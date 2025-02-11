package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;

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
    By blockBtn = By.cssSelector(".fal.fa-circle.custom-check-off ");
    By statusTextBox = By.cssSelector(".form-control[maxlength=\"250\"]");
    By updateStatusBtn = By.xpath("//button[text()='Update Status']");
    By deleteBtn = By.cssSelector("button[href=\".-deleteStore-\"]");
    By deleteStoreNameField = By.cssSelector("input[name=\"name\"][required]");
    By clickPermanentDeleteBtn = By.xpath("//button[text()='Delete Permanently']");
    By clickFirstResult = By.cssSelector(".ms-2.text-truncate:nth-child(1)");
    By getStoreName = By.cssSelector(" .d-flex .ms-2.text-truncate:nth-child(1)");
    By ownerEmail = By.cssSelector("a.me-1 +div >a+span");

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
        click(blockBtn);
    }
    public void getUpdateStatusBtn(){
        click(updateStatusBtn);
    }
    public void getDeleteBtn(){
        click(deleteBtn);
    }
    public void getEditDeleteStoreNameBox(){
        click(deleteStoreNameField);
    }
    public void getPermanentDeleteBtn(){
        click(clickPermanentDeleteBtn);
    }




    public void selectedStoreDeleted(String storeName){
        LoginAsAdmin();
        getFindStoreLink();
        getFilterIcon();
        enterText(storeNameField,storeName);
        System.out.println(storeName);
        getApplyBtn();
        getStoreBtn();
        getBlockBtn();
        enterText(statusTextBox, "deleted the store");
        getUpdateStatusBtn();
        getDeleteBtn();
        enterText(deleteStoreNameField,"Final Delete");
        getPermanentDeleteBtn();


    }
}
