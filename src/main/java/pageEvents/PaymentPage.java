package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Constants;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import static pageEvents.LoginPage.LoginAsCustomer;
import static pageEvents.TransactionsPage.attentionHeader;
import static pageEvents.TransactionsPage.okButn;

public class PaymentPage extends BaseTest {

    PaymentMethod payment = new PaymentMethod();


    // Payment popup locators

    By countryDropDown = By.id("Field-countryInput");
    /*
    Receive Payment Locators
     */

    By cardNumberTbx = By.xpath("//input[@id='Field-numberInput']");
    By expirationDateTbx = By.xpath("//input[@id='Field-expiryInput']");
    By cvcTbx = By.xpath("//input[@id='Field-cvcInput']");
    By autoPaymentCardFrame = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]");

    public By swipeBtn = By.xpath("//input[@class='slider -pm-none-']");


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
    By paidLabel = By.xpath("//div[normalize-space()='Paid']");
    By cashIcon = By.xpath("(//span[text()='Cash']/../child::span)[3]");
    By crossIcon = By.xpath("//div[contains (@class, 'modal fade show')]//button[@class='btn-close']");
    By crossIconOnTransactionpage = By.xpath("//button[@class='btn-close']");
    By transcationMenu = By.xpath("(//div[text()='Transactions'])[2]");
    By paidBill = By.xpath("//div[contains(@class,'bg-white border')][1]");
    By amountPaidTime = By.xpath("(//span[@class='fs-pn15'])[4]");
    By partialAmountPaidTime = By.xpath("(//span[@class='fs-pn15'])[1]");
    By paidlabel = By.xpath("//span[text()='Paid']");
    By uniqueId = By.xpath("//span[contains(@class,'badge position-relative bg-light text-dark p-1 px-2 text-truncate f')]");
    By refundIcon = By.xpath("//button[text()='Refund']");
    By verifyIcon = By.xpath("//button[text()='Verify']");
    By creditCardInfoFrame = By.xpath("//h5[text()='Credit card information']/../..//iframe");
    By expiryDate = By.xpath("//input[@name='expiry']");
    By cvc = By.xpath("//input[@name='cvc']");
    By PaymentProcessBtn = By.xpath("//button[contains(text(),'Process')]");
    By visaIcon = By.xpath("//span[text()='Visa']/..");
    By venmoIcon = By.xpath("(//span[text()='Venmo'])[2]");
    By zelleIcon = By.xpath("(//span[text()='Zelle'])[2]");
    By notPaid = By.xpath("//div[contains(@class, 'row bg-white')][1]");
    By deleteIcon = By.xpath("//i[@class='fa fa-trash text-danger']/../.");
    By voided = By.xpath("//h6[text()='VOIDED']");
    By signOut = By.xpath("//a[text()='Sign out']");
    By attentionPopup = By.xpath("//h4[text()='Attention!']");
    By okBtn = By.xpath("//button[text()='OK']");
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
    By debitCardName = By.xpath("(//span[contains(text(),'Visa')])[5]");
    By changeBtn = By.xpath("//div[normalize-space()='Change']");
    By visaCardName = By.xpath("(//span[contains(text(),'Visa')])[3]");
    By creditCards = By.xpath("//span[text()='New Credit Card']/../../../..");
    By iframeForCard = By.xpath("(//div[@class='StripeElement']//div/iframe[contains(@name,'__privateStripeFrame')])[2]");
    By iframeForCreditCard = By.xpath("//div[@class='StripeElement']//div/iframe[contains(@name,'__privateStripeFrame')]");
    public By saveBtn = By.xpath("//button[text()='Save']");
    By thankTxt = By.xpath("//span[text()='Thank']");
    By youTxt = By.xpath("//span[text()='You!']");
    By rateYourExpTxt = By.xpath("//div[normalize-space()='Rate your experience']");
    public By viewReciptTxt = By.xpath("//a[text()='View the receipt']");
    By transactionHeader = By.xpath("//h1[normalize-space()='Transaction Detail']");
    By tarnsactionUniqueId = By.xpath("(//span[contains(text(),'TR-')])[2]");
    By paymentMethodIcon = By.xpath("//span[contains(@class,'payment-logo-bg-sm')]");
    By bankAccountSection = By.xpath("(//span[contains(text(),'New Bank Account')])/../../../..");
    By amountField = By.xpath("(//form//input[@name='amount'])[2]");
    By bankAccount = By.xpath("(//span[text()='Bank Account 6789'])[1]");
    By emailField = By.cssSelector("#Field-emailInput");
    By nameField = By.cssSelector("#Field-nameInput");
    By bankFrame = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[2]");
    By frame = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[3]");
    By header = By.xpath("(//h5[text()='New payment method'])[2]");
    By fullName = By.xpath("//input[@id='Field-nameInput']");
    By testInstitution = By.xpath("//p[text()='Test Institution']");
    By saveBtnOnNewPaymentPopUp = By.xpath("//button[text()='Save']");
    By agreeAndCounBtn = By.xpath("//span[text()='Agree and continue']/..");
    By connectAccount = By.xpath("//span[text()='Connect account']/..");
    By phoneNumber = By.xpath("//span[text()='Phone number']/..");
    By saveWithLinkBtn = By.xpath("//span[text()='Save with Link']/..");
    By backToKadePayBtn = By.xpath("//span[text()='Back to Kade Pay']/..");


    By updateBtn = By.xpath("(//button[text()='Update'])[2]");
    By swipeArrowBtn = By.xpath("//input[@type='range']/..//span[contains(text(),'$')]/..");
    By zelleAccount = By.xpath("//span[text()='Zelle']/../../../..");
    By VenmoAccount = By.xpath("//span[text()='Venmo']/../../../..");

    By makePayment = By.xpath("//button[text()='I made the payment']");
    By selectCheckBox = By.xpath("(//span[text()='Confirm your payment by checking this box']/../i)[2]");
    By zelleSaveBtn = By.xpath("//button[text()='Submit']");
    By payCurrentBalance = By.xpath("//button[text()='Pay the current balance']/..");
    By paymentSaveBtn = By.xpath("//button[text()='Save']");

    // Affirm payment button
    By affirmAccount = By.xpath("//span[text()='Affirm']/../../../..");
    By processBtnOfAffirm = By.xpath("//button[starts-with(text(),'Process')]");
    By paymentInformationTitle = By.xpath("//h5[text()='Payment information']");
    By affirmTestPageTitle = By.xpath("//h1[@class='common-SectionTitle']");
    By authorizeTestPaymentBtn = By.xpath("//button[starts-with(text(),'Authorize Test Payment')]");
    public By paymentDetails = By.xpath("//span[starts-with(@class,'payment-logo-bg-sm')]/../../..");
    By moreDetailsBtn = By.xpath("//button[contains(@class,'btn btn-link w-100')]//i/..");
    public By moreDetails = By.xpath("//div[@class='card-body collapse show']");
    public By PaymentMethodTitle = By.xpath("//h3[text()='Payment Methods']");
    public By addORModifyPaymentLink = By.xpath("//a[text()='Add or modify payment methods']");
    public By addPaymentButton = By.xpath("//button[text()='Add Payment Method']");
    public By addNewPaymentMethodTitle = By.xpath("//h5[text()='Add new payment method']");
    public By creditCardOption = By.xpath("(//span[@class='payment-logo-bg me-2'])[1]/..");
    public By bankAccountOption = By.xpath("(//span[@class='payment-logo-bg me-2']//..)[2]");
    public By crossIconAddNewPaymentPopup = By.xpath("//button[@class='btn-close text-reset']");
    public By newPaymentMethodPopupTitle = By.xpath("//h5[text()='New payment method']");
    By nePaymentPopUp = By.xpath("(//h5[text()='New payment method'])[4]");
    public By bankEmailField = By.cssSelector("[name=email]");
    public By fullNameBField = By.cssSelector("[placeholder='First and last name']");
    public By testInsituteBtn = By.xpath("//p[text()='Test Institution']");
    public By LogInWithTestInstitutionLabel = By.xpath("//div[contains(@class,'LightboxModalContent')]//h1[text()='Log in with Test Institution']");
    public By agreeAndContinueBtn = By.xpath("//span[text()='Agree and continue']/..");
    public By successOption = By.xpath("//div[contains(@class, 'la-v3-accountPicker')]//div/p[text()='Success']");
    public By continueAccount = By.xpath("(//span[text()='Connect account']//..)[2]");
    public By saveWithLink = By.xpath("//span[text()='Save with Link']/..");
    public By notNow = By.xpath("//span[text()='Not now']/..");
    public By backToKadePay = By.xpath("//span[text()='Back to Kade Pay']/..");
    public By finalSavebtn = By.xpath("//button[contains (@class, 'btn btn-primary ') and text()='Save']");
    public By loginInsitututeFrame = By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[1]");
    public By successText = By.xpath("//div[contains(@class,'la-v3-successTextWrapper')]//h1");
    public By stripeBankAccountText = By.xpath("//div[contains(@class,'p-PickerItem--singleRow')]//../h3");
    public By visaCardText = By.xpath("//span[normalize-space()='Visa 1111']");
    public By trash = By.xpath("//i[@class='fas fa-trash']//..");
    public By noPaymentInfo = By.xpath("//div[@class='no-result-icon']/../p");

    // Methods
    public void getAddOrModifyPaymentLink() {
        click(addORModifyPaymentLink);
    }

    public void getAddPaymentButton() {
        click(addPaymentButton);
    }

    public void getCreditCardOption() {
        click(creditCardOption);
        staticWait(2000);
    }

    public void clickOnPaymentSaveBtn() {
        click(paymentSaveBtn);
    }

    public void getCrossIconOfNewP() {
        click(crossIconAddNewPaymentPopup);
    }

    public void getTestInsituteBtn() {
        click(testInsituteBtn);
    }

    public void getAgreeAndContinueBtn() {
        scrollToElement(agreeAndContinueBtn);
        click(agreeAndContinueBtn);
    }

    public void getSuccessOption() {
        click(successOption);
    }

    public void getConnectAccountBtn() {
        click(continueAccount);
    }

    public void getSaveWithLinkBtn() {
        click(saveWithLink);
    }

    public void getNotNow() {
        click(notNow);
    }

    public void getBackToKadePayBtn() {
        click(backToKadePay);
    }

    public void getFinalSaveBtn() {
        click(finalSavebtn);
    }

    public void getTrashIcon() {
        clickElementByJS(trash);
    }

    public void getThumbIcon() {
        clickElementByJS(thumbIcon);
    }


    public void clickOnAffirmButton() {
        click(affirmAccount);
    }

    public void getProcessButtonOfAffirm() {
        click(processBtnOfAffirm);
    }

    public void getAuthorizeTestPaymentBtn() {
        click(authorizeTestPaymentBtn);
    }

    public void getPayemntDetails() {
        click(paymentDetails);
    }

    public void getMoreDetailsBtn() {
        clickElementByJS(moreDetailsBtn);
    }

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
        scrollToElement(saveBtn);
        waitForElementToBeClickable(saveBtn, 4);
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
        staticWait(2000);
        click(transcationMenu);
    }

    public void clickOnpaidBillSection() {
        click(paidBill);
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
        staticWait(3000);
        click(signOut);
    }

    public void clickOnZelleCard() {
        click(ZelleCard);
    }

    public void enterTxtInRecieveAmountField(String recieveAmountTxt) {
        staticWait(3000);
        actionEnterText(recieveAmountField, recieveAmountTxt);
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
        scrollToElement(changeBtn);
        staticWait(4000);
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
        staticWait(3000);
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
        staticWait(2000);
        scrollToElement(viewReciptTxt);
        click(viewReciptTxt);
    }

    public void clickOnBankAccountSection() {
        staticWait(3000);
        click(bankAccountSection);
    }


    public void clickOnPaymentMethod(String emailFieldTxt) {
        staticWait(3000);
        actionEnterText(emailField, emailFieldTxt);
    }

    public void enterTxtInnameField(String nameFieldTxt) {
        staticWait(3000);
        actionEnterText(nameField, nameFieldTxt);
    }

    public void enterTxtInfullNameField(String fullNameFieldTxt) {
        staticWait(3000);
        actionEnterText(fullName, fullNameFieldTxt);
    }

    public void clickOntestInstitution() {
        staticWait(3000);
        click(testInstitution);
    }

    public void clickOnsaveBtnOnNewPaymentPopUp() {
        scrollToElement(saveBtnOnNewPaymentPopUp);
        click(saveBtnOnNewPaymentPopUp);
    }

    public void clickOnagreeAndCounBtn() {
        click(agreeAndCounBtn);
    }

    public void clickOnconnectAccount() {
        click(connectAccount);
    }

    public void enterInPhoneTxt(String phoneNum) {
        actionEnterText(phoneNumber, phoneNum);
    }

    public void clickOnsaveWithLink() {
        click(saveWithLinkBtn);
    }

    public void clickOnbackToKadePayBtn() {
        click(backToKadePayBtn);
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
        click(swipeArrowBtn);
    }

    public void clickOnBankAccount() {
        click(bankAccount);
    }


    public void swipeCard() {
        staticWait(5000);
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

    public void clickOnRejectBtn() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//i[@class='fal fa-circle custom-check-off ']"));
        for (WebElement element : elements) {
            String resonsName = element.getText();
            Log.info(resonsName);
            element.click();
            ;
        }
    }


    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }

    public void clickOnNotPaidLabel() {
        staticWait(3000);
        hoverAndClick(notPaid, notPaid);
    }


    public void paymentPopup(String memoTxt) {
        String billHead = getText(billHeader);
        Assert.assertEquals(billHead, "Bill");

        Assert.assertTrue(isElementDisplayed(qrCode));
        Assert.assertTrue(isElementDisplayed(shareBtn));
        Assert.assertTrue(isElementDisplayed(editIcon));
        Assert.assertTrue(isElementDisplayed(processPaymentBtn));
        Assert.assertTrue(isElementDisplayed(deleteIconBtn));
        Assert.assertTrue(isElementDisplayed(uniqueNumber));
        Assert.assertTrue(isElementDisplayed(BillCreatedTime));
        Assert.assertTrue(isElementDisplayed(NotPaid));
        // Assert.assertTrue(isElementDisplayed(tapToAddFile));


        // Click on Process payment button in Bill popup
        clickOnProcessPaymentBtn();
        staticWait(2000);
        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters

        Assert.assertEquals(totalAmt, balance);
        Assert.assertTrue(isElementDisplayed(recieveAmtTxtField));
        Assert.assertTrue(isElementDisplayed(creditCardButton));
        Assert.assertTrue(isElementDisplayed(otherBtn));

        //click on others button.
        clickOnOtherBtn();

        staticWait(2000);
        Assert.assertTrue(isElementDisplayed(paymentTypeText));

        String getAttMemo = getAttribute(memoTxtField, "placeholder");
        Assert.assertEquals(getAttMemo, "Memo");

        Assert.assertTrue(isElementDisplayed(venomoBtn));
        Assert.assertTrue(isElementDisplayed(zelleBtn));
        Assert.assertTrue(isElementDisplayed(CashBtn));


        enterInMemoField(memoTxt);
        clickOnCashBtn();

        //  Assert.assertTrue(isElementDisplayed(paidLabel));
        Assert.assertTrue(isElementDisplayed(cashIcon));

        clickOnCrossIcon();
        clickOntranscationMenu();
        clickOnpaidBillSection();

        Assert.assertTrue(isElementDisplayed(amountPaidTime));

        Assert.assertTrue(isElementDisplayed(paidlabel));

        Assert.assertTrue(isElementDisplayed(uniqueId));

        Assert.assertTrue(isElementDisplayed(refundIcon));
        Assert.assertTrue(isElementDisplayed(verifyIcon));

        clickOncrossIconOnTransactionpage();

    }

    public void paymentByCreditCard(String cardNumber, String expiryDateTxt, String cvcTxt, String countryName) {
        staticWait(2000);
//        softAssert.assertEquals(billHeader, "Bill");
//        softAssert.assertTrue(isElementDisplayed(qrCode));
//        softAssert.assertTrue(isElementDisplayed(shareBtn));
//        softAssert.assertTrue(isElementDisplayed(editIcon));
//        softAssert.assertTrue(isElementDisplayed(processPaymentBtn));
//        softAssert.assertTrue(isElementDisplayed(deleteIconBtn));
//        softAssert.assertTrue(isElementDisplayed(uniqueNumber));
//        softAssert.assertTrue(isElementDisplayed(BillCreatedTime));
//        softAssert.assertTrue(isElementDisplayed(NotPaid));
//        softAssert.assertTrue(isElementDisplayed(tapToAddFile));

        String billHead = getText(billHeader);
        Assert.assertEquals(billHead, "Bill");

        Assert.assertTrue(isElementDisplayed(qrCode));
        Assert.assertTrue(isElementDisplayed(shareBtn));
        Assert.assertTrue(isElementDisplayed(editIcon));
        Assert.assertTrue(isElementDisplayed(processPaymentBtn));
        Assert.assertTrue(isElementDisplayed(deleteIconBtn));
        Assert.assertTrue(isElementDisplayed(uniqueNumber));
        Assert.assertTrue(isElementDisplayed(BillCreatedTime));
        Assert.assertTrue(isElementDisplayed(NotPaid));
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(tapToAddFile));

        // Click on Process payment button in Bill popup
        clickOnProcessPayment();

        String recievePaymentTxt = getText(totalAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String totalAmt = recievePaymentTxt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + balance); // Output: 1000.00// Remove non-numeric characters

//        softAssert.assertEquals(totalAmt, balance);
//        softAssert.assertTrue(isElementDisplayed(recieveAmtTxtField));
//        softAssert.assertTrue(isElementDisplayed(creditCardButton));
//        softAssert.assertTrue(isElementDisplayed(otherBtn));

        Assert.assertEquals(totalAmt, balance);
        Assert.assertTrue(isElementDisplayed(recieveAmtTxtField));
        Assert.assertTrue(isElementDisplayed(creditCardButton));
        Assert.assertTrue(isElementDisplayed(otherBtn));

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
        String totalAmt = recievePaymentTxt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[^0-9.]", "");
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
        String totalAmt = recievePaymentTxt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[^0-9.]", "");
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
        staticWait(2000);
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
        String totalAmt = recievePaymentTxt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[^0-9.]", "");
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
        String totalAmt = recievePaymentTxt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[^0-9.]", "");
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
        String totalAmt = recievePaymentTxt.replaceAll("[^0-9.]", "");
        Log.info("Numeric Value: " + totalAmt); // Output: 1000.00// Remove non-numeric characters

        String balanceSAmt = getText(balanceAmt); // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String balance = balanceSAmt.replaceAll("[^0-9.]", "");
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
        staticWait(3000);
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        if (isElementDisplayed(payCurrentBalance)) {
            hoverAndClick(payCurrentBalance, payCurrentBalance);
        } else {
            Log.info("Nothing to be selected");
        }
        //  softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(visaCardName));
        clickOnchangeBtn();
        clickOncreditCards();
        switchToFrame();
        enterCardName(cardNameTxt, expiryDateTxt, cvcTxt, countryName);
        switchToDefaultContent();
        staticWait(5000);
        clickOnSaveBtn();

    }


    public void paymentThrouhBankAccount() {
        staticWait(3000);
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        if (isElementDisplayed(payCurrentBalance)) {
            hoverAndClick(payCurrentBalance, payCurrentBalance);
        } else {
            Log.info("Nothing to be selected");
        }
        //   softAssert.assertTrue(isElementDisplayed(storeName));
        // softAssert.assertTrue(isElementDisplayed(visaCardName));
        clickOnchangeBtn();
        staticWait(3000);
        clickOnBankAccountSection();

        staticWait(3000);
        if (isElementDisplayed(newPaymentMethodPopupTitle)) {

            // Verify that new payment method popup
            waitForElementToBeVisible(newPaymentMethodPopupTitle, 5);
            Assert.assertTrue(isElementDisplayed(newPaymentMethodPopupTitle), "New Payment Method Popup Title");

            switchToFrame(bankFrame);
            waitForElementToBeClickable(bankEmailField, 5);

            // enter email and full name
            actionEnterText(bankEmailField, Constants.validLoginEmail);
            actionEnterText(fullNameBField, Constants.nameInput);
            getTestInsituteBtn();
            staticWait(5000);
            switchToDefaultContent();
            //  waitForPageLoad();
            staticWait(3000);
            //  switchToFrame(bankFrame);

            getAgreeAndContinueBtn();

            // wait till bank options
            staticWait(5000);
            getSuccessOption();
            getConnectAccountBtn();

            staticWait(5000);

            getSaveWithLinkBtn();

            staticWait(5000);

            // Verify that success text appears
            Assert.assertTrue(isElementDisplayed(successText), "Success Text");

            getBackToKadePayBtn();
            switchToDefaultContent();
            staticWait(5000);
            switchToFrame(bankFrame);

//        waitForElementToBeVisible(paymentMethod.stripeBankAccountText,5);
            System.out.println("Bank Account name is " + getText(stripeBankAccountText));
            Assert.assertEquals(getText(stripeBankAccountText), "Stripebank");
            switchToDefaultContent();
            waitForElementToBeClickable(finalSavebtn, 5);
            getFinalSaveBtn();

            staticWait(5000);
            getTrashIcon();
            getThumbIcon();
        } else {
            Log.info("Payment POP up not displayed");
        }


        // paymentThrougBankAccount();
        //  paymentMethodPopUp(email,name, fullNameField, phoneTxt);
        payment.getBankAccountDetails();


    }

    public void billPaymentByVariousPaymentMethods(String enterTextInAmountField, String cardNameTxt, String expiryDateTxt, String cvcTxt, String countryName) {
        staticWait(3000);
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        if (isElementDisplayed(payCurrentBalance)) {
            hoverAndClick(payCurrentBalance, payCurrentBalance);
        } else {
            Log.info("Nothing to be selected");
        }
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

    public void clickOnZelleAccount() {
        clickOnchangeBtn();
        clickOnZelleBank();
    }

    public void getPayThroughCreditCard() {
        switchToFrame();
        scrollToElement(cardNumberTbx);
        actionEnterText(cardNumberTbx, "4111111111111111");
        actionEnterText(expirationDateTbx, "0230");
        actionEnterText(cvcTbx, "123");
        actionEnterText(countryDropDown, "Australia");
        switchToDefaultWindow();
    }


    public void getPayThroughCreditCardForAddingPayment() {
        waitForElementToBeVisible(iframeForCreditCard, 20);
        switchToFrame(iframeForCreditCard);
        scrollToElement(cardNumberTbx);
        actionEnterText(cardNumberTbx, "4111111111111111");
        actionEnterText(expirationDateTbx, "0230");
        actionEnterText(cvcTbx, "123");
        actionEnterText(countryDropDown, "Australia");
        switchToDefaultWindow();
        staticWait(5000);
    }

    public void clickOnVenmoAccount() {
        clickOnchangeBtn();
        clickOnVenmoBank();
    }

    public void clickOnVenomoAccount() {
        clickOnVenmoAccount();
        clickOnMakePaymentBtn();
        clickOnCheckBox();
        zelleSaveBtn();
    }


    public void paymentByZelleAccount() {
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        if (isElementDisplayed(payCurrentBalance)) {
            hoverAndClick(payCurrentBalance, payCurrentBalance);
        } else {
            Log.info("Nothing to be selected");
        }

        // softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(visaCardName));
        clickOnZelleAccount();
        clickOnMakePaymentBtn();
        clickOnCheckBox();
        zelleSaveBtn();
        billPayment();
    }


    public void paymentThrouhVenmoAccount() {
        staticWait(3000);
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        if (isElementDisplayed(payCurrentBalance)) {
            hoverAndClick(payCurrentBalance, payCurrentBalance);
        } else {
            Log.info("Nothing to be selected");
        }
        staticWait(4000);
        clickOnVenmoAccount();
        clickOnMakePaymentBtn();
        clickOnCheckBox();
        zelleSaveBtn();
        billPayment();
    }

    public void RejectABill() {
        staticWait(3000);
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnRejectBtn();

    }

    public void paymentMethodPopUp(String emailTxtField, String nameTxtField, String fullNameField, String phoneTxt) {
        if (isElementDisplayed(header)) {
            switchToFrame(bankFrame);
            clickOnPaymentMethod(emailTxtField);
            enterTxtInnameField(nameTxtField);
            enterTxtInfullNameField(fullNameField);
            clickOntestInstitution();
            switchToDefaultContent();
            clickOnagreeAndCounBtn();
            clickOnconnectAccount();
            enterInPhoneTxt(phoneTxt);
            clickOnsaveWithLink();
            clickOnbackToKadePayBtn();
            clickOnsaveBtnOnNewPaymentPopUp();
        } else {
            Log.info("Do payment");
        }

    }

    public void billPaymentByThroughDebitCardWithRecurringBill(String cardNameTxt, String expiryDateTxt, String cvcTxt, String countryName) {
        staticWait(3000);
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();
        if (isElementDisplayed(notPaid)) {
            hoverAndClick(notPaid, notPaid);
        } else {
            Log.info("Nothing to be selected");
        }
        if (isElementDisplayed(attentionHeader)) {
            hoverAndClick(okButn, okButn);
        } else {
            Log.info("Nothing to be selected");
        }
        // Clicking on Ok button of Attention popup
        staticWait(3000);
        clickOnchangeBtn();
        clickOncreditCards();
        switchToFrame();
        enterCardName(cardNameTxt, expiryDateTxt, cvcTxt, countryName);
        switchToDefaultContent();
        if (isElementDisplayed(attentionPopup)) {
            click(okBtn);
        } else {
            Log.info("Countinue");
        }
        staticWait(10000);
        clickOnSaveBtn();
    }

    public void billPaymentThroughAffirmMethod() {
        staticWait(3000);
        clickOnSignOut();
        LoginAsCustomer();
        clickOnBillIcon();
        clickOnBill();
        clickOnPayNowBtn();

        staticWait(3000);
        clickOnchangeBtn();

        waitForElementToBeVisible(affirmAccount, 5);

        // clicking on affirm payment method button
        clickOnAffirmButton();

        waitForElementToBeVisible(paymentInformationTitle, 5);
        Assert.assertTrue(isElementDisplayed(paymentInformationTitle), "Payment information Title ");
//        waitForElementToBeVisible(processBtnOfAffirm,5);
        staticWait(5000);

        // click on 'Process' button

        getProcessButtonOfAffirm();

        waitForPageLoad();

        // verify Affirm test page appears
        Assert.assertTrue(isElementDisplayed(affirmTestPageTitle), "Affirm Test page title");

        scrollToElement(authorizeTestPaymentBtn);
        getAuthorizeTestPaymentBtn();
    }

    public void getPayThroughCreditCardThroughAutoPayment() {
        switchToFrame(autoPaymentCardFrame);
        scrollToElement(cardNumberTbx);
        actionEnterText(cardNumberTbx, "4111111111111111");
        actionEnterText(expirationDateTbx, "0230");
        actionEnterText(cvcTbx, "123");
        actionEnterText(countryDropDown, "Australia");
        staticWait(2000);
        switchToDefaultWindow();
        scrollToElement(saveBtn);

        waitForElementToBeClickable(saveBtn, 4);
        clickOnSaveBtn();

    }

    public void paymentThrougBankAccount() {
        //clickOnBankAccount();
        swipeCard();
        billPayment();

    }
}