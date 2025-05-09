package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class PaymentHistoryPage extends BaseTest {
    BillPage bills = new BillPage();
    PaymentPage pays =new PaymentPage();

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
    public By notificationIcon= By.xpath("//a[@data-bs-toggle='dropdown']");
    public By firstNotification = By.xpath("(//div[@class='list-group']/a)[1]");
    public By CustPaymentBtn = By.xpath("//Button[@name='applyAmount' and @value='-1']");
    public By TransBillId = By.xpath("(//span[contains(@class, 'badge')])[1]");
    public By CloseBtn = By.xpath("//a[normalize-space()='Close']");
    public By paymentId =By.xpath("//div[contains(@class, 'bg-white mb-2')][1]//span[contains(@class, 'badge position-relative')]");
    public By SignoutBtn = By.xpath("//a[normalize-space()='Sign out']");
    public By PaymentPrice = By.xpath("//div[@class='d-flex align-items-end']");
    public By StoreName = By.xpath("(//div[contains(@class,'bg-white')])[1]//div[contains(@class,'text-truncate')]");
    public By StoreImg = By.xpath("(//div[contains(@class,'d-flex align-items-center')])[1]//img");
    public By PaymentMethod= By.xpath("(//div[contains(@class,'flex-row-reverse')])[1]");
    public By PaymentTime = By.xpath("(//div[@class='text-muted fs-pn25'])[1]");
    public By TransacrtionDetailPage = By.xpath("//h1[normalize-space()='Transaction Detail']");
    public By transPageId = By.xpath("//span[contains(@class,'text-truncate flex-shrink-0')]");
    public By PaymentTile= By.xpath("(//div[contains(@class, 'bg-white')]/descendant::a[contains(@href, '/Bills')])[1]");
    public By PaymentTiles= By.xpath("//div[contains(@class, 'p-1 p-sm-2') and contains(@class, 'rounded')][1]");
    public By UpdateAmount = By.xpath("//a[@class='stretched-link position-absolute h-100 -updateamount-']");
    public By AmountText = By.xpath("//input[@lbl-title='Amount']");
    public By UpdateBtn = By.xpath("//input[@name='amount']//following::button[@type='submit' and normalize-space()='Update'][2]");
    public By CurrentBalanceBtn =By.xpath("//button[contains(text(), 'selected bill')]");
    public By MakePaymentsBtn = By.xpath("//button[normalize-space()='Make payments']");
    public By paymentTileRecord = By.xpath("//div[@class='d-flex px-2 justify-content-between']");
    By payCurrentBalance=By.xpath("//button[text()='Pay the current balance']/..");
    By CustomPayBalance =By.xpath("//input[@name='applyAmount']");
    By payNowBtns = By.xpath("//button[normalize-space()='Pay now']");


    public void getMyStuffandPaymentHistory() {
        clickElementByJS(Mystuff);
        clickElementByJS(paymenthistory);
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
        getMyStuffandPaymentHistory();
        staticWait(2000);
        Assert.assertEquals(getpagetitle(), Constants.PaymentHistoryTitle);
        log.info("User is successfully navigated to payment history page");

    }

    public void VerifyPageNoPayments() {
        LoginAsNewUser();
        scrollToElement(Mystuff);
        getMyStuffandPaymentHistory();
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
    public void getPayBalance(){
        waitForElementToBeClickable(CustPaymentBtn,2);
        clickElementByJS(CustPaymentBtn);
    }
    public String getTransId(){
        waitForElementToBeVisible(TransBillId,10);
        return getText(TransBillId);
    }
    public String getPaymentId(){
        waitForElementToBeVisible(paymentId,5);return getText(paymentId);
    }
    public void getCloseBtn(){
        clickElementByJS(CloseBtn);
    }
    public void getsignout(){
        clickElementByJS(SignoutBtn);

    }
    public void getUpdateAmount(){
        clickElementByJS(UpdateAmount);
    }

    public void VerifytheTransaction() {
        LoginAsCustomer();
        getNotificationIcon();
        getFirstNotification();
        staticWait(2000);
        getPaynowBtn();
        if (isElementDisplayed(payCurrentBalance)) {
            getPayBalance();
        } else {
            Log.info("Nothing to be selected");
        }

        getTransId();
        pays.swipeToPay();
        waitForElementToBeClickable(CloseBtn, 3);
        getCloseBtn();
        scrollToElement(Mystuff);
        getMyStuffandPaymentHistory();
        getPaymentId();
        int count = getCountOfWebElements(paymentTileRecord);
        System.out.println("Count of the transaction " + count);
        List<WebElement> allBills = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        int previousCount = 0;

        while (true) {
            // Scroll to bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for the new elements to load (you can customize this with ExpectedConditions)
            staticWait(2000); // Can be replaced with WebDriverWait for stability

            // Re-fetch the list after scroll
            List<WebElement> currentBills = getDriver().findElements(paymentTileRecord);

            int currentCount = currentBills.size();
            System.out.println("Currently loaded bills: " + currentCount);

            if (currentCount == previousCount) {
                // No new bills loaded
                break;
            }

            previousCount = currentCount;
            allBills = currentBills;
        }
    }

    public void getTransactionPage(){
        waitForElementInVisible(PaymentTile,3);
        scrollToElement(PaymentTile);
        click(PaymentTiles);
    }

    public String getTransPageId(){
        return getText(transPageId);
    }

    public void VerifytheDetails() {
        LoginAsCustomer();
        scrollToElement(Mystuff);
        getMyStuffandPaymentHistory();
        staticWait(2000);
        softAssert.assertTrue(isElementDisplayed(paymentId));
        softAssert.assertTrue(isElementDisplayed(StoreName));
        softAssert.assertTrue(isElementDisplayed(StoreImg));
        softAssert.assertTrue(isElementDisplayed(PaymentPrice));
        softAssert.assertTrue(isElementDisplayed(PaymentMethod));
        softAssert.assertTrue(isElementDisplayed(PaymentTime));

        softAssert.assertAll();
        log.info("All are verified");
    }

    public void VerifyNavigationToBillpage() {
        LoginAsCustomer();
        getMyStuffandPaymentHistory();
        staticWait(5000);
        String PaymentID = getText(paymentId);
        getTransactionPage();
        staticWait(2000);
        Assert.assertTrue(isElementDisplayed(TransacrtionDetailPage));
        staticWait(2000);
        String TransPageID = getText(transPageId);
        Assert.assertEquals(PaymentID,TransPageID);


    }

    public void VerifyPartiallypaidamount(){
        LoginAsCustomer();
        getNotificationIcon();
        getFirstNotification();
        staticWait(2000);
        getPaynowBtn();
        if(isElementDisplayed(payCurrentBalance)){
            actionEnterText(CurrentBalanceBtn,"200");
          //  clickElementByJS(payNowBtns);

           // pays.swipeToPay();
            //getDriver().navigate().back();
            scrollToElement(UpdateAmount);
            waitForElementToBeClickable(UpdateAmount,3);
            getUpdateAmount();
            staticWait(5000);
            clickElementByJS(AmountText);
            staticWait(2000);
            actionEnterText(AmountText,"200");
            staticWait(5000);
            clickElementByJS(UpdateBtn);
            pays.swipeToPay();
            staticWait(3000);
            getDriver().navigate().back();
        }else{
            Log.info("Nothing to be selected");
            scrollToElement(UpdateAmount);
            waitForElementToBeClickable(UpdateAmount,3);
            getUpdateAmount();
            staticWait(5000);
            clickElementByJS(AmountText);
            staticWait(2000);
            actionEnterText(AmountText,"200");
            staticWait(5000);
            clickElementByJS(UpdateBtn);
            pays.swipeToPay();
            staticWait(3000);
            getDriver().navigate().to("https://sibtestenv.azurewebsites.net/Users/transactions");
        }

            scrollToElement(Mystuff);
            getMyStuffandPaymentHistory();
            staticWait(2000);
            getTransactionPage();

            clickElementByJS(MakePaymentsBtn);
            pays.swipeToPay();

    }

}