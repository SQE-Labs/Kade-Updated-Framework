package qa.tests;

import base.BaseTest;
import logger.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageEvents.SignUpPage;
import pageEvents.TransactionsPage;
import pageObjects.PageObjectManager;
import utils.Constants;

public class TransactionsTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(SignUpPage.class);
    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private TransactionsPage transaction  = pageObjectManager.getTransactionsPage();

//    @Test(description = "Verify that list of transactions appears on 'Transaction' page.")
//    public void verifyThatListOfTransactionsAppears(){
//
//    }

    @Test(description = "TRS2 : Verify that appropriate information message appears when no transaction is available, on 'Transaction' page.")
    public void verifyInfoMessageAppearsWhenNoTransactionIsAvailable() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        selectStore(Constants.AutomationTransaction2);
        String informsg = getText(transaction.informationMessage);
        softAssert.assertEquals(informsg,Constants.noPaymentInfoMsg);
    }

    @Test(description = "TRS3 : Verify that 'New Bill' and 'New Charge' buttons and filter icon, appear on 'Transaction' page.")
    public void verifyNewBillNewChargeButtonsAndFilterOnTransactionPage() {
        Login();
        // verify the Elements on Transaction Page
        transaction.verifyElementsOnTransactionsPage();
    }

    @Test(description = "TRS4 : Verify that store manager is not able to do the new charge payment, when stripe payment is not configured.")
    public void newChargePaymentWithoutStripeConfiguration() {
        Login();
        transaction.verifyNewChargeWithoutStripeConfigured();

    }

    @Test(description = "TRS5 (a) :Verify that store manager is able to charge a customer manually, after stripe payment is configured for a store.")
    public void chargeManuallyAfterStripeConfigured() {
        Login();
        transaction.getManualCharge();

    }

    @Test(description = "TRS5 (b): Verify that store manager is able to charge a customer when terminal is configured for a store.")
    public void newChargerWithTerminal() {
        Login();
        transaction.getTerminalcharge();

    }
    @Test(description = "TRS 5 (c): Verify that the store manager can manually do new charge payment, after cancelling the terminal automatic payment deduction process, on 'Transaction' page.")
    public void newChargePaymentManuallyAfterCancelingTerminalAutomaticPaymentDeduction() {
        Login();
        transaction.getManualChargeAfterCancelingTerminal();
    }

    @Test(description = "TRS6 Verify that 'Transaction details' popup opens up after clicking on any transaction of 'Transaction' page.")
    public void verifyThatElementsOfTransactionDetailsPopup() {
        Login();
        transaction.getAllElementsOfTransactionsPopup();
    }


    @Test(description = "TRS7 (a): Verify that store manager is able to refund full transaction on 'Transaction details' popup of 'Transaction' page.")
    public void verifyRefundFullTransactionOnTransactionPage() {
        transaction.getFullRefund();
    }

    @Test(description = "TRS7 (b): Verify that store manager is able to refund partial transaction on 'Transaction details' popup of 'Transaction' page.")
    public void verifyThatStoreMangerIsAbleToRefundPartialPayment() {
        transaction.getPartialRefund();

    }

    @Test(description = "TRS8 Verify that store manager is able to verify the transactions on 'Transaction details' popup of 'Transaction' page.")
    public void verifyThatStoreMangerIsAbleToVerifyTransaction() {
        Login();
        transaction.verifyTheTransaction();
    }

    @Test(description = " TRS 12 Verify that Question mark icon gets removed, when store manager manually marked the payment as 'Captured'.")
    public void verifyQuestionmarkIconRemovedWhenStoreManagerManuallyMarkedPaymentAsCaptured() {
        transaction.getQuestionMarkIcon();
    }

    @Test(description = "TRS 09Verify that store manager is able to filter the transaction on 'Transactions' page.")
    public void verifyThatTransactionListAppears() {

    }




}

