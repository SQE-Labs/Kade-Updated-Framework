package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.BillPage;
import pageEvents.MyStorePage;
import pageEvents.PaymentPage;
import pageObjects.PageObjectManager;
import utils.Constants;

import static java.lang.Float.*;
import static utils.Constants.*;

public class MyStoreTest extends BaseTest {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(MyStorePage.class);

    PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    MyStorePage mystore = pageObjectManager.getMyStorePage();
    BillPage bill = new BillPage();
    PaymentPage payment = new PaymentPage();

    @Test(priority = 0, enabled = true, description = "SC_01(A) Verifying creation of Store without Stripe Payment Account Configuration")
    public void storeCreationWithoutStripeAccount() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        mystore.getStoreCreationWithoutStripePayment();
    }


    @Test(priority = 1, enabled = true, description = "SC_01(B) Verifying deletion of Store when Stripe Account is not Registered Yet")
    public void sc01b_DeletionOfStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Register New Business' Button
        mystore.getRegisterNewBusinessButton();
        staticWait(2000);
        if (!isElementDisplayed(mystore.storeLogo)) {
            mystore.getSkipStripeAccountButton();
            waitForElementToBeVisible(mystore.skipPopUpTitle, 4);

            String actual = getText(mystore.skipPopUpTitle);
            //Verifying the 'Skip' Pop Up Title
            Assert.assertEquals(actual, Constants.skip);
            //  Click on 'Skip' button
            mystore.getSkipBtnOfStripe();
        }
        scrollToElement(mystore.deleteStoreBtn);
        waitForElementToBeVisible(mystore.deleteStoreBtn, 7);
        // click on delete button
        mystore.getDeleteStoreButton();
        mystore.getDeleteStoreIcon();
    }


    @Test(priority = 2, enabled = true, description = "SC_02  Verify creation of Store with Stripe Payment Account")
    public void creationOfStoreWithStripeAccount() {

        Login();
        mystore.getStoreCreation();
        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(mystore.storeNamewithstripe);
    }

    @Test(priority = 3, enabled = true, description = "SC_03 Verifying modification of existing created Store")
    public void verifyingModificationOfExistingCreatedStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        waitForElementToBeVisible(mystore.configureLink, 5);

        // Click on 'Configure' Link
        mystore.getConfigureLink();

        //step 3: Click on 'Modify' Button
        mystore.getModifyButton();
        mystore.editStoreFields();
    }


    @Test(priority = 4, enabled = true, description = "SC_04(A) Verifying buying Monthly Business Plan for already created Store")
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
        System.out.println(defaultPaymentMthd);
        softAssert.assertEquals(defaultPaymentMthd, Constants.visavalue);

//       Click on 'Change Pay Method' Link
        mystore.getChangePayMethodLink();//Verifying that other payment methods are available
        softAssert.assertTrue(isElementDisplayed(mystore.newCreditCardBtn), " New credit card button");
        softAssert.assertTrue(isElementDisplayed(mystore.newBankAccountBtn), "new bank account");

        // Click on 'Terms' Checkbox
        mystore.getTermsCheckbox();
        scrollToElement(mystore.changePlanBtn);

        //  Click on 'Change Plan' Button
        mystore.getChangePlanButton();

        //Verifying that next bill date is generated
        Assert.assertTrue(isElementDisplayed(mystore.nextBillDate), "next bill date");
        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(mystore.storeNamewithstripe);
        softAssert.assertAll();

    }

    @Test(priority = 5, enabled = true, description = "SC04(b): Verify Store creation with Yearly Business Plan on 'Store Configuration' Page ")
    public void verifyStoreCreationWithYearlyBusinessPlan() {
        Login();
        mystore.getStoreCreation();
        mystore.getSubscriptionPlanTab();

        //Verifying that 'Current Plan' appears under Essential Free Plan
        String message = getText(mystore.currentPlanMSg);
        Assert.assertEquals(message, Constants.currentPlan);

        // select on Business Yearly plan
        mystore.getBusinessYearlyPlan();

        //Click on 'Sign up' button
        mystore.getPlansSignUpButton();

        //Verifying that by-default Visa Payment method is enabled
        String defaultPaymentMthd = getText(mystore.addedVisaMethod);
        softAssert.assertEquals(defaultPaymentMthd, Constants.visavalue);

//       Click on 'Change Pay Method' Link
        mystore.getChangePayMethodLink();//Verifying that other payment methods are available
        softAssert.assertTrue(isElementDisplayed(mystore.newCreditCardBtn), " New credit card button");
        softAssert.assertTrue(isElementDisplayed(mystore.newBankAccountBtn), "new bank account");
        mystore.getbankAccountOptionForPlan();

        // Click on 'Terms' Checkbox
        mystore.getTermsCheckbox();
        scrollToElement(mystore.changePlanBtn);

        //  Click on 'Change Plan' Button
        mystore.getChangePlanButton();

        //Verifying that next bill date is generated
        softAssert.assertTrue(isElementDisplayed(mystore.nextBillDate), "next bill date");

        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(mystore.storeNamewithstripe);
        softAssert.assertAll();

    }

    // Bug Failed due to 3092, 2827

    @Test(priority = 6, enabled = true, description = "SC_05(A) Verifying the Configuration of already created Store using Settings Sub-Tabs")
    public void verifyingConfigurationsOfStoreUsingSettings() {
        String tipAmountPercent1 = requiredDigits(2);
        String tipAmountPercent2 = requiredDigits(2);
        String tipAmountPercent3 = requiredDigits(2);
        String rewardPoints = requiredDigits(4);

        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        waitForElementToBeInteractable(mystore.configureLink, 4);

        // Click on 'Configure' Link
        mystore.getConfigureLink();

        // Click on 'Settings' Sub-Tab
        mystore.getSettingSubTab();

        //Verifying Minimum, Maximum and Default values of 'Maximum Bill Amount' Field
        String maxBillAmount = requiredDigits(parseFloat(Constants.minimumBillAmount), parseFloat(Constants.maximumBillAmount));
        softAssert.assertEquals(getAttribute(mystore.maxBillAmountTbx, "max"), Constants.maximumBillAmount);
        softAssert.assertEquals(getAttribute(mystore.maxBillAmountTbx, "min"), Constants.minimumBillAmount);

        //  Enter amount in 'Maximum Bill Amount' field
        actionEnterText(mystore.maxBillAmountTbx, maxBillAmount);
        staticWait(3000);

        if (!isElementDisplayed(mystore.tipGratuityToggleOffBtn)) {

            // Click on 'Tip & Gratuity' Toggle Button
            mystore.getTipGratuityToggleOnButton();
        }
        // Click on 'Configure' button
        mystore.getTipConfigureBtn();

        //Verifying the 'Tip Configuration' Pop-up Title
        softAssert.assertEquals(mystore.tipConfigPopUpTitle, Constants.tipConfigurationTitle);

        staticWait(5000);
        mystore.getEnterInPerCentToggleButton();

        cleanByJS(mystore.tipPercentField1);
        cleanByJS(mystore.tipPercentField2);
        cleanByJS(mystore.tipPercentField3);

        // Click on 'Save Changes' button
        mystore.getSaveChangesButton();

        mystore.getValidationCrossIcon();

        staticWait(3000);

        String tooltip1 = getToolTipMessage(mystore.tipPercentField1);
        Assert.assertEquals(tooltip1, requiredFldValidation);

        String tooltip2 = getToolTipMessage(mystore.tipPercentField2);
        Assert.assertEquals(tooltip2, requiredFldValidation);

        String tooltip3 = getToolTipMessage(mystore.tipPercentField3);
        Assert.assertEquals(tooltip3, requiredFldValidation);

        staticWait(4000);

        // Click on 'Enter in Percentage' Toggle button
        mystore.getEnterInPerCentToggleButton();

        staticWait(3000);

        if (!isElementDisplayed(mystore.alertMessage)) {

            // Click on 'Enter in Percentage' Toggle button
            mystore.getEnterInPerCentToggleButton();
        }

        //Verifying the Default and maximum values of 'Tip Amount' fieltipPercentField1d
        softAssert.assertEquals(getAttribute(mystore.tipPercentField1, "max"), tipAmountPercent1);

        //  Enter Tip Values
        actionEnterText(mystore.tipPercentField1, tipAmountPercent1);
        actionEnterText(mystore.tipPercentField2, tipAmountPercent2);
        actionEnterText(mystore.tipPercentField3, tipAmountPercent3);

        // Click on 'Save Changes' button
        mystore.getSaveChangesButton();

        // Click on 'Configure' button
        mystore.getRewardConfigureButton();

        //Verifying the 'Rewards Configuration' Pop-Up Title
        String rewardConfig = getText(mystore.rewardConfigPopUpTitle);
        softAssert.assertEquals(rewardConfig, Constants.rewardConfigurationpopup);

        // Click on 'Reward Point' Toggle button
        if (!isElementDisplayed(mystore.rewardPointsField)) {
            mystore.getRewardPointToggleOnButton();
        }

        //Verifying the Minimum and Maximum Values of 'Reward Points' Field
        Assert.assertEquals(getAttribute(mystore.rewardPointsField, "max"), "99999");
        Assert.assertEquals(getAttribute(mystore.rewardPointsField, "min"), "100");

        // Enter Reward Points
        actionEnterText(mystore.rewardPointsField, rewardPoints);

        // Click on 'Save Changes' Button
        mystore.getSaveChangesButton();

        scrollToElement(mystore.storeLinksBtn);

        waitForElementToBeVisible(mystore.storeLinksBtn, 3);

        // Click on 'Store Links' button
        mystore.getStoreLinksButton();
        waitForElementToBeClickable(mystore.rewardPtsValue, 3);

        // Enter Reward Points
        actionEnterText(mystore.rewardPtsValue, rewardPoints);

        // Enter Website URL
        cleanByJS(mystore.websiteURLField);
        actionEnterText(mystore.websiteURLField, "www.KadePay" + requiredString(4) + ".com");

        // Click on 'Earn Rewards Points' Toggle Button
        System.out.println("testse2: " + isToggleEnabled(mystore.earnRewardsToggleBtn));
        if (!isToggleEnabled(mystore.earnRewardsToggleBtn)) {
            mystore.getEarnRewardsPointsToggleButton();
        } else {
            scrollToElement(mystore.saveChangesBtn);
            waitForElementToBeClickable(mystore.saveChangesBtn, 3);

            // Click on 'Save Changes' Button
            mystore.getSaveChangesButton();
            softAssert.assertAll();
        }
    }

    // Bug Raised and Bug Id is : 3020
    @Test(priority = 7, enabled = true, description = "SC_05(B) Verifying the Configuration of the Store using flat value in 'tip or gratuity' field")
    public void verifyingConfigurationsOfStoreUsingFlatValueInTipField() {

        String value1 = requiredDigits(Float.parseFloat("0.01"), Float.parseFloat("999.00"));
        String value2 = requiredDigits(Float.parseFloat("0.01"), Float.parseFloat("999.00"));
        String value3 = requiredDigits(Float.parseFloat("0.01"), Float.parseFloat("999.00"));


        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        // Click on 'Configure' Link
        mystore.getConfigureLink();

        // Click on 'Settings' Sub-Tab
        mystore.getSettingSubTab();

        if (!isElementDisplayed(mystore.tipGratuityToggleOffBtn)) {

            // Click on 'Tip & Gratuity' Toggle Button
            mystore.getTipGratuityToggleOnButton();
        }

        // Click on 'Configure' button
        mystore.getTipConfigureBtn();

        //Verifying the 'Tip Configuration' Pop-up Title
        String tipConfig = getText(mystore.tipConfigPopUpTitle);
        Assert.assertEquals(tipConfig, Constants.tipConfigurationTitle);


        staticWait(3000);

        cleanByJS(mystore.tipFlatValueField1);
        cleanByJS(mystore.tipFlatValueField2);
        cleanByJS(mystore.tipFlatValueField3);
        staticWait(3000);

        // Click on 'Save Changes' Button
        mystore.getSaveChangesButton();
        mystore.getValidationCrossIcon();

        // Verify that this field is required tooltip appears
        String tooltip1 = getToolTipMessage(mystore.tipFlatValueField1);
        softAssert.assertEquals(tooltip1, requiredFldValidation, "This field is required tooltip not appear");
        staticWait(2000);
        String tooltip2 = getToolTipMessage(mystore.tipFlatValueField2);
        softAssert.assertEquals(tooltip2, requiredFldValidation, "This field is required tooltip not appear");

        String tooltip3 = getToolTipMessage(mystore.tipFlatValueField3);
        softAssert.assertEquals(tooltip3, requiredFldValidation, "This field is required tooltip not appear");

        staticWait(3000);


        if (getCountOfWebElements(mystore.alertMessage) > 0) {
            // Click on 'Enter in Percentage' Toggle button
            mystore.getEnterInPerCentToggleButton();
        }

        // Verifying the maximum and minimum values of 'Tip Amount' field
        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField1, "max"), "999.00");
        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField1, "min"), "0.01");
        // field 2

        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField2, "max"), "999.00");
        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField2, "min"), "0.01");

        // field 3
        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField3, "max"), "999.00");
        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField3, "min"), "0.01");

        waitForElementToBeInteractable(mystore.tipFlatValueField1, 3);

        actionEnterText(mystore.tipFlatValueField1, value1);
        actionEnterText(mystore.tipFlatValueField2, value2);
        actionEnterText(mystore.tipFlatValueField3, value3);

        // Click on 'Save Changes' Button
        mystore.getSaveChangesButton();
        softAssert.assertAll();
    }

    @Test(priority = 13, enabled = true, description = "SC_06 Verifying the Configuration of the Store using Payment Processing Sub-Tab with terminal configuration,")
    public void verifyingConfigurationOfStoreUsingPaymentProcessingSubTab() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Configure' Link
        mystore.getConfigureLink();

        waitForElementToBeVisible(mystore.paymentProcessingSubTab, 5);

        // Click on 'Payment-Processing' Sub-Tab
        mystore.getPaymentProcessingSubTab();

        //  Click on 'Credit Card Terminal' button

        if (isElementDisplayed(mystore.configureATerminalTitle)) {
            mystore.getAddaTerminalLink();
        } else {
            mystore.getCreditCardTerminalButton();
            // Click on 'Add new Terminal' button
            mystore.getAddNewTerminalButton();
        }

        //Verifying the 'New Terminal' Pop-Up Title
        Assert.assertEquals(getText(mystore.newTerminalPopUpTitle), Constants.newTerminalTitle);

        // Select an option and save
        mystore.getCreditTerminalOption();
    }


    @Test(priority = 8, enabled = true, description = "SC_06 Verifying the Configuration of the Store using Payment Processing Sub-Tabs on 'Store Configuration' Page with Venmo & Zelle. ")
    public void verifyConfigurationOfStoreUsingPaymentProcessingSubTab() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        waitForElementToBeClickable(mystore.configureLink, 3);

        // Click on 'Configure' Link
        mystore.getConfigureLink();

        waitForElementToBeVisible(mystore.paymentProcessingSubTab, 5);

        // Click on 'Payment-Processing' Sub-Tab
        mystore.getPaymentProcessingSubTab();
        staticWait(3000);
        scrollToDown();
        staticWait(3000);

        mystore.getAcceptVenmoToggleButton();

        staticWait(5000);

        //Verifying Maximum length of 'VenmoID' field
        Assert.assertEquals(getAttribute(mystore.venmoIDField, "maxlength"), "40");

        // Enter ID in 'Venmo ID" field
        enterText(mystore.venmoIDField, requiredDigits(4));

        //Verifying maximum length of 'Venmo Name' field
        Assert.assertEquals(getAttribute(mystore.venmoNameField, "maxlength"), "40");

        // Enter name in 'Venmo Name' Field
        enterText(mystore.venmoNameField, requiredString(8));

        // Click on 'Save' Button
        mystore.getVenmoSaveButton();
        scrollToElement(mystore.acceptZelleHeader);
        staticWait(3000);

        if (!isToggleEnabled(mystore.acceptZelleToggleBtn)) {
            clickElementByJS(mystore.acceptZelleToggleBtn);
        } else {
            hoverAndClick(mystore.acceptZelleToggleBtn, mystore.acceptZelleToggleBtn);
        }

        //Verifying maximum length of 'Zelle Phone' field
        Assert.assertEquals(getAttribute(mystore.zellePhoneField, "maxlength"), "40");

        //  Enter Phone Number in 'Zelle Phone' Field
        enterText(mystore.zellePhoneField, requiredDigits(4));

        // Verifying maximum length of 'Zelle Name' field
        Assert.assertEquals(getAttribute(mystore.zelleNameField, "maxlength"), "40");

        // Enter Zelle Account Name
        enterText(mystore.zelleNameField, requiredString(8));

        // Click on 'Save' Button
        mystore.getZelleSaveButton();
    }


    @Test(priority = 9, enabled = true, description = "SC_08 Verify deactivating an activated Store")
    public void verifyDeactivatingAnActivatedStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Configure' Link
        mystore.getConfigureLink();
        scrollToElement(mystore.activeSubTab);

        waitForElementToBeInteractable(mystore.activeSubTab, 6);

        //  Click on 'Active' Sub-tab
        mystore.getActivateSubtab();

        // Click on Deactivate button
        mystore.getDeactivateBtn();

        //Verifying that store gets Deactivated and success message appears
        String nonActive = getText(mystore.notActiveStoreLabel);
        Assert.assertEquals(nonActive, Constants.deacticeStatus);
        //  softAssert.assertEquals(getText(mystore.notActiveStoreLabel), Constants.deacticeStatus);

        // click on Activate button
        mystore.getActiveButton();

        // Verify the store gets ACTIVE AND INFORMATION MESSAGE APPEARS
        String activeStore = getText(mystore.activeStoreLabel);
        Assert.assertEquals(activeStore, Constants.activeStoreStatus);

        //   softAssert.assertEquals(getText(mystore.activeStoreLabel), Constants.activeStoreStatus);
        softAssert.assertAll();
    }

    // Failed due to Bug 3092, 2827
    @Test(priority = 10, enabled = true, description = "SC 09 and Sc 10 Verify that store creation and purchasing the 'Premium' monthly plan subscription for the store, on 'Store Configuration' page.")
    public void verifyingStoreCreationWithPurchasingMonthlyPremiumPlan() {
        Login();
        mystore.getStoreCreation();
        mystore.getSubscriptionPlanTab();
        //Verifying that 'Current Plan' appears under Essential Free Plan
        String message = getText(mystore.currentPlanMSg);
        softAssert.assertEquals(message, Constants.currentPlan);

        // Verifying the Premium title
        softAssert.assertTrue(isElementDisplayed(mystore.premiumTitle), "Premium Title");
        scrollToElement(mystore.premiumMonthlyBtn);
        // byuing the Premium plan
        mystore.getPremiumMonthlyBtn();
        mystore.getPremiumnMonthlySignUpBtn();

        //Verifying that by-default Visa Payment method is enabled
        String defaultPaymentMthd = getText(mystore.addedVisaMethod);
        softAssert.assertEquals(defaultPaymentMthd, Constants.visavalue);

        // Click on 'Change Pay Method' Link
        mystore.getChangePayMethodLink();

        //Verifying that other payment methods are available
        softAssert.assertTrue(isElementDisplayed(mystore.newCreditCardBtn), " New credit card button");
        softAssert.assertTrue(isElementDisplayed(mystore.newBankAccountBtn), "new bank account");

        mystore.getbankAccountOptionForPlan();

        // Click on 'Terms' Checkbox
        mystore.getTermsCheckbox();
        scrollToElement(mystore.changePlanBtn);
        waitForElementToBeClickable(mystore.changePlanBtn, 3);

        //  Click on 'Change Plan' Button
        mystore.getChangePlanButton();

        //Verifying that next bill date is generated
        Assert.assertTrue(isElementDisplayed(mystore.nextBillDate), "next bill date");

        scrollToElement(mystore.premiumYearlyBtn);

        // selecting premium yearly plan
        mystore.getPremiumYearlyBtn();
        mystore.getPremiunmYearlySignUpbtn();

        // Click on 'Change Pay Method' Link
        mystore.getChangePayMethodLink();

        // Click on 'Terms' Checkbox
        mystore.getTermsCheckbox();
        scrollToElement(mystore.changePlanBtn);
        waitForElementToBeClickable(mystore.changePlanBtn, 3);

        //  Click on 'Change Plan' Button
        mystore.getChangePlanButton();
        //Verifying that next bill date is generated
        Assert.assertTrue(isElementDisplayed(mystore.nextBillDate), "next bill date"); // Bug Failed due to 3092, 2827


        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(mystore.storeNamewithstripe);
        softAssert.assertAll();

    }

    @Test(priority = 11, enabled = true, description = "SC_07(A) Verifying the Configuration of the Store using 'Manage Users' Sub-Tab")
    public void sc07a_VerifyingConfigurationOfStoreUsingManageUsersSubTabs() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        waitForElementToBeClickable(mystore.configureLink, 3);

        // Click on 'Configure' Link
        mystore.getConfigureLink();
        waitForElementToBeClickable(mystore.manageUserSubTab, 5);

        // click on Manage Sub Tab
        mystore.getManageUserSubTab();
        waitForElementToBeInteractable(mystore.createUserAndCredetButton, 5);

        // Creating  Manager user
        mystore.createManagerUser();

        // Creating Reader user
        mystore.creatingReaderProfile();

        // Creating Operator user
        mystore.creatingOperatorUser();

    }

    // Bug id =
    @Test(priority = 12, enabled = true, description = "SC_07(B) Verifying the Configuration of the store using Manage User sub tab to invite any existing user to manage store.")
    public void sc_07b_VerifyingConfigurationOfStoreUsingManageUserSubTabToInviteAnyExistingUserToManageStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        staticWait(3000);
        // Click on 'Configure' Link
        mystore.getConfigureLink();
        staticWait(5000);
        // click on Manage Sub Tab
        mystore.getManageUserSubTab();
        staticWait(5000);

        mystore.getinviteUserButton();
        staticWait(4000);
        // Verifying the 'Invite Existing User' PopUp Title
        Assert.assertEquals(getText(mystore.inviteExistingUserPopupTitle), "Invite users");

        // Enter Email Or Phone Number
        enterText(mystore.inviteMangeUserEmailOrPhoneField, "saybo@yopmail.com");

        //  Click on the 'User Profile' Drop Down
        mystore.getUserProfileDropdown();

        // Select profile of 'Manager' User
        mystore.getmanagerProfileOption();

        // Click on 'Send Invite' Button.
        mystore.sendInviteButton();

        pageObjectManager.getSidePannel().getSignOut();

        LoginAsCustomer();
        payment.clickOnBillIcon();

        // Need to add assertion
    }
}












