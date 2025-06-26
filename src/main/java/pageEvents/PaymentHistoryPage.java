package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

import static pageEvents.LoginPage.*;

public class PaymentHistoryPage extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(PaymentHistoryPage.class);
    //Locators
    By paymentHistoryTitle = By.cssSelector(".header-title");
    By noPaymentMessage = By.cssSelector("div[class= 'card'] div p");
    By BillIdCustomer = By.xpath("(//div[@class='mb-1']/span)[1]");
    By CopyBillIdCustomer = By.xpath("(//div[@class='col-7']/div/span)[1]");
    By transactionsButton = By.xpath("//div[@class='text-nowrap'and contains(text(),'Transactions')]");
    By mystuff = By.xpath("//a[normalize-space()='My Stuff']");
    By paymenthistory = By.xpath("//div[normalize-space()='Payment History']");
    By payNowButton = By.xpath("//button[@type=\"button\" and text()='Pay Now']");
    By notificationIcon = By.xpath("//a[@data-bs-toggle='dropdown']");
    By firstNotification = By.xpath("(//div[@class='list-group']/a)[1]");
    By custPaymentBtn = By.xpath("//Button[@name='applyAmount' and @value='-1']");
    By transBillId = By.xpath("(//span[contains(@class, 'badge')])[1]");
    By closeBtn = By.xpath("//a[normalize-space()='Close']");
    By paymentId = By.xpath("//div[contains(@class, 'bg-white mb-2')][1]//span[contains(@class, 'badge position-relative')]");
    By signoutBtn = By.xpath("//a[normalize-space()='Sign out']");
    By paymentPrice = By.xpath("//div[@class='d-flex align-items-end']");
    By storeName = By.xpath("(//div[contains(@class,'bg-white')])[1]//div[contains(@class,'text-truncate')]");
    By storeImg = By.xpath("(//div[contains(@class,'d-flex align-items-center')])[1]//img");
    By paymentMethod = By.xpath("(//div[contains(@class,'flex-row-reverse')])[1]");
    By paymentTime = By.xpath("(//div[@class='text-muted fs-pn25'])[1]");
    By transacrtionDetailPage = By.xpath("//h1[normalize-space()='Transaction Detail']");
    By transPageId = By.xpath("//span[contains(@class,'text-truncate flex-shrink-0')]");
    By paymentTile = By.xpath("(//div[contains(@class, 'bg-white')]/descendant::a[contains(@href, '/Bills')])[1]");
    By paymentTiles = By.xpath("//div[contains(@class, 'p-1 p-sm-2') and contains(@class, 'rounded')][1]");
    By updateAmount = By.xpath("//a[@class='stretched-link position-absolute h-100 -updateamount-']");
    By amountText = By.xpath("//input[@lbl-title='Amount']");
    By updateBtn = By.xpath("//input[@name='amount']//following::button[@type='submit' and normalize-space()='Update'][2]");
    By currentBalanceBtn = By.xpath("//button[contains(text(), 'selected bill')]");
    By makePaymentsBtn = By.xpath("//button[normalize-space()='Make payments']");
    By paymentTileRecord = By.xpath("//div[@class='d-flex px-2 justify-content-between']");
    By payCurrentBalance = By.xpath("//button[text()='Pay the current balance']/..");
    By CustomPayBalance = By.xpath("//input[@name='applyAmount']");
    By makePaymentBtns = By.xpath("//button[text()='Make payments']");
    By paymentBtn = By.xpath("//button[text()='Process Payment']");
    By swipeBtn = By.xpath("//input[@class='slider -pm-none-']");


    public void getMyStuffandPaymentHistory() {
        clickElementByJS(mystuff);
        clickElementByJS(paymenthistory);
    }

    public String getpagetitle() {
        String pagetitle = getText(paymentHistoryTitle);
        return pagetitle;
    }

    public String getNopaymentMessage() {
        String Message = getText(noPaymentMessage);
        return Message;
    }

    public void VerifyPaymentHistoryPage() {
        Login();
        scrollToElement(mystuff);
        getMyStuffandPaymentHistory();
        staticWait(2000);
        Assert.assertEquals(getpagetitle(), Constants.PaymentHistoryTitle);
        log.info("User is successfully navigated to payment history page");

    }

    public void VerifyPageNoPayments() {
        LoginAsNewUser1();
        scrollToElement(mystuff);
        getMyStuffandPaymentHistory();
        staticWait(2000);
        Assert.assertEquals(getNopaymentMessage(), Constants.NoPaymentsMessage);
        log.info("User can see a message on payment history page");
    }

    public void getNotificationIcon() {
        click(notificationIcon);
    }

    public void getFirstNotification() {
        click(firstNotification);

    }

    public void getPaynowBtn() {
        waitForElementToBeClickable(payNowButton, 2);
        click(payNowButton);
    }

    public void getPayBalance() {
        waitForElementToBeClickable(custPaymentBtn, 2);
        clickElementByJS(custPaymentBtn);
    }

    public String getTransId() {
        waitForElementToBeVisible(transBillId, 10);
        return getText(transBillId);
    }

    public String getPaymentId() {
        waitForElementToBeVisible(paymentId, 5);
        return getText(paymentId);
    }

    public void getCloseBtn() {
        clickElementByJS(closeBtn);
    }

    public void getsignout() {
        clickElementByJS(signoutBtn);

    }

    public void getUpdateAmount() {
        clickElementByJS(updateAmount);
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
        swipeToPay();
        waitForElementToBeClickable(closeBtn, 3);
        getCloseBtn();
        scrollToElement(mystuff);
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

    public void getTransactionPage() {
        waitForElementInVisible(paymentTile, 3);
        scrollToElement(paymentTile);
        click(paymentTiles);
    }

    public void swipeToPay() {
        staticWait(10000);
        Actions actions = new Actions(getDriver());
        WebElement elm = getDriver().findElement(swipeBtn);
        //  scrollToElement(swipeBtn);
        actions.moveToElement(elm).moveByOffset(-100, 0).clickAndHold().moveByOffset(200, 0).release().perform();
    }

    public void makePaymentBtn() {
        scrollToElement(makePaymentBtns);
        click(makePaymentBtns);
    }

    public void clickOnPaymentBtn() {
        scrollToElement(paymentBtn);
        click(paymentBtn);
    }


    public String getTransPageId() {
        return getText(transPageId);
    }

    public void VerifytheDetails() {
        LoginAsCustomer();
        scrollToElement(mystuff);
        getMyStuffandPaymentHistory();
        staticWait(2000);
        softAssert.assertTrue(isElementDisplayed(paymentId));
        softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(storeImg));
        softAssert.assertTrue(isElementDisplayed(paymentPrice));
        softAssert.assertTrue(isElementDisplayed(paymentMethod));
        softAssert.assertTrue(isElementDisplayed(paymentTime));

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
        Assert.assertTrue(isElementDisplayed(transacrtionDetailPage));
        staticWait(2000);
        String TransPageID = getText(transPageId);
        Assert.assertEquals(PaymentID, TransPageID);


    }

    public void VerifyPartiallypaidamount() {
        LoginAsCustomer();
        getNotificationIcon();
        getFirstNotification();
        staticWait(2000);
        getPaynowBtn();
        if (isElementDisplayed(payCurrentBalance)) {
            actionEnterText(currentBalanceBtn, "200");
            //  clickElementByJS(payNowBtns);

            // pays.swipeToPay();
            //getDriver().navigate().back();
            scrollToElement(updateAmount);
            waitForElementToBeClickable(updateAmount, 3);
            getUpdateAmount();
            staticWait(5000);
            clickElementByJS(amountText);
            staticWait(2000);
            actionEnterText(amountText, "200");
            staticWait(5000);
            clickElementByJS(updateBtn);
            swipeToPay();
            staticWait(3000);
            getDriver().navigate().back();
        } else {
            Log.info("Nothing to be selected");
            scrollToElement(updateAmount);
            waitForElementToBeClickable(updateAmount, 3);
            getUpdateAmount();
            staticWait(5000);
            clickElementByJS(amountText);
            staticWait(2000);
            actionEnterText(amountText, "5000");
            staticWait(5000);
            clickElementByJS(updateBtn);
            swipeToPay();
        }
        staticWait(3000);
        getDriver().navigate().to("https://sibtestenv.azurewebsites.net/Users/transactions");
        staticWait(3000);
        scrollToElement(mystuff);
        getMyStuffandPaymentHistory();
        staticWait(2000);
        getTransactionPage();
        makePaymentBtn();
        swipeToPay();
    }

}