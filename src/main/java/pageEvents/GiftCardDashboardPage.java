package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;



public class GiftCardDashboardPage extends BaseTest {
    SidePannelPage pannel = new SidePannelPage();
    public By systemMsg = By.cssSelector("p.h2");
    public By giftCardDashBoardHeaderText = By.cssSelector("h1.header-title");
    public By whichStoreText = By.cssSelector("p.header-subtitle");
    public By storeDropDown = By.cssSelector("span.select2-selection__rendered[role='textbox']");
    public By storeDropDownList = By.cssSelector("ul.select2-results__options > li");
    public By whichStoreContinueBtn = By.cssSelector("button.btn-primary");
    public By storeName = By.cssSelector("h3.text-truncate");
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
    public By cardNoText = By.xpath("//label[text()='Card No']");
    public By fundingResourceText = By.xpath("//label[text()='Funding source']");
    public By memoText = By.xpath("//label[text()='Memo']");
    public By startDateText = By.xpath("//label[text()='Start Date:']");
    public By endDateText = By.xpath("//label[text()='Exp. Date:']");
    public By CardNoField = By.cssSelector("label.optional~input[name='cardNo']");
    public By validationMsg = By.cssSelector("div.alert-message>p");
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



    // Locators for Gift Cards For Sale

    public By giftCardsSaleLink = By.xpath("//a[normalize-space()='Gift Cards For Sale']");
    public By addBtn =By.xpath("//a[normalize-space()='Add']");
    public By faceValue =By.xpath("//input[@name='amount']");
    public By salePrice =By.xpath("//input[@name='salePrice']");
    public By refNum =By.xpath("//input[@name='referenceNo']");
    public By fundingSrc =By.xpath("//select[@name='fundSource']");//div[@class='master-body']//div[4]//label[1]
    public By fundingLabel =By.xpath("//div[@class='master-body']//div[4]//label[1]");
    public By availableQnty =By.xpath("//input[@name='qty']");
    public By date =By.xpath("//div[@class='input-group']//input[@name='saleDateRange']");
    public By startDay =By.xpath("//input[@name='startInDays']");
    public By expireDay =By.xpath("//input[@name='expireInDays']");
    public By memo =By.xpath("//textarea[@name='memo']");
    public By saveBtn=By.xpath("//button[normalize-space()='Save changes']");
    public By pickingLeftDate =By.xpath("//div[@class='drp-calendar left']//div//table//tbody//tr[3]//td[4]");
    public By afterGiftCardFOrSalePage = By.xpath("//p[contains(text(), \"share the link to your gift cards\")]");
    public By firstCardLink = By.xpath("(//div[@class='loaded']//div)[1]");
    public By endText = By.xpath("(//span[text()=\"Ended\"])[1]");
    public By dataSavedSuccessfully = By.xpath("//div[text()=\"Data saved successfully!\"]");

    public By storeMnager = By.cssSelector("div.fw-bold");
    public By issuedOn = By.xpath("//span[contains(text(),'Issued on:')]");
    public By issueBy = By.xpath("//span[contains(text(), 'Issued by:')]");
    public By editBtn = By.cssSelector("i.far.fa-edit");
    public By systemAlert = By.cssSelector("div.alert-message>h4");
    public By clientDetailValidationMsg = By.cssSelector("div.alert-message>p");
    public By statusBtn = By.cssSelector("span.me-2~div>button.btn~ul.p-1");
    public By blockBtn = By.cssSelector("span.me-2~div>button.btn-danger");
    public By activeBtn = By.cssSelector("span.me-2~div>button.btn-success");


    public static void LoginAsCustomerNew() {
        Log.info("Starting Login test - Entering username and password");


        String username = configReader.getProperty("customerNew");
        String password = configReader.getProperty("password");

        // Validate if username and password are present in the config file
        if (username == null || password == null) {
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }


    public String selectStore(int index) {
        click(storeDropDown);
        String getStoreName = clickElementFromList(storeDropDownList, index);
        return getStoreName;
    }


    public String[] offOptionalSettings() {
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
        return  maxAmountValue;

        return new String[]{maxAmountValue, storeManagerName};
    }

    public String[] onOptionalSettings() {
        Login();
        String storeManagerName = getText(storeMnager);
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(1);
        click(whichStoreContinueBtn);
        click(configurationBtn);


        waitForElementToBeVisible(amountField, 1000);
        actionEnterText(amountField, "100000");
        WebElement element = getWebElement(amountField);
        String maxAmountValue = element.getAttribute("value");
        click(saveConfiguration);

        return new String[]{maxAmountValue, storeManagerName};
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
        scrollToElement(giftCardDetailCardLink);
        staticWait(3000);
        click(giftCardDetailCardLink);


    }


    public void verifyInformationMsgNoActiveStore(){
        LoginAsCustomerNew();
    public void verifyInformationMsgNoActiveStore() {
        LoginAsCustomer();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        Assert.assertEquals(getText(systemMsg), Constants.noActiveStoreInfoMsg);
    }

    public void verifyGiftcardDashboardPage() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        Assert.assertEquals(getText(giftCardDashBoardHeaderText), Constants.GiftCardHeader);
        String name = selectStore(3);
        click(whichStoreContinueBtn);
        Assert.assertEquals(getText(storeName), name);
    }


    public void verifyGiftConfigurationPopup() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(4);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        Assert.assertEquals(getText(configurationPopupHeader), Constants.configurationPopupTitle);


    }


    public void verifyReferenceNoOptions() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(4);
        click(whichStoreContinueBtn);
        click(configurationBtn);
    public void verifyReferenceNoOptions() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(4);
        click(whichStoreContinueBtn);
        click(configurationBtn);

        if (isDisplayed(disabledToggleBtn, 3)) {
            Assert.assertEquals(getText(disabledText), Constants.DisabledText);
            click(disabledToggleBtn);
            Assert.assertEquals(getText(enableText), Constants.EnableText);
        } else if (isDisplayed(enabledToggleBth, 3)) {
            Assert.assertEquals(getText(enableText), Constants.EnableText);
        } else {
            throw new IllegalStateException("Main toggle button not found in expected states");
        }
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
        Assert.assertEquals(getText(textLocator), expectedText);
    }

    private void handleReferenceNoToggle() {
        if (isDisplayed(refernceNoDiableToggleBtn, 3)) {
            Assert.assertEquals(getText(referenceNoDisabledText), Constants.referenceNoDisabledText);
            click(refernceNoDiableToggleBtn);
            Assert.assertEquals(getText(referenceNoEnabledText), Constants.referenceNoEnabledText);
        } else if (isDisplayed(referenceNoEnableToggleBtn, 3)) {
            click(referenceNoEnableToggleBtn);
            Assert.assertEquals(getText(referenceNoDisabledText), Constants.referenceNoDisabledText);
            click(refernceNoDiableToggleBtn);
            Assert.assertEquals(getText(referenceNoEnabledText), Constants.referenceNoEnabledText);
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

        if (!isDisplayed((disabledToggleBtn), 1000)) {
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
        if (isDisplayed((fundingSourceDisableText), 1000)) {
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
            waitForElementToBeVisible(amountField,1000);actionEnterText(amountField,"100000");
            click(saveConfiguration);
            softAssert.assertEquals(storeName.toString(), name);

        } else {
            waitForElementToBeVisible(amountField,1000);actionEnterText(amountField,"100000");
            click(saveConfiguration);
            softAssert.assertEquals(storeName.toString(), name);

        }


    }


    public void verifyNullAmountValidationMsg() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        click(whichStoreContinueBtn);
        click(configurationBtn);
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
                waitForElementToBeVisible(amountField,3);actionEnterText(amountField,"100000");
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
                waitForElementToBeVisible(amountField,3);actionEnterText(amountField,"100000");
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

        amountFieldElement.click();
        // Bring focus and clear the field using multiple methods for reliability
        amountFieldElement.click(); // Focus the field

        String currentValue = amountFieldElement.getAttribute("value");
        System.out.println("Current Amount Field Value: " + currentValue);

        if (currentValue != null && !currentValue.isEmpty()) {
            try {
                amountFieldElement.clear();
                Thread.sleep(500);


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


    public void verifyOptionalSettings() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        String name = selectStore(6);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        if (isDisplayed(disabledToggleBtn, 10000)) {
            click(disabledToggleBtn);
            if (!isDisplayed(refernceNoDiableToggleBtn, 1000)) {
                click(referenceNoEnableToggleBtn);
            }
            if (!isDisplayed(fundingSourceDisableText, 1000)) {
                click(fundingSourceDiableToggleBtn);
            } else {
                waitForElementToBeVisible(amountField,1000);actionEnterText(amountField,"100000");
                click(saveConfiguration);
                softAssert.assertEquals(storeName.toString(), name);
            }


        } else {
            if (!isDisplayed(refernceNoDiableToggleBtn, 1000)) {
                click(referenceNoEnableToggleBtn);
            }
            if (!isDisplayed(fundingSourceDisableText, 1000)) {
                click(fundingSourceDiableToggleBtn);
            } else {
                waitForElementToBeVisible(amountField,1000);actionEnterText(amountField,"100000");
                click(saveConfiguration);
                softAssert.assertEquals(storeName.toString(), name);
            }


        }
    }
    public void verifyCrossButton() {
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        String name = selectStore(6);
        click(whichStoreContinueBtn);
        click(configurationBtn);
        click(crossBtn);
        Assert.assertEquals(storeName.toString(), name);

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

    public void verifyCustomerPopUp() {
        offOptionalSettings();
        staticWait(1000);
        waitForElementToBeVisible(issueNewGiftCardBtn, 1000);
        click(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
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
        Assert.assertEquals(getText(customerPhoneValidationMsg), Constants.ValidationMsg);
        Assert.assertEquals(getToolTipMessage(customerPhoneToolTip), Constants.phoneValidationToolTip);


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
        Assert.assertEquals(getText(customerEmailValidationMsg), Constants.ValidationMsg);
        Assert.assertEquals(getToolTipMessage(customerEmailToolTip), Constants.emailValidationToolTip);


    }

    public void verifyInvalidCustomerNameField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerName, 10000);
        actionEnterText(customerName, "rt");
        waitForElementToBeVisible(customerNameSearchBtn, 10000);
        click(customerNameSearchBtn);
        Assert.assertEquals(getText(noSearchResultText), Constants.noResultText);

    }

    public void verifyInitialAmountField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 1000);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        waitForElementToBeVisible(intialAmount, 1000);
        actionEnterText(intialAmount, "1000");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);

    }




    public void verifyInitialAmtEqualsMaxGiftAmount() {
        String maxConfiguredAmt = offOptionalSettings()[0];
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField, 10000);
        clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail, 1000);
        actionEnterText(customerEmail, "beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        waitForElementToBeVisible(intialAmount, 1000);
        actionEnterText(intialAmount, "100000");
        WebElement element = getWebElement(intialAmount);
        String maxIntialAmt = element.getAttribute("value");
        Assert.assertEquals(maxConfiguredAmt, maxIntialAmt);


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
        waitForElementToBeVisible(customerField, 1000);
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
        staticWait(1000);
       Assert.assertEquals(getToolTipMessage(referenceNoField), Constants.referenceNoTooltipMsg);
        Assert.assertEquals(getText(validationMsg), Constants.ValidationMsg);
    }

    public void verifyAdditionalFields() {
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
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        waitForElementToBeVisible(cardNoText, 1000);
        Assert.assertEquals(getText(cardNoText), Constants.cardNoText);
        Assert.assertEquals(getText(fundingResourceText), Constants.fundingResourceText);
        Assert.assertEquals(getText(memoText), Constants.memoText);
        Assert.assertEquals(getText(startDateText), Constants.startDateText);
        Assert.assertEquals(getText(endDateText), Constants.endDateText);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);

    }

    public void verifyCardNoRejectLessThan4NumericValues() {
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
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        staticWait(10000);
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
        Assert.assertEquals(type, Constants.cardNoDatatype);

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
        Assert.assertEquals(maxLength, Constants.memoMaxLength);

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

        waitForElementToBeVisible(amountField, 1000);
        actionEnterText(amountField, "100000");
        click(saveConfiguration);
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        WebElement element = getWebElement(fundingResourceField);
        String dataType = element.getAttribute("type");
        Assert.assertEquals(dataType, Constants.fundingSourceType);


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
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        Assert.assertEquals(getText(fundSourceOption), "HSBC");
    }


    public void selectDateTwoDaysAgo() {

        LocalDate twoDaysAgo = LocalDate.now().minusDays(2);
        int day = twoDaysAgo.getDayOfMonth();
        String xpath = "//td[contains(@class, 'off') and contains(@class, 'disabled') and normalize-space(text())='" + day + "']";
        getDriver().findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        WebElement dateElement = getDriver().findElement(By.xpath(xpath));
        String classes = dateElement.getAttribute("class");
        if (classes.contains("disabled")) {
            System.out.println("The date " + twoDaysAgo + " is disabled.");
        } else {
            dateElement.click();
            System.out.println("Selected date: " + twoDaysAgo);
        }
    }
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

    public void getForSaleBtn(){
       click(giftCardsSaleLink);
    }

    public void verifyUserDirection(){

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
    softAssert.assertTrue(isDisplayed(fundingLabel,3));
    softAssert.assertTrue(isElementDisplayed(availableQnty));
    softAssert.assertTrue(isElementDisplayed(date));
    softAssert.assertTrue(isElementDisplayed(startDay));
    softAssert.assertTrue(isElementDisplayed(expireDay));
    softAssert.assertTrue(isElementDisplayed(memo));
    softAssert.assertAll();

    }

//84
    public void verifyFaceValueAmountField(){
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

        String maxLen= element.getAttribute("max");
        System.out.println(maxLen);           //maxlinit is 1000.00
        String amt="100000";
        actionEnterText(faceValue,amt);    //10000.00
        String afterEnter= getText(faceValue);
        System.out.println(afterEnter);
        System.out.println("faceValue take input only 1000 as maximum limit is 1000");
        staticWait(3000);
        Assert.assertEquals(maxLen,"1000.00");
        staticWait(3000);


    }
    //85
    public void verifyFaceValueFieldAccept(){
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(faceValue,"asd100000");
        Log.info("Only enters numeric value so expected would be 1000.00 which is max");
        WebElement element = getWebElement(faceValue);
        String maxLen= element.getAttribute("max");
        Assert.assertEquals(maxLen,"1000.00");   //assert 1000.00 which is being entered with max
        staticWait(3000);

    }
//86
    public void verifySalePriceFieldAccept(){
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(salePrice,"asd150000");
        Log.info("Only enters numeric value so expected would be 1000.00 which is max");
        WebElement element = getWebElement(salePrice);
        String maxLen= element.getAttribute("max");
        Assert.assertEquals(maxLen,"1500.00");   //assert 1500.00 which is being entered with max
        staticWait(3000);

    }
    public void verifyUserAllowedToEnterMaximumValue(){
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(salePrice,"150000");
        Log.info("Only enters numeric value so expected would be 1000.00 which is max");
        WebElement element = getWebElement(salePrice);
        String maxLen= element.getAttribute("max");
        Assert.assertEquals(maxLen,"1500.00");   //assert only 1500.00 which is being entered, with max
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
        actionEnterText(faceValue,"15000");
        actionEnterText(salePrice,"17000");
        actionEnterText(refNum,"abc123");
        actionEnterText(availableQnty,"5");
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
    public void verifyPastStartDatesDisabled () {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        click(startDate);
        selectDateTwoDaysAgo();


    }
    public void verifyPastEndDateDisabled () {

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
        actionEnterText(startDate, requiredString(5));
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
        Assert.assertEquals(getToolTipMessage(startDate), Constants.invalidDateTooltip);
        Assert.assertEquals(getText(validationMsg), Constants.ValidationMsg);
        waitForElementToBeVisible(createButton, 1);
        click(createButton);
        staticWait(2000);
        softAssert.assertEquals(getText(validationMsg), Constants.ValidationMsg);
        softAssert.assertEquals(getToolTipMessage(startDate), Constants.invalidDateTooltip);


    }

    public void verifyEndDateRejectsCharacters() {
    public void verifyEndDateRejectsCharacters () {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        click(endDate);
        getDriver().findElement(endDate).sendKeys("asshiidnh");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton, 1000);
        click(createButton);
        Assert.assertEquals(getToolTipMessage(endDate), Constants.invalidDateTooltip);
        Assert.assertEquals(getText(validationMsg), Constants.ValidationMsg);
        waitForElementToBeVisible(createButton, 1);
        click(createButton);
        softAssert.assertEquals(getToolTipMessage(endDate), Constants.invalidDateTooltip);
        softAssert.assertEquals(getText(validationMsg), Constants.ValidationMsg);

    }


    public void verifyFundingSrcFieldAppear (String actionType){

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

    public void verifyAvailableQuantityFieldLength () {
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

    public void verifyAvailableQuantityAcceptsNumbers(){
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


    public void verifyRefNoValidation(){

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        String max_char = getAttribute(referenceNoField,"maxlength");
        Log.info("Maximum char limit is : " + max_char);
        Assert.assertEquals(max_char, "30", "Max character limit is not 30");

    }

    private String getExpectedDateRange() {
        LocalDate today = LocalDate.now();
        LocalDate nextYear = today.plusYears(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        return formatter.format(today) + " - " + formatter.format(nextYear);
    }

    public void verifyDefaultDateRange(){

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

    public void verifyDateRange(){

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
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        Assert.assertEquals(getText(fundSourceOption), "HSBC");

    }

    public void verifyMemoFieldMaximumChar (){

        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        scrollToElement(memo);
        String max_char = getAttribute(memo,"maxlength");
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
        waitForElementToBeClickable(firstCardLink,5);
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
        public void verifyStatusOfGiftCard(){
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
        actionEnterText(date,"05/04/2023 - 05/04/2024");
        waitForElementToBeClickable(saveBtn, 2);
        staticWait(6000);
        click(saveBtn);
        staticWait(3000);
        Assert.assertTrue(isElementDisplayed(afterGiftCardFOrSalePage));
        waitForElementToBeVisible(endText,5);
        staticWait(5000);
        String status = getText(endText);
        Assert.assertEquals(status, "Ended", "Status is not Active");

        }
@Test
    public void verifyUpdateSaleGiftCard() {

        offOptionalSettings();
        staticWait(2000);
        click(infoIcon);
        WebElement element = getWebElement(giftCardHeaderText);
        String cardNumber = element.getText().split(":")[1].trim();
        System.out.println(cardNumber);
        String issuedOnActualText = getText(issuedOn);
        String issuedOnexpectedText = DateStringGenerator();
        Assert.assertEquals(issuedOnActualText, issuedOnexpectedText);
        Assert.assertEquals(getText(issueBy), issueByActualText);
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
        waitForElementToBeClickable(firstCardLink,5);
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
        waitForElementToBeVisible(dataSavedSuccessfully,5);
        Assert.assertTrue(isElementDisplayed(dataSavedSuccessfully));



    }


    public void verifyEditBtn() {
        createGiftCard();
        click(editBtn);
        Assert.assertEquals(getText(fundingResourceText), Constants.fundingResourceText);
        Assert.assertEquals(getText(memoText), Constants.memoText);
        Assert.assertEquals(getText(startDateText), Constants.startDateText);
        Assert.assertEquals(getText(endDateText), Constants.endDateText);

    }
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

    public void verifyStartDateRejectsChar() {
        verifyMandatoryFields();
        click(editBtn);
        click(startDate);
        actionEnterText(startDate, "vfhfuu");
        click(updateButton);
        Assert.assertEquals(getText(systemAlert),Constants.systemAlert);
        Assert.assertEquals(getText(clientDetailValidationMsg),Constants.ValidationMsg);


    }
    public void verifyEndDateRejectsChar() {
        verifyMandatoryFields();
        click(editBtn);
        click(startDate);
        actionEnterText(startDate, "bhgisdhvi");
        click(updateButton);
        Assert.assertEquals(getText(systemAlert),Constants.systemAlert);
        Assert.assertEquals(getText(clientDetailValidationMsg),Constants.ValidationMsg);


    }
    public void verifyStatusChange(){
        createGiftCard();
        click(activeBtn);
        click(statusBtn);
        staticWait(2000);
        Assert.assertEquals(getText(blockBtn),Constants.blockedStatus);
        staticWait(2000);
        click(blockBtn);
        click(statusBtn);
        Assert.assertEquals(getText(activeBtn),Constants.activeStatus);
    }

}