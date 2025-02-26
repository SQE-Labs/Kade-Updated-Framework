package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.MyStorePage;
import pageObjects.PageObjectManager;
import utils.Constants;

public class MyStoreTest extends BaseTest {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(MyStorePage.class);

     PageObjectManager pageObjectManager = PageObjectManager.getInstance();
     MyStorePage mystore = pageObjectManager.getMyStorePage();


    @Test(enabled = true, description = "SC_01(B) Verifying deletion of Store when Stripe Account is not Registered Yet")
    public void sc01b_DeletionOfStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Register New Business' Button
        mystore.getRegisterNewBusinessButton();
        staticWait(2000);
        if(!isElementDisplayed(mystore.storeLogo)) {
            mystore.getSkipStripeAccountButton();

            String actual = getText(mystore.skipPopUpTitle);
            //Verifying the 'Skip' Pop Up Title
            Assert.assertEquals(actual, Constants.skip);
            //  Click on 'Skip' button
            mystore.getSkipBtnOfStripe();
        }
        scrollToElement(mystore.deleteStoreBtn);
        // click on delete button
        mystore.getDeleteStoreButton();
        mystore.getDeleteStoreIcon();
    }

    @Test(enabled = true, description = "SC_02 Verify creation of Store with Stripe Payment Account")
    public void a2sc02_CreationOfStoreWithStripeAccount() {
        Login();
        String storeName = "AutoStore" + requiredString(4);
        String phone = requiredDigits(10);

        //Step 1: Click on 'My Stores' Tab
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Register New Business' Button
        mystore.getRegisterNewBusinessButton();
        if (isElementDisplayed(mystore.storeLogo)) {
            mystore.getSkipStripeAccountButton();
            mystore.getSkipBtnOfStripe();
            scrollToElement(mystore.deleteStoreBtn);
            // click on delete button
            mystore.getDeleteStoreButton();
            mystore.getDeleteStoreIcon();
            pageObjectManager.getSidePannel().getMangeBusinessTab();
            pageObjectManager.getSidePannel().getMyStoreTab();
        }
        // Click on 'Stripe Account' Button
        mystore.getStripeAccountBtn();

        //Verifying the 'Connect To Stripe' PopUp Title
        String stripeTitle = getText(mystore.connectStripePopUpTitle);
        softAssert.assertEquals(stripeTitle, Constants.ConnectToStripe);

        //Click on 'Test Stripe Account' Button
        mystore.getTestStripeAccountButton();

        //Edit Store name
        mystore.getEditStoreButton();
        waitForElementToBeClickable(mystore.addedStoreName,3);
        enterText(mystore.addedStoreName, storeName);
        enterText(mystore.phoneTbx, phone);
        mystore.getSaveButton();

        // Click on 'Bank Transfer' toggle button
        mystore.getBankTransferToggleButton();
        mystore.getContinueButton();

        // Click on 'Skip For Now' Button
        mystore.getSkipForNowButton();
        mystore.getContinueButton();

        //verifying the default Values of the Store
        String storenameactual = getText(mystore.addedStoreName);
        String locationDescription = getText(mystore.locationDescTbx);
        String storeAddress = getText(mystore.storeAddressField);
        String storePhoneno = getText(mystore.phoneTbx).replaceAll("[+()\\s-]", "").substring(1, 11), phoneNumber;
        String Currency = getText(mystore.addedCurrencyOfStore);
        String Taxrate = getText(mystore.taxRateTbx);

        softAssert.assertEquals(storenameactual, storeName);
        softAssert.assertEquals(locationDescription, Constants.defaultLocationDescription);
        softAssert.assertEquals(storeAddress, Constants.storeAddress);
        softAssert.assertEquals(storePhoneno, phone);
        softAssert.assertEquals(Currency, Constants.defaultCurrency);
        softAssert.assertEquals(Taxrate, Constants.defaultTaxRate);

        pageObjectManager.getSidePannel().getSignOut();
        pageObjectManager.getAdminPage().selectedStoreDeleted(storeName);
    }
}





