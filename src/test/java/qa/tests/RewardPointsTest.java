package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObjectManager;
import pageEvents.RewardPointsPage;

public class RewardPointsTest extends BaseTest {

    public static Logger log = LogManager.getLogger(BasicInformationPage.class);

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    private RewardPointsPage rewardPointsPage = pageObjectManager.getRewardPointsPage();

    @Test
    public void verifyRewardsPointsPageOpens() {
        log.info("Verify that rewards points page opens up");

        Login();
        click(rewardPointsPage.MyStuff);
        click(rewardPointsPage.rewardsPointsPage);

        Assert.assertTrue(isElementDisplayed(rewardPointsPage.rewardCard));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.alertMsgHours));
    }

    @Test
    public void verifyRewardCardDetails() {
        log.info("Verify that '<Store-Name>' Reward Point cards contain appropriate details");

        Login();
        click(rewardPointsPage.MyStuff);
        click(rewardPointsPage.rewardsPointsPage);

        Assert.assertTrue(isElementDisplayed(rewardPointsPage.storeNameOnCard));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.rewardPointsOnCard));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.redeemNowLinkOnCard));
    }

    @Test
    public void verifyStoreInfoPageDetails() {
        log.info("Verify that appropriate details appears under store Information page");

        Login();
        click(rewardPointsPage.MyStuff);
        click(rewardPointsPage.rewardsPointsPage);

        click(rewardPointsPage.storeNameOnCard);
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.storeInformationTitle));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.contactInfoCard));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.recentTransaction));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.customerSince));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.earnedRewardPoints));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.contactNumber));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.address));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.url));
    }

    @Test
    public void verifyRewardPointsDetails() {
        log.info("Verify that user gets directed to 'Reward Points Detail' page, after clicking on '<Total Reward Point Earned>' link,");

        Login();
        click(rewardPointsPage.MyStuff);
        click(rewardPointsPage.rewardsPointsPage);

        click(rewardPointsPage.rewardPointsOnCard);
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.pointsTable));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.rewardPointsDetailPageTitle));
    }

    @Test
    public void verifyRedeemNowPg() {
        log.info("Verify that user get directed to 'Redeem Reward Points To Gift Card' page, after clicking on 'Redeem Points' link");

        Login();
        click(rewardPointsPage.MyStuff);
        click(rewardPointsPage.rewardsPointsPage);

        click(rewardPointsPage.redeemNowLinkOnCard);
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.totalPointsEarned));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.infoMsgOnRedeemNowLink));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.CustomGiftCardToggleBtn));
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.claimGiftCard));
    }

    @Test
    public void verifyCustomGiftCardSlider() {
        log.info("verify Custom gift card slider appears after toggling 'Custom Gift Card' button");

        Login();
        click(rewardPointsPage.MyStuff);
        click(rewardPointsPage.rewardsPointsPage);

        click(rewardPointsPage.redeemNowLinkOnCard);
        click(rewardPointsPage.CustomGiftCardToggleBtn);
        waitForElementToBeVisible(rewardPointsPage.pointsToRedeem,10);
        Assert.assertTrue(isElementDisplayed(rewardPointsPage.pointsToRedeem));

        rewardPointsPage.pointsToRedeemSlider();
        System.out.println(getText(rewardPointsPage.eligibleGiftCardAmt));
    }

}
