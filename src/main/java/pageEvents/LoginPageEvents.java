package pageEvents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import base.BaseTest;
import utils.Constants;

public class LoginPageEvents extends BaseTest {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(LoginPageEvents.class);

    // Locators for Login Page elements
    private By usernameTextField = By.cssSelector("input[name='userName']"); // Locator for the username input field
    private By passwordTextField = By.cssSelector("input[name='passWord']"); // Locator for the password input field
    private By signInButton = By.xpath("//*[@id='loginAdvDivId']/div[2]/div/button"); // Locator for the Sign-In button
    // Locators
    public By userNameField = By.cssSelector("[name='userName']");
    By passwordField =By.cssSelector("[name='passWord']");
    public By forgotPasswordLink = By.linkText("Forgot password?");
    By signUpLink = By.linkText("Sign up");
    By validation = By.xpath("//p[@class='alert-content']");
    public By termsOfUse = By.linkText("Terms Of Use");
    public By popupTitle = By.xpath("//h5[normalize-space()='New Account']");
    By credentialsValidation  = By.cssSelector(".alert-content");
    public By privacyPolicyTitle = By.cssSelector(".mb-3.fs-pn15");
    public By privacyPolicyLink = By.cssSelector(" .p-2.fs-pn25.text-center>a+a");

    // Forget Password page locators
    By continueBtn= By.cssSelector(".btn-lg.btn.btn-primary");
    By emailPhoneField = By.cssSelector("[name='phone_email']");
    By signInLinkFP = By.cssSelector(".fs-6>a");
    By verifyAccountTitle = By.xpath("//h1[text()='Verify your account']");
    By enteredEmailorPhone = By.cssSelector(".badge.bg-light");
    By changeLinkFP = By.cssSelector(".badge.bg-light+a");
    By securityCodeField = By.cssSelector(".form-control-lg.fs-3");
    By recentSecurityCodeLink = By.cssSelector(".-resend-.btn.btn-link");
    By securityCodeTostmsg = By.cssSelector(".toast-message");
    By validationCrossIcon = By.cssSelector(".btn-close.autoclick-effect");
    By alreadyHaveAccount = By.cssSelector(".fs-6 ");
    By googleAccount = By.cssSelector("[value='Google']");
    public By googleEmailField= By.cssSelector(".Xb9hP >[type='email']");
    By nextBtn = By.xpath("//span[text()='Next']");





    /**
     * Method to perform login by entering username and password and clicking the Sign-In button.
     *
     * @param username The username to enter in the username field
     * @param password The password to enter in the password field
     */
    public void signIn(String username, String password) {
        log.info("Starting the sign-in process.");
        
        // Enter username
        log.info("Entering username: {}", username);
        enterText(usernameTextField, username); // Using BaseTest's reusable method to enter text

        // Enter password
        log.info("Entering password: {}", password);
        enterText(passwordTextField, password); // Using BaseTest's reusable method to enter text

        // Click on Sign-In button
        log.info("Clicking on the Sign-In button.");
        click(signInButton); // Using BaseTest's reusable method to click

        log.info("Sign-in process completed.");
    }
    public void getNextButton(){
        click(nextBtn);
    }
    public void getSignUpLink(){
        click(signUpLink);
    }
    public void getSignInBtn(){click(signInButton);}
    public void getForgotPassowrdLink(){
        click(forgotPasswordLink);
    }
    public void getTermsofUseLink(){
        click(termsOfUse);
    }
    public void getPrivacyPolicylink(){
        click(privacyPolicyLink);
    }
    public void getPrivacyPolicyTitle(){
        click(privacyPolicyTitle);
    }
    public void getValidationCrossIcon(){
        click(validationCrossIcon);
    }
    public void getSignInWithGoogle(){
        click(googleAccount);
    }
    public void getAlreadyHaveAccountLabel(){
        waitForElementToBeClickable(alreadyHaveAccount,3);
        click(alreadyHaveAccount);
    }

    public void verifyLoginPageFields(){

        // verify field gets highlighted after clicking on Sign In.
        getSignInBtn();
        getToolTipMessage(usernameTextField);
        getToolTipMessage(passwordTextField);
        String actualAttribute = getAttribute(userNameField,"class");
        String expectedAttribute="form-control form-control-lg is-invalid";
        softAssert.assertEquals(actualAttribute, expectedAttribute);
        waitForElementToBeInteractable(usernameTextField,3);

        // verify that tooltip appears on entering invalid Email or PhoneNumber
        enterText(usernameTextField,"Test@");
        actionEnterText(passwordField,Constants.invalidData);
        getSignInBtn();
        getToolTipMessage(usernameTextField);
        waitForElementToBeInteractable(usernameTextField,3);
        cleanByJS(usernameTextField);
        enterText(usernameTextField,Constants.invalidEmail);
        getSignInBtn();

        // Tooltip and validation message
        String actualValidation = getText(credentialsValidation);
        softAssert.assertEquals(actualValidation, Constants.credentialsValidationLP);
        softAssert.assertAll();

    }
    public void getContinueBtnFP(){
        click(continueBtn);
    }
    public void getSignInLinkFP(){
        click(signInLinkFP);
    }
    public void getChangeLinkFP(){
       click(changeLinkFP);
    }


    public void  verifyForgetPassword(){
        getContinueBtnFP();
        // verify the validation
        getToolTipMessage(emailPhoneField);
        getAlreadyHaveAccountLabel();

        // Enter invalid data
        enterText(emailPhoneField,Constants.invalidData);

        waitForElementToBeInteractable(emailPhoneField,5);
        getAlreadyHaveAccountLabel();
        String text= getToolTipMessage(emailPhoneField);
        softAssert.assertEquals(text,Constants.userPhnEmailTooltip);
        cleanByJS(emailPhoneField);
        waitForElementToBeClickable(emailPhoneField,5);

        // enter invalid email
        enterText(emailPhoneField,Constants.invalidEmail);
        getAlreadyHaveAccountLabel();
        String text2 = getToolTipMessage(emailPhoneField);
        waitForElementToBeClickable(continueBtn,5);
//        getContinueBtnFP();
        softAssert.assertEquals(text2 ,Constants.invalidEmailValidation);
        cleanByJS(emailPhoneField);
        waitForElementToBeClickable(emailPhoneField,5);

        // enter valid email address
        enterText(emailPhoneField,Constants.validLoginEmail);
        getContinueBtnFP();
        softAssert.assertTrue(isElementDisplayed(verifyAccountTitle));

        // click on change link
        getChangeLinkFP();

        // enter valid phone number
        enterText(emailPhoneField,Constants.phone);
        getContinueBtnFP();

        // click on continue button
        getContinueBtnFP();
        waitForElementToBeInteractable(securityCodeField,3);
        String tooltip = getToolTipMessage(securityCodeField);
        softAssert.assertEquals(tooltip, Constants.requiredFldValidation);
        enterText(securityCodeField,Constants.phoneSecurityCodeForLogin);
        getContinueBtnFP();

        waitForElementToBeInteractable(pageObjectManager.getSignUpPage().setYourPasswordTitle,5);
        softAssert.assertTrue(isElementDisplayed(pageObjectManager.getSignUpPage().setYourPasswordTitle));

        pageObjectManager.getSignUpPage().getSubmitButton();

        getToolTipMessage(pageObjectManager.getSignUpPage().passwordField);
        enterText(pageObjectManager.getSignUpPage().passwordField,Constants.validPassword);
        enterText(pageObjectManager.getSignUpPage().confirmPasswordField,Constants.validPassword);
        pageObjectManager.getSignUpPage().getSubmitButton();
        softAssert.assertAll();
    }



}
