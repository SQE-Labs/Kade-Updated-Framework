package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class TransactionsPage extends BaseTest {
    PaymentPage payments = new PaymentPage();
    PaymentMethod paymentMethod = new PaymentMethod();

    //Locators
    public By transactionRow = By.xpath("//div[contains(@class,'bg-white border')]");
    public By billAmount = By.xpath("//div[@class='display-6 fw-bold pt-2']");
    public By closeTransactionPopupBtn = By.xpath("(//button[@class='btn-close'])[1]");
    public By storesCombobox = By.xpath("//span[@role='combobox']");
    public By continueBtn = By.xpath("//button[@type='submit']");
    public By uniqueTransactionId = By.xpath("//span[@class='badge position-relative bg-light text-dark p-1 px-2 text-truncate flex-shrink-0']");
    public By transactionID = By.xpath("//div[contains(@class,'bg-white border')]");
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
    By TransactionHeader=By.xpath("//h1[contains(text(),'Transactions')]");
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
    public By unverifiedPayments = By.xpath("(//select[@name='paymentStatus']/option)[4]");
    public By pendingPaymentIcon = By.xpath("(//i[contains(@class,'fas fa-hourglass-half text-warning mx-1')])[2]");
    public By excalamatrySign = By.xpath("(//div[@class='d-flex align-items-center']//i[@class='fas fa-exclamation-circle text-danger mx-1'])[1]");
    public By quotionmarkSign = By.xpath("//i[@class='fas fa-question-square text-info fs-5 me-2']");
    public By qrCodeSign = By.xpath("(//i[contains(@class,'fa fa-qrcode mx-1')])[2]");
    public By paymentLinkField = By.xpath("//select[@name='billTemplate']");
    public By qrCodeSeletct = By.xpath("(//select[@name='billTemplate']/option)[2]");
    public By amountRangeFrom = By.xpath("//input[@placeholder='From']");
    public By amountRangeTo = By.xpath("//input[@placeholder='To']");
    public By clearQrPayment = By.xpath("(//select[@name='billTemplate']/option)[1]");
    public By ammountList = By.xpath("((//div[contains(@class,'d-flex align-items-center')])//span)");
    public By paidLabelOnPopup = By.cssSelector("span.bg-success");
    public By returnSymbol = By.xpath("//div[span[text()='Refunded']]/following::div[4]/i");
    public By questionMarkIcon = By.cssSelector("div.d-flex>span [title='Unverified']");
    public By capturedButton = By.cssSelector("[value='captured']");
    public By failedButton = By.cssSelector(".mx-3");
    public By recurringIcon = By.cssSelector(".fa.fa-repeat.me-1");
    public By legend = By.cssSelector(".text-end.p-2>button");
    By legendLabels = By.cssSelector("#_PR >div >div");
    public static By attentionHeader=By.xpath("//h4[text()='Attention!']");
    public static By okButn=By.xpath("//button[text()='OK']");
    By manualServiceFeeValue = By.xpath("//div[@class='text-warning']//span[2]");


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
    By creditCardInfoFrame = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]");
    By amount = By.cssSelector(".d-flex.flex-column.align-items-end");
    By dropdown = By.xpath("//select[@name='paymentStatus']");
    By crossIconOfCurrentPaid = By.xpath("//button[@class='btn-close']");
    By processBtn = By.xpath("(//button[starts-with((text()), 'Process')])[2]");


    BillPage bills = new BillPage();
    private BaseTest ActionEngine;

    public void getLegendLink() {
        click(legend);
    }

    public void getStoresDropdown() {
        click(storesCombobox);
    }

    public void getContinueButton() {
        click(continueBtn);
    }

    public void getNewChargeBtn() {
        click(newChargeTab);
    }

    public void getNewChargeConfirmBtn() {
        click(newChargeConfirm);
    }

    public void getCustomerBtn() {
        clickElementByJS(selectCustomerbtn);
    }

    public void getGoButton() {
        click(goBtnEmail);
    }

    public void getDoneBtnOfCNpopup() {
        click(doneBtn);
    }

    public void getTerminalCancelButton() {
        click(terminalCancelButton);
    }

    public void getManualChargeTab() {
        clickElementByJS(manualChargeTab);
    }

    public void switchToCreditCardFrame() {
        staticWait(6000);
        switchToFrame(creditCardInfoFrame);
    }

    public void getRefundBtn() {
        click(refundButton);
    }

    public void getFullRefundBtn() {
        click(processFullRefund);
    }

    public void getPartialRefundbtn() {
        click(partialRefundLink);
    }

    public void getProcessRefundBtn() {
        click(processRefundButton);
    }

    public void getVisaPaymentCheckbox() {
        click(paymentCheckBox);
    }

    public void getVerifyButton() {
        click(verifyButton);
    }

    public void getVerifyButtonOnPopup() {
        click(verifyButtonOnPopup);
    }

    public void getQuestionMarkIcon() {
        click(questionMarkIcon);
    }

    public void getCaptureButton() {
        click(capturedButton);
    }

    public void clickOnAmount() {
        click(amount);
    }

    public void getFailedBtn() {
        click(failedButton);
    }

    public void getFilterIcon() {
        click(filterIcon);
    }

    public void getApplyBtn() {
        click(applyButton);
    }

    public void getDownloadBtn() {
        click(downloadButton);
    }

    public void getDateRangeField() {
        click(dateRangeField);
    }

    public void getPaymentStatusDropdown() {
        click(paaymentStatusDropdown);
    }

    public void getUnverifiedPayments() {
        click(unverifiedPayments);
    }

    public void getClearPaymentField() {
        click(clearPaymentField);
    }

    public void getPaymentLinkField() {
        click(paymentLinkField);
    }
    public void clickOnDownloadBtn() {
        click(downloadButton);
    }

    public void getQrCodeSeletct() {
        click(qrCodeSeletct);
    }

    public void getApplyButtonOnPopup() {
        click(applyButton);
    }

    public void getCrossIconOfCurrentPaidBill() {
        click(crossIconOfCurrentPaid);
    }
    public void getProcessBtn(){
        click(processBtn);
    }


//    Select select = new Select((WebElement)dropdown);


    // TRS 01 - a
    public void verifyAllElementsOnTransactionPopup() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        waitForElementToBeVisible(customerName, 3);
        softAssert.assertTrue(isElementDisplayed(customerName), "customer name");
        softAssert.assertTrue(isElementDisplayed(payment), "payment");
        softAssert.assertTrue(isElementDisplayed(time), " time");
        softAssert.assertTrue(isElementDisplayed(transactionAmmount), "Transaction Amount ");
        softAssert.assertTrue(isElementDisplayed(transactionID), "transaction Id ");
        softAssert.assertAll();
    }

    // Trs 01 b
    public void verifyByStoreLabel() {
        bills.createBillWithCustomer("636045278965", "Saybo@yopmail.com");
        bills.clickOnNotPaidLabel();
        payments.paymentPopup("Enter Bill Amount");

    }


    // TRS3
    public void getLegendLabels() {
        // Find all elements using the stored locator
        List<WebElement> elements = getDriver().findElements(legendLabels);
        int count = getCountOfWebElements(legendLabels);
        softAssert.assertEquals(count, "14");

        // Print text of each element
        for (WebElement element : elements) {
            System.out.println(element.getText());
            System.out.println("****************");
            System.out.println(element);
        }
    }

    public void verifyElementsOnTransactionsPage() {
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
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationTransactions);
        getContinueButton();

        // clicking on new charge button
        getNewChargeBtn();
        waitForElementToBeClickable(newChargeAmountField, 5);
        actionEnterText(newChargeAmountField, Constants.amount);
        actionEnterText(descriptionField, Constants.description);
        getNewChargeConfirmBtn();
        // Making new charge payment manually with Credit Card

        waitForElementToBeClickable(manualChargeTab,5);
        getManualChargeTab();

//        staticWait(6000);
         switchToCreditCardFrame();
         payments.getPayThroughCreditCard();
         getProcessBtn();
         waitForElementToBeVisible(sendReceiptTitle,5);

        // Verify the Send Receipt Popup is Displayed
        softAssert.assertTrue(isElementDisplayed(sendReceiptTitle));
        String text = getText(amountField);
        softAssert.assertEquals(text, "$" + Constants.amount);
        String successMsg = getText(successMessage);
        softAssert.assertEquals(successMsg, "$" + Constants.terminalSuccessMessage);
    }

    // TRS 5 b
    public void getTerminalcharge() {
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
        waitForElementToBeInteractable(selectCustomerbtn, 5);
        getCustomerBtn();
        staticWait(3000);
        actionEnterText(emailField, Constants.custEmailInput);
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
        String successMsg = getText(successMessage);
        softAssert.assertEquals(successMsg, "$" + Constants.terminalSuccessMessage);
    }

    // TRS 5 c
    public void getManualChargeAfterCancelingTerminal() {
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.TerminalChargeStore);
        getContinueButton();

        // clicking on new charge button
        getNewChargeBtn();
        waitForElementToBeClickable(newChargeAmountField, 3);
        actionEnterText(newChargeAmountField, Constants.amount);
        actionEnterText(descriptionField, Constants.description);
        waitForElementToBeInteractable(selectCustomerbtn, 5);
        getCustomerBtn();
        staticWait(3000);
        actionEnterText(emailField, Constants.custEmailInput);
        getGoButton();
//        getDoneBtnOfCNpopup();
        staticWait(5000);
        getNewChargeConfirmBtn();

        // Waiting for Automatic Terminal Payment
        softAssert.assertTrue(isElementDisplayed(terminal));
        String terminalValue = getText(manualServiceFeeValue);
        softAssert.assertEquals(terminalValue, "$3.39");
        staticWait(3000);
        getTerminalCancelButton();

        // Paying through credit card after canceling terminal payment
        getManualChargeTab();
        String manualValue = getText(manualServiceFeeValue);
        softAssert.assertEquals(terminalValue, "$3.86");
        staticWait(3000);
        staticWait(6000);
        switchToCreditCardFrame();
        payments.getPayThroughCreditCard();
    }


    public void getCurrentPaidBill() {
        click(currentPaidBill);
    }

    //  TRS 06
    public void getAllElementsOfTransactionsPopup() {
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationTransactions3);
        getContinueButton();

        waitForElementToBeClickable(currentPaidBill, 5);
        getCurrentPaidBill();

        // Verifying the elements on Transaction Popup
        // softAssert.assertTrue(isElementDisplayed(transactionID));
        softAssert.assertTrue(isElementDisplayed(verifyButton));
        softAssert.assertTrue(isElementDisplayed(payment));
        softAssert.assertTrue(isElementDisplayed(time));
        softAssert.assertTrue(isElementDisplayed(uniqueTransactionId));
        softAssert.assertTrue(isElementDisplayed(customerName));
        softAssert.assertTrue(isElementDisplayed(refundButton));
        softAssert.assertTrue(isElementDisplayed(paidLabelOnPopup));
        softAssert.assertAll();

    }


    // TRS 7 a
    public void getFullRefund() {

        // Making payment
        bills.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payments.billPaymentByThroughDebitCard("4111111111111111", "0930", "794", "Australia");
        payments.swipeCard();
        payments.billPayment();

        waitForElementToBeVisible(pageObjectManager.getSidePannel().signOutBtn,5);


        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);

        // login as store manager
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Clicking on Current Paid bill
        getCurrentPaidBill();
        Assert.assertTrue(isElementDisplayed(refundButton));
        getRefundBtn();
        enterText(refundRefenceNo, "1111");
        enterText(refundReason, "refund full amount");
        getFullRefundBtn();
        String getAmt = getText(refundAmountOnReceipt);
        softAssert.assertEquals(getAmt, "$" + bills.amount);
        staticWait(3000);
        softAssert.assertTrue(isElementDisplayed(refundLabel));
        softAssert.assertTrue(isElementDisplayed(verifyButton));

        // Clicking on transaction tab to verify the refunded transaction
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();
        softAssert.assertTrue(isElementDisplayed(returnSymbol));
    }

    // TRS 07 b
    public void getPartialRefund() {
        String refundReasonn = "Extra fair testing";
        String refundAmmount = "50.00";
        String refundReferenceNo = requiredDigits(4);

        // Making payment
        bills.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payments.billPaymentByThroughDebitCard("4111111111111111", "0930", "794", "Australia");
        payments.swipeCard();
        payments.billPayment();

        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);

        // login as store manager
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Clicking on Current Paid bill
        getCurrentPaidBill();
        Assert.assertTrue(isElementDisplayed(refundButton));
        getRefundBtn();
        enterText(refundRefenceNo, refundReferenceNo);
        enterText(refundReason, refundReasonn);

        // Clicking on partial refund link.
        getPartialRefundbtn();
        waitForElementToBeClickable(processRefundButton, 3);


        // Verify the validation message when no payment checkbox is selected.
        getProcessRefundBtn();
        String actual = getText(validationMessage);
        softAssert.assertEquals(actual, "Select at least one payment to refund");
        getVisaPaymentCheckbox();

        // Verify that Refund Amount field is displayed after selecting the checkbox
        softAssert.assertTrue(isElementDisplayed(refundAmountField));
        getProcessRefundBtn();
        scrollToElement(refundAmountField);
        waitForElementToBeClickable(refundAmountField, 3);
        actionEnterText(refundAmountField, refundAmmount);
        staticWait(5000);
        scrollToElement(processRefundButton);
        getProcessRefundBtn();
    }

    // TRS 08
    public void verifyTheTransaction() {
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Clicking on Current Paid bill
        getCurrentPaidBill();
        waitForElementToBeClickable(verifyButton, 3);
        getVerifyButton();

        // Assertions on Verify Assertion Popup
        softAssert.assertTrue(isElementDisplayed(verifyButtonOnPopup));
        String actualmsg = getElementText(informationMessageOnVerifyPopup);
        softAssert.assertEquals(actualmsg, Constants.verifyInfoMsg);

        getVerifyButtonOnPopup();
        String verifyByStoreMsg = getText(verifyByStoreMssg);
        softAssert.assertEquals(verifyByStoreMsg, Constants.verifyByStore);
    }

    // TRS 12
    public void verifyQuestionMarkIcon() {
        bills.verifyCreateBillForSuggestedCustomer("saybo@yopmail.com");
        payments.paymentThrouhVenmoAccount();
        pageObjectManager.getSidePannel().getSignOut();
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();
        getCurrentPaidBill();
//        waitForElementToBeVisible(questionMarkIcon,3);
        staticWait(3000);

        // Clicking on the paid amount and verify the question mark icon is displayed
        softAssert.assertTrue(isElementDisplayed(questionMarkIcon),"Question Mark Icon");
//        waitForElementToBeClickable(amount,4);
        staticWait(5000);
        clickOnAmount();


        // Verify Capture and Failed Button is visible
        softAssert.assertTrue(isElementDisplayed(capturedButton), "captured button");
        softAssert.assertTrue(isElementDisplayed(failedButton), "Failed button");

        // clicking on capture button
        getCaptureButton();

        waitForElementInVisible(questionMarkIcon, 5);
        softAssert.assertFalse(isElementDisplayed(questionMarkIcon), "Question mark removed");
        softAssert.assertAll();

    }

    // TRS 15
    public void recurringIconCheck() {
        bills.verifyBillCreationByAddingRecurringTransactionsWeekly("6364748848", "saybo@yopmail.com");
        bills.clickOnCrossIcon();
        staticWait(3000);
        payments.billPaymentByThroughDebitCard("4111111111111111", "0930", "794", "Australia");
        payments.swipeCard();
        payments.billPayment();

        pageObjectManager.getSidePannel().getSignOut();
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();
        getCurrentPaidBill();

    }

    // TRS16 Pending processing icon
    public void verifyPaymentProcessingIcon() {
        bills.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payments.paymentThrouhBankAccount();
        payments.swipeCard();
        payments.billPayment();

        pageObjectManager.getSidePannel().getSignOut();
        staticWait(5000);

        // login as store manager
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Clicking on Current Paid bill
        getCurrentPaidBill();
        staticWait(5000);

        // verify the Pending processing Icon
        Assert.assertTrue(isElementDisplayed(pendingPaymentIcon), "pending icon");
        getToolTipMessage(pendingPaymentIcon);
    }

    // TRS 10
    public void verifyTheFailedIcon() {
        bills.createBillWithCustomer("636045278965", "saybo@yopmail.com");

        payments.paymentThrouhVenmoAccount();
        pageObjectManager.getSidePannel().getSignOut();
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();
        getCurrentPaidBill();

        // Clicking on the paid amount and verify the question mark icon is displayed
        softAssert.assertTrue(isElementDisplayed(questionMarkIcon));
//        waitForElementToBeClickable(amount,4);
        staticWait(5000);
        clickOnAmount();

        // Verify Capture and Failed Button is visible
        softAssert.assertTrue(isElementDisplayed(capturedButton), "captured button");
        softAssert.assertTrue(isElementDisplayed(failedButton), "Failed button");

        // click on fail button
        getFailedBtn();

        waitForElementToBeVisible(excalamatrySign,5);

        // verify that failed icon appear
        Assert.assertTrue(isElementDisplayed(excalamatrySign),"Excalamatry Sign");
    }

    // TRS 09
    public void getFilterAllTheElements() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // click on filter icon
        getFilterIcon();
        staticWait(3000);

        // verify filter title
        softAssert.assertTrue(isElementDisplayed(filterTiltle), "Filter title");

        // click on apply button
        getApplyBtn();
        staticWait(5000);
        // waitForPageLoad();

        int count = getCountOfWebElements(transactionID);
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
            List<WebElement> currentBills = getDriver().findElements(By.xpath("//div[contains(@class,'bg-white border rounded rounded-2 g')]"));

            int currentCount = currentBills.size();
            System.out.println("Currently loaded bills: " + currentCount);

            if (currentCount == previousCount) {
                // No new bills loaded
                break;
            }

            previousCount = currentCount;
            allBills = currentBills;
        }

        // Output total bills
        Log.info("Total bills collected: " + allBills.size());
        for (WebElement bill : allBills) {
            System.out.println(bill.getText()); // or any property you want
        }

        staticWait(5000);


    }

    public void FilterGetsDownloadTransactions() {
        String ammountFrom = "10.00";
        String ammountTo = "100.00";

        Login();
        //  pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
             staticWait(3000);
        getContinueButton();
            // verify filter title
        staticWait(3000);
       //     Assert.assertTrue(isElementDisplayed(filterTiltle));
            //  softAssert.assertTrue(isElementDisplayed(filterTiltle), "Filter title");

         //   getApplyButtonOnPopup();
            staticWait(3000);
            Assert.assertTrue(isElementDisplayed(TransactionHeader));
            // click on filter icon
            getFilterIcon();
            staticWait(3000);

            clickOnDownloadBtn();


//        String fileStatus = ActionEngine.isFileDownloaded("Transactions.xlsx");
//        System.out.println("fileStatus :" + fileStatus);
//        staticWait(3000);
//        if (fileStatus.equalsIgnoreCase("File Present")) {
//            String deletStatus = ActionEngine.deleteFile("Transactions.xlsx");
//            System.out.println("deleteStatus :" + deletStatus);
//
//            staticWait(3000);


            staticWait(5000);
            String fileDownloadStatus = ActionEngine.isFileDownloaded("Transactions.xlsx");

                getFilterIcon();
                getPaymentStatusDropdown();
                // getClearPaymentField();

                staticWait(3000);
                getPaymentLinkField();
                getQrCodeSeletct();
                getApplyButtonOnPopup();

//            waitForElementToBeVisible(qrCodeSign, 3);
//            softAssert.assertTrue(isElementDisplayed(qrCodeSign), "Qr Code Sign");
//            Assert.assertTrue(isElementDisplayed(qrCodeSign));

                staticWait(3000);
                getFilterIcon();
                // getPaymentStatusDropdown();
                //  getClearPaymentField();
                staticWait(3000);

                actionEnterText(amountRangeFrom, ammountFrom);
                //waitForElementToBeVisible(amountRangeTo, 10);
                actionEnterText(amountRangeTo, ammountTo);

                getApplyButtonOnPopup();
                staticWait(5000);
            }
        }



















