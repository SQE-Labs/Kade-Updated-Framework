package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.PageObjectManager;
import utils.Constants;

import java.io.File;


public class MyStorePage extends BaseTest {
    public By registerNewBusinessBtn = By.partialLinkText("Register new business");
    public By skipPopUpTitle = By.xpath("//h5[text()='Skip']");
    public By skipStripeAccountBtn = By.cssSelector(".btn-lg.fw-bold.w-100.btn.btn-outline-primary");
    public By skipStripeAccountPopUpBtn = By.xpath("//div[@class='modal-footer justify-content-around']//button[text()='Skip']");
    public By deleteStoreBtn = By.xpath("//button[text()='Delete the store']");
  public By deleteStoreIcon = By.xpath("//i[@class='fal fa-thumbs-up text-white']");
  public By alertMessage = By.cssSelector("form.link-check.checked div.alert-message");
  public By configureBtnBusinessPlanStore = By.xpath("(//h6[text()='Automation Flow Business']/../..//a)[1]");
  public By blankFieldWarningMsg = By.xpath("//p[@class='alert-content']");
  public By storeLogo = By.xpath("//div[@class='display-none -update-div-']//a");
  public By StoreNameTbx = By.xpath("//input[@name='name']");
  public By locationDescTbx = By.xpath("//input[@name='description']");
  public By storeAddressField = By.cssSelector(".form-control.pac-target-input");
  public By storeAddressOption = By.xpath("(//div[@class='pac-item'])[1]");
  public By phoneTbx = By.xpath("//input[@name='phone']");
  public By timeZoneField = By.xpath("//select[@name='timeZone']");
  public By timeZoneOption = By.xpath("//option[text()='(GMT-05:00) Eastern Time (US & Canada)']");
  public By taxRateTbx = By.xpath("//input[@name='taxRate']");
  public By saveBtn = By.xpath("//button[text()='Save']");
  public By saveVenmoPaymentBtn = By.xpath("(//div[@class='card-footer']//button)[1]");
  public By stripeBtn = By.cssSelector(".img-fluid.h-100");
  public By connectStripePopUpTitle = By.xpath("//h5[text()='Connect to stripe']");
  public By testStripeBtn = By.partialLinkText("Create a test Stripe account");
  public By bankTransferToggleBtn = By.xpath("//span[text()='Accept bank transfer']");
  public By skipForNowBtn = By.xpath("//button[text()='Skip for now']");
  public By continueBtn = By.xpath("//button[text()='Continue']");
  public By configureLink = By.xpath("(//h6[text()='Automation Flow Business']/..//../div/a)[1]");

  public By configureLink2 = By.xpath("/html/body/div[4]/div/div/main/div/div[3]/div/div/div[4]/div[1]/a");
  public By modifyBtn = By.xpath("//button[text()='Modify']");
  public By plansSubTab = By.partialLinkText("Plans");
  public By currentPlanMSg = By.xpath("//span[@class='text-success me-1']");
    public By planSignUpBtn = By.partialLinkText("Sign up");
   public By yearlyBtn = By.xpath("//label[text()='Yearly']");
   public By termsCbx = By.xpath("//span[text()='     I agree to the']");
   public By changePlanBtn = By.xpath("//button[text()='Change plan']");
   public By addedStoreName = By.cssSelector(".form-group.mb-3>h4");
   public By addedLocationDescription = By.cssSelector("div[class='display-none -readonly-div-'] span");
   public By addedStoreAddress = By.xpath("//label[text()='Store Address']/following-sibling::p");
   public By addedStorePhone = By.xpath("//label[text()='Store Phone']/following-sibling::p");
   public By addedCurrencyOfStore = By.xpath("//label[text()='Currency of the Store']/following-sibling::p");
   public By addedTaxRate = By.xpath("//label[text()='Tax rate']/following-sibling::p");
   public By addedVisaMethod = By.cssSelector("div[class='-title- d-flex flex-column'] span[class='text-nowrap']");
   public By newCreditCardBtn = By.xpath("//span[text()='New Credit Card']");
   public By newBankAccountBtn = By.xpath("//span[text()='New Bank Account']");
   public By changePayMethodBtn = By.xpath("//button[text()='change']");
   public By nextBillDate = By.xpath("(//div[@class='d-flex'])[2]");
   public By configureBtnWithoutStripe = By.xpath("(//h6[text()='Automation Flow 3']/../..//a)[1]");
   public By settingsSubTab = By.xpath("//div[text()='Settings']");
   public By maxBillAmountTbx = By.xpath("//input[@name='maxBillAmountThreshold']");
   public By tipGratuityToggleBtn = By.xpath("//span[@class='ms-2 custom-check-on'][text()='No']");
   public By tipGratuityToggleOffBtn = By.xpath("//span[@class='ms-2 custom-check-off' and text()='Yes']");
   public By tipConfigureBtn = By.xpath("//div[@class='checked-d-none']//button[@type='button'][text()='Configure']");
   public By tipConfigPopUpTitle = By.xpath("//h5[text()='Tip configuration']");
   public By tipPercentField1 = By.xpath("//input[@name='tipSelections[0].percentage']");
   public By tipPercentField2 = By.xpath("//input[@name='tipSelections[1].percentage']");
   public By tipPercentField3 = By.xpath("//input[@name='tipSelections[2].percentage']");
   public By tipFlatValueField1 = By.xpath("//input[@name='tipSelections[0].amount']");
   public By tipFlatValueField2 = By.xpath("//input[@name='tipSelections[1].amount']");
   public By tipFlatValueField3 = By.xpath("//input[@name='tipSelections[2].amount']");
   public By saveChangesBtn = By.xpath("//button[text()='Save changes']");
   public By rewardConfigureBtn = By.xpath("(//button[@type='button'][text()='Configure'])[2]");
   public By rewardConfigPopUpTitle = By.xpath("//h5[text()='Rewards Program Configuration']");
   public By rewardPointToggleBtn = By.xpath("//span[@class='ms-2 fs-6 custom-check-off']");
   public By rewardPointToggleOffBtn = By.xpath("//span[@class='ms-2 fs-6 custom-check-on']");
   public By rewardPointsField = By.xpath("//input[@name='pointsForGiftcard']");
   public By rewardPtsValue = By.xpath("//input[@name='ponitsValue']");
   public By checkBtn = By.cssSelector(".btn.btn-dark.-crop-");
   public By checkDeleteUser = By.xpath("//button[@class='btn btn-link ms-5 -yes-']");
   public By storeLinksBtn = By.xpath("//button[text()='Store links']");
   public By websiteURLField = By.xpath("//input[@name='StoreURLTypes[0].url']");
   public By earnRewardsToggleBtn = By.xpath("//label[@class='custom-checkbox fs-3'][1]");
   public By earnRewardsToggleOffBtn = By.xpath("//label[text()=' Website']/../..//i[@class='far fa-toggle-on custom-check-on ']");
   public By enterInPercentToggleBtn = By.cssSelector(".custom-checkbox.mb-2>span");
    public By paymentProcessingSubTab = By.xpath("//div[text()='Payment Processing']");
   public By acceptVenmoToggleBtn = By.xpath("(//div[@class='my-3 loaded']//label/i)[14]");
   public By enableToggle=By.xpath("(//i[@class='far fa-toggle-on custom-check-on '])[8]");
   public By acceptZelleToggleBtn = By.xpath("(//span[text()='Accept Zelle'])[1]");
   public By venmoIDField = By.xpath("//label[text()='Venmo ID']/following-sibling::input");
   public By venmoNameField = By.xpath("//label[text()='Venmo Name']/following-sibling::input");
   public By zellePhoneField = By.xpath("//input[@name='phoneemail']");
   public By zelleNameField = By.xpath("//label[text()='Name of the account in Zelle']/following-sibling::input");
    public By creditCardTerminalBtn = By.xpath("//a[text()='Credit Card Terminals']");
 public By addNewTerminalBtn = By.xpath("//button[text()='Add new terminal']");
 public By newTerminalPopUpTitle = By.xpath("//h5[text()='New Terminal']");
 public By creditCardTerminalOption = By.xpath("//label[text()='Select your terminal']/../div[4]/label/i[2]");
 public By manageUserSubTab = By.xpath("//div[text()='Manage Users']");
 public By addUserButton = By.xpath("//div[@class='card-footer']//h6");
 public By manageUserNameField = By.xpath("//div[@class='mb-2']//div[@class='input-group']//input");
 public By userProfileDropDown = By.xpath("//select[@name='profileId']");
 public By managerProfileOption = By.xpath("//option[@value='3000']");
 public By manageUserPassword = By.xpath("//input[@name='passWord']");
 public By createManagerUserButton = By.xpath("//button[@class='btn btn-primary']");
 public By addUserPopUpTitle = By.cssSelector(".modal-title");
 public By inviteExistingUserButton = By.xpath("//button[@class='position-relative btn btn-outline-primary']");
 public By inviteExistingUserPopupTitle = By.cssSelector(".modal-title");
 public By inviteMangeUserEmailOrPhoneField = By.xpath("//input[@name='email_phones']");
 public By sendInviteButton = By.xpath("//button[text()='Send Invite']");
 public By activeSubTab = By.xpath("//span[text()='Active']");
 public By deactivateBtn = By.xpath("//button[text()='Deactivate']");
 public By activateButton = By.xpath("//button[text()='Activate']");
 public By notActiveStoreLabel = By.xpath("//h4[@class='me-2 text-danger']");
 public By activeStoreLabel = By.xpath("//h4[@class='me-2 text-success']");
 public By acceptVenmoHeader = By.xpath("//form[@action='/api/Stores/SaveVenmoGatewayApplication' and @style='display: none;']");
 public By acceptZelleHeader = By.xpath("//form[@action='/api/Stores/SaveZelleGatewayApplication']");
 public  By deleteUserIcon = By.xpath("(//h5[text()='Users with access to this store']/../..//button)[2]");
    public By saveZellePaymentSettings = By.xpath("//form[@action='/api/Stores/SaveZelleGatewayApplication'] //button[text()='Save']");
    public By editStoreBtn = By.xpath("//i[@class='far fa-edit ms-2']");
    public By premiumTitle = By.xpath("//h4[text()='Premium']");
    public By premiumMonthlyBtn = By.cssSelector(".flex-fill label[for='rdo_p3_0']");
    public By premiumYearlyBtn = By.cssSelector(".flex-fill label[for='rdo_p3_1']");
    public By premiumMonthlySignUpBtn = By.cssSelector("div#div_p3_0>a");
    public By premiumYearlySignUpBtn = By.cssSelector("div#div_p3_1>a");
    public By storeLogoCreation = By.cssSelector(".d-flex.align-items-center>img");
    public By configureLinkofStoreName = By.xpath("//tr[td[contains(text(),'\" + storename + \"')]]//a[text()='Configure']");
   public By fileInput2 = By.xpath("//input[@type='file' and @accept='image/*']");
   public By configureATerminalTitle = By.cssSelector(".text-danger.mb-3");
    public By addACreditCardTerminal = By.xpath("//h4[text()='Configure a terminal']/../div//button");
    public By terminalEditIcon = By.xpath("(//div[contains(@class, 'row-cols-2')]//i)[1]");
    public By terminalDeleteBtn = By.cssSelector(".d-flex.mt-3>button:nth-child(2)");



    // Methods
    public void getTickIconofImg(){
        click(checkBtn);
    }
    public void getRegisterNewBusinessButton(){
        click(registerNewBusinessBtn);
    }

    public void getSkipStripeAccountButton(){
        click(skipStripeAccountBtn);
    }

    public void getSkipBtnOfStripe(){
        click(skipStripeAccountPopUpBtn);
    }
    public void getDeleteStoreButton(){
    click(deleteStoreBtn);
    }

    public void getDeleteStoreIcon(){
        click(deleteStoreIcon);
    }

    public void getStripeAccountBtn(){
        click(stripeBtn);
    }
    public void getTestStripeAccountButton(){
        click(testStripeBtn);
    }
    public void getEditStoreButton(){
        click(editStoreBtn);
    }
    public void getSaveButton(){
        clickElementByJS(saveBtn);
    }
    public void getBankTransferToggleButton(){
        clickElementByJS(bankTransferToggleBtn);
    }
    public void getContinueButton(){
        clickElementByJS(continueBtn);
    }
    public void getStorelogo(){
        click(storeLogo);
    }
    public void getSkipForNowButton(){
        click(skipForNowBtn);
    }
    public void getSubscriptionPlanTab(){
        click(plansSubTab);
    }
    public void getPlansSignUpButton(){
        click(planSignUpBtn);
    }
    public void getTermsCheckbox(){
        click(termsCbx);
    }
    public void getChangePlanButton(){
        click(changePlanBtn);
    }
    public void getYearlyPlanButton(){
        click(yearlyBtn);
    }
    public void getChangePayMethodLink(){
        click(changePayMethodBtn); }


    public void getStoreLinksButton() {
        clickElementByJS(storeLinksBtn);
    }
    public void getAcceptVenmoHeader(){click(acceptVenmoHeader);}

    // time zone
    public void selectTimeZone() {
        click(timeZoneField);
        click(timeZoneOption);
    }

        public void selectStoreAddress(String storeAddressName) {
            waitForElementToBeVisible(storeAddressField,10);
            cleanByJS(storeAddressField);
            pressKeys(storeAddressField, storeAddressName);
            click(storeAddressField);
            click(storeAddressOption);
        }
    public void getConfigureLink(){
        click(configureLink);
    }
    public void getModifyButton(){
        click(modifyBtn);
    }
    public void getSettingSubTab(){
        click(settingsSubTab);
    }
    public void getTipConfigureBtn(){
        click(tipConfigureBtn);
    }

    public void getTipGratuityToggleOnButton(){
        clickElementByJS(tipGratuityToggleBtn);
    }
    public void getEnterInPerCentToggleButton(){
        clickElementByJS(enterInPercentToggleBtn);
    }
    public void getSaveChangesButton(){
        clickElementByJS(saveChangesBtn);
    }
    public void getRewardConfigureButton(){
        clickElementByJS(rewardConfigureBtn);
    }
    public void getRewardPointToggleOnButton(){
        click(rewardPointToggleBtn);
    }

    public void getEarnRewardsPointsToggleButton(){
        click(earnRewardsToggleBtn);
    }
    public void getPaymentProcessingSubTab(){
        click(paymentProcessingSubTab);
    }

    public void  getAcceptVenmoToggleButton() {

        if(!isToggleEnabled(acceptVenmoToggleBtn)){
            clickElementByJS(acceptVenmoToggleBtn);
        }
        else{
            hoverAndClick(enableToggle,enableToggle);
        }

//        staticWait(6000);
//        // Check if the toggle button is disabled
//        boolean isDisabled = !isEnabled(acceptVenmoToggleBtn); // isEnabled() returns false if disabled
//
//        if (isDisabled) {
//            System.out.println("Toggle button is disabled. Enabling it now...");
//
//            // Click the toggle button using JavaScript (in case normal click doesn't work)
//           clickElementByJS(acceptVenmoToggleBtn);
//
//            // Wait for toggle effect
//            staticWait(3000);
//
//            // Verify if the toggle button is now enabled
//            if (isEnabled(acceptVenmoToggleBtn)) {
//                System.out.println("Toggle button successfully enabled!");
//            } else {
//                System.out.println("Failed to enable the toggle button.");
//            }
//        } else {
//            System.out.println("Toggle button is already enabled.");
//        }

    }
    public void getAcceptZelleToggleButton() {
        waitForElementToBeVisible(acceptZelleToggleBtn,2);
        hoverAndClick(acceptZelleToggleBtn,acceptZelleToggleBtn);
    }
    public void getVenmoSaveButton(){
        click(saveVenmoPaymentBtn);
    }
    public void getAcceptZelleHeader(){
        click(acceptZelleHeader);
    }
    public void getZelleSaveButton(){
        click(saveZellePaymentSettings);
    }
    public void getAddaTerminalLink(){
        clickElementByJS(addACreditCardTerminal);
    }
    public void getCreditCardTerminalButton(){
        click(creditCardTerminalBtn);
    }
    public void getAddNewTerminalButton(){
        scrollToElement(addNewTerminalBtn);
        clickElementByJS(addNewTerminalBtn);
    }
    public void getCreditTerminalOption(){
        scrollToElement(creditCardTerminalOption);
//        waitForElementToBeClickable(creditCardTerminalOption,5);
        clickElementByJS(creditCardTerminalOption);
        waitForElementToBeClickable(saveBtn,6);
        getSaveButton();

        staticWait(5000);
        getTerminalEditIcon();
        scrollToElement(terminalDeleteBtn);
        getDeleteTerminalBtn();
    }

    public void getTerminalEditIcon(){
        click(terminalEditIcon);
    }

    public void getDeleteTerminalBtn(){
        scrollToElement(terminalDeleteBtn);
        click(terminalDeleteBtn);
    }
    public void getManageUserSubTab(){
        click(manageUserSubTab);
    }
    public void getAddUserBtn(){
        click(addUserButton);
    }
    public void getUserProfileDropdown(){
        click(userProfileDropDown);
    }


    public  String storeNamewithstripe;


//*****************************
    public void getStoreCreation(){
         storeNamewithstripe = "AutoStore" + requiredDigits(4);
         String phone = requiredDigits(10);

        //Step 1: Click on 'My Stores' Tab
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Register New Business' Button
         getRegisterNewBusinessButton();
        if (isElementDisplayed(storeLogoCreation)) {
            getEditStoreButton();
            scrollToElement(deleteStoreBtn);
            waitForElementToBeClickable(deleteStoreBtn,5);
            // click on delete button
          getDeleteStoreButton();
          getDeleteStoreIcon();
          staticWait(3000);

            scrollToElement(pageObjectManager.getSidePannel().manageBusinessAcc);
            pageObjectManager.getSidePannel().getMangeBusinessTab();
            waitForElementToBeClickable(pageObjectManager.getSidePannel().myStoreBtn,3);
            pageObjectManager.getSidePannel().getMyStoreTab();
            getRegisterNewBusinessButton();
        }
        // Click on 'Stripe Account' Button
          getStripeAccountBtn();
          scrollToElement(testStripeBtn);
        //Click on 'Test Stripe Account' Button
         getTestStripeAccountButton();

        //Edit Store name
         getEditStoreButton();

        enterText(StoreNameTbx, storeNamewithstripe);
        actionEnterText(phoneTbx, phone);
        staticWait(3000);
        scrollToElement(saveBtn);
        waitForElementToBeVisible(saveBtn,5);
        getSaveButton();
        waitForElementToBeVisible(bankTransferToggleBtn,10);
        scrollToElement(bankTransferToggleBtn);

        // Click on 'Bank Transfer' toggle button
        getBankTransferToggleButton();
        getContinueButton();

        // Click on 'Skip For Now' Button
        getSkipForNowButton();
        getContinueButton();
        //verifying the default Values of the Store
        String storenameactual = getText(addedStoreName);
        String locationDescription = getText(addedLocationDescription);
        String storeAddress = getText(addedStoreAddress);
        String storePhoneno = getText(addedStorePhone).replaceAll("[+()\\s-]", "").substring(1, 11), phoneNumber;
        String Currency = getText(addedCurrencyOfStore);
        String Taxrate = getText(addedTaxRate);

      Assert.assertEquals(storenameactual,storeNamewithstripe);
      Assert.assertEquals(locationDescription, Constants.defaultLocationDescription);
      Assert.assertEquals(storeAddress, Constants.storeAddress);
      Assert.assertEquals(storePhoneno, phone);
      Assert.assertEquals(Currency, Constants.defaultCurrency);
      Assert.assertEquals(Taxrate, Constants.defaultTaxRate);

      staticWait(3000);

    }
// *************************************************************************************

    public void getStoreCreationWithoutStripePayment() {
       String  storeName = "AutoStore" + requiredDigits(4);
        String phone = requiredDigits(10);

        // Click on 'Register New Business' Button
        getRegisterNewBusinessButton();

        if (isElementDisplayed(storeLogo)) {
            scrollToElement(deleteStoreBtn);
            waitForElementToBeClickable(deleteStoreBtn, 5);
            // click on delete button
            getDeleteStoreButton();
            getDeleteStoreIcon();
            staticWait(3000);

            scrollToElement(pageObjectManager.getSidePannel().manageBusinessAcc);
            pageObjectManager.getSidePannel().getMangeBusinessTab();
            waitForElementToBeClickable(pageObjectManager.getSidePannel().myStoreBtn, 3);
            pageObjectManager.getSidePannel().getMyStoreTab();
            getRegisterNewBusinessButton();
        }
        waitForElementToBeClickable(skipStripeAccountBtn,4);
        getSkipStripeAccountButton();
        staticWait(3000);
//        waitForElementToBeClickable(skipStripeAccountPopUpBtn,5);
        getSkipBtnOfStripe();
        scrollToElement(saveBtn);
        waitForElementToBeClickable(saveBtn,3);
        getSaveButton();
        waitForElementToBeVisible(blankFieldWarningMsg,10);

        //Verify the validation message
        String pleaseReviewMsg=getText(blankFieldWarningMsg);
        Assert.assertEquals(pleaseReviewMsg,Constants.pleaseReviewValidation);

        // uploding store image

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file' and @accept='image/*']"));

        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator+ "ImageResources"+ File.separator + "image" + File.separator + "BillDummyImg.jpg";
        fileInput.sendKeys(filePath);
        getTickIconofImg();

        staticWait(3000);

        //Verifying maximum length of 'Store Name' field
        Assert.assertEquals(getAttribute(StoreNameTbx,"maxlength"),"100");

        // Enter Store Name
        enterText(StoreNameTbx,storeName);
        enterText(locationDescTbx,Constants.defaultLocationDescription);
        selectStoreAddress(Constants.storeAddress);

        //Verifying the maximum length of 'Phone' field
        softAssert.assertEquals(getAttribute(phoneTbx,"maxlength"),"22");
        actionEnterText(phoneTbx,Constants.validPhoneNumber);

        // Select Time Zone

        //Verifying the minimum, maximum and default values of taxRate field
       softAssert.assertEquals(getAttribute(taxRateTbx,"min"),"0");
       softAssert.assertEquals(getAttribute(taxRateTbx,"value"),"0.000");
       softAssert.assertEquals(getAttribute(taxRateTbx,"max"),"100");

       //  Enter Tax rate
        actionEnterText(taxRateTbx,Constants.taxRate);
        scrollToElement(saveBtn);
        staticWait(3000);
        getSaveButton();
        waitForElementToBeVisible(continueBtn,10);
        getContinueButton();
        waitForPageLoad();
        //  //Verify Created Store
        softAssert.assertEquals(getText(addedStoreName),storeName);
        softAssert.assertAll();

        pageObjectManager.getSidePannel().getSignOut();
        pageObjectManager.getAdminPage().selectedStoreDeleted(storeName);
    }
   // **********************************************************
    public void editStoreFields(){
        // uploding store image

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file' and @accept='image/*']"));

        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator+ "ImageResources"+ File.separator + "image" + File.separator + "BillDummyImg.jpg";
        fileInput.sendKeys(filePath);
        getTickIconofImg();

        staticWait(3000);

        //Verifying maximum length of 'Store Name' field
        Assert.assertEquals(getAttribute(StoreNameTbx,"maxlength"),"100");
        waitForElementToBeClickable(StoreNameTbx,5);

        // Enter Store Name
        enterText(StoreNameTbx,Constants.editdefaultStoreName);
        enterText(locationDescTbx,Constants.defaultLocationDescription);
        selectStoreAddress(Constants.storeAddress);

        //Verifying the maximum length of 'Phone' field
        softAssert.assertEquals(getAttribute(phoneTbx,"maxlength"),"22");
        actionEnterText(phoneTbx,Constants.validPhoneNumber);

        // Select Time Zone

        //Verifying the minimum, maximum and default values of taxRate field
        softAssert.assertEquals(getAttribute(taxRateTbx,"min"),"0");
        softAssert.assertEquals(getAttribute(taxRateTbx,"value"),"0.000","Tax rate tbx value");
        softAssert.assertEquals(getAttribute(taxRateTbx,"max"),"100");

        //  Enter Tax rate
        actionEnterText(taxRateTbx,Constants.taxRate);
        scrollToElement(saveBtn);
        staticWait(3000);
        getSaveButton();


        ////Reset Store to default
        getModifyButton();

        // Enter Store Name
        enterText(StoreNameTbx,Constants.reverseStoreName);
        enterText(locationDescTbx,Constants.defaultLocationDescription);
        actionEnterText(phoneTbx,Constants.validPhoneNumber2);
        actionEnterText(taxRateTbx,Constants.defaultTaxRate);
        waitForElementToBeClickable(saveBtn,3);
        getSaveButton();
        softAssert.assertAll();


    }
    public void getActivateSubtab(){
        click(activeSubTab);
    }
    public void getActiveButton(){
        click(activateButton);
    }
    public void getDeactivateBtn(){
        click(deactivateBtn);
    }
    public void getPremiumMonthlyBtn(){
        click(premiumMonthlyBtn);
    }
    public void getPremiumYearlyBtn(){
    click(premiumYearlyBtn);
    }
    public void getPremiumnMonthlySignUpBtn(){
        click(premiumMonthlySignUpBtn);
    }
    public void getBusinessYearlyPlan(){
        click(yearlyBtn);
    }

    public void getPremiunmYearlySignUpbtn(){
        click(premiumYearlySignUpBtn);
    }


}
