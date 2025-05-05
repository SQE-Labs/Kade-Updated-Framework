package qa.tests;

import base.BaseTest;

import org.testng.annotations.Test;
import pageEvents.BillPage;
import pageEvents.PaymentPage;
 import pageEvents.TransactionsPage;
import pageObjects.PageObjectManager;
import utils.Constants;

public class TransactionsTest extends BaseTest {
    BillPage bill = new BillPage();
    PaymentPage payment = new PaymentPage();

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private TransactionsPage transaction = pageObjectManager.getTransactionsPage();


    @Test(priority = 0, enabled = true,description = "TRS 01 a: Verify that list of transactions appears on 'Transaction' page.")
    public void verifyThatListOfTransactionsAppears() {
        transaction.verifyAllElementsOnTransactionPopup();
    }

    @Test(priority = 1, enabled = true,description = "TRS 01 b: Verify that 'By store' appears on each transaction when transaction is completed by the store manager, on 'Transaction' page.")
    public void verifyByStoreLabelOnTransactionPage() {
        transaction.verifyByStoreLabel();
    }


    @Test(priority = 2, enabled = true,description = "TRS2 : Verify that appropriate information message appears when no transaction is available, on 'Transaction' page.")
    public void averifyInfoMessageAppearsWhenNoTransactionIsAvailable() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        staticWait(3000);

        bill.getStoresDropdown();
        selectStore(Constants.AutomationTransaction2);
        bill.getContinueButton();

        String informsg = getText(transaction.informationMessage);
        softAssert.assertEquals(informsg, Constants.noPaymentInfoMsg);
    }

    @Test(priority = 3, enabled = true,description = "TRS3 : Verify that 'New Bill' and 'New Charge' buttons and filter icon, appear on 'Transaction' page.")
    public void verifyNewBillNewChargeButtonsAndFilterOnTransactionPage() {
        Login();
        // verify the Elements on Transaction Page
        transaction.verifyElementsOnTransactionsPage();
    }

    @Test(priority = 4, enabled = true,description = "TRS4 : Verify that store manager is not able to do the new charge payment, when stripe payment is not configured.")
    public void newChargePaymentWithoutStripeConfiguration() {
        Login();
        transaction.verifyNewChargeWithoutStripeConfigured();

    }

    @Test(priority = 5, enabled = true,description = "TRS5 (a) :Verify that store manager is able to charge a customer manually, after stripe payment is configured for a store.")
    public void a3chargeManuallyAfterStripeConfigured() {
        transaction.getManualCharge();

    }

    @Test(priority = 6, enabled = true,description = "TRS5 (b): Verify that store manager is able to charge a customer when terminal is configured for a store.")
    public void newChargerWithTerminal() {
        Login();
        transaction.getTerminalcharge();

    }

    @Test(priority = 7, enabled = true,description = "TRS 5 (c): Verify that the store manager can manually do new charge payment, after cancelling the terminal automatic payment deduction process, on 'Transaction' page.")
    public void newChargePaymentManuallyAfterCancelingTerminalAutomaticPaymentDeduction() {
        Login();
        transaction.getManualChargeAfterCancelingTerminal();
    }

    @Test(priority = 8, enabled = true,description = "TRS6 Verify that 'Transaction details' popup opens up after clicking on any transaction of 'Transaction' page.")
    public void verifyThatElementsOfTransactionDetailsPopup() {
        Login();
        transaction.getAllElementsOfTransactionsPopup();
    }


    @Test(priority = 9, enabled = true,description = "TRS7 (a): Verify that store manager is able to refund full transaction on 'Transaction details' popup of 'Transaction' page.")
    public void verifyRefundFullTransactionOnTransactionPage() {
        transaction.getFullRefund();
    }

    @Test(priority = 10, enabled = true,description = "TRS7 (b): Verify that store manager is able to refund partial transaction on 'Transaction details' popup of 'Transaction' page.")
    public void verifyThatStoreMangerIsAbleToRefundPartialPayment() {

        transaction.getPartialRefund();
    }

    @Test(priority = 11, enabled = true,description = "TRS8 Verify that store manager is able to verify the transactions on 'Transaction details' popup of 'Transaction' page.")
    public void verifyThatStoreMangerIsAbleToVerifyTransaction() {
        Login();
        transaction.verifyTheTransaction();
    }

    @Test(priority = 12, enabled = true,description = " TRS 11 & 12 Verify that Question mark icon gets removed, when store manager manually marked the payment as 'Captured'.")
    public void verifyQuestionmarkIconRemovedWhenStoreManagerManuallyMarkedPaymentAsCaptured() {
        transaction.verifyQuestionMarkIcon();
    }

    @Test(priority = 13, enabled = true,description = "TRS 15 : Recurring icon appears for RT enable bill transaction, on 'Transaction' page.")
    public void verifyRecurringIconAppearsForRTEnabledBillTransactions() {

        bill.BillCreationByAddingRecurringTransactionsWeekly("6356789657", "saybo@yopmail.com");
        staticWait(3000);
        payment.billPaymentByThroughDebitCardWithRecurringBill("4111111111111111", "0930", "794", "Australia");
        payment.swipeCard();
        payment.billPayment();
    }

    @Test(priority = 14, enabled = true,description = "TRS10: Verify that Fail payment icon appears, when payment is failed manually on 'Transaction detail' popup of 'Transaction' page.")
    public void a2getFailedPaymentIcon() {
        transaction.verifyTheFailedIcon();

    }

    @Test(priority = 15, enabled = true,description = "TRS 16 verify That processing payment icon appears, after making bank transfer payment")
    public void verifyProcessingPaymentIcon() {
        transaction.verifyPaymentProcessingIcon();

    }

    @Test(priority = 16, enabled = true,description = "TRS 09- A Verify that store manager is able to filter the transaction on 'Transactions' page.")
    public void verifyThatTransactionListAppears() {
        transaction.getFilterAllTheElements();
    }

    @Test(priority = 17, enabled = true,description = "TRS 09- A Verify that store manager is able to Download the transactions on 'Transactions' page.")
    public void verifyThatTransactionsGetsDownloaded() {
        transaction.FilterGetsDownloadTransactions();

    }
}

