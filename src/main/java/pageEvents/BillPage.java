package pageEvents;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.Constants;

import static utils.Constants.BillHeader;


public class BillPage extends BaseTest {

    String descriptionTxt;
    String referenceTxt;
    String memoTxt;
    public String amt;

    public String enteredamt;
    PaymentPage payment = new PaymentPage();

    public By newBillTxt = By.xpath("//div/child::div[text()='New Bill']");
    public By newBillBtn = By.cssSelector(".fs-p15>i+div");
    public By recurringBtn = By.xpath("//div[text()='Recurring']");
    public By alertMessage = By.xpath("//div[@class='alert-message']");
    public By transactionsLink = By.xpath("//div[text()='Transactions']");
    public By amtTbx = By.xpath("//input[@name='amount']");
    public By selectCustomer = By.xpath("//button[text()='Select a customer']");
    public By suggestionList = By.xpath("//div[@class='border rounded-3 mb-1 p-2 position-relative clone']");
    By customerField = By.xpath("//div[@class='modal-content']//label[text()='Customer']");
    By moreOptionsField = By.xpath("//div[@class='modal-body'] //label[text()='More options']");
    By pageHeader = By.xpath("//h1[@class='header-title mb-0']");
    By closeIcon = By.xpath("(//button[@class='btn-close'])[3]");
    By closeBillBtn = By.xpath("//span[text()='Bill']/../../../../.. //button");
    By userNumber = By.xpath("//input[@name='userPhone']");
    public By filterBtn = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    public By configureAmount = By.xpath("//div[@class='text-center fs-pn25']");
    public By enteredAmount = By.cssSelector("span[data-field='total']");
    public By tapToAddFiles = By.xpath("//div[text()='Tap to add files']/..");
    public By camera = By.xpath("(//button[contains(@class,'btn btn-outline-dark mx-2')]/child::i[contains(@class,'fas fa-camera-retro fs-p50')])[2]/..");
    public By pdfIcon = By.xpath("(//button[contains(@class,'btn btn-outline-dark mx-2')]/child::i[contains(@class,'fas fa-file-pdf fs-p50')])[2]/..");
    public By okIcon = By.xpath("//button[@class='btn btn-dark -crop-']");
    By refDescTxt = By.xpath("//label[text()='Ref No.:']/..//div[contains(@class,'link-empty')]");
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
    public By successMessage = By.xpath("//div[@class='toast-message']");
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
    public By popUpHeader = By.cssSelector(".modal-title span");
    By subTotalBox = By.xpath("//input[@name='subTotal']");
    public By customerNumber = By.xpath("//input[@name='phone']");
    public By emailField = By.xpath("//input[@name='email']");
    //input[@name='email']
    By createBtn = By.xpath("//button[@class='btn btn-primary fs-p50']");
    By addBillDetails = By.xpath("//button[@class='p-0 btn btn-link collapsed auto-collapse']");
    public By addBillDescription = By.xpath("//textarea[@name='amount_description']");
    public By customerDropdown = By.xpath("//div[contains(text(),'Select or create')]");
    public By moreLabelTxt = By.xpath("//label[contains(text(),'More options')]");
    By addBillPrice = By.xpath("//th[text()='Price']");
    By addMoreRowLink = By.xpath("//button[@class='btn-sm btn btn-link']");
    By toolTipMessage = By.xpath("//div[@class='tooltip-inner']");
    By refNoTextBox = By.xpath("//input[@name='refNo']");
    By autoGenToggleBtn = By.xpath("//input[@name='useCardOnFile']/following-sibling::i[2]");
    public By autoPaymentInfoMsg = By.xpath("//div[@class='alert-message']//div[contains(text(),'process this bill')]");

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
    By customerBtn = By.xpath("//label[@class='mb-1' and text()='Customer']/../..");
    public By phoneNoTbx = By.xpath("//input[@placeholder='Phone number']");
    public By emailTbx = By.xpath("//input[@placeholder='Email. Existing or new']");
    public By searchTbx = By.xpath("//input[@placeholder='Search']");
    By goBtnPhnNo = By.xpath("//input[@name='phone']/following-sibling::button");
    By goBtnEmail = By.xpath("//input[@name='email']/following-sibling::button");
    By enterCustomernameDoneBtn = By.xpath("(//button[text()='Done'])[6]");
    By enterUserNamePopUp = By.xpath("(//div[@class='modal-header']/h5)[8]");
    public By customerNameField = By.xpath("(//div[@class='my-4']/input[@class='form-control'])[2]");
    public By billDoneBtn = By.xpath("(//div[@class='modal-content']//button[@class='btn btn-link w-100 my-3'])[6]");
    public By confirmBtnDisabled = By.xpath("(//button[@disabled='disabled'])[3]");
    By searcherName = By.xpath("(//div[@data-field='alias'])[2]");
    By discardBtn = By.xpath("(//*[contains(text(),'discard')])[5]/.. //button[text()='Discard']");
    public By confirmBtn = By.xpath("//button[@name='method']");
    public By continueWithoutBtn = By.xpath("//button[text()='Continue without']");
    public By closePopup = By.xpath("(//div[@class='modal-content']//h5/following-sibling::button)[3]");
    public By crossPopUpIcon = By.xpath("(//div[contains(@class, 'modal-content')]//button[@class='btn-close'])[2]");
    public By crossIcon = By.xpath("(//div[contains(@class,'modal-content')]//button[@class='btn-close'])[1]");
    public By countinueWithoutTxt = By.xpath("//div//button[text()='Continue without']");
    public By selectACustomerBtn = By.xpath("(//div[@class='modal-content'])[8]//button[text()='Select a customer']");
    By whichStorePopup = By.xpath("//p[text()='Which store?']");
    By newBusinessCard = By.xpath("div.overflow-hidden.border.border-info");
    public By storesCombobox = By.xpath("//span[@role='combobox']");
    public By messagePopupHeader = By.xpath("//h5[text()='Message']");
    public By closeLogoPopupBtn = By.xpath("(//div[contains(@class, 'modal-content')]//button[@class='btn-close'])[3]");
    public By totalAmt = By.xpath("//span[@data-field='total']");
    // By tapToAddFiles = By.cssSelector(".flex-column-reverse > div:nth-child(3)");
    By cameraIcon = By.xpath("(//button[contains(@onclick,'image')])[2]");
    By documentIcon = By.xpath("(//button[contains(@onclick,'pdf')])[2]");
    By checkBtn = By.xpath("//button[@class='btn btn-dark -crop-']");
    By attachedImage = By.xpath("//img[@class='img-thumbnail  bg-black']");
    By notPaidBill = By.xpath("//div[contains(@class, 'row bg-white')][1]");
    By unPaidBill = By.xpath("(//div[contains(@class,'row bg-white ')])[1]/div[2]");
    By deleteButton = By.cssSelector(".btn-outline-danger");
    public By notPaid = By.xpath("//div[contains(@class, 'row bg-white')][1]");
    public By billsection = By.xpath("//*[@id=\"_16U\"]/div[2]");
    public By billLabel = By.xpath("//div[contains(@class,'row bg-white border rounded')]");
    public By reccuringBill = By.xpath("//div[contains(@class, 'bg-white mb-2 row')][1]");
    public By reccuringAmount = By.xpath("//span[@class='display-6 ms-1 text-danger']");
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
    By selectCust = By.xpath("//div[contains(text(),'Select or create a new customer')]/../../../../../..");
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
    By memoBtn = By.xpath("//label[text()='Memo:']/..");
    By memoField = By.xpath("//div[@class='my-4']//textarea[@lbl-title='Memo']");
    By doneBtn = By.xpath("(//button[text()='Done'])[5]");
    By doneBtn2 = By.xpath("//h5[text()='Repeat']/../..//button[text()='Done']");
    By memoFieldText = By.xpath("(//div[@class='d-none empty-d-block fst-italic w-100'])[4]");
    By memoFieldMessage = By.xpath("//div[contains(text(),'Customer will not see this memo')]");
    By memoPopUpTitle = By.xpath("//h5[text()='Memo']");
    By addedMemoText = By.xpath("(//div[contains(text(),'Memo Text')])[1]");
    public By taxToggleBtn = By.xpath("//input[@name='applyTax']/../i[2]");
    public By totalAmtAfterTax = By.xpath("//span[@data-field='total']");
    public By moreSection = By.xpath("//label[text()='More options']/../..");
    public By repeatLockIcon = By.xpath("(//i[@class='fas fa-lock'])[1]");
    public By expireLockIcon = By.xpath("(//i[@class='fas fa-lock'])[2]");
    public By memoNoneTxt = By.xpath("(//div[contains(@class,'text-nowrap d-flex')]//div[text()='None'])[4]");
    public By expiryDateSection = By.xpath("(//div[@class='position-absolute start-0 end-0 top-0 bottom-0 bg-locked'])[2]");
    By expirationDate = By.xpath("(//a[@class='stretched-link ms-1 -activator-button-'])[5]");
    public By expirationDayPopUp = By.xpath("//h5[text()='Expiration Date']");
    public By refNoneTxt = By.xpath("//label[text()='Ref No.:']/..//div[text()='None']");
    By refPopup = By.xpath("//label[text()='Ref No.:']/..//div[text()='None']/../../../../..");
    public By DescriptionEnteredText = By.xpath("//label[text()='Description:']/..//div[contains(@class,'link-empty')]");
    public By descriptionNoneTxt = By.xpath("//label[text()='Description:']/..//div[text()='None']/../../../../..");
    public By refNoPopup = By.xpath("//h5[text()='Reference No.']");
    public By enterTxtInRefNo = By.xpath("//h5[text()='Reference No.']/../../child::div/div/input");
    public By refNopopupDoneBtn = By.xpath("//h5[text()='Reference No.']/../../child::div/button[text()='Done']");
    public By descriptionSection = By.xpath("//label[text()='Description:']/..//div[text()='None']/../../../../..");
    public By taxRateField = By.xpath("//input[@name='taxRate']");
    public By descriptionTextField = By.xpath("//h5[text()='Description']/../following-sibling::div/child::div/textarea");
    public By descriptionTitle = By.xpath("//h5[text()='Description']");
    public By descriptionDoneButton = By.xpath("//h5[text()='Description']/../following-sibling::div/child::button[text()='Done']");
    public By saveBtn = By.cssSelector("button[class='btn btn-primary']");
    public By validationMsg = By.xpath("//p[text()='The amount is larger than acceptable amount (50,000.00) for this store']");
    By paidRepeatField = By.xpath("//div[text()='No repeat']/../../../../..");
    public By repeatUpgradePlan = By.xpath("//h3[text()='Upgrade your plan']");
    By repeatUpgradePlanNotNowBtn = By.xpath("//button[text()='Not now']");
    By repeatTxt = By.xpath("//h5[text()='Repeat']");
    By timesTotalField = By.xpath("//label[text()='times total']");
    By dailyCheckbox = By.xpath("//label[normalize-space()='Daily']/input");
    By weeklyCheckbox = By.xpath("//label[normalize-space()='Weekly']/input");
    By MonthlyCheckbox = By.xpath("//label[normalize-space()='Monthly']/input");
    By yearlyCheckbox = By.xpath("//label[normalize-space()='Yearly']/input");
    By repeatElements = By.xpath("//label[@class='list-group-item']");
    public By paidExpiryField = By.xpath("//label[text()='Expiration Date:']");
    public By repeatPopUpTitle = By.xpath("//h5[text()='Repeat']");
    public By reccuringIcon = By.xpath("(//span/following-sibling::i)[1]");
    public By reccuringMenu = By.xpath("//div[text()='Recurring']/..");
    By expiryDatePopUpTitle = By.xpath("//h5[text()='Expiration Date']");
    By unpaidAmount = By.cssSelector(".text-danger.fs-4");
    public By enterInBillfield = By.xpath("(//div[@class='d-flex mb-2 clone']/div/input[@name='detail_amount'])[1]");
    public By reEnterAmountInBillfield = By.xpath("(//div[@class='d-flex mb-2 clone']//input[@data-field='amount'])[1]");
    public By enterInSecondBillfield = By.xpath("(//div[@class='d-flex mb-2 clone']/div/input[@name='detail_amount'])[2]");
    public By enteredDescTxt = By.xpath("//div[@class='border rounded p-1 overflow-hidden']");
    public By refGetTxt = By.xpath("//span[contains(text(),'Ref:')]");

    // Expiration Date x-paths
    public By noneTxt = By.xpath("//button[contains(text(),'None')]");
    public By dayTxt = By.xpath("//button[contains(text(),'24 Hours')]");
    public By quterDayTxt = By.xpath("//button[contains(text(),'24 Hours')]/following-sibling::button[contains(text(),'4 Hours')]");
    public By oneHourTxt = By.xpath("//button[contains(text(),'1 Hour')]");
    public By thirtyMinTxt = By.xpath("//button[contains(text(),'30')]");
    By expiresField = By.xpath("//span[text()='Expires in:']/../input[@lbl-title='Expires in']");

    public By expireInTxtField = By.xpath("//span[contains(text(),'Expires in:')]/following-sibling::input[@data-field='duration']");
    public By expireDropDown = By.xpath("//option[text()='Minutes']/..");
    public By minutesTxt = By.xpath("//option[text()='Minutes']");

    By paymentMethodLink = By.xpath("//button[text()='Add payment method']");
    By customerPermissionCheckbox = By.xpath("((//label[@class='custom-checkbox'])[5]/child::i)[2]");
    By customerPrmissionDoneButton = By.xpath("(//button[text()='Continue'])[2]");
    By cardName = By.xpath("//input[@placeholder='1234 1234 1234 1234']");
    By cardIframe = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[2]");
    By cardExpiry = By.xpath("//input[@name='expiry']");
    By cvcField = By.xpath("//input[@name='cvc']");
    By cardSaveBtn = By.xpath("//button[text()='Save']");

    By shareLinkToCustomer = By.xpath("//button[normalize-space()='Send a link to the customer to add a payment method']");
    By shareLinkSuccessMessage = By.xpath("//div[text()='We sent a link to the customer.']");
    By continueBtn = By.xpath("//button[@type='submit']");


    By expCloseIcon = By.xpath("(//button[@class='btn-close'])[7]");
    By expiresInField = By.cssSelector(".form-control.flex-grow-1.me-1");
    By expDropDown = By.cssSelector(".form-control.form-select.max-10c");
    By expDropDownOption = By.xpath("//option[@value='minutes']");
    By addedExpTimer = By.cssSelector(".badge.bg-warning");
    By expPopUpBtnNone = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[1]");
    By expPopUpBtn24Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[2]");
    By expPopUpBtn4Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[3]");
    By expPopUpBtn1Hr = By.xpath("(//button[contains(@class,'fs-inherit mb-4')])[4]");
    By repeatOption = By.xpath("//input[@value='1']");
    By customerCancelOption = By.xpath("//span[text()='Customer can cancel at any time']");
    By everyDayField = By.xpath("(//div[@class='d-flex']/child::label/following-sibling::input)[1]");
    By everyWeekField = By.xpath("(//div[@class='d-flex']/child::label/following-sibling::input)[2]");
    By everyMonthField = By.xpath("(//div[@class='d-flex']/child::label/following-sibling::input)[3]");

    By specificNumbers = By.xpath("//label[normalize-space()='Specific number of times']/input");
    public By pecificNumberText = By.xpath("//div[@class='d-flex']/child::input[@lbl-title='Times']");
    public By totalDays = By.xpath("//div[contains(@class,'mb-2 d-flex')]");
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
    public By uniqueRefNo = By.xpath("(//span[contains(@class,'badge position-relative')])[1]");
    public By notPaidLabel = By.xpath("(//span[text()='NOT PAID'])[1]");
    public By billTimeOnPopup = By.xpath("(//div[@class='fs-pn25 mb-1'])[1]");
    public By memoEnteredTxt = By.xpath("(//div[contains(text(),'Memo Text')])[1]");
    public By expireDateTime = By.xpath("(//div[contains(@class,'col-5  text-end ')]/div/span)[1]");
    public By taxValue = By.xpath("//input[@name='applyTax']/../child::div");
    public By taxToggleBtnDisable = By.xpath("(//input[@name='applyTax']/../child::i)[2]");
    By customName = By.xpath("//*[@id=\"_B7O\"]/span");
    By activeBillAmmount = By.xpath("//span[@class='display-5 display-sm-2 fw-bold']");
    By doneButton = By.xpath(" //div[@id='_3FH']/button[@type='button'][normalize-space()='Done']");
    public By amountTxtField = By.xpath("//label[text()='Amount']");
    By btnDisabled = By.xpath("(//button[@disabled='disabled'])[3]");
    By chargeButton = By.xpath("//span[contains(text(),'Charge')]");
    public By removeButtonUnderInfoMsg = By.xpath("//div[contains(text(),'process this bill')]/..//button");


    String amount = "2000.00";

    public void expirationIcon() {
        click(expireLockIcon);
    }

    public void clickOnNewBill() {
        Log.info("Clicking on newBillTxt");
        click(newBillTxt);
    }

    public void getStoresDropdown() {
        staticWait(2000);
        click(storesCombobox);
    }

    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }


    public void getEnableTaxToggleButton() {
        click(taxToggleBtn);
    }

    public void clickOnTapToAddImageFiles() throws AWTException {
        scrollToElement(tapToAddFiles);
        click(tapToAddFiles);
        hoverAndClick(camera, camera);
        staticWait(1000);
        uploadImageInStoreLogo();
        staticWait(5000);
        //  scrollToElement(okIcon);
        click(okIcon);
    }

    public void clickOnTapToAddPdfFiles() throws AWTException {
        scrollToElement(tapToAddFiles);
        click(tapToAddFiles);
        hoverAndClick(pdfIcon, pdfIcon);
        staticWait(1000);
        uploadPdf();
        staticWait(5000);


    }

    public void clickOnMoreSection() {
        scrollToElement(moreSection);
        staticWait(3000);
        click(moreSection);
    }

    public void clickOnIcon() {
        staticWait(2000);
        click(closeIcon);
    }


//    public void verifyEnteredMemoText() {
//        //Verify not paid label for generated amount
//
//        Assert.assertTrue(isElementDisplayed(notPaidLabel));
//        Assert.assertTrue(isElementDisplayed(uniqueRefNo));
//        Assert.assertTrue(isElementDisplayed(billTimeOnPopup));
//        Assert.assertTrue(isElementDisplayed(memoEnteredTxt));
//    }

    public void clickOnExpiryDateSection() {
        staticWait(3000);
        clickElementByJS(expiryDateSection);
    }

    public void clickOnexpirationDate() {
        staticWait(3000);
        clickElementByJS(expirationDate);
    }


    public void sendTxtInexpireInTxtField(String hrs, int minTxt) {
        staticWait(2000);
        actionEnterText(expireInTxtField, hrs);
        click(expireDropDown);
        staticWait(2000);
        selectDropdownByIndex(expireDropDown, minTxt);
        staticWait(2000);

    }

    public void clickOnshareLinkToCustomer() {

        click(shareLinkToCustomer);
        String successMsg = getText(shareLinkSuccessMessage);
        Assert.assertEquals(successMsg, "We sent a link to the customer.");
    }

    public void clickOnpaymentMethodLink() {
        staticWait(3000);
        click(paymentMethodLink);
    }

    public void ClickOnCustomerPermissionCheckbox() {
        click(customerPermissionCheckbox);
    }

    public void ClickOncustomerPrmissionDoneButton() {
        click(customerPrmissionDoneButton);
    }

    public void getUseThisToggle() {
        clickElementByJS(autoGenToggleBtn);
    }

    public void getChargeButton() {
        click(chargeButton);
    }

    public void getRemoveBtnUnderInfoMsg() {
        click(removeButtonUnderInfoMsg);
    }

    public void enterTxtInCardNumberField(String txt, String expiryDate, String cvcNumber) {
        staticWait(5000);
        switchToFrame(cardIframe);
        staticWait(5000);
        actionEnterText(cardName, txt);
        actionEnterText(cardExpiry, expiryDate);
        actionEnterText(cvcField, cvcNumber);
        switchToDefaultContent();
        click(cardSaveBtn);
    }

    public void clickOnDoneBtn() {
        staticWait(6000);
        //scrollToElement(doneBtn);
        clickElementByJS(doneBtn);
    }

    public void assertGetRefNotxt() {
        WaitUntilElementVisible(refNoneTxt, 10);
        scrollToElement(refNoneTxt);
        Assert.assertTrue(isElementDisplayed(refNoneTxt));
    }

    public void assertDescriptionNonetxt() {
        Assert.assertTrue(isElementDisplayed(descriptionNoneTxt));
    }

    public void clickOnGetRefNotxt() {
        staticWait(4000);
        click(refPopup);

        String refNoPopups = getText(refNoPopup);
        Assert.assertEquals(refNoPopups, "Reference No.");

        referenceTxt = "Kevin123" + requiredString(42);
        staticWait(4000);
        actionEnterText(enterTxtInRefNo, referenceTxt);
        click(refNopopupDoneBtn);
        staticWait(4000);
    }

    public void entertxtInDescriptiontxt() {
        staticWait(4000);
        click(descriptionSection);
        Log.info("descriptionSection None text displayed");

        String descriptionTitles = getText(descriptionTitle);
        Assert.assertEquals(descriptionTitles, "Description");

        descriptionTxt = "Kevin123" + requiredString(192);
        staticWait(4000);
        actionEnterText(descriptionTextField, descriptionTxt);
        click(descriptionDoneButton);
        staticWait(4000);
    }


    public void assertEnteredText() {
        Log.info("Validating text");

        String referenceTxts = getText(refDescTxt);
        Assert.assertEquals(referenceTxt, referenceTxts);
        Log.info(getText(refDescTxt));


    }


    public void assertEnteredTextInDescriptionField() {
        Log.info("Validating text");

        String DescriptionEnteredTexts = getText(DescriptionEnteredText);
        Assert.assertEquals(descriptionTxt, DescriptionEnteredTexts);

        Log.info(getText(DescriptionEnteredText));
    }

    public void enterInBillTxtField(String maximumBill, String maximumSecondBill) {
        actionEnterText(enterInBillfield, maximumBill);
        actionEnterText(enterInSecondBillfield, maximumSecondBill);
    }

    public void reEnterAmountInBillTxtField(String maximumBill, String maximumSecondBill) {
        scrollToElement(reEnterAmountInBillfield);
        actionEnterText(reEnterAmountInBillfield, maximumBill);
    }

    public void assertingDescription() {
        Log.info("Validating text");
        Assert.assertEquals(enteredDescTxt, descriptionTxt);
        Log.info("Validating text : " + enteredDescTxt);
        Log.info("Validating text");
        Assert.assertEquals(refGetTxt, referenceTxt);
        Log.info("Validating text : " + refGetTxt);
    }


    public void enterTextInTaxRateField(String taxRateFieldText) {
        staticWait(3000);
        actionEnterText(taxRateField, taxRateFieldText);
    }

    public void clickOnSaveBtn() {
        click(saveBtn);
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
        staticWait(2000);
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
        staticWait(4000);
        scrollToElement(confirmBtn);
        click(confirmBtn);
    }

    public void getContinueWithoutButton() {
        waitForElementToBeVisible(countinueWithoutTxt, 10);
        hoverAndClick(countinueWithoutTxt, countinueWithoutTxt);
    }

    public void getSelectACustomerButton() {
        staticWait(3000);
        click(selectACustomerBtn);
    }

    public void selectCust() {
        staticWait(3000);
        click(selectCust);
    }


    public void getCustomerPhoneNoField(String phone) {
        staticWait(3000);
        actionEnterText(customerNumber, phone);
    }

    public void getCustomerEmailField(String email) {
        waitForElementToBeVisible(emailField, 10);
        actionEnterText(emailField, email);
    }

    public void clickOnEnterNameDoneBtn() {
        staticWait(2000);
        if (isElementDisplayed(enterUserNamePopUp)) {
            staticWait(2000);
            click(enterCustomernameDoneBtn);
        } else {
            Log.info("POPup Not Displayed");
        }
    }


    public void getSearchField() {
        click(searchTbx);
    }

    public void getGoPhoneNumberButton() {
        click(goBtnPhnNo);
    }

    public void BillClosePopup() {
        waitForElementToBeClickable(closePopup, 10);
        click(closePopup);
    }

    public void closePopupIcon() {
        waitForElementToBeClickable(crossPopUpIcon, 10);
        click(crossPopUpIcon);
    }

    public void clickOnCrossIcon() {
        staticWait(3000);
        click(crossIcon);
    }

    public void getAmountField() {
        click(amtInput);
    }

    public void getCloseLogoPopupBtn() {
        hoverAndClick(closeLogoPopupBtn, closeLogoPopupBtn);
    }

    public void getPopupTitle() {
        click(popUpHeader);
    }

//    public void createBill(BillPage billObj) {
//        createBill(billObj, true);
//    }

//    public void createBill(BillPage billObj, boolean navigateToBillSection) {
//        if (navigateToBillSection) {
//            getStoresDropdown();
//            selectStore(billObj.getStore());
//            getContinueButton();
//        }
//
//        getNewBillButton();
//        if (billObj.getAmount() != null) {
//            getAmountField().setText(billObj.getAmount());
//        }
//        getDisableTaxToggleButton();
//        getDescriptionTextbox();
//        if (billObj.getCustomerPhnNo() != null) {
//            getCustomerButton();
//            getCustomerPhoneNoField().setText(billObj.getCustomerPhnNo());
//            getGoPhoneNumberButton();
//            getConfirmButton();
//        }
//        if (billObj.getCustomerEmail() != null) {
//            getCustomerButton();
//            getUserEmailField().setText(billObj.getCustomerEmail());
//            getEmailGoButton();
//        }
//        getConfirmButton();
//
//        getContinueWithoutButton();
//    }
//
//    public void createBillForRT(BillPage billObj, boolean navigateToBillSection) {
//        if (navigateToBillSection) {
//            getStoresDropdown();
//            selectStore(billObj.getStore());
//            getContinueButton();
//        }
//
//        getNewBillButton();
//        if (billObj.getAmount() != null) {
//            getAmountField().setText(billObj.getAmount());
//        }
//        getDisableTaxToggleButton();
//        getDescriptionTextbox();
//        if (billObj.getCustomerPhnNo() != null) {
//            getCustomerButton();
//            getCustomerPhoneNoField().setText(billObj.getCustomerPhnNo());
//            getGoPhoneNumberButton();
//            getConfirmButton();
//        }
//        if (billObj.getCustomerEmail() != null) {
//            getCustomerButton();
//            getUserEmailField().setText(billObj.getCustomerEmail());
//            getEmailGoButton();
//
//            getMoreOption();
//
//            getRepeatField();
//            getRepeatOption();
//            getCustomerCancelOption();
//            getDoneBtn();
//        }
//        getConfirmButton();
//        getContinueWithoutButton();
//    }


    public void getEmailGoButton() {
        click(goBtnEmail);
    }

    public void enterCustomerDetail(String customerNameFieldText) {
        actionEnterText(customerNameField, customerNameFieldText);
    }

    public void clickOnDoneButton() {
        click(billDoneBtn);
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
        staticWait(3000);
        click(customerBtn);
    }

    public void getCustomerHeader() {
        click(customerHeader);
    }


    public void getMessagePopupHeader() {
        click(messagePopupHeader);
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
        // uploding store image

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file' and @accept='image/*']"));

        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator+ "ImageResources"+ File.separator + "image" + File.separator + "BillDummyImg.jpg";
        fileInput.sendKeys(filePath);


    }


    public void uploadPdf() throws AWTException {
        uploadImageAsAttachment("/src/main/resources/ImageResources/image/dummy");
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


    public void getDeleteButton() {
        staticWait(4000);
        clickElementByJS(deleteButton);
    }

    public void clickOnNotPaidLabel() {
        staticWait(3000);
        hoverAndClick(notPaid, notPaid);
    }


    public void reduceScreenResolution() throws AWTException {
        Robot robot = new Robot();

        // Press and hold the Control key
        robot.keyPress(KeyEvent.VK_CONTROL);

        // Press the Minus (-) key
        robot.keyPress(KeyEvent.VK_MINUS);
        robot.keyRelease(KeyEvent.VK_MINUS); // Release Minus key

        // Release the Control key
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void getDeleteIcon() {
        staticWait(2000);
        click(deleteIcon);
    }

    public void clickOnMemoButton() {
        click(memoBtn);
    }

    public void getMemoField() {
        String maxLengthValue = getAttribute(memoField, "maxlength");
        Log.info(maxLengthValue);
        Assert.assertEquals(maxLengthValue, "200");
        memoTxt = "Memo Text" + requiredString(5);
        staticWait(4000);
        actionEnterText(memoField, memoTxt);
    }


    public void getMemoFieldMessage() {

        String memoFieldMessages = getText(memoFieldMessage);
        Assert.assertEquals(memoFieldMessages, "Customer will not see this memo");
    }

    public void getMemoPopUpTitle() {

        String memoPopUpTitles = getText(memoPopUpTitle);
        Assert.assertEquals(memoPopUpTitles, "Memo");
    }

    public void getEveryDayFieldValue(String specificNumber) {
        String attValue = getAttribute(everyDayField, "value");
        Assert.assertEquals(attValue, "1");
        Log.info("Attribute value is fetched");
        staticWait(2000);
        actionEnterText(specificNumbers, specificNumber);
        Log.info("specificNumberTxt:" + specificNumber);
    }

    public void getEveryWeekFieldValue(String specificNumber) {
        String attValue = getAttribute(everyWeekField, "value");
        Assert.assertEquals(attValue, "1");
        Log.info("Attribute value is fetched");
        staticWait(2000);
        actionEnterText(specificNumbers, specificNumber);
        Log.info("specificNumberTxt:" + specificNumber);
    }

    public void getEveryMonthFieldValue(String specificNumber) {
        String attValue = getAttribute(everyMonthField, "value");
        Assert.assertEquals(attValue, "1");
        Log.info("Attribute value is fetched");
        staticWait(2000);
        actionEnterText(specificNumbers, specificNumber);
        Log.info("specificNumberTxt:" + specificNumber);
    }


    public void clickOnRepeatField() {
        staticWait(2000);
        click(paidRepeatField);
        String repeatText = getText(repeatTxt);
        Assert.assertEquals(repeatText, "Repeat");
    }

    public void closePopup() {
        staticWait(5000);
        if (isElementDisplayed(crossIcon)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(2000);
            clickOnCrossIcon();
        } else {
            Log.info("No pop-up showed");
        }

    }

    public void enableTaxToggleBtn() {
        if (isElementDisplayed(taxToggleBtn)) {
            getEnableTaxToggleButton();
        } else {
            clickOnMoreSection();
            getEnableTaxToggleButton();
            enterTextInTaxRateField("10.000");
            clickOnSaveBtn();
        }
    }

    public void closePaymentpopup() {
        staticWait(3000);
        if (isElementDisplayed(closePopup)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(5000);
            BillClosePopup();
        } else {
            Log.info("No pop-up showed");
        }
    }

    public void removeNonNumericValueFromTheValue() {
        String amt = "1000.00";
        String text = getText(reccuringAmount);  // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String numericValue = text.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + numericValue); // Output: 1000.00// Remove non-numeric characters
        Assert.assertEquals(amt, numericValue);
    }

    public void validatingEnteredAmount() {
        String amount = getText(enteredAmount);  // Get the value from the field
        Log.info("Field value: " + amount);

        // Remove non-numeric characters (like commas or currency symbols)
        String extractedNumber = amount.replaceAll("[^0-9]", "");
        Log.info("Extracted Number: " + extractedNumber);

        // Parse to integer for comparison
        int actualAmount = Integer.parseInt(extractedNumber);

        // Validate against the limit
        if (actualAmount > 50000) {
            Log.info("Restriction FAILED. Field allowed more than 50,000: " + actualAmount);
        } else {
            Log.info("Restriction WORKING. Value in field is within limit: " + actualAmount);
        }
    }


    public void validateEnteredAmount() {
        String testInput = "500001";
        // Try to enter more than 50000
        staticWait(3000);

        String fieldValue = getText(enteredAmount);
        staticWait(3000);


        // Read actual value from the field

        Log.info("Attempted to enter: " + testInput);
        Log.info("Actual field value after restriction: " + fieldValue);

        // Remove non-numeric characters if the field includes commas or currency symbols
        // String numericFieldValue = fieldValue.replaceAll("[^0-9]", "");
        String numericFieldValue = fieldValue.replaceAll("[^0-9.]", "");

        double actualAmount = Double.parseDouble(numericFieldValue);

        if (actualAmount > 50000.00) {
            Log.info(" Restriction FAILED. Field allowed more than 50,000: " + actualAmount);
        } else {
            Log.info(" Restriction WORKING. Value in field is within limit: " + actualAmount);
        }
    }

    public void getAmountValue() {
        String text = getText(configureAmount);  // Get text (e.g., "Maximum $50,000")
        String numericValue = text.replaceAll("[^0-9]", ""); // Remove non-numeric characters
        Log.info("Extracted Number: " + numericValue); // Output: 50000
    }

    public void clickOnCloseIcon() {
        staticWait(3000);
        if (isElementDisplayed(closeLogoPopupBtn)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(4000);
            getCloseLogoPopupBtn();
        } else {
            Log.info("No pop-up showed");
        }

    }

    public void closePopupOnBillPage() {
        staticWait(3000);
        if (isElementDisplayed(crossPopUpIcon)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(5000);
            closePopupIcon();
        } else {
            Log.info("No pop-up showed");
        }
    }

    public void getDailyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Daily")) {
                staticWait(2000);
                click(dailyCheckbox);
                staticWait(2000);
                getEveryDayFieldValue("3");
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
                List<WebElement> selectedElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement selectedElement : selectedElements) {
                    staticWait(2000);
                    scrollToDown();
                    String selectedTxt = selectedElement.getText();
                    Log.info("Selected: " + selectedTxt);
                }
            }
        }
    }


    public void getWeeklyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Weekly")) {
                staticWait(2000);
                click(weeklyCheckbox);
                staticWait(2000);
                getEveryWeekFieldValue("3");
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
                List<WebElement> selectedElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement selectedElement : selectedElements) {
                    staticWait(2000);
                    scrollToDown();
                    String selectedTxt = selectedElement.getText();
                    Log.info("Selected: " + selectedTxt);
                }
            }
        }
    }

    public void getMonthlyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Monthly")) {
                staticWait(2000);
                click(MonthlyCheckbox);
                staticWait(2000);
                getEveryMonthFieldValue("3");
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
                List<WebElement> selectedElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement selectedElement : selectedElements) {
                    staticWait(2000);
                    scrollToDown();
                    String selectedTxt = selectedElement.getText();
                    Log.info("Selected: " + selectedTxt);
                }
            }
        }
    }

    public void getYearlyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Yearly")) {
                staticWait(2000);
                click(yearlyCheckbox);
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
            }
        }
    }
    //        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
//        for (WebElement element : elements) {
//            staticWait(3000);
//            String repeatTxt = element.getText();
//            Log.info("Clicking on: " + repeatTxt);
//            element.click();
//            staticWait(2000);
//
//            switch (repeatTxt) {
//                case "Daily":
//                    getEveryDayFieldValue("1");
//                    break;
//                case "Weekly":
//                    getEveryWeekFieldValue("1");
//                    break;
//                case "Monthly":
//                    getEveryMonthFieldValue("1");
//                    break;
//                case "Yearly":
//                     Log.info("Every month field is not displayed.");
//                    break;
//                default:
//                    Log.info("No repeat selected");
//                    break;
//            }
//    public void activateAfterFirstElement() {
//        List<WebElement> selectedElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
//        for (WebElement selectedElement : selectedElements) {
//            staticWait(2000);
//
//            scrollToDown();
//            String selectedTxt = selectedElement.getText();
//            Log.info("Selected: " + selectedTxt);
////                selectedElement.click();
////                if(isElementDisplayed(timesTotalField)){
////                    Log.info("Time total field appears");
////                }
////                else{
////                    Log.info("Ends on date field appears");
////                }
//
//        }
//    }

    public void clickOnRepeatsection() {
        staticWait(2000);
        click(paidRepeatField);
    }

    public void assertUpgradePlan() {
        scrollToElement(repeatUpgradePlan);

        String repeatUpgradePlans = getText(repeatUpgradePlan);
        Assert.assertEquals(repeatUpgradePlans, "Upgrade your plan");

        click(repeatUpgradePlanNotNowBtn);
    }

    public void clickOnReccuring() {

        staticWait(2000);
        scrollToElement(reccuringMenu);
        click(reccuringMenu);
        click(reccuringBill);
    }

    public void createBillWithoutCustomer() {
        Login();

        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Click on New Bill Button
        getNewBillButton();

        // Verify New Bill popup Web Elements
        String billPopupTitle = getText(billPopupHeader);
        Assert.assertEquals(billPopupTitle, BillHeader);
        Assert.assertTrue(isElementDisplayed(amountTxtField), "Amount");
        Assert.assertTrue(isElementDisplayed(addBillDescription), "Description (optional)");
        Assert.assertTrue(isElementDisplayed(customerDropdown), "Select or create a new customer");
        Assert.assertTrue(isElementDisplayed(moreLabelTxt), "More options");


        // Verify Default value of Amount tab
        String defaultAmt = getAttribute(amtInput, "value");
        Assert.assertEquals(defaultAmt, "$0.00");

        //Verify Confirm Button is disabled before entering amount
        scrollToElement(btnDisabled);
        Assert.assertTrue(isElementDisplayed(btnDisabled));

        //Enter amount
        String amt = "2,999.00";
        // Thread.sleep(4000);
        actionEnterText(amtTbx, amt);

        Assert.assertTrue(isElementDisplayed(taxToggleBtnDisable));

        // Verify Default Confirm button is enabled after entering amount
        scrollToElement(confirmBtn);
        Assert.assertTrue(isElementDisplayed(confirmBtn));

        //Click Confirm
        getConfirmButton();

        //Verify Message popup and Buttons
        String messagePopupHeaders = getText(messagePopupHeader);
        Assert.assertEquals(messagePopupHeaders, "Message");

        Assert.assertTrue(isElementDisplayed(selectCustomer));
        Assert.assertTrue(isElementDisplayed(continueWithoutBtn));

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();
    }

    public void deleteBill() {
        clickOnNotPaidLabel();
        staticWait(2000);
        getDeleteButton();
        getDeleteIcon();
    }

    public void createBillWithCustomer(String phoneNumber, String emailID) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Click on New Bill Button
        getNewBillButton();

        // Verify New Bill popup
        //  Assert.assertEquals(popUpHeader, "Bill");
        String popupheader = getText(popUpHeader);
        Assert.assertEquals(popupheader, "Bill");

        //Verify Confirm Button is disabled before entering amount
        scrollToElement(btnDisabled);
        Assert.assertTrue(isElementDisplayed(btnDisabled));


        //Enter amount
        String amt = "2,000.00";
        staticWait(3000);
        scrollToElement(amtTbx);
        actionEnterText(amtTbx, amt);

        //Verify Default Confirm button is enabled after entering amount
        scrollToElement(confirmBtn);
        Assert.assertTrue(isElementDisplayed(confirmBtn));


        //Click Confirm
        getConfirmButton();

        //Verify Message popup and Buttons
        String messagePopupHeade = getText(messagePopupHeader);
        Assert.assertEquals(messagePopupHeade, "Message", "Message popup header");

        Assert.assertTrue(isElementDisplayed(selectCustomer));

        Assert.assertTrue(isElementDisplayed(continueWithoutBtn));


        //click on select customer button.
        getSelectACustomerButton();

        //Verify Customer popup
        String phoneNumberField = "Phone number. Existing or new";
        String phone = getAttribute(customerNumber, "placeholder");
        //   Assert.assertTrue(Boolean.parseBoolean(phone), phoneNumberField);
        Assert.assertEquals(phone, phoneNumberField);
        Log.info(phone);

        String emailFieldTxt = "Email. Existing or new";
        String email = getAttribute(emailField, "placeholder");
        //  Assert.assertTrue(Boolean.parseBoolean(email), emailField);
        Assert.assertEquals(email, emailFieldTxt);
        Log.info(email);


        //   Select Customer
        getCustomerPhoneNoField(phoneNumber);
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click Confirm

        getConfirmButton();

        //Verify toast message : Success message Popup.
        Assert.assertTrue(isElementDisplayed(successMessage));
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        String toastMess = getText(successMessage);
        Assert.assertEquals(toastMess, toastMessage);


        //Close popup
        closePopupOnBillPage();

        //Deleting Created Bill
//        waitForElementToBeClickable(notPaid, 5);
//        clickOnNotPaidLabel();
    }

    public void verifyCreateBillForSuggestedCustomer(String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "105.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer

        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();
        getConfirmButton();

        //Verify toast message : Success message Popup.
        waitForElementToBeVisible(successMessage, 10);
        Assert.assertTrue(isElementDisplayed(successMessage));

        String successMsg = getText(successMessage);

        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assert.assertEquals(successMsg, toastMessage);

        //Close popup
        closePopup();

        //Verify not paid label for generated amount
        Assert.assertTrue(isElementDisplayed(notPaidLabel), "Not Paid Label");
        Assert.assertTrue(isElementDisplayed(uniqueRefNo), "Unique Reference No");
        Assert.assertTrue(isElementDisplayed(billTimeOnPopup), "Bill Time On Popup");

        staticWait(3000);


    }

    public void verifyBillCreationByOptionalFields(String amount, String DesAmount, String emailID) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //click on more option section
        clickOnMoreSection();

        //Asserting 'None' text bydefault in the 'Ref No' field.
        assertGetRefNotxt();
        //Asserting Reference No.' popup.
        clickOnGetRefNotxt();
        //Asserting entered text in refno text field
        assertEnteredText();
        assertDescriptionNonetxt();
        // Click on Descrption field
        entertxtInDescriptiontxt();
        assertEnteredTextInDescriptionField();
        enterInBillTxtField(amount, DesAmount);

        //select customer to share the bill
        //Select Suggested Customer
        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();
        getConfirmButton();

        //Close popup
        closePopup();


    }

    public void verifyingBillCreationWithConfiguredBilledAmount() {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "5000001";
        validateEnteredAmount();
        getAmountValue();

        staticWait(3000);
        actionEnterText(amtTbx, amt);

        validatingEnteredAmount();

        //Click Confirm
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();

        //Close popup
        closePaymentpopup();

        //Deleting Created Bill
        staticWait(3000);
    }

    public void verifyingBillCreationWithOutConfiguredBillAmount() {


        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillTest);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        amt = "300001";


        getAmountValue();

        staticWait(3000);
        actionEnterText(amtTbx, amt);

        validatingEnteredAmount();


        //Click Confirm
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();


        //Close popup
        closePaymentpopup();


        //Deleting Created Bill
        staticWait(3000);


    }

    public void createBillByAttachingImageFile() throws InterruptedException, AWTException {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillTest);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        Thread.sleep(4000);
        actionEnterText(amtTbx, amt);

        clickOnTapToAddImageFiles();

        //Click Confirm
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();
    }

    public void verifyingBillCreationByAttachingPdfFile() throws InterruptedException, AWTException {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        Thread.sleep(4000);
        actionEnterText(amtTbx, amt);

        clickOnTapToAddPdfFiles();

        //Click Confirm
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();

        //Close popup
        closePopup();
    }

    public void verifyingBillCreationWithAddingMemoField(String emailID) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer
        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();


        //click on more option section
        clickOnMoreSection();

        String memoNoneTxts = getText(memoNoneTxt);
        Assert.assertEquals(memoNoneTxts, "None");

        getMemoFieldMessage();
        clickOnMemoButton();

        //Verifying details of 'Memo' Pop-up
        getMemoPopUpTitle();
        getMemoField();
        clickOnDoneBtn();

        //Confirming the Bill
        getConfirmButton();

        //Close popup
        closePopupOnBillPage();

        //Verify not paid label for generated amount
      //  verifyEnteredMemoText();
    }


    public void verifyingBillCreationWithEssentialFreePlan(String emailId) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationCustomerStore);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer
        getCustomerButton();
        getCustomerEmailField(emailId);
        getEmailGoButton();
        clickOnEnterNameDoneBtn();


        //click on more option section
        clickOnMoreSection();

        //Click on 'Repeat' Field
        Assert.assertTrue(isElementDisplayed(repeatLockIcon));
        clickOnRepeatsection();
        assertUpgradePlan();


        //Click on 'Expiry' Field
        Assert.assertTrue(isElementDisplayed(expireLockIcon));
        clickOnExpiryDateSection();
        assertUpgradePlan();


        //Confirming the Bill
        getConfirmButton();

        //Close popup
        closePaymentpopup();

//Verify not paid label for generated amount
        Assert.assertTrue(isElementDisplayed(notPaidLabel));
        Assert.assertTrue(isElementDisplayed(uniqueRefNo));
        Assert.assertTrue(isElementDisplayed(billTimeOnPopup));
        Assert.assertTrue(isElementDisplayed(expireDateTime));

        staticWait(3000);

    }

    public void verifyBillCreationByAddingExpirationDate(String emailID, String expiresInFieldTxt) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        staticWait(3000);
        scrollToElement(amtTbx);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer

        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();

        clickOnExpiryDateSection();
        staticWait(2000);

        String expirationDay = getText(expirationDayPopUp);
        Assert.assertEquals(expirationDay, "Expiration Date");

        String noneTxts = getText(noneTxt);
        Assert.assertEquals(noneTxts, "None");

        String dayTxts = getText(dayTxt);
        Assert.assertEquals(dayTxts, "24 Hours");

        String quterDayTxts = getText(quterDayTxt);
        Assert.assertEquals(quterDayTxts, "4 Hours");

        String oneHourTxts = getText(oneHourTxt);
        Assert.assertEquals(oneHourTxts, "1 Hour");

        String thirtyMinTxts = getText(thirtyMinTxt);
        Assert.assertEquals(thirtyMinTxts, "30 Minutes");

        //Click on Expiry Field
        actionEnterText(expiresField, expiresInFieldTxt);
        clickOnDoneBtn();


        //Click Confirm
        getConfirmButton();


        //Close popup
        closePopup();


        //Verify not paid label for generated amount
        Assert.assertTrue(isElementDisplayed(notPaidLabel));
        Assert.assertTrue(isElementDisplayed(uniqueRefNo));
        Assert.assertTrue(isElementDisplayed(billTimeOnPopup));
        staticWait(3000);
    }

    public void verifyBillCreationByAddingRecurringTransactionsDaily(String phoneNumber, String emailID) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);


        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getDailyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        getConfirmButton();


        //Close popup
        closePopup();

        staticWait(4000);
        scrollToTopOfPage();
        clickOnReccuring();

        removeNonNumericValueFromTheValue();


        //Deleting Created Bill
        staticWait(3000);


    }

    public void verifyBillCreationByAddingRecurringTransactionsWeekly(String phoneNumber, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);
        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();


        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getWeeklyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        getConfirmButton();
        //Close popup
        closePopup();

        // Assert.assertTrue(isElementDisplayed(reccuringIcon));
        staticWait(4000);
        scrollToTopOfPage();
        clickOnReccuring();

        removeNonNumericValueFromTheValue();
        //Deleting Created Bill
        staticWait(3000);
    }

    public void BillCreationByAddingRecurringTransactionsWeekly(String phoneNumber, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getWeeklyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();

        //Click Confirm

        getConfirmButton();


        //Close popup
        closePopup();

        // Assert.assertTrue(isElementDisplayed(reccuringIcon));
        staticWait(2000);
        scrollToTopOfPage();
        clickOnReccuring();

        removeNonNumericValueFromTheValue();
        //Deleting Created Bill
        staticWait(3000);
    }


    public void verifyBillCreationByAddingRecurringTransactionsMonthly(String phone, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getMonthlyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        getConfirmButton();

        //Close popup
        closePopup();
        staticWait(4000);
        scrollToTopOfPage();
        clickOnReccuring();
        removeNonNumericValueFromTheValue();

        //Deleting Created Bill
        staticWait(3000);
    }

    public void verifyBillCreationByAddingRecurringTransactionsYearly(String phone, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount

        staticWait(3000);
        String amt = "1000.00";
        actionEnterText(amtTbx, amt);

        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getYearlyFieldValue();
        clickOnDoneBtn();

        //Click Confirm
        staticWait(2000);
        getConfirmButton();

        //Close popup
        closePopup();

        Assert.assertTrue(isElementDisplayed(reccuringIcon));
        clickOnReccuring();

        removeNonNumericValueFromTheValue();

        //Deleting Created Bill
        staticWait(3000);
    }

    public void verifyBillCreationByAddingpaymentMethod(String emilId) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1005.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer

        getCustomerButton();
        getCustomerEmailField(emilId);
        getEmailGoButton();

        //Share bill by clicking on Share link to customer button
        clickOnpaymentMethodLink();
        clickOnshareLinkToCustomer();

        //Share bill by adding card details
        clickOnpaymentMethodLink();

    }

    public void createBillWithCustomerAndPayThroughAutoPayment() {

        String emailId = requiredString(4) + "@yopmail.com";
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillTest);
        getContinueButton();

        // Click on New Bill Button
        getNewBillButton();

        // Verify New Bill popup
        //  Assert.assertEquals(popUpHeader, "Bill");
        String popupheader = getText(popUpHeader);
        Assert.assertEquals(popupheader, "Bill");

        //Verify Confirm Button is disabled before entering amount
        scrollToElement(btnDisabled);
        Assert.assertTrue(isElementDisplayed(btnDisabled));

        //Enter amount
        String amt = "1005.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer

        getCustomerButton();
        getCustomerEmailField(emailId);
        getEmailGoButton();
        clickOnEnterNameDoneBtn();

        staticWait(3000);
        clickOnpaymentMethodLink();
        ClickOnCustomerPermissionCheckbox();
        ClickOncustomerPrmissionDoneButton();

        staticWait(5000);
        payment.getPayThroughCreditCardThroughAutoPayment();

        staticWait(5000);

        // Clicking on use this toggle button
        getUseThisToggle();
        scrollToDown();

        // Verify that info message appears
        Assert.assertTrue(isElementDisplayed(autoPaymentInfoMsg), "Autopayment Info Message");
        Assert.assertTrue(isElementDisplayed(removeButtonUnderInfoMsg), "Remove Btn ");
        Assert.assertTrue(isElementDisplayed(chargeButton), "Charge Button");

        // clicking on remove button
        staticWait(3000);
        getRemoveBtnUnderInfoMsg();

        // Verify that toggle gets disabled
        Assert.assertFalse(isElementDisplayed(autoPaymentInfoMsg), "Autopayment method disappears");
        Assert.assertTrue(!isToggleEnabled(autoGenToggleBtn));


        // Clicking on use this toggle button
        getUseThisToggle();
        scrollToElement(chargeButton);
        waitForElementToBeVisible(chargeButton, 3);
        getChargeButton();

        staticWait(3000);

    }
}