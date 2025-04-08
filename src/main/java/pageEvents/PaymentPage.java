package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Constants;

import java.awt.*;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class PaymentPage extends BaseTest {


    /*
    Receive Payment Locators
     */
    public By paymentPopupTitle = By.xpath("//h5[text()='Receive Payment']");
    By closeIcon = By.xpath("(//button[@class=\"btn-close\"])[1]");
    By cardNumberTbx = By.id("Field-numberInput");
    By expirationDateTbx = By.id("Field-expiryInput");
    By cvcTbx = By.id("Field-cvcInput");
    By countryDropDown = By.id("Field-countryInput");
    By processBtn = By.xpath("//button[@type=\"submit\" and contains(text(),'Process')]");
    By voidBtn = By.xpath("//button[text()='Void']");
    By paymentLogo = By.xpath("//span[@class='payment-logo-bg me-1']");
    public By totalPaidAmt = By.xpath("//h4[contains(text(),'Total paid')]");
    By voidedTag = By.xpath("//h6[text()='VOIDED']");
    public By changeButton = By.xpath("//div[contains(text(),'Change')]");
    public By swipeBtn = By.xpath("//input[@class='slider -pm-none-']");
    By closeBtn = By.xpath("//a[text()='Close']");


    /*
    Receive Payment popup locators
     */
    By balanceDue = By.xpath("//span[text()='Balance Due:']//following-sibling::span");
    By totalAmount = By.xpath("//span[contains(text(),'Total')]");
    By receiveAmountTbx = By.xpath("//input[@name='amount']");
    public By creditCardBtn = By.xpath("//button[text()='Credit Card']");
    By othersBtn = By.xpath("//button[text()='Other']");
    public By savedCreditcard = By.xpath("//div[contains(@class,'-paymethodbox-')] //span[contains(text(),'Visa')][1]");


    /*
    Payment Type Panel
     */
    public By paymentTypeHeader = By.xpath("//h5[@class='offcanvas-title' and text()='Payment type']");
    By venmoPaymentType = By.xpath("(//button[@name='payType'])[1]/..");
    By zellePaymentType = By.xpath("(//button[@name='payType'])[2]/..");
    By cashPaymentType = By.xpath("//span[text()='Cash']/../../..");
    By memoTextbox = By.xpath("//textarea[@name='message']");
    By receivingAmtPaymentTypePanel = By.xpath("//span[@data-field='amount']");
    public By payNowButton = By.xpath("//button[@type=\"button\" and text()='Pay Now']");

    By rejectButton = By.xpath("//button[text()='Reject']");
    By rejectReason = By.xpath("(//i[contains(@class,'fal fa-circle custom-check-off')])[1]");
    By submitButton = By.xpath("//button[text()='Submit']");
    By rejectToastMessage = By.xpath("//div[@class='toast-message']");
    By confirmationPopUp = By.xpath("//h5[text()='Confirmation']");

    // By savedCreditcard = By.xpath("//div[contains(@class,'-paymethodbox-')] //span[contains(text(),'Visa')]");
    public By savedBankAccount = By.xpath("//span[text()='Bank Account 6789'][1]");
    public By SavedVenmoCard = By.xpath("//span[@class='text-nowrap fs-pn25' and text()='Venmo']");
    public By iMadeMyPaymentButtonVenmo = By.cssSelector(".text-center.mb-3>button");
    By personalMessageVenmo = By.xpath("//textarea[@placeholder='Personal message']");
    By screenshotButton = By.xpath("//button[text()='Do you have a screenshot?']");
    By confirmVenmoCheckbox = By.xpath("//i[@class='fal fa-square custom-check-off ']");
    By venmoSubmitButton = By.xpath("//button[text()='Submit']");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By selectedBankDisplay = By.xpath("//div[@class='-placeholder- link-empty']");

    // Assertion elements of Venmo Card
    By qrVenmoPopup = By.xpath("//div[@class='fs-4 text-center py-2 ']");
    By venmoPopup = By.xpath("(//h5[@class='modal-title'])[1]");
    By copyLink = By.xpath("//span[text()='Copy']");
    By getUploadedImage = By.xpath("//div[@class='my-2 display-none']/img");
    By processSuccessMsg = By.xpath("//div[@class='d-flex justify-content-center align-items-center fs-1 text-success py-2']");
    By rateYourExperienceLink = By.xpath("//div[@class='col-sm fs-4 pb-2']");
    By viewReceipt = By.xpath("//div[@class='mt-4']/child::div/a[1]");
    public By closeBlueBtn = By.xpath("//a[text()='Close']");
    By tapToPayMoreLink = By.partialLinkText("Tap to pay more");
    //By tapToPayMoreLink=By.xpath("//a[text()='Tap to pay more']");
    By moreAmountTbx = By.xpath("//input[@lbl-title='Amount']");
    By updateButton = By.xpath("(//button[contains(text(),'Update')])[2]");
    By swipeButton = By.xpath("//a[contains(@class,' -updateamount-')]");
    By savedZellePaymentButton = By.xpath("//div//span[text()='Zelle']");
    By zellePopup = By.xpath("//h5[@class='modal-title']//span");
    By zelleCopyLink = By.xpath("//span[text()='Copy']");
    By paymentType = By.xpath("//div[@class='d-flex flex-column align-items-end']//span[@class='fs-pn25']");
    By updateAmtBtn = By.xpath("//button[text()='Update']");

    // Payment popup locators

    public By billHeader = By.xpath("//span[text()='Bill']");
    public By qrCode = By.xpath("//span[text()='QR Code']");
    public By processPaymentBtn = By.xpath("//button[text()='Process Payment']");
    public By processPayment = By.xpath("//button[@class='btn btn-outline-success']");
    public By deleteIconBtn = By.xpath("//button[text()='Delete']");
    public By editIcon = By.xpath("//button[text()=' edit']");
    public By uniqueNumber = By.xpath("(//div[contains(@class,'d-flex align-items-center')]//span)[3]");
    public By tapToAddFile = By.xpath("//div[text()='Tap to add files']");
    public By NotPaid = By.xpath("//span[text()='Not Paid']");
    public By BillCreatedTime = By.xpath("//div[@class='fs-pn15 mb-1']");
    public By shareBtn = By.xpath("//span[text()='Share']");
    public By recievePaymentTitle = By.xpath("//span[text()='Receive Payment']");
    public By totalAmt = By.xpath("//span[@class='fs-4 mb-2 text-info']");
    public By balanceAmt = By.xpath("//span[@class='display-4 fw-bold ']");
    public By recieveAmtTxtField = By.xpath("//label[text()='Receiving amount']");
    public By creditCardButton = By.xpath("//button[text()='Credit Card']");
    public By otherBtn = By.xpath("//button[text()='Other']");
    public By creditCard = By.xpath("//button[text()='Credit Card']");
    By cardName = By.xpath("//input[@name='number']");
    public By paymentTypeText = By.xpath("//h5[text()='Payment type']");
    public By memoTxtField = By.xpath("//textarea[@placeholder='Memo']");
    public By venomoBtn = By.xpath("//span[text()='Venmo']");
    public By zelleBtn = By.xpath("//span[text()='Zelle']");
    public By CashBtn = By.xpath("(//div[contains(@class,'w-100 border')])[3]");
    By venomoCard = By.xpath("(//div[contains(@class,'w-100 border')])[1]");
    By ZelleCard = By.xpath("(//div[contains(@class,'w-100 border')])[2]");
    public By paidLabel = By.xpath("//div[normalize-space()='Paid']");
    public By cashIcon = By.xpath("(//span[text()='Cash']/../child::span)[3]");
    public By crossIcon = By.xpath("(//button[@class='btn-close'])[3]");
    public By crossIconOnTransactionpage = By.xpath("//button[@class='btn-close']");
    public By transcationMenu = By.xpath("(//div[text()='Transactions'])[2]");
    public By paidBill = By.xpath("//div[contains(@class,'bg-white border')][1]");
    public By amountPaidTime = By.xpath("(//span[@class='fs-pn15'])[4]");
    By partialAmountPaidTime = By.xpath("(//span[@class='fs-pn15'])[1]");
    public By paidlabel = By.xpath("//span[text()='Paid']");
    public By uniqueId = By.xpath("//span[contains(@class,'badge position-relative bg-light text-dark p-1 px-2 text-truncate f')]");
    public By refundIcon = By.xpath("//button[text()='Refund']");
    public By verifyIcon = By.xpath("//button[text()='Verify']");
    public By creditCardInfoFrame = By.xpath("//h5[text()='Credit card information']/../..//iframe");
    public By expiryDate = By.xpath("//input[@name='expiry']");
    public By cvc = By.xpath("//input[@name='cvc']");
    By PaymentProcessBtn = By.xpath("//button[contains(text(),'Process')]");
    By visaIcon = By.xpath("//span[text()='Visa']/..");
    By venmoIcon = By.xpath("(//span[text()='Venmo'])[2]");
    By zelleIcon = By.xpath("(//span[text()='Zelle'])[2]");
    By notPaid = By.xpath("//div[contains(@class, 'row bg-white')][1]");
    By deleteIcon = By.xpath("//i[@class='fa fa-trash text-danger']/../.");
    By voided = By.xpath("//h6[text()='VOIDED']");
    By signOut = By.xpath("//a[text()='Sign out']");
    By thumbIcon = By.xpath("//div[@class='popover-body p-2']/child::div/child::button[text()='Never mind']/following-sibling::button");


    By recieveAmountField = By.xpath("//input[@name='amount']");
    By dueAmount = By.xpath("//span[@class='display-6 text-danger']");
    By paidAmount = By.xpath("//div[@class='display-5']");
    By crossIconOnPartialPaid = By.xpath("//button[@class='btn-close']");
    By paidBillUniqueid = By.xpath("(//div[contains(@class,'d-flex justify-content-between mb-2')]/div)[1]");

    // Bill paid by customer
    By billIcon = By.xpath("//i[@class='align-middle fas fa-bell']");
    By bill = By.xpath("(//p[text()='A bill received']/../..)[1]");
    By payNowBtn = By.xpath("//button[text()='Pay Now']");
    By storeName = By.xpath("//h4[text()='Automation Bill Flow']");
    By visaCardName = By.xpath("(//span[contains(text(),'Visa')])[3]");
    By debitCardName = By.xpath("(//span[contains(text(),'Visa')])[5]");
    By changeBtn = By.xpath("//div[normalize-space()='Change']");
    By creditCards = By.xpath("//span[text()='New Credit Card']/../../../..");
    By iframeForCard = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[2]");
    By saveBtn = By.xpath("//button[text()='Save']");
    By thankTxt = By.xpath("//span[text()='Thank']");
    By youTxt = By.xpath("//span[text()='You!']");
    By rateYourExpTxt = By.xpath("//div[normalize-space()='Rate your experience']");
    By viewReciptTxt = By.xpath("//a[text()='View the receipt']");
    By transactionHeader = By.xpath("//h1[normalize-space()='Transaction Detail']");
    By tarnsactionUniqueId = By.xpath("(//span[contains(text(),'TR-')])[2]");
    By paymentMethodIcon = By.xpath("//span[text()='Visa 1111']");
    By bankAccountSection = By.xpath("(//span[contains(text(),'Bank Account 6789')])");
    By amountField = By.xpath("(//form//input[@name='amount'])[2]");
    By updateBtn = By.xpath("(//button[text()='Update'])[2]");
    By swipeArrowBtn = By.xpath("//input[@type='range']/..//span[contains(text(),'$')]/..");
    By zelleAccount = By.xpath("//span[text()='Zelle']/../../../..");
    By VenmoAccount = By.xpath("//span[text()='Venmo']/../../../..");

    By makePayment = By.xpath("//button[text()='I made the payment']");
    By selectCheckBox = By.xpath("(//span[text()='Confirm your payment by checking this box']/../i)[2]");
    By zelleSaveBtn = By.xpath("//button[text()='Submit']");


    //        public void PaymentsPage() {
//        }
//
//        public void clickCashBtn() {
//            WebdriverWaits.waitForElementVisible(paymentPopupTitle, 5);
//            moveToWebElement(cashBtn);
//            clickElementByJS(cashBtn);
//        }
//
//        public Clickable getCashButton() {
//            return Clickable.getElementBy(cashPaymentType, "Cash Button");
//        }
//
//        public Clickable getOthersButton() {
//            return Clickable.getElementBy(othersBtn, "Other button");
//        }
//
//        public Editable getAmountTextbox() {
//            return Editable.getElementBy(receiveAmountTbx, "Receiving amount textbox");
//        }
//
//        public Clickable getPaidLabel() {
//            return Clickable.getElementBy(paidLabel, "Paid label on Bill");
//        }
//
//        public boolean isPaidLabelDisplayed() {
//            WebdriverWaits.waitForElementVisible(paidLabel, 5);
//            return isWebElementVisible(paidLabel);
//        }
//
//        public Clickable getReceivedPaymentTitle() {
//            return Clickable.getElementBy(paymentPopupTitle, "Receive Payment Popup Title");
//        }
//
//        public Clickable getCreditCardButton() {
//            return Clickable.getElementBy(creditCardBtn, "Credit card button");
//        }
//
//
//        public Editable getCardNumberTextbox() {
//            return Editable.getElementBy(cardNumberTbx, "Card Number textbox");
//        }
//
//        public Editable getExpirationDateTextbox() {
//            return Editable.getElementBy(expirationDateTbx, "Expiration Date textbox");
//        }
//
//        public Editable getCvcTextbox() {
//            return Editable.getElementBy(cvcTbx, "CVC textbox");
//        }
//
//        public void selectCountry(String country) {
//            selectDropDownByVisibleText_custom(countryDropDown, country);
//        }
//
//        public void clickProcessBtn() {
//            click(processBtn);
//        }
//
//        public void switchToCreditCardFrame() {
//            switchToFrame(creditCardInfoFrame);
//        }
//
//        public Clickable getBalanceDue() {
//            return Clickable.getElementBy(balanceDue, "Balance Due Field");
//        }
//
//        public Clickable getTotalAmount() {
//            return Clickable.getElementBy(totalAmount, "Total amount element");
//        }
//
//        public Clickable getReceivingAmount() {
//            return Clickable.getElementBy(receiveAmountTbx, "value");
//        }
//
//        public Clickable getPaymentTypePanelHeader() {
//            return Clickable.getElementBy(paymentTypeHeader, "Payment Type Header");
//        }
//
//
//        public Clickable getPaymentLogo() {
//            return Clickable.getElementBy(paymentLogo, "Payment type logo");
//        }
//
//        public void payByCreditCard() {
//            switchToCreditCardFrame();
//            getCardNumberTextbox().setText("4111111111111111");
//            getExpirationDateTextbox().setText("0230");
//            getCvcTextbox().setText("123");
//            selectCountry("Australia");
//            switchToDefaultWindow();
//            clickProcessBtn();
//        }
//
//        public void enterAmount(String amount) {
//            pressKeys(receiveAmountTbx, amount);
//        }
//
//        public Editable getReceivingAmountTextbox() {
//            return Editable.getElementBy(receiveAmountTbx);
//        }
//
//        public Clickable getReceivingAmountFromPaymentTypePanel() {
//            return Clickable.getElementBy(receivingAmtPaymentTypePanel, "Receiving Amount Payment Type Panel");
//        }
//
//        public Clickable getChangePaymentMethodButton() {
//            System.out.println(changeButton);
//            return Clickable.getElementBy(changeButton, "change Payment Method button");
//        }
//
//        public Clickable getTotalPaidAmount() {
//            return Clickable.getElementBy(totalPaidAmt, "Total Paid Amount");
//        }
//
//        public Clickable getZelleButton() {
//            WebdriverWaits.waitForElementVisible(paymentPopupTitle, 5);
//            return Clickable.getElementBy(zellePaymentType);
//        }
//
//        public Clickable getCloseReceivedPopupButton() {
//            return Clickable.getElementBy(closeIcon, "Close Received Button");
//        }
//
//        public Clickable getVenmoButton() {
//            return Clickable.getElementBy(venmoPaymentType);
//        }
//
//        public Clickable getCreditCardBtn() {
//            return Clickable.getElementBy(creditCardBtn);
//        }
//
//        public Clickable getVoidButton() {
//            return Clickable.getElementBy(voidBtn, "Void Button");
//        }
//
//        public Clickable getVoidedTag() {
//            return Clickable.getElementBy(voidedTag, "Voided Tag");
//        }
//
//        public Clickable getMomoTextbox() {
//            return Clickable.getElementBy(memoTextbox, "Memo Textbox");
//        }
//
//        public Clickable getPayNowButton() {
//            return Clickable.getElementBy(payNowButton, "Pay Now Button");
//        }
//
//
//        public Clickable getSavedCreditCard() {
//            return Clickable.getElementBy(savedCreditcard, "Saved Credit card");
//        }
//
//        public void swipeToPay() {
//            Actions actions = new Actions(getDriver());
//            WebElement elm = getDriver().findElement(swipeBtn);
//            actions.moveToElement(elm).moveByOffset(-100, 0).clickAndHold().moveByOffset(200, 0).release().perform();
//        }
//
//        public Clickable getCloseButton() {
//            return Clickable.getElementBy(closeBtn, "Close Button");
//        }
//
//        public Clickable getSavedBankAccount() {
//            return Clickable.getElementBy(savedBankAccount, "Saved Bank Account Card");
//        }
//
//        public Clickable getSavedVenmoCard() {
//            return Clickable.getElementBy(SavedVenmoCard, "Venmo Card");
//        }
//
//        public Clickable getIMadeMyPaymentButton() {
//            return Clickable.getElementBy(iMadeMyPaymentButtonVenmo);
//        }
//
//        public Editable getVenmoPaymentText() {
//            return Editable.getElementBy(personalMessageVenmo);
//        }
//
//        public Clickable getScreenshotButton() {
//            return Clickable.getElementBy(screenshotButton);
//        }
//
//        // For Attaching image for Venmo payment Screenshot
//        public void uploadImageAsAttachment(String relativePath) throws AWTException {
//            String projectPath = System.getProperty("user.dir");
//            String absolutePath = Paths.get(projectPath, relativePath).toString();
//            uploadImageFile(absolutePath);
//        }
//
//        public void uploadVenmoImageScreenshot() throws AWTException {
//            uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
//        }
//
//        public Clickable getCheckButton() {
//            return Clickable.getElementBy(checkBtn, "Check Button");
//        }
//
//        public Clickable getConfirmVenmoCheckbox() {
//            return Clickable.getElementBy(confirmVenmoCheckbox);
//        }
//
//        public Clickable getVenmoSubmitButton() {
//            return Clickable.getElementBy(venmoSubmitButton);
//        }
//
//
//        //Assertion for Venmo
//        public Clickable getVenmoPopup() {
//            return Clickable.getElementBy(venmoPopup);
//        }
//
//        public Clickable getVenmoQrCode() {
//            return Clickable.getElementBy(qrVenmoPopup);
//        }
//
//        public Clickable getCopyLink() {
//            return Clickable.getElementBy(copyLink);
//        }
//
//        public Clickable getUploadedImage() {
//            return Clickable.getElementBy(getUploadedImage);
//        }
//
//
//        public Clickable getRejectButton() {
//            return Clickable.getElementBy(rejectButton, "Reject Button");
//        }
//
//        public Clickable getRejectReason() {
//            return Clickable.getElementBy(rejectReason, "Reject Reason");
//        }
//
//        public Clickable getSubmitButton() {
//            return Clickable.getElementBy(submitButton, "Submit Button");
//        }
//
//        public Editable getRejectToastMessage() {
//            return Editable.getElementBy(rejectToastMessage, "Reject Toast Message");
//        }
//
//        public Editable getConfirmationPopUpTitle() {
//            return Editable.getElementBy(confirmationPopUp, "Confirmation Pop Up");
//        }
//
//        public Clickable getSelectedBankDisplay() {
//            return Clickable.getElementBy(selectedBankDisplay);
//        }
//
//        public Clickable getProcessSuccessMsg() {
//            return Clickable.getElementBy(processSuccessMsg);
//        }
//
//        public Clickable getRateYourExperienceLink() {
//            return Clickable.getElementBy(rateYourExperienceLink);
//        }
//
//        public Clickable getViewReceiptLink() {
//            return Clickable.getElementBy(viewReceipt);
//        }
//
//        public Clickable getBlueCloseButton() {
//            return Clickable.getElementBy(closeBlueBtn);
//        }
//
//        public Clickable getTapToPayMoreLink() {
//            return Clickable.getElementBy(tapToPayMoreLink, "Tap To Pay More Link");
//        }
//
//        public Clickable getSwipeToPayButton() {
//            return Clickable.getElementBy(swipeButton, "Swipe To Pay Button");
//        }
//
//        public Clickable getAmountUpdateButton() {
//            return Clickable.getElementBy(updateButton, "Amount Update Button");
//        }
//
//        public Editable getMoreAmountField() {
//            return Editable.getElementBy(moreAmountTbx, "More Amount Field");
//        }
//
//        // Zelle Payment Methods
//        public Clickable getSavedZelleCard() {
//            return Clickable.getElementBy(savedZellePaymentButton);
//        }
//
//        public Clickable getZellePopup() {
//            return Clickable.getElementBy(zellePopup);
//        }
//
//        public Clickable getZelleCopyLink() {
//            return Clickable.getElementBy(zelleCopyLink);
//        }
//
//        public Clickable  getPaymentType(){
//            return  Clickable.getElementBy(paymentType, "Payment type on PaymentPage");
//        }
//
//        public Clickable  getUpdateAmountToPayButton(){
//            return  Clickable.getElementBy(updateAmtBtn, "Update Amount to pay button");
//        }
    public void clickOnProcessPaymentBtn() {
        staticWait(2000);
        click(processPaymentBtn);
    }

    public void clickOnProcessPayment() {
        staticWait(5000);
        hoverAndClick(processPayment, processPayment);
    }

    public void clickOnOtherBtn() {
        click(otherBtn);
    }

    public void clickOncreditCardBtn() {
        click(creditCard);
    }

    public void enterCardName(String cardNameTxt, String expiryDateTxt, String cvcTxt, String countryName) {
        staticWait(5000);
        hoverAndClick(cardName, cardName);
        actionEnterText(cardName, cardNameTxt);
        actionEnterText(expiryDate, expiryDateTxt);
        actionEnterText(cvc, cvcTxt);
        selectCountry(countryName);
    }

    public void clickOnSaveBtn() {
        click(saveBtn);
    }

    public void clickOnPaymentProcessBtn() {
        staticWait(2000);
        click(PaymentProcessBtn);
    }

    public String convertToNumberFormat(float num) {
        // Create a NumberFormat instance for the default locale
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        // Set maximum fraction digits to 2 for two decimal places
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        // Format the number and return
        return formatter.format(num);
    }

    public void enterInMemoField(String memoEnterTxt) {
        actionEnterText(memoTxtField, memoEnterTxt);
    }

    public void clickOnCashBtn() {
        staticWait(7000);
        hoverAndClick(CashBtn, CashBtn);
    }

    public void clickOnCrossIcon() {
        staticWait(3000);
        click(crossIcon);
    }


    public void clickOncrossIconOnTransactionpage() {
        staticWait(3000);
        click(crossIconOnTransactionpage);
    }

    public void clickOntranscationMenu() {
        click(transcationMenu);
    }

    public void clickOnpaidBillSection() {
        click(paidBill);
    }

    public void clickOnNotPaidLabel() {
        staticWait(3000);
        click(notPaid);
    }

    public void clickOnDeleteIcon() {
        staticWait(2000);
        click(deleteIcon);
    }

    public void clickOnthumbIcon() {
        click(thumbIcon);
    }

    public void switchToCreditCardFrame() {
        switchToFrame(creditCardInfoFrame);
    }

    public void selectCountry(String country) {
        selectDropdownByVisibleText(countryDropDown, country);
    }

    public void clickOnVenomCard() {
        click(venomoCard);
    }

    public void clickOnSignOut() {
        click(signOut);
    }

    public void clickOnZelleCard() {
        click(ZelleCard);
    }

    public void enterTxtInRecieveAmountField(String recieveAmountTxt) {
        staticWait(3000);
        actionEnterText(recieveAmountField, recieveAmountTxt);
    }


    public void clickOncrossIconOnPartialPaid() {
        click(crossIconOnPartialPaid);
    }

    public void clickOnBillIcon() {
        click(billIcon);
    }

    public void clickOnBill() {
        staticWait(2000);
        click(bill);
    }

    public void clickOnPayNowBtn() {
        staticWait(2000);
        click(payNowBtn);
    }

    public void clickOnchangeBtn() {
        staticWait(5000);
        scrollToDown();
        click(changeBtn);
    }

    public void clickOnZelleBank() {
        staticWait(4000);
        click(zelleAccount);
    }

    public void clickOnVenmoBank() {
        staticWait(4000);
        click(VenmoAccount);
    }

    public void clickOncreditCards() {
        staticWait(3000);
        click(creditCards);
    }

    public void switchToFrame() {
        staticWait(4000);
        switchToFrame(iframeForCard);
    }

    public void clickOnSwipeBtn() {
        staticWait(4000);
        click(swipeBtn);
    }

    public void swipeToPay() {
        staticWait(10000);
        Actions actions = new Actions(getDriver());
        WebElement elm = getDriver().findElement(swipeBtn);
        //  scrollToElement(swipeBtn);
        actions.moveToElement(elm).moveByOffset(-100, 0).clickAndHold().moveByOffset(200, 0).release().perform();
    }

    public void clickOnViewReciptLink() {
        staticWait(3000);
        scrollToDown();
        click(viewReciptTxt);
    }

    public void clickOnBankAccountSection() {
        staticWait(3000);
        click(bankAccountSection);
    }

    public void enterTextInAmountField(String enterTxtInamountField) {
        staticWait(2000);
        actionEnterText(amountField, enterTxtInamountField);
    }

    public void clickOnupdateBtn() {
        click(updateBtn);
    }

    public void clickOnswipeArrowBtn() {
        staticWait(5000);
        hoverAndClick(swipeArrowBtn, swipeArrowBtn);
    }

    public void swipeCard() {
        staticWait(20000);
        softAssert.assertTrue(isElementDisplayed(storeName));
        //   softAssert.assertTrue(isElementDisplayed(debitCardName));
        swipeToPay();
    }

    public void clickOnMakePaymentBtn() {
        staticWait(3000);
        hoverAndClick(makePayment, makePayment);
    }

    public void clickOnCheckBox() {
        click(selectCheckBox);
    }

    public void zelleSaveBtn() {
        click(zelleSaveBtn);
    }


    public void paymentPopup(String memoTxt) {
        softAssert.assertEquals(billHeader, "Bill");
        softAssert.assertTrue(isElementDisplayed(qrCode));
        softAssert.assertTrue(isElementDisplayed(shareBtn));
        softAssert.assertTrue(isElementDisplayed(editIcon));
        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
        softAssert.assertTrue(isElementDisplayed(NotPaid));
        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPaymentBtn();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters

        softAssert.assertEquals(totalAmt, balance);
        softAssert.assertTrue(isElementDisplayed(recieveAmtTxtField));
        softAssert.assertTrue(isElementDisplayed(creditCardButton));
        softAssert.assertTrue(isElementDisplayed(otherBtn));

        //click on others button.
        clickOnOtherBtn();

        softAssert.assertTrue(isElementDisplayed(paymentTypeText));
        String getAttMemo = getAttribute(memoTxtField, "placeholder");
        softAssert.assertEquals(getAttMemo, "Memo");

        softAssert.assertTrue(isElementDisplayed(venomoBtn));
        softAssert.assertTrue(isElementDisplayed(zelleBtn));
        softAssert.assertTrue(isElementDisplayed(CashBtn));

        enterInMemoField(memoTxt);
        clickOnCashBtn();

        softAssert.assertTrue(isElementDisplayed(paidLabel));
        softAssert.assertTrue(isElementDisplayed(cashIcon));

        clickOnCrossIcon();
        clickOntranscationMenu();
        clickOnpaidBillSection();

        softAssert.assertTrue(isElementDisplayed(amountPaidTime));
        softAssert.assertTrue(isElementDisplayed(paidlabel));
        softAssert.assertTrue(isElementDisplayed(uniqueId));
        softAssert.assertTrue(isElementDisplayed(refundIcon));
        softAssert.assertTrue(isElementDisplayed(verifyIcon));

        clickOncrossIconOnTransactionpage();

    }

    public void paymentByCreditCard(String cardNumber, String expiryDateTxt, String cvcTxt, String countryName) {

        softAssert.assertEquals(billHeader, "Bill");
        softAssert.assertTrue(isElementDisplayed(qrCode));
        softAssert.assertTrue(isElementDisplayed(shareBtn));
        softAssert.assertTrue(isElementDisplayed(editIcon));
        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
        softAssert.assertTrue(isElementDisplayed(NotPaid));
        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPayment();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters

        softAssert.assertEquals(totalAmt, balance);
        softAssert.assertTrue(isElementDisplayed(recieveAmtTxtField));
        softAssert.assertTrue(isElementDisplayed(creditCardButton));
        softAssert.assertTrue(isElementDisplayed(otherBtn));

        //click on others button.
        clickOncreditCardBtn();
        switchToCreditCardFrame();
        enterCardName(cardNumber, expiryDateTxt, cvcTxt, countryName);
        switchToDefaultContent();

        clickOnPaymentProcessBtn();
        softAssert.assertTrue(isElementDisplayed(paidLabel));
        softAssert.assertTrue(isElementDisplayed(visaIcon));

        clickOnCrossIcon();

        clickOntranscationMenu();
        clickOnpaidBillSection();

        softAssert.assertTrue(isElementDisplayed(amountPaidTime));
        softAssert.assertTrue(isElementDisplayed(paidlabel));
        softAssert.assertTrue(isElementDisplayed(uniqueId));
        softAssert.assertTrue(isElementDisplayed(refundIcon));
        softAssert.assertTrue(isElementDisplayed(verifyIcon));

        clickOncrossIconOnTransactionpage();
    }


    public void paymentThroughVenomo() {
        softAssert.assertEquals(billHeader, "Bill");
        softAssert.assertTrue(isElementDisplayed(qrCode));
        softAssert.assertTrue(isElementDisplayed(shareBtn));
        softAssert.assertTrue(isElementDisplayed(editIcon));
        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
        softAssert.assertTrue(isElementDisplayed(NotPaid));
        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPaymentBtn();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters

        softAssert.assertEquals(totalAmt, balance);
        softAssert.assertTrue(isElementDisplayed(recieveAmtTxtField));
        softAssert.assertTrue(isElementDisplayed(creditCardButton));
        softAssert.assertTrue(isElementDisplayed(otherBtn));

        //click on others button.
        clickOnOtherBtn();
        clickOnVenomCard();
        softAssert.assertTrue(isElementDisplayed(paidLabel));
        softAssert.assertTrue(isElementDisplayed(venmoIcon));

        clickOnCrossIcon();

        clickOntranscationMenu();
        clickOnpaidBillSection();

        softAssert.assertTrue(isElementDisplayed(amountPaidTime));
        softAssert.assertTrue(isElementDisplayed(paidlabel));
        softAssert.assertTrue(isElementDisplayed(uniqueId));
        softAssert.assertTrue(isElementDisplayed(refundIcon));
        softAssert.assertTrue(isElementDisplayed(verifyIcon));

        clickOncrossIconOnTransactionpage();

    }

    public void paymentThroughZelle() {
        softAssert.assertEquals(billHeader, "Bill");
        softAssert.assertTrue(isElementDisplayed(qrCode));
        softAssert.assertTrue(isElementDisplayed(shareBtn));
        softAssert.assertTrue(isElementDisplayed(editIcon));
        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
        softAssert.assertTrue(isElementDisplayed(NotPaid));
        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPaymentBtn();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters

        softAssert.assertEquals(totalAmt, balance);
        softAssert.assertTrue(isElementDisplayed(recieveAmtTxtField));
        softAssert.assertTrue(isElementDisplayed(creditCardButton));
        softAssert.assertTrue(isElementDisplayed(otherBtn));

        //click on others button.
        clickOnOtherBtn();
        clickOnZelleCard();
        softAssert.assertTrue(isElementDisplayed(paidLabel));
        softAssert.assertTrue(isElementDisplayed(zelleIcon));

        clickOnCrossIcon();

        clickOntranscationMenu();
        clickOnpaidBillSection();

        softAssert.assertTrue(isElementDisplayed(amountPaidTime));
        softAssert.assertTrue(isElementDisplayed(paidlabel));
        softAssert.assertTrue(isElementDisplayed(uniqueId));
        softAssert.assertTrue(isElementDisplayed(refundIcon));
        softAssert.assertTrue(isElementDisplayed(verifyIcon));

        clickOncrossIconOnTransactionpage();

    }

    public void PaymentByMultipleMode(String partialAmount, String partialAmounts, String totalAmount) {
        softAssert.assertEquals(billHeader, "Bill");
        softAssert.assertTrue(isElementDisplayed(qrCode));
        softAssert.assertTrue(isElementDisplayed(shareBtn));
        softAssert.assertTrue(isElementDisplayed(editIcon));
        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
        softAssert.assertTrue(isElementDisplayed(NotPaid));
        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPaymentBtn();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters


        enterTxtInRecieveAmountField(partialAmount);

        //click on others button.
        clickOnOtherBtn();
        clickOnCashBtn();

        //Cash through zelle
        enterTxtInRecieveAmountField(partialAmounts);

        //click on others button.
        clickOnOtherBtn();
        clickOnZelleCard();

        //Cash through zelle
        enterTxtInRecieveAmountField(totalAmount);

        //click on others button.
        clickOnOtherBtn();
        clickOnVenomCard();


        clickOnCrossIcon();

        clickOntranscationMenu();
        clickOnpaidBillSection();

        softAssert.assertTrue(isElementDisplayed(partialAmountPaidTime));
        softAssert.assertTrue(isElementDisplayed(paidlabel));
        softAssert.assertTrue(isElementDisplayed(uniqueId));
        softAssert.assertTrue(isElementDisplayed(refundIcon));
        softAssert.assertTrue(isElementDisplayed(verifyIcon));

        clickOncrossIconOnTransactionpage();

    }

    public void partialPayment(String partialAmount) {
        String payAmt = "1,185.25";
        softAssert.assertEquals(billHeader, "Bill");
        softAssert.assertTrue(isElementDisplayed(qrCode));
        softAssert.assertTrue(isElementDisplayed(shareBtn));
        softAssert.assertTrue(isElementDisplayed(editIcon));
        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
        softAssert.assertTrue(isElementDisplayed(NotPaid));
        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPaymentBtn();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters


        enterTxtInRecieveAmountField(partialAmount);

        //click on others button.
        clickOnOtherBtn();

        //Verify Total Paid Amount
        float amount = Float.parseFloat(partialAmount.replace(",", ""));
        float updateAmount = Float.parseFloat(payAmt.replace(",", ""));
        float expBalanceDue = amount - updateAmount;
        String expectedBalanceDue = convertToNumberFormat(expBalanceDue);
        Log.info(expectedBalanceDue);

        clickOnCashBtn();
        clickOnCrossIcon();
        clickOnNotPaidLabel();

        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(dueAmount));
        softAssert.assertTrue(isElementDisplayed(paidAmount));
        softAssert.assertTrue(isElementDisplayed(paidBillUniqueid));

        // clickOncrossIconOnPartialPaid();
        clickOnCrossIcon();
    }

    public void markSuccessfulPaymentAsVoid(String memoTxt) {
        softAssert.assertEquals(billHeader, "Bill");
        softAssert.assertTrue(isElementDisplayed(qrCode));
        softAssert.assertTrue(isElementDisplayed(shareBtn));
        softAssert.assertTrue(isElementDisplayed(editIcon));
        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
        softAssert.assertTrue(isElementDisplayed(NotPaid));
        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPaymentBtn();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters

        softAssert.assertEquals(totalAmt, balance);
        softAssert.assertTrue(isElementDisplayed(recieveAmtTxtField));
        softAssert.assertTrue(isElementDisplayed(creditCardButton));
        softAssert.assertTrue(isElementDisplayed(otherBtn));

        //click on others button.
        clickOnOtherBtn();

        softAssert.assertTrue(isElementDisplayed(paymentTypeText));
        String getAttMemo = getAttribute(memoTxtField, "placeholder");
        softAssert.assertEquals(getAttMemo, "Memo");

        softAssert.assertTrue(isElementDisplayed(venomoBtn));
        softAssert.assertTrue(isElementDisplayed(zelleBtn));
        softAssert.assertTrue(isElementDisplayed(CashBtn));

        enterInMemoField(memoTxt);
        clickOnCashBtn();

        softAssert.assertTrue(isElementDisplayed(paidLabel));
        softAssert.assertTrue(isElementDisplayed(cashIcon));

        clickOnDeleteIcon();
        clickOnthumbIcon();
        softAssert.assertTrue(isElementDisplayed(voided));

        softAssert.assertEquals(totalAmt, balance);
        Log.info("Numeric Value: " + totalAmt);
        Log.info("Numeric Value: " + balance);
        softAssert.assertTrue(isElementDisplayed(recieveAmtTxtField));

    }

    public void billPaymentByCustomer() {
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(visaCardName));
        swipeToPay();
        softAssert.assertTrue(isElementDisplayed(thankTxt));
        softAssert.assertTrue(isElementDisplayed(youTxt));
        scrollToDown();
        softAssert.assertTrue(isElementDisplayed(rateYourExpTxt));
        softAssert.assertTrue(isElementDisplayed(viewReciptTxt));

        clickOnViewReciptLink();
        softAssert.assertTrue(isElementDisplayed(transactionHeader));
        softAssert.assertTrue(isElementDisplayed(tarnsactionUniqueId));
        softAssert.assertTrue(isElementDisplayed(paymentMethodIcon));

    }

    public void billPayment() {

        staticWait(5000);
        softAssert.assertTrue(isElementDisplayed(thankTxt));
        softAssert.assertTrue(isElementDisplayed(youTxt));
        scrollToDown();
        softAssert.assertTrue(isElementDisplayed(rateYourExpTxt));
        softAssert.assertTrue(isElementDisplayed(viewReciptTxt));
        staticWait(2000);
        clickOnViewReciptLink();
        softAssert.assertTrue(isElementDisplayed(transactionHeader));
        softAssert.assertTrue(isElementDisplayed(tarnsactionUniqueId));
        softAssert.assertTrue(isElementDisplayed(paymentMethodIcon));

    }

    public void billPaymentByThroughDebitCard(String cardNameTxt, String expiryDateTxt, String cvcTxt, String countryName) {
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        //  softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(visaCardName));
        clickOnchangeBtn();
        clickOncreditCards();
        switchToFrame();
        enterCardName(cardNameTxt, expiryDateTxt, cvcTxt, countryName);
        switchToDefaultContent();
        staticWait(10000);
        clickOnSaveBtn();

    }


    public void paymentThrouhBankAccount() {
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(visaCardName));
        clickOnchangeBtn();
        clickOnBankAccountSection();
    }

    public void billPaymentByVariousPaymentMethods(String enterTextInAmountField, String cardNameTxt, String expiryDateTxt, String cvcTxt, String countryName) {
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        softAssert.assertTrue(isElementDisplayed(storeName));
        // softAssert.assertTrue(isElementDisplayed(visaCardName));
        clickOnswipeArrowBtn();
        enterTextInAmountField(enterTextInAmountField);
        clickOnupdateBtn();
        clickOnchangeBtn();
        clickOncreditCards();
        switchToFrame();
        enterCardName(cardNameTxt, expiryDateTxt, cvcTxt, countryName);
        switchToDefaultContent();
        staticWait(10000);
        clickOnSaveBtn();

    }

    public void paymentByBankAccount(String enterTextInAmountField) {
        clickOnchangeBtn();
        clickOnBankAccountSection();
        clickOnswipeArrowBtn();
        enterTextInAmountField(enterTextInAmountField);
        clickOnupdateBtn();
    }

    public void clickOnZelleAccount() {
        clickOnchangeBtn();
        clickOnZelleBank();
    }

    public void clickOnVenmoAccount() {
        clickOnchangeBtn();
        clickOnVenmoBank();
    }

    public void paymentByZelleAccount() {
        clickOnZelleAccount();
        clickOnMakePaymentBtn();
        clickOnCheckBox();
        zelleSaveBtn();
        billPayment();
    }


    public void paymentThrouhVenmoAccount() {
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
       // softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(visaCardName));
        clickOnchangeBtn();
        clickOnVenmoAccount();
        clickOnMakePaymentBtn();
        clickOnCheckBox();
        zelleSaveBtn();
        billPayment();
    }


}