package qa.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.BillPage;
import pageEvents.PaymentPage;


public class PaymentsAndRefundTest extends BaseTest {
    BillPage bill = new BillPage();
    PaymentPage payment = new PaymentPage();


    @Test(priority = 0, enabled = true, description = "PYMT1 Bill Creation and Successful Bill Payment by Cash through Store Manager.")
    public void cashPaymentThroughStoreManager() {

        bill.createBillWithCustomer("636045278965","Saybo@yopmail.com");
        payment.paymentPopup("Enter Bill Amount");

    }

    @Test(priority = 1, enabled = true, description = "PYMT2 : Bill Creation and Successful Bill Payment by Credit Card through Store manager.")
    public void cardPaymentThroughStoreManager() {
        bill.createBillWithCustomer("636045278965","Saybo@yopmail.com");
        payment.paymentByCreditCard("4111111111111111", "0930", "794", "Australia");

    }

    @Test(priority = 2, enabled = true, description = "PYMT3 : Bill Creation and Successful Bill Payment by Venmo through Store manager.")
    public void payByVenmoThroughStoreManager() {

        bill.createBillWithCustomer("636045278965","Saybo@yopmail.com");
        payment.paymentThroughVenomo();

    }

    @Test(priority = 3, enabled = true, description = "PYMT4 : Bill Creation and Successful Bill Payment by Zelle through Store manager.")
    public void payByZelleThroughStoreManager() {
        bill.createBillWithCustomer("636045278965","Saybo@yopmail.com");

        payment.paymentThroughZelle();
    }

    @Test(priority = 4, enabled = true, description = "PYMT6 : Bill Creation and pay the bill by multiple payment mode through Store manager.")
    public void verifyPaymentByMultipleModeThroughStoreManager() {

        bill.createBillWithCustomer("636045278965","Saybo@yopmail.com");

        payment.PaymentByMultipleMode("500.00", "500.00", "1000.00");

    }

    @Test(priority = 5, enabled = true, description = "PYMT5 : Bill Creation and partial payment of the bill through Store manager.")
    public void partialPaymentThroughStoreManager() {

        bill.createBillWithCustomer("636045278965","Saybo@yopmail.com");
        payment.partialPayment("1500.00");
    }

    @Test(priority = 6, enabled = true, description = "PYMT7 : Bill Creation and mark payment as Void by Store manager.")
    public void markSuccessfulPaymentAsVoid() {

        bill.createBillWithCustomer("636045278965","Saybo@yopmail.com");
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

    @Test(priority = 9, enabled = true,description = "PYMT10 :Create Bill and Pay Bills Partially/Multiple payment type")
    public void BillPaymentByVariousPaymentMethods() {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.billPaymentByVariousPaymentMethods("500.00", "4111111111111111", "0930", "794", "Australia");
        payment.swipeCard();
        payment.paymentByZelleAccount();
    }

    @Test(priority = 10, enabled = true,description = "PYMT13 : Create Bill for a customer and pay using Venmo.")
    public void CreateBillForCustomerPayUsingVenmo ()  {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.paymentThrouhVenmoAccount();








//        KadeSession session = KadeSession.login(KadeUserAccount.Default);
//
//        //Step 1: Click on 'Bill' sub-Tab
//        session.getSidePannel().getBillButton().click();
//
//        //Step 2: Enter Amount
//        String amt = "4999.00";
//
//        //Step 3: Enter Customer Email
//        String customerEmail = "yonro@yopmail.com";
//        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
//
//        //Step 4: Create Bill
//        session.getBillPage().createBill(bills);
//        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);
//
//        //Step 5: Logout as Store manager
//        session.getSidePannel().getSignOutButton().click();
//
//        //Step 6: Login as Customer
//        session.getLoginPage().performSignIn(customerEmail, "Test@123");
//
//        //Step 7: Click on Notification icon
//        session.getNotificationPage().getNotificationIcon().click();
//
//        //Step 8: click on first notification
//        session.getNotificationPage().getFirstNotification().click();
//
//        //Step 9: click 'pay now' button
//        session.getPaymentsPage().getPayNowButton().click();
//
//        //Step 10: Click on 'Change Payment' Button
//        session.getPaymentsPage().getChangePaymentMethodButton().clickbyJS();
//        WebdriverWaits.sleep(2000);
//        //Step 11:  Selecting Venmo Card
//        session.getPaymentsPage().getSavedVenmoCard().clickByMouse();
//        //Verifying that Venmo PopUp is displayed
//        Assertions.assertTrue(session.getPaymentsPage().getVenmoPopup().isDisplayed());
//
//        //Verifying that Copy link is visible
//        Assertions.assertTrue(session.getPaymentsPage().getCopyLink().isDisplayed());
//
//        //Verifying that 'Made my Payment' button is visible
//        Assertions.assertTrue(session.getPaymentsPage().getIMadeMyPaymentButton().isDisplayed());
//
//        //Step 12: Click on 'Made my Payment' Button
//        session.getPaymentsPage().getIMadeMyPaymentButton().clickbyJS();
//
//        //Verifying that Venmo Payment Text is displayed
//        Assertions.assertTrue(session.getPaymentsPage().getVenmoPaymentText().isDisplayed());
//
//        //Step 13: Enter Text
//        session.getPaymentsPage().getVenmoPaymentText().setText("Paid the bill");
//
//        //Verify that Screenshot button is Displayed
//        Assertions.assertTrue(session.getPaymentsPage().getScreenshotButton().isDisplayed());
//
//        //Step 14: Upload Screenshot
//        session.getPaymentsPage().getScreenshotButton ().click();
//        WebdriverWaits.sleep(1000);
//        session.getPaymentsPage().uploadVenmoImageScreenshot();
//        session.getPaymentsPage().getCheckButton().click();
//
//        //Verify that attached image is displayed
//        Assertions.assertTrue(session.getPaymentsPage().getUploadedImage().isDisplayed());
//        WebdriverWaits.sleep(2000);
//
//        //Step 15: Click on 'Confirm Venmo' Checkbox
//        session.getPaymentsPage().getConfirmVenmoCheckbox().click();
//
//        //Step 16: Click on 'Submit' Button
//        session.getPaymentsPage().getVenmoSubmitButton().click();
//
//        //Step 17: Click on 'Close' Icon
//        session.getPaymentsPage().getCloseButton().clickbyJS();
    }

//    @Test(description = "PYMT15 : Create Bill for a customer and pay using Zelle.")
//    public void CreateBillForCustomerAndPayUsingZelle() throws AWTException {
//        KadeSession session = KadeSession.login(KadeUserAccount.Default);
//        session.getSidePannel().getBillButton().click();
//
//        String amt = "4,999.00";
//        String customerEmail = "yonro@yopmail.com";
//        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
//
//        //Creating Bill
//        session.getBillPage().createBill(bills);
//        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true, 2);
//
//        //Logout as Store manager
//        session.getSidePannel().getSignOutButton().click(); // Signing out
//        WebdriverWaits.sleep(3000);
//
//        //Login as Customer
//        session.getLoginPage().performSignIn(customerEmail, "Test@123");
//        session.getNotificationPage().getNotificationIcon().click(); // Click on Notification icon
//        session.getNotificationPage().getFirstNotification().click(); // click on first bill notification
//        session.getPaymentsPage().getPayNowButton().click(); // click paynow button
//        session.getPaymentsPage().getChangePaymentMethodButton().clickbyJS();
//        WebdriverWaits.sleep(3000);
//        session.getPaymentsPage().getSavedZelleCard().clickbyJS();
//        WebdriverWaits.sleep(3000);
//        Assertions.assertTrue(session.getPaymentsPage().getZellePopup().isDisplayed());
//        Assertions.assertTrue(session.getPaymentsPage().getZelleCopyLink().isDisplayed());
//        session.getPaymentsPage().getIMadeMyPaymentButton().click();
//        Assertions.assertTrue(session.getPaymentsPage().getVenmoPaymentText().isDisplayed());
//
//        //Step 13: Enter Text
//        session.getPaymentsPage().getVenmoPaymentText().setText("Paid the bill");
//
//        //Verify that Screenshot button is Displayed
//        Assertions.assertTrue(session.getPaymentsPage().getScreenshotButton().isDisplayed());
//
//        //Step 14: Upload Screenshot
//        session.getPaymentsPage().getScreenshotButton ().click();
//        session.getPaymentsPage().uploadVenmoImageScreenshot();
//        session.getPaymentsPage().getCheckButton().clickbyJS();
//
//        //Verify that attached image is displayed
//        Assertions.assertTrue(session.getPaymentsPage().getUploadedImage().isDisplayed());
//        WebdriverWaits.sleep(2000);
//
//        //Step 15: Click on 'Confirm Venmo' Checkbox
//        session.getPaymentsPage().getConfirmVenmoCheckbox().click();
//
//        //Step 16: Click on 'Submit' Button
//        session.getPaymentsPage().getVenmoSubmitButton().click();
//        WebdriverWaits.sleep(3000);
//
//        //Step 17: Click on 'Close' Icon
//        session.getPaymentsPage().getCloseButton().clickbyJS();
//    }
//
//   /* @Test(description="PYMT12:Bill Payment by Customer through Credit Card, Pay more amount after paying full bill")
//    public void BillPaymentByCustomerThroughCreditCardPayMoreAmountAfterFullBillPayment() throws InterruptedException {
//        KadeSession session = KadeSession.login(KadeUserAccount.Default);
//
//        //Step 1: Click on 'Bill' sub-Tab
//        session.getDashBoardPage().getBillButton().click();
//
//        //Step 2: Enter Amount
//        String amt = "500.00";
//
//        //Step 3: Enter Customer Email
//        String customerEmail ="yonro@yopmail.com" ;
//        BillsPage bills = ObjectBuilder.BillDetails.getDefaultBillDetails().setAmount(amt).setCustomerEmail(customerEmail);
//
//        //Step 4: Create Bill
//        session.getBillPage().createBill(bills);
//        session.getBillPage().getCloseLogoPopupBtn().clickIfExist(true,2);
//
//        //Step 5: Logout as Store manager
//        session.getDashBoardPage().getSignOutButton().click();
//
//        //Step 6: Login as Customer
//        session.getLoginPage().performSignIn(customerEmail, "Test@123");
//
//        //Step 7: Click on 'Notification' icon
//        session.getNotificationPage().getNotificationIcon().click();
//
//        //Step 8: Click on first Notification
//        session.getNotificationPage().getFirstNotification().click();
//
//        //Step 9: Click on 'Pay Now' Button
//        session.getPaymentsPage().getPayNowButton().click();
//
//        //Step 10: Click on 'Change' Button
//        session.getPaymentsPage().getChangePaymentMethodButton().click();
//
//        //Step 11: Select Credit Card
//        session.getPaymentsPage().getSavedCreditCard().click();
//
//        //Step 12: Swipe To Pay Full Amount
//        session.getPaymentsPage().swipeToPay();
//        session.getPaymentsPage().scrollToBottomPage();
//
//        //Step 13: Close the Pop-up
//        session.getPaymentsPage().getBlueCloseButton().clickbyJS();
//
//        //Step 14: Click on 'Notification' icon
//        session.getNotificationPage().getNotificationIcon().click();
//
//        //Step 15: Click on First Notification
//        session.getNotificationPage().getFirstNotification().click();
//
//        //Step 16: Click on 'Pay Now' Button
//        session.getPaymentsPage().getPayNowButton().click();
//        session.getPaymentsPage().scrollToBottomPage();
//        WebdriverWaits.sleep(5000);
//
//        //Step 17: Click on 'Tap to Pay More' link
//        session.getPaymentsPage().getTapToPayMoreLink().clickbyJS();
//
//        //Step 18: Click on 'Swipe to Pay' field
//        session.getPaymentsPage().getSwipeToPayButton().clickbyJS();
//
//        //Step 19: Enter Amount
//        session.getPaymentsPage().getMoreAmountField().setText("100.00");
//
//        //Step 20: Click on 'Update' Button
//        session.getPaymentsPage().getAmountUpdateButton().click();
//
//        //Step 21: Swipe to Pay more Amount
//        session.getPaymentsPage().swipeToPay();
//
//        //Step 22: Click on 'Close' button
//        session.getPaymentsPage().getBlueCloseButton().clickbyJS();
//    }
//
//    */

}
