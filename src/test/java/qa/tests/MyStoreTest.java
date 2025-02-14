package qa.tests;

import base.BaseTest;
import net.minidev.json.JSONUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;
import pageEvents.MyStorePage;
import pageObjects.PageObjectManager;
import utils.Constants;

public class MyStoreTest extends BaseTest {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(MyStorePage.class);

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private MyStorePage mystore = pageObjectManager.getMyStorePage();


    @Test(description = "SC_01(A) Verifying creation of Store without Stripe Payment Account Configuration")
    public void Tc1storeCreationWithoutStripeAccount(){
        String storeName = "AutoStore" + requiredDigits(4);
        String phone = requiredDigits(10);

        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();


        }


    @Test( description = "SC_01(B) Verifying deletion of Store when Stripe Account is not Registered Yet")
    public void deletionOfStoreDuringCreation() {
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

    @Test( description = "SC_02 Verify creation of Store with Stripe Payment Account")
    public void c1creationOfStoreWithStripeAccount() {
        Login();
        mystore.getStoreCreation();

     pageObjectManager.getSidePannel().getSignOut();
//     pageObjectManager.getAdminPage().selectedStoreDeleted(mystore.storeName);
    }


    @Test( description = "SC_04(A) Verifying buying Monthly Business Plan for already created Store")
    public void c2verifyingBuyingMonthlyBusinessPlanForAlreadyCreatedStore() {
        Login();
        mystore.getStoreCreation();
        mystore.getSubscriptionPlanTab();
        //Verifying that 'Current Plan' appears under Essential Free Plan
        String message = getText(mystore.currentPlanMSg);
        softAssert.assertEquals(message, Constants.currentPlan);

        //Click on 'Sign up' button
        mystore.getPlansSignUpButton();

        //Verifying that by-default Visa Payment method is enabled
        String defaultPaymentMthd = getText(mystore.addedVisaMethod);
        softAssert.assertEquals(defaultPaymentMthd, Constants.visavalue);

//       Click on 'Change Pay Method' Link
        mystore.getChangePayMethodLink();//Verifying that other payment methods are available
        softAssert.assertTrue(isElementDisplayed(mystore.newCreditCardBtn), " New credit card button");
        softAssert.assertTrue(isElementDisplayed(mystore.newBankAccountBtn), "new bank account");

        // Click on 'Terms' Checkbox
        mystore.getTermsCheckbox();

        //  Click on 'Change Plan' Button
        mystore.getChangePlanButton();

        //Verifying that next bill date is generated
        softAssert.assertTrue(isElementDisplayed(mystore.nextBillDate), "next bill date");
    }


}





