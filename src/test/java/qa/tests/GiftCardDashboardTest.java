package qa.tests;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageEvents.GiftCardDashboardPage;
import pageEvents.SidePannelPage;
import pageObjects.PageObjectManager;



import utils.Constants;

import java.io.File;
import java.io.IOException;


public class GiftCardDashboardTest extends BaseTest {

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private GiftCardDashboardPage giftCardPage = pageObjectManager.getGiftCardPage();

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


    @Test(priority = 10, enabled = true, description = "Verify that 'Customer' popup opens up after clicking on 'Customer' field, on 'Issue a new gift card' popup of 'Gift Cards Dashboard' page.")
    public void verifyCustomerPopUp() {
        giftCardPage.verifyCustomerPopUp();

    }


    @Test(priority = 11, enabled = true, description = "Verify that appropriate validation message appears on entering invalid phone number in  'Customer phone/email' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerPhoneField() {
        giftCardPage.verifyInvalidCustomerPhoneField();
    }

    @Test(priority = 12, enabled = true, description = "Verify that appropriate validation message appears on entering invalid phone number in  'Customer phone/email' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerEmailField() {
        giftCardPage.verifyInvalidCustomerEmailField();


    }


    @Test(priority = 13, enabled = true, description = "Verify that appropriate validation message appears on entering invalid name in  'Customer Name' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerNameField() {
        giftCardPage.verifyInvalidCustomerNameField();
    }

    @Test(priority = 14, enabled = true, description = "Verify that user is able to create gift card only after entering value in 'Initial amount' field, on 'Create gift card' popup.")
    public void verifyInitialAmountField() {
        giftCardPage.verifyInitialAmountField();
    }

    @Test(priority = 15, enabled = true, description = "Verify that value for 'Initial amount' field' cannot be greater than the value set in 'Maximum gift card amount allowed' field during Gift Cards Configuration")
    public void verifyInitialAmtEqualsMaxGiftAmount() {
        giftCardPage.verifyInitialAmtEqualsMaxGiftAmount();
    }


    @Test(priority = 16, enabled = true, description = "Verify that value for 'Initial amount' field' cannot be greater than the value set in 'Maximum gift card amount allowed' field during Gift Cards Configuration")
    public void verifyRefrenceNoMandatory() {
        giftCardPage.verifyRefrenceNoMandatory();
    }

    @Test(priority = 17, enabled = true, description = "Verify that 5 additional options appear after clicking on 'Advanced' link , on 'Create gift card' popup.")
    public void verifyAdditionalFields() {
        giftCardPage.verifyAdditionalFields();
    }


    @Test(priority = 18, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
    public void verifyCardNoRejectLessThan4NumericValues() {
        giftCardPage.verifyCardNoRejectLessThan4NumericValues();
    }


    @Test(priority = 19, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
    public void verifyCardAcceptesNumericValues() {
        giftCardPage.verifyCardAcceptesNumericValues();
    }


    @Test(priority = 20, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
    public void verifyCardNoAccepts18NumericValues() {
        giftCardPage.verifyCardNoAccepts18NumericValues();
    }

    @Test(priority = 21, enabled = true, description = "Verify that 'Memo' field accepts value up to 500 characters, on' Create gift card' popup.")
    public void verifyMemoAccepts500Values() {
        giftCardPage.verifyMemoAccepts500Values();
    }

    @Test(priority = 22, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyFundingSourceAsTList() {
        giftCardPage.verifyFundingSourceAsTList();
    }

    @Test(priority = 23, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyFundingSourceAsText() {
        giftCardPage.verifyFundingSourceAsText();
    }

    @Test(priority = 24, enabled = true, description = "26 Verify that user is not allowed to select past dates in 'Start Date' and 'Exp. Date' fields respectively, on  'Create gift card' popup.")
    public void verifyPastStartDatesDisabled() {
        giftCardPage.verifyPastStartDatesDisabled();
    }

    @Test(priority = 25, enabled = true, description = "27 Verify that user is not allowed to select past dates in 'Start Date' and 'Exp. Date' fields respectively, on  'Create gift card' popup.")
    public void verifyPastEndDateDisabled() {
        giftCardPage.verifyPastEndDateDisabled();
    }

    @Test(priority = 26, enabled = true, description = "28 Verify that validation message appears on entering character in 'Start Date' or 'Exp. Date' field, on 'Create gift card' popup.")
    public void verifyStartDateRejectsCharacters() {
       giftCardPage.verifyStartDateRejectsCharacters();
    }

    @Test(priority = 27, enabled = true, description = "29 Verify that validation message appears on entering character in 'Start Date' or 'Exp. Date' field, on 'Create gift card' popup.")
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
        giftCardPage.verifyFundingResourceTextField();
    }

    @Test(priority = 34, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyFundingResourceAsList() {
        giftCardPage.verifyFundingResourceAsList();
    }
    @Test(priority = 34, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyReferenceNoFieldMaxLen50() {
        giftCardPage.verifyReferenceNoFieldMaxLen50();
    }
    @Test(priority = 35, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyMemoFieldMaxLen500() {
        giftCardPage.verifyMemoFieldMaxLen500();
    }

    @Test(priority = 36, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyPastStartDateIsDisabled() {
        giftCardPage.verifyPastStartDateIsDisabled();
    }
    @Test(priority = 37, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyPastEndDateIsDisabled() {
        giftCardPage.verifyPastEndDateIsDisabled();
    }

    @Test(priority = 38, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyStartDateRejectsChar() {
        giftCardPage.verifyStartDateRejectsChar();
    }

    @Test(priority = 39, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyEndDateRejectsChar() {
        giftCardPage.verifyEndDateRejectsChar();
    }
    @Test(priority = 40, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyStatusChange() {
        giftCardPage.verifyStatusChange();
    }

    @Test(priority = 42, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyUserDirectedToProfilePage() {
        giftCardPage.verifyUserDirectedToProfilePage();
    }
    @Test(priority = 43, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void verifyMessageIcon() {
        giftCardPage.verifyMessageIcon();
    }
    @Test(priority = 44, enabled = true, description = "Verify that 'Funding Source' field appear as text field on ''Gift Card Details' popup ,  when Funding source is set to optional on 'Gift Cards Configuration' popup.")
    public void VerifyActiveGiftCard() {
        giftCardPage.VerifyActiveGiftCard();
    }


    @Test(priority = 83, enabled = true, description = "Verify that user gets directed to 'Gift Card For Sale' page, after clicking on 'Add' button, on 'Sell Dashboard' page.")
    public void verifyUserDirectsToGiftCardForSalePage() {
        giftCardPage.verifyUserDirection();
    }

    @Test(priority = 29, enabled = true, description = "84 Verify that appropriate validation message appears on entering value in 'Gift card amount' field' greater than the value set in 'Maximum gift card amount ")
    public void verifyValidationOnEnteringGreaterValue() {
        giftCardPage.verifyFaceValueAmountField();
    }

    @Test(priority = 30, enabled = true, description = " 85 Verify that 'Face value' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyFaceValueFieldAcceptNumeric() {
        giftCardPage.verifyFaceValueFieldAccept();
    }

    @Test(priority = 31, enabled = true, description = " 86 Verify that 'Sale price' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifySalePriceAcceptOnlyNumeric() {
        giftCardPage.verifySalePriceFieldAccept();
    }

    @Test(priority = 32, enabled = true, description = "87 Verify that user is allowed to enter maximum value upto 150% of the value entered in 'Maximum Gift Card amount' ")
    public void verifyUserAllowedToEnterMaximumValueInSalePrice(){
        giftCardPage.verifyUserAllowedToEnterMaximumValue();
    }

    @Test(priority = 33, enabled = true, description = " 88 Verify that 'Face value', 'sale price', 'Reference No.' and 'Available quantity for sale' fields appears mandatory,on'Gift Card For Sale' page.")
    public void verifyFieldsAppearMandatoryOnPage() {
        giftCardPage.verifyFieldsAppearMandatory();
    }

    @Test(priority = 34, enabled = true, description = " 89 Verify that appropriate validation message appears on leaving any mandaory field blank on 'Gift Card For Sale' page")
    public void verifyValidationOnLeavingBlankAnyFIeld(){
        giftCardPage.verifyValidationLeavingFieldsBlank();
    }

    @Test(priority = 35, enabled = true, description = "90 and 91 Verify that 'Funding Source' field appear as text field on 'Gift Card For Sale' page. ")
    public void verifyFundingSrcFieldAppearAsText(){
      giftCardPage.validateAddedFundingSource();
    }

    @Test(priority = 36, enabled = true, description = " 92 Verify that 'Available quantity for sale' field accepts value up to 4 digits, on 'Gift Card For Sale' page.  ")
    public void verifyAvailableQuantityMaximumLength (){
        giftCardPage.verifyAvailableQuantityFieldLength();
    }

    @Test(priority = 37, enabled = true, description = "93 Verify that user is not able to enter any decimal value in 'Available quantity for sale' field, on 'Gift Card For Sale' page. ")
    public void verifyAvailableQuantityAcceptsNumerical (){
        giftCardPage.verifyAvailableQuantityFieldLength();
    }

    @Test(priority = 38, enabled = true, description = "94 Verify that 'Reference No' field accepts value up to 30 characters, on 'Gift Card For Sale' page. ")
    public void verifyRefNoFieldAcceptsChar (){
        giftCardPage.verifyRefNoValidation();
    }

    @Test(priority = 39, enabled = true, description = "95 Verify that by default date range appears as 1 year from current date in 'Sale date range' field, on 'Gift Card For Sale' page.")
    public void verifyDefaultDateRangeInSaleDateRange (){
        giftCardPage.verifyDefaultDateRange();
    }

    @Test(priority = 40, enabled = true, description = "96 AND 98Verify that user is able to set date range from date picker of 'Sale date range' field, on 'Gift Card For Sale' page.")
    public void verifySelectingDateRange (){
        giftCardPage.verifyDateRange();

    }
    @Test(priority = 41, enabled = true, description = " 97 Verify that 'Memo' field accepts value up to 500 characters, on 'Gift Card For Sale' page.")
    public void verifyMemoFieldMaximumLimit (){

        giftCardPage.verifyMemoFieldMaximumChar();


    }


    @Test(priority = 42, enabled = true, description = " 99 Verify that user gets directed to 'Gift Card For Sale' page and all the fields appear pre-filled, after clicking on any sale gift card from 'Sell Dashboard' page" )
    public void verifyPre_filledFieldsOnGiftCardsForSalePage (){

        giftCardPage.verifyUserDirectionForSalePage();


    }

    @Test(priority = 43, enabled = true, description = " 100 Verify that status of the gift card appears 'Ended' after the sale end date, on 'Sell Dashboard' page."
    )
    public void verifyStatusOfGiftCardAfterEndDate (){
        giftCardPage.verifyStatusOfGiftCard();
    }

    @Test(priority = 44, enabled = true, description = "101 Verify that user is able to update the sale gift card from 'Gift Card For Sale' page. "
    )
    public void verifyUserUpdateSaleGiftCard (){
        giftCardPage.verifyUpdateSaleGiftCard();
    }

    @Test(priority = 45, enabled = true, description = "Verify that user is not able to delete the sale gift card, after cancelling the Deletion action, on 'Gift Card For Sale' page"
    )
    public void verifyUserNotAbleToDeleteAfterCancelingGiftCard (){

        giftCardPage.verifyUserNotAbleToDeleteAfterCanceling();

        }
    @Test(priority = 46, enabled = true, description = "Verify that user is able to delete the sale gift card, after clicking on 'Delete' button, on 'Gift Card For Sale' page")
    public void verifyUserAbleToDeleteSaleGiftCard () {

        giftCardPage.verifyUserAbleToDeleteSaleGift();

        }

    @Test(priority = 47, enabled = true, description = "\"Verify that all the available sale gift cards appear listed on 'Sell Dashboard' page.\n" +
            "\"")
    public void verifyAllSaleGiftCardsListedOnSellDashboard (){

        giftCardPage.verifyListOfGiftCards();

    }

    @Test(priority = 48, enabled = true, description = "Verify that by-default 'Available' option appears selected in 'Status' dropdown under filter option, on 'Sell Dashboard' page.")
    public void verifyDefaultOptionSelectedInStatusDropdown (){

        giftCardPage.verifyGiftCardDetails();

    }

    @Test(priority = 49, enabled = true, description = "\"Verify that 'Available' and 'All' options appear after clicking on 'Status' dropdown under filter option, on 'Sell Dashboard' page.\n" +
            "\"")
    public void verifyAvailableAndAllOptionsInStatusDropdown (){

        giftCardPage.verifyAvailableAndAllOptionsInStatus();

    }


    @Test(priority = 50, enabled = true, description = " 107 & 108 Verify that only avaliable sale gift cards appear listed after selecting 'Available' option from 'Status' dropdown of Filter, on 'Sell Dashboard' page." )
    public void verifyAvailableSaleGiftCardsListed (){
        giftCardPage.verifyAvailableSaleGiftCards();
    }

    @Test(priority = 51, enabled = true, description = "114 & 115Verify that user is not able to delete the sale gift card, if the sale gift card Available QTY is zero, on 'Sell Dashboard' page.\n")
    public void verifyActionOnZeroAvlQty (){

        giftCardPage.verifyActionOnZeroAvailableQty();

    }

    @Test(priority = 52, enabled = true, description = "116 Verify that user is able to delete only those sale gift card which has Sold QTY: Zero, on 'Sell Dashboard' page.\n" +
            "\"")
    public void verifyUserAbleToDeleteSaleGiftCardQty0 (){
        giftCardPage.verifyActionOnSoldQty0();

    }

    @Test(priority = 53, enabled = true, description = "TC-73 and TC-74")
    public void verifyDonateGraph () {
        giftCardPage.donateGraph("may2025");
    }


    @Test (priority = 54,enabled = true,description = "52 Verify that appropirate fields appears after clicking on 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyFilterFieldsOfGiftCardDashboard(){
        giftCardPage.getAllFilterFileds();
    }


    @Test(priority = 55, enabled = true, description = "53 Verify that relevant gift cards appear listed after entering any existing  card holder name in 'User Name' field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyRelevantGiftCardAppearsWhileAddingExistingCardHolderName(){
        giftCardPage.getRelevantRecordAfterEnteringExistingCardHolderFilter();
    }

    @Test(priority = 56, enabled = true,description = " 54 Verify that information message appears after entering non existing card holder name in 'User Name' field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyNoResultInfoMsgAppearsAfterEnteringNonExistingData(){
        giftCardPage.getNoRecordMsgForInvalidCardHolder();
    }


    @Test(priority = 57, enabled = true, description = "55 Verify that relevant gift cards appear listed after entering any existing customer phone number in 'User Phone/Email' field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyRelevantRecordsAppearAfterEnteringUsingPhoneFilter(){
        giftCardPage.verifyRecordsAppearForPhoneFilter();
    }
    @Test(priority = 58, enabled = true, description ="56 Verify that information message appears after entering non existing customer phone number in 'User Phone/Email' field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyInformationMsgAppearsAfterEnteringNonExistingCustomerPhoneNumber(){
        giftCardPage.verifyInfoMsgForInvalidCustomerPhoneInput();
    }

    @Test(priority = 59, enabled = true, description = "57 Verify that relevant gift cards appear listed after entering any existing customer email in 'User Phone/Email' field under 'Filter' link, on 'Gift Cards Dashboard' page.\n")
    public void verifyRelevantRecordsAppearAfterEnteringUserEmailFilter(){
        giftCardPage.verifyRelevantRecordsAppearAfterEnteringUserEmailFilter();
    }

    @Test(priority = 60,enabled = true, description = "58 Verify that information message appears after entering non existing customer email in 'User Phone/Email' field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyInformationMsgAppearsAfterEnteringNonExistingCustomerEmail(){
        giftCardPage.verifyInfoMsgForInvalidCustomerEmailInput();
    }
    @Test(priority = 61 ,enabled = true, description ="59 Verify that relevant gift cards appear listed after selecting date range( gift card exists) from 'Date' field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyGiftCardAppearsForSelectedDate(){

        giftCardPage.verifyGiftCardAppearsForSelectedDate();
    }

    @Test(priority = 62,enabled = true, description ="60 Verify that information message appears after selecting non-existing date range in  from 'Date' field under 'Filter' link, on 'Gift Cards Dashboard' page.\n")
    public void verifyGiftCardResultWhileApplyingNonExistingDateRangeFilter(){
        giftCardPage.verifyGCResultWhileApplyingNonExistingDateRangeFilter();
    }

    @Test(priority = 63,enabled = true, description ="61 Verify that appropriate validation message appears after entering characters in 'Date' field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyValidationOfDateFieldAfterEnteringCharacters(){
        giftCardPage.verifyValidationOfDateFieldAfterEnteringCharacters();
    }

    @Test(priority = 64,enabled = true, description ="62&63 Verify that appropriate options appear in 'Gift card status' dropdown, after clicking 'Gift card status' dropdown under 'Filter' link, on 'Gift Cards Dashboard' page. ")
    public void verifyDropDownGCFilterOptions(){
        giftCardPage.getDropDownOptions();
    }

    @Test(priority = 65,enabled = true, description ="64 Verify that all the existing active gift cards appear listed, after selecting 'Active' option from 'Gift card status' dropdown field under 'Filter' link, on 'Gift Cards Dashboard' page. ")
    public void verifyRecordAfterApplyActiveFilterDD(){
        giftCardPage.verifyRecordAfterApplyActiveFilterDD();
    }

    @Test(priority = 66,enabled = true, description ="65 Verify that all the existing blocked gift cards appear listed, after selecting 'Blocked' option from 'Gift card status' dropdown field under 'Filter' link, on 'Gift Cards Dashboard' page. ")
    public void verifyRecordAfterApplyBlockedFilterDD(){
        giftCardPage.verifyRecordAfterApplyBlockedFilterDD();
    }
    @Test(priority = 67,enabled = true, description ="66 Verify that all the existing expired gift cards appear listed, after selecting 'Expired' option from 'Gift card status' dropdown field under 'Filter' link, on 'Gift Cards Dashboard' page. ")
    public void verifyRecordAfterApplyExpiredFilterDD(){
        giftCardPage.verifyRecordAfterApplyExpiredFilterDD();
    }
    @Test(priority = 68,enabled = true, description ="67 Verify that all the existing No Balance gift cards appear listed, after selecting 'No Balance' option from 'Gift card status' dropdown field under 'Filter' link, on 'Gift Cards Dashboard' page. ")
    public void verifyRecordAfterApplyNoBalanceFilterDD(){
        giftCardPage.verifyRecordAfterApplyNoBalanceFilterDD();

    }
    @Test(priority = 69,enabled = true, description ="68 Verify that all the existing Pending Activation gift cards appear listed, after selecting 'Pending Activation' option from 'Gift card status' dropdown field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyRecordAfterApplyPendingActivationFilterDD(){
        giftCardPage.verifyRecordAfterApplyPendingActivationFilterDD();
    }

    @Test(priority = 70,enabled = true, description ="69 Verify that relevant gift cards appear listed after entering value in 'Min Amount' under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyRelevantGCAppearsAfterApplyingMinAmountFilter(){
        giftCardPage.verifyRelevantGCAppearsAfterApplyingMinAmountFilter();
    }

    @Test(priority = 71,enabled = true, description ="70 Verify that relevant gift cards appear listed after entering value in 'Max Amount' under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyRelevantGCAppearsAfterApplyingMaxAmountFilter(){
        giftCardPage.verifyRelevantGCAppearsAfterApplyingMaxAmountFilter();
    }

    @Test(priority = 72,enabled = true, description =" 71 Verify that relevant gift cards appear listed after entering value in 'Min Amount' and 'Max Amount' 'under 'Filter' link, on 'Gift Cards Dashboard' page.\n")
    public void verifyRecordAfterApplyingMinAndMaxValueFilterValues(){
        giftCardPage.verifyRecordAfterApplyingMinAndMaxValueFilterValues();
    }
    @Test(priority = 73,enabled = true, description =" 72&73&74 Verify that relevant gift cards appear listed after entering any existing gift card number in 'Card Number \"Partial\" field under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyRelevantGCAppearAfterApplyingAnyExistingGCno(){
        giftCardPage. verifyRelevantGCAppearAfterApplyingAnyExistingGCno();
    }
    @Test(priority = 74,enabled = true, description =" 75 Verify that appropirate information message appears after enteriing non-existing data in all the fileds under 'Filter' link, on 'Gift Cards Dashboard' page.")
    public void verifyInvalidInputofFilterFields(){
        giftCardPage. verifyInvalidInputofFilterFields();
    }
     }






















