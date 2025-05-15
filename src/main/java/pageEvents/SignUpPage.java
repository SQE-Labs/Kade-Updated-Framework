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
  public  By businessAccountButton = By.xpath("//span[text()='Business Account']");
  public  By personalAccountButton = By.xpath("//a[text()='Personal Account']");
  public  By existingPhoneValidation = By.xpath("//p[text()='This phone number is already registered.']");
  public  By existingEmailValidation = By.xpath("//p[text()='This email is already registered.']");
  public  By crossIcon = By.cssSelector(".btn-close");
  public  By verifyAccountTitle = By.xpath("//h1[text()='Verify your account']");
  public  By securityCodeLabel = By.xpath("//label[text()='Security Code']");
  public  By securityCodeField = By.xpath("//label[text()='Security Code:']//following-sibling::input");
  public  By continueButton = By.xpath("//button[text()='Continue']");
  public  By setYourPasswordTitle = By.xpath("//h1[text()='Set your password']");
  public  By submitButton = By.xpath("//button[text()='Submit']");
  public  By passwordField = By.cssSelector("[name='password']");
  public  By confirmPasswordField = By.cssSelector("[name='confirmPassword']");
  public  By showPassword = By.cssSelector("[class='ms-2 text-start']");
  public  By successMessage = By.xpath("//p[@class='text-success fs-3']/.");
  public  By signInButton = By.xpath("//button[text()='Sign in']");
          By validation = By.xpath("//p[@class='alert-content']");
          public By securityCodePC = By.xpath("//label[text()='Security Code']//following-sibling::input");

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

   // SignIn popup locators
   public By signInTitle = By.xpath("//h5[text()='Sign-in']");
   public By switchToEmailLinkSP = By.xpath("//button[text()='switch to email']");
   public By continueBtnSignInP = By.xpath("//div[@class='text-center mt-3 px-2 mb-3']/button[text()='Continue']");
   public By phoneNumberfieldLabelSP = By.xpath("//div[@class='-phone-div-   mb-2']/label");
   public By phoneFieldSP = By.xpath("//input[@name='userName' and @data-f-type='phone']");
   public By googleIconSP = By.cssSelector("[value='Google']");
   public By appleIconSP = By.cssSelector("[aria-label='Sign in with Apple']");
   public By pleaseReviewValidationSP = By.xpath("//p[text()='Please review the highlighted field(s)']");
   public By changeLinkSP = By.cssSelector("[class='btn-link btn p-0 -change-']");
   public By iDontKnowPasswordSP = By.cssSelector(".mx-3.-forgotpwd-");
   public By passwordFieldSignP = By.cssSelector("[name='password']");
   public By signInButtonSignInP = By.xpath("(//button[@class='btn btn-primary'])[4]");
   public By showPasswordSignInP = By.xpath("//span[text()='Show password']");
   public By informationMessageSP = By.cssSelector(".fw-bold.fst-italic");
   public By securityCodeLabelsignInP = By.cssSelector("label[class='mb-2']");
   public By newPasswordLabelSP= By.xpath("//label[text()='New password']");
   public By securityCodeFieldNewAccount = By.cssSelector("label +div>input[name='otp']");
   public By newPasswordFieldSP = By.xpath("//input[@name='password']");
   public By emailFieldSP = By.xpath("//input[@name='userName' and @type='email']");
   public By finalSignInbtn = By.cssSelector(".d-flex.justify-content-between.px-2 >button");
   public By invalidEmailValidation = By.cssSelector(".alert-heading+p");



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
     public void getSignInBtn(){click(signInButton);}

    // Sign In Popup Methods
    public void getContinueBtnSP(){
             click(continueBtnSignInP);
    }
public void getsignInButtonSignInP(){
             click(signInButtonSignInP);
}
public void getShowPasswordSP(){
             click(showPasswordSignInP);
}

public void getFinalSignInbtn(){
             click(finalSignInbtn);
}
public void getSwitchtoEmailLink(){
             click(switchToEmailLinkSP);
}
public void getIdonkKnowPasswordLinkSP(){
             click(iDontKnowPasswordSP);
}


public void getsignInWithEmailUsingBusinessAccount(){
    pageObjectManager.getLoginPage().getSignUpLink();
    getBusinessAccount();
    getCrossIcon();

    // Clicking on 'Sign In Button
     getSignInBtn();

    // Clicking on Switch to Email Link
     getSwitchtoEmailLink();
     enterText(emailFieldSP, Constants.validAdminEmail);
     getContinueBtnSP();
     waitForElementToBeVisible(iDontKnowPasswordSP,5);

     // Clicking on I don't know password link
    getIdonkKnowPasswordLinkSP();

    waitForElementToBeVisible(securityCodeLabelsignInP,5);

    // Verify the elements
    softAssert.assertTrue(isElementDisplayed(securityCodeLabelsignInP),"Security code label");
    softAssert.assertTrue(isElementDisplayed(informationMessageSP),"Information message");
    softAssert.assertTrue(isElementDisplayed(newPasswordLabelSP),"new passoword label");
    softAssert.assertTrue(isElementDisplayed(showPasswordSignInP),"show password");
    softAssert.assertTrue(isElementDisplayed(signInButtonSignInP),"sign in button ");
    waitForElementToBeClickable(securityCodeField,3);

    enterText(securityCodeField,Constants.securityCode);
    enterText(newPasswordFieldSP,Constants.validPassword);
      getShowPasswordSP();
      getFinalSignInbtn();
}

public void creatingNewAccountWithEmailWithBusinessAccount(){
    pageObjectManager.getLoginPage().getSignUpLink();
    //Clicking on Business Account Option
     getBusinessAccount();

    //Click on continue button and verify the Tooltip
     getContinueButton();


    // Click on Use Email Link
     getUseEmailLink();


    // Entering valid email in the Email field
    enterText(emailBusinessField,  requiredString(4)+ "@yopmail.com");

    // Checking the By providing my information, I consent to receive text/email notifications. checkbox
     getReceiveTextEmailNotificationCheckBox();
     getContinueButton();

    // Verify the start Over Link and resent code link
    softAssert.assertTrue(isElementDisplayed(startOverLink));
    softAssert.assertTrue(isElementDisplayed(resendCode));

    // Click on start over link and Continue button
    getStartOverLink();
    getContinueButton();

    // Enter data in security code field
    enterText(securityCodeFieldNewAccount, Constants.securityCode);
    waitForElementToBeClickable(fullname,6);

    //Entering name in the Full name field
    enterText(fullname, "New Kade Member" + requiredString(4));

    // Clicking on 'Continue' button
    getBusinessContinuebtn();
}






public void getValidationsOfPersonalAccountPage() {
    getpersonalAccountButton();
    getSignUpBtnPA();
    waitForElementToBeVisible(validation,10);

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






