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
    By privacyPolicyTitle = By.cssSelector(".mb-3.fs-pn15");
    By privacyPolicyLink = By.cssSelector(" .p-2.fs-pn25.text-center>a+a");

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


}
