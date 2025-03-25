package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;
import pageObjects.PageObjectManager;
import pageEvents.CustomersPage;
import utils.Constants;


public class CustomersTest extends BaseTest {

    public static Logger log = LogManager.getLogger(BasicInformationPage.class);

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    private CustomersPage customersPage = pageObjectManager.getCustomersPage();

    @Test
    public void verifystoreCustomersPage() {
        log.info("Verify that Store's customers page opens up displaying all the options");

        Login();
        customersPage.navigateToCustomersPage();

        Assert.assertTrue(isElementDisplayed(customersPage.nameAddress));
        Assert.assertTrue(isElementDisplayed(customersPage.findAddCustomer));
        Assert.assertTrue(isElementDisplayed(customersPage.filter));
    }

    @DataProvider(name = "phoneNumberData")
    public Object[][] phoneNumberData() {
        return new Object[][]{
                {"9011017524", null}, // Valid phone number
                {"901101752", "Invalid phone number"}, // Invalid phone number
                {"", "This field is required."}, // Blank phone number
                {"12345678901234567890123", "Please enter no more than 22 characters."} // More than 22 characters
        };
    }

    @Test(dataProvider = "phoneNumberData")
    public void verifyAddCustomerWithPhoneNumber(String phoneNumber, String expectedValidationMessage) {
        log.info("Adding a new customer with Phone number");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.findAddCustomer);
        waitForElementToBeInteractable(customersPage.phoneNumber,20);
        actionEnterText(customersPage.phoneNumber,phoneNumber);
        click(customersPage.goBtn);
        if (expectedValidationMessage != null) {
            Assert.assertTrue(isElementDisplayed(customersPage.phoneValidation));
            String actualValidationMessage = getToolTipMessage(customersPage.phoneNumber);
            Assert.assertEquals(actualValidationMessage,expectedValidationMessage);
        } else {
            Assert.assertTrue(isElementDisplayed(customersPage.findAddCustomer));
        }
        click(customersPage.customerPopupClose);
        waitForElementInVisible(customersPage.customerPopupClose,20);
    }

    @Test
    public void verifyAddCustomerWithEmail() {
        log.info("Adding a new customer with Email");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.findAddCustomer);
        waitForElementToBeInteractable(customersPage.phoneNumber,20);
        actionEnterText(customersPage.emailField, Constants.custEmailInput);
        click(customersPage.emailGoBtn);
        waitForElementInVisible(customersPage.emailGoBtn,20);

        click(customersPage.findAddCustomer);
        waitForElementToBeInteractable(customersPage.phoneNumber,20);
        actionEnterText(customersPage.emailField, Constants.emailInput);
        click(customersPage.emailGoBtn);
        Assert.assertTrue(isElementDisplayed(customersPage.emailValidation));
        Assert.assertEquals(getToolTipMessage(customersPage.emailField),Constants.emailTooltip);
        click(customersPage.customerPopupClose);
        waitForElementInVisible(customersPage.customerPopupClose,20);

        click(customersPage.findAddCustomer);
        waitForElementToBeInteractable(customersPage.phoneNumber,20);
        actionEnterText(customersPage.emailField, " ");
        click(customersPage.emailGoBtn);
        Assert.assertTrue(isElementDisplayed(customersPage.emailValidation));
        Assert.assertEquals(getToolTipMessage(customersPage.emailField),Constants.emptyFieldTooltip);
        click(customersPage.customerPopupClose);
    }

    @Test
    public void verifyCreateBillAndSearch() {
        log.info("Creating a bill and searching for the customer on Customers page");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.findAddCustomer);
        Assert.assertTrue(isElementDisplayed(customersPage.customerDisplayed));
        waitForElementToBeInteractable(customersPage.searchField,20);
        actionEnterText(customersPage.searchField,Constants.searchInput);
        click(customersPage.searchBtn);
        Assert.assertTrue(isElementDisplayed(customersPage.customerDisplayed));
    }

    @Test
    public void verifyFilterWithPhoneNumber() {
        log.info("Filtering out using Phone number");

        Login();
        customersPage.navigateToCustomersPage();

        customersPage.applyFilter(Constants.phnNumberInput);
        waitForElementInVisible(customersPage.filterApplyBtn,20);

        customersPage.applyFilter(Constants.phnNumberInput2);
        Assert.assertTrue(isElementDisplayed(customersPage.noResult));

        customersPage.applyFilter(Constants.phnNumberInput3);
        Assert.assertTrue(isElementDisplayed(customersPage.alertValidation));
        Assert.assertEquals(getToolTipMessage(customersPage.filterPhonenumberInvalid),Constants.maxPhnFieldCharValidation);

        actionEnterText(customersPage.filterPhonenumberInvalid," ");
        click(customersPage.filterApplyBtn);
        waitForElementInVisible(customersPage.filterApplyBtn,20);

        customersPage.applyFilter(Constants.phnNumberInput4);
        Assert.assertTrue(isElementDisplayed(customersPage.alertValidation));
        Assert.assertEquals(getToolTipMessage(customersPage.filterPhonenumberInvalid),Constants.invalidPhnValidation);
    }

    @Test
    public void verifyFilterWithEmail() {
        log.info("Filtering out using Email");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.filter);
        enterText(customersPage.filterEmail,Constants.custEmailInput);
        staticWait(2000);
        click(customersPage.filterApplyBtn);
        waitForElementInVisible(customersPage.filterApplyBtn,20);
        staticWait(2000);

        customersPage.tryCatchFilter();
        enterText(customersPage.filterEmail,Constants.PartialUsername);
        click(customersPage.filterApplyBtn);
        Assert.assertTrue(isElementDisplayed(customersPage.alertValidation));
        Assert.assertEquals(getToolTipMessage(customersPage.invalidFilterEmail),Constants.validEmailValidationMsg);
    }

    @Test
    public void verifyFilterWithName() {
        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.filter);
        enterText(customersPage.filterName,Constants.PartialUsername);
        click(customersPage.filterApplyBtn);
        waitForElementInVisible(customersPage.filterApplyBtn,20);

        customersPage.tryCatchFilter();
        enterText(customersPage.filterName,Constants.nameInput);
        click(customersPage.filterApplyBtn);
        Assert.assertTrue(isElementDisplayed(customersPage.noResult));
    }

    @Test
    public void verifySelectCustomerViaFilter() {
        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.filter);
        waitForElementToBeVisible(customersPage.selectCustomerinFilter,10);
        click(customersPage.selectCustomerinFilter);
        click(customersPage.customerSelection);
        staticWait(2000);
        Assert.assertTrue(isElementDisplayed(customersPage.customerDisplayed2));
    }

    @Test
    public void verifyChangeCustomerName() {
        log.info("Changing the name of the Customer");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.pencilIcon);
        enterText(customersPage.chngeName,Constants.chngeNameInput);
        click(customersPage.saveBtn);
    }

    @Test
    public void verifyOpenCustomersProfilePage() {
        log.info("Open customer's profile page");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.eyeIcon);
        Assert.assertTrue(isElementDisplayed(customersPage.profileHeading));
        Assert.assertTrue(isElementDisplayed(customersPage.messageIcon));
        Assert.assertTrue(isElementDisplayed(customersPage.trophieIcon));
        Assert.assertTrue(isElementDisplayed(customersPage.storeName));
    }

    @Test
    public void verifyOpenMessagePg() {
        log.info("Type and Unsend message to the customer");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.eyeIcon);
        click(customersPage.messageIcon);
        Assert.assertTrue(isElementDisplayed(customersPage.messagePg));
    }

    @Test
    public void verifyAddRewardPoints() {
        log.info("Add reward points to the customer");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.eyeIcon);
        click(customersPage.trophieIcon);
        click(customersPage.addRewardpts);
        actionEnterText(customersPage.memoinput,Constants.Memo);
        actionEnterText(customersPage.rewardPoints,Constants.Points);
        click(customersPage.submitRewardPts);
    }

    @Test(enabled = false)
    public void verifyAddPaymentMethod() {
        log.info("Add payment method");

        Login();
        customersPage.navigateToCustomersPage();

        click(customersPage.addPaymentMethod);
        click(customersPage.permissionChkbx);
        click(customersPage.permissionCtnBtn);
        waitForElementToBeVisible(customersPage.addCardNumberField,10);
        switchToFrame(customersPage.frame1);
        customersPage.saveNewByCreditCard();
    }

    @Test
    public void verifyCreateGiftCard() {
        log.info("Create Gift Card");

        Login();
        customersPage.navigateToCustomersPage();
        click(customersPage.eyeIcon);
        click(customersPage.addGiftCardBtn);
        waitForElementToBeInteractable(customersPage.initialAmt,10);
        actionEnterText(customersPage.initialAmt, Constants.initialAmt);
        click(customersPage.createGiftCardBtn);
    }





}
