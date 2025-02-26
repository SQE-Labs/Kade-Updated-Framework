package qa.tests;



import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import base.BaseTest;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageEvents.BillPage;

import static sun.security.jgss.GSSUtil.login;

public class BillTest extends BaseTest {

    @Test(description = "BC_01 Verify that creating a bill by adding amount value only, without Selecting a Customer")
    public void verifyCreateBillWithoutSelectingCustomer() throws InterruptedException {

        
        BillPage bill =new BillPage();
        Login();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        // Click on New Bill Button
        bill.getNewBillButton();

        // Verify New Bill popup Web Elements
        String billPopupTitle = bill.getPopupTitle().getText();
        Assertions.assertEquals(billPopupTitle, "Bill");
        Assertions.assertTrue(bill.getAmountTextbox().isDisplayed());
        Assertions.assertTrue(bill.getDescriptionTextbox().isDisplayed());
        Assertions.assertTrue(bill.getCustomerField().isDisplayed());
        Assertions.assertTrue(bill.getMoreOption().isDisplayed());

        // Verify Default value of Amount tab
        String defaultAmt = bill.getAttribute(bill.amtInput, "value");
        Assertions.assertEquals(defaultAmt, "$0.00");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(bill.getConfirmButton().isEnabled());

        //Enter amount
        String amt = "2,999.00";
        bill.getAmountTextbox().setText(amt);
        bill.getDisableTaxToggleButton();

        // Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(bill.getConfirmButton().isEnabled());

        //Click Confirm
        bill.getConfirmButton();

        //Verify Message popup and Buttons
        Assertions.assertEquals(bill.getMessagePopupHeader().getText(), "Message");
        Assertions.assertTrue(bill.getSelectCustomerButton().isDisplayed());
        Assertions.assertTrue(bill.getContinueWithoutButton().isDisplayed());

        //Click On Continue Button
        WebdriverWaits.waitForElementVisible(session.getBillPage().continueWithoutBtn,30);
        bill.getContinueWithoutButton().clickByMouse();

        //Verify toast message : Success message Popup.
        WebdriverWaits.waitForElementVisible(session.getBillPage().toastMessage,30);
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify not paid label for generated amount
        bill.getUnpaidBillWithoutDescription();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_02 Verify that creating a bill by adding amount value only, with Selecting a Customer")
    public void verifyCreateBillBySelectingCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        // Click on New Bill Button
        bill.getNewBillButton();

        // Verify New Bill popup
        String popupTitle = bill.getPopupTitle().getText();
        Assertions.assertEquals(popupTitle, "Bill");

        //Verify Confirm Button is disabled before entering amount
        Assertions.assertFalse(bill.getConfirmButton().isEnabled());

        //Enter amount
        String amt = "1,000.00";
        bill.getAmountTextbox().setText(amt);

        //Verify Default Confirm button is enabled after entering amount
        Assertions.assertTrue(bill.getConfirmButton().isEnabled());

        //Click Confirm
        WebdriverWaits.waitForElementVisible(session.getBillPage().confirmBtn,30);
        bill.getConfirmButton().clickbyJS();

        //Verify Message popup and Buttons
        Assertions.assertEquals(bill.getMessagePopupHeader().getText(), "Message");
        Assertions.assertTrue(bill.getSelectCustomerButton().isDisplayed());
        Assertions.assertTrue(bill.getContinueWithoutButton().isDisplayed());
        WebdriverWaits.waitForElementVisible(session.getBillPage().selectACustomerBtn,30);
        bill.getSelectACustomerButton();

        //Verify Customer popup
        Assertions.assertTrue(bill.getCustomerPhoneNoField().isDisplayed());
        Assertions.assertTrue(bill.getEmailField().isDisplayed());
        Assertions.assertTrue(bill.getSearchField().isDisplayed());

        //Select Customer
        bill.getCustomerPhoneNoField().setText("918877070727");
        bill.getGoPhoneNumberButton();
        bill.getDoneLinkOnBillPage().clickIfExist();

        //Click Confirm
        bill.getDisableTaxToggleButton().clickIfExist();
        bill.getConfirmButton();

        //Verify toast message
        WebdriverWaits.waitForElementVisible(session.getBillPage().toastMessage,30);
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify not paid label for generated amount
        bill.getUnpaidBillWithoutDescription();

        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_03 Bill creation by selecting customers from the suggestion list")
    public void verifyCreateBillForSuggestedCustomer() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "105.00";
        bill.getAmountTextbox().setText(amt);

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();
        bill.getDisableTaxToggleButton().clickIfExist();
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify not paid label for generated amount
        bill.getUnpaidBillWithoutDescription().clickByMouse();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }


    // When we try to run on new store we have to configure tax under more section .
    @Test(description = "BC_04 Bill Creation with already configured 'Tax' from store configuration page.")
    public void verifyCreateBillForConfiguredTax() throws ParseException {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "2500.00";
        bill.getAmountTextbox();

        //Enable Tax toggle Button
        bill.getEnableTaxToggleButton();

        //Verify Total Amt after tax
        float taxValue = Float.parseFloat(bill.getTaxValue().getText().split(" ")[2].replace("%", ""));
        float totalAmt = NumberFormat.getInstance(Locale.US).parse(bill.getTotalAmt().getText()).floatValue();
        float expectedTotal = Float.parseFloat(amt) + (taxValue / 100) * Float.parseFloat(amt);

        Assertions.assertTrue(expectedTotal == totalAmt);

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();
        bill.getConfirmButton();

        //Verify toast message
        softAssert.assertEquals(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify not paid label for generated amount
        bill.getUnpaidBillWithoutDescription();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }


    @Test(description = "BC_07 Verify that unpaid bill gets deleted")
    public void verifyBillDeletion() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        bill.getNewBillButton();

        //Enter amount
        String amt = "2500.00";
        bill.getAmountTextbox().setText(amt);

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();
        bill.getConfirmButton();

        //Close popup
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Delete the 1st unpaid bill
        bill.getUnpaidBillWithoutDescription();
        WebdriverWaits.waitForElementVisible(session.getBillPage().deleteButton,30);
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_08 Verify that creating a bill by adding 'Ref No.', 'Description' and 'Items' fields")
    public void verifyBillCreationUsingOptionalFields() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Click on New Bill Button
        bill.getNewBillButton();
        bill.getDisableTaxToggleButton();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();
        bill.getDisableTaxToggleButton();

        //Verify that optional fields are added to the bill
        bill.getMoreOptionsButton();

        String defaultPriceValue = bill.getItemPriceField1().getAttribute("value");
        //  Assertions.assertEquals(defaultPriceValue, "$0.00"); due to defect.

        //Verifying that 'None' text should appear by default in 'Reference' field
        Assertions.assertEquals(bill.getDefaultReferenceNumberText().getText(), "None");
        bill.getReferenceNumber();
        Assertions.assertEquals(bill.getReferencePopUpTitle().getText(), "Reference No.");
        String actualMaxRefLen = bill.getReferenceNumberField().getAttribute("maxlength");
        Assertions.assertEquals(actualMaxRefLen, "50");
        String refNum = "1789";
        bill.getReferenceNumberField().setText(refNum);
        bill.getDoneLink();

        //Verifying that added reference number should appear under the 'Ref No' field.
        Assertions.assertEquals(bill.getAddedReferenceNumberText().getText(), refNum);

        //Verifying that default text should be none in Description Field
        Assertions.assertEquals(bill.getDescriptionFieldDefaultText().getText(), "None");
        bill.getDescription();
        Assertions.assertEquals(bill.getDescriptionPopUpTitle().getText(), "Description");
        String actualMaxDescLen = bill.getItemDescriptionField1().getAttribute("maxlength");
        Assertions.assertEquals(actualMaxDescLen, "200");
        String descriptionValue = "Test Description";
        bill.getDescriptionBox().setText(descriptionValue);

        //Verifying that added reference number should appear under the 'Description' field.
        bill.getDoneLink();
        Assertions.assertEquals(bill.getDescriptionFieldAddedText().getText(), descriptionValue);

        //Verifying that Description and Price fields appear
        Assertions.assertTrue(bill.getItemDescriptionField1().isDisplayed());
        Assertions.assertTrue(bill.getItemDescriptionField2().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField1().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField2().isDisplayed());
        String actualItemDescLen = bill.getItemDescriptionField1().getAttribute("maxlength");
        Assertions.assertEquals(actualItemDescLen, "200");

        String actualItemPriceLen = bill.getItemPriceField1().getAttribute("max");
        Assertions.assertEquals(actualItemPriceLen, "50000.00");

        //Enter Items and Item Price
        String desc1 = "Tea";
        bill.getItemDescriptionField1().setText(desc1);
        String price1 = "80.00";
        bill.getItemPriceField1().setText(price1);
        String desc2 = "Coffee";
        bill.getItemDescriptionField2().setText(desc2);
        String price2 = "120.00";
        bill.getItemPriceField2().setText(price2);

        //Verifying that 'Add A line' button appear in the bill pop-up
        Assertions.assertTrue(bill.getAddALineButton().isDisplayed());
        Assertions.assertEquals(bill.getAddALineButton().getText(), "Add a line");
        bill.getAddALineButton();
        Assertions.assertTrue(bill.getItemPriceField3().isDisplayed());
        Assertions.assertTrue(bill.getItemPriceField3().isDisplayed());
        String desc3 = "Shake";
        bill.getItemDescriptionField3().setText(desc3);
        String price3 = "150.00";
        bill.getItemPriceField3().setText(price3);
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist(true,3);

        //Verifying the total amount 80+120+150
        bill.getUnPaidBillWithDescription();
        Assertions.assertTrue(bill.getNotPaidLabel();
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        Assertions.assertTrue(bill.getAddedDescription().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_09 Verify that creating a bill, when user has  Essential (Free) plan for his store")
    public void verifyingBillCreationWithEssentialFreePlan() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton();
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "90.00";
        bill.getAmountTextbox();
        bill.getDisableTaxToggleButton();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Verify that optional fields are added to the bill
        bill.getMoreOption();

        Assertions.assertTrue(bill.getFreezeIcon1().isDisplayed());
        bill.getRepeatButton();
        Assertions.assertTrue(bill.getNotNowButton().isDisplayed());
        Assertions.assertTrue(bill.getUpgradeButton().isDisplayed());
        Assertions.assertEquals(bill.getUpgradePopUpTitle().getText(), "Upgrade your plan");
        bill.getNotNowButton();

        //Verifying that Repeat and Expiry Fields are locked
        Assertions.assertTrue(bill.getFreezeIcon2().isDisplayed());
        bill.getExpiryButton();
        bill.getUpgradeButton();
    }

    @Test(description = "BC_12 Verify that creating a bill with configured bill amount, on 'Bill' popup")
    public void qverifyingBillCreationWithConfiguredBillAmount() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "50,000.00";
        bill.getAmountTextbox();
        bill.getDisableTaxToggleButton();
        Assertions.assertEquals(bill.getAmountTextbox().getAttribute("max"), "50000.00");

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify Created Bill
        bill.getUnpaidBillWithoutDescription().clickByMouse();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amount = "60,000.00";
        WebdriverWaits.waitForElementVisible(session.getBillPage().amtTbx,30);
        bill.getAmountTextbox();
        bill.getDisableTaxToggleButton();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        WebdriverWaits.waitForElementVisible(session.getBillPage().closeLogoPopupBtn,30);
        bill.getCloseLogoPopupBtn();
        bill.getUnpaidBillWithoutDescription();
        Assertions.assertNotEquals(bill.getUnpaidAmount().getText(), amount);
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Delete Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

// first time no suggested customer appears . we need to handle this test scenrios also.

    @Test(description = "BC_11 Verify that creating a bill with default configured bill amount, on 'Bill' popup")
    public void
    verifyingBillCreationWithOutConfiguredBillAmount() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillTest);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "3,000.00";
        bill.getAmountTextbox();
        bill.getDisableTaxToggleButton();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify Created Bill
        bill.getUnpaidBillWithoutDescription();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amount = "5,000.00";
        WebdriverWaits.waitForElementVisible(session.getBillPage().amtTbx,30);
        bill.getAmountTextbox().setText(amount);
        bill.getDisableTaxToggleButton().clickIfExist();
        bill.getNewBillButton();

        //Enter amount



        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify Created Bill
        Assertions.assertNotEquals(bill.getUnpaidAmount().getText(),amount);
        bill.getUnpaidBillWithoutDescription().clickByMouse();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_13 Verify that creating a bill with adding Memo field, on 'Bill' popup.")
    public void verifyingBillCreationWithAddingMemoField() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillFlow);
        bill.getContinueButton();

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.getDisableTaxToggleButton().clickIfExist();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Click on More Options
        bill.getMoreOption();
        Assertions.assertEquals(bill.getDefaultMemoFieldText().getText(), "None");
        Assertions.assertEquals(bill.getMemoFieldMessage().getText(), "Customer will not see this memo");
        bill.getMemoButton();

        //Verifying details of 'Memo' Pop-up
        Assertions.assertEquals(bill.getMemoPopUpTitle().getText(), "Memo");
        Assertions.assertEquals(bill.getMemoField().getAttribute("maxlength"), "200");
        String memoText = "Memo Text";
        bill.getMemoField().setText(memoText);
        bill.getDoneButton();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist(true,3);

        //Verify Created Bill
        bill.getUnPaidBillWithDescription().clickByMouse();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        Assertions.assertEquals(bill.getAddedMemoText().getText(), "Memo Text");

        //Delete Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_10 Verify that creating a bill after purchasing the 'Business' plan from the 'Store Configuration' page.")
    public void verifyingBillCreationAfterPurchasingBusinessPlan() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillTest);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.getDisableTaxToggleButton().clickIfExist();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();
        bill.getMoreOption();

        //Click on 'Repeat' Field
        bill.getRepeatField();
        WebdriverWaits.waitForElementVisible(session.getBillPage().repeatPopUpTitle,30);
        WebdriverWaits.fluentWait_ElementIntactable(2000, 500, By.xpath("//h5[text()='Repeat']"));
        Assertions.assertEquals(bill.getRepeatPopUpTitle().getText(), "Repeat");
        bill.getDoneButton();

        //Click on 'Expiry' Field
        WebdriverWaits.waitForElementVisible(session.getBillPage().paidExpiryField,30);
        bill.getExpiryField().clickByMouse();
        Assertions.assertEquals(bill.getExpiryDatePopUpTitle().getText(), "Expiration Date");
        bill.getDoneButton();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);

        //Verify Created Bill
        bill.getCloseLogoPopupBtn().clickIfExist(true,3);
        bill.getUnPaidBillWithDescription().clickByMouse();
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_15 Verify that creating a bill by adding the custom expiration date' on 'Bills' page..")
    public void verifyingBillCreationByAddingExpirationDate() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillTest);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.getDisableTaxToggleButton().clickIfExist();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Click on More Option
        bill.getMoreOption();
        WebdriverWaits.sleep(2000);
        //    WebdriverWaits.waitForElementVisible(session.getBillPage().paidExpiryField,40);
        bill.getExpiryField().clickByMouse();
        Assertions.assertEquals(bill.getExpiryDatePopUpTitle().getText(), "Expiration Date");
        Assertions.assertTrue(bill.getExpiryNoneOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry24HrOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry4HrOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry1HrOption().isDisplayed());
        Assertions.assertTrue(bill.getExpiry30MinOption().isDisplayed());
        bill.getDoneButton();

        //Click on Expiry Field
        WebdriverWaits.waitForElementVisible(session.getBillPage().paidExpiryField,30);
        bill.getExpiryField().clickByMouse();
        String expiresIn = "20";
        bill.getExpiresInField().setText(expiresIn);
        bill.getExpiryDropDown();
        bill.getExpiryDropDownOption();
        bill.getDoneButton();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist(true,3);

        //Verify Created Bill
        bill.getUnpaidBillWithoutDescription().clickByMouse();
        Assertions.assertTrue(bill.getAddedExpiryTimer().isDisplayed());
        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(description = "BC_16 Verify that creating a store by adding recurring transactions, on Bills page")
    public void verifyingBillCreationByAddingRecurringTransactions() {
        KadeSession session = KadeSession.login(KadeUserAccount.Default);
        session.getSidePannel().getBillButton();
        BillPage bill = session.getBillPage();

        //Select Store
        bill.getStoresDropdown();
        bill.selectStore(Constants.AutomationBillTest);
        bill.getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assertions.assertTrue(bill.getNewBillButton().isDisplayed());
        Assertions.assertTrue(bill.getTransactionLink().isDisplayed());
        Assertions.assertTrue(bill.getFilterButton().isDisplayed());

        // Click on New Bill Button
        bill.getNewBillButton();

        //Enter amount
        String amt = "1,000.00";
        bill.getAmountTextbox().setText(amt);
        bill.getDisableTaxToggleButton().clickIfExist();

        //Select Suggested Customer
        bill.getCustomerButton();
        bill.getSuggestedCustomer();

        //Click on More Option
        bill.getMoreOption();
        bill.getRepeatField();
        Assertions.assertEquals(bill.getRepeatPopUpTitle().getText(), "Repeat");
        bill.getDoneButton();

        //Click on Repeat Field
        bill.getRepeatField();
        bill.getRepeatOption();
        bill.getCustomerCancelOption();
        Assertions.assertEquals(bill.getEveryDayFieldValue().getAttribute("value"), "1");
        bill.getDoneBtn();

        //Confirming the Bill
        bill.getConfirmButton();

        //Verify toast message
        Assertions.assertTrue(bill.getToastMessage().isDisplayed());
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assertions.assertEquals(bill.getToastMessage().getText(), toastMessage);
        bill.getCloseLogoPopupBtn().clickIfExist(true,4);

        //Verify Created Bill
        bill.getUnpaidBillWithoutDescription().clickByMouse();

        Assertions.assertTrue(bill.getNotPaidLabel().isDisplayed());
        Assertions.assertTrue(bill.getUniqueReferenceNumber().isDisplayed());
        Assertions.assertTrue(bill.getBillTime().isDisplayed());
        Assertions.assertEquals(bill.getRecurringBillText().getText(), "This is a recurring bill");

        //Deleting Created Bill
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }
}

