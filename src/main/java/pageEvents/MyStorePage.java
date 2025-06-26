package pageEvents;

import base.BaseTest;
import logger.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Constants;

import java.io.File;

import static java.lang.Float.parseFloat;
import static utils.Constants.requiredFldValidation;
import static utils.Constants.validPassword;


public class MyStorePage extends BaseTest {
    private static final Logger log = LogManager.getLogger(MyStorePage.class);

    By registerNewBusinessBtn = By.partialLinkText("Register new business");
    public By skipPopUpTitle = By.xpath("//h5[text()='Skip']");
    public By skipStripeAccountBtn = By.xpath("//button[contains(text(), 'Skip')]");
    public By skipStripeAccountPopUpBtn = By.xpath("//button[text()='Skip']");
    public By deleteStoreBtn = By.xpath("//button[text()='Delete the store']");
    By deleteStoreIcon = By.xpath("//i[@class='fal fa-thumbs-up text-white']");
    public By alertMessage = By.cssSelector("form.link-check.checked div.alert-message");
    public By configureBtnBusinessPlanStore = By.xpath("(//h6[text()='Automation Flow Business']/../..//a)[1]");
    public By blankFieldWarningMsg = By.xpath("//p[@class='alert-content']");
    public By storeLogo = By.xpath("//div[@class='display-none -update-div-']//a");
    By editIcon = By.xpath("//div[text()='Avenue']/button");
    By editStore = By.xpath("//button[@class='btn ']");
    public By StoreNameTbx = By.xpath("//input[@name='name']");
    public By locationDescTbx = By.xpath("//input[@name='description']");
    public By storeAddressField = By.cssSelector(".form-control.pac-target-input");
    public By storeAddressOption = By.xpath("(//div[@class='pac-item'])[1]");
    public By phoneTbx = By.xpath("//input[@name='phone']");
    By address = By.xpath("//input[@name='fulladdress']");
    By locationField = By.xpath("//input[@Name='description']");
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
    public By configureLink = By.xpath("(//h6[starts-with(text(),'Automation Flow Business')]/../../div/a)[1]");

    public By modifyBtn = By.xpath("//button[text()='Modify']");
    public By plansSubTab = By.partialLinkText("Plans");
    public By currentPlanMSg = By.xpath("//span[@class='text-success me-1']");
    public By configureLink2 = By.xpath("(//h6[starts-with(text(),'Automation flow 2')]/../../div/a)[1]");

    public By planSignUpBtn = By.partialLinkText("Sign up");
    public By yearlyBtn = By.xpath("//label[text()='Yearly']");
    public By termsCbx = By.xpath("//span[text()='     I agree to the']");
    public By changePlanBtn = By.xpath("//button[text()='Change plan']");
    public By addedStoreName = By.xpath("(//div[contains (@class, 'form-group mb-3')]//label//following-sibling::div)[1]");
    public By addedLocationDescription = By.cssSelector("div[class='display-none -readonly-div-'] span");
    public By addedStoreAddress = By.xpath("//label[text()='Store Address']/following-sibling::p");
    public By addedStorePhone = By.xpath("//label[text()='Store Phone']/following-sibling::p");
    public By addedCurrencyOfStore = By.xpath("//label[text()='Currency of the Store']/following-sibling::p");
    public By addedTaxRate = By.xpath("//label[text()='Tax rate']/following-sibling::p");
    public By addedVisaMethod = By.xpath("(//span[contains(text(), 'Visa 1111')])[1]");
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
    public By acceptVenmoToggleBtn = By.xpath("(//span[text()='Accept Venmo']/../i)[2]");
    public By enableToggle = By.xpath("(//i[@class='far fa-toggle-on custom-check-on '])[8]");
    public By acceptZelleToggleBtn = By.xpath("(//span[text()='Accept Zelle'])[1]");
    public By venmoIDField = By.xpath("//label[text()='Venmo ID']/following-sibling::input");
    public By venmoNameField = By.xpath("//label[text()='Venmo Name']/following-sibling::input");
    public By zellePhoneField = By.xpath("//input[@name='phoneemail']");
    public By zelleNameField = By.xpath("//label[text()='Name of the account in Zelle']/following-sibling::input");
    public By creditCardTerminalBtn = By.xpath("//a[text()='Credit Card Terminals']");
    public By addNewTerminalBtn = By.xpath("//button[text()='Add new terminal']");
    public By newTerminalPopUpTitle = By.xpath("//h5[text()='New Terminal']");
    public By creditCardTerminalOption = By.xpath("//label[text()='Select your terminal']/../div[4]/label/i[2]");
    public By manageUserSubTab = By.xpath("//div[text()='Manage Users']/../..");
    public By addUserButton = By.xpath("//div[@class='card-footer']//h6");
    public By manageUserNameField = By.xpath("//div[@class='mb-2']//div[@class='input-group']//input");
    public By userProfileDropDown = By.xpath("//select[@name='profileId']");
    public By managerProfileOption = By.xpath("//option[@value='3000']");
    public By readerProfileOption = By.xpath("//option[@value='1000']");
    public By operatorProfileOption = By.xpath("//option[@value='2000']");
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
    public By deleteUserIcon = By.xpath("(//h5[text()='Users with access to this store']/../..//button)[2]");
    public By saveZellePaymentSettings = By.xpath("(//button[text()='Save'])[3]");
    public By editStoreBtn = By.xpath("//i[@class='far fa-edit ms-2']");
    public By premiumTitle = By.xpath("//h4[text()='Premium']");
    public By premiumMonthlyBtn = By.cssSelector(".flex-fill label[for='rdo_p3_0']");
    public By premiumYearlyBtn = By.cssSelector(".flex-fill label[for='rdo_p3_1']");
    public By premiumMonthlySignUpBtn = By.cssSelector("div#div_p3_0>a");
    public By premiumYearlySignUpBtn = By.cssSelector("div#div_p3_1>a");
    public By storeLogoCreation = By.xpath("(//div[text()='Click on the logo to replace'])[2]/..");
    public By configureLinkofStoreName = By.xpath("//tr[td[contains(text(),'\" + storename + \"')]]//a[text()='Configure']");
    public By fileInput2 = By.xpath("//input[@type='file' and @accept='image/*']");
    public By configureATerminalTitle = By.xpath("//h4[contains(text(),'Configure a terminal')]");
    public By addACreditCardTerminal = By.xpath("//h4[text()='Configure a terminal']/../div//button");
    public By terminalEditIcon = By.xpath("(//div[contains(@class, 'row-cols-2')]//i)[1]");
    public By terminalDeleteBtn = By.cssSelector(".d-flex.mt-3>button:nth-child(2)");
    By venmoIDLabel = By.xpath("//label[text()='Venmo ID']");
    public By bankAccountOptionForPlan = By.xpath("//span[contains(text(),'Bank Account 6789')]/..");
    public By createUserAndCredetButton = By.xpath("//div[@class='mb-1 text-center']/..");
    public By inviteUserButton = By.xpath("//span[text()='Recommended']/..");
    By validationCrossIcon = By.cssSelector(".btn-close.autoclick-effect");
    public By store = By.cssSelector(".d-flex.flex-column>h3");
    public By storeNameCompare = By.xpath("(//img[contains(@class,'profile-image-sm')]/../div/span)[1]");
    By avenue = By.xpath("//div[text()='Avenue']");
    By editIConAvenue = By.xpath("//div[text()='Avenue']/button/i");

    public void getValidationCrossIcon() {
        waitForElementToBeClickable(validationCrossIcon, 5);
        click(validationCrossIcon);
    }

    // Methods
    public void getTickIconofImg() {
        click(checkBtn);
    }

    public String getStoreName() {
        return getText(store);
    }

    public void getRegisterNewBusinessButton() {
        click(registerNewBusinessBtn);
    }

    public void getSkipStripeAccountButton() {
        click(skipStripeAccountBtn);
    }

    public void getSkipBtnOfStripe() {
        waitForElementToBeClickable(skipStripeAccountPopUpBtn, 10);
        hoverAndClick(skipStripeAccountPopUpBtn, skipStripeAccountPopUpBtn);
    }

    public void getDeleteStoreButton() {
        click(deleteStoreBtn);
    }

    public void getDeleteStoreIcon() {
        click(deleteStoreIcon);
    }

    public void getStripeAccountBtn() {
        staticWait(2000);
        click(stripeBtn);

    }

    public void getTestStripeAccountButton() {
        staticWait(2000);
        click(testStripeBtn);
    }

    public void getEditStoreButton() {
        click(editStoreBtn);
    }

    public void getSaveButton() {
        clickElementByJS(saveBtn);
    }

    public void getBankTransferToggleButton() {
        staticWait(2000);
        clickElementByJS(bankTransferToggleBtn);
    }

    public void getContinueButton() {
        clickElementByJS(continueBtn);
    }

    public void getStorelogo() {
        click(storeLogo);
    }

    public void getSkipForNowButton() {
        click(skipForNowBtn);
    }

    public void getSubscriptionPlanTab() {
        click(plansSubTab);
    }

    public void getPlansSignUpButton() {
        click(planSignUpBtn);
    }

    public void getTermsCheckbox() {
        click(termsCbx);
    }

    public void getChangePlanButton() {
        click(changePlanBtn);
    }

    public void getYearlyPlanButton() {
        click(yearlyBtn);
    }

    public void getChangePayMethodLink() {
        click(changePayMethodBtn);
    }

    public void getcreateUserAndCredetButton() {
        staticWait(2000);
        scrollToElement(createUserAndCredetButton);
        click(createUserAndCredetButton);
    }

    public void getmanagerProfileOption() {
        click(managerProfileOption);
    }

    public void getReaderProfileOption() {
        click(readerProfileOption);
    }

    public void getOperatorProfileOption() {
        click(operatorProfileOption);
    }

    public void getcreateManagerUserButton() {
        click(createManagerUserButton);
    }

    public void getdeleteUserIcon() {
        click(deleteUserIcon);
    }

    public void getCheckIconOfDeleteUser() {
        click(checkDeleteUser);
    }

    public void getinviteUserButton() {
        scrollToElement(inviteUserButton);
        staticWait(2000);
        click(inviteUserButton);
    }


    public void getStoreLinksButton() {
        clickElementByJS(storeLinksBtn);
    }

    public void getAcceptVenmoHeader() {
        click(acceptVenmoHeader);
    }

    public void getbankAccountOptionForPlan() {
        click(bankAccountOptionForPlan);
    }

    // time zone
    public void selectTimeZone() {
        click(timeZoneField);
        click(timeZoneOption);
    }

    public void selectStoreAddress(String storeAddressName) {
        waitForElementToBeVisible(storeAddressField, 10);
        cleanByJS(storeAddressField);
        pressKeys(storeAddressField, storeAddressName);
        click(storeAddressField);
        staticWait(2000);
        click(storeAddressOption);
    }

    public void getConfigureLink() {
        click(configureLink);
    }

    public void getModifyButton() {
        click(modifyBtn);
    }

    public void getSettingSubTab() {
        click(settingsSubTab);
    }

    public void getTipConfigureBtn() {
        click(tipConfigureBtn);
    }

    public void getTipGratuityToggleOnButton() {
        clickElementByJS(tipGratuityToggleBtn);
    }

    public void getEnterInPerCentToggleButton() {
        clickElementByJS(enterInPercentToggleBtn);
    }

    public void getSaveChangesButton() {
        clickElementByJS(saveChangesBtn);
    }

    public void getRewardConfigureButton() {
        clickElementByJS(rewardConfigureBtn);
    }

    public void getRewardPointToggleOnButton() {
        click(rewardPointToggleBtn);
    }

    public void sendInviteButton() {
        click(sendInviteButton);
    }

    public void getEarnRewardsPointsToggleButton() {
        click(earnRewardsToggleBtn);
    }

    public void getPaymentProcessingSubTab() {
        click(paymentProcessingSubTab);
    }

    public void getAcceptVenmoToggleButton() {

        if (!isDisplayed(venmoIDLabel, 2)) {
            clickElementByJS(acceptVenmoToggleBtn);
        } else {
            Log.info("Toggle button is already On");
        }
//        else{
//            hoverAndClick(enableToggle,enableToggle);
//        }

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
        waitForElementToBeVisible(acceptZelleToggleBtn, 2);
        hoverAndClick(acceptZelleToggleBtn, acceptZelleToggleBtn);
    }

    public void getVenmoSaveButton() {
        click(saveVenmoPaymentBtn);
    }

    public void getZelleSaveButton() {
        staticWait(2000);
        scrollToElement(saveZellePaymentSettings);
        click(saveZellePaymentSettings);
    }

    public void getAddaTerminalLink() {
        clickElementByJS(addACreditCardTerminal);
    }

    public void getCreditCardTerminalButton() {
        click(creditCardTerminalBtn);
    }

    public void getAddNewTerminalButton() {
        scrollToElement(addNewTerminalBtn);
        clickElementByJS(addNewTerminalBtn);
    }

    public void getCreditTerminalOption() {
        scrollToElement(creditCardTerminalOption);
        staticWait(3000);
//        waitForElementToBeClickable(creditCardTerminalOption,5);
        clickElementByJS(creditCardTerminalOption);
        waitForElementToBeClickable(saveBtn, 6);
        getSaveButton();

        staticWait(5000);
        getTerminalEditIcon();
        scrollToElement(terminalDeleteBtn);
        getDeleteTerminalBtn();
    }

    public void getTerminalEditIcon() {
        staticWait(3000);
        click(terminalEditIcon);
    }

    public void getDeleteTerminalBtn() {
        scrollToElement(terminalDeleteBtn);
        click(terminalDeleteBtn);
    }

    public void getManageUserSubTab() {
        click(manageUserSubTab);
    }

    public void getAddUserBtn() {
        click(addUserButton);
    }

    public void getUserProfileDropdown() {
        click(userProfileDropDown);
    }


    public String storeNamewithstripe;


    //*****************************
    public void getStoreCreation(String location, String addressField) {
        storeNamewithstripe = "AutoStore" + requiredDigits(4);
        String phone = requiredDigits(10);

        //Step 1: Click on 'My Stores' Tab
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Register New Business' Button
        getRegisterNewBusinessButton();
        if (isElementDisplayed(editStore)) {
            staticWait(4000);
            click(editStore);
        } else {
            Log.info("Edit icon not appears");
        }
        if (isElementDisplayed(storeLogoCreation)) {
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
        // Click on 'Stripe Account' Button
        getStripeAccountBtn();
        scrollToElement(testStripeBtn);
        //Click on 'Test Stripe Account' Button
        getTestStripeAccountButton();

        //Edit Store name
        getEditStoreButton();

        enterText(StoreNameTbx, storeNamewithstripe);
        getDriver().findElement(By.xpath("//input[@Name='description']")).clear();
        actionEnterText(locationField, location);
        getDriver().findElement(By.xpath("//input[@name='fulladdress']")).clear();
        actionEnterText(address, addressField);
        actionEnterText(phoneTbx, phone);
        staticWait(3000);
        scrollToElement(saveBtn);
        waitForElementToBeVisible(saveBtn, 5);
        getSaveButton();

        scrollToElement(bankTransferToggleBtn);
        waitForElementToBeVisible(bankTransferToggleBtn, 10);

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

        Assert.assertEquals(storenameactual, storeNamewithstripe);
        Assert.assertEquals(locationDescription, Constants.defaultLocationDescription);
        Assert.assertEquals(storeAddress, Constants.storeAddress);
        Assert.assertEquals(storePhoneno, phone);
        Assert.assertEquals(Currency, Constants.defaultCurrency);
        Assert.assertEquals(Taxrate, Constants.defaultTaxRate);

        staticWait(3000);

    }
// *************************************************************************************

    public void getStoreCreationWithoutStripePayment() {
        String storeName = "AutoStore" + requiredDigits(4);
        String phone = requiredDigits(10);

        // Click on 'Register New Business' Button
        getRegisterNewBusinessButton();

        if (isElementDisplayed(editIcon)) {
            staticWait(4000);
            click(editIcon);
        } else {
            Log.info("Edit icon not appears");
        }
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
        waitForElementToBeClickable(skipStripeAccountBtn, 4);
        getSkipStripeAccountButton();
        staticWait(3000);
//        waitForElementToBeClickable(skipStripeAccountPopUpBtn,5);
        getSkipBtnOfStripe();
        staticWait(3000);
        scrollToElement(saveBtn);
        waitForElementToBeClickable(saveBtn, 3);
        getSaveButton();
        waitForElementToBeVisible(blankFieldWarningMsg, 10);

        //Verify the validation message
        String pleaseReviewMsg = getText(blankFieldWarningMsg);
        Assert.assertEquals(pleaseReviewMsg, Constants.pleaseReviewValidation);

        // uploding store image

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file' and @accept='image/*']"));

        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ImageResources" + File.separator + "image" + File.separator + "BillDummyImg.jpg";
        fileInput.sendKeys(filePath);
        getTickIconofImg();

        staticWait(3000);

        //Verifying maximum length of 'Store Name' field
        Assert.assertEquals(getAttribute(StoreNameTbx, "maxlength"), "100");

        // Enter Store Name
        enterText(StoreNameTbx, storeName);
        enterText(locationDescTbx, Constants.defaultLocationDescription);
        selectStoreAddress(Constants.storeAddress);

        //Verifying the maximum length of 'Phone' field
        softAssert.assertEquals(getAttribute(phoneTbx, "maxlength"), "22");
        actionEnterText(phoneTbx, Constants.validPhoneNumber);

        // Select Time Zone

        //Verifying the minimum, maximum and default values of taxRate field
        Assert.assertEquals(getAttribute(taxRateTbx, "min"), "0");
        Assert.assertEquals(getAttribute(taxRateTbx, "value"), "0.000");
        Assert.assertEquals(getAttribute(taxRateTbx, "max"), "100");

        //  Enter Tax rate
        actionEnterText(taxRateTbx, Constants.taxRate);
        scrollToElement(saveBtn);
        staticWait(3000);
        getSaveButton();
        waitForElementToBeVisible(continueBtn, 10);
        getContinueButton();
        waitForPageLoad();

        //  //Verify Created Store
        softAssert.assertEquals(getText(addedStoreName), storeName);


        pageObjectManager.getSidePannel().getSignOut();
        pageObjectManager.getAdminPage().selectedStoreDeleted(storeName);

    }

    // **********************************************************
    public void editStoreFields() {
        // uploding store image

        WebElement fileInput = getDriver().findElement(By.xpath("//input[@type='file' and @accept='image/*']"));

        // Set the file path to upload
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "ImageResources" + File.separator + "image" + File.separator + "BillDummyImg.jpg";
        fileInput.sendKeys(filePath);
        getTickIconofImg();

        staticWait(3000);

        //Verifying maximum length of 'Store Name' field
        Assert.assertEquals(getAttribute(StoreNameTbx, "maxlength"), "100");
        waitForElementToBeClickable(StoreNameTbx, 8);

        // Enter Store Name
        getDriver().findElement(By.xpath("//input[@name='name']")).clear();
        actionEnterText(StoreNameTbx, Constants.editdefaultStoreName);
        getDriver().findElement(By.xpath("//input[@name='description']")).clear();
        actionEnterText(locationDescTbx, Constants.defaultLocationDescription);

        selectStoreAddress(Constants.storeAddress);

        //Verifying the maximum length of 'Phone' field
        Assert.assertEquals(getAttribute(phoneTbx, "maxlength"), "16"); // Phone number field accept now max 16 characters only
        actionEnterText(phoneTbx, Constants.validPhoneNumber);

        // Select Time Zone

        //Verifying the minimum, maximum and default values of taxRate field
        scrollToElement(taxRateTbx);
        Assert.assertEquals(getAttribute(taxRateTbx, "min"), "0");
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(taxRateTbx));
        Assert.assertEquals(getAttribute(taxRateTbx, "max"), "100");

        //  Enter Tax rate
        actionEnterText(taxRateTbx, Constants.taxRate);
        scrollToElement(saveBtn);
        staticWait(3000);
        getSaveButton();

        //Reset Store to default
        getModifyButton();

        // Enter Store Name
        enterText(StoreNameTbx, Constants.reverseStoreName);
        enterText(locationDescTbx, Constants.defaultLocationDescription);
        actionEnterText(phoneTbx, Constants.validPhoneNumber2);
        scrollToElement(taxRateTbx);
        waitForElementToBeClickable(taxRateTbx, 4);
        actionEnterText(taxRateTbx, Constants.enterTaxRate);
        waitForElementToBeClickable(saveBtn, 5);
        getSaveButton();

    }

    public void getActivateSubtab() {
        click(activeSubTab);
    }

    public void getActiveButton() {
        click(activateButton);
    }

    public void getDeactivateBtn() {
        click(deactivateBtn);
    }

    public void getPremiumMonthlyBtn() {
        click(premiumMonthlyBtn);
    }

    public void getPremiumYearlyBtn() {
        click(premiumYearlyBtn);
    }

    public void getPremiumnMonthlySignUpBtn() {
        click(premiumMonthlySignUpBtn);
    }

    public void getBusinessYearlyPlan() {
        click(yearlyBtn);
    }

    public void getPremiunmYearlySignUpbtn() {
        click(premiumYearlySignUpBtn);
    }

    public void createManagerUser() {
        // Clicking on add new user button
        getcreateUserAndCredetButton();
        waitForElementToBeVisible(addUserPopUpTitle, 4);

        // verify the add user popup
        Assert.assertEquals(getText(addUserPopUpTitle), "Add User");

        // Enter UserName in 'Username' field
        enterText(manageUserNameField, "My store user" + requiredString(4));

        //Verifying the Maximum length of 'Username' field.
        Assert.assertEquals(getAttribute(manageUserNameField, "maxlength"), "30");

        //  Click on the 'User Profile' Drop Down
        getUserProfileDropdown();

        // Select profile of 'Manager' User
        getmanagerProfileOption();

        // Enter password in 'Password' field
        enterText(manageUserPassword, validPassword);

        //Verifying the Maximum length of 'Password' field
        Assert.assertEquals(getAttribute(manageUserPassword, "maxlength"), "18");

        // Click on 'Create User' Button
        getcreateManagerUserButton();
        staticWait(3000);

        // wait for deleting the user
        getdeleteUserIcon();
        getCheckIconOfDeleteUser();

        staticWait(4000);

    }

    public void creatingReaderProfile() {
        // Clicking on add new user button
        getcreateUserAndCredetButton();
        waitForElementToBeVisible(addUserPopUpTitle, 4);

        // verify the add user popup
        softAssert.assertEquals(getText(addUserPopUpTitle), "Add User");

        // Enter UserName in 'Username' field
        enterText(manageUserNameField, "My store user" + requiredString(4));

        //Verifying the Maximum length of 'Username' field.
        softAssert.assertEquals(getAttribute(manageUserNameField, "maxlength"), "30");

        //  Click on the 'User Profile' Drop Down
        getUserProfileDropdown();

        // Select profile of 'Reader' User
        getReaderProfileOption();

        // Enter password in 'Password' field
        enterText(manageUserPassword, validPassword);

        //Verifying the Maximum length of 'Password' field
        softAssert.assertEquals(getAttribute(manageUserPassword, "maxlength"), "18");

        // Click on 'Create User' Button
        getcreateManagerUserButton();
        staticWait(3000);

        // wait for deleting the user
        getdeleteUserIcon();
        getCheckIconOfDeleteUser();
        staticWait(4000);
        softAssert.assertAll();
    }

    public void creatingOperatorUser() {
        // Clicking on add new user button
        getcreateUserAndCredetButton();
        waitForElementToBeVisible(addUserPopUpTitle, 4);

        // verify the add user popup
        softAssert.assertEquals(getText(addUserPopUpTitle), "Add User");

        // Enter UserName in 'Username' field
        enterText(manageUserNameField, "My store user" + requiredString(4));

        //Verifying the Maximum length of 'Username' field.
        softAssert.assertEquals(getAttribute(manageUserNameField, "maxlength"), "30");

        //  Click on the 'User Profile' Drop Down
        getUserProfileDropdown();

        // Select profile of 'Manager' User
        getOperatorProfileOption();

        // Enter password in 'Password' field
        enterText(manageUserPassword, validPassword);

        //Verifying the Maximum length of 'Password' field
        softAssert.assertEquals(getAttribute(manageUserPassword, "maxlength"), "18");

        // Click on 'Create User' Button
        getcreateManagerUserButton();
        staticWait(3000);

        // wait for deleting the user
        getdeleteUserIcon();
        getCheckIconOfDeleteUser();
        softAssert.assertAll();

    }

    public void verifyConfigOfStoreUsingProcessPayment() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();
        waitForElementToBeClickable(configureLink, 3);

        // Click on 'Configure' Link
        getConfigureLink();

        waitForElementToBeVisible(paymentProcessingSubTab, 5);

        // Click on 'Payment-Processing' Sub-Tab
        getPaymentProcessingSubTab();
        staticWait(3000);
        scrollToDown();
        staticWait(3000);

        getAcceptVenmoToggleButton();

        staticWait(5000);

        //Verifying Maximum length of 'VenmoID' field

        Assert.assertEquals(getAttribute(venmoIDField, "maxlength"), "40");

        // Enter ID in 'Venmo ID" field
        enterText(venmoIDField, requiredDigits(4));

        //Verifying maximum length of 'Venmo Name' field
        Assert.assertEquals(getAttribute(venmoNameField, "maxlength"), "40");

        // Enter name in 'Venmo Name' Field
        enterText(venmoNameField, requiredString(8));

        // Click on 'Save' Button
        getVenmoSaveButton();
        scrollToElement(acceptZelleHeader);
        staticWait(3000);

        if (!isToggleEnabled(acceptZelleToggleBtn)) {
            clickElementByJS(acceptZelleToggleBtn);
        } else {
            Log.info("Toggle button is already On");
        }

        //Verifying maximum length of 'Zelle Phone' field
        Assert.assertEquals(getAttribute(zellePhoneField, "maxlength"), "40");

        //  Enter Phone Number in 'Zelle Phone' Field
        enterText(zellePhoneField, requiredDigits(4));

        // Verifying maximum length of 'Zelle Name' field
        Assert.assertEquals(getAttribute(zelleNameField, "maxlength"), "40");

        // Enter Zelle Account Name
        enterText(zelleNameField, requiredString(8));

        // Click on 'Save' Button
        getZelleSaveButton();
    }


    public void c2verifyBuyingMonthlyBusinessPlanForAlreadyCreatedStore(String location, String Address) {
        Login();
        getStoreCreation(location, Address);
        getSubscriptionPlanTab();
        //Verifying that 'Current Plan' appears under Essential Free Plan
        String message = getText(currentPlanMSg);
        softAssert.assertEquals(message, Constants.currentPlan);

        //Click on 'Sign up' button
        getPlansSignUpButton();

        //Verifying that by-default Visa Payment method is enabled
        String defaultPaymentMthd = getText(addedVisaMethod);
        System.out.println(defaultPaymentMthd);
        softAssert.assertEquals(defaultPaymentMthd, Constants.visavalue);

//       Click on 'Change Pay Method' Link
        getChangePayMethodLink();//Verifying that other payment methods are available
        softAssert.assertTrue(isElementDisplayed(newCreditCardBtn), " New credit card button");
        softAssert.assertTrue(isElementDisplayed(newBankAccountBtn), "new bank account");

        // Click on 'Terms' Checkbox
        getTermsCheckbox();
        scrollToElement(changePlanBtn);

        //  Click on 'Change Plan' Button
        getChangePlanButton();

        //Verifying that next bill date is generated
        Assert.assertTrue(isElementDisplayed(nextBillDate), "next bill date");
        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(storeNamewithstripe);
        softAssert.assertAll();
    }

    public void verifyStoreCreationWithYearlyBusinessPlan(String location, String address) {
        Login();
        getStoreCreation(location, address);

        getSubscriptionPlanTab();

        //Verifying that 'Current Plan' appears under Essential Free Plan
        String message = getText(currentPlanMSg);
        Assert.assertEquals(message, Constants.currentPlan);

        // select on Business Yearly plan
        getBusinessYearlyPlan();

        //Click on 'Sign up' button
        getPlansSignUpButton();

        //Verifying that by-default Visa Payment method is enabled
        String defaultPaymentMthd = getText(addedVisaMethod);
        Assert.assertEquals(defaultPaymentMthd, Constants.visavalue);

//       Click on 'Change Pay Method' Link
        getChangePayMethodLink();//Verifying that other payment methods are available
        Assert.assertTrue(isElementDisplayed(newCreditCardBtn));
        Assert.assertTrue(isElementDisplayed(newBankAccountBtn));
        getbankAccountOptionForPlan();

        // Click on 'Terms' Checkbox
        getTermsCheckbox();
        scrollToElement(changePlanBtn);

        //  Click on 'Change Plan' Button
        getChangePlanButton();

        //Verifying that next bill date is generated
        Assert.assertTrue(isElementDisplayed(nextBillDate));

        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);
        pageObjectManager.getAdminPage().selectedStoreDeleted(storeNamewithstripe);
    }

    public void deletionOfStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Click on 'Register New Business' Button
        getRegisterNewBusinessButton();
        staticWait(2000);
        if (!isElementDisplayed(storeLogo)) {
            getSkipStripeAccountButton();
            waitForElementToBeVisible(skipPopUpTitle, 4);

            String actual = getText(skipPopUpTitle);
            //Verifying the 'Skip' Pop Up Title
            Assert.assertEquals(actual, Constants.skip);
            //  Click on 'Skip' button
            getSkipBtnOfStripe();
        } else {
            Log.info("Logo is not displayed");
        }
        scrollToElement(deleteStoreBtn);
        waitForElementToBeVisible(deleteStoreBtn, 7);
        // click on delete button
        getDeleteStoreButton();
        getDeleteStoreIcon();
    }

    public void verifyConfigurationsOfStoreUsingSettings() {
        String tipAmountPercent1 = requiredDigits(2);
        String tipAmountPercent2 = requiredDigits(2);
        String tipAmountPercent3 = requiredDigits(2);
        String rewardPoints = requiredDigits(4);

        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        waitForElementToBeInteractable(configureLink, 4);

        // Click on 'Configure' Link
        getConfigureLink();

        // Click on 'Settings' Sub-Tab
        getSettingSubTab();

        //Verifying Minimum, Maximum and Default values of 'Maximum Bill Amount' Field
        String maxBillAmount = requiredDigits(parseFloat(Constants.minimumBillAmount), parseFloat(Constants.maximumBillAmount));
        softAssert.assertEquals(getAttribute(maxBillAmountTbx, "max"), Constants.maximumBillAmount);
        softAssert.assertEquals(getAttribute(maxBillAmountTbx, "min"), Constants.minimumBillAmount);

        //  Enter amount in 'Maximum Bill Amount' field
        actionEnterText(maxBillAmountTbx, maxBillAmount);
        staticWait(3000);

        if (!isElementDisplayed(tipGratuityToggleOffBtn)) {

            // Click on 'Tip & Gratuity' Toggle Button
            getTipGratuityToggleOnButton();
        }
        // Click on 'Configure' button
        getTipConfigureBtn();

        //Verifying the 'Tip Configuration' Pop-up Title
        softAssert.assertEquals(tipConfigPopUpTitle, Constants.tipConfigurationTitle);

        staticWait(5000);
        getEnterInPerCentToggleButton();

        cleanByJS(tipPercentField1);
        cleanByJS(tipPercentField2);
        cleanByJS(tipPercentField3);

        // Click on 'Save Changes' button
        getSaveChangesButton();

        getValidationCrossIcon();

        staticWait(3000);

        String tooltip1 = getToolTipMessage(tipPercentField1);
        Assert.assertEquals(tooltip1, requiredFldValidation);

        String tooltip2 = getToolTipMessage(tipPercentField2);
        Assert.assertEquals(tooltip2, requiredFldValidation);

        String tooltip3 = getToolTipMessage(tipPercentField3);
        Assert.assertEquals(tooltip3, requiredFldValidation);

        staticWait(4000);

        // Click on 'Enter in Percentage' Toggle button
        getEnterInPerCentToggleButton();

        staticWait(3000);

        if (!isElementDisplayed(alertMessage)) {

            // Click on 'Enter in Percentage' Toggle button
            getEnterInPerCentToggleButton();
        }

        //Verifying the Default and maximum values of 'Tip Amount' fieltipPercentField1d
        softAssert.assertEquals(getAttribute(tipPercentField1, "max"), tipAmountPercent1);

        //  Enter Tip Values
        actionEnterText(tipPercentField1, tipAmountPercent1);
        actionEnterText(tipPercentField2, tipAmountPercent2);
        actionEnterText(tipPercentField3, tipAmountPercent3);

        // Click on 'Save Changes' button
        getSaveChangesButton();

        // Click on 'Configure' button
        getRewardConfigureButton();

        //Verifying the 'Rewards Configuration' Pop-Up Title
        String rewardConfig = getText(rewardConfigPopUpTitle);
        softAssert.assertEquals(rewardConfig, Constants.rewardConfigurationpopup);

        // Click on 'Reward Point' Toggle button
        if (!isElementDisplayed(rewardPointsField)) {
            getRewardPointToggleOnButton();
        }

        //Verifying the Minimum and Maximum Values of 'Reward Points' Field
        Assert.assertEquals(getAttribute(rewardPointsField, "max"), "99999");
        Assert.assertEquals(getAttribute(rewardPointsField, "min"), "100");

        // Enter Reward Points
        actionEnterText(rewardPointsField, rewardPoints);

        // Click on 'Save Changes' Button
        getSaveChangesButton();

        scrollToElement(storeLinksBtn);

        waitForElementToBeVisible(storeLinksBtn, 3);

        // Click on 'Store Links' button
        getStoreLinksButton();
        waitForElementToBeClickable(rewardPtsValue, 3);

        // Enter Reward Points
        actionEnterText(rewardPtsValue, rewardPoints);

        // Enter Website URL
        cleanByJS(websiteURLField);
        actionEnterText(websiteURLField, "www.KadePay" + requiredString(4) + ".com");

        // Click on 'Earn Rewards Points' Toggle Button
        System.out.println("testse2: " + isToggleEnabled(earnRewardsToggleBtn));
        if (!isToggleEnabled(earnRewardsToggleBtn)) {
            getEarnRewardsPointsToggleButton();
        } else {
            scrollToElement(saveChangesBtn);
            waitForElementToBeClickable(saveChangesBtn, 3);

            // Click on 'Save Changes' Button
            getSaveChangesButton();
            softAssert.assertAll();
        }
        softAssert.assertAll();
    }

}



