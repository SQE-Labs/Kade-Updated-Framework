package qa.tests;


import base.BaseTest;
import logger.Log;
import org.testng.annotations.Test;
import pageEvents.BillPage;
import utils.Constants;

import java.awt.*;
import java.text.ParseException;


import static utils.Constants.BillHeader;


public class BillTest extends BaseTest {

    BillPage bill = new BillPage();

    @Test(priority = 0, description = "BC_01 and BC_08 Verify that creating a bill by adding amount value only, without Selecting a Customer and Verify that unpaid bill gets deleted")
    public void verifyCreateBillWithoutSelectingCustomer() throws InterruptedException {

        BillPage bill = new BillPage();

        Login();

        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        // Click on New Bill Button
        bill.getNewBillButton();

        // Verify New Bill popup Web Elements
        String billPopupTitle = getText(bill.billPopupHeader);
        softAssert.assertEquals(billPopupTitle, BillHeader);
        softAssert.assertTrue(isElementDisplayed(bill.amountTxtField), "Amount");
        softAssert.assertTrue(isElementDisplayed(bill.addBillDescription), "Description (optional)");
        softAssert.assertTrue(isElementDisplayed(bill.customerDropdown), "Select or create a new customer");
        softAssert.assertTrue(isElementDisplayed(bill.moreLabelTxt), "More options");

        // Verify Default value of Amount tab
        String defaultAmt = bill.getAttribute(bill.amtInput, "value");
        softAssert.assertEquals(defaultAmt, "$0.00");

        //Verify Confirm Button is disabled before entering amount
        softAssert.assertTrue(isElementDisplayed(bill.btnDisbled));

        //Enter amount
        String amt = "2,999.00";
        // Thread.sleep(4000);
        actionEnterText(bill.amtTbx, amt);

        softAssert.assertTrue(isElementDisplayed(bill.taxToggleBtnDisable));

        // Verify Default Confirm button is enabled after entering amount
        softAssert.assertTrue(isElementDisplayed(bill.btnDisbled));

        //Click Confirm
        bill.getConfirmButton();

        //Verify Message popup and Buttons
        softAssert.assertEquals(bill.messagePopupHeader, "Message");
        softAssert.assertTrue(isElementDisplayed(bill.selectCustomer));
        softAssert.assertTrue(isElementDisplayed(bill.continueWithoutBtn));

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Verify toast message : Success message Popup.
        staticWait(4000);
        softAssert.assertTrue(isElementDisplayed(bill.successMessage));
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        softAssert.assertEquals(bill.successMessage, toastMessage);


        //Close popup
        bill.closePaymentpopup();

        //Deleting Created Bill
        staticWait(3000);
        bill.clickOnNotPaidLabel();
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 1, description = "BC_02 Verify that creating a bill by adding amount value only, with Selecting a Customer")
    public void verifyCreateBillBySelectingCustomer() {

        Login();

        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        // Click on New Bill Button
        bill.getNewBillButton();

        // Verify New Bill popup
        softAssert.assertEquals(bill.popUpHeader, "Bill");

        //Verify Confirm Button is disabled before entering amount
        softAssert.assertTrue(isElementDisplayed(bill.btnDisbled));


        //Enter amount
        String amt = "1,000.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Verify Default Confirm button is enabled after entering amount
        softAssert.assertTrue(isElementDisplayed(bill.btnDisbled));


        //Click Confirm
        bill.getConfirmButton();

        //Verify Message popup and Buttons
        softAssert.assertEquals(bill.messagePopupHeader, "Message");
        softAssert.assertTrue(isElementDisplayed(bill.selectCustomer));
        softAssert.assertTrue(isElementDisplayed(bill.continueWithoutBtn));

        //click on select customer button.
        bill.getSelectACustomerButton();

        //Verify Customer popup
        String phoneNumberField = "Phone number. Existing or new";
        String phone = getAttribute(bill.customerNumber, "placeholder");
        softAssert.assertTrue(Boolean.parseBoolean(phone), phoneNumberField);
        Log.info(phone);

        String emailField = "Email. Existing or new";
        String email = getAttribute(bill.customerNumber, "placeholder");
        softAssert.assertTrue(Boolean.parseBoolean(email), emailField);
        Log.info(email);


        //   Select Customer
        bill.getCustomerPhoneNoField("6465551106");
        bill.getCustomerEmailField("yonro@yopmail.com");
        bill.getEmailGoButton();

        //Click Confirm

        bill.getConfirmButton();

        //Verify toast message : Success message Popup.
        softAssert.assertTrue(isElementDisplayed(bill.successMessage));
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        softAssert.assertEquals(bill.successMessage, toastMessage);


        //Close popup
        bill.closePaymentpopup();

        //Deleting Created Bill
        waitForElementToBeClickable(bill.notPaid, 5);
        staticWait(3000);
        bill.clickOnNotPaidLabel();

        //Deleting created bill
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    //
    @Test(priority = 2, description = "BC_03 Bill creation by selecting customers from the suggestion list")
    public void verifyCreateBillForSuggestedCustomer() {

        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "105.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Select Suggested Customer

        bill.getCustomerButton();
        bill.getCustomerEmailField("yonro@yopmail.com");
        bill.getEmailGoButton();
        bill.getConfirmButton();

        //Verify toast message : Success message Popup.
        waitForElementToBeVisible(bill.successMessage, 10);
        softAssert.assertTrue(isElementDisplayed(bill.successMessage));
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        softAssert.assertEquals(bill.successMessage, toastMessage);


        //Close popup
        bill.closePopup();

        //Verify not paid label for generated amount
        softAssert.assertTrue(isElementDisplayed(bill.notPaidLabel));
        softAssert.assertTrue(isElementDisplayed(bill.uniqueRefNo));
        softAssert.assertTrue(isElementDisplayed(bill.billTimeOnPopup));
        staticWait(3000);
        bill.clickOnNotPaidLabel();

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }


    // When we try to run on new store we have to configure tax under more section .
    @Test(priority = 3, description = "BC_04 Bill Creation with already configured 'Tax' from store configuration page.")
    public void verifyCreateBillForConfiguredTax() throws ParseException {


        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "105.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Enable Tax toggle Button
        bill.enableTaxToggleBtn();

//        //Verify Total Amt after tax
//        float taxValue = Float.parseFloat(getText(bill.taxValue).split(" ")[2].replace("%", ""));
//        float totalAmt = NumberFormat.getInstance(Locale.US).parse(getText(bill.totalAmt)).floatValue();
//        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);

        // Extract and parse the tax percentage (handles decimals properly)
        staticWait(4000);

        //  softAssert.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getCustomerEmailField("yonro@yopmail.com");
        bill.getEmailGoButton();
        bill.getConfirmButton();

        //Verify toast message
        //Verify toast message : Success message Popup.
        waitForElementToBeVisible(bill.successMessage, 10);
        softAssert.assertTrue(isElementDisplayed(bill.successMessage));
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        softAssert.assertEquals(bill.successMessage, toastMessage);


        //Close popup
        bill.closePopup();

        //Verify not paid label for generated amount
        softAssert.assertTrue(isElementDisplayed(bill.notPaidLabel));
        softAssert.assertTrue(isElementDisplayed(bill.uniqueRefNo));
        softAssert.assertTrue(isElementDisplayed(bill.billTimeOnPopup));
        staticWait(3000);
        bill.clickOnNotPaidLabel();

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }


    @Test(priority = 4, description = "BC_09 Verify that creating a bill by adding 'Ref No.', 'Description' and 'Items' fields")
    public void verifyBillCreationUsingOptionalFields() {

        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //click on more option section
        bill.clickOnMoreSection();

        //Asserting 'None' text bydefault in the 'Ref No' field.
        bill.assertGetRefNotxt();
        //Asserting Reference No.' popup.
        bill.clickOnGetRefNotxt();
        //Asserting entered text in refno text field
        bill.assertEnteredText();
        bill.assertDescriptionNonetxt();
        // Click on Descrption field
        bill.entertxtInDescriptiontxt();
        bill.assertEnteredTextInDescriptionField();
        bill.enterInBillTxtField("47000.00", "3000.00");

        //select customer to share the bill
        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getCustomerEmailField("yonro@yopmail.com");
        bill.getEmailGoButton();
        bill.getConfirmButton();

        //Close popup
        bill.closePopup();

        // Asserting description
        bill.assertingDescription();

    }

    @Test(priority = 5, enabled = true, description = "BC_13 Verify that creating a bill after configuring the bill amount value form the store configuration page.")
    public void verifyingBillCreationWithConfiguredBillAmount() {


        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        softAssert.assertTrue(isElementDisplayed(bill.newBillBtn));
        softAssert.assertTrue(isElementDisplayed(bill.transactionsLink));
        softAssert.assertTrue(isElementDisplayed(bill.filterBtn));

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "5000001";
        bill.validateEnteredAmount();
        bill.getAmountValue();

        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        bill.validatingEnteredAmount();
        //Click Confirm
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();


        //Close popup
        bill.closePaymentpopup();

        //Deleting Created Bill
        staticWait(3000);
        bill.clickOnNotPaidLabel();
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();

    }

// first time no suggested customer appears . we need to handle this test scenrios also.

    @Test(priority = 6, enabled = true, description = "BC_12 Verify that creating a bill with default configured bill amount, on 'Bill' popup of 'Bills' page.")
    public void verifyingBillCreationWithOutConfiguredBillAmount() {


        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillTest);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        softAssert.assertTrue(isElementDisplayed(bill.newBillBtn));
        softAssert.assertTrue(isElementDisplayed(bill.transactionsLink));
        softAssert.assertTrue(isElementDisplayed(bill.filterBtn));

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        bill.amt = "300001";


        bill.getAmountValue();

        staticWait(3000);
        actionEnterText(bill.amtTbx, bill.amt);

        bill.validatingEnteredAmount();


        //Click Confirm
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();


        //Close popup
        bill.closePaymentpopup();


        //Deleting Created Bill
        staticWait(3000);
        bill.clickOnNotPaidLabel();
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 7, enabled = true, description = "BC_06 Verify that creating a bill by attaching the image file.")
    public void verifyingBillCreationByAttachingImageFile() throws InterruptedException, AWTException {

        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillTest);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        softAssert.assertTrue(isElementDisplayed(bill.newBillBtn));
        softAssert.assertTrue(isElementDisplayed(bill.transactionsLink));
        softAssert.assertTrue(isElementDisplayed(bill.filterBtn));

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        Thread.sleep(4000);
        actionEnterText(bill.amtTbx, amt);

        bill.clickOnTapToAddImageFiles();

        //Click Confirm
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Close popup
        bill.clickOnCloseIcon();
    }

    @Test(priority = 8, enabled = true, description = "BC_07 Verify that creating a bill by attaching the image file.")
    public void verifyingBillCreationByAttachingPdfFile() throws InterruptedException, AWTException {

        Login();
        //Select Store

        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillTest);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        softAssert.assertTrue(isElementDisplayed(bill.newBillBtn));
        softAssert.assertTrue(isElementDisplayed(bill.transactionsLink));
        softAssert.assertTrue(isElementDisplayed(bill.filterBtn));

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        Thread.sleep(4000);
        actionEnterText(bill.amtTbx, amt);

        bill.clickOnTapToAddPdfFiles();

        //Click Confirm
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Close popup
        bill.closePopup();
    }

    @Test(priority = 9, enabled = true, description = "BC_14 Verify that creating a bill with adding Memo field, on 'Bill' popup.")
    public void verifyingBillCreationWithAddingMemoField() {
        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getCustomerEmailField("yonro@yopmail.com");
        bill.getEmailGoButton();


        //click on more option section
        bill.clickOnMoreSection();

        softAssert.assertEquals(bill.memoNoneTxt, "None");
        bill.getMemoFieldMessage();
        bill.clickOnMemoButton();

        //Verifying details of 'Memo' Pop-up
        bill.getMemoPopUpTitle();
        bill.getMemoField();
        bill.clickOnDoneBtn();

        //Confirming the Bill
        bill.getConfirmButton();

        //Close popup
        bill.closePopupOnBillPage();
        //Verify not paid label for generated amount
        bill.verifyEnteredMemoText();
    }


    @Test(priority = 10, enabled = true, description = "BC_10 Verify that creating a bill, when user has  Essential (Free) plan for his store")
    public void verifyingBillCreationWithEssentialFreePlan() {
        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationCustomerStore);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getCustomerEmailField("yonro@yopmail.com");
        bill.getEmailGoButton();
        bill.clickOnEnterNameDoneBtn();


        //click on more option section
        bill.clickOnMoreSection();

        //Click on 'Repeat' Field
        softAssert.assertTrue(isElementDisplayed(bill.repeatLockIcon));
        bill.clickOnRepeatsection();
        bill.assertUpgradePlan();


        //Click on 'Expiry' Field
        softAssert.assertTrue(isElementDisplayed(bill.expireLockIcon));
        bill.clickOnExpiryDateSection();
        bill.assertUpgradePlan();


        //Confirming the Bill
        bill.getConfirmButton();

        //Close popup
        bill.closePaymentpopup();

//Verify not paid label for generated amount
        softAssert.assertTrue(isElementDisplayed(bill.notPaidLabel));
        softAssert.assertTrue(isElementDisplayed(bill.uniqueRefNo));
        softAssert.assertTrue(isElementDisplayed(bill.billTimeOnPopup));
        softAssert.assertTrue(isElementDisplayed(bill.expireDateTime));

        staticWait(3000);
        bill.clickOnNotPaidLabel();

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();

    }

    @Test(priority = 11, enabled = true, description = "BC_15 Verify that creating a bill by adding the custom expiration date' on 'Bills' page..")
    public void verifyBillCreationByAddingExpirationDate() {
        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Click on More Option
        bill.clickOnMoreSection();
        bill.clickOnExpiryDateSection();
        staticWait(2000);

        softAssert.assertEquals((bill.expirationDayPopUp), "Expiration Date");
        softAssert.assertTrue(isElementDisplayed(bill.noneTxt));
        softAssert.assertTrue(isElementDisplayed(bill.dayTxt));
        softAssert.assertTrue(isElementDisplayed(bill.quterDayTxt));
        softAssert.assertTrue(isElementDisplayed(bill.oneHourTxt));
        softAssert.assertTrue(isElementDisplayed(bill.thirtyMinTxt));


        //Click on Expiry Field
        bill.sendTxtInexpireInTxtField("20", 1);
        bill.clickOnDoneBtn();


        //Click Confirm
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Close popup
        bill.closePaymentpopup();


//Verify not paid label for generated amount
        softAssert.assertTrue(isElementDisplayed(bill.notPaidLabel));
        softAssert.assertTrue(isElementDisplayed(bill.uniqueRefNo));
        softAssert.assertTrue(isElementDisplayed(bill.billTimeOnPopup));
        softAssert.assertTrue(isElementDisplayed(bill.expireDateTime));

        staticWait(3000);
        bill.clickOnNotPaidLabel();

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 12, enabled = true, description = "BC_16, BC_10 and BC_17  Verify that creating a store by adding recurring transactions, on Bills page and Verify that creating a 'Daily Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsDaily() {

        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Click on More Option
        bill.clickOnMoreSection();
        bill.clickOnRepeatField();
        bill.getDailyFieldValue();
        //  bill.activateAfterFirstElement();
        bill.clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Close popup
        bill.closePaymentpopup();

        softAssert.assertTrue(isElementDisplayed(bill.reccuringIcon));
        bill.clickOnReccuring();

        bill.removeNonNumericValueFromTheValue();


        //Deleting Created Bill
        staticWait(3000);
        bill.clickOnBillLabel();
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 13, enabled = true, description = "BC_18 Verify that creating a 'Weekly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsWeekly() {

        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Click on More Option
        bill.clickOnMoreSection();
        bill.clickOnRepeatField();
        bill.getWeeklyFieldValue();
        //  bill.activateAfterFirstElement();
        bill.clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Close popup
        bill.closePaymentpopup();

        softAssert.assertTrue(isElementDisplayed(bill.reccuringIcon));
        bill.clickOnReccuring();

        bill.removeNonNumericValueFromTheValue();


        //Deleting Created Bill
        staticWait(3000);
        bill.clickOnBillLabel();
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 14, enabled = true, description = "BC_19 Verify that creating a 'Monthly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsMonthly() {

        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount

        staticWait(3000);
        actionEnterText(bill.amtTbx, bill.amt);

        //Click on More Option
        bill.clickOnMoreSection();
        bill.clickOnRepeatField();
        bill.getMonthlyFieldValue();
        //  bill.activateAfterFirstElement();
        bill.clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Close popup
        bill.closePaymentpopup();

        softAssert.assertTrue(isElementDisplayed(bill.reccuringIcon));
        bill.clickOnReccuring();


        bill.removeNonNumericValueFromTheValue();

        //Deleting Created Bill
        staticWait(3000);
        bill.clickOnBillLabel();
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 15, enabled = true, description = "BC_20 Verify that creating a 'Monthly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsYearly() {

        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount

        staticWait(3000);
        actionEnterText(bill.amtTbx, bill.amt);

        //Click on More Option
        bill.clickOnMoreSection();
        bill.clickOnRepeatField();
        bill.getYearlyFieldValue();
        bill.clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        bill.getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        bill.getContinueWithoutButton();

        //Close popup
        bill.closePaymentpopup();

        softAssert.assertTrue(isElementDisplayed(bill.reccuringIcon));
        bill.clickOnReccuring();


        bill.removeNonNumericValueFromTheValue();

        //Deleting Created Bill
        staticWait(3000);
        bill.clickOnBillLabel();
        staticWait(2000);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 21, enabled = true, description = "BC_20 Verify that creating a 'Monthly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingpaymentMethod() {
        Login();
        //Select Store
        bill.clickOnNewBill();
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1005.00";
        staticWait(3000);
        actionEnterText(bill.amtTbx, amt);

        //Select Suggested Customer

        bill.getCustomerButton();
        bill.getCustomerEmailField("yonro@yopmail.com");
        bill.getEmailGoButton();

        //Share bill by clicking on Share link to customer button
        bill.clickOnpaymentMethodLink();
        bill.clickOnshareLinkToCustomer();

        //Share bill by adding card details
        bill.clickOnpaymentMethodLink();

    }
}


