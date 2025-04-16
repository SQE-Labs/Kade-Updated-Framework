package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;

public class GiftCardPage extends BaseTest {

    // Locators
    public By noResultIcon = By.cssSelector(".no-result-icon");
    public By infoMsg = By.cssSelector(".no-result-icon +p");
    public By purchaseGCButton = By.cssSelector("[href='/Giftcards/publicpurchaseGC']");
    public By showUnavaibleGCLink = By.cssSelector(".collapsed.auto-collapse");
    public By giftCards = By.cssSelector(" .d-flex.flex-wrap.gap-2 >div");
    public By firstCardLink = By.xpath("(//div[@class=' d-flex flex-wrap gap-2 mb-3']//div[@class='d-flex flex-column']/a)[1]");
    public By sendArrow = By.cssSelector(".fas.fa-external-link");
    By crossIcon = By.cssSelector(".btn-close.ms-2");


public void getFirstCardLink(){
    click(firstCardLink);
}
public void getCrossIconGCpopup(){
    click(crossIcon);
}

public void getSendArrow(){
    click(sendArrow);
}







}
