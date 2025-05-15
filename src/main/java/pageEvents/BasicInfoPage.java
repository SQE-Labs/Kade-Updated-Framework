package pageEvents;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;

import java.io.File;

public class BasicInfoPage extends BaseTest {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(BasicInfoPage.class);

    // Locators for BasicInfoPage Page elements
    public By custStoreConfig = By.cssSelector("a.float-end.btn.btn-link[href^='/Stores/manageStore/3790']");
    public By storeConfigTitle = By.cssSelector(".header-title.mb-0");
    public By basicInfoTab = By.xpath("//a[contains(@href, '#_71Z')]");
    public By basicInfoPg = By.cssSelector(".col-md-9.col-xl-10");
    public By storeAddress = By.xpath("//label[@class='text-muted fs-pn15'][text()='Store Address']");
    public By storePhone = By.xpath("//label[@class='text-muted fs-pn15'][text()='Store Phone']");
    public By storeCurrency = By.xpath("//label[@class='text-muted fs-pn15'][text()='Currency of the Store']");
    public By storeTaxRate = By.xpath("//label[@class='text-muted fs-pn15'][text()='Tax rate']");
    public By modifyBtn = By.xpath("//button[@class='-btn-modify- btn btn-outline-primary']");
    public By storeNameField = By.xpath("//input[@name='name']");
    public By saveButton = By.cssSelector(".-btn-save-.btn.btn-primary");
    public By storeFullAddress = By.xpath("//input[@name='fulladdress']");
    public By storePhoneField = By.xpath("(//input[@name='phone'])[1]");
    public By storeTexRateField = By.xpath("//input[@name='taxRate']");
    public By storeLogo = By.xpath("//a[@class=' -profile- d-inline-block position-relative start-50 translate-middle-x']");
    public By checkBtn = By.cssSelector(".fa.fa-check");
    public By validationMsg = By.cssSelector(".toast-message");
    public By alertMsg = By.cssSelector(".alert-content");
    public By manageBusinessAcc = By.xpath("//a[@class='sidebar-link fw-bold text-black collapsed' and text()='Manage Business']");
    public By myStoreBtn=By.cssSelector(".fa-fw.fas.fa-store");


    public void enterFields(){
        enterText(storeNameField, Constants.storeName);
        enterText(storeFullAddress,Constants.storeAddress);
        actionEnterText(storePhoneField,Constants.storePhone);
        actionEnterText(storeTexRateField,Constants.taxRate);
        scrollToElement(saveButton);
        getSaveBtn();
    }

    public void invalidInputStoreAddress(){
        enterText(storeFullAddress,Constants.invalidStoreAddress);
        scrollToElement(saveButton);
        waitForElementToBeClickable(saveButton,10);
        getSaveBtn();
    }

    public void invalidInputStorePhone() {
        scrollToElement(storePhoneField);
        click(storePhoneField);
        actionEnterText(storePhoneField,Constants.invalidStorePhone);
        scrollToElement(saveButton);
        waitForElementToBeClickable(saveButton,5);
        getSaveBtn();
    }

    public void invalidImageUpload() {
        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file']"));

        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator+ "ImageResources"+ File.separator + "image" + File.separator + "dummy.pdf";
                //userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "image" + File.separator + "dummy.pdf";
        fileInput.sendKeys(filePath);
    }

    public void storeFullAddress() {click(storeFullAddress);}

    public void getSaveBtn() {clickElementByJS(saveButton);}

    public void getStoreNameField() {click(storeNameField);}

    public void getModifyBtn() {click(modifyBtn);}

    public void getStoreConfigTitle() {click(storeConfigTitle);}

    public void getMyStoreBtn() {click(myStoreBtn);}

    public void getManageBussinessAcc() {click(manageBusinessAcc);}

    public void getCustStoreConfig() {
        waitForElementToBeClickable(custStoreConfig,5);
        click(custStoreConfig);}

}
