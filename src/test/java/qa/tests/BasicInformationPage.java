package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageEvents.BasicInfoPage;
import pageObjects.PageObjectManager;
import org.testng.Assert;
import utils.Constants;

import java.io.File;
import java.nio.file.Paths;


public class BasicInformationPage extends BaseTest {

    public static Logger log = LogManager.getLogger(BasicInformationPage.class);

    private final PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    private final BasicInfoPage basicInfoPage = pageObjectManager.getbasicInfoPage();

    @Test
    public void verifyBasicInformationPageOpens() {
        Login();
        basicInfoPage.getManageBussinessAcc();
        basicInfoPage.getMyStoreBtn();
        basicInfoPage.getCustStoreConfig();

        Assert.assertTrue(isElementDisplayed(basicInfoPage.storeConfigTitle));
        Assert.assertTrue(isElementDisplayed(basicInfoPage.basicInfoPg));
        Assert.assertTrue(isElementDisplayed(basicInfoPage.storeAddress));
        Assert.assertTrue(isElementDisplayed(basicInfoPage.storePhone));
        Assert.assertTrue(isElementDisplayed(basicInfoPage.storeCurrency));
    }

    @Test
    public void verifyModifyAndSaveChangesFunctionality() throws InterruptedException {
        log.info("Verify that the user is able to modify information after clicking on 'Modify' button");

        Login();
        basicInfoPage.getManageBussinessAcc();
        basicInfoPage.getMyStoreBtn();
        basicInfoPage.getCustStoreConfig();
        scrollToElement(basicInfoPage.modifyBtn);
        basicInfoPage.getModifyBtn();
        basicInfoPage.enterFields();

    }

    @Test
    public void verifyInvalidAddressValidation(){
        log.info("Enter Invalid or Unverified address in the Store Address field of the Store Basic Information page");

        Login();
        basicInfoPage.getManageBussinessAcc();
        basicInfoPage.getMyStoreBtn();
        basicInfoPage.getCustStoreConfig();
        scrollToElement(basicInfoPage.modifyBtn);
        basicInfoPage.getModifyBtn();
        basicInfoPage.invalidInputStoreAddress();
        Assert.assertTrue(isElementDisplayed(basicInfoPage.alertMsg));
        Assert.assertEquals(getToolTipMessage(basicInfoPage.storeFullAddress),Constants.addressNotVerifiedToolTip,"After Entering Invalid address");
    }

    @Test
    public void verifyInvalidPhoneValidation() {
        log.info("Enter Invalid Phone number in the Phone number field of the Store Basic Information page");

        Login();
        basicInfoPage.getManageBussinessAcc();
        basicInfoPage.getMyStoreBtn();
        basicInfoPage.getCustStoreConfig();
        scrollToElement(basicInfoPage.modifyBtn);
        basicInfoPage.getModifyBtn();
        waitForElementInVisible(basicInfoPage.modifyBtn,20);
        basicInfoPage.invalidInputStorePhone();
        Assert.assertTrue(isElementDisplayed(basicInfoPage.alertMsg));
        hoverOverElement(basicInfoPage.storePhoneField);
        Assert.assertEquals(getToolTipMessage(basicInfoPage.storePhoneField),Constants.invalidPhoneToolTip,"After Entering Invalid phone number");
    }

    @Test
    public void verifyStoreLogoChange() {
        log.info("Change Store logo");

        Login();
        basicInfoPage.getManageBussinessAcc();
        basicInfoPage.getMyStoreBtn();
        basicInfoPage.getCustStoreConfig();

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file']"));

      //  String userDir = System.getProperty("user.dir");
      //  String filePath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "image", "dummy-image.jpg").toString();
        // fileInput.sendKeys(filePath);

        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator+ "ImageResources"+ File.separator + "image" + File.separator + "BillDummyImg.jpg";

        fileInput.sendKeys(filePath);
        click(basicInfoPage.checkBtn);
        waitForElementInVisible(basicInfoPage.checkBtn,10);
    }

    @Test
    public void verifyStoreLogoChangeWithInvalidFile(){
        log.info("Try uploading invalid file format as store logo");

        Login();
        basicInfoPage.getManageBussinessAcc();
        basicInfoPage.getMyStoreBtn();
        basicInfoPage.getCustStoreConfig();
        basicInfoPage.invalidImageUpload();

        Assert.assertTrue(isElementDisplayed(basicInfoPage.validationMsg));
        Assert.assertEquals(getElementText(basicInfoPage.validationMsg),Constants.invalidImageFile,"Invalid Image file");

    }



}
