package qa.tests;

import base.BaseTest;

import org.testng.annotations.Test;
import pageObjects.PageObjectManager;
import pageEvents.GiftCardDashboardPage;





public class GiftCardDashboardTest extends BaseTest {

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    private GiftCardDashboardPage giftCardPage = pageObjectManager.getGiftCardDashboardPage();
    @Test(priority = 0, enabled = true, description = "Verify that appropriate information message appears after clicking on 'Gift Card Dashboard' tab, when not store is active")
    public void verifyInformationMsgNoActiveStore() {
        giftCardPage.verifyInformationMsgNoActiveStore();
    }

    @Test(priority = 1, enabled = true, description = "Verify that user gets directed to 'Gift Cards Dashboard' page, after clicking on any store under 'Which store?' section.")
    public void verifyGiftcardDashboardPage() {
        giftCardPage.verifyGiftcardDashboardPage();

    }

    @Test(priority = 2, enabled = true, description = "Verify that 'Gift Cards Configuration' popup opens up after clicking on 'Configuration' link, on 'Gift Card Dashboard' page.")
    public void verifyGiftConfigurationPopup() {
        giftCardPage.verifyGiftConfigurationPopup();

    }

    @Test(priority = 3, enabled = true, description = "TC_04_01 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyReferenceNoOption() {
        giftCardPage.verifyReferenceNoOptions();
    }


    @Test(priority = 4, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifySourceFundingOptions() {
        giftCardPage.verifySourceFundingOptions();
    }


    @Test(priority = 5, enabled = true, description = "TC_4_03 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyCardAmountField() {
        giftCardPage.verifyCardAmountField();

    }

    @Test(priority = 6, enabled = true, description = "Verify Maximum gift card amount allowed' field.")
    public void verifySendAmount() {
        giftCardPage.verifySendAmount();


    }

    @Test(priority = 7, enabled = true, description = "Verify Maximum gift card amount allowed' field.")
    public void verifyNullAmountValidationMsg() {
        giftCardPage.verifyNullAmountValidationMsg();
    }

    @Test(priority = 8, enabled = true, description = "Verify that 'Managing, accepting and issuing Gift Cards is' and 'Providing Reference No. is'  settings appears as optional on 'Gift Cards Configuration' popup of 'Gift Cards Dashboard' page.")
    public void verifyOptionalSettings() {
        giftCardPage.verifyOptionalSettings();
    }

    @Test(priority = 9, enabled = true, description = "Verify that 'Gift Cards Configuration' popup closes after clicking on 'Cross' icon, without any changes on 'Gift Cards Configuration' popup of 'Gift Cards Dashboard' page")
    public void verifyCrossButton() {
        giftCardPage.verifyCrossButton();

    }


    @Test(priority = 11, enabled = true, description = "Verify that 'Customer' popup opens up after clicking on 'Customer' field, on 'Issue a new gift card' popup of 'Gift Cards Dashboard' page.")
    public void verifyCustomerPopUp() {
        giftCardPage.verifyCustomerPopUp();

    }


    @Test(priority = 12, enabled = true, description = "Verify that appropriate validation message appears on entering invalid phone number in  'Customer phone/email' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerPhoneField() {
        giftCardPage.verifyInvalidCustomerPhoneField();
    }

    @Test(priority = 13, enabled = true, description = "Verify that appropriate validation message appears on entering invalid phone number in  'Customer phone/email' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerEmailField() {
        giftCardPage.verifyInvalidCustomerEmailField();


    }


    @Test(priority = 14, enabled = true, description = "Verify that appropriate validation message appears on entering invalid name in  'Customer Name' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerNameField() {
        giftCardPage.verifyInvalidCustomerNameField();
    }

    @Test(priority = 15, enabled = true, description = "Verify that user is able to create gift card only after entering value in 'Initial amount' field, on 'Create gift card' popup.")
    public void verifyInitialAmountField() {
        giftCardPage.verifyInitialAmountField();

    }

    @Test(priority = 16, enabled = true, description = "Verify that value for 'Initial amount' field' cannot be greater than the value set in 'Maximum gift card amount allowed' field during Gift Cards Configuration")
    public void verifyInitialAmtEqualsMaxGiftAmount() {
        giftCardPage.verifyInitialAmtEqualsMaxGiftAmount();

    }


    @Test(priority = 17, enabled = true, description = "Verify that value for 'Initial amount' field' cannot be greater than the value set in 'Maximum gift card amount allowed' field during Gift Cards Configuration")
    public void verifyRefrenceNoMandatory() {
        giftCardPage.verifyRefrenceNoMandatory();


    }

    @Test(priority = 18, enabled = true, description = "Verify that 5 additional options appear after clicking on 'Advanced' link , on 'Create gift card' popup.")
    public void verifyAdditionalFields() {
        giftCardPage.verifyAdditionalFields();
    }


    @Test(priority = 20, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
    public void verifyCardNoRejectLessThan4NumericValues() {
        giftCardPage.verifyCardNoRejectLessThan4NumericValues();
    }


    @Test(priority = 21, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
    public void verifyCardAcceptesNumericValues() {
        giftCardPage.verifyCardAcceptesNumericValues();
    }


    @Test(priority = 22, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
    public void verifyCardNoAccepts18NumericValues() {
        giftCardPage.verifyCardNoAccepts18NumericValues();
    }

    @Test(priority = 23, enabled = true, description = "Verify that 'Memo' field accepts value up to 500 characters, on' Create gift card' popup.")
    public void verifyMemoAccepts500Values() {
        giftCardPage.verifyMemoAccepts500Values();

    }

    @Test(priority = 24, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyFundingSourceAsTList() {
        giftCardPage.verifyFundingSourceAsTList();


    }

    @Test(priority = 25, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyFundingSourceAsText() {
        giftCardPage.verifyFundingSourceAsText();


    }

    @Test(priority = 26, enabled = true, description = "Verify that user is not allowed to select past dates in 'Start Date' and 'Exp. Date' fields respectively, on  'Create gift card' popup.")
    public void verifyPastStartDatesDisabled() {
        giftCardPage.verifyPastStartDatesDisabled();


    }

    @Test(priority = 27, enabled = true, description = "Verify that user is not allowed to select past dates in 'Start Date' and 'Exp. Date' fields respectively, on  'Create gift card' popup.")
    public void verifyPastEndDateDisabled() {
        giftCardPage.verifyPastEndDateDisabled();


    }

    @Test(priority = 28, enabled = true, description = "Verify that validation message appears on entering character in 'Start Date' or 'Exp. Date' field, on 'Create gift card' popup.")
    public void verifyStartDateRejectsCharacters() {
       giftCardPage.verifyStartDateRejectsCharacters();
    }

    @Test(priority = 29, enabled = true, description = "Verify that validation message appears on entering character in 'Start Date' or 'Exp. Date' field, on 'Create gift card' popup.")
    public void verifyEndDateRejectsCharacters() {
       giftCardPage.verifyEndDateRejectsCharacters();
    }

    @Test(priority = 30, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyGiftCardDetailPopUp() {
        giftCardPage.verifyGiftCardDetailPopUp();
    }

    @Test(priority = 31, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyInfoIcon() {
        giftCardPage.verifyInfoIcon();
    }

    @Test(priority = 32, enabled = true, description = "Verify that appropriate fields appear after clicking on edit icon below the  <Card No: XXXXX>' label, on 'Gift Card Details' popup ")
    public void verifyEditBtn() {
        giftCardPage.verifyEditBtn();
    }


    @Test(priority = 33, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyFundingResourceOptional() {
        giftCardPage.verifyFundingResourceOptional();
    }

}















