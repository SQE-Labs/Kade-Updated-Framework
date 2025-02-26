package pageEvents;


import java.awt.*;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Locale;

import base.BaseTest;
import org.openqa.selenium.*;


public class BillPage extends BaseTest {

    public By newBillBtn = By.cssSelector(".fs-p15>i+div");
    public By recurringBtn = By.xpath("//div[text()='Recurring']");
    public By alertMessage = By.xpath("//div[@class='alert-message']");
    public By transactionsLink = By.xpath("//div[text()='Transactions']");
    public By amtTbx = By.xpath("//input[@name='amount']");
    public By selectedCustomer = By.xpath("(//div[@data-field='name']/../../../..  //div[@class='d-none empty-d-block'])[2]");
    public By suggestionList = By.xpath("//div[@class='border rounded-3 mb-1 p-2 position-relative clone']");
    By customerField = By.xpath("//div[@class='modal-content']//label[text()='Customer']");
    By moreOptionsField = By.xpath("//div[@class='modal-body'] //label[text()='More options']");
    By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
    By closeIcon = By.cssSelector("button.btn-close");
    By closeBillBtn = By.xpath("//span[text()='Bill']/../../../../.. //button");
    By userNumber = By.xpath("//input[@name='userPhone']");
    By filterBtn = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    By fromDatePicker = By.cssSelector("[name='dateRange']");
    By customerName = By.cssSelector("[name='custName']");
    By UserPhoneField = By.xpath("//input[@name='userPhone']");
    By UserEmailField = By.cssSelector("[name='email']");
    By applyBtn = By.cssSelector("button.btn.btn-outline-primary.btn-sm");
    By customerNumberResult = By.xpath("//td[@class='text-nowrap']/p");
    By fromMonth = By.xpath("//th[@class='month'])[1]");
    By previousMonthArrow = By.xpath("//th[@class='prev available']");
    By toMonth = By.xpath("(//th[@class='month'])[2]");
    By nextMonthArrow = By.xpath("//th[@class='next available']");
    By refNo = By.xpath("//tr[@class='none-workingEffect']/td[2]/p[1]");
    By toastCloseBtn = By.xpath("//button[@class='toast-close-button']");
    public By toastMessage = By.xpath("//div[@class='toast-message']");
    By refundBtn = By.xpath("//button[@title='Refund']");
    By reasonField = By.xpath("(//input[@name='reason'])[3]");
    By processFullRefund = By.xpath("//button[@name='refundAll']");
    By refundHeader = By.xpath("//h4[@class='text-center color-inherit py-2']");
    By billGrid = By.xpath("//tr[@class='none-workingEffect']");
    By infoMessage = By.xpath("//div[@class='no-result-icon']/following-sibling::p");
    By billViewPopupTitleHeader = By.xpath("//h4[@class='modal-title']");
    By paidBill1 = By.xpath("//tr//td//div//div[not(contains(text(),'NOT PAID')) and not(@class='text-danger') and not(contains(text(),'PARTIAL')) and not(@class='text-warning')]/../../..");
    By memoNote = By.xpath("(//tr[@class='none-workingEffect']/td[2]/a)[1]");
    By name = By.xpath("//td[@class='text-nowrap']/p[1]");
    By customerNames = By.xpath("//td[@class='text-nowrap']/p[1]");
    By bill = By.xpath("(//tr[@class='none-workingEffect'])[1]");
    By customerHeader = By.xpath("//span[text()='Customer']");
    By popUpHeader = By.cssSelector(".modal-title span");
    By subTotalBox = By.xpath("//input[@name='subTotal']");
    By customerNumber = By.xpath("//input[@name='phone']");
    By createBtn = By.xpath("//button[@class='btn btn-primary fs-p50']");
    By addBillDetails = By.xpath("//button[@class='p-0 btn btn-link collapsed auto-collapse']");
    public By addBillDescription = By.xpath("//textarea[@name='amount_description']");
    By addBillPrice = By.xpath("//th[text()='Price']");
    By addMoreRowLink = By.xpath("//button[@class='btn-sm btn btn-link']");
    By toolTipMessage = By.xpath("//div[@class='tooltip-inner']");
    By refNoTextBox = By.xpath("//input[@name='refNo']");
    By autoGenToggleBtn = By.xpath("(//input[@name='autoGenerate'])[1]");
    By autoGenClass = By.xpath("(//input[@name='autoGenerate'])[1]/../../../..");
    //	By closeIcon = By.xpath("(//button[@class='btn-close'])[2]");
    By customerEmail = By.xpath("(//input[@name='email'])[2]");
    By moreToggleBtn = By.xpath("(//input[@name='captureCustomerInfo'])[1]");
    By custName = By.xpath("(//input[@name='custName'])[2]");
    By memoTextField = By.xpath("//textarea[@name='memo']");
    By price1 = By.xpath("//input[@name='items[0].price']");
    By price2 = By.xpath("//input[@name='items[1].price']");
    By description1 = By.xpath("//input[@name='items[0].description']");
    By description2 = By.xpath("//input[@name='items[1].description']");
    public By amtInput = By.xpath("//input[@name='amount']");
    By closeCustomerBtn = By.xpath("//span[text()='Customer']/../..//button");
    By customerBtn = By.xpath("//span[text()='Bill']/../../../../../../div[2]/div/div/form/div[5]/div");
    public By phoneNoTbx = By.xpath("//input[@placeholder='Phone number']");
    public By emailTbx = By.xpath("//input[@placeholder='Email']");
    public By searchTbx = By.xpath("//input[@placeholder='Search']");
    By goBtnPhnNo = By.xpath("//input[@placeholder='Phone number']/..//button");
    By goBtnEmail = By.xpath("//input[@placeholder='Email']/..//button");
    By searcherName = By.xpath("(//div[@data-field='alias'])[2]");
    By discardBtn = By.xpath("(//*[contains(text(),'discard')])[5]/.. //button[text()='Discard']");
    public By confirmBtn = By.xpath("//button[@name='method']");
    public By continueWithoutBtn = By.xpath("//*[@role='dialog'] //button[text()='Continue without']");
    public By selectACustomerBtn = By.xpath("//*[@role=\"dialog\"] //button[text()='Select a customer']");
    By whichStorePopup = By.xpath("//p[text()='Which store?']");
    By newBusinessCard = By.xpath("div.overflow-hidden.border.border-info");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By continueBtn = By.xpath("//button[@type='submit']");
    By messagePopupHeader = By.xpath("//*[@role='dialog'] //h5[text()='Message']");
    public By closeLogoPopupBtn = By.xpath("//div[@class='modal fade show' and not(@data-bs-keyboard='false')]" +
            "//child::button");
    By totalAmt = By.xpath("//span[@data-field='total']");
    By tapToAddFiles = By.cssSelector(".flex-column-reverse > div:nth-child(3)");
    By cameraIcon = By.xpath("(//button[contains(@onclick,'image')])[2]");
    By documentIcon = By.xpath("(//button[contains(@onclick,'pdf')])[2]");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By attachedImage = By.xpath("//img[@class='img-thumbnail  bg-black']");
    By notPaidBill = By.xpath("//div[contains(@class, 'row bg-white')][1]");
    By unPaidBill = By.xpath("(//div[contains(@class,'row bg-white ')])[1]/div[2]");
    public By deleteButton = By.cssSelector(".btn-outline-danger");
    By deleteIcon = By.cssSelector(".fal.fa-thumbs-up.text-white");
    By moreOptions = By.cssSelector(".mb-3.border.p-2.py-3.rounded-3.advanced-d-none.position-relative");
    By referenceNo = By.xpath("(//div[@class='border p-2 py-3 mb-2 rounded-3  d-none advanced-d-block'])[1]");
    public By refNoField = By.xpath("(//input[@lbl-title='Reference No.'])[2]");
    By description = By.xpath("//label[text()='Description:']/..");
    public By descriptionField = By.xpath("//textarea[@name='amount_description']");
    By descriptionBox = By.xpath("(//textarea[@lbl-title='Description'])[2]");
    By doneLink = By.xpath("(//button[@class='btn btn-link w-100 my-3'])[5]");
    By itemsDesc1 = By.xpath("(//textarea[@name='detail_description'])[2]");
    By itemsDesc2 = By.xpath("(//textarea[@name='detail_description'])[3]");
    By itemsDesc3 = By.xpath("(//textarea[@name='detail_description'])[4]");
    By addALineBtn = By.xpath("//button[normalize-space()='Add a line']");
    By itemPrice1 = By.xpath("(//input[@name='detail_amount'])[2]");
    By itemPrice2 = By.xpath("(//input[@name='detail_amount'])[3]");
    By itemPrice3 = By.xpath("(//input[@name='detail_amount'])[4]");
    By refPopUp = By.xpath("//h5[text()='Reference No.']");
    By defaultRefNoText = By.xpath("//label[text()='Ref No.:']/../div/div/div[1]/div[2]");
    By refNoText = By.xpath("//label[text()='Ref No.:']/../div/div/div[1]/div[1]");
    By defaultDescText = By.xpath("//label[text()='Description:']/../div/div/div[1]/div[2]");
    By descText = By.xpath("//label[text()='Description:']/../div/div/div[1]/div[1]");
    By descPopUp = By.xpath("//h5[text()='Description']");
    By addedDescription = By.xpath("(//div[@class='border rounded p-1 overflow-hidden'])[1]");
    By repeatBtn = By.xpath("(//div[contains(@class,'bg-locked')])[1]");
    By expiryBtn = By.xpath("(//div[contains(@class,'bg-locked')])[2]");
    By notNowBtn = By.xpath("(//button[@class='btn btn-outline-primary'])[1]");
    By upgradeBtn = By.xpath("//a[text()='Upgrade']");
    By filterIcon = By.xpath("//i[@class='far fa-2x fa-sliders-h-square']");
    By freezeIcon1 = By.xpath("(//button[@class='fs-pn15 m-1 btn btn-danger'])[1]");
    By freezeIcon2 = By.xpath("(//button[@class='fs-pn15 m-1 btn btn-danger'])[2]");
    By upgradePopUpTitle = By.xpath("//h3[text()='Upgrade your plan']");
    By memoBtn = By.xpath("(//div[@class='text-nowrap d-flex align-items-center w-100'])[4]");
    By memoField = By.xpath("(//textarea[@lbl-title='Memo'])[2]");
    By doneBtn = By.xpath("(//button[text()='Done'])[5]");
    By doneBtn2 = By.xpath("//h5[text()='Repeat']/../..//button[text()='Done']");
    By memoFieldText = By.xpath("(//div[@class='d-none empty-d-block fst-italic w-100'])[4]");
    By memoFieldMessage = By.xpath("//div[@class='text-muted fs-pn15 pt-3']");
    By memoPopUpTitle = By.xpath("//h5[text()='Memo']");
    By addedMemoText = By.xpath("(//div[contains(text(),'Memo Text')])[1]");
    By taxToggleBtn = By.xpath("//input[@name='applyTax']/../i[2]");
    //    By paidRepeatField = By.xpath("//div[@class='border p-2 py-3 mb-2 rounded-3 position-relative']");
    By paidRepeatField = By.xpath("(//div[contains(@class,'text-nowrap d-flex align-items-center w-100')])[3]");
    //By paidExpiryField = By.xpath("//div[@class='border p-2 py-3 mb-2 rounded-3 position-relative -expdate-div-']");
    public By paidExpiryField = By.xpath("//label[text()='Expiration Date:']");
    public By repeatPopUpTitle = By.xpath("//h5[text()='Repeat']");
    By expiryDatePopUpTitle = By.xpath("//h5[text()='Expiration Date']");
    By unpaidAmount = By.cssSelector(".text-danger.fs-4");

    By expCloseIcon = By.xpath("(//button[@class='btn-close'])[7]");
    By repeatCloseIcon = By.xpath("(//button[@class='btn-close'])[8]");
    By expiresInField = By.cssSelector(".form-control.flex-grow-1.me-1");
    By expDropDown = By.cssSelector(".form-control.form-select.max-10c");
    By expDropDownOption = By.xpath("//option[@value='minutes']");
    By addedExpTimer = By.cssSelector(".badge.bg-warning");
    By expPopUpBtnNone = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[1]");
    By expPopUpBtn24Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[2]");
    By expPopUpBtn4Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[3]");
    By expPopUpBtn1Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[4]");
    By expPopUpBtn30Min = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[2]");
    By repeatOption = By.xpath("//input[@value='1']");
    By customerCancelOption = By.xpath("//span[text()='Customer can cancel at any time']");
    By everyDayField = By.xpath("//input[@class='max-5c form-control']");
    By recurringBillText = By.xpath("//a[@class='btn btn-link']");
    public By billTag = By.xpath("//div[contains(@class,'col-5  text-end') ]//div[1]/span");

    /*
    Locators of Bill popup
     */
    public By billPopupHeader = By.xpath("//span[text()='Bill']");
    public By qrCodeBtn = By.xpath("//span[text()='QR Code']");
    By shareBtn = By.xpath("//span[text()='Share']");
    public By processPaymentBtn = By.xpath("//button[text()='Process Payment']");
    By deleteBillBtn = By.xpath("//button[text()='Delete']");
    By editBillBtn = By.xpath("//i[@class='far fa-edit']");
    By uniqueRefNo = By.cssSelector(".badge.position-relative:first-child");
    By notPaidLabel = By.cssSelector(".badge.bg-danger");
    By billTimeOnPopup = By.cssSelector("div[role='document'] div.d-flex.justify-content-between div+div>div");
    By taxValue = By.xpath("//input[@name='applyTax']/../span");
    By taxToggleBtnDisable = By.xpath("//input[@name='applyTax']/../i[1]");
    By customName = By.xpath("//*[@id=\"_B7O\"]/span");
    By activeBillAmmount = By.xpath("//span[@class='display-5 display-sm-2 fw-bold']");
    By doneButton = By.xpath(" //div[@id='_3FH']/button[@type='button'][normalize-space()='Done']");


    public BillPage() {
        super();
    }

    public void getStoresDropdown() {
        click(storesCombobox);
    }

    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }

    public void getSelectACustomerButton() {
        click(selectACustomerBtn);
    }

    public void getEnableTaxToggleButton() {
        click(taxToggleBtn);
    }

    public void getDisableTaxToggleButton() {
        click(taxToggleBtnDisable);
    }

    public void getTotalAmt() {
        click(totalAmt);
    }

    public void getTaxValue() {
        click(taxValue);
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

    public void getAttachedFiles() {
        click(attachedImage);
    }

    public void getUnPaidBillWithDescription() {
        click(unPaidBill);
    }

    public void getUnpaidBillWithoutDescription() {
        click(notPaidBill);
    }

    public void getProcessPaymentButton() {
        click(processPaymentBtn);
    }

    public void getTransactionLink() {
        click(transactionsLink);
    }

    public void getContinueButton() {
        click(continueBtn);
    }

    public void getNewBillButton() {
        click(newBillBtn);
    }

    public void getAmountTextbox() {
        click(amtTbx);
    }

    public void getDescriptionTextbox() {
        click(descriptionField);
    }

    public void getCustomerField() {
        click(customerField);
    }

    public void getMoreOption() {
        click(moreOptions);
    }

    public void getConfirmButton() {
        click(confirmBtn);
    }

    public void getSelectCustomerButton() {
        click(selectedCustomer);
    }

    public void getContinueWithoutButton() {
        click(continueWithoutBtn);
    }

    public void getCustomerPhoneNoField() {
        click(customerNumber);
    }

    public void getEmailField() {
        click(emailTbx);
    }

    public void getSearchField() {
        click(searchTbx);
    }

    public void getGoPhoneNumberButton() {
        click(goBtnPhnNo);
    }

    public void getSuggestedCustomer() {
        click(suggestionList);
    }

    public void getAmountField() {
        click(amtInput);
    }

    public void getCloseLogoPopupBtn() {
        click(closeLogoPopupBtn);
    }

    public void getPopupTitle() {
        click(popUpHeader);
    }

    public void createBill(BillPage billObj) {
        createBill(billObj, true);
    }

    public void createBill(BillPage billObj, boolean navigateToBillSection) {
        if (navigateToBillSection) {
            getStoresDropdown();
            selectStore(billObj.getStore());
            getContinueButton();
        }

        getNewBillButton();
        if (billObj.getAmount() != null) {
            getAmountField().setText(billObj.getAmount());
        }
        getDisableTaxToggleButton();
        getDescriptionTextbox();
        if (billObj.getCustomerPhnNo() != null) {
            getCustomerButton();
            getCustomerPhoneNoField().setText(billObj.getCustomerPhnNo());
            getGoPhoneNumberButton();
            getConfirmButton();
        }
        if (billObj.getCustomerEmail() != null) {
            getCustomerButton();
            getUserEmailField().setText(billObj.getCustomerEmail());
            getEmailGoButton();
        }
        getConfirmButton();
        WebdriverWaits.sleep(2000);
        getContinueWithoutButton();
    }

    public void createBillForRT(BillPage billObj, boolean navigateToBillSection) {
        if (navigateToBillSection) {
            getStoresDropdown();
            selectStore(billObj.getStore());
            getContinueButton();
        }

        getNewBillButton();
        if (billObj.getAmount() != null) {
            getAmountField().setText(billObj.getAmount());
        }
        getDisableTaxToggleButton();
        getDescriptionTextbox();
        if (billObj.getCustomerPhnNo() != null) {
            getCustomerButton();
            getCustomerPhoneNoField().setText(billObj.getCustomerPhnNo());
            getGoPhoneNumberButton();
            getConfirmButton();
        }
        if (billObj.getCustomerEmail() != null) {
            getCustomerButton();
            getUserEmailField().setText(billObj.getCustomerEmail());
            getEmailGoButton();

            getMoreOption();

            getRepeatField();
            getRepeatOption();
            getCustomerCancelOption();
            getDoneBtn();
        }
        getConfirmButton();
        getContinueWithoutButton();
    }


    public void getEmailGoButton() {
        click(goBtnEmail);
    }

    public void getFilterButton() {
        click(filterBtn);
    }

    public void getUserEmailField() {
        click(UserEmailField);
    }

    public void getApplyButton() {
        click(applyBtn);
    }

    public void getMoreOptionField() {
        click(moreOptionsField);
    }

    public void getCustomerButton() {
        click(customerBtn);
    }

    public void getCustomerHeader() {
        click(customerHeader);
    }

    public void GetGoButtonPhoneNo() {
        click(goBtnPhnNo);
    }

    public void getMessagePopupHeader() {
        click(messagePopupHeader);
    }

    public void getToastMessage() {
        click(toastMessage);
    }

    public void getCustomerPhoneField() {
        click(customerNumber);
    }

    public void getSuggestionList() {
        click(suggestionList);
    }

    public void getTapToAddFilesIcon() {

        click(tapToAddFiles);
    }

    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }

    public void uploadImageInStoreLogo() throws AWTException {
        uploadImageAsAttachment("src/main/resources/image/BillDummyImg.jpg");
    }

    public void uploadPdf() throws AWTException {
        uploadImageAsAttachment("src/main/resources/Documents/Bills.pdf");
    }

    public void getCheckButton() {
        click(checkBtn);
    }

    public void getCameraIcon() {
        click(cameraIcon);
    }

    public void getAttachedFile() {
        click(attachedImage);
    }

    public void getAttachedImage() {
        click(attachedImage);
    }

    public void getDocumentIcon() {
        click(documentIcon);
    }

    public void getCloseBillButton() {
        click(closeBillBtn);
    }

    public void getDeleteButton() {
        click(deleteButton);
    }

    public void getDeleteIcon() {

        click(deleteIcon);
    }

    public void getMoreOptionsButton() {
        click(moreOptions);
    }

    public void getReferenceNumber() {
        click(referenceNo);
    }

    public void getReferenceNumberField() {
        click(refNoField);
    }

    public void getDescription() {
        click(description);
    }

    public void getDescriptionField() {
        click(descriptionBox);
    }

    public void getDoneLink() {
        click(doneLink);
    }

    public void getDescriptionBox() {
        click(descriptionBox);
    }

    public void getItemDescriptionField1() {

        click(itemsDesc1);
    }

    public void getItemDescriptionField2() {
        click(itemsDesc2);
    }

    public void getItemPriceField2() {
        click(itemPrice2);
    }

    public void getItemPriceField3() {

        click(itemPrice3);
    }

    public void getItemDescriptionField3() {
        click(itemsDesc3);
    }

    public void getItemPriceField1() {
        click(itemPrice1);
    }

    public void getAddALineButton() {
        click(addALineBtn);
    }

    public void getReferencePopUpTitle() {
        click(refPopUp);
    }

    public void getDefaultReferenceNumberText() {
        click(defaultRefNoText);
    }

    public void getAddedReferenceNumberText() {
        click(refNoText);
    }

    public void getDescriptionFieldDefaultText() {
        click(defaultDescText);
    }

    public void getDescriptionFieldAddedText() {
        click(defaultDescText);
    }

    public void getAddedDescription() {
        click(addedDescription);
    }

    public void getDescriptionPopUpTitle() {
        click(descPopUp);
    }

    public void getRepeatButton() {
        click(repeatBtn);
    }

    public void getExpiryButton() {
        click(repeatBtn);
    }

    public void getNotNowButton() {
        click(notNowBtn);
    }

    public void getUpgradeButton() {
        click(upgradeBtn);
    }

    public void getFilterIcon() {
        click(filterIcon);
    }

    public void getFreezeIcon1() {
        click(freezeIcon1);
    }

    public void getFreezeIcon2() {
        click(freezeIcon2);
    }

    public void getUpgradePopUpTitle() {
        click(upgradePopUpTitle);
    }

    public void getMemoButton() {
        click(memoBtn);
    }

    public void getMemoField() {
        click(memoField);
    }

    public void getDoneButton() {
        click(doneBtn);
    }

    public void getDefaultMemoFieldText() {
        click(memoFieldText);
    }

    public void getMemoFieldMessage() {

        click(memoFieldMessage);
    }

    public void getMemoPopUpTitle() {

        click(memoPopUpTitle);
    }

    public void getAddedMemoText() {

        click(addedMemoText);
    }

    public void getRepeatField() {
        click(paidRepeatField);
    }

    public void getExpiryField() {

        click(paidExpiryField);
    }

    public void getRecurringButtton() {
        click(recurringBtn);
    }

    public void getRepeatPopUpTitle() {
        click(repeatPopUpTitle);
    }

    public void getExpiryDatePopUpTitle() {
        click(expiryDatePopUpTitle);
    }

    public void getUnpaidAmount() {
        click(unpaidAmount);
    }

    public void getCloseIcon() {

        click(expCloseIcon);
    }

    public void getExpiresInField() {
        click(expiresInField);
    }

    public void getExpiryDropDown() {
        click(expDropDown);
    }

    public void getExpiryDropDownOption() {
        click(expDropDownOption);
    }

    public void getAddedExpiryTimer() {
        click(addedExpTimer);
    }

    public void getExpiryPopUpButton() {
        click(expPopUpBtnNone);
    }

    public void getExpiry24HrOption() {
        click(expPopUpBtn24Hr);
    }

    public void getExpiry4HrOption() {
        click(expPopUpBtn4Hr);
    }

    public void getExpiry1HrOption() {
        click(expPopUpBtn1Hr);
    }

    public void getExpiry30MinOption() {
        click(expPopUpBtn24Hr);
    }

    public void getExpiryNoneOption() {
        click(expPopUpBtnNone);
    }

    public void getRepeatOption() {
        click(repeatOption);
    }

    public void getCustomerCancelOption() {
        click(customerCancelOption);
    }

    public void getDoneBtn() {

        click(doneBtn2);
    }

    public void getEveryDayFieldValue() {

        click(everyDayField);
    }

    public void getRecurringBillText() {
        click(recurringBillText);
    }

    public void getProcessingPaymentButton() {
        click(processPaymentBtn);
    }

    public void getBillPopupHeader() {
        click(billPopupHeader);
    }

    public void getShareButton() {
        click(shareBtn);
    }

    public void getQRCodeButton() {
        click(qrCodeBtn);
    }

    public void getEditBillButton() {
        click(editBillBtn);
    }

    public void getUniqueReferenceNumber() {

        click(uniqueRefNo);
    }

    public void getBillTime() {
        click(billTimeOnPopup);
    }

    public void getNotPaidLabel() {
        click(notPaidLabel);
    }


    public void getPaymentStatusOfLatestBill() {
        click(billTag);
    }

    public void getCustomName() {
        click(customName);
    }


    public void getActiveBillAmmount() {
        click(activeBillAmmount);
    }

    public void getDoneLinkOnBillPage() {
        click(doneButton);
    }

}
