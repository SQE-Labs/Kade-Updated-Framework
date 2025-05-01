package qa.tests;


import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.BillPage;

import java.awt.*;


public class BillTest extends BaseTest {

    BillPage bill = new BillPage();

    @Test(priority = 0, description = "BC_01 and BC_08 Verify that creating a bill by adding amount value only, without Selecting a Customer and Verify that unpaid bill gets deleted")
    public void verifyCreateBillWithoutSelectingCustomer() {

        bill.createBillWithoutCustomer();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 1, description = "BC_02 Verify that creating a bill by adding amount value only, with Selecting a Customer")
    public void verifyCreateBillBySelectingCustomer() {
        bill.createBillWithCustomer("636045278965", "yonro@yopmail.com");
        bill.clickOnNotPaidLabel();
        bill.getDeleteButton();
        bill.getDeleteIcon();

    }

    //
    @Test(priority = 2, description = "BC_03 Bill creation by selecting customers from the suggestion list")
    public void verifyCreateBillForSuggestedCustomer() {
        bill.verifyCreateBillForSuggestedCustomer("yonro@yopmail.com");
        bill.deleteBill();
    }


    @Test(priority = 4, description = "BC_09 Verify that creating a bill by adding 'Ref No.', 'Description' and 'Items' fields")
    public void verifyBillCreationUsingOptionalFields() {
        bill.verifyBillCreationByOptionalFields("47000.00", "3000.00", "yonro@yopmail.com");
    }

    @Test(priority = 5, enabled = true, description = "BC_13 Verify that creating a bill after configuring the bill amount value form the store configuration page.")
    public void verifyingBillCreationWithConfiguredBillAmount() {
        bill.verifyingBillCreationWithConfiguredBilledAmount();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }


    @Test(priority = 6, enabled = true, description = "BC_12 Verify that creating a bill with default configured bill amount, on 'Bill' popup of 'Bills' page.")
    public void verifyingBillCreationWithoutConfiguredBillAmount() {
        bill.verifyingBillCreationWithOutConfiguredBillAmount();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 7, enabled = true, description = "BC_06 Verify that creating a bill by attaching the image file.")
    public void verifyingBillCreationByAttachingImageFile() throws InterruptedException, AWTException {

        bill.createBillByAttachingImageFile();

    }

    @Test(priority = 8, enabled = true, description = "BC_07 Verify that creating a bill by attaching the image file.")
    public void verifyingBillCreationByAttachingPdfFile() throws InterruptedException, AWTException {

        bill.verifyingBillCreationByAttachingPdfFile();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 9, enabled = true, description = "BC_14 Verify that creating a bill with adding Memo field, on 'Bill' popup.")
    public void verifyingBillCreationWithAddingMemoField() {
        bill.verifyingBillCreationWithAddingMemoField("yonro@yopmail.com");
    }

    @Test(priority = 10, enabled = true, description = "BC_10 Verify that creating a bill, when user has  Essential (Free) plan for his store")
    public void verifyingBillCreationWithEssentialFreePlan() {
        bill.verifyingBillCreationWithEssentialFreePlan("yonro@yopmail.com");
        bill.clickOnNotPaidLabel();
        bill.deleteBill();
    }

    @Test(priority = 11, enabled = true, description = "BC_15 Verify that creating a bill by adding the custom expiration date' on 'Bills' page..")
    public void verifyBillCreationByAddingExpirationDate() {
        bill.verifyBillCreationByAddingExpirationDate();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 12, enabled = true, description = "BC_16, BC_10 and BC_17  Verify that creating a store by adding recurring transactions, on Bills page and Verify that creating a 'Daily Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsDaily() {
        bill.verifyBillCreationByAddingRecurringTransactionsDaily("6356789657", "saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 13, enabled = true, description = "BC_18 Verify that creating a 'Weekly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsWeekly() {

        bill.verifyBillCreationByAddingRecurringTransactionsWeekly("6356789657", "saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 14, enabled = true, description = "BC_19 Verify that creating a 'Monthly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsMonthly() {
        bill.verifyBillCreationByAddingRecurringTransactionsMonthly("6356789657", "saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 15, enabled = true, description = "BC_20 Verify that creating a 'Monthly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingRecurringTransactionsYearly() {
        bill.verifyBillCreationByAddingRecurringTransactionsYearly("6356789657", "saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        bill.getDeleteButton();
        bill.getDeleteIcon();
    }

    @Test(priority = 16, enabled = true, description = "BC_20 Verify that creating a 'Monthly Recurring bill and Activate after the first payment, on 'Bill' popup.")
    public void verifyBillCreationByAddingpaymentMethod() {
        bill.verifyBillCreationByAddingpaymentMethod("yonro@yopmail.com");
    }
}


