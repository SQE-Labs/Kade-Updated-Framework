package pageEvents;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BaseTest {

    private static final Logger log = LogManager.getLogger(BaseTest.class); // Logger instance

    //login method
    public static void Login() {
        // Fetch the username and password from the configuration file
        String username = configReader.getProperty("username");
        String password = configReader.getProperty("password");

        // Validate if username and password are present in the config file
        if (username == null || password == null) {
            log.error("Username or password is missing in the configuration file.");
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }

        // Log the username and password for debug purposes (considering security)
        log.debug("Attempting to login with username: {}", username);

        // Perform login action using the provided credentials
        pageObjectManager.getLoginPage().signIn(username, password);

        // Log the status of the action after clicking SignIn
        log.debug("User has successfully logged in and landed on the dashboard");

        // Verify the landing page is correct after login
        pageObjectManager.getHomePage().landingPage();


    }

    public static void LoginAsNewUser() {
        log.info("Starting Login test - Entering username and password");

        // Fetch the username and password from the configuration file
        String username = configReader.getProperty("newuser");
        String password = configReader.getProperty("newpass");

        // Validate if username and password are present in the config file
        if (username == null || password == null) {
            log.error("Username or password is missing in the configuration file.");
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }

        // Log the username and password for debug purposes (considering security)
        log.debug("Attempting to login with username: {}", username);

        // Perform login action using the provided credentials
        pageObjectManager.getLoginPage().signIn(username, password);

        // Log the status of the action after clicking SignIn
        log.debug("User has successfully logged in and landed on the dashboard");

        // Verify the landing page is correct after login
        pageObjectManager.getHomePage().landingPage();
    }

    public static void LoginAsNewUser1() {
        log.info("Starting Login test - Entering username and password");

        // Fetch the username and password from the configuration file
        String username = configReader.getProperty("newUserForNoPayment");
        String password = configReader.getProperty("password");

        // Validate if username and password are present in the config file
        if (username == null || password == null) {
            log.error("Username or password is missing in the configuration file.");
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }

        // Log the username and password for debug purposes (considering security)
        log.debug("Attempting to login with username: {}", username);

        // Perform login action using the provided credentials
        pageObjectManager.getLoginPage().signIn(username, password);

        // Log the status of the action after clicking SignIn
        log.debug("User has successfully logged in and landed on the dashboard");

        // Verify the landing page is correct after login
        pageObjectManager.getHomePage().landingPage();
    }

    public static void LoginAsGiftCardUser() {
        log.info("Starting Login test");

        // Fetch credentials
        String username = configReader.getProperty("giftcarduser");
        String password = configReader.getProperty("password");

        // Validate credentials
        if (username == null || password == null) {
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }

        // Perform login
        pageObjectManager.getLoginPage().signIn(username, password);

        // Verify successful login
        pageObjectManager.getHomePage().landingPage();
    }


    //login as customer method
    public static void LoginAsCustomer() {
        log.info("Starting Login test - Entering username and password");

        // Fetch the username and password from the configuration file
        String username = configReader.getProperty("customer");
        String password = configReader.getProperty("password");

        // Validate if username and password are present in the config file
        if (username == null || password == null) {
            log.error("Username or password is missing in the configuration file.");
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }

        // Log the username and password for debug purposes (considering security)
        log.debug("Attempting to login with username: {}", username);

        // Perform login action using the provided credentials
        pageObjectManager.getLoginPage().signIn(username, password);

        // Log the status of the action after clicking SignIn
        log.debug("User has successfully logged in and landed on the dashboard");

        // Verify the landing page is correct after login
        pageObjectManager.getHomePage().landingPage();
    }

    public static void LoginAsAdmin() {
        log.info("Starting Login test");

        // Fetch credentials
        String username = configReader.getProperty("admin");
        String password = configReader.getProperty("password");

        // Validate credentials
        if (username == null || password == null) {
            throw new RuntimeException("Username or password is missing in the configuration file.");
        }

        // Perform login
        pageObjectManager.getLoginPage().signIn(username, password);

        // Verify successful login
        pageObjectManager.getHomePage().landingPage();
    }
}
