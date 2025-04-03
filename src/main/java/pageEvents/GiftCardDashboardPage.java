package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;


public class GiftCardDashboardPage extends BaseTest {
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
    public By amountCardText = By.cssSelector("div.d-none.checked-d-block> div:nth-child(3)>label");
    public By amountCard = By.cssSelector("div.d-none.checked-d-block> div:nth-child(3)");

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





}
