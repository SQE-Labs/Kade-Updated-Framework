package pageEvents;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends BaseTest {
    By adminDashboardBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(2)");
    By adminTransactionBtn =By.cssSelector(".sidebar-item.text-danger:nth-child(3)");
    By findStoreLink =By.xpath("//a[@href='/Admin/Stores']");
    By dashboardPageTitle = By.cssSelector(".header-title.mb-0");
    By filterIcon = By.cssSelector(".ps-1.pt-2>a");
    By findStoreBtn = By.cssSelector("a[href=\"/Admin/Stores\"]");
    By storeNameField = By.cssSelector("input[name=\"name\"].form-control.max-20c");
    By applyBtn = By.cssSelector("button.btn.btn-outline-primary.btn-sm");
    By clickStore = By.cssSelector(".d-flex.flex-column.overflow-hidden .ms-2.text-truncate");
    By blockBtn = By.cssSelector(".fal.fa-circle.custom-check-off");
    By statusTextBox = By.cssSelector(".form-control[maxlength=\"250\"]");
    By updateStatusBtn = By.xpath("//button[text()='Update Status']");
    By deleteBtn = By.cssSelector("button[href=\".-deleteStore-\"]");
    By deleteStoreNameField = By.cssSelector("input[name=\"name\"][required]");
    By clickPermanentDeleteBtn = By.xpath("//button[text()='Delete Permanently']");
    By clickFirstResult = By.cssSelector(".ms-2.text-truncate:nth-child(1)");
    By getStoreName = By.cssSelector(" .d-flex .ms-2.text-truncate:nth-child(1)");
    By ownerEmail = By.xpath("(//span[@class='position-relative'])[1]");
    By selectStatus=By.cssSelector("#storeStatus");
    By storeName = By.xpath("(//span[@class='ms-2 text-truncate'])[1]");

    public void getFindStoreLink(){
        click(findStoreLink);
    }
    public void getFilterIcon(){
        click(filterIcon);
    }
    public void getApplyBtn(){
        click(applyBtn);
    }
    public void getStoreBtn(){
        click(clickStore);
    }
    public void getBlockBtn(){
        clickElementByJS(blockBtn);
    }
    public void getUpdateStatusBtn(){
        clickElementByJS(updateStatusBtn);
    }
    public void getDeleteBtn(){
        staticWait(3000);
        clickElementByJS(deleteBtn);
    }
    public void getEditDeleteStoreNameBox(){
        click(deleteStoreNameField);
    }
    public void getPermanentDeleteBtn(){
        scrollToElement(clickPermanentDeleteBtn);
        clickElementByJS(clickPermanentDeleteBtn);
    }
    public void getFirstResult(){
        click(clickFirstResult);
    }




    public void selectedStoreDeleted(String storeName){
        LoginAsAdmin();
        getFindStoreLink();
        getFilterIcon();
        enterText(storeNameField,storeName);
        System.out.println(storeName);
        getApplyBtn();
        getStoreBtn();
        scrollToElement(blockBtn);
        staticWait(3000);
        getBlockBtn();
        enterText(statusTextBox, "deleted the store");
        getUpdateStatusBtn();
        scrollToElement(deleteBtn);
        getDeleteBtn();
        enterText(deleteStoreNameField,"Final Delete");
        getPermanentDeleteBtn();
    }

    public void ToDeleteStores() {
        LoginAsAdmin();
        getFindStoreLink();
        getFilterIcon();
        enterText(storeNameField,"AutoStore");
        selectDropdownByVisibleText(selectStatus,"Active");
        getApplyBtn();
        staticWait(3000);
       String text = getText(ownerEmail);
        Log.info(text);
        System.out.println(ownerEmail);

        if (text.equals("test1114@yopmail.com")){
            List<WebElement> storeElements = getDriver().findElements(By.cssSelector(".ms-2.text-truncate"));
            int elementcount = storeElements.size();
            while (elementcount > 0) {
                String storename=getText(storeName);
//           for(WebElement store : storeElements){
                staticWait(2000);
               getFirstResult();
               // store.click();
                scrollToElement(blockBtn);
                staticWait(3000);
                getBlockBtn();
                enterText(statusTextBox, "deleted the store");
                getUpdateStatusBtn();
                scrollToElement(deleteBtn);
                getDeleteBtn();
                staticWait(2000);

               enterText(deleteStoreNameField,storename);
               staticWait(3000);
               getPermanentDeleteBtn();
               staticWait(3000);

               getFilterIcon();
               enterText(storeNameField,"AutoStore");
               getApplyBtn();
               storeElements = getDriver().findElements(By.cssSelector(".ms-2.text-truncate"));
               elementcount = storeElements.size();
            }
        }


    }
}
