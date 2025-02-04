package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RewardPointsPage extends BaseTest {

    public By rewardsPointsPage = By.xpath("(//i[@class='align-middle me-2 fa-fw far fa-trophy-alt'])[2]");
    public By MyStuff = By.xpath("//a[text()='My Stuff']");
    public By rewardCard = By.cssSelector(".card.m-0.p-2.p-md-3");
    public By alertMsgHours = By.xpath("//div[@class='alert-message' and text()='Reward points may take up to 24 hours to show up']");
    public By storeName = By.cssSelector(".text-truncate");
    public By storeNameOnCard = By.cssSelector(".ms-2.text-truncate");
    public By rewardPointsOnCard = By.cssSelector(".d-flex.justify-content-center.gap-3.fs-1");
    public By redeemNowLinkOnCard = By.cssSelector(".fs-pn25.mt-2.float-end");
    public By storeInformationTitle = By.cssSelector(".header-title.mb-0");
    public By contactInfoCard = By.cssSelector(".card-title");
    public By recentTransaction = By.xpath("//h5[@class='card-header']");
    public By customerSince = By.cssSelector(".fal.fa-calendar-edit.fa-fw.me-1");
    public By earnedRewardPoints = By.cssSelector(".border.p-4.my-2.rounded");
    public By contactNumber = By.cssSelector(".fa-2x.far.fa-phone");
    public By address = By.cssSelector(".fa-2x.fal.fa-map-marker-alt");
    public By url = By.cssSelector(".avatar-title.rounded-circle.bg-dark");
    public By pointsTable = By.xpath("//tbody");
    public By rewardPointsDetailPageTitle = By.cssSelector(".header-title.mb-0");
    public By totalPointsEarned = By.cssSelector("div.card-body h1.display-5.mt-2.mb-4");
    public By infoMsgOnRedeemNowLink = By.xpath("//div[text()='You will receive $1 per each ']");
    public By CustomGiftCardToggleBtn = By.cssSelector(".form-check-input.mt-0.me-3");
    public By claimGiftCard = By.cssSelector(".card-img-overlay");
    public By pointsToRedeem = By.cssSelector(".custom-slider.w-100");
    public By eligibleGiftCardAmt = By.xpath("//span[@data-field='eligibleGiftCardAmount']");

    public void pointsToRedeemSlider() {
        Actions actions = new Actions(getDriver());
        WebElement elm = getDriver().findElement(pointsToRedeem);
        actions.moveToElement(elm).moveByOffset(-100, 0).clickAndHold().moveByOffset(200, 0).release().perform();
    }
}
