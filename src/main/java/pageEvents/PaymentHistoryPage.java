package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.Constants;

public class PaymentHistoryPage extends BaseTest {
    BillPage bills = new BillPage();

    private static final Logger log = LoggerFactory.getLogger(PaymentHistoryPage.class);
    //Locators
    public By PaymentHistoryTitle = By.cssSelector(".header-title");
    By NoPaymentMessage = By.cssSelector("div[class= 'card'] div p");
    By BillIdCustomer = By.xpath("(//div[@class='mb-1']/span)[1]");
    By CopyBillIdCustomer = By.xpath("(//div[@class='col-7']/div/span)[1]");
    public By transactionsButton = By.xpath("//div[@class='text-nowrap'and contains(text(),'Transactions')]");
    public By Mystuff = By.xpath("//a[normalize-space()='My Stuff']");
    public By paymenthistory = By.xpath("//div[normalize-space()='Payment History']");
    public By payNowButton = By.xpath("//button[@type=\"button\" and text()='Pay Now']");
    By notificationIcon= By.xpath("//a[@data-bs-toggle='dropdown']");
    By firstNotification = By.xpath("(//div[@class='list-group']/a)[1]");


    public void getmystuffandpaymenthistory() {
        click(Mystuff);
        click(paymenthistory);
    }

    public String getpagetitle() {
        String pagetitle = getText(PaymentHistoryTitle);
        return pagetitle;
    }

    public String getNopaymentMessage() {
        String Message = getText(NoPaymentMessage);
        return Message;
    }

    public void VerifyPaymentHistoryPage() {
        Login();
        scrollToElement(Mystuff);
        getmystuffandpaymenthistory();
        staticWait(2000);
        Assert.assertEquals(getpagetitle(), Constants.PaymentHistoryTitle);
        log.info("User is successfully navigated to payment history page");

    }

    public void VerifyPageNoPayments() {
        LoginAsNewUser();
        scrollToElement(Mystuff);
        getmystuffandpaymenthistory();
        staticWait(2000);
        Assert.assertEquals(getNopaymentMessage(), Constants.NoPaymentsMessage);
        log.info("User can see a message on payment history page");
    }
    public void getNotificationIcon(){
        click(notificationIcon);
    }
    public void getFirstNotification(){
        click(firstNotification);

    }
    public void getPaynowBtn(){
        waitForElementToBeClickable(payNowButton,2);
        click(payNowButton);
    }

    public void VerifytheTransaction() {
        LoginAsCustomer();
        getNotificationIcon();
        getFirstNotification();
        staticWait(2000);
        getPaynowBtn();
        getmystuffandpaymenthistory();
        scrollToElement(Mystuff);
        clickAndHoldElement();

    }





}