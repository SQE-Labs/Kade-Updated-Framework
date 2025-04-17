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


    @Test(description = " PH01 : Verify that user get directed to 'Payment History' page, after clicking on 'Payment History' tab")
    public void verifyUserDirectedToPaymentHistoryPageAfterClickingOnPaymentHistoryTab() {
        pay.VerifyPaymentHistoryPage();
    }



    @Test(description = " PH02 : Verify that appropriate message displayed after clicking on Payment History Tab when no payments are made")
    public void verifyMessageDisplayedWhenNoPaymentsAreMade() {

        pay.VerifyPageNoPayments();
    }


    @Test(description = "PH03 , PH04 : Verify that records get updated everytime on 'Payment History' page when user make any transactions")
    public void verifyRecordsGetUpdatedAfterMakingTransaction() throws IOException, UnsupportedFlavorException {

        bills.verifyCreateBillForSuggestedCustomer("Saybo@yopmail.com");
        pay.getsignout();
        pay.VerifytheTransaction();
    }


    @Test(description = " PH05 : Verify that appropriate details appears on 'Payments' tiles, on 'Payment History'  page.")
    public void verifyRequiredDetailsTransaction() throws IOException, UnsupportedFlavorException {
        pay.VerifytheDetails();
    }


    @Test(description = " PH06 : Verify that user get directed to '<REF- No>' page i.e Bill detail page, after clicking on any payment, on 'Payment History' page.")
    public void VerifyUserNavigateToBillDetailPage() throws IOException, UnsupportedFlavorException {
        pay.VerifyNavigationToBillpage();
    }

    @Test(description = "PH07 : Verify that 'Partially Paid' label appears and left amount can be paid using 'Make payments' button on 'Transaction Detail' Page")
    public void VerifyPartiallyPaidLabelOnTransactionDetailPage(){
        bills.verifyCreateBillForSuggestedCustomer("Saybo@yopmail.com");
        pay.getsignout();
        pay.VerifyPartiallypaidamount();


    }
}