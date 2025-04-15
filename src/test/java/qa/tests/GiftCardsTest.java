package qa.tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.GiftCardPage;
import pageObjects.PageObjectManager;

import java.util.List;

public class GiftCardsTest extends BaseTest {

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    GiftCardPage giftcard = new GiftCardPage();

    @Test(priority = 1, enabled = true, description = "GC 01 and GC 02: Verify that user get directed to 'Gift Cards' page, after clicking on 'Gift Cards' tab , on  Left Panel., Verify that appropriate information message appears on 'Gift Cardst' page, when user has no gift card in his account.")
    public void verifyTheInfoMsgWhenNoGiftCard(){
        Login();
        pageObjectManager.getSidePannel().getMyStuff();
        pageObjectManager.getSidePannel().getGiftCardTab();

        // verify the info msg when no gift card is available
        Assert.assertTrue(isElementDisplayed(giftcard.infoMsg));

    }

    @Test(priority =2, enabled = true, description = "GC 03 and GC 06 Verify that all the gift card appear listed in Grid View, on 'Gift Cards' Page, when gift card has been issued by store manager., Verify that appropriate details appears on active Gift Card, on 'Gift Cards'  page.")
    public void verifyTheCardsAndInfomationOnGC(){
        LoginAsCustomer();
        staticWait(3000);
        scrollToDown();
        scrollToElement(pageObjectManager.getSidePannel().myStuff);
        pageObjectManager.getSidePannel().getMyStuff();
        scrollToElement(pageObjectManager.getSidePannel().giftCardsTab);
        waitForElementToBeClickable( pageObjectManager.getSidePannel().giftCardsTab,5);
        pageObjectManager.getSidePannel().getGiftCardTab();


   // Get the list of all gift card tiles
        List<WebElement> giftCards = getListOfWebElement(giftcard.giftCards);
        Assert.assertTrue(giftCards.size() > 0, "No gift cards are listed in Grid View.");

        //  Loop through gift cards and validate details
        for (WebElement card : giftCards) {
            System.out.println("Card Details are "+ card.getText());




        }




    }


}
