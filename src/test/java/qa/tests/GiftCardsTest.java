package qa.tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.GiftCardPage;
import pageObjects.PageObjectManager;
import utils.Constants;

import java.util.List;
import java.util.Set;

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
    @Test(priority = 3, enabled = true, description = "GC 12, 13 and GC 14, Verify that Gift Card Summary popup opens up, after clicking on any Gift card, on 'Gift Cards' page.")
      public void verifyGCSummaryPopupOpensUpAfterClickingOnGC(){
        LoginAsCustomer();
        staticWait(3000);
        scrollToDown();
        scrollToElement(pageObjectManager.getSidePannel().myStuff);
        pageObjectManager.getSidePannel().getMyStuff();
        scrollToElement(pageObjectManager.getSidePannel().giftCardsTab);
        waitForElementToBeClickable( pageObjectManager.getSidePannel().giftCardsTab,6);
        pageObjectManager.getSidePannel().getGiftCardTab();

       waitForElementToBeClickable(giftcard.firstCardLink,5);

        // Clicking on FirstGC link
        giftcard.getFirstCardLink();
        staticWait(3000);

        String currentUrl = getDriver().getCurrentUrl();
        softAssert.assertEquals(currentUrl, Constants.GiftCardSummaryURL);

        // clicking on cross icon to close the popup
        giftcard.getCrossIconGCpopup();


    }
    @Test(priority = 4,enabled = false, description = "GC 15: Verify that 'Gift card detail' page opens in a new tab, after clicking on 'Open in a new tab' icon , on Gift Card Summary popup")
    public void verifyGCOpenInNewTab(){
        LoginAsCustomer();
        staticWait(3000);
        scrollToDown();
        scrollToElement(pageObjectManager.getSidePannel().myStuff);
        pageObjectManager.getSidePannel().getMyStuff();
        scrollToElement(pageObjectManager.getSidePannel().giftCardsTab);
        waitForElementToBeClickable( pageObjectManager.getSidePannel().giftCardsTab,6);
        pageObjectManager.getSidePannel().getGiftCardTab();

        waitForElementToBeClickable(giftcard.firstCardLink,5);

        // Clicking on FirstGC link
        giftcard.getFirstCardLink();
        staticWait(3000);

        String currentUrl = getDriver().getCurrentUrl();
        softAssert.assertEquals(currentUrl, Constants.GiftCardSummaryURL);

        // clicking on send icon of GC popup
        String originalWindow = getDriver().getWindowHandle();
        giftcard.getSendArrow();

        // Step 4: Wait for new tab and switch
       staticWait(3000);
        Set<String> windowHandles = getDriver().getWindowHandles();

        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }
        String currentUrlof = getDriver().getCurrentUrl();
        softAssert.assertEquals(currentUrlof,Constants.giftCardDetailURL);
    }
}

