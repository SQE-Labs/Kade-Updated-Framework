package qa.tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.GiftCardDashboardPage;
import pageEvents.SidePannelPage;
import pageObjects.PageObjectManager;
import utils.Constants;




public class GiftCardDashboardTest extends BaseTest {

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private GiftCardDashboardPage giftCardPage = pageObjectManager.getGiftCardPage();

    @Test(priority = 1, enabled = true, description = "Verify that user gets directed to 'Gift Cards Dashboard' page, after clicking on any store under 'Which store?' section.")
    public void verifyGiftcardDashboardPage(){
        SidePannelPage pannel= new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        softAssert.assertEquals(giftCardPage.giftCardDashBoardHeaderText, Constants.GiftCardHeader);
        String name = giftCardPage.selectStore(3);
        giftCardPage.clickWhichStoreContinueBtn();
        softAssert.assertEquals(giftCardPage.storeName.toString(),name);
        System.out.println(giftCardPage.infoMessageText);
        softAssert.assertEquals(giftCardPage.infoMessageText,Constants.infoMessage);

    }

    @Test(priority = 2, enabled = true, description = "Verify that 'Gift Cards Configuration' popup opens up after clicking on 'Configuration' link, on 'Gift Card Dashboard' page.")
    public void verifyGiftConfigurationPopup(){
        SidePannelPage pannel= new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        softAssert.assertEquals(giftCardPage.getConfigurationPopupText().toString(),Constants.configurationPopupTitle);
        softAssert.assertEquals(giftCardPage.getDisabledText().toString(),Constants.DisabledText);

    }
    @Test(priority = 3, enabled = true, description = "Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyReferenceNoOptions(){
        SidePannelPage pannel= new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(6);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if(giftCardPage.disabledText.equals(Constants.DisabledText)){
                      giftCardPage.enableToggleButton();

        }
        else {
            giftCardPage.disableToggleButton();
            giftCardPage.enableToggleButton();
            if(!isElementDisplayed(giftCardPage.referenceNoDisabledText)){
                giftCardPage.disableReferenceNoEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.referenceNoDisabledText.toString(),Constants.referenceNoDisabledText);
            }else {
                softAssert.assertEquals(giftCardPage.referenceNoDisabledText.toString(),Constants.referenceNoDisabledText);
            }
        }



    }
    @Test(priority = 4, enabled = true, description = "Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyCardAmountField(){
            SidePannelPage pannel= new SidePannelPage();
            Login();
            pannel.getMangeBusinessTab();
            pannel.getGiftCardsDashboardTab();
            giftCardPage.selectStore(6);
            giftCardPage.clickWhichStoreContinueBtn();
            giftCardPage.clickConfigurationButton();

        }
    }


