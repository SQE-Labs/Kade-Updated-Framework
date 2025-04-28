package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
    public By storeMnager = By.cssSelector("div.fw-bold");
    public By issuedOn = By.xpath("//span[contains(text(),'Issued on:')]");
    public By issueBy = By.xpath("//span[contains(text(), 'Issued by:')]");
    public By editBtn = By.cssSelector("i.far.fa-edit");
    public By fundingSourceOptionalField = By.xpath("//label[text()='Funding source']");




    public String DateStringGenerator()
        {
            LocalDate currentDate = LocalDate.now(); // or any specific date: LocalDate.of(2025, 4, 15)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = currentDate.format(formatter);

            String result = "Issued on: " + formattedDate;
             return result;
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

        return new String[] { maxAmountValue, storeManagerName };
    }







    public void createGiftCard(){
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
        staticWait(2000);
        click(infoIcon);

    }



    public void verifyInformationMsgNoActiveStore(){
        LoginAsCustomer();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        softAssert.assertEquals(getText(systemMsg), Constants.noActiveStoreInfoMsg);
    }
    public void verifyGiftcardDashboardPage(){
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        softAssert.assertEquals(getText(giftCardDashBoardHeaderText), Constants.GiftCardHeader);
        String name = selectStore(3);
        click(whichStoreContinueBtn);
        softAssert.assertEquals(getText(storeName), name);
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

        if (!isDisplayed((disabledToggleBtn), 1000)) {
            click(enabledToggleBth);
            softAssert.assertEquals(getText(disabledText), Constants.DisabledText);
            click(disabledToggleBtn);
            softAssert.assertEquals(getText(enableText), Constants.EnableText);
        } else {
            softAssert.assertEquals(getText(disabledText), Constants.DisabledText);
            click(disabledToggleBtn);
            softAssert.assertEquals(getText(enableText), Constants.EnableText);
        }

        handleSourceFundingToggle();
    }

    private void handleSourceFundingToggle() {
        if (isDisplayed((fundingSourceDisableText), 1000)) {
            softAssert.assertEquals(getText(fundingSourceDisableText), Constants.sourceFundingDisabledText);
            click(fundingSourceDiableToggleBtn);
            softAssert.assertEquals(getText(fundingSourceEnabledText), Constants.getSourceFundingEnabledText);
        } else {
            click(fundingSourceDiableToggleBtn);
            softAssert.assertEquals(getText(fundingSourceDisableText), Constants.sourceFundingDisabledText);
            click(fundingSourceEnableToggleBtn);
            softAssert.assertEquals(getText(fundingSourceEnabledText), Constants.sourceFundingDisabledText);
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
            softAssert.assertEquals(isDisplayed(amountCardText, 3), "true");
        } else {
            click(enabledToggleBth);
            click(disabledToggleBtn);
            softAssert.assertEquals(isDisplayed(amountCardText, 3), "true");
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

    WebElement amountFieldElement = getWebElement(amountField);

    amountFieldElement.click();

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
        staticWait(1000);waitForElementToBeVisible(issueNewGiftCardBtn,1000); click(issueNewGiftCardBtn);
        softAssert.assertEquals(getText(giftCardHeader), Constants.giftCardHeaderText);

    }

    public void verifyCustomerPopUp() {
        offOptionalSettings();
        staticWait(1000);
        waitForElementToBeVisible(issueNewGiftCardBtn,1000);
        click(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        softAssert.assertEquals(getText(customerTitleText), Constants.customerPopupTitle);


    }

    public void verifyInvalidCustomerPhoneField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerPhoneNo,1000);actionEnterText(customerPhoneNo,"1");
        click(customerPhoneSearchBtn);
        softAssert.assertEquals(getText(customerPhoneValidationMsg), Constants.ValidationMsg);
        softAssert.assertEquals(getToolTipMessage(customerPhoneToolTip), Constants.phoneValidationToolTip);


    }

    public void verifyInvalidCustomerEmailField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail,1000); actionEnterText(customerEmail,"r");
        clickElementByJS(customerEmailSearchBtn);
        softAssert.assertEquals(getText(customerEmailValidationMsg), Constants.ValidationMsg);
        softAssert.assertEquals(getToolTipMessage(customerEmailToolTip), Constants.emailValidationToolTip);


    }
    public void verifyInvalidCustomerNameField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerName,10000);     actionEnterText(customerName,"rt");
        waitForElementToBeVisible(customerNameSearchBtn,10000);click(customerNameSearchBtn);
        softAssert.assertEquals(getText(noSearchResultText), Constants.noResultText);

    }

    public void verifyInitialAmountField() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail,1000); actionEnterText(customerEmail,"beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        waitForElementToBeVisible(intialAmount,1000);actionEnterText(intialAmount,"1000");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton,1000);click(createButton);

    }




    public void verifyInitialAmtEqualsMaxGiftAmount() {
        String maxConfiguredAmt= offOptionalSettings()[0];
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail,1000); actionEnterText(customerEmail,"beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        waitForElementToBeVisible(intialAmount,1000);actionEnterText(intialAmount,"100000");
        WebElement element = getWebElement(intialAmount);
        String maxIntialAmt = element.getAttribute("value");
        softAssert.assertEquals(maxConfiguredAmt,maxIntialAmt);


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
        waitForElementToBeVisible(customerField,1000); clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail,1000); actionEnterText(customerEmail,"beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
       waitForElementToBeVisible(intialAmount,1000); actionEnterText(intialAmount,"100000");
        staticWait(1000);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton,1000);click(createButton);
        staticWait(1000);
        softAssert.assertEquals(getToolTipMessage(referenceNoField), Constants.referenceNoTooltipMsg);
    }

    public void verifyAdditionalFields() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail,1000); actionEnterText(customerEmail,"beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount,1000); actionEnterText(intialAmount,"100000");
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        waitForElementToBeVisible(cardNoText, 1000);
        softAssert.assertEquals(getText(cardNoText), Constants.cardNoText);
        softAssert.assertEquals(getText(fundingResourceText), Constants.fundingResourceText);
        softAssert.assertEquals(getText(memoText), Constants.memoText);
        softAssert.assertEquals(getText(startDateText), Constants.startDateText);
        softAssert.assertEquals(getText(endDateText), Constants.endDateText);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton,1000);click(createButton);

    }

    public void verifyCardNoRejectLessThan4NumericValues() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail,1000); actionEnterText(customerEmail,"beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount,1000); actionEnterText(intialAmount,"100000");
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        staticWait(10000);
        actionEnterText(CardNoField, "12");
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton,1000);click(createButton);
        softAssert.assertEquals(getToolTipMessage(CardNoField), Constants.cardMinLendthMsg);
        softAssert.assertEquals(getText(validationMsg),Constants.ValidationMsg);


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
        softAssert.assertEquals(type,Constants.cardNoDatatype);

    }


    public void verifyCardNoAccepts18NumericValues () {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        staticWait(10000);
        WebElement element = getWebElement(CardNoField);
        String maxLength = element.getAttribute("maxlength");
        softAssert.assertEquals(maxLength,Constants.maxLength);
     }
    public void verifyMemoAccepts500Values () {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        WebElement element = getWebElement(memoField);
        String maxLength = element.getAttribute("maxlength");
        softAssert.assertEquals(maxLength,Constants.memoMaxLength);

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
        softAssert.assertEquals(dataType,Constants.fundingSourceType);


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
        softAssert.assertEquals(getText(fundSourceOption), "HSBC");
    }



        public void selectDateTwoDaysAgo(){

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
        actionEnterText(startDate, requiredString(5));
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton,1000);click(createButton);
        softAssert.assertEquals(  getToolTipMessage(startDate), Constants.invalidDateTooltip);
        softAssert.assertEquals(getText(validationMsg), Constants.ValidationMsg);


    }
    public void verifyEndDateRejectsCharacters() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        scrollToElement(moreOptionsBtn);
        clickElementByJS(moreOptionsBtn);
        click(startDate);
        actionEnterText(startDate, requiredString(5));
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton,1000);click(createButton);
        softAssert.assertEquals(getToolTipMessage(endDate), Constants.invalidDateTooltip);
        softAssert.assertEquals(getText(validationMsg), Constants.ValidationMsg);

    }

    public void verifyGiftCardDetailPopUp() {
        offOptionalSettings();
        staticWait(1000);
        clickElementByJS(issueNewGiftCardBtn);
        waitForElementToBeInteractable(customerField,10000);clickElementByJS(customerField);
        waitForElementToBeVisible(customerEmail,1000); actionEnterText(customerEmail,"beanBliss@yopmail.com");
        clickElementByJS(customerEmailSearchBtn);
        staticWait(1000);
        waitForElementToBeVisible(intialAmount,1000); actionEnterText(intialAmount,"100000");
        staticWait(1000);
        scrollToElement(createButton);
        waitForElementToBeVisible(createButton,1000);click(createButton);
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
      String storeManagerName =  offOptionalSettings()[1];
      String issueByActualText=  "Issued on: " + storeManagerName;
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
        String issuedOnexpectedText =  DateStringGenerator();
        softAssert.assertEquals(issuedOnActualText, issuedOnexpectedText);
        softAssert.assertEquals(getText(issueBy), issueByActualText);



    }


    public void verifyEditBtn() {
        createGiftCard();
        click(editBtn);
        softAssert.assertEquals(getText(fundingResourceText), Constants.fundingResourceText);
        softAssert.assertEquals(getText(memoText), Constants.memoText);
        softAssert.assertEquals(getText(startDateText), Constants.startDateText);
        softAssert.assertEquals(getText(endDateText), Constants.endDateText);

    }

    public void verifyFundingResourceOptional(){
        createGiftCard();
        click(editBtn);
        WebElement element = getWebElement(fundingResourceField);
        String dataType = element.getAttribute("type");
        softAssert.assertEquals(dataType,Constants.fundingSourceType);
    }

}











