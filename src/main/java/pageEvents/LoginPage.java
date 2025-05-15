package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;

/**
 * This class represents the Login Page and contains methods to interact with its elements.
 * It extends the BaseTest class to inherit common setup and utility methods.
 */
public class LoginPage extends BaseTest {

    // Locators for Login Page elements
    /**
     * Locator for the username input field.
     */
    By usernameField = By.cssSelector("input[name='userName']");
    /**
     * Locator for the password input field.
     */
    By passwordField = By.cssSelector("input[name='passWord']");
    /**
     * Locator for the sign-in button.
     */
    By signInButton = By.xpath("//*[@id='loginAdvDivId']/div[2]/div/button");
    /**
     * Locator for the "Forgot Password?" link.
     */
    By forgotPasswordLink = By.linkText("Forgot Password?");
    /**
     * Locator for the error message displayed upon invalid login.
     */
    By errorMessage = By.cssSelector("div.alert.alert-danger");

    /**
     * Enters the username into the username input field.
     *
     * @param username The username to enter.
     */
    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    /**
     * Enters the password into the password input field.
     *
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    /**
     * Clicks the sign-in button to submit the login form.
     */
    public void clickLoginButton() {
        click(signInButton);
    }

    /**
     * Clicks the "Forgot Password?" link to navigate to the password recovery page.
     */
    public void clickForgotPasswordLink() {
        click(forgotPasswordLink);
    }

    /**
     * Retrieves the text of the error message displayed upon invalid login.
     *
     * @return The error message text.
     */
    public String getErrorMessageText() {
        return getText(errorMessage);
    }

    /**
     * Performs the complete login process by entering the username and password
     * and then clicking the sign-in button.
     *
     * @param username The username to enter.
     * @param password The password to enter.
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}