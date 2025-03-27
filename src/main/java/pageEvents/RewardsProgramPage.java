package pageEvents;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class RewardsProgramPage extends BaseTest {
    private static final Logger log = LogManager.getLogger(RewardsProgramPage.class);

    By RewardsProgramPage = By.xpath("//div[text()='Rewards Program']");
    By manageBusinessAcc = By.xpath("//a[@class='sidebar-link fw-bold text-black collapsed' and text()='Manage Business']");
    By storeCombobox = By.cssSelector(".select2-selection.select2-selection--single");
    By cutomerStoreOption = By.xpath("//li[@class='select2-results__option'][text()='Automation Customer Store']");
    By continueBtn = By.xpath("//button[@class='btn btn-primary'][text()='Continue']");
    public By pageHeading = By.cssSelector(".header-title.mb-0");
    public By infoMsgRewardsConfig = By.cssSelector(".fa.fa-do-not-enter.text-danger.me-2");
    public By settingsBtn = By.cssSelector(".btn.btn-link.float-end.p-0");
    public By rewardsProgPopupTitle = By.cssSelector(".modal-title");
    public By toggleDisabled = By.cssSelector(".far.fa-toggle-off.custom-check-off ");
    public By toggleEnabled = By.cssSelector(".far.fa-toggle-on.custom-check-on ");
    public By saveChangesBtn = By.xpath("//button[@class='btn btn-primary'][text()='Save changes']");
    public By rewardsProgActivationMsg = By.cssSelector(".fa.fa-check.text-success.me-2");
    public By customerNameYonro = By.xpath("//span[text()='Yonro']");
    public By customerCardTitle = By.xpath("//h5[@class='card-title'][text()='Customer']");
    public By rewardsPtsCardTitle = By.xpath("//h4[@class='card-title'][text()='Reward points']");
    public By rewardsPntsLink = By.xpath("//a[@class='btn btn-link'][1]");
    public By rewardsPtsPgTitle = By.xpath("//h1[@class='header-title mb-0']");
    public By addNewRowBtn = By.cssSelector(".btn.btn-outline-primary.floar-start.collapsed.btn-sm");
    public By memoInputField = By.xpath("//input[@name='memo']");
    public By pointsInputField = By.xpath("//input[@name='points']");
    public By addBtn = By.cssSelector(".btn.btn-outline-primary.ms-auto");
    public By alertMsg = By.xpath("//p[text()='Please review the highlighted field(s)']");
    public By filterBtn = By.cssSelector(".fas.fa-filter.me-1");
    public By partialUsername = By.xpath("//input[@name='userName']");
    public By userPhnEmail = By.xpath("//input[@name='emailPhone']");
    public By lastVisit = By.xpath("//input[@name='dateRangeLastVisit']");
    public By customerSince = By.xpath("//input[@name='dateRangeCustomerSince']");
    public By minRewardPts = By.xpath("//input[@name='minRewardPoints']");
    public By maxRewardPts = By.xpath("//input[@name='maxRewardPoints']");
    public By applyBtn = By.cssSelector(".btn-sm.btn.btn-outline-primary");
    public By yonroCustomer = By.xpath("//span[text()='yonro']");
    public By noResultIcon = By.cssSelector(".no-result-icon");
    public By minPayments = By.cssSelector("[name='minpayments']");
    public By maxPayments = By.cssSelector("[name='maxpayments']");

    public void RewardsProgramPageOpen() {
        clickElementByJS(manageBusinessAcc);
        clickElementByJS(RewardsProgramPage);
        click(storeCombobox);
        click(cutomerStoreOption);
        click(continueBtn);
    }

    public void tryCatchForFilter() {
        try {
            waitForElementToBeVisible(userPhnEmail,10);
        } catch (Exception e) {
            click(filterBtn);
        }
    }

    public void tryCatchforApplyBtn() {
        try {
            waitForElementInVisible(applyBtn,20);
        } catch (Exception e) {
            click(applyBtn);
        }
    }



}
