package qa.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.BillPage;
import pageEvents.PaymentHistoryPage;
import pageEvents.SearchPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class PaymentHistoryTest extends BaseTest {


    PaymentHistoryPage pay = new PaymentHistoryPage();
    BillPage bills = new BillPage();


    @Test(priority = 1, description = " PH01 : Verify that user get directed to 'Payment History' page, after clicking on 'Payment History' tab")
    public void verifyUserDirectedToPaymentHistoryPageAfterClickingOnPaymentHistoryTab() {
        pay.VerifyPaymentHistoryPage();
    }



    @Test(priority = 2,description = " PH02 : Verify that appropriate message displayed after clicking on Payment History Tab when no payments are made")
    public void verifyMessageDisplayedWhenNoPaymentsAreMade() {
        pay.VerifyPageNoPayments();
    }


    @Test(priority = 3,description = "PH03 , PH04 : Verify that records get updated everytime on 'Payment History' page when user make any transactions")
    public void verifyRecordsGetUpdatedAfterMakingTransaction()  {

        bills.verifyCreateBillForSuggestedCustomer("alexnew@yopmail.com");
        pay.getsignout();
        pay.VerifytheTransaction();
    }


    @Test(priority = 4,description = " PH05 : Verify that appropriate details appears on 'Payments' tiles, on 'Payment History'  page.")
    public void verifyRequiredDetailsTransaction()   {
        pay.VerifytheDetails();
    }


    @Test(priority = 5,description = " PH06 : Verify that user get directed to '<REF- No>' page i.e Bill detail page, after clicking on any payment, on 'Payment History' page.")
    public void VerifyUserNavigateToBillDetailPage()   {
        pay.VerifyNavigationToBillpage();
    }

    @Test(priority = 6,description = "PH07 : Verify that 'Partially Paid' label appears and left amount can be paid using 'Make payments' button on 'Transaction Detail' Page")
    public void VerifyPartiallyPaidLabelOnTransactionDetailPage(){
        bills.verifyCreateBillForSuggestedCustomer("alexnew@yopmail.com");
        pay.getsignout();
        pay.VerifyPartiallypaidamount();
    }
}