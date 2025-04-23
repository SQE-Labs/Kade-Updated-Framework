package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;


public class GiftCardDashboardPage extends BaseTest {

    SidePannelPage Pannel = new SidePannelPage();
    public By giftCardDashBoardHeaderText = By.cssSelector("h1.header-title");
    public By whichStoreText = By.cssSelector("p.header-subtitle");
    public By storeDropDown = By.cssSelector("span.select2-selection__rendered[role='textbox']");
    public By storeDropDownList = By.cssSelector("ul.select2-results__options > li");
    public By whichStoreContinueBtn = By.cssSelector("button.btn-primary");
    public By storeName= By.cssSelector("h3.text-truncate");
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
    public By customerField = By.cssSelector(".modal-content .stretched-link.-selectCustomer-");
    public By customerTitleText = By.cssSelector("div.modal-content>div.modal-header>h5.modal-title>span.me-1");
    public By customerPhoneNo = By.cssSelector("input[name='phone']");
    public By customerName = By.cssSelector("input[name='phrase']");
    public By customerEmail = By.cssSelector("input[name='email']");
    public By customerEmailToolTip = By.cssSelector("input[name='email'].form-control.is-invalid");
    public By customerPhoneValidationMsg =  By.xpath("(//form[@action=\"/api/Stores/searchCustomer\"]//div[contains(text(), \"Please review\")])[1]");
    public By customerPhoneSearchBtn = By.cssSelector("input[name='phone']~button.btn");
    public By customerEmailSearchBtn = By.cssSelector("input[name='email']~button.btn");
    public By customerEmailValidationMsg =  By.xpath("(//form[@action=\"/api/Stores/searchCustomer\"]//div[contains(text(), \"Please review\")])[1]");
    public By customerPhoneToolTip = By.cssSelector("input[name='phone'].form-control.is-invalid");
    public By  noSearchResultText = By.cssSelector("div.p-2>div.w-100>div~p");
    public By customerNameSearchBtn = By.cssSelector("input[name='phrase']~button.btn>i.far");
    public By doneBtn = By.cssSelector("button.btn.btn-link.w-100.my-3");
    public By intialAmount = By.cssSelector("input[name='initialAmount']");
    public By createButton = By.cssSelector("button.btn.btn-success.btn-lg.w-100");
    public By referenceNoField = By.cssSelector("input[name='referenceNo']");
    public By moreOptionsBtn = By.cssSelector("div.d-flex.justify-content-between ~ a.p-0.mb-1");
    public By cardNoText = By.xpath("//label[text()='Card No']");
    public By CardNoField = By.cssSelector("label.optional~input[name='cardNo']");
    public By validationMsg = By.cssSelector("div.alert-message>p");
    public By memoField = By.cssSelector("textarea[name='greetingMessage']");

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

   public String selectStore(int index){
       click(storeDropDown);
       String getStoreName = clickElementFromList(storeDropDownList,index);
       return getStoreName;
   }
    public void clickWhichStoreContinueBtn(){ click(whichStoreContinueBtn);}
    public void clickConfigurationButton(){click(configurationBtn);}
    public String getConfigurationPopupText(){return getText(configurationPopupHeader);}
    public String getDisabledText(){return getText(disabledText);}
    public void enableToggleButton(){ click(disabledToggleBtn);}
    public void disableToggleButton(){ click(enabledToggleBth);}
    public String getReferenceNoDisabledText(){ return getText(referenceNoDisabledText);}
    public String getReferenceNoEnabledText(){ return getText(referenceNoEnabledText);}
    public void enableReferenceNoEnableToggleBtn(){ click(refernceNoDiableToggleBtn);}
    public void disableReferenceNoEnableToggleBtn(){ click(referenceNoEnableToggleBtn);}
    public String getFundingSourceDisabledText(){ return getText(fundingSourceDisableText);}
    public String getFundingSourceEnabledText(){ return getText(fundingSourceEnabledText);}
    public void enableFundingSourceEnableToggleBtn(){ click(fundingSourceEnableToggleBtn);}
    public void disableFundingSourceEnableToggleBtn(){ click(fundingSourceDiableToggleBtn);}
    public void clickSaveConfigurationBtn(){ click(saveConfiguration);}
    public void enterAmount(){waitForElementToBeVisible(amountField,1000);actionEnterText(amountField,"100000");}
    public void enterTextSourceFunding(){SendKeys(sourceFundingText,"");}
    public String getCardAmountValidationMeg(){return getText(cardAmountValidationMsg);}
    public void clickCrossIcon(){click(crossBtn);}
    public void clickIssueNewGiftCardBtn(){staticWait(1000);waitForElementToBeVisible(issueNewGiftCardBtn,1000); click(issueNewGiftCardBtn);}
    public String getGiftCardHeader(){return getText(giftCardHeader);}
    public String getCustomerTitle(){return getText(customerTitleText);}
    public void clickCustomerField(){waitForElementToBeClickable(customerField,1000);clickElementByJS(customerField);}
    public void setCustomerPhoneNo(String number){waitForElementToBeVisible(customerPhoneNo,1000);actionEnterText(customerPhoneNo,number);}
    public void clickPhoneSearchBtn(){click(customerPhoneSearchBtn);}
    public String getPhoneValidationMsgText(){return getText(customerPhoneValidationMsg);}
    public String geEmailValidationMsgText(){waitForElementToBeVisible(customerEmailValidationMsg,1000);return getText(customerEmailValidationMsg);}
    public void setCustomerName(String name){waitForElementToBeVisible(customerName,10000);     actionEnterText(customerName,name);}
    public String getNoSearchResultText(){return getText(noSearchResultText);}
    public void setCustomerEmail(String email){staticWait(1000);actionEnterText(customerEmail,email);}
    public void clickEmailSearchBtn(){staticWait(1000);waitForElementToBeVisible(customerEmailSearchBtn,10000);click(customerEmailSearchBtn);}
    public void clickCustomerNameSearchBtn(){waitForElementToBeVisible(customerNameSearchBtn,10000);click(customerNameSearchBtn);}
    public String getEmailValidationToolTip(){return getToolTipMessage(customerEmailToolTip);}
    public String getPhoneValidationToolTip(){return getToolTipMessage(customerPhoneToolTip);}
    public void clickCreateBtn(){waitForElementToBeVisible(createButton,1000);click(createButton);}
    public void clickDoneBtn(){waitForElementToBeVisible(doneBtn,1000);click(doneBtn);}
    public void setIntialAmount(String amt){staticWait(10000);   waitForElementToBeVisible(intialAmount,1000);actionEnterText(intialAmount,amt);}
    public  String getReferenceNoToolTip(){ return getToolTipMessage(referenceNoField);}
    public void clickMoreOptionsBtn(){staticWait(10000);waitForElementToBeVisible(moreOptionsBtn,1000);clickElementByJS(moreOptionsBtn);}
    public String getCardNoText(){waitForElementToBeVisible(cardNoText,1000);return getText(cardNoText);}
    public void setCardNo(String No){staticWait(10000);actionEnterText(CardNoField,No);}
    public String getCardNoValidationToolTip(){return getToolTipMessage(CardNoField);}
    public String getCardNoValidationMsg(){return getText(validationMsg);}



    // Gift Cards for sale
//83

    public void getForSaleBtn(){
       click(giftCardsSaleLink);
    }

    public void verifyUserDirection(){

    Login();
    Pannel.getMangeBusinessTab();
    Pannel.getGiftCardsDashboardTab();
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
        Pannel.getMangeBusinessTab();
        Pannel.getGiftCardsDashboardTab();
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
        Pannel.getMangeBusinessTab();
        Pannel.getGiftCardsDashboardTab();
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
        Pannel.getMangeBusinessTab();
        Pannel.getGiftCardsDashboardTab();
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
        Pannel.getMangeBusinessTab();
        Pannel.getGiftCardsDashboardTab();
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
    @Test
    public void verifyFieldsAppearMandatory() {
        Login();
        Pannel.getMangeBusinessTab();
        Pannel.getGiftCardsDashboardTab();
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
@Test
    public void verifyValidationLeavingFieldsBlank(){

        Login();
        Pannel.getMangeBusinessTab();
        Pannel.getGiftCardsDashboardTab();
        selectStore(5);
        clickWhichStoreContinueBtn();
        getForSaleBtn();
        staticWait(3000);
        click(addBtn);
        actionEnterText(faceValue,"15000");
        actionEnterText(salePrice,"17000");

        staticWait(5000);
        clickElementByJS(saveBtn);
        staticWait(2000);
        hoverOverElement(availableQnty);
        staticWait(2000);
        String message=getToolTipMessage(availableQnty);
        Assert.assertEquals(message, Constants.emptyFieldTooltip);

        Log.info("Validate tooltip");



    }
    public void verifyFundingSrcFieldAppear(String actionType) {

        if (actionType.equals("Optional")) {
            Login();
            Pannel.getMangeBusinessTab();
            Pannel.getGiftCardsDashboardTab();
            selectStore(5);
            clickWhichStoreContinueBtn();
            getForSaleBtn();
            staticWait(3000);
            click(addBtn);
        } else {
            Login();
            Pannel.getMangeBusinessTab();
            Pannel.getGiftCardsDashboardTab();
            selectStore(5);
            clickWhichStoreContinueBtn();
            getForSaleBtn();
            staticWait(3000);
            click(addBtn);
        }
    }
@Test
    public void verifyAvailableQuantityFieldLength(){
            Login();
            Pannel.getMangeBusinessTab();
            Pannel.getGiftCardsDashboardTab();
            selectStore(5);
            clickWhichStoreContinueBtn();
            getForSaleBtn();
            staticWait(3000);
            click(addBtn);

            String length = getAttribute(availableQnty,"maxlength");
            Log.info("Maximum length is" + " " + length);
        }





    }








