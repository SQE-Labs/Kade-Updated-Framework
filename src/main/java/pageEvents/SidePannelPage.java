package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;

public class SidePannelPage extends BaseTest {

    public By profileLink = By.xpath("//a[@class='btn btn-link p-0 fs-pn15 ']");
    By validationMessage=By.xpath("//p[@class='alert-content']");
    public By billBtn = By.cssSelector(".sidebar-nav > li:nth-child(5)");
    By transactionsButton=By.cssSelector(".sidebar-nav > li:nth-child(4)");
    public By myStoreBtn=By.cssSelector(".fa-fw.fas.fa-store");
    By giftCardsDashboardTab=By.xpath("//a[text()='Gift Cards Dashboard']");
    By pageHeader=By.xpath("//h1[@class='header-title mb-0']");
    By reportBtn=By.xpath("(//a[@class='sidebar-link'])[11]");
    By signOutBtn = By.xpath("//a[text()='Sign out']");
    By qrCodeDashboardBtn = By.xpath("//a[text()='QR Code Dashboard']");
    public By manageBusinessAcc = By.xpath("//li[@class='sidebar-item mb-2 bg-light']/ a[text()='Manage Business']");
    By CustomersBtn = By.cssSelector(".fa-fw.fas.fa-user-friends");
    public By dashboardTab = By.cssSelector("[href='/Stores/dashboard']");
    By RewardsProgramPage = By.xpath("//a[text()='Rewards Program']");
    By SearchBtn = By.cssSelector(".fa-search");
    public By myStuff = By.xpath("//a[text()='My Stuff']");
    public By giftCardsTab = By.cssSelector("[href='/Giftcards/GiftCardsSummary']");
    public By securityAndPasswordTab = By.xpath("//a[text()='Security and Password']");




    // Methods
    public void getMangeBusinessTab(){
        click(manageBusinessAcc);
    }

    public void getDashboardTab(){
        click(dashboardTab);
    }
    public void getSignOut(){
        click(signOutBtn);
    }

    public void getMyStoreTab(){
        click(myStoreBtn);
    }

    public void getTransactionTab(){
        click(transactionsButton);
    }
    public void getBillBtn(){
        click(billBtn);
    }
    public void getSearchTab(){
        click(SearchBtn);
    }
    public void getProfileLink(){
        click(profileLink);
    }
    public void getMyStuff(){
        click(myStuff);
    }
    public void getGiftCardTab(){
        click(giftCardsTab);
    }
    public void getSecurityAndPasswordTab(){
        click(securityAndPasswordTab);
    }
}
