package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import utils.Constants;
import org.testng.annotations.Test;

public class SignUpPage extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    // Locators for Personal Account
  public  By appLogo = By.xpath("//span[@class='app-name-logo']");
  public  By createNewAccountTitle = By.xpath("//div[@class='card-header text-center']");
  public  By emailOrPhoneLabel = By.xpath("//input[@name='phone_email']");
  public  By emailOrPhoneField = By.xpath("//input[@name='phone_email']");
  public  By signUpButton = By.xpath("//button[@class='btn-lg btn btn-primary']");
  public  By alreadyHaveAnAccountLabel = By.xpath("//p[contains(text(),'Already have an account?')]");
  public  By signInLink = By.xpath("//a[@class='ms-2']");
  public  By checkBox=By.xpath("//i[@class='fal fa-square custom-check-off ']");
  public  By businessAccountButton = By.xpath("//a[text()='Business Account']");
  public  By personalAccountButton = By.xpath("//a[text()='Personal Account']");
  public  By existingPhoneValidation = By.xpath("//p[text()='This phone number is already registered.']");
  public  By existingEmailValidation = By.xpath("//p[text()='This email is already registered.']");
  public  By crossIcon = By.cssSelector(".btn-close");
  public  By verifyAccountTitle = By.xpath("//h1[text()='Verify your account']");
  public  By securityCodeLabel = By.xpath("//label[text()='Security Code']");
  public  By securityCodeField = By.cssSelector("[name=\"otp\"]");
  public  By continueButton = By.xpath("//button[text()='Continue']");
  public  By setYourPasswordTitle = By.xpath("//h1[text()='Set your password']");
  public  By submitButton = By.xpath("//button[text()='Submit']");
  public  By passwordField = By.cssSelector("[name='password']");
  public  By confirmPasswordField = By.cssSelector("[name='confirmPassword']");
  public  By showPassword = By.cssSelector("[class='ms-2 text-start']");
  public  By successMessage = By.xpath("//p[@class='text-success fs-3']/.");
  public  By signInButton = By.xpath("//button[text()='Sign in']");
          By validation = By.xpath("//p[@class='alert-content']");

          // Locators for Business Account Option

   public By phoneFieldLabel = By.xpath("//div[@class='mb-3 -row- pt-3']/label[1]");
   public By useEmailLink = By.xpath("//button[text()='Use email']");
   public By mobilePhoneField = By.cssSelector("[name='phone']");
   public By emailBusinessField = By.cssSelector("[name='email']");
   public By fullname= By.cssSelector("[name='name']");
   public By startOverLink = By.cssSelector(".far.fa-edit");
   public By resendCode = By.xpath("//button[text()='Resend the code']");
   public By ContinueButtonBusiness = By.xpath("(//button[@type='submit'][text()='Continue'])[2]");
   public By securityCodeSendInfoMsg = By.cssSelector(".p-2.mb-2.fs-pn15");
   public By securityCodeAlertMessage = By.xpath("//p[text()='Invalid security code']");
   public By stripePageTitle = By.cssSelector(".header-title.mb-0");
   public By businessSignInButton = By.xpath("//button[text()='Sign in']");

   // Methods **********************
   public void getpersonalAccountButton(){
    click(personalAccountButton);
}
         public void getSignUpBtnPA(){
    click(signUpButton);
}
         public void getReceiveTextEmailNotificationCheckBox(){
    click(checkBox);
}
         public void getCrossIcon(){
    click(crossIcon);
}
public void getSignInLink(){click(signInLink);}
       public void getSubmitButton() {click(submitButton);}
       public void getContinueButton(){click(continueButton);}
       public void getBusinessAccount() {click(businessAccountButton);}
        public void getUseEmailLink(){click(useEmailLink);}
        public void getStartOverLink(){click(startOverLink);}
    public void getBusinessContinuebtn() {click(ContinueButtonBusiness);}











public void getValidationsOfPersonalAccountPage() {
    getpersonalAccountButton();
    getSignUpBtnPA();
    waitForElementToBeVisible(validation,3);

    // Verify the Please review the highlighted field validation message and This field is required Tooltip
    softAssert.assertTrue(isElementDisplayed(validation));
    String actualMessage = getToolTipMessage(emailOrPhoneField);
    softAssert.assertEquals(actualMessage, Constants.RequiredField);

    // Enter invalid data in 'Email or Phone' field
    enterText(emailOrPhoneField, Constants.invalidData);
//    getReceiveTextEmailNotificationCheckBox();
    getSignUpBtnPA();

    // tooltip message
    String actualToolTip = getToolTipMessage(emailOrPhoneField);
    softAssert.assertEquals(actualToolTip, Constants.emailandPhoneValidation);

    // Enter invalid email
    enterText(emailOrPhoneField, Constants.invalidEmail);
    waitForElementToBeClickable(signUpButton,5);
     getSignUpBtnPA();

    String invalidEmailTooltip = getToolTipMessage(emailOrPhoneField);
    softAssert.assertEquals(invalidEmailTooltip, Constants.emailValidation);

    // Entering existing phone number and verify the validation message
    enterText(emailOrPhoneField, Constants.phone);
    getReceiveTextEmailNotificationCheckBox();
    getSignUpBtnPA();

    //Verify the validation message for Phone Number
    String validation = getText(existingPhoneValidation);
    softAssert.assertEquals(validation, Constants.phoneValidation);
    getCrossIcon();

    // Verify the Validation for Existing Email
    enterText(emailOrPhoneField, Constants.existingEmail);
    getSignUpBtnPA();
    String existingemail = getText(existingEmailValidation);
    softAssert.assertEquals(existingemail, Constants.existingEmailValidation);
    softAssert.assertAll();
}








}






