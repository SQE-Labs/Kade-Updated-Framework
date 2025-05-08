package qa.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.BillPage;
import pageEvents.PaymentHistoryPage;
import pageEvents.PaymentPage;

import java.awt.*;


public class PaymentsAndRefundTest extends BaseTest {
    BillPage bill = new BillPage();
    PaymentPage payment = new PaymentPage();
    PaymentHistoryPage pay = new PaymentHistoryPage();


    @Test(priority = 0, enabled = true, description = "PYMT1 Bill Creation and Successful Bill Payment by Cash through Store Manager.")
    public void cashPaymentThroughStoreManager() {

        bill.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        payment.paymentPopup("Enter Bill Amount");
    }

    @Test(priority = 1, enabled = true, description = "PYMT2 : Bill Creation and Successful Bill Payment by Credit Card through Store manager.")
    public void cardPaymentThroughStoreManager() {
        bill.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        payment.paymentByCreditCard("4111111111111111", "0930", "794", "Australia");

    }

    @Test(priority = 2, enabled = true, description = "PYMT3 : Bill Creation and Successful Bill Payment by Venmo through Store manager.")
    public void payByVenmoThroughStoreManager() {

        bill.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        payment.paymentThroughVenomo();

    }

    @Test(priority = 3, enabled = true, description = "PYMT4 : Bill Creation and Successful Bill Payment by Zelle through Store manager.")
    public void payByZelleThroughStoreManager() {
        bill.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        payment.paymentThroughZelle();
    }

    @Test(priority = 4, enabled = true, description = "PYMT6 : Bill Creation and pay the bill by multiple payment mode through Store manager.")
    public void verifyPaymentByMultipleModeThroughStoreManager() {

        bill.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        payment.PaymentByMultipleMode("500.00", "500.00", "1000.00");

    }

    @Test(priority = 5, enabled = true, description = "PYMT5 : Bill Creation and partial payment of the bill through Store manager.")
    public void partialPaymentThroughStoreManager() {

        bill.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        payment.partialPayment("1500.00");
    }

    @Test(priority = 6, enabled = true, description = "PYMT7 : Bill Creation and mark payment as Void by Store manager.")
    public void markSuccessfulPaymentAsVoid() {

        bill.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bill.clickOnNotPaidLabel();
        payment.markSuccessfulPaymentAsVoid("Paying Bill");
    }

    @Test(priority = 7, enabled = true, description = "PYMT8 : Bill Creation and Successful Bill Payment through Credit Card by Customer.")
    public void BillPaymentByCreditCardThroughCustomer() {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.billPaymentByThroughDebitCard("4111111111111111", "0930", "794", "Australia");
        payment.swipeCard();
        payment.billPayment();
    }


    @Test(priority = 8, enabled = true, description = "PYMT9 : Bill Creation and Successful Bill Payment through Bank account by Customer.")
    public void BillPaymentByCustomerThroughBankAccount() {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.paymentThrouhBankAccount();
        payment.swipeCard();
        payment.billPayment();
    }

    @Test(priority = 9, enabled = true, description = "PYMT10 :Create Bill and Pay Bills Partially/Multiple payment type")
    public void BillPaymentByVariousPaymentMethods() {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.billPaymentByVariousPaymentMethods("500.00", "4111111111111111", "0930", "794", "Australia");
        payment.swipeCard();
        payment.clickOnchangeBtn();
        staticWait(2000);
        payment.clickOnZelleAccount();
        payment.clickOnMakePaymentBtn();
        payment.clickOnCheckBox();
        payment.zelleSaveBtn();
        payment.billPayment();
    }

    @Test(priority = 10, enabled = true, description = "Create Bill for a customer and pay using Venmo.")
    public void CreateBillForCustomerPayUsingVenmo() {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.paymentThrouhVenmoAccount();
    }


    @Test(priority = 11, enabled = true, description = "PYMT15 : Create Bill for a customer and pay using Zelle.")
    public void CreateBillForCustomerAndPayUsingZelle() throws AWTException {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.paymentByZelleAccount();
    }

    @Test(priority = 12, enabled = true, description = "PYMT12:Bill Payment by Customer through Credit Card, Pay more amount after paying full bill")
    public void RejectingTheBillByCustomer() {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.RejectABill();
    }
    @Test(priority = 13, enabled = true, description = "PYMT16 Creating bill for customer and pay through affrim payment method.")
    public void verifyCreatingBillForCustomerPayThroughAffirmPayment(){
        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.billPaymentThroughAffirmMethod();
        payment.billPayment();
        System.out.println("Payment Details is" + getText(payment.paymentDetails));
        payment.getPayemntDetails();
    }

}
