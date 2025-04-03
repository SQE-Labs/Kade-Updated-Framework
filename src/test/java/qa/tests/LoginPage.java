package qa.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageObjects.PageObjectManager;
import utils.Constants;

/**
 * Test class for the Login page functionality.
 * This class tests the login functionality by entering valid credentials and verifying the landing page.
 */
public class LoginPage extends BaseTest {

    // Logger for logging test execution details
    public static Logger log = LogManager.getLogger(LoginPage.class);

    // Page Object Manager for accessing Page Events
    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    // Page Events for Login and Home pages
    private LoginPageEvents loginPage = pageObjectManager.getLoginPage();
    private HomePageEvents homePage = pageObjectManager.getHomePage();

    /**
     * Test method for logging into the application.
     * It enters the username and password, clicks the SignIn button,
     * and verifies the landing page after login.
     */
    //@Test
//    public void Login() {
//        log.info("Starting Login test - Entering username and password");
//
//        // Fetch the username and password from the configuration file
//        String username = configReader.getProperty("username");
//        String password = configReader.getProperty("password");
//
//        // Validate if username and password are present in the config file
//        if (username == null || password == null) {
//            log.error("Username or password is missing in the configuration file.");
//            throw new RuntimeException("Username or password is missing in the configuration file.");
//        }
//
//        // Log the username and password for debug purposes (considering security)
//        log.debug("Attempting to login with username: {}", username);
//
//        // Perform login action using the provided credentials
//        loginPage.signIn(username, password);
//
//        // Log the status of the action after clicking SignIn
//        log.debug("User has successfully logged in and landed on the dashboard");
//
//        // Verify the landing page is correct after login
//        homePage.landingPage();
//    }
    @Test(priority = 1, enabled = true, description = "Verify the Login Page Fields's Validations")
    public void verifyLoginPage() {
        loginPage.verifyLoginPageFields();
    }

    @Test(priority = 2, enabled = true, description = " Verify that user get directed to 'Create New Account' page")
    public void validateSignUpLink() {
        loginPage.getSignUpLink();
        String popupTitle = getText(loginPage.popupTitle);
        Assert.assertEquals(popupTitle, "New Account");
    }

    @Test(priority = 3,enabled = true, description = "Verify that  'User Agreement' page opens up, when  user clicks on 'Terms Of Use' link, on 'Login' page. & Verify that " + " 'Privacy' page opens up, when  user clicks on 'Privacy Policy' link, on 'Login' page.")
        public void verifyPrivacyAndTermsOfUsePage() {
        loginPage.getTermsofUseLink();
        // Store the parent window handle
        String parentWindowHandle = getDriver().getWindowHandle();

        Assert.assertTrue(isElementDisplayed(loginPage.termsOfUse));
        loginPage.switchToWindow("Terms of Use Page");
        String actualTitle = getPageTitle();
        String expectedTitle = "Terms Of Use";
        staticWait(3000);
        switchToParentWindow(parentWindowHandle);
        waitForElementToBeInteractable(loginPage.privacyPolicyLink,3);
        loginPage.getPrivacyPolicylink();
        loginPage.switchToWindow("Privacy Policy");
        Assert.assertTrue(isElementDisplayed(loginPage.privacyPolicyTitle));
    }
    @Test(priority = 4, enabled = true, description =" Verify that Forgot Password page appears after clickin gon 'Forgot Password' link")
    public void validateForgotPasswordLink(){
        loginPage.getForgotPassowrdLink();
        String actualTitle = getPageTitle();
        Assert.assertEquals(actualTitle, Constants.ForgetPasswordtitle);
        loginPage.verifyForgetPassword();

    }
    @Test(priority = 5, enabled = true, description = "Verify that user gets logged in with google account when user  clicks on 'Sign in using your Google account' link, on 'Login' page.")
    public void signInwithGoogle(){
        loginPage.getSignInWithGoogle();
        enterText(loginPage.googleEmailField,"");


    }

    @Test(priority = 6,enabled = true,description = "Verify that user is able to login successfully, after entering valid data in all the mandatory fields.")
    public void successfulLogin(){
        Login();
        String title = getPageTitle();
        Assert.assertEquals(title,Constants.transactionsTitle);
    }

}


