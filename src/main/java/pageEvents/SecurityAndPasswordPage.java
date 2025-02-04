package pageEvents;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.UUID;

public class SecurityAndPasswordPage extends BaseTest {

    private static final Logger log = LogManager.getLogger(SecurityAndPasswordPage.class);

    public By userProfile = By.cssSelector("a.btn.btn-link.p-0.fs-pn15[href='/Users/userprofile']");
    public By securityAndPasswordTab = By.xpath("//a[@class='list-group-item list-group-item-action'][@data-section='security']");
    public By editEmailBtn = By.cssSelector("button.btn.btn-outline-secondary[data-action='/users/_userProfile_replaceEmail']");
    public By updateEmailPopupTitle = By.cssSelector("h5.modal-title");
    public By closePopupBtn = By.cssSelector(".btn-close");
    public By updateEmailInputField = By.xpath("//input[@placeholder='email@gmail.com']");
    public By sendBtnForUpdatedEmail = By.cssSelector(".-email-.btn.btn-primary");
    public By alertMessage = By.xpath("//p[text()='Please review the highlighted field(s)']");
    public By currentSecurityCode = By.xpath("//input[@name='current_OTP']");
    public By newEmailSecurityCode = By.xpath("//input[@name='otp']");
    public By saveBtn = By.xpath("//button[@class='display-none -otp- btn btn-primary']");
    public By emailField = By.xpath("//input[@name='email'][@type='text']");
    public By invalidSecurityCodeValidationMsg = By.xpath("//p[text()='Security code cannot be verified for the current email.']");
    public By differentEmailBtn = By.xpath("//button[text()='Different Email']");
    public By sendBtnOfNewEMailPopup = By.xpath("//button[@class='-email- btn btn-primary']");
    public By securityVerificationError = By.xpath("//p[text()='Security code cannot be verified for the new email.']");
    public By editPhoneBtn = By.xpath("//button[@class='btn btn-outline-secondary'][@data-action='/users/_userProfile_replacePhone']");
    public By newPhoneInputField = By.xpath("//input[@name='phone'][@placeholder='+12125551234']");
    public By sendSecurityCodeForNewPhone = By.xpath("//button[@class='-phone- btn btn-primary']");
    public By closeNewPhonePopup = By.cssSelector(".btn-close");
    public By currentPhoneOTPField = By.xpath("//input[@name='current_otp']");
    public By newPhoneOTPField = By.xpath("//input[@name='otp']");
    public By differentCellPhone = By.xpath("//button[text()='Different Cell-phone']");
    public By updatePhoneNumberPopupTitle = By.xpath("//h5[text()='Update Cell-phone']");
    public By systemAlertMessage = By.cssSelector(".alert-heading");
    public By saveNewPhoneBtn = By.cssSelector(".display-none.-otp-.btn.btn-primary");
    public By resetYourPassword = By.xpath("//a[@href='#'][text()='Reset your password']");
    public By resetPwdEmailFIeld = By.cssSelector(".form-control.custom-select");
    public By resetPwdSecurityCodeBtn = By.cssSelector(".-email-.btn.btn-primary");
    public By resetPwdCodeInputField = By.cssSelector(".form-control-lg.fs-3.text-center.form-control");
    public By resetPwdContinueBtn = By.cssSelector(".btn-lg.btn.btn-primary");
    public By passwordField = By.xpath("//input[@name='password']");
    public By confirmPasswordField = By.xpath("//input[@name='confirmPassword']");
    public By showPasswordIcon = By.cssSelector(".fal.fa-eye-slash.custom-check-off");
    public By submitNewPasswordBtn = By.xpath("//button[@class='btn-lg btn btn-primary'][text()='Submit']");
    public By deleteEmailBtn = By.xpath("//button[@data-action='/users/_userProfile_deleteEmail']");
    public By deletePhoneBtn = By.xpath("//button[@data-action='/users/_userProfile_deletePhone']");
    public By deletePhoneValidationMsg = By.xpath("//p[text()='You cannot remove the phone number from a Business account.']");
    public By deleteEmailValidationMsg = By.xpath("//p[text()='You cannot remove the email address from a Business account.']");

    public void getSecurityAndPasswordPage(){
        click(userProfile);
        click(securityAndPasswordTab);
    }

    public void getEmailBtn() {
        click(editEmailBtn);
    }

    public void getEditPhoneBtn() {
        clickElementByJS(editPhoneBtn);
    }

    public void closePopup() {
        click(closePopupBtn);
    }

    public String generateRandomEmail() {
        String uniqueId = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return uniqueId + "@yopmail.com";
    }


}
