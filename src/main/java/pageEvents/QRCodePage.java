package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QRCodePage extends BaseTest {
    MyStorePage mystore = new MyStorePage();


    By manageBusinessMenu = By.xpath("//a[text()='Manage Business']");
    By qrCodeMenu = By.xpath("//div[text()='QR Code Dashboard']/..");
    By continueBtn = By.xpath("//button[@type='submit']");
    By directPaySection = By.xpath("//div[text()=' Direct Pay']");
    By contactScreenSection = By.xpath("//div[text()=' Contact Screen']");
    By customerPermissionSection = By.xpath("//div[text()=' Customer permissions']");
    By directPaySec = By.xpath("//div[text()=' Direct Pay']/../..");
    By contactScreenSec = By.xpath("//div[text()=' Contact Screen']/../..");
    By custPerSec = By.xpath("//div[text()=' Customer permissions']/../..");
    By directPayHeader = By.xpath("//h6[text()='Direct Pay']");
    By copyIcon = By.xpath("//h6[text()='Direct Pay']/..//button");
    By downloadIcon = By.xpath("(//h6[text()='Direct Pay']/..//a)[1]");
    By viewLinkIcon = By.xpath("(//h6[text()='Direct Pay']/..//a)[2]");
    By crsIcon = By.xpath("//h5[text()='QR code view']/../button");

    By ContactScreenDownloadIcon = By.xpath("(//h6[text()='Contact Screen']/..//a)[1]");
    By ContactScreenViewIcon = By.xpath("(//h6[text()='Contact Screen']/..//a)[2]");
    By ContactScreenCopyIcon = By.xpath("//h6[text()='Contact Screen']/..//button");
    By ContactScreenHeader = By.xpath("//h6[text()='Contact Screen']");


    By cusPerDownloadIcon = By.xpath("(//h6[text()='Customer permissions']/..//a)[1]");
    By cusPerViewIcon = By.xpath("(//h6[text()='Customer permissions']/..//a)[2]");
    By cusPerCopyIcon = By.xpath("//h6[text()='Customer permissions']/..//button");
    By cusPerHeader = By.xpath("//h6[text()='Customer permissions']");
    By payNow = By.xpath("//button[text()='Pay Now']");
    By enterAmt = By.xpath("//h5[text()='Enter the amount']");
    By enterAmount = By.xpath("//input[@name='amount']");
    By viewLink = By.xpath("//i[contains(@class,'fas fa-external')]/..");
    By payNowBtn = By.xpath("//button[text()='Pay Now']");
    By countinuePay = By.xpath("//button[text()='Continue to pay']");
    By updateBtn = By.xpath("//button[text()='Update']");
    By storeName = By.xpath("//h3[text()='Automation Bill Flow']");
    By authorizePayment = By.xpath("//h5[text()='Authorized Payment Method']");
    By newQrCode = By.xpath("//button[text()='Generate a new QR code']");
    By flexibleAmount = By.xpath("//span[text()='Flexible amount']/..");
    By fixedAmount = By.xpath("//span[text()='Fixed amount']");
    By fixedAmoutSec=By.xpath("//span[text()='Fixed amount']/..");
    By addButn=By.xpath("//button[text()='Add a line']");
    By validationMsg=By.xpath("//p[text()='Please review the highlighted field(s)']");
    By tickets = By.xpath("//span[text()='Tickets/Events']");
    By ticketsSection = By.xpath("//span[text()='Tickets/Events']/..");
    By clickOnClockIcon=By.xpath("(//i[@class='fal fa-clock'])[2]/..");
    By priceSchedule=By.xpath("//h5[text()='Price schedule']");
    By datePicker=By.xpath("(//input[@data-field='scheduleDate'])[1]");
    By currentDate=By.xpath("//td[@class='today active start-date active end-date available']");
    By monthHeaderText=By.xpath("(//th[@class='month'])[1]");
    By countinueBtn=By.xpath("//button[text()='Continue']");
    By newPriceField=By.xpath("(//input[@data-field='price'])[1]");

    By donations = By.xpath("//span[text()='Donations']");
    By flexibleAmounteader = By.xpath("//p[text()='Flexible amount']");
    By editPaymentLink = By.xpath("//h1[normalize-space()='Edit Payment link']");
    By titleField = By.xpath("//input[@name='description']");
    By amountDesc = By.xpath("//label[text()='Amount description']/../child::textarea");
    By editContent = By.xpath("//button[text()='Edit content']");
    By customizeContent = By.xpath("//h5[text()='Customize content']");
    By title = By.xpath("(//div[@class='qr-template']/div)[1]");
    By titleFieldOnPopup = By.xpath("//input[@name='title']");
    By saveBtnOnFieldOnPopup = By.xpath("//input[@name='title']/../../child::div/button[text()='Save']");
    By uploadImage = By.xpath("(//div[@class='template-main-image mb-3'])[1]");
    By content = By.xpath("//div[@class='template-content text-black p-2 mb-3']//a[@class='-remove- stretched-link']/..");
    By contentPage = By.xpath("//h5[text()='HTML Editor']");
    By enterInContentPage = By.xpath("//h5[text()='HTML Editor']/../..//p");
    By addBtn = By.xpath("//span[text()='Add']/..");
    By saveBtnContentPage = By.xpath("//h5[text()='HTML Editor']/../../child::div//button[text()='Save']");
    By fieldType = By.xpath("//select[@name='type']");
    By selectValue = By.xpath("//option[text()='Full name']");
    By titleNewField = By.xpath("//input[@name='name']");
    By enableToggle = By.xpath("(//i[@class='far fa-toggle-off custom-check-off '])[4]");
    By saveBtnOnNewField = By.xpath("(//button[text()='Save'])[2]");
    By editIcon = By.xpath("//div[@class='-titlediv- flex-grow-1 mx-2']/..//i[@class='fal fa-pencil']");
    By addButton = By.xpath("//span[text()='Add']");
    By enterTxt = By.xpath("(//input[@name='name'])[1]");
    By correctIcon = By.xpath("(//button[@type='submit'])[1]");
    By deleteIcon = By.xpath("//div[contains(@class,'mb-2 border')]//button[@type='button']/i[@class='far fa-trash']/..");
    By calender = By.xpath("//input[@name='endDate']");
    By monthHeader = By.xpath("(//th[@class='month'])[1]");
    By toggleBtn = By.xpath("((//label[@class='custom-checkbox'])[3]/i)[1]");
    By saveBtn = By.xpath("//button[text()='Save']");
    By eyeIcon = By.xpath("(//button[@class='p-0 btn btn-link'])[1]");
    By viewText = By.xpath("//a[normalize-space()='View']");
    By linkNotAvailableTxt = By.xpath("//div[normalize-space()='This link is not available.']");
    By dashboardLink = By.xpath("//span[text()='Return to dashboard']/..");
    By QrDashboard = By.xpath("//h1");
    By pencilIcon = By.xpath("(//a[@class='p-0 me-4 btn btn-link'])[1]");
    By typeOfEntryDropdown = By.xpath("//select[@name='type']/option");
    By QrCodeView = By.xpath("//span[text()='QR code view']");
    By ClickCopyIcon = By.xpath("//i[@class='fal fa-copy']/..");
    By eyeSuccessIcon = By.xpath("//i[@class='far fa-eye text-success']/..");
    By filterIcon = By.xpath("//button[@class='btn btn-link']");
    By crossIcon = By.xpath("(//button[@class='btn-close'])[2]");
    By descriptionTxt=By.xpath("(//textarea[@placeholder='Description'])[2]");
    By descriptionAmtField=By.xpath("(//input[@class='text-end form-control'])[2]");
    By QrFilterIcon=By.xpath("//button[@class='btn btn-link']");


    public void clickOnmanageBusinessMenu() {
        waitForElementToBeVisible(manageBusinessMenu, 10);

        scrollToElement(manageBusinessMenu);
        click(manageBusinessMenu);
    }

    public void clickOnqrCodeMenu() {
        staticWait(3000);
        scrollToElement(qrCodeMenu);
        waitForElementToBeVisible(qrCodeMenu, 10);
        click(qrCodeMenu);
    }

    public void clickOnPayNowBtn() {
        click(payNowBtn);
    }

    public void clickOnCrossIcon() {
        click(crossIcon);
    }

    public void enterTxtIndescriptionTxtFiled(String descriptionTxtField){
        staticWait(2000);
        scrollToTopOfPage();
        actionEnterText(descriptionTxt,descriptionTxtField);
    }
    public void enterTxtIndescriptionAmtField(String descriptionAmtTxtField){

        actionEnterText(descriptionAmtField,descriptionAmtTxtField );
    }

    public void clickOnCountnuePayBtn() {
        click(countinuePay);
    }
    public void clickOnQrFilterIcon(){
        click(QrFilterIcon);
    }

    public void selectStore(String store) {
        staticWait(3000);
        // click(selectStore);
        click(By.xpath("//span[contains(text(),'" + store + "')]"));
        click(By.xpath("//span[contains(text(),'" + store + "')]"));
    }

    public void getContinueButton() {
        waitForElementToBeVisible(continueBtn, 10);
        click(continueBtn);
    }

    public void ClickOnDirectPaySec() {
        click(directPaySec);
    }

    public void clickOnCrsIcon() {
        click(crsIcon);
    }

    public void ClickOncontactScreenSec() {

        click(contactScreenSec);
    }

    public void ClickOncustPerSec() {
        click(custPerSec);
    }

    public void enterAmount(String amount) {
        actionEnterText(enterAmount, amount);
    }

    public void clickOnViewLink() {
        staticWait(4000);
        click(viewLink);
    }

    public void clickOnUpdateBtn() {
        click(updateBtn);
    }

    public void clickOnnewQrCode() {
        click(newQrCode);
    }

    public void clickOnFlexibleAmount() {
        click(flexibleAmount);
    }

    public void enterAmountDesc(String amountTxt) {
        actionEnterText(amountDesc, amountTxt);
    }

    public void clickOneditContent() {
        click(editContent);
    }

    public void clickOncustomizeContent() {
        click(customizeContent);
    }

    public void clickOntitle() {
        staticWait(5000);
        hoverAndClick(title, title);
    }

    public void clickOntitleFieldOnPopup(String enterTitleField) {
        staticWait(3000);
        actionEnterText(titleFieldOnPopup, enterTitleField);
    }

    public void clickOnSaveBtnOnFieldOnPopup() {
        click(saveBtnOnFieldOnPopup);
    }

    public void clickOncontent() {
        scrollToElement(content);
        staticWait(2000);
        click(content);
        staticWait(4000);
        Assert.assertTrue(isElementDisplayed(contentPage));
    }

    public void enterInContentPage(String txtEnterInContentPage) {
        actionEnterText(enterInContentPage, txtEnterInContentPage);
    }

    public void clickOnsaveBtnContentPage() {
        click(saveBtnContentPage);
    }

    public void clickOnAddBtn() {
        staticWait(3000);
        scrollToElement(addBtn);
        click(addBtn);
    }

    public void selectfieldType() {
        click(fieldType);
        staticWait(2000);
        click(selectValue);
    }

    public void entertitleNewField(String titleNewFieldTxt) {
        actionEnterText(titleNewField, titleNewFieldTxt);
    }

    public void clickOnToggle() {
        click(enableToggle);
    }

    public void clickOnsaveBtnOnNewField() {
        click(saveBtnOnNewField);
    }

    public void clickOnEditIcon() {
        staticWait(3000);
        scrollToElement(editIcon);
        click(editIcon);
    }

    public void enterTxtInFlexibleAmtField(String Txt) {
        actionEnterText(enterTxt, Txt);
    }

    public void clickOnCorrectIcon() {
        click(correctIcon);
    }

    public void clickOndeleteIcon() {
        click(deleteIcon);
    }

    public void clickOnSaveBtn() {
        scrollToElement(saveBtn);
        staticWait(2000);
        click(saveBtn);
    }

    public void clickOnEyeIcon() {
        click(eyeIcon);
        String QrCode = getText(QrCodeView);
        Assert.assertEquals(QrCode, "QR code view");
    }

    public void ClickOnViewIcon() {
        click(viewText);
    }

    public void clickOnCopyIcon() {
        click(ClickCopyIcon);
    }

    public void clickEyeIcon() {
        staticWait(3000);
        click(eyeSuccessIcon);
    }

    public void disableTogleButton() {
        scrollToElement(toggleBtn);
        if (isEnabled(toggleBtn)) {
            click(toggleBtn);
        } else {
            Log.info("Toggle button is disabled only");
        }
    }

    public void clickOnPencilIcon() {
        scrollToElement(pencilIcon);
        click(pencilIcon);
    }

    public void clickOndashboardLink() {
        scrollToElement(dashboardLink);
        click(dashboardLink);
        String dahboardTxt = getText(QrDashboard);
        Assert.assertEquals(dahboardTxt, "QR Code Dashboard");
    }


    public void clickOnCalenderIcon() {
        scrollToElement(calender);
        click(calender);
        staticWait(2000);
        String calenderHead = getText(monthHeader);
        Log.info(calenderHead);
        Assert.assertTrue(isElementDisplayed(monthHeader));
    }

    public void enableToggle() {
        staticWait(2000);
        scrollToElement(toggleBtn);
        if (isElementDisabled(toggleBtn)) {
            click(toggleBtn);
        } else {
            Log.info("Toggle button is on");
        }
    }


    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        staticWait(4000);
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }

    public void uploadImageInStoreLogo() throws AWTException {
        // uploding store image

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file' and @accept='image/*']"));
        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ImageResources" + File.separator + "image" + File.separator + "BillDummyImg.jpg";
        fileInput.sendKeys(filePath);
        mystore.getTickIconofImg();
        staticWait(3000);
        // uploding store image




//        uploadImageAsAttachment("/src/main/resources/ImageResources/image/BillDummyImg");
    }

    public void clickOnFilterIcon() {
        click(filterIcon);
    }
    public void clickOnfixedAmoutSec() {
        click(fixedAmoutSec);
    }
    public void clickOnaddButn() {
        click(addButn);
    }


    public void descriptionFields(){
        List<WebElement> values = getDriver().findElements(By.xpath(" //div[@class='-detail- validator d-flex mb-2 rounded p-1 clone']"));
             int totalFields = values.size();
        System.out.println("Total number of form fields: " + totalFields);

     }



    public void selectStore() {
        Login();
        clickOnmanageBusinessMenu();
        clickOnqrCodeMenu();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();
    }

    public void clickOnTicketsAndEvents(){
        click(ticketsSection);
    }
    public void clickOnClockIcon(){
        click(clickOnClockIcon);
    }
    public void clickOndatePickerIcon(){

        click(datePicker);
     }
    public void clickOnCountinueBtn(){
        scrollToElement(countinueBtn);
        click(countinueBtn);
    }
    public void enterAmountInNewPriceField(String newPriceTxtField){
        actionEnterText(newPriceField,newPriceTxtField);
    }
    public void clickOncurrentDate(){
         click(currentDate);
    }


    public void printTypeOfEntryDropdown() {
        List<WebElement> values = getDriver().findElements(By.xpath("//select[@name='type']/option"));
        for (WebElement value : values) {
            String txt = value.getText();
            Log.info("Type Of Entry Dropdown values are :" + txt);
        }
    }
    public void QrTypeDropdown() {
        List<WebElement> Types = getDriver().findElements(By.xpath("//select[@name='qrCodeType']/option"));
        for (WebElement Type : Types) {
            String txt = Type.getText();
            Log.info("Qr code Type Dropdown values are :" + txt);
        }
    }


    public void openNewWindow() {
        staticWait(4000);

        // Step 4: Switch to the new window
        switchToNewWindow();
    }


    public void typesOfQrCodes() {
        selectStore();
        softAssert.assertTrue(isElementDisplayed(directPaySection));
        softAssert.assertTrue(isElementDisplayed(contactScreenSection));
        softAssert.assertTrue(isElementDisplayed(customerPermissionSection));
    }

    public void directPaySect(String amount) {
        selectStore();
        ClickOnDirectPaySec();
        staticWait(5000);
        softAssert.assertTrue(isElementDisplayed(directPayHeader));

        softAssert.assertTrue(isElementDisplayed(copyIcon));
        WebElement element = getDriver().findElement(By.xpath("//h6[text()='Direct Pay']/..//button"));
        element.click();
        String ele = element.getAttribute("data-content");
        softAssert.assertTrue(isElementDisplayed(downloadIcon));
        softAssert.assertTrue(isElementDisplayed(viewLinkIcon));
        clickOnCrsIcon();
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        staticWait(4000);


        openNewWindow();

        // Step 5: Open the copied link in the new window
        getDriver().get(ele);
        staticWait(3000);
        clickOnPayNowBtn();
        softAssert.assertTrue(isElementDisplayed(payNow));
        waitForElementToBeVisible(enterAmt, 10);
        softAssert.assertTrue(isElementDisplayed(enterAmt));
        enterAmount(amount);

        clickOnUpdateBtn();
    }

    public void contactScreenSect() {
        selectStore();
        ClickOncontactScreenSec();
        softAssert.assertTrue(isElementDisplayed(ContactScreenHeader));
        softAssert.assertTrue(isElementDisplayed(ContactScreenCopyIcon));
        WebElement element = getDriver().findElement(By.xpath("//h6[text()='Contact Screen']/..//button"));
        element.click();
        String ele = element.getAttribute("data-content");
        softAssert.assertTrue(isElementDisplayed(ContactScreenViewIcon));
        softAssert.assertTrue(isElementDisplayed(ContactScreenDownloadIcon));
        clickOnCrsIcon();
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        openNewWindow();

        // Step 5: Open the copied link in the new window
        getDriver().get(ele);
        staticWait(3000);
        softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(authorizePayment));


    }

    public void custPermSect() {
        selectStore();
        ClickOncustPerSec();
        softAssert.assertTrue(isElementDisplayed(cusPerHeader));
        softAssert.assertTrue(isElementDisplayed(cusPerCopyIcon));
        WebElement element = getDriver().findElement(By.xpath("//h6[text()='Customer permissions']/..//button"));
        element.click();
        String ele = element.getAttribute("data-content");
        softAssert.assertTrue(isElementDisplayed(cusPerViewIcon));
        softAssert.assertTrue(isElementDisplayed(cusPerDownloadIcon));
        clickOnCrsIcon();
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        openNewWindow();

        // Step 5: Open the copied link in the new window
        getDriver().get(ele);
        staticWait(3000);

        softAssert.assertTrue(isElementDisplayed(storeName));
        softAssert.assertTrue(isElementDisplayed(authorizePayment));
    }

    public void DirectPayByViewLink(String amount) {
        selectStore();
        ClickOnDirectPaySec();
        clickOnViewLink();
        switchToNewWindow();
        clickOnPayNowBtn();
        softAssert.assertTrue(isElementDisplayed(payNow));
        waitForElementToBeVisible(enterAmt, 10);
        softAssert.assertTrue(isElementDisplayed(enterAmt));
        enterAmount(amount);
        clickOnUpdateBtn();
    }

    public void createNewQrCode() {
        selectStore();
        clickOnnewQrCode();
        staticWait(3000);
        softAssert.assertTrue(isElementDisplayed(flexibleAmount));
        softAssert.assertTrue(isElementDisplayed(fixedAmount));
        softAssert.assertTrue(isElementDisplayed(tickets));
        softAssert.assertTrue(isElementDisplayed(donations));
        clickOnFlexibleAmount();
        waitForElementToBeVisible(flexibleAmounteader, 10);
        softAssert.assertTrue(isElementDisplayed(flexibleAmounteader));
    }

    public void flexibleAmountQrCode(String enterAmount, String enterTitleField, String txtEnterInContentPage) throws AWTException {
        createNewQrCode();
        softAssert.assertTrue(isElementDisplayed(editPaymentLink));
        String titleLength = getAttribute(titleField, "maxlength");
        Log.info(titleLength);
        enterAmountDesc(enterAmount);
        clickOneditContent();
        clickOncustomizeContent();
        clickOntitle();
        clickOntitleFieldOnPopup(enterTitleField);
        clickOnSaveBtnOnFieldOnPopup();
        scrollToDown();
        uploadImageInStoreLogo();
        clickOncontent();
        enterInContentPage(txtEnterInContentPage);
        clickOnsaveBtnContentPage();
    }

    public void addAdditionalField(String entertitleNewFieldTxt) {
        selectStore();
        clickOnnewQrCode();
        clickOnFlexibleAmount();
        clickOnAddBtn();
        printTypeOfEntryDropdown();
        selectfieldType();
        entertitleNewField(entertitleNewFieldTxt);
        clickOnToggle();
        clickOnsaveBtnOnNewField();
    }

    public void editAdditionalFields(String Txt) {
        staticWait(5000);
        clickOnEditIcon();
        enterTxtInFlexibleAmtField(Txt);
        clickOnCorrectIcon();
        clickOndeleteIcon();
        clickOnCalenderIcon();
        enableToggle();
        clickOnSaveBtn();
        staticWait(5000);
    }

    public void TemporaryUnavailable() {
        staticWait(5000);
        clickOnEyeIcon();
        ClickOnViewIcon();
        switchToNewWindow();
        String linkNotTxt = getText(linkNotAvailableTxt);
        Assert.assertEquals(linkNotTxt, "This link is not available.");
    }

    public void paymentThroughByenablingTheToggleBtn(String amt) {
        selectStore();
        clickOnnewQrCode();
        clickOnFlexibleAmount();
        disableTogleButton();
        clickOnSaveBtn();
        clickEyeIcon();
        WebElement element = getDriver().findElement(By.xpath("//i[@class='fal fa-copy']/.."));
        element.click();
        String ele = element.getAttribute("data-content");
        softAssert.assertTrue(isElementDisplayed(downloadIcon));
        softAssert.assertTrue(isElementDisplayed(viewLinkIcon));
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        staticWait(4000);
        openNewWindow();
        // Step 5: Open the copied link in the new window
        getDriver().get(ele);
        staticWait(3000);
        enterAmount(amt);
        clickOnCountnuePayBtn();
        // switchToParentWindow();
        //  clickOnCrossIcon();
        //  clickOnFilterIcon();
    }

    public void fixedAmountQrCode(String descriptionTxtFiled,String descriptionAmtTxtField) {
        selectStore();
        clickOnnewQrCode();
        clickOnfixedAmoutSec();
        descriptionFields();
        clickOnaddButn();
        descriptionFields();
        clickOnSaveBtn();
        String validMsg=getText(validationMsg);
        Assert.assertEquals(validMsg,"Please review the highlighted field(s)");
        enterTxtIndescriptionTxtFiled(descriptionTxtFiled);
        enterTxtIndescriptionAmtField(descriptionAmtTxtField);
        clickOnSaveBtn();
    }
    public void ticketsAndEvents(String newPrice){
        selectStore();
        clickOnnewQrCode();
        clickOnTicketsAndEvents();
        clickOnClockIcon();

        String PriceScheduleHeader=getText(priceSchedule);
        Assert.assertEquals(PriceScheduleHeader,"Price schedule");

        clickOndatePickerIcon();
        clickOncurrentDate();
        enterAmountInNewPriceField(newPrice);
        staticWait(4000);
        clickOnCountinueBtn();
        clickOnSaveBtn();
    }

    public void QrFilter(){
        selectStore();
        clickOnQrFilterIcon();
        QrTypeDropdown();

    }
}