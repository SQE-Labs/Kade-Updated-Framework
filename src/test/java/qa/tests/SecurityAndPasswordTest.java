package qa.tests;

import base.BaseTest;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.PageObjectManager;
import pageEvents.SecurityAndPasswordPage;
import utils.Constants;

import java.util.UUID;

public class SecurityAndPasswordTest extends BaseTest {

    public static Logger log = LogManager.getLogger(BasicInformationPage.class);

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    private SecurityAndPasswordPage securityAndPasswordPage = pageObjectManager.getSecurityAndPasswordPage();

    @Test
    public void verifyUpdateEmailPopupOpens() {
        log.info("Verify Update Email popup opens");

        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        securityAndPasswordPage.getEmailBtn();
        staticWait(2000);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.updateEmailPopupTitle));
        securityAndPasswordPage.closePopup();

    }

    @Test
    public void verifyInvalidEmailUpdateInput() {
        log.info("Verify for Invalid Email inputs in Update email address popup");

        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        securityAndPasswordPage.getEmailBtn();
        enterText(securityAndPasswordPage.updateEmailInputField, " ");
        click(securityAndPasswordPage.sendBtnForUpdatedEmail);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.alertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.updateEmailInputField), Constants.requiredFieldValidation, "tool tip");
        securityAndPasswordPage.closePopup();
        waitForElementInVisible(securityAndPasswordPage.closePopupBtn, 30);

        securityAndPasswordPage.getEmailBtn();
        enterText(securityAndPasswordPage.updateEmailInputField, Constants.emailInput);
        click(securityAndPasswordPage.sendBtnForUpdatedEmail);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.alertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.updateEmailInputField), Constants.invalidEmailValidation, "tool tip");
        securityAndPasswordPage.closePopup();
        waitForElementInVisible(securityAndPasswordPage.closePopupBtn, 30);

        securityAndPasswordPage.getEmailBtn();
        String currentEmail = getAttribute(securityAndPasswordPage.emailField,"value");
        enterText(securityAndPasswordPage.updateEmailInputField,currentEmail);
        click(securityAndPasswordPage.sendBtnForUpdatedEmail);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.alertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.updateEmailInputField), Constants.sameEmailErrorMessage, "tool tip");
    }

    @Test
    public void verifyValidEmailUpdateInput(){
        log.info("Verify for Valid Email inputs in Update email address popup");

        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        securityAndPasswordPage.getEmailBtn();
        String randomEmail = securityAndPasswordPage.generateRandomEmail();
        enterText(securityAndPasswordPage.updateEmailInputField, randomEmail);
        click(securityAndPasswordPage.sendBtnForUpdatedEmail);
        enterText(securityAndPasswordPage.currentSecurityCode," ");
        enterText(securityAndPasswordPage.newEmailSecurityCode," ");
        click(securityAndPasswordPage.saveBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.alertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.currentSecurityCode), Constants.requiredFldValidation, "tool tip");
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.newEmailSecurityCode), Constants.requiredFldValidation, "tool tip");

        enterText(securityAndPasswordPage.currentSecurityCode,Constants.invalidSecurityCode);
        enterText(securityAndPasswordPage.newEmailSecurityCode,Constants.validSecurityCode);
        click(securityAndPasswordPage.saveBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.invalidSecurityCodeValidationMsg));

        enterText(securityAndPasswordPage.currentSecurityCode,Constants.validSecurityCode);
        enterText(securityAndPasswordPage.newEmailSecurityCode,Constants.invalidSecurityCode);
        click(securityAndPasswordPage.saveBtn);
        waitForElementToBeVisible(securityAndPasswordPage.securityVerificationError,10);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.securityVerificationError));

        enterText(securityAndPasswordPage.currentSecurityCode,Constants.incompleteSecurityCode);
        enterText(securityAndPasswordPage.newEmailSecurityCode,Constants.IncompleteSecurityCode2);
        click(securityAndPasswordPage.saveBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.alertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.currentSecurityCode), Constants.atLeastCharReqMessage, "tool tip");
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.newEmailSecurityCode), Constants.atLeastCharReqMessage, "tool tip");

        click(securityAndPasswordPage.differentEmailBtn);
        click(securityAndPasswordPage.sendBtnOfNewEMailPopup);
        enterText(securityAndPasswordPage.currentSecurityCode,Constants.validSecurityCode);
        enterText(securityAndPasswordPage.newEmailSecurityCode,Constants.validSecurityCode);
        click(securityAndPasswordPage.saveBtn);
    }

    @Test
    public void UpdatePhoneNumber() {
        log.info("Verify user is able to edit phone number");

        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        click(securityAndPasswordPage.editPhoneBtn);
        waitForElementToBeVisible(securityAndPasswordPage.updatePhoneNumberPopupTitle,10);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.updatePhoneNumberPopupTitle));

        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.alertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.newPhoneInputField), Constants.requiredFldValidation, "tool tip");

        actionEnterText(securityAndPasswordPage.newPhoneInputField,Constants.invalidPhoneNumber);
        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.newPhoneInputField), Constants.invalidPhnValidation, "tool tip");
        click(securityAndPasswordPage.closeNewPhonePopup);
    }

    @Test
    public void verifyAllSecurityCodeScenarios() {
        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        click(securityAndPasswordPage.editPhoneBtn);

        waitForElementToBeVisible(securityAndPasswordPage.newPhoneInputField,10);
        actionEnterText(securityAndPasswordPage.newPhoneInputField,Constants.validPhoneNumber);
        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        click(securityAndPasswordPage.saveNewPhoneBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.systemAlertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.newPhoneOTPField), Constants.requiredFldValidation, "tool tip");
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.currentPhoneOTPField), Constants.requiredFldValidation, "tool tip");

        enterText(securityAndPasswordPage.currentPhoneOTPField,Constants.validSecurityCode);
        enterText(securityAndPasswordPage.newPhoneOTPField,Constants.incompleteSecurityCode);
        click(securityAndPasswordPage.saveNewPhoneBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.systemAlertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.newPhoneOTPField), Constants.LeastCharReqMessage, "tool tip");

        enterText(securityAndPasswordPage.currentPhoneOTPField,Constants.validSecurityCode);
        enterText(securityAndPasswordPage.newPhoneOTPField,Constants.invalidSecurityCode);
        click(securityAndPasswordPage.saveNewPhoneBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.systemAlertMessage));

        clickElementByJS(securityAndPasswordPage.differentCellPhone);
        waitForElementToBeVisible(securityAndPasswordPage.newPhoneInputField,10);
        actionEnterText(securityAndPasswordPage.newPhoneInputField,Constants.diffCellNumber);
        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        enterText(securityAndPasswordPage.currentPhoneOTPField,Constants.validSecurityCode);
        enterText(securityAndPasswordPage.newPhoneOTPField,Constants.validSecurityCode);
    }

    @Test
    public void verifyAlternatePhoneNumber() {
        log.info("Verify user can update/change phone number using Different phone number option");

        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        click(securityAndPasswordPage.editPhoneBtn);

        waitForElementToBeVisible(securityAndPasswordPage.newPhoneInputField,10);
        actionEnterText(securityAndPasswordPage.newPhoneInputField,Constants.validPhoneNumber);
        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        click(securityAndPasswordPage.differentCellPhone);
        actionEnterText(securityAndPasswordPage.newPhoneInputField,Constants.invalidPhoneNumber);
        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.systemAlertMessage));
        Assert.assertEquals(getToolTipMessage(securityAndPasswordPage.newPhoneInputField), Constants.invalidPhnValidation, "tool tip");
        click(securityAndPasswordPage.closeNewPhonePopup);
        waitForElementInVisible(securityAndPasswordPage.closeNewPhonePopup,20);

        click(securityAndPasswordPage.editPhoneBtn);
        waitForElementToBeVisible(securityAndPasswordPage.newPhoneInputField,10);
        actionEnterText(securityAndPasswordPage.newPhoneInputField,Constants.validPhoneNumber);
        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        click(securityAndPasswordPage.differentCellPhone);
        waitForElementToBeVisible(securityAndPasswordPage.newPhoneInputField,10);
        actionEnterText(securityAndPasswordPage.newPhoneInputField,Constants.validPhoneNumber2);
        click(securityAndPasswordPage.sendSecurityCodeForNewPhone);
        enterText(securityAndPasswordPage.currentPhoneOTPField,Constants.validSecurityCode);
        enterText(securityAndPasswordPage.newPhoneOTPField,Constants.validSecurityCode);
        click(securityAndPasswordPage.saveNewPhoneBtn);
    }

    @Test
    public void verifyResetYourPasswordPopupOpens() {
        log.info("verify that 'Chnage password' popup opens up, when user clicks on 'Reset your password' button");

        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        click(securityAndPasswordPage.resetYourPassword);

        click(securityAndPasswordPage.resetPwdSecurityCodeBtn);
        enterText(securityAndPasswordPage.resetPwdCodeInputField,Constants.validSecurityCode);
        click(securityAndPasswordPage.resetPwdContinueBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.passwordField));
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.confirmPasswordField));
    }

    @Test
    public void verifyDeleteButton() {
        log.info("Verify validation message appears when clicked on delete button");

        Login();
        securityAndPasswordPage.getSecurityAndPasswordPage();
        click(securityAndPasswordPage.deleteEmailBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.deleteEmailValidationMsg));
        click(securityAndPasswordPage.deletePhoneBtn);
        Assert.assertTrue(isElementDisplayed(securityAndPasswordPage.deletePhoneValidationMsg));
    }


}
