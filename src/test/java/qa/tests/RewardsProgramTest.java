package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.PageObjectManager;
import pageEvents.RewardsProgramPage;
import utils.Constants;

public class RewardsProgramTest extends BaseTest {

    public static Logger log = LogManager.getLogger(RewardsProgramPage.class);

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    private RewardsProgramPage rewardsProgramPage = pageObjectManager.getRewardsProgramPage();

    @Test
    public void verifyRewardsProgramPageOpens() {
        log.info("Verify that Rewards Program Page Opens");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.pageHeading));
    }

    @Test(enabled = false)
    public void verifyInformationMessageAppears() {
        log.info("Verify that information message appears, when Rewards program is not configured for store.");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.infoMsgRewardsConfig));
    }

    @Test
    public void verifyRewardsProgramConfigOpens() {
        log.info("Verify that 'Rewards Program Configuration' popup opens up");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        click(rewardsProgramPage.settingsBtn);
        waitForElementToBeVisible(rewardsProgramPage.rewardsProgPopupTitle,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.rewardsProgPopupTitle));
        click(rewardsProgramPage.toggleDisabled);
        click(rewardsProgramPage.saveChangesBtn);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.rewardsProgActivationMsg));


        click(rewardsProgramPage.settingsBtn);
        click(rewardsProgramPage.toggleEnabled);
        click(rewardsProgramPage.saveChangesBtn);
    }

    @Test
    public void verifyCustProfileOpens() {
        log.info("Verify Customer profile page opens up after clicking on the customer name");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        click(rewardsProgramPage.customerNameYonro);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.customerCardTitle));
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.rewardsPtsCardTitle));
    }

    @Test
    public void verifyRewardsPointsDetailPageOpens() {
        log.info("Verify that user gets directed to 'Reward Points Detail' page");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        click(rewardsProgramPage.rewardsPntsLink);
        Assert.assertTrue(isElementDisplayed(rewardsProgramPage.rewardsPtsPgTitle));
        click(rewardsProgramPage.addNewRowBtn);
        Assert.assertTrue(isElementDisplayed(rewardsProgramPage.memoInputField));

        //Leave fields blank
        click(rewardsProgramPage.addBtn);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.alertMsg));
        softAssert.assertEquals(getToolTipMessage(rewardsProgramPage.memoInputField), Constants.requiredFieldValidation);
        softAssert.assertEquals(getToolTipMessage(rewardsProgramPage.pointsInputField), Constants.requiredFieldValidation);

        actionEnterText(rewardsProgramPage.memoInputField,Constants.Memo);
        actionEnterText(rewardsProgramPage.pointsInputField,Constants.Points);
        click(rewardsProgramPage.addBtn);
    }

    @Test
    public void verifyFilterFunctionality() {
        log.info("Verify Filter functionality");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        click(rewardsProgramPage.filterBtn);
        waitForElementToBeVisible(rewardsProgramPage.partialUsername,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.partialUsername));
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.userPhnEmail));
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.lastVisit));
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.customerSince));
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.minRewardPts));
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.maxRewardPts));
    }

    @Test
    public void verifyUsernameFieldFunc() {
        log.info("Verify relevent record appears on searching using Username");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.partialUsername, Constants.PartialUsername);
        waitForElementToBeInteractable(rewardsProgramPage.applyBtn,20);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));

        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.partialUsername, Constants.InvalidPartialUsername);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));
    }

    @Test
    public void verifyUserPhnEmailFieldFunc() {
        log.info("Verify relevant record appears on searching using Customer Phone/Email filter field");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.userPhnEmail,Constants.phnNoFilterInput);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);

        rewardsProgramPage.tryCatchForFilter();
        enterText(rewardsProgramPage.userPhnEmail,Constants.EmailFilterInput);
        click(rewardsProgramPage.applyBtn);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));
    }

    @Test
    public void verifyUserPhnEmailFieldF() {
        log.info("Verify relevant record appears on searching using Customer Phone/Email filter field for invalid input");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();

        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.userPhnEmail,Constants.nonExistingEmailFilterInput);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));

        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.userPhnEmail,Constants.nonExistingPhoneNoFilterInput);
        waitForElementToBeInteractable(rewardsProgramPage.applyBtn,20);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));

        rewardsProgramPage.tryCatchForFilter();
        enterText(rewardsProgramPage.userPhnEmail,Constants.invalidPhoneNumberFilterInput);
        click(rewardsProgramPage.applyBtn);
        softAssert.assertEquals(getToolTipMessage(rewardsProgramPage.userPhnEmail),Constants.userPhnEmailTooltip,"tool tip");
    }

    @Test
    public void verifyValidLastVisitDateRng() {
        log.info("Verify relevant record appears after selecting last visit date range");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        waitForElementToBeInteractable(rewardsProgramPage.lastVisit,20);
        enterText(rewardsProgramPage.lastVisit,Constants.LastVisitFilterInput);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));
    }

    @Test
    public void verifyInvalidLastVisitDateRng() {
        log.info("Verify relevant record appears after selecting invalid last visit date range");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.lastVisit,Constants.InvalidLastVisitFilterInput);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));

        rewardsProgramPage.tryCatchForFilter();
        enterText(rewardsProgramPage.lastVisit,Constants.InvalidLastVisitFilterInput2);
        click(rewardsProgramPage.applyBtn);
        softAssert.assertEquals(getToolTipMessage(rewardsProgramPage.lastVisit),Constants.invalidDateRange,"tool tip");

    }

    @Test
    public void verifyCustomerSinceValidDateRange() {
        log.info("Verify relevant record appears after selecting Customer since date range");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.customerSince,Constants.customerSinceDateRange);
        click(rewardsProgramPage.applyBtn);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));
    }

    @Test
    public void verifyCustomerSinceInvalidDateRange() {
        log.info("Verify relevant record appears after selecting invalid Customer since date range");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        enterText(rewardsProgramPage.customerSince,Constants.InvalidLastVisitFilterInput);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));

        rewardsProgramPage.tryCatchForFilter();
        enterText(rewardsProgramPage.customerSince,Constants.InvalidLastVisitFilterInput2);
        click(rewardsProgramPage.applyBtn);
        softAssert.assertEquals(getToolTipMessage(rewardsProgramPage.customerSince),Constants.invalidDateRange,"tool tip");
    }

    @Test
    public void verifyMinRewardPointsFilter() {
        log.info("Verify that relevant record appears after selecting minimum reward points");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        waitForElementToBeVisible(rewardsProgramPage.minRewardPts,20);
        actionEnterText(rewardsProgramPage.minRewardPts,Constants.minRewardPointsInput);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));
        staticWait(2000);

        rewardsProgramPage.tryCatchForFilter();
        waitForElementToBeInteractable(rewardsProgramPage.minRewardPts,20);
        actionEnterText(rewardsProgramPage.minRewardPts,Constants.minRewardPointsInput2);
        rewardsProgramPage.tryCatchforApplyBtn();
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));
    }

    @Test
    public void verifyMaxRewardPointsFilter() {
        log.info("Verify that relevant record appears after selecting maximum reward points");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        waitForElementToBeInteractable(rewardsProgramPage.maxRewardPts,20);
        actionEnterText(rewardsProgramPage.maxRewardPts,Constants.maxRewardPointsInput);
        click(rewardsProgramPage.applyBtn);
        waitForElementInVisible(rewardsProgramPage.applyBtn,20);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));
        staticWait(2000);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.filterBtn));

        waitForElementToBeClickable(rewardsProgramPage.filterBtn,20);
        rewardsProgramPage.tryCatchForFilter();
        waitForElementToBeInteractable(rewardsProgramPage.maxRewardPts,20);
        actionEnterText(rewardsProgramPage.maxRewardPts,Constants.maxRewardPointsInput2);
        click(rewardsProgramPage.applyBtn);
//        rewardsProgramPage.tryCatchforApplyBtn();
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));
    }

    @Test
    public void verifyMinPaymentsField() {
        log.info("Verify that relevant record appear listed after entering any existing value in 'Min number of payments' field under 'Filter' link");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        actionEnterText(rewardsProgramPage.minPayments,Constants.minPaymentInput);
        click(rewardsProgramPage.applyBtn);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));
        staticWait(2000);

        rewardsProgramPage.tryCatchForFilter();
        waitForElementToBeInteractable(rewardsProgramPage.maxRewardPts,20);
        actionEnterText(rewardsProgramPage.minPayments,Constants.minPaymentInput2);
        rewardsProgramPage.tryCatchforApplyBtn();
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.noResultIcon));
    }

    @Test
    public void verifyMaxPaymentsField() {
        log.info("Verify that relevant record appear listed after entering any existing value in 'Max number of payments' field under 'Filter' link");

        Login();
        rewardsProgramPage.RewardsProgramPageOpen();
        click(rewardsProgramPage.filterBtn);
        actionEnterText(rewardsProgramPage.maxPayments,Constants.minPaymentInput);
        click(rewardsProgramPage.applyBtn);
        softAssert.assertTrue(isElementDisplayed(rewardsProgramPage.yonroCustomer));
    }


}
