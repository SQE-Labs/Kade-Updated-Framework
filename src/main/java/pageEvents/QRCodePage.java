package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Constants;

import java.awt.*;
import java.nio.file.Paths;

public class QRCodePage extends BaseTest {

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
    By updateBtn = By.xpath("//button[text()='Update']");
    By storeName = By.xpath("//h3[text()='Automation Bill Flow']");
    By authorizePayment = By.xpath("//h5[text()='Authorized Payment Method']");
    By newQrCode = By.xpath("//button[text()='Generate a new QR code']");
    By flexibleAmount = By.xpath("//span[text()='Flexible amount']");
    By fixedAmount = By.xpath("//span[text()='Fixed amount']");
    By tickets = By.xpath("//span[text()='Tickets/Events']");
    By donations = By.xpath("//span[text()='Donations']");
    By flexibleAmounteader = By.xpath("//p[text()='Flexible amount']");
    By editPaymentLink=By.xpath("//h1[normalize-space()='Edit Payment link']");
    By titleField=By.xpath("//input[@name='description']");
    By amountDesc=By.xpath("//label[text()='Amount description']/../child::textarea");
    By editContent=By.xpath("//button[text()='Edit content']");
    By customizeContent=By.xpath("//h5[text()='Customize content']");
    By title=By.xpath("(//div[@class='qr-template']/div)[1]");
    By titleFieldOnPopup=By.xpath("//input[@name='title']");
    By saveBtnOnFieldOnPopup=By.xpath("//input[@name='title']/../../child::div/button[text()='Save']");
    By uploadImage=By.xpath("(//div[@class='template-main-image mb-3'])[1]");
    By content=By.xpath("(//div[@data-field='content'])[1]");
    By contentPage=By.xpath("//h5[text()='HTML Editor']");
    By enterInContentPage=By.xpath("//h5[text()='HTML Editor']/../..//p");
    By addBtn =By.xpath("//span[text()='Add']/..");
    By saveBtnContentPage=By.xpath("//h5[text()='HTML Editor']/../../child::div//button[text()='Save']");
    By fieldType=By.xpath("//select[@name='type']");
        By selectValue=By.xpath("//option[text()='Full name']");
        By titleNewField=By.xpath("//input[@name='name']");
        By enableToggle=By.xpath("(//i[@class='far fa-toggle-off custom-check-off '])[4]");
        By saveBtnOnNewField=By.xpath("(//button[text()='Save'])[2]");















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
    public void enterAmountDesc(String amountTxt){
        actionEnterText(amountDesc,amountTxt);
    }
    public void clickOneditContent() {
        click(editContent);
    }
    public void clickOncustomizeContent() {
        click(customizeContent);
    }

    public void clickOntitle() {
        staticWait(5000);
        hoverAndClick(title,title);
    }
    public void clickOntitleFieldOnPopup(String enterTitleField) {
        actionEnterText(titleFieldOnPopup,enterTitleField);
    }
    public void clickOnSaveBtnOnFieldOnPopup() {
        click(saveBtnOnFieldOnPopup);
    }
    public void clickOncontent() {
        click(content);
        softAssert.assertTrue(isElementDisplayed(contentPage ));
    }
    public void enterInContentPage(String txtEnterInContentPage) {
        actionEnterText(enterInContentPage,txtEnterInContentPage);
     }

    public void clickOnsaveBtnContentPage() {
        click(saveBtnContentPage);
     }
     public void clickOnAddBtn(){
        staticWait(3000);
        scrollToElement(addBtn);
        click(addBtn);
     }
     public void selectfieldType(){
        click(fieldType);
        staticWait(2000);
        click(selectValue);
     }
     public void entertitleNewField(String titleNewFieldTxt){
        actionEnterText(titleNewField,titleNewFieldTxt);
     }
     public void clickOnToggle(){
        click(enableToggle);
     }
     public void clickOnsaveBtnOnNewField(){
        click(saveBtnOnNewField);
     }




    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        staticWait(4000);
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }
    public void uploadImageInStoreLogo() throws AWTException {

        uploadImageAsAttachment("/src/main/resources/ImageResources/image/BillDummyImg");
    }





    public void selectStore() {
        Login();
        clickOnmanageBusinessMenu();
        clickOnqrCodeMenu();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();
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
        String titleLength=getAttribute(titleField,"maxlength");
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

     public void addAdditionalField(String entertitleNewFieldTxt){
         selectStore();
         clickOnnewQrCode();
         clickOnFlexibleAmount();
         clickOnAddBtn();
         selectfieldType();
         entertitleNewField(entertitleNewFieldTxt);
         clickOnToggle();
         clickOnsaveBtnOnNewField();
     }
}
