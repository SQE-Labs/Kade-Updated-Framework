package qa.tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageEvents.LoginPage;
import utils.Constants;

/**
 * This class contains test methods for the login functionality of the application.
 * It extends the BaseTest class to inherit common setup and utility methods.
 */
public class LoginTest extends BaseTest {

    /**
     * This method runs before each test method. It navigates to the login page URL
     * specified in the Constants class.
     */
    @BeforeMethod
    public void setUp() {
        // Navigate to the login page URL
        getDriver().get(Constants.URL);
    }

    /**
     * This test method verifies the login functionality with valid credentials.
     * It creates an instance of the LoginPage class, then calls the login method
     * with the username and password defined in the Constants class.
     */
    @Test(description = "Verify login functionality with valid credentials")
    public void testLoginWithValidCredentials() {
        // Create an instance of the LoginPage class
        LoginPage loginPage = new LoginPage();
        // Call the login method with valid username and password
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);
    }
}