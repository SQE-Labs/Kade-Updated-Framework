package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.MyStorePage;
import pageObjects.PageObjectManager;
import utils.Constants;

import java.io.File;

import static base.BaseTest.Login;
import static java.lang.Float.*;
import static utils.Constants.CustomerTitle;
import static utils.Constants.storeName;

public class MyStoreTest extends BaseTest {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(MyStorePage.class);

    PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    MyStorePage mystore = pageObjectManager.getMyStorePage();

    @Test(description = "SC_01(A) Verifying creation of Store without Stripe Payment Account Configuration")
    public void storeCreationWithoutStripeAccount() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        mystore.getStoreCreationWithoutStripePayment();
    }


    @Test(description = "SC_01(B) Verifying deletion of Store when Stripe Account is not Registered Yet")
    public void sc01b_DeletionOfStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Register New Business' Button
        mystore.getRegisterNewBusinessButton();
        staticWait(2000);
        if (!isElementDisplayed(mystore.storeLogo)) {
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


    @Test(description = "SC_02  Verify creation of Store with Stripe Payment Account")
    public void c1creationOfStoreWithStripeAccount() {

        Login();
        mystore.getStoreCreation();
        pageObjectManager.getSidePannel().getSignOut();
        pageObjectManager.getAdminPage().selectedStoreDeleted(storeName);
    }

    @Test(description = "SC_03 Verifying modification of existing created Store")
    public void c2verifyingModificationOfExistingCreatedStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        // Click on 'Configure' Link
        mystore.getConfigureLink();

        //step 3: Click on 'Modify' Button
        mystore.getModifyButton();
        mystore.editStoreFields();
    }


    @Test(description = "SC_04(A) Verifying buying Monthly Business Plan for already created Store")
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
        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(mystore.storeNamewithstripe);

    }

    @Test(description = "SC_05(A) Verifying the Configuration of already created Store using Settings Sub-Tabs")
    public void verifyingConfigurationsOfStoreUsingSettings() {
        String tipAmountPercent1 = requiredDigits(2);
        String tipAmountPercent2 = requiredDigits(2);
        String tipAmountPercent3 = requiredDigits(2);
        String rewardPoints = requiredDigits(4);


        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
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
        softAssert.assertEquals(getText(mystore.rewardConfigPopUpTitle), Constants.rewardConfigurationpopup);

        // Click on 'Reward Point' Toggle button
        if (!isElementDisplayed(mystore.rewardPointsField)) {
            mystore.getRewardPointToggleOnButton();
        }

        //Verifying the Minimum and Maximum Values of 'Reward Points' Field
        softAssert.assertEquals(getAttribute(mystore.rewardPointsField, "max"), "99999");
        softAssert.assertEquals(getAttribute(mystore.rewardPointsField, "min"), "100");

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
        }
    }

    @Test(description = "SC_05(B) Verifying the Configuration of the Store using flat value in 'tip or gratuity' field")
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
        softAssert.assertEquals(mystore.tipConfigPopUpTitle, Constants.tipConfigurationTitle);

        if (getCountOfWebElements(mystore.alertMessage) > 0) {
            // Click on 'Enter in Percentage' Toggle button
            mystore.getEnterInPerCentToggleButton();
        }

        // Verifying the maximum and minimum values of 'Tip Amount' field
        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField1, "max"), "999.00");
        softAssert.assertEquals(getAttribute(mystore.tipFlatValueField1, "min"), "0.01");

        enterText(mystore.tipFlatValueField1, value1);
        enterText(mystore.tipFlatValueField2, value2);
        enterText(mystore.tipFlatValueField3, value3);

        // Click on 'Save Changes' Button
        mystore.getSaveChangesButton();

    }

    @Test(description = "SC_06 Verifying the Configuration of the Store using Payment Processing Sub-Tab with terminal configuration,")
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
//    @Test(description SC06 (b) =" Verifying the Configuration of the Store using Payment Processing Sub-Tabs on 'Store Configuration' Page with Venmo & Zelle. ")
//    public void verifyConfigurationOfStoreUsingPaymentProcessingSubTab(){
//        Login();
//        pageObjectManager.getSidePannel().getMangeBusinessTab();
//        pageObjectManager.getSidePannel().getMyStoreTab();
//
//        // Click on 'Configure' Link
//        mystore.getConfigureLink();
//
//    waitForElementToBeVisible(mystore.paymentProcessingSubTab,5);
//
//        // Click on 'Payment-Processing' Sub-Tab
//        mystore.getPaymentProcessingSubTab();
//        staticWait(3000);
//        scrollToDown();
//        staticWait(3000);
//        mystore.getAcceptVenmoToggleButton();
////        if(isElementDisabled(mystore.acceptVenmoToggleBtn)) {
////            mystore.getAcceptVenmoToggleButton();
////        }
//        //Verifying Maximum length of 'VenmoID' field
//        softAssert.assertEquals(getAttribute(mystore.venmoIDField,"maxlength"),"40");
//
//        // Enter ID in 'Venmo ID" field
//        enterText(mystore.venmoIDField,requiredDigits(4));
//
//        //Verifying maximum length of 'Venmo Name' field
//        softAssert.assertEquals(getAttribute(mystore.venmoNameField,"maxlength"),"40");
//
//        // Enter name in 'Venmo Name' Field
//        enterText(mystore.venmoNameField,requiredString(8));
//
//        // Click on 'Save' Button
//        mystore.getVenmoSaveButton();
//
//        if(isElementDisabled(mystore.acceptZelleHeader)) {
//            mystore.getAcceptZelleToggleButton();
//        }
//        //Verifying maximum length of 'Zelle Phone' field
//        softAssert.assertEquals(getAttribute(mystore.zellePhoneField,"maxlength"),"40");
//
//        //  Enter Phone Number in 'Zelle Phone' Field
//        enterText(mystore.zellePhoneField,requiredDigits(4));
//
//        // Verifying maximum length of 'Zelle Name' field
//        softAssert.assertEquals(getAttribute(mystore.zelleNameField,"maxlength"),"40");
//
//        // Enter Zelle Account Name
//        enterText(mystore.zelleNameField,requiredString(8));
//
//        // Click on 'Save' Button
//        mystore.getZelleSaveButton();
//    }

    @Test(description = "SC_07(A) Verifying the Configuration of the Store using 'Manage Users' Sub-Tab")
    public void sc07a_VerifyingConfigurationOfStoreUsingManageUsersSubTabs() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Configure' Link
        mystore.getConfigureLink();

        // click on Manage Sub Tab
        mystore.getManageUserSubTab();

        // Click on 'Add User' Button
        mystore.getAddUserBtn();

        //Verifying 'Add User' Pop-Up Title
        softAssert.assertEquals(getText(mystore.addUserPopUpTitle),Constants.addUserTitle);
    }
    @Test(description = "SC_08 Verify deactivating an activated Store")
    public void verifyDeactivatingAnActivatedStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Configure' Link
        mystore.getConfigureLink();
        scrollToElement(mystore.activeSubTab);

       waitForElementToBeInteractable(mystore.activeSubTab,6);

        //  Click on 'Active' Sub-tab
        mystore.getActivateSubtab();

        // Click on Deactivate button
        mystore.getDeactivateBtn();

        //Verifying that store gets Deactivated and success message appears
        softAssert.assertEquals(getText(mystore.notActiveStoreLabel),Constants.deacticeStatus);

        // click on Activate button
        mystore.getActiveButton();

        // Verify the store gets ACTIVE AND INFORMATION MESSAGE APPEARS
        softAssert.assertEquals(getText(mystore.activeStoreLabel),Constants.activeStoreStatus);
        softAssert.assertAll();
    }

    @Test(description = "SC 09-a Verify that store creation and purchasing the 'Premium' monthly plan subscription for the store, on 'Store Configuration' page.")
    public void verifyingStoreCreationWithPurchasingMonthlyPremiumPlan(){
        Login();
        mystore.getStoreCreation();
        mystore.getSubscriptionPlanTab();
        //Verifying that 'Current Plan' appears under Essential Free Plan
        String message = getText(mystore.currentPlanMSg);
        softAssert.assertEquals(message, Constants.currentPlan);

        // Verifying the Premium title
        softAssert.assertTrue(isElementDisplayed(mystore.premiumTitle),"Premium Title");

        // byuing the Premium plan
        mystore.getPremiumMonthlyBtn();
        mystore.getPremiumnSignUpBtn();

        //Verifying that by-default Visa Payment method is enabled
        String defaultPaymentMthd = getText(mystore.addedVisaMethod);
        softAssert.assertEquals(defaultPaymentMthd, Constants.visavalue);

        // Click on 'Change Pay Method' Link
        mystore.getChangePayMethodLink();

        //Verifying that other payment methods are available
        softAssert.assertTrue(isElementDisplayed(mystore.newCreditCardBtn), " New credit card button");
        softAssert.assertTrue(isElementDisplayed(mystore.newBankAccountBtn), "new bank account");

        // Click on 'Terms' Checkbox
        mystore.getTermsCheckbox();

        //  Click on 'Change Plan' Button
        mystore.getChangePlanButton();

        //Verifying that next bill date is generated
        softAssert.assertTrue(isElementDisplayed(mystore.nextBillDate), "next bill date");
        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(mystore.storeNamewithstripe);


    }

}











