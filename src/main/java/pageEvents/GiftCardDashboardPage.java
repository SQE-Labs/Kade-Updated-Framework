package pageEvents;

 import logger.Log;
 import base.BaseTest;
 import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class GiftCardDashboardPage extends BaseTest {
    BillPage bill = new BillPage();
    //WebDriver driver =new ChromeDriver();
    public By systemMsg = By.cssSelector("p.h2");

    SidePannelPage pannel = new SidePannelPage();
    public By giftCardDashBoardHeaderText = By.cssSelector("h1.header-title");
     public By storeDropDown = By.cssSelector("span.select2-selection__rendered[role='textbox']");
    public By storeDropDownList = By.cssSelector("ul.select2-results__options > li");
    public By whichStoreContinueBtn = By.cssSelector("button.btn-primary");
    public By storeName = By.cssSelector("h3.text-truncate");
    By continueBtn = By.xpath("//button[@type='submit']");
    public By storeMnager = By.cssSelector("div.fw-bold");
    public By issuedOn = By.xpath("//span[contains(text(),'Issued on:')]");
    public By issueBy = By.xpath("//span[contains(text(), 'Issued by:')]");
    public By editBtn = By.cssSelector("i.far.fa-edit");
    public By systemAlert = By.cssSelector("div.alert-message>h4");
    public By clientDetailValidationMsg = By.cssSelector("div.alert-message>p");
    public By statusBtn = By.cssSelector("span.me-2~div>button.btn~ul.p-1");
    public By blockBtn = By.cssSelector("span.me-2~div>button.btn-danger");
    public By activeBtn = By.cssSelector("span.me-2~div>button.btn-success");
    public By infoMessageText = By.cssSelector("div.card-header.pb-0");
    public By configurationBtn = By.cssSelector("button.btn.btn-link");
     public By configurationPopupHeader = By.cssSelector("h5.modal-title");
    public By disabledToggleBtn = By.cssSelector("label.custom-checkbox.mb-3>i.far.fa-toggle-on.fa-rotate-180.custom-check-off");
    public By enabledToggleBth = By.cssSelector("label.custom-checkbox.mb-3>i.far.fa-toggle-on.custom-check-on");
    public By disabledText = By.cssSelector("label.custom-checkbox.mb-3>span.ms-2.fs-6.custom-check-off");
    public By enableText = By.cssSelector("label.custom-checkbox.mb-3>span.ms-2.fs-6.custom-check-on");
    public By referenceNoDisabledText = By.cssSelector("input[name='ReferenceNo'] ~ span.custom-check-off");
    public By referenceNoEnabledText = By.cssSelector("input[name='ReferenceNo'] ~ span.custom-check-on");
    public By referenceNoEnableToggleBtn = By.cssSelector("input[name='ReferenceNo'] ~ i.custom-check-on");
    public By refernceNoDiableToggleBtn = By.cssSelector("input[name='ReferenceNo'] ~ i.custom-check-off");
    public By fundingSourceEnabledText = By.cssSelector("input[name='readonlyFunds'] ~ span.custom-check-on");
    public By fundingSourceDisableText = By.cssSelector("input[name='readonlyFunds'] ~ span.custom-check-off");
    public By fundingSourceEnableToggleBtn = By.cssSelector("input[name='readonlyFunds'] ~ i.custom-check-on");
    public By fundingSourceDiableToggleBtn = By.cssSelector("input[name='readonlyFunds'] ~ i.custom-check-off");
    public By amountCardText = By.cssSelector("div.d-none.checked-d-block> div:nth-child(3)>label");
    public By saveConfiguration = By.cssSelector("button.btn.btn-outline-primary.ms-auto.mt-3");
    public By amountField = By.cssSelector("input[name='maximumGCAmount']");
    public By sourceFundingText = By.cssSelector("textarea[name='fundSourceList']");
    public By cardAmountValidationMsg = By.cssSelector("div.alert-message>p.alert-content");
    public By crossBtn = By.cssSelector("h5.modal-title ~button.btn-close");
    public By issueNewGiftCardBtn = By.cssSelector("div.bg-white>button:nth-child(2)");
    public By giftCardHeader = By.cssSelector("h5.modal-title");
    public By customerField = By.cssSelector("div>.modal-content .stretched-link.-selectCustomer-");
    public By customerTitleText = By.cssSelector("div.modal-content>div.modal-header>h5.modal-title>span.me-1");
    public By customerPhoneNo = By.cssSelector("input[name='phone']");
    public By customerName = By.cssSelector("input[name='phrase']");
    public By customerEmail = By.cssSelector("input[name='email']");
    public By customerEmailToolTip = By.cssSelector("input[name='email'].form-control.is-invalid");
    public By customerPhoneValidationMsg = By.xpath("(//form[@action=\"/api/Stores/searchCustomer\"]//div[contains(text(), \"Please review\")])[1]");
    public By customerPhoneSearchBtn = By.cssSelector("input[name='phone']~button.btn");
    public By customerEmailSearchBtn = By.cssSelector("input[name='email']~button.btn");
    public By customerEmailValidationMsg = By.xpath("(//form[@action=\"/api/Stores/searchCustomer\"]//div[contains(text(), \"Please review\")])[1]");
    public By customerPhoneToolTip = By.cssSelector("input[name='phone'].form-control.is-invalid");
    public By noSearchResultText = By.cssSelector("div.p-2>div.w-100>div~p");
    public By customerNameSearchBtn = By.cssSelector("input[name='phrase']~button.btn>i.far");
    public By doneBtn = By.cssSelector("button.btn.btn-link.w-100.my-3");
    public By intialAmount = By.cssSelector("input[name='initialAmount']");
    public By createButton = By.cssSelector("button.btn.btn-success.btn-lg.w-100");
    public By referenceNoField = By.cssSelector("input[name='referenceNo']");
    public By moreOptionsBtn = By.cssSelector("div.d-flex.justify-content-between ~ a.p-0.mb-1");
    By moreOptionSec=By.xpath("//label[text()='More options']/../..");
    public By cardNoText = By.xpath("//label[text()='Card No']");
    public By fundingResourceText = By.xpath("//label[text()='Funding source']");
    public By memoText = By.xpath("//label[text()='Memo']");
    public By startDateText = By.xpath("//label[text()='Start Date:']");
    public By endDateText = By.xpath("//label[text()='Exp. Date:']");
    public By CardNoField = By.cssSelector("label.optional~input[name='cardNo']");
    public By validationMsg = By.xpath("//p[text()='Please review the highlighted field(s)']");
    public By memoField = By.cssSelector("textarea[name='greetingMessage']");
    public By fundingResourceField = By.cssSelector("input[name='fundSource']");
    public By fundSourceList = By.cssSelector("textarea[name='fundSourceList']");
    public By fundSourceOption = By.cssSelector("select[name='fundSource']>option:nth-child(2)");
    public By startDate = By.cssSelector("div.input-group>input[name='startDate']");
    public By endDate = By.cssSelector("div.input-group>input[name='endDate']");
    public By giftCardDetailCardLink = By.xpath("(//tr/td/a[@class='btn btn-link btn btn-link'])[1]");
    public By giftCardHeaderText = By.cssSelector("h3.text-info");
    public By issueNewGiftcardForm = By.cssSelector("div.modal-body");
    public By infoIcon = By.cssSelector("i.fal.fa-info-square");
    public By enableClass = By.cssSelector("label.custom-checkbox.mb-3");
    public By updateButton = By.xpath("//button[text()='Update']");



    // Locators for Gift Cards For Sale

    By giftCardsSaleLink = By.xpath("//a[normalize-space()='Gift Cards For Sale']");
    public By addBtn = By.xpath("//a[normalize-space()='Add']");
    public By faceValue = By.xpath("//input[@name='amount']");
    public By salePrice = By.xpath("//input[@name='salePrice']");
    public By refNum = By.xpath("//input[@name='referenceNo']");
    public By fundingSrc = By.xpath("//select[@name='fundSource']");//div[@class='master-body']//div[4]//label[1]
    public By fundingLabel = By.xpath("//div[@class='master-body']//div[4]//label[1]");
    public By availableQnty = By.xpath("//input[@name='qty']");
    public By date = By.xpath("//div[@class='input-group']//input[@name='saleDateRange']");
    public By startDay = By.xpath("//input[@name='startInDays']");
    public By expireDay = By.xpath("//input[@name='expireInDays']");
    public By memo = By.xpath("//textarea[@name='memo']");
    public By saveBtn = By.xpath("//button[normalize-space()='Save changes']");
    public By pickingLeftDate = By.xpath("//div[@class='drp-calendar left']//div//table//tbody//tr[3]//td[4]");
    public By afterGiftCardFOrSalePage = By.xpath("//p[contains(text(), \"share the link to your gift cards\")]");
    public By firstCardLink = By.xpath("(//div[@class='loaded']//div)[1]");
    public By endText = By.xpath("(//span[text()=\"Ended\"])[1]");
    public By dataSavedSuccessfully = By.xpath("//div[text()=\"Data saved successfully!\"]");
    public By deleteIcon = By.xpath("//button[normalize-space(text())='Delete']");
    public By neverMindIcon = By.xpath("//button[normalize-space(text())='Never mind']");
    public By giftCardDetails = By.xpath("//div[starts-with(@class, 'bg-white mb-2 position-relative ')]");
    public By fundingResourceDropDown = By.cssSelector("select[name='fundSource']");
    By thumbsUp = with(By.tagName("button")).toRightOf(neverMindIcon);
    By filterBtn = with(By.tagName("button")).toLeftOf(addBtn);
    By statusAvailable = By.xpath("//option[text()='Available']");
    By optionLocator = By.xpath("//select[@name='status']//option");
    By endBtn = By.xpath("//option[2]");
    By applyBtn = By.xpath("//button[normalize-space(text())='Apply']");

    By storeDropdown = By.xpath("//span[contains(@class,'select2-selection s')]");
    By storeField = By.xpath("//input[@class='select2-search__field']");
    By selectStore = By.xpath("//li[text()='may2025']");
    By donutGraphDark = By.xpath("//div[@class='apexcharts-tooltip apexcharts-theme-dark']");
    By donutGraph = By.xpath("//div[@class='apexcharts-tooltip apexcharts-theme-dark apexcharts-active']");
    By donut = By.cssSelector("[class='apexcharts-series apexcharts-pie-series']");
    public By giftCardStatus = By.xpath("(//tr/td/a[@class='btn btn-link btn btn-link'])[1]/ancestor::tr/td[last()]");

    // filter locators
    By filterIcon = By.xpath("//div[contains(@class,'d-flex flex-wrap px-3')]/button/i");
    By filterTitle = By.xpath("//h5[text()='Filters']");
    By filterPopupCrossIcon = By.xpath("//h5[text()='Filters']/../button");
    By filterLabels = By.xpath("//div[@class='offcanvas-body']//div/label");
    By userNamePartialfield = By.cssSelector("[name='userName']");
    By userPhoneEmailtbx = By.xpath("//label[text()='User Phone/Email']");
    By applyBtnFilter = By.xpath("(//button[text()='Apply'])[1]");
    By resultUserName = By.xpath("(//img[contains(@class,'profile-image-sm')]/../span)[1]");
    By allresult = By.xpath("//table[contains(@class,'sortable_table')]//tbody/tr[@data-ref]");
    By noResultInfoMsg = By.cssSelector(".no-result-icon+p");
    By userEmailTbx = with(By.tagName("div")).below(userPhoneEmailtbx);
    By userEmailTxtField = By.xpath("(//label[text()='User Phone/Email']/../div)[2]");
    By validationMsgForCustomerPopup = By.cssSelector(".no-result-icon+p");
    By dateFilterLabel = By.xpath("//label[starts-with(text(),'Date')]");
    By dateFilterInput = with(By.tagName("input")).below(dateFilterLabel);
    By existingGCDate = By.xpath("//table[@class='table-condensed'][.//th[text()='May 2025']]//td[text()='12']");
    By dateFilterFiled = By.xpath("(//div[contains(@class,'position-relative mb-3')]/div[@class='input-group'])[1]");
    By nonExistingGCDate = By.xpath("//table[@class='table-condensed'][.//th[text()='May 2025']]//td[text()='2']");
    By datefilterTbx = By.xpath("//div[@class='input-group']//input[@name='dateRange']");
    By validationCrossIcon = By.cssSelector(".btn-close.autoclick-effect");
    By dropDownFilter = By.xpath("//select[@name='status']");
    By giftCardStatusTbx = By.xpath("(//label[text()='Gift card status']/following-sibling::div)[1]");
    By dropdownoptions = By.xpath("//select[@name='status']/option");
    By minAmountFilterField = By.cssSelector("[name='minAmount']");
    By maxAmountFilterField = By.cssSelector("[name='maxAmount']");
    By cardNumberFilterField = By.cssSelector("[name='cardNo']");
    public By profileLink = By.cssSelector("div.min-15c>div.d-flex>a.me-1~div>a");
    public By totalSpentText = By.xpath("//div[contains(@class, 'col') and contains(@class, 'd-flex') and contains(@class, 'flex-column')]//span[contains(text(), 'Total spent')]");
    public By messageIcon = By.cssSelector("a.p-0>i.fa-paper-plane");
    public By messageTextBox = By.cssSelector("textarea[id='newMessage']");
    public By totalAmt = By.cssSelector("h6>span>span.ms-1");

    public String DateStringGenerator() {
        LocalDate currentDate = LocalDate.now(); // or any specific date: LocalDate.of(2025, 4, 15)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);

        String result = "Issued on: " + formattedDate;
        return result;
    }

    public void getFilterIcon() {
        clickElementByJS(filterIcon);
    }

    public void getFitlerApplyBtn() {
        click(applyBtnFilter);
    }

    public void getUserPhoneEmailTbxFilter() {
        staticWait(3000);
        click(userEmailTbx);
    }

    public void clickOnUserEmailTxtField() {
        click(userEmailTxtField);
    }

    public void getDateFilterInput() {
        click(dateFilterFiled);
    }

    public void getValidationCrossIcon() {
        click(validationCrossIcon);
    }

    public void getExistingGCDate() {
        click(existingGCDate);
        click(existingGCDate);
    }

    public void getNonExistingGCDate() {
        click(nonExistingGCDate);
        click(nonExistingGCDate);
    }

    public void getGiftCardStatusTbx() {
        click(giftCardStatusTbx);
    }

    public String[] onOptionalSettings() {
        Login();
        String storeManagerName = getText(storeMnager);
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(1);
        click(whichStoreContinueBtn);
        click(configurationBtn);

        if (!isDisplayed(enableClass, 3)) {
            clickElementByJS(enabledToggleBth);
        }
        if (isDisplayed(fundingSourceDisableText, 3)) {
            clickElementByJS(fundingSourceDiableToggleBtn);
            setFundingSourceList();
        }
        if (isDisplayed(referenceNoDisabledText, 3)) {
            clickElementByJS(referenceNoEnableToggleBtn);
        }

        waitForElementToBeVisible(amountField, 1000);
        actionEnterText(amountField, "100000");
        WebElement element = getWebElement(amountField);
        String maxAmountValue = element.getAttribute("value");
        click(saveConfiguration);

        return new String[]{maxAmountValue, storeManagerName};
    }

    public void verifyMandatoryFields() {
        onOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 1000);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount, 1000);
        actionEnterText(intialAmount, "100000");
        staticWait(1000);
        actionEnterText(referenceNoField, "924-124");
        scrollToElement(moreOptionsBtn);
        staticWait(1000);
        clickElementByJS(moreOptionsBtn);
        selectDropdownByIndex(fundingResourceDropDown, 1);
        staticWait(1000);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
        staticWait(3000);
        scrollToElement(giftCardDetailCardLink);
        staticWait(3000);
        click(giftCardDetailCardLink);
        staticWait(2000);
        click(infoIcon);


    }

    public static void LoginAsCustomerNew() {
        Log.info("Starting Login test - Entering username and password");


        String username = configReader.getProperty("customerNew");
        String password = configReader.getProperty("password");

        // Validate if username and password are present in the config file
        if (username == null || password == null) {
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }

        pageObjectManager.getLoginPage().signIn(username, password);

        // Log the status of the action after clicking SignIn
        Log.debug("User has successfully logged in and landed on the dashboard");

        // Verify the landing page is correct after login
        pageObjectManager.getHomePage().landingPage();
    }


    public String selectStore(int index) {
        click(storeDropDown);
        String getStoreName = clickElementFromList(storeDropDownList, index);
        return getStoreName;
    }

    public void clickOnStore() {
        click(storeDropdown);
    }

    public void selectStore() {
        click(selectStore);
    }

    public void sendKeysInStoreField(String storeFieldTxt) {
        actionEnterText(storeField, storeFieldTxt);
    }


    public String[] offOptionalSettings() {
        Login();
        String storeManagerName = getText(storeMnager);
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(3);
        click(whichStoreContinueBtn);
        click(configurationBtn);

        if (!isDisplayed(enableClass, 3)) {
            clickElementByJS(enabledToggleBth);
        }
        if (!isDisplayed(fundingSourceDisableText, 3)) {
            clickElementByJS(fundingSourceEnableToggleBtn);
        }
        if (!isDisplayed(referenceNoDisabledText, 3)) {
            clickElementByJS(referenceNoEnableToggleBtn);
        }

        waitForElementToBeVisible(amountField, 1000);
        actionEnterText(amountField, "100000");
        WebElement element = getWebElement(amountField);
        String maxAmountValue = element.getAttribute("value");
        click(saveConfiguration);

        return new String[]{maxAmountValue, storeManagerName};
    }


    public void verifyInformationMsgNoActiveStore() {
        LoginAsCustomerNew();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        softAssert.assertEquals(getText(systemMsg), Constants.noActiveStoreInfoMsg);
    }

    public void verifyGiftcardDashboardPage() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        softAssert.assertEquals(getText(giftCardDashBoardHeaderText), Constants.GiftCardHeader);
        String name = selectStore(3);
        click(whichStoreContinueBtn);
        softAssert.assertEquals(getText(storeName), name);
    }

    public void getContinueButton() {
        click(continueBtn);
    }


    public void verifyGiftConfigurationPopup() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(4);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        softAssert.assertEquals(getText(configurationPopupHeader), Constants.configurationPopupTitle);


    }


    public void verifyReferenceNoOptions() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(4);
        click(whichStoreContinueBtn);
        click(configurationBtn);

        if (isDisplayed(disabledToggleBtn, 3)) {
            softAssert.assertEquals(getText(disabledText), Constants.DisabledText);
            click(disabledToggleBtn);
            softAssert.assertEquals(getText(enableText), Constants.EnableText);
        } else if (isDisplayed(enabledToggleBth, 3)) {
            softAssert.assertEquals(getText(enableText), Constants.EnableText);
        } else {
            throw new IllegalStateException("Main toggle button not found in expected states");
        }

        handleReferenceNoToggle();
    }

    private void toggle(By toggleBtn, By textLocator, String expectedText) {
        click(toggleBtn);
        waitUntilTextChanges(textLocator, expectedText, 3);
        softAssert.assertEquals(getText(textLocator), expectedText);
    }

    private void handleReferenceNoToggle() {
        if (isDisplayed(refernceNoDiableToggleBtn, 3)) {
            softAssert.assertEquals(getText(referenceNoDisabledText), Constants.referenceNoDisabledText);
            click(refernceNoDiableToggleBtn);
            softAssert.assertEquals(getText(referenceNoEnabledText), Constants.referenceNoEnabledText);
        } else if (isDisplayed(referenceNoEnableToggleBtn, 3)) {
            click(referenceNoEnableToggleBtn);
            softAssert.assertEquals(getText(referenceNoDisabledText), Constants.referenceNoDisabledText);
            click(refernceNoDiableToggleBtn);
            softAssert.assertEquals(getText(referenceNoEnabledText), Constants.referenceNoEnabledText);
        } else {
            throw new IllegalStateException("Reference No toggle not found");
        }
    }

    private void waitUntilTextChanges(By locator, String expectedText, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.textToBe(locator, expectedText));
    }


    public void verifySourceFundingOptions() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(6);
        click(whichStoreContinueBtn);
        click(configurationBtn);

        if (!isDisplayed((disabledToggleBtn), 3)) {
            click(enabledToggleBth);
            Assert.assertEquals(getText(disabledText), Constants.DisabledText);
            click(disabledToggleBtn);
            Assert.assertEquals(getText(enableText), Constants.EnableText);
        } else {
            Assert.assertEquals(getText(disabledText), Constants.DisabledText);
            click(disabledToggleBtn);
            Assert.assertEquals(getText(enableText), Constants.EnableText);
        }

        handleSourceFundingToggle();
    }

    private void handleSourceFundingToggle() {
        if (isDisplayed((fundingSourceDisableText), 3)) {
            Assert.assertEquals(getText(fundingSourceDisableText), Constants.sourceFundingDisabledText);
            click(fundingSourceDiableToggleBtn);
            Assert.assertEquals(getText(fundingSourceEnabledText), Constants.getSourceFundingEnabledText);
        } else {
            click(fundingSourceDiableToggleBtn);
            Assert.assertEquals(getText(fundingSourceDisableText), Constants.sourceFundingDisabledText);
            click(fundingSourceEnableToggleBtn);
            Assert.assertEquals(getText(fundingSourceEnabledText), Constants.sourceFundingDisabledText);
        }
    }

    public void verifyCardAmountField() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(6);
        click(whichStoreContinueBtn);
        click(configurationBtn);

        if (isDisplayed(disabledToggleBtn, 3)) {
            click(disabledToggleBtn);
            Assert.assertEquals(isDisplayed(amountCardText, 3), "true");
        } else {
            click(enabledToggleBth);
            click(disabledToggleBtn);
            Assert.assertEquals(isDisplayed(amountCardText, 3), "true");
        }


    }

    public void verifySendAmount() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        String name = selectStore(6);
        click(whichStoreContinueBtn);
        click(configurationBtn);

        if (isDisplayed(disabledToggleBtn, 3)) {
            click(disabledToggleBtn);
            waitForElementToBeVisible(amountField, 3);
            actionEnterText(amountField, "100000");
            click(saveConfiguration);
            softAssert.assertEquals(storeName.toString(), name);

        } else {
            waitForElementToBeVisible(amountField, 3);
            actionEnterText(amountField, "100000");
            click(saveConfiguration);
            softAssert.assertEquals(storeName.toString(), name);

        }


    }


    public void verifyOptionalSettings() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        String name = selectStore(6);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        if (isDisplayed(disabledToggleBtn, 3)) {
            click(disabledToggleBtn);
            if (!isDisplayed(refernceNoDiableToggleBtn, 3)) {
                click(referenceNoEnableToggleBtn);
            }
            if (!isDisplayed(fundingSourceDisableText, 3)) {
                click(fundingSourceDiableToggleBtn);
            } else {
                waitForElementToBeVisible(amountField, 3);
                actionEnterText(amountField, "100000");
                click(saveConfiguration);
                softAssert.assertEquals(storeName.toString(), name);
            }


        } else {
            if (!isDisplayed(refernceNoDiableToggleBtn, 3)) {
                click(referenceNoEnableToggleBtn);
            }
            if (!isDisplayed(fundingSourceDisableText, 3)) {
                click(fundingSourceDiableToggleBtn);
            } else {
                waitForElementToBeVisible(amountField, 3);
                actionEnterText(amountField, "100000");
                click(saveConfiguration);
                softAssert.assertEquals(storeName.toString(), name);
            }


        }
    }

    public void verifyNullAmountValidationMsg() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        click(whichStoreContinueBtn);
        click(configurationBtn);

        WebElement amountFieldElement = getWebElement(amountField);

        // Bring focus and clear the field using multiple methods for reliability
        amountFieldElement.click(); // Focus the field

        String currentValue = amountFieldElement.getAttribute("value");
        System.out.println("Current Amount Field Value: " + currentValue);

        if (currentValue != null && !currentValue.isEmpty()) {
            try {
                amountFieldElement.clear(); // First attempt to clear
                Thread.sleep(500); // Wait briefly for UI to update

                // Double-check and fallback to JavaScript if not cleared
                if (!amountFieldElement.getAttribute("value").isEmpty()) {
                    JavascriptExecutor js = (JavascriptExecutor) getDriver();
                    js.executeScript("arguments[0].value='';", amountFieldElement);
                    System.out.println("Field cleared using JavaScript.");
                } else {
                    System.out.println("Field cleared using .clear().");
                }
            } catch (Exception e) {
                System.out.println("Exception while clearing: " + e.getMessage());
            }
        } else {
            System.out.println("Amount field is already empty.");
        }

        if (isDisplayed(disabledToggleBtn, 4)) {
            click(disabledToggleBtn);
        }

        click(saveConfiguration);
        softAssert.assertEquals(getText(cardAmountValidationMsg), Constants.ValidationMsg);
    }

    public void verifyCrossButton() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        String name = selectStore(6);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        click(crossBtn);
        softAssert.assertEquals(storeName.toString(), name);

    }

    public void verifyIssueNewGiftCardBtn() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(4);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        offOptionalSettings();
        staticWait(1000);
        waitForElementToBeVisible(issueNewGiftCardBtn, 1000);
        click(issueNewGiftCardBtn);
        softAssert.assertEquals(getText(giftCardHeader), Constants.giftCardHeaderText);

    }

    public void verifyCustomerPopUp() {
        offOptionalSettings();
        staticWait(1000);
        waitForElementToBeVisible(issueNewGiftCardBtn, 1000);
        click(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        softAssert.assertEquals(getText(customerTitleText), Constants.customerPopupTitle);


    }

    public void verifyInvalidCustomerPhoneField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerPhoneNo, 1000);
        actionEnterText(customerPhoneNo, "1");
        click(customerPhoneSearchBtn);
        softAssert.assertEquals(getText(customerPhoneValidationMsg), Constants.ValidationMsg);
        softAssert.assertEquals(getToolTipMessage(customerPhoneToolTip), Constants.phoneValidationToolTip);


    }

    public void verifyInvalidCustomerEmailField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 1000);
        actionEnterText(customerEmail, "r");
        clickElementByJS(customerEmailSearchBtn);
        softAssert.assertEquals(getText(customerEmailValidationMsg), Constants.ValidationMsg);
        softAssert.assertEquals(getToolTipMessage(customerEmailToolTip), Constants.emailValidationToolTip);


    }

    public void verifyInvalidCustomerNameField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerName, 10000);
        actionEnterText(customerName, "rt");
        waitForElementToBeVisible(customerNameSearchBtn, 10000);
        click(customerNameSearchBtn);
        softAssert.assertEquals(getText(noSearchResultText), Constants.noResultText);

    }

    public void verifyInitialAmountField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 10);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        waitForElementToBeVisible(intialAmount, 10);
        actionEnterText(intialAmount, "1000");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 10);
        click(createButton);
    }


    public void verifyInitialAmtEqualsMaxGiftAmount() {
        String maxConfiguredAmt = offOptionalSettings()[2];
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 10);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        waitForElementToBeVisible(intialAmount, 10);
        actionEnterText(intialAmount, "100000");
        WebElement element = getWebElement(intialAmount);
        String maxIntialAmt = element.getAttribute("value");
        softAssert.assertEquals(maxConfiguredAmt, maxIntialAmt);


    }


    public void verifyRefrenceNoMandatory() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        click(whichStoreContinueBtn);
        click(configurationBtn);


        if (!isDisplayed(enableClass, 3)) {
            clickElementByJS(enabledToggleBth);
        }

        if (isDisplayed(referenceNoDisabledText, 3)) {
            clickElementByJS(refernceNoDiableToggleBtn);
        }


        actionEnterText(amountField, "100000");
        click(saveConfiguration);
        verifyReferenceTooltipFlow();
    }

    private void verifyReferenceTooltipFlow() {
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeVisible(customerField, 10);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 10);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount, 10);
        actionEnterText(intialAmount, "100000");
        staticWait(1000);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 10);
        click(createButton);
        staticWait(1000);
        softAssert.assertEquals(getToolTipMessage(referenceNoField), Constants.referenceNoTooltipMsg);
    }

    public void verifyAdditionalFields() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 10);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount, 10);
        actionEnterText(intialAmount, "100000");
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        waitForElementToBeVisible(cardNoText, 10);
        softAssert.assertEquals(getText(cardNoText), Constants.cardNoText);
        softAssert.assertEquals(getText(fundingResourceText), Constants.fundingResourceText);
        softAssert.assertEquals(getText(memoText), Constants.memoText);
        softAssert.assertEquals(getText(startDateText), Constants.startDateText);
        softAssert.assertEquals(getText(endDateText), Constants.endDateText);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 10);
        click(createButton);

    }

    public void verifyCardNoRejectLessThan4NumericValues() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 10);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount, 10);
        actionEnterText(intialAmount, "100000");
        staticWait(2000);
        scrollToElement(moreOptionSec);
        clickElementByJS(moreOptionSec);
        staticWait(3000);
        actionEnterText(CardNoField, "12");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
        Assert.assertEquals(getToolTipMessage(CardNoField), Constants.cardMinLendthMsg);
        Assert.assertEquals(getText(validationMsg), Constants.ValidationMsg);


    }

    public void verifyCardAcceptesNumericValues() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        staticWait(10000);
        WebElement element = getWebElement(CardNoField);
        String type = element.getAttribute("data-f-type");
        softAssert.assertEquals(type, Constants.cardNoDatatype);

    }


    public void verifyCardNoAccepts18NumericValues() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        staticWait(10000);
        WebElement element = getWebElement(CardNoField);
        String maxLength = element.getAttribute("maxlength");
        Assert.assertEquals(maxLength, Constants.maxLength);
    }

    public void verifyMemoAccepts500Values() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        WebElement element = getWebElement(memoField);
        String maxLength = element.getAttribute("maxlength");
        softAssert.assertEquals(maxLength, Constants.memoMaxLength);

    }


    public void verifyFundingSourceAsText() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        if (!isDisplayed(enableClass, 3)) {
            clickElementByJS(enabledToggleBth);
        }
        if (!isDisplayed(fundingSourceDisableText, 5)) {
            clickElementByJS(fundingSourceEnableToggleBtn);
        }

        waitForElementToBeVisible(amountField, 10);
        actionEnterText(amountField, "100000");
        click(saveConfiguration);
        staticWait(5000);
        clickElementByJS(issueNewGiftCardBtn);
        staticWait(2000);
        scrollToElement(moreOptionsBtn);
        staticWait(2000);
        clickElementByJS(moreOptionsBtn);
        staticWait(2000);
        WebElement element = getWebElement(fundingResourceField);
        String dataType = element.getAttribute("type");
        softAssert.assertEquals(dataType, Constants.fundingSourceType);


    }


    public String getNoActiveStoreInfoMsg() {
        return getText(systemMsg);
    }

    public String getSourceFundOption() {
        return getText(fundSourceOption);
    }

    public void clickWhichStoreContinueBtn() {
        click(whichStoreContinueBtn);
    }

    public void clickConfigurationButton() {
        click(configurationBtn);
    }

    public String getConfigurationPopupText() {
        return getText(configurationPopupHeader);
    }

    public String getDisabledText() {
        return getText(disabledText);
    }

    public void enableToggleButton() {
        click(disabledToggleBtn);
    }

    public void disableToggleButton() {
        click(enabledToggleBth);
    }

    public String getReferenceNoDisabledText() {
        return getText(referenceNoDisabledText);
    }

    public String getReferenceNoEnabledText() {
        return getText(referenceNoEnabledText);
    }

    public void enableReferenceNoEnableToggleBtn() {
        click(refernceNoDiableToggleBtn);
    }

    public void disableReferenceNoEnableToggleBtn() {
        click(referenceNoEnableToggleBtn);
    }

    public String getFundingSourceDisabledText() {
        return getText(fundingSourceDisableText);
    }

    public String getFundingSourceEnabledText() {
        return getText(fundingSourceEnabledText);
    }

    public void enableFundingSourceEnableToggleBtn() {
        click(fundingSourceEnableToggleBtn);
    }

    public void disableFundingSourceEnableToggleBtn() {
        click(fundingSourceDiableToggleBtn);
    }

    public void clickSaveConfigurationBtn() {
        click(saveConfiguration);
    }

    public void enterAmount() {
        waitForElementToBeVisible(amountField, 1000);
        actionEnterText(amountField, "100000");
    }

    public void enterTextSourceFunding() {
        SendKeys(sourceFundingText, "");
    }

    public String getCardAmountValidationMeg() {
        return getText(cardAmountValidationMsg);
    }

    public void clickCrossIcon() {
        click(crossBtn);
    }

    public void clickIssueNewGiftCardBtn() {
        staticWait(1000);
        waitForElementToBeVisible(issueNewGiftCardBtn, 1000);
        click(issueNewGiftCardBtn);
    }

    public String getGiftCardHeader() {
        return getText(giftCardHeader);
    }

    public String getCustomerTitle() {
        return getText(customerTitleText);
    }

    public void clickCustomerField() {
        waitForElementToBeClickable(customerField, 1000);
        clickElementByJS(customerField);
    }

    public void setCustomerPhoneNo(String number) {
        waitForElementToBeVisible(customerPhoneNo, 1000);
        actionEnterText(customerPhoneNo, number);
    }

    public void clickPhoneSearchBtn() {
        click(customerPhoneSearchBtn);
    }

    public String getPhoneValidationMsgText() {
        return getText(customerPhoneValidationMsg);
    }

    public String geEmailValidationMsgText() {
        waitForElementToBeVisible(customerEmailValidationMsg, 1000);
        return getText(customerEmailValidationMsg);
    }

    public void setCustomerName(String name) {
        waitForElementToBeVisible(customerName, 10000);
        actionEnterText(customerName, name);
    }

    public String getNoSearchResultText() {
        return getText(noSearchResultText);
    }

    public void setCustomerEmail(String email) {
        staticWait(1000);
        actionEnterText(customerEmail, email);
    }

    public void clickEmailSearchBtn() {
        staticWait(1000);
        waitForElementToBeVisible(customerEmailSearchBtn, 10000);
        click(customerEmailSearchBtn);
    }

    public void clickCustomerNameSearchBtn() {
        waitForElementToBeVisible(customerNameSearchBtn, 10000);
        click(customerNameSearchBtn);
    }

    public String getEmailValidationToolTip() {
        return getToolTipMessage(customerEmailToolTip);
    }

    public String getPhoneValidationToolTip() {
        return getToolTipMessage(customerPhoneToolTip);
    }

    public void clickCreateBtn() {
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
    }

    public void clickDoneBtn() {
        waitForElementToBeVisible(doneBtn, 1000);
        click(doneBtn);
    }

    public void setIntialAmount(String amt) {
        staticWait(10000);
        waitForElementToBeVisible(intialAmount, 1000);
        actionEnterText(intialAmount, amt);
    }

    public String getReferenceNoToolTip() {
        return getToolTipMessage(referenceNoField);
    }

    public void clickMoreOptionsBtn() {
        staticWait(10000);
        waitForElementToBeVisible(moreOptionsBtn, 1000);
        clickElementByJS(moreOptionsBtn);
    }

    public String getCardNoText() {
        waitForElementToBeVisible(cardNoText, 1000);
        return getText(cardNoText);
    }

    public void setCardNo(String No) {
        staticWait(10000);
        actionEnterText(CardNoField, No);
    }

    public String getCardNoValidationToolTip() {
        return getToolTipMessage(CardNoField);
    }

    public String getCardNoValidationMsg() {
        return getText(validationMsg);
    }

    public void clickStartDate() {
        click(startDate);
    }

    public void clickEndDate() {
        click(endDate);
    }

    public void enterTextStartDate() {
        actionEnterText(startDate, requiredString(5));
    }

    public void enterTextEndDate() {
        actionEnterText(endDate, requiredString(5));
    }

    public String getStartDateTooltipMsg() {
        return getToolTipMessage(startDate);
    }

    public String getEndDateTooltipMsg() {
        return getToolTipMessage(endDate);
    }

    public void clickGiftCardLink() {
        staticWait(10000);
        waitForElementInVisible(issueNewGiftcardForm, 1000);
        click(giftCardDetailCardLink);
    }

    public String getGiftCardText() {
        staticWait(10000);
        ;
        return getText(giftCardDetailCardLink);
    }

    public String getGiftCardTextHeaders() {
        staticWait(10000);
        String noText = getText(giftCardHeaderText);
        String numberOnly = noText.split(":")[1].trim();
        return numberOnly;
    }

    public void clickInfoIcon() {
        staticWait(10000);
        click(infoIcon);
    }

    public List<WebElement> getListOfWebElements(By locator) {
        return getDriver().findElements(locator);
    }

    public String clickElementFromList(By locator, int index) {
        List<WebElement> elements = getDriver().findElements(locator);
        String name = elements.get(index).getText();
        if (!elements.isEmpty() && index < elements.size()) {
            elements.get(index).click();
            Log.info("Element is clicked at index: " + index);
        } else {
            Log.warn("Element not found at index: " + index);
        }
        return name;
    }

    public WebElement getWebElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        return wait.until(visibilityOfElementLocated(locator));
    }


    public void setFundingSourceList() {
        WebElement textArea = getWebElement(fundSourceList);
        String currentValue = textArea.getAttribute("value");
        if (currentValue != null && !currentValue.trim().isEmpty()) {
            System.out.println("Existing text found: " + currentValue);
            textArea.clear();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            textArea.sendKeys("HSBC");
            System.out.println("New text entered.");
        } else {
            System.out.println("Textarea was already empty.");
            textArea.sendKeys("HSBC");
        }
    }

    public void verifyFundingSourceAsTList() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        if (!isDisplayed(enableClass, 3)) {
            clickElementByJS(enabledToggleBth);
        }
        if (isDisplayed(fundingSourceDisableText, 3)) {
            clickElementByJS(fundingSourceDiableToggleBtn);
        }
        setFundingSourceList();
        waitForElementToBeVisible(amountField, 1000);
        actionEnterText(amountField, "100000");
        click(saveConfiguration);
        staticWait(5000);
        clickElementByJS(issueNewGiftCardBtn);
        staticWait(2000);
        scrollToElement(moreOptionsBtn);
        staticWait(2000);
        clickElementByJS(moreOptionsBtn);
        Assert.assertEquals(getText(fundSourceOption), "HSBC");
    }


    public void selectDateTwoDaysAgo() {

        LocalDate twoDaysAgo = LocalDate.now().minusDays(2);
        int day = twoDaysAgo.getDayOfMonth();
        String xpath = "//td[contains(@class, 'off') and contains(@class, 'disabled') and normalize-space(text())='" + day + "']";
        getDriver().findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(visibilityOfElementLocated(By.xpath(xpath)));
        WebElement dateElement = getDriver().findElement(By.xpath(xpath));
        String classes = dateElement.getAttribute("class");
        if (classes.contains("disabled")) {
            System.out.println("The date " + twoDaysAgo + " is disabled.");
        } else {
            dateElement.click();
            System.out.println("Selected date: " + twoDaysAgo);
        }
    }
    // Gift Cards for sale
//83

    public void getForSaleBtn() {
        click(giftCardsSaleLink);
    }

    public void verifyUserDirection() {

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        softAssert.assertTrue(isElementDisplayed(faceValue));
        softAssert.assertTrue(isElementDisplayed(salePrice));
        softAssert.assertTrue(isElementDisplayed(refNum));
        softAssert.assertTrue(isDisplayed(fundingLabel, 3));
        softAssert.assertTrue(isElementDisplayed(availableQnty));
        softAssert.assertTrue(isElementDisplayed(date));
        softAssert.assertTrue(isElementDisplayed(startDay));
        softAssert.assertTrue(isElementDisplayed(expireDay));
        softAssert.assertTrue(isElementDisplayed(memo));
        softAssert.assertAll();

    }

    //84
    public void verifyFaceValueAmountField() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        WebElement element = getWebElement(faceValue);
        //String maxlen=getAttribute(faceValue,"max");

        String maxLen = element.getAttribute("max");
        System.out.println(maxLen);           //maxlinit is 1000.00
        String amt = "100000";
        actionEnterText(faceValue, amt);    //10000.00
        String afterEnter = getText(faceValue);
        System.out.println(afterEnter);
        System.out.println("faceValue take input only 1000 as maximum limit is 1000");
        staticWait(3000);
        Assert.assertEquals(maxLen, "1000.00");
        staticWait(3000);


    }

    //85
    public void verifyFaceValueFieldAccept() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(faceValue, "asd100000");
        Log.info("Only enters numeric value so expected would be 1000.00 which is max");
        WebElement element = getWebElement(faceValue);
        String maxLen = element.getAttribute("max");
        Assert.assertEquals(maxLen, "1000.00");   //assert 1000.00 which is being entered with max
        staticWait(3000);

    }

    //86
    public void verifySalePriceFieldAccept() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(salePrice, "asd150000");
        Log.info("Only enters numeric value so expected would be 1000.00 which is max");
        WebElement element = getWebElement(salePrice);
        String maxLen = element.getAttribute("max");
        Assert.assertEquals(maxLen, "1500.00");   //assert 1500.00 which is being entered with max
        staticWait(3000);

    }

    public void verifyUserAllowedToEnterMaximumValue() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(salePrice, "150000");
        Log.info("Only enters numeric value so expected would be 1000.00 which is max");
        WebElement element = getWebElement(salePrice);
        String maxLen = element.getAttribute("max");
        Assert.assertEquals(maxLen, "1500.00");   //assert only 1500.00 which is being entered, with max
        staticWait(3000);


    }

    public void verifyFieldsAppearMandatory() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(faceValue, "15000");
        actionEnterText(salePrice, "17000");
        actionEnterText(refNum, "abc123");
        actionEnterText(availableQnty, "5");
        staticWait(5000);
        clickElementByJS(saveBtn);
        staticWait(2000);
        Log.info("Navigated to Gift Card for sale page");


    }

    public void verifyValidationLeavingFieldsBlank() {

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(faceValue, "15000");
        actionEnterText(salePrice, "17000");

        staticWait(5000);
        clickElementByJS(saveBtn);
        staticWait(2000);
        hoverOverElement(availableQnty);
        staticWait(2000);
        String message = getToolTipMessage(availableQnty);
        Assert.assertEquals(message, Constants.emptyFieldTooltip);

        Log.info("Validate tooltip");

    }

    public void verifyPastStartDatesDisabled() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        click(startDate);
        selectDateTwoDaysAgo();


    }

    public void verifyPastEndDateDisabled() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        click(endDate);
        selectDateTwoDaysAgo();


    }

    public void verifyStartDateRejectsCharacters() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        click(startDate);
        actionEnterText(startDate, "fssgjyfu");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1);
        click(createButton);
        staticWait(2000);
        softAssert.assertEquals(getText(validationMsg), Constants.ValidationMsg);
        softAssert.assertEquals(getToolTipMessage(startDate), Constants.invalidDateTooltip);
    }

    public void verifyEndDateRejectsCharacters() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        click(endDate);
        getDriver().findElement(endDate).sendKeys("asshiidnh");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1);
        click(createButton);
        softAssert.assertEquals(getToolTipMessage(endDate), Constants.invalidDateTooltip);
        softAssert.assertEquals(getText(validationMsg), Constants.ValidationMsg);

    }


    public void verifyFundingSrcFieldAppear(String actionType) {

        if (actionType.equals("Optional")) {
            Login();
            pannel.getMangeBusinessTab();
            pannel.getGiftCardsDashboardTab();
            selectStore(5);
            clickWhichStoreContinueBtn();
            getForSaleBtn();
            staticWait(3000);
            click(addBtn);
        } else {
            Login();
            pannel.getMangeBusinessTab();
            pannel.getGiftCardsDashboardTab();
            selectStore(5);
            clickWhichStoreContinueBtn();
            getForSaleBtn();
            staticWait(3000);
            click(addBtn);
        }
    }

    public void verifyAvailableQuantityFieldLength() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(availableQnty, "123456");
        staticWait(3000);
        String length = getAttribute(availableQnty, "maxlength");
        Log.info("Maximum length is" + " " + length);
        String limit = "4";
        Assert.assertEquals(limit, length);
    }

    public void verifyAvailableQuantityAcceptsNumbers() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(availableQnty, "123.33");
        String type = getAttribute(availableQnty, "data-f-type");
        String ExpectedType = "numeric";
        Assert.assertEquals(type, ExpectedType);


    }


    public void verifyRefNoValidation() {

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String max_char = getAttribute(referenceNoField, "maxlength");
        Log.info("Maximum char limit is : " + max_char);
        Assert.assertEquals(max_char, "30", "Max character limit is not 30");

    }

    private String getExpectedDateRange() {
        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return formatter.format(today) + " - " + formatter.format(nextYear);
    }

    public void verifyDefaultDateRange() {

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        // Get date range from UI
        String actualRange = getAttribute(date, "value");
        Log.info("Default date range is: " + actualRange);

        // Generate expected date range
        String expectedRange = getExpectedDateRange();

        // Assertion
        Assert.assertEquals(actualRange, expectedRange, "Date range does not match expected value.");

    }

    public void verifyDateRange() {

        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String amt = "1000";
        actionEnterText(faceValue, amt);
        actionEnterText(salePrice, "1500");
        actionEnterText(availableQnty, "5");
        scrollToElement(date);
        clickElementByJS(date);
        click(pickingLeftDate);
        click(pickingLeftDate);
        waitForElementToBeClickable(saveBtn, 2);
        staticWait(6000);
        click(saveBtn);
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(afterGiftCardFOrSalePage));


    }

    public void validateAddedFundingSource() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        if (!isDisplayed(enableClass, 3)) {
            clickElementByJS(enabledToggleBth);
        }
        if (isDisplayed(fundingSourceDisableText, 3)) {
            clickElementByJS(fundingSourceDiableToggleBtn);
        }
        setFundingSourceList();
        waitForElementToBeVisible(amountField, 1000);
        actionEnterText(amountField, "100000");
        click(saveConfiguration);
        staticWait(1000);
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        Assert.assertEquals(getText(fundSourceOption), "HSBC");

    }

    public void verifyMemoFieldMaximumChar() {

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        scrollToElement(memo);
        String max_char = getAttribute(memo, "maxlength");
        Log.info("Maximum char limit is : " + max_char);
        Assert.assertEquals(max_char, "500", "Max character limit is not 30");


    }

    public void verifyUserDirectionForSalePage() {
        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String amt = "1000";
        String saleAmt = "1500";
        String available = "5";
        actionEnterText(faceValue, amt);
        actionEnterText(salePrice, saleAmt);
        actionEnterText(availableQnty, available);
        scrollToElement(date);
        clickElementByJS(date);
        click(pickingLeftDate);
        click(pickingLeftDate);
        waitForElementToBeClickable(saveBtn, 2);
        staticWait(6000);
        click(saveBtn);
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(afterGiftCardFOrSalePage));
        waitForElementToBeClickable(firstCardLink, 5);
        click(firstCardLink);
        staticWait(4000);
        String prefilledFaceValue = getAttribute(faceValue, "value");
        String prefilledSalePrice = getAttribute(salePrice, "value");
        String prefilledAvailableQnty = getAttribute(availableQnty, "value");
        Assert.assertEquals(prefilledAvailableQnty, "5", "Available quantity is not prefilled");
        Assert.assertEquals(prefilledFaceValue, "10.00", "Available quantity is not prefilled");
        Assert.assertEquals(prefilledSalePrice, "15.00", "Sale price is not prefilled");

    }

    @Test
    public void verifyStatusOfGiftCard() {
        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String amt = "1000";
        String saleAmt = "1500";
        String available = "5";
        actionEnterText(faceValue, amt);
        actionEnterText(salePrice, saleAmt);
        actionEnterText(availableQnty, available);
        scrollToElement(date);
        clickElementByJS(date);
        // WebElement dateElement = driver.findElement(date);
        // dateElement.clear();
        cleanByJS(date);
        actionEnterText(date, "05/04/2023 - 05/04/2024");
        waitForElementToBeClickable(saveBtn, 2);
        staticWait(6000);
        click(saveBtn);
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(afterGiftCardFOrSalePage));
        waitForElementToBeVisible(endText, 5);
        staticWait(5000);
        String status = getText(endText);
        Assert.assertEquals(status, "Ended", "Status is not Active");

    }

    public void verifyUpdateSaleGiftCard() {

        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String amt = "1000";
        String saleAmt = "1500";
        String available = "5";
        actionEnterText(faceValue, amt);
        actionEnterText(salePrice, saleAmt);
        actionEnterText(availableQnty, available);
        scrollToElement(date);
        clickElementByJS(date);
        click(pickingLeftDate);
        click(pickingLeftDate);
        waitForElementToBeClickable(saveBtn, 2);
        staticWait(6000);
        click(saveBtn);
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(afterGiftCardFOrSalePage));
        waitForElementToBeClickable(firstCardLink, 5);
        click(firstCardLink);
        staticWait(4000);
        String updatedAmt = "70000";
        String updatedSaleAmt = "90000";
        String updateAvailable = "10";
        actionEnterText(faceValue, updatedAmt);
        actionEnterText(salePrice, updatedSaleAmt);
        actionEnterText(availableQnty, updateAvailable);
        scrollToElement(saveBtn);
        click(saveBtn);
        waitForElementToBeVisible(dataSavedSuccessfully, 5);
        Assert.assertTrue(isElementDisplayed(dataSavedSuccessfully));


    }

    public void verifyUserNotAbleToDeleteAfterCanceling() {

        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String amt = "1000";
        String saleAmt = "1500";
        String available = "5";
        actionEnterText(faceValue, amt);
        actionEnterText(salePrice, saleAmt);
        actionEnterText(availableQnty, available);
        scrollToElement(date);
        clickElementByJS(date);
        click(pickingLeftDate);
        click(pickingLeftDate);
        waitForElementToBeClickable(saveBtn, 2);
        staticWait(6000);
        click(saveBtn);
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(afterGiftCardFOrSalePage));
        waitForElementToBeClickable(firstCardLink, 5);
        click(firstCardLink);
        staticWait(4000);
        scrollToElement(deleteIcon);
        click(deleteIcon);
        waitForElementToBeVisible(neverMindIcon, 5);
        click(neverMindIcon);
        Assert.assertTrue(isElementDisplayed(date));
    }


    public void verifyUserAbleToDeleteSaleGift() {

        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String amt = "1000";
        String saleAmt = "1500";
        String available = "5";
        actionEnterText(faceValue, amt);
        actionEnterText(salePrice, saleAmt);
        actionEnterText(availableQnty, available);
        scrollToElement(date);
        clickElementByJS(date);
        click(pickingLeftDate);
        click(pickingLeftDate);
        waitForElementToBeClickable(saveBtn, 2);
        staticWait(6000);
        click(saveBtn);
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(afterGiftCardFOrSalePage));
        waitForElementToBeClickable(firstCardLink, 5);
        click(firstCardLink);
        staticWait(4000);
        scrollToElement(deleteIcon);
        click(deleteIcon);
        click(thumbsUp);
        staticWait(3000);

    }


    public void verifyListOfGiftCards() {

        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();


        int count = getCountOfWebElements(giftCardDetails);
        System.out.println("Count of the transaction " + count);

        List<WebElement> allGiftCards = new ArrayList<>();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        int previousCount = 0;

        while (true) {
            // Scroll to bottom
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for the new elements to load (you can customize this with ExpectedConditions)
            staticWait(2000); // Can be replaced with WebDriverWait for stability

            // Re-fetch the list after scroll
            List<WebElement> currentGiftCards = getDriver().findElements(giftCardDetails);

            int currentCount = currentGiftCards.size();
            System.out.println("Currently loaded bills: " + currentCount);

            if (currentCount == previousCount) {
                // No new gift cards loaded
                break;
            }

            previousCount = currentCount;
            allGiftCards = currentGiftCards;
        }

// Output total bills
        Log.info("Total gift cards collected: " + allGiftCards.size());
        for (WebElement gifts : allGiftCards) {
            System.out.println(gifts.getText()); // or any property you want
        }

        staticWait(5000);


    }

    public void verifyGiftCardDetails() {
        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(1000);
        click(filterBtn);
        staticWait(7000);
        Assert.assertTrue(isElementDisplayed(statusAvailable));
        Assert.assertEquals(getText(statusAvailable), "Available");


    }

    public void verifyAvailableAndAllOptionsInStatus() {

        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(1000);
        click(filterBtn);
        staticWait(2000);
        click(statusAvailable);
        List<WebElement> options = getDriver().findElements(optionLocator);

        // Assert that exactly two <option> elements are presentAssert.assertEquals("Expected exactly two options", 2, options.size());

        // Assert the text of each <option> element
        Assert.assertEquals(options.get(0).getText(), "Available");
        System.out.println("First option text: " + options.get(0).getText());
        Assert.assertEquals(options.get(1).getText(), "All");
        System.out.println("Second option text: " + options.get(1).getText());

    }


    public void verifyAvailableSaleGiftCards() {
        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        List<WebElement> allGiftCards = new ArrayList<>();

        int previousCount = 0;

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            staticWait(2000);

            List<WebElement> currentGiftCards = getDriver().findElements(giftCardDetails);
            int currentCount = currentGiftCards.size();

            System.out.println("Currently loaded gift cards: " + currentCount);

            if (currentCount == previousCount) {
                break;
            }

            previousCount = currentCount;
            allGiftCards = currentGiftCards;
        }

        Log.info("Total gift cards collected: " + allGiftCards.size());

        boolean zeroQtyFound = false;
        for (WebElement gift : allGiftCards) {
            String giftText = gift.getText();
            System.out.println(giftText);

            if (giftText.contains("Available QTY: 0")) {
                zeroQtyFound = true;
                Log.error("Gift card with zero available quantity found:\n" + giftText, new RuntimeException("Available QTY: 0"));
            }
        }

        if (zeroQtyFound) {
            throw new AssertionError("One or more gift cards have 'Available QTY: 0'. Test failed.");
        }

        staticWait(5000);
    }

    @Test
    public void verifyActionOnZeroAvailableQty() {
        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(1000);
        click(filterBtn);
        staticWait(2000);
        click(statusAvailable);
        click(endBtn);
        click(applyBtn);
        staticWait(5000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        List<WebElement> allGiftCards = new ArrayList<>();

        int previousCount = 0;

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            staticWait(2000);

            List<WebElement> currentGiftCards = getDriver().findElements(giftCardDetails);
            int currentCount = currentGiftCards.size();

            System.out.println("Currently loaded gift cards: " + currentCount);

            if (currentCount == previousCount) {
                break;
            }

            previousCount = currentCount;
            allGiftCards = currentGiftCards;
        }

        Log.info("Total gift cards collected: " + allGiftCards.size());
        boolean zeroQtyFound = false;

        for (WebElement gift : allGiftCards) {
            String giftText = gift.getText();
            System.out.println(giftText);

            if (giftText.contains("Available QTY: 0")) {
                zeroQtyFound = true;

                // Log the issue
                Log.error("Gift card with zero available quantity found:\n" + giftText, new RuntimeException("Available QTY: 0"));

                // Scroll to the gift card and click
                try {
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gift);
                    staticWait(1000); // allow scroll transition
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(gift)).click();
                } catch (ElementClickInterceptedException e) {
                    js.executeScript("arguments[0].click();", gift); // fallback JS click
                }

                staticWait(2000); // Optional: wait for UI to load

                // Check for Delete button
                try {
                    WebElement deleteBtn = getDriver().findElement(By.id("deleteButton")); // Use actual locator
                    boolean isDisplayed = isDisplayed(deleteIcon, 2);
                    if (isDisplayed) {
                        throw new AssertionError("Delete button should not be visible for Available QTY: 0");
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Delete button is not present, as expected.");
                }

                break; // Only handle the first tile with Available QTY: 0
            }
        }

        if (!zeroQtyFound) {
            throw new AssertionError("No gift card with 'Available QTY: 0' was found.");
        }
    }

    public void verifyActionOnSoldQty1() {
        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(1000);
        click(filterBtn);
        staticWait(2000);
        click(statusAvailable);
        click(endBtn);
        click(applyBtn);
        staticWait(5000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        List<WebElement> allGiftCards = new ArrayList<>();

        int previousCount = 0;

        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            staticWait(2000);

            List<WebElement> currentGiftCards = getDriver().findElements(giftCardDetails);
            int currentCount = currentGiftCards.size();

            System.out.println("Currently loaded gift cards: " + currentCount);

            if (currentCount == previousCount) {
                break;
            }

            previousCount = currentCount;
            allGiftCards = currentGiftCards;
        }

        Log.info("Total gift cards collected: " + allGiftCards.size());
        boolean soldQtyFound = false;

        for (WebElement gift : allGiftCards) {
            String giftText = gift.getText();
            System.out.println(giftText);

            if (giftText.contains("Sold QTY: 1")) {
                soldQtyFound = true;
                Log.info("Gift card with Sold QTY: 1 found:\n" + giftText);

                // Scroll to tile and click
                try {
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gift);
                    staticWait(1000);
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(gift)).click();
                } catch (ElementClickInterceptedException e) {
                    js.executeScript("arguments[0].click();", gift);
                }

                staticWait(2000); // wait for tile details to load

                // Scroll to delete icon and click
                try {
                    WebElement deleteBtn = getDriver().findElement(deleteIcon); // deleteIcon is a By locator
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", deleteBtn);
                    staticWait(1000);
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
                    Log.info("Delete button clicked successfully.");
                } catch (NoSuchElementException e) {
                    throw new AssertionError("Delete button not found on tile with Sold QTY: 1");
                }

                break;
            }
        }

        if (!soldQtyFound) {
            throw new AssertionError("No gift card with 'Sold QTY: 1' was found.");
        }
    }

    @Test
    public void verifyActionOnSoldQty0() {
        offOptionalSettings();
        staticWait(2000);
        getForSaleBtn();
        staticWait(1000);
        click(filterBtn);
        staticWait(2000);
        click(statusAvailable);  // Assuming the status filter is relevant for sold quantity as well
        click(endBtn);
        click(applyBtn);
        staticWait(5000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        List<WebElement> allGiftCards = new ArrayList<>();

        int previousCount = 0;

        // Scroll and collect all gift card elements until the list stops growing
        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            staticWait(2000);

            List<WebElement> currentGiftCards = getDriver().findElements(giftCardDetails);
            int currentCount = currentGiftCards.size();

            System.out.println("Currently loaded gift cards: " + currentCount);

            if (currentCount == previousCount) {
                break;
            }

            previousCount = currentCount;
            allGiftCards = currentGiftCards;
        }

        Log.info("Total gift cards collected: " + allGiftCards.size());
        boolean soldQtyFound = false;

        // Iterate over all gift cards and find the one with Sold QTY: 0
        for (WebElement gift : allGiftCards) {
            String giftText = gift.getText();
            System.out.println(giftText);

            if (giftText.contains("Sold QTY: 0")) {
                soldQtyFound = true;
                Log.info("Gift card with Sold QTY: 0 found:\n" + giftText);

                // Scroll to the gift card tile and click on it
                try {
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", gift);
                    staticWait(1000);  // Allow time for scroll to finish
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(gift)).click();
                } catch (ElementClickInterceptedException e) {
                    js.executeScript("arguments[0].click();", gift);
                }

                staticWait(2000); // wait for tile details to load

                // Scroll to delete icon and click
                try {
                    WebElement deleteBtn = getDriver().findElement(deleteIcon); // deleteIcon is a By locator
                    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", deleteBtn);
                    staticWait(1000); // Allow time for scroll to finish
                    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                    wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
                    Log.info("Delete button clicked successfully.");
                } catch (NoSuchElementException e) {
                    throw new AssertionError("Delete button not found on tile with Sold QTY: 0");
                }

                break;  // Only handle the first found tile with Sold QTY: 0
            }
        }

        // If no gift card with Sold QTY: 0 was found, throw an error
        if (!soldQtyFound) {
            throw new AssertionError("No gift card with 'Sold QTY: 0' was found.");
        }
    }

    public void countOfGiftCards() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//span[@class='apexcharts-legend-text']"));
        int count = elements.size();
        System.out.println("Total QR Code Types: " + count);

// Loop through each legend
        for (WebElement element : elements) {
            String txt = element.getText();
            Log.info("🔹 Legend Text: " + txt);

            element.click();
            staticWait(1000); // Let donut chart update

            // Get all donut segments
            List<WebElement> donuts = getDriver().findElements(By.cssSelector(".apexcharts-series.apexcharts-pie-series"));

            int index = 1;
            for (WebElement donut : donuts) {
                String selectedAttr = donut.getAttribute("selected");
                Log.info("  🍩 Donut #" + index + " selected attribute: " + selectedAttr);
                index++;
            }
        }
    }


//        public void getDonetGraphsColour() {
//            List<WebElement> DonetGraphs = getDriver().findElements(By.cssSelector("[class=apexcharts-datalabels]"));
//            for (WebElement graph : DonetGraphs) {
//                hoverOverElement(graph);       // hover over the WebElement
//                staticWait(2000);
//                Assert.assertTrue(isElementDisplayed(donutGraph));

//                 List<WebElement> DonetGraphs = getDriver().findElements(By.cssSelector("[class=apexcharts-datalabels]"));
//
//              //  for (int i = 0; i < DonetGraphs.size(); i++)
//                for(WebElement ele: DonetGraphs)
//                    By locator = By.cssSelector(ele);
//                    staticWait(3000);
//                    hoverOverElement(locator);
//                    staticWait(2000);
//                   String donetColour= getText(locator);
//                   Log.info("donet Colour is :" +donetColour);
//            }
//        }


    public void donateGraph(String storeFieldTxt) {

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        clickOnStore();
        sendKeysInStoreField(storeFieldTxt);
        selectStore();
        getContinueButton();
        countOfGiftCards();
        // getDonetGraphsColour();
    }


    public void getAllFilterFileds() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(filterTitle, 5);
        // verify Filter Title
        Assert.assertTrue(isElementDisplayed(filterTitle), "Filter Title ");

        // Expected filter labels
        List<String> expectedLabels = Arrays.asList("User Name \"Partial\"", "User Phone/Email", "Date", "Gift card status", "Min Amount", "Max Amount", "Card Number \"Partial\"");

        // Locate filter section
        List<WebElement> filterElements = getDriver().findElements(filterLabels);

        // Extract actual filter text
        for (String expectedLabel : expectedLabels) {
            boolean found = filterElements.stream().anyMatch(element -> element.getText().trim().equalsIgnoreCase(expectedLabel));
            Assert.assertTrue(found, "Filter label not found: " + expectedLabel);
        }
    }

    public void getRelevantRecordAfterEnteringExistingCardHolderFilter() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();

        waitForElementToBeClickable(userNamePartialfield, 4);
        enterText(userNamePartialfield, Constants.giftCardCustomer);

        // Click on apply button
        getFitlerApplyBtn();
        staticWait(4000);
        scrollToDown();

        // Verify that applied customer result appears
        Assert.assertEquals(getText(resultUserName), Constants.giftCardCustomer);

        staticWait(5000);


//         Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);

        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Gift Card Record for existing user is: " + detail);
        }
    }

    public void getNoRecordMsgForInvalidCardHolder() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();

        waitForElementToBeClickable(userNamePartialfield, 4);
        enterText(userNamePartialfield, Constants.invalidData);

        getFitlerApplyBtn();
        staticWait(4000);
        scrollToDown();
        waitForElementToBeVisible(noResultInfoMsg, 3);
        // Verify the no result info msg
        Assert.assertTrue(isElementDisplayed(noResultInfoMsg), "No result Info Message");
    }

    public void verifyRecordsAppearForPhoneFilter() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();

        waitForElementToBeClickable(userEmailTbx, 4);

        // clicking on 'User Email Phone filter
        clickOnUserEmailTxtField();
        staticWait(4000);

        //   Select Customer
        bill.getCustomerPhoneNoField(Constants.giftCardUserPhoneNumber);
        bill.getGoPhoneNumberButton();
        staticWait(3000);

        getFitlerApplyBtn();
        staticWait(3000);

        scrollToDown();
        staticWait(3000);

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);

        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for existing user is: " + detail);
        }
    }


    public void createGiftCard() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 1000);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount, 1000);
        actionEnterText(intialAmount, "100000");
        staticWait(1000);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
        staticWait(3000);
        click(giftCardDetailCardLink);
    }


    public void verifyRelevantRecordsAppearAfterEnteringUserEmailFilter() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();


        // clicking on 'User Email Phone filter
        clickOnUserEmailTxtField();
        staticWait(3000);
//        waitForElementToBeVisible();

        //   Select Customer
        bill.getCustomerEmailField(Constants.giftCardUserEmail);
        bill.getEmailGoButton();
        staticWait(3000);

        getFitlerApplyBtn();
        staticWait(3000);
        scrollToDown();
        //         Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);

        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for existing user is: " + detail);
        }
    }

    public void verifyInfoMsgForInvalidCustomerEmailInput() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();

        waitForElementToBeClickable(userEmailTbx, 4);

        // clicking on 'User Email Phone filter
        clickOnUserEmailTxtField();
        staticWait(3000);

        //   Select Customer
        bill.getCustomerEmailField(Constants.nonExistingEmailFilterInput);
        bill.getEmailGoButton();
        waitForElementToBeVisible(validationMsgForCustomerPopup, 3);

        // verify that  validation message appears
        Assert.assertEquals(getText(validationMsgForCustomerPopup), Constants.noResultText);
    }

    public void verifyInfoMsgForInvalidCustomerPhoneInput() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();

        // clicking on 'User Email Phone filter
        clickOnUserEmailTxtField();
        staticWait(5000);

        //   Select Customer
        bill.getCustomerPhoneNoField(Constants.nonExistingPhoneNoFilterInput);
        bill.getGoPhoneNumberButton();

        waitForElementToBeVisible(validationMsgForCustomerPopup, 3);

        // verify that  validation message appears
        Assert.assertEquals(getText(validationMsgForCustomerPopup), Constants.noResultText);
    }

    public void verifyGiftCardAppearsForSelectedDate() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);

        getDateFilterInput();
        staticWait(3000);

        getExistingGCDate();
        staticWait(3000);

        getFitlerApplyBtn();

        staticWait(4000);

        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        String expectedDate = "5/12/2025";

        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for existing user is: " + detail);

            Assert.assertTrue(detail.contains(expectedDate), "Record does not match the selected date: " + detail);
        }
    }

    public void verifyGCResultWhileApplyingNonExistingDateRangeFilter() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);

        getDateFilterInput();
        staticWait(3000);

        getNonExistingGCDate();
        getFitlerApplyBtn();
        staticWait(4000);
        scrollToDown();
        waitForElementToBeVisible(noResultInfoMsg, 3);
        // Verify the no result info msg
        Assert.assertTrue(isElementDisplayed(noResultInfoMsg), "There are no result Info Message");
    }

    public void verifyValidationOfDateFieldAfterEnteringCharacters() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);

        enterText(datefilterTbx, Constants.invalidDateTooltip);
        getFitlerApplyBtn();
        getValidationCrossIcon();

        String validation = getToolTipMessage(datefilterTbx);
        System.out.println("Invalid date is" + validation);
    }

    public void getDropDownOptions() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        getGiftCardStatusTbx();

        WebElement dropdown = getDriver().findElement(dropDownFilter);

        List<String> expectedOptions = Arrays.asList("", "Active", "Blocked", "Expired", "No Balance", "Pending transfer");

        // Find the dropdown options
        List<WebElement> options = getDriver().findElements(dropdownoptions);

        System.out.println("Verifying dropdown options:");

        // Iterate over the options in the dropdown
        for (WebElement option : options) {
            String optionText = option.getText().trim();  // Clean up any extra spaces or newlines
            optionText = optionText.replaceAll("\\s+", " "); // Replace multiple spaces with a single space

            // Check if the option exists in the expected list
            if (expectedOptions.contains(optionText)) {
                System.out.println("Option found: " + optionText);
            } else {
                // Fail the test if the option is not expected
                Assert.fail("Unexpected option: " + optionText);
            }
        }

        // Now check if all expected options are present
        for (String expectedOption : expectedOptions) {
            boolean optionFound = false;
            for (WebElement option : options) {
                String optionText = option.getText().trim();
                optionText = optionText.replaceAll("\\s+", " ");

                if (optionText.equals(expectedOption)) {
                    optionFound = true;
                    break;
                }
            }
        }
    }


    public void verifyRecordAfterApplyActiveFilterDD() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        getGiftCardStatusTbx();

        WebElement dropdown = getDriver().findElement(dropDownFilter);
        selectDropdownByIndex(dropDownFilter, 1);

        getFitlerApplyBtn();

        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);

        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for Active Gift Cards: " + detail);

            // ASSERT: each record should mention "Active"
            Assert.assertTrue(detail.contains("Active"), "Found non-Active record: " + detail);
        }
    }

    public void verifyRecordAfterApplyBlockedFilterDD() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        getGiftCardStatusTbx();

        WebElement dropdown = getDriver().findElement(dropDownFilter);
        selectDropdownByIndex(dropDownFilter, 2);

        getFitlerApplyBtn();

        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        int count = 0;
        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for Blocked Gift Cards: " + detail);
            // ASSERT: each record should mention "Blocked"
            Assert.assertTrue(detail.contains("Blocked"), "Found record: " + detail);

            count += 1;
        }
        System.out.println("Gift Card Count is " + count);
        staticWait(3000);

    }

    public void verifyRecordAfterApplyExpiredFilterDD() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        getGiftCardStatusTbx();

        WebElement dropdown = getDriver().findElement(dropDownFilter);
        selectDropdownByIndex(dropDownFilter, 3);

        getFitlerApplyBtn();

        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        int count = 0;
        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for Expired Gift Cards: " + detail);
            count += 1;
            // ASSERT: each record should mention "Expired"
            Assert.assertTrue(detail.contains("Expired"), "Found record non Expired : " + detail);
        }
        System.out.println("Gift Card Count is " + count);
        staticWait(3000);
    }

    public void verifyRecordAfterApplyPendingActivationFilterDD() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        getGiftCardStatusTbx();

        WebElement dropdown = getDriver().findElement(dropDownFilter);
        selectDropdownByIndex(dropDownFilter, 5);

        getFitlerApplyBtn();

        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        int count = 0;
        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for Pending Activation Gift Cards: " + detail);
            count += 1;
            // ASSERT: each record should mention "Expired"
            Assert.assertTrue(detail.contains("Pending transfer"), "Found record non Expired : " + detail);

        }
        System.out.println("Gift Card Count is " + count);
        staticWait(3000);
    }

    public void verifyRecordAfterApplyNoBalanceFilterDD() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        getGiftCardStatusTbx();

        WebElement dropdown = getDriver().findElement(dropDownFilter);
        selectDropdownByIndex(dropDownFilter, 4);

        getFitlerApplyBtn();

        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        int count = 0;
        for (WebElement record : allRecords) {
            String detail = record.getText();
            System.out.println("Record for No Balance Gift Cards: " + detail);
            count += 1;
            // ASSERT: each record should mention "No Balance"
            Assert.assertTrue(detail.contains("No Balance"), "Found record non Expired : " + detail);
        }
        System.out.println("Gift Card Count is " + count);
        staticWait(3000);
    }

    public void verifyRelevantGCAppearsAfterApplyingMinAmountFilter() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);

        actionEnterText(minAmountFilterField, Constants.minAmountOfGC);

        getFitlerApplyBtn();
        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        int count = 0;
        for (WebElement record : allRecords) {
            scrollToDown();
            String detail = record.getText();
            System.out.println("Record for Min Amount Gift Cards: " + detail);
            count += 1;
        }
        System.out.println("Gift Card Count is " + count);
        staticWait(3000);
    }

    public void verifyRelevantGCAppearsAfterApplyingMaxAmountFilter() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);

        actionEnterText(maxAmountFilterField, Constants.maxAmountOfGC);

        getFitlerApplyBtn();
        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        int count = 0;
        for (WebElement record : allRecords) {
            scrollToDown();
            String detail = record.getText();
            System.out.println("Record for Min Amount Gift Cards: " + detail);
            count += 1;
        }

        System.out.println("Gift Card Count is " + count);
        staticWait(3000);
    }

    public void verifyRecordAfterApplyingMinAndMaxValueFilterValues() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        actionEnterText(minAmountFilterField, Constants.minAmountOfGC);
        actionEnterText(maxAmountFilterField, Constants.midValue);

        getFitlerApplyBtn();
        staticWait(3000);
        scrollToDown();

        //Verify all result appears
        List<WebElement> allRecords = getDriver().findElements(allresult);
        int count = 0;
        for (WebElement record : allRecords) {
            scrollToDown();
            String detail = record.getText();
            System.out.println("Record Are: " + detail);

            // Removing '$' sign
            Pattern pattern = Pattern.compile("\\$(\\d+)");
            Matcher matcher = pattern.matcher(detail);

            if (matcher.find()) {
                int amount = Integer.parseInt(matcher.group(1));
                Assert.assertTrue(amount >= 100 && amount <= 500, " Amount out of expected range (100–500): $" + amount);
            } else {
                Assert.fail("Amount not found in record: " + detail);
            }
            count += 1;
        }

        System.out.println("Gift Card Count is " + count);
        staticWait(3000);
    }

    public void verifyRelevantGCAppearAfterApplyingAnyExistingGCno() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);

        // verify the validation message when less than 4 digit is entered in card no field
        actionEnterText(cardNumberFilterField, Constants.threeDigit);
        getFitlerApplyBtn();
        getValidationCrossIcon();
        staticWait(2000);
        String actualLessThan3Msg = getToolTipMessage(cardNumberFilterField);
        Assert.assertEquals(actualLessThan3Msg, Constants.lessThan3cardNoValidation);

        // Entering valid card no
        waitForElementToBeClickable(cardNumberFilterField, 4);
        actionEnterText(cardNumberFilterField, Constants.giftCardNo);

        getFitlerApplyBtn();
        staticWait(3000);
        scrollToDown();

        List<WebElement> allRecords = getDriver().findElements(allresult);
        String recordText = allRecords.get(0).getText();
        Assert.assertTrue(recordText.contains(Constants.giftCardNo), "Record does not match");


        // Entering non- existing GC no and Validate
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);
        actionEnterText(cardNumberFilterField, Constants.nonexistingGC);

        getFitlerApplyBtn();
        staticWait(3000);
        scrollToDown();

        // Verify the validation message
        waitForElementToBeVisible(noResultInfoMsg, 3);
        // Verify the no result info msg
        Assert.assertTrue(isElementDisplayed(noResultInfoMsg), "There are no result Info Message");
    }

    public void verifyInvalidInputofFilterFields() {
        offOptionalSettings();
        waitForPageLoad();

        staticWait(5000);
        getFilterIcon();
        waitForElementToBeVisible(dateFilterLabel, 4);

        // verify the validation message when less
        actionEnterText(maxAmountFilterField, Constants.midValue);
        actionEnterText(cardNumberFilterField, Constants.nonexistingGC);

        getFitlerApplyBtn();
        staticWait(3000);
        scrollToDown();

        // Verify the validation message
        waitForElementToBeVisible(noResultInfoMsg, 3);
        // Verify the no result info msg
        Assert.assertTrue(isElementDisplayed(noResultInfoMsg), "There are no result Info Message");


    }

    public void verifyGiftCardDetailPopUp() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 1000);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount, 1000);
        actionEnterText(intialAmount, "100000");
        staticWait(1000);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
        staticWait(2000);
        scrollToElement(giftCardDetailCardLink);
        String giftCardLinkText = getText(giftCardDetailCardLink);
        click(giftCardDetailCardLink);
        WebElement element = getWebElement(giftCardHeaderText);
        String cardNumber = element.getText().split(":")[1].trim();
        Assert.assertEquals(giftCardLinkText, cardNumber);
        System.out.println(cardNumber);
        staticWait(1000);


    }


    public void verifyInfoIcon() {
        String storeManagerName = offOptionalSettings()[1];
        String issueByActualText = "Issued on: " + storeManagerName;
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 1000);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount, 1000);
        actionEnterText(intialAmount, "100000");
        staticWait(1000);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
        staticWait(2000);
        scrollToElement(giftCardDetailCardLink);
        click(giftCardDetailCardLink);
        staticWait(2000);
        click(infoIcon);
        WebElement element = getWebElement(giftCardHeaderText);
        String cardNumber = element.getText().split(":")[1].trim();
        System.out.println(cardNumber);
        String issuedOnActualText = getText(issuedOn);
        String issuedOnexpectedText = DateStringGenerator();
        Assert.assertEquals(issuedOnActualText, issuedOnexpectedText);
        Assert.assertEquals(getText(issueBy), issueByActualText);


    }


    public void verifyEditBtn() {
        createGiftCard();
        click(editBtn);
        Assert.assertEquals(getText(fundingResourceText), Constants.fundingResourceText);
        Assert.assertEquals(getText(memoText), Constants.memoText);
        Assert.assertEquals(getText(startDateText), Constants.startDateText);
        Assert.assertEquals(getText(endDateText), Constants.endDateText);

    }

    public void verifyFundingResourceTextField() {
        createGiftCard();
        click(editBtn);
        WebElement element = getWebElement(fundingResourceField);
        String dataType = element.getAttribute("type");
        Assert.assertEquals(dataType, Constants.fundingSourceType);
    }

    public void verifyFundingResourceAsList() {
        verifyMandatoryFields();
        click(editBtn);
        Assert.assertEquals(getText(fundSourceOption), "HSBC");

    }

    public void verifyReferenceNoFieldMaxLen50() {
        verifyMandatoryFields();
        click(editBtn);
        WebElement element = getWebElement(referenceNoField);
        String maxLength = element.getAttribute("maxlength");
        Assert.assertEquals(maxLength, Constants.maxLength);
    }

    public void verifyMemoFieldMaxLen500() {
        verifyMandatoryFields();
        click(editBtn);
        WebElement element = getWebElement(memoField);
        String maxLength = element.getAttribute("maxlength");
        Assert.assertEquals(maxLength, Constants.memoMaxLength);
    }

    public void verifyPastStartDateIsDisabled() {
        verifyMandatoryFields();
        click(editBtn);
        click(startDate);
        selectDateTwoDaysAgo();

    }

    public void verifyPastEndDateIsDisabled() {
        verifyMandatoryFields();
        click(editBtn);
        click(endDate);
        selectDateTwoDaysAgo();

    }

    public void verifyStatusChange() {
        createGiftCard();
        click(activeBtn);
        click(statusBtn);
        staticWait(2000);
        Assert.assertEquals(getText(blockBtn), Constants.blockedStatus);
        staticWait(2000);
        click(blockBtn);
        click(statusBtn);
        Assert.assertEquals(getText(activeBtn), Constants.activeStatus);
    }

    public void verifyUserDirectedToProfilePage() {
        createGiftCard();
        click(profileLink);
        switchToWindow("1");
        staticWait(3000);
        Assert.assertEquals(getText(totalSpentText), Constants.totalSpentText);


    }

    public void verifyMessageIcon() {
        createGiftCard();
        click(profileLink);
        switchToWindow("1");
        staticWait(3000);
        click(messageIcon);
        String messageText = getAttribute(messageTextBox, "placeholder");
        Assert.assertEquals(messageText, Constants.messageText);

    }

    public void VerifyActiveGiftCard() {
        createGiftCard();
        scrollToElement(filterIcon);
        staticWait(2000);
        Assert.assertEquals(getText(giftCardStatus), Constants.activeStatus);


    }

    public void verifyStartDateRejectsChar() {
        verifyMandatoryFields();
        click(editBtn);
        click(startDate);
        actionEnterText(startDate, "vfhfuu");
        click(updateButton);
        Assert.assertEquals(getText(systemAlert), Constants.systemAlert);
        Assert.assertEquals(getText(clientDetailValidationMsg), Constants.ValidationMsg);


    }

    public void verifyEndDateRejectsChar() {
        verifyMandatoryFields();
        click(editBtn);
        click(startDate);
        actionEnterText(startDate, "bhgisdhvi");
        click(updateButton);
        Assert.assertEquals(getText(systemAlert), Constants.systemAlert);
        Assert.assertEquals(getText(clientDetailValidationMsg), Constants.ValidationMsg);


    }


}























