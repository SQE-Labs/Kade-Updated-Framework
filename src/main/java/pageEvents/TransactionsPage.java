package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;

import java.util.List;

public class TransactionsPage extends BaseTest {
    //Locators
    public By transactionRow = By.xpath("//div[contains(@class,'bg-white border')]");
    public By billAmount = By.xpath("//div[@class='display-6 fw-bold pt-2']");
    public By closeTransactionPopupBtn = By.xpath("(//button[@class='btn-close'])[1]");
    public By storesCombobox = By.xpath("//span[@role='combobox']");
    public By continueBtn = By.xpath("//button[@type='submit']");
    public By uniqueTransactionId = By.xpath("//span[@class='badge position-relative bg-light text-dark p-1 px-2 text-truncate flex-shrink-0']");
    public By transactionID = By.cssSelector(".badge.position-relative.bg-light.text-dark.p-1");
    public By store = By.xpath("//span[@class='fs-pn15 text-truncate']");
    public By payment = By.cssSelector(".fs-pn25.ms-2");
    public By customerName = By.cssSelector(".flex-column.overflow-hidden>a");
    public By transactionAmmount = By.xpath("//div[@class='d-flex align-items-center']");
    public By customNameONRecipt = By.xpath("//a[@class='text-truncate']");
    public By time = By.xpath("//span[@class='fs-pn25 mb-2 ms-auto']");
    public By informationMessage = By.xpath("//p[text()='There are no payments available yet!']");
    public By newBillTab = By.xpath("//div[@class='d-flex flex-wrap'] //button[1]");
    public By newChargeTab = By.xpath("//div[@class='d-flex flex-wrap'] //button[2]");
    public By filterIcon = By.xpath("//div[@class='d-flex flex-wrap'] //button[3]");
    public By terminalAlertMessage = By.xpath("(//div[@class='alert-message'])[2]");
    public By currentPaidBill = By.xpath("(//div[contains(@class, 'bg-white') and contains(@class, 'position-relative')])[1]");
    public By refundButton = By.cssSelector("[title='Refund']");
    public By refundRefenceNo = By.cssSelector("[name='refNo']");
    public By refundReason = By.cssSelector("[name='reason']");
    public By processFullRefund = By.cssSelector("[name='refundAll']");
    public By refundAmountOnReceipt = By.cssSelector("[class=\"d-flex align-items-end\"]");
    public By refundLabel = By.xpath("//h4[text()='** Refund **']");
    public By verifyButton = By.cssSelector("button.btn.btn-outline-success");
    public By partialRefundLink = By.xpath("//button[text()='Partial refund']");
    public By selectPaymentInfo = By.cssSelector("div[id='_B1Q'] p");
    public By paymentCheckBox = By.xpath(" //label[@class='custom-checkbox']");
    public By validationMessage = By.xpath("//p[text()='Select at least one payment to refund']");
    public By processRefundButton = By.xpath("//button[text()='Process Refund']");
    public By refundAmountField = By.cssSelector("[name='refunds[0].amount']");
    public By verifyButtonOnPopup = By.xpath("//button[@class='btn btn-success']");
    public By informationMessageOnVerifyPopup = By.xpath("//div[@class='alert-message']");
    public By verifyByStoreMssg = By.xpath("//span[@class='badge rounded-pill bg-info px-2']");
    public By applyButton = By.xpath("//button[@type='submit']");
    By filterTiltle = By.xpath("(//h5[@class='offcanvas-title'])[1]");
    public By downloadButton = By.xpath("//button[normalize-space()='Download']");
    By listCallender = By.xpath("//ul[@class='float-none w-100']/li");
    public By dateRangeField = By.xpath("//input[@name='dateRange']");
    By calender1 = By.xpath("//div[@class='drp-calendar left float-none w-100']");
    By calender2 = By.xpath("//div[@class='drp-calendar right float-none w-100']");
    By yesterday = By.xpath("(//ul[@class='float-none w-100']/li)[2]");
    By yesterdayOnTransactionList = By.xpath("//span[@class='fs-pn25 mb-2']");
    public By paaymentStatusDropdown = By.xpath("//select[@name='paymentStatus']");
    public By clearPaymentField = By.xpath("(//select[@name='paymentStatus']/option)[1]");
    public By pendingPayments = By.xpath("//option[@value='pending']");
    public By failedPayments = By.xpath("//option[@value='failed']");
    public By unverifiedPayments = By.xpath("//option[@value='unverified']");
    public By pendingPaymentIcon = By.xpath("//i[contains(@class,'fas fa-hourglass-half text-warning fs-5 me-2')]");
    public By excalamatrySign = By.xpath("//i[contains(@class,'fas fa-exclamation-circle text-danger fs-5 me-2')]");
    public By quotionmarkSign = By.xpath("//i[@class='fas fa-question-square text-info fs-5 me-2']");
    public By qrCodeSign = By.xpath("//i[contains(@class,'fa fa-qrcode me-2')]");
    public By paymentLinkField = By.xpath("//select[@name='billTemplate']");
    public By qrCodeSeletct = By.xpath("(//select[@name='billTemplate']/option)[2]");
    public By amountRangeFrom = By.xpath("//input[@placeholder='From']");
    public By amountRangeTo = By.xpath("//input[@placeholder='To']");
    public By clearQrPayment = By.xpath("(//select[@name='billTemplate']/option)[1]");
    public By ammountList = By.xpath("((//div[contains(@class,'d-flex align-items-center')])//span)");
    public By paidLabelOnPopup = By.cssSelector("span.bg-success");
    public By returnSymbol = By.xpath("//div[span[text()='Refunded']]/following::div[4]/i");
    public By questionMarkIcon = By.cssSelector(".align-items-end>i");
    public By capturedButton = By.cssSelector("[value='captured']");
    public By failedButton = By.cssSelector(".mx-3");
    public By recurringIcon = By.cssSelector(".fa.fa-repeat.me-1");
    public By legend = By.cssSelector(".text-end.p-2>button");
    By legendLabels = By.cssSelector("#_PR >div >div");

    // New charge popup locators
    By newChargeAmountField = By.xpath("//input[@lbl-title='Amount']");
    public By newChargeConfirm = By.xpath("//button[@name='method' and @type= 'submit']");
    By terminal = By.xpath("//h4[text()='Initializing the terminal...']");
    By terminalCancelButton = By.xpath("//div[@class='text-center']/button[text()='Cancel']");
    By manualChargeTab = By.xpath("//div[text()='Manual']");
    By descriptionField = By.cssSelector("[name=\"memo\"]");
    By configureStoreLink = By.xpath("//a[text()='Configure your store']");
    By frame = By.cssSelector(".alert-danger.alert-outline-coloured.alert:nth-child(2)");
    By selectCustomerbtn = By.cssSelector(".modal-content .stretched-link.-selectCustomer-");
    public By sendReceiptTitle = By.xpath("//h5[text()='Send the receipt']");
    By amountField = By.cssSelector("h3.text-success.display-3");
    By successMessage = By.cssSelector("div.text-center > p");
    public By emailField = By.xpath("//input[@name='email']");
    By goBtnEmail = By.xpath("//input[@name='email']/following-sibling::button");
    By doneBtn = By.cssSelector(".modal-content .btn.btn-link.w-100.my-3");



    public void getLegendLink() {
        click(legend);
    }
    public void getStoresDropdown() {
        click(storesCombobox);
    }
    public void getContinueButton() {
        click(continueBtn);
    }
    public void getNewChargeBtn(){
        click(newChargeTab);
    }
    public void getNewChargeConfirmBtn(){
        click(newChargeConfirm);
    }

    public void getCustomerBtn(){
        clickElementByJS(selectCustomerbtn);
    }
    public void getGoButton(){
        click(goBtnEmail);
    }
    public void getDoneBtnOfCNpopup(){click(doneBtn);}
    public void getTerminalCancelButton(){click(terminalCancelButton);}
    public void getManualChargeTab(){
        click(manualChargeTab);
    }


    // TRS3
    public void getLegendLabels(){
        // Find all elements using the stored locator
        List<WebElement> elements = getDriver().findElements(legendLabels);
        int count = getCountOfWebElements(legendLabels);
        softAssert.assertEquals(count,"14" );

        // Print text of each element
        for (WebElement element : elements) {
            System.out.println(element.getText());
            System.out.println("****************");
            System.out.println(element);
        }
    }

    public void verifyElementsOnTransactionsPage(){
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationTransaction2);
        getContinueButton();

        // Verifying  New Bill, New Charge, Filter icon is displayed
        softAssert.assertTrue(isElementDisplayed(newBillTab));
        softAssert.assertTrue(isElementDisplayed(newChargeTab));
        softAssert.assertTrue(isElementDisplayed(filterIcon));
        softAssert.assertTrue(isElementDisplayed(legend));

        // Verify that Lengend Labels appears after clicking on it
           getLegendLink();
           getLegendLabels();
    }

// TRS4
        public void verifyNewChargeWithoutStripeConfigured() {
            pageObjectManager.getSidePannel().getMangeBusinessTab();
            pageObjectManager.getSidePannel().getTransactionTab();
            getStoresDropdown();
            selectStore(Constants.AutomationTransaction2);
            getContinueButton();

            // clicking on new charge button
            getNewChargeBtn();
            waitForElementToBeClickable(newChargeAmountField, 3);
            actionEnterText(newChargeAmountField, Constants.amount);
            actionEnterText(descriptionField, Constants.description);

            // Verify that configureStoreLink appears
            Assert.assertTrue(isElementDisplayed(configureStoreLink));

            // Verify Alert message is displayed
            String alertmsg = getText(terminalAlertMessage);
            Assert.assertEquals(alertmsg, Constants.terminalNotAcceptedAlert);
        }


// TRS 5 a
            public void getManualCharge() {
                pageObjectManager.getSidePannel().getMangeBusinessTab();
                pageObjectManager.getSidePannel().getTransactionTab();
                getStoresDropdown();
                selectStore(Constants.AutomationTransaction2);
                getContinueButton();

                // clicking on new charge button
                getNewChargeBtn();
                waitForElementToBeClickable(newChargeAmountField, 3);
                actionEnterText(newChargeAmountField, Constants.amount);
                actionEnterText(descriptionField, Constants.description);
                getNewChargeConfirmBtn();
               // Making new charge payment manually with Credit Card
            }

    // TRS 5 b
            public void getTerminalcharge(){
                pageObjectManager.getSidePannel().getMangeBusinessTab();
                pageObjectManager.getSidePannel().getTransactionTab();
                getStoresDropdown();
                selectStore(Constants.AutomationTransactions3);
                getContinueButton();

                // clicking on new charge button
                getNewChargeBtn();
                waitForElementToBeClickable(newChargeAmountField, 3);
                actionEnterText(newChargeAmountField, Constants.amount);
                actionEnterText(descriptionField, Constants.description);
                waitForElementToBeInteractable(selectCustomerbtn,5);
                getCustomerBtn();
                staticWait(3000);
                actionEnterText(emailField,Constants.custEmailInput);
                getGoButton();
                staticWait(3000);
//                getDoneBtnOfCNpopup();
//                waitForElementToBeClickable(newChargeConfirm,5);
                getNewChargeConfirmBtn();

                // Waiting for Automatic Terminal Payment
                softAssert.assertTrue(isElementDisplayed(terminal));

                // Verify the Send Receipt Popup is Displayed
                softAssert.assertTrue(isElementDisplayed(sendReceiptTitle));
                String text = getText(amountField);
                softAssert.assertEquals(text, "$" + Constants.amount);
                String successMsg= getText(successMessage);
                softAssert.assertEquals(successMsg, "$" + Constants.terminalSuccessMessage);
    }

    public void getManualChargeAfterCancelingTerminal(){
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationTransactions3);
        getContinueButton();

        // clicking on new charge button
        getNewChargeBtn();
        waitForElementToBeClickable(newChargeAmountField, 3);
        actionEnterText(newChargeAmountField, Constants.amount);
        actionEnterText(descriptionField, Constants.description);
        waitForElementToBeInteractable(selectCustomerbtn,5);
        getCustomerBtn();
        staticWait(3000);
        actionEnterText(emailField,Constants.custEmailInput);
        getGoButton();
//      getDoneBtnOfCNpopup();
        waitForElementToBeInteractable(newChargeConfirm,5);
        getNewChargeConfirmBtn();

        // Waiting for Automatic Terminal Payment
        softAssert.assertTrue(isElementDisplayed(terminal));
        getTerminalCancelButton();

        // Paying through credit card after canceling terminal payment
        getManualChargeTab();

    }


        }




