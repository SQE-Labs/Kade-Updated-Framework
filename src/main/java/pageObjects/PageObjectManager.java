package pageObjects;

import pageEvents.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageObjectManager {
    public static PageObjectManager pageObjectManager;
    private LoginPageEvents loginPage;
    private HomePageEvents homePage;
    private DashboardPage dashboardPage;
    private SidePannelPage sidePannelPage;
    private MyStorePage myStorePage;
    private SignUpPage signUpPage;
//    private MyStorePage myStorePage;

    // Logger instance for logging messages
    private static final Logger log = LoggerFactory.getLogger(PageObjectManager.class);

    /**
     * Constructor to initialize all page event objects.
     * Ensures that all page event objects are created when the manager is instantiated.
     */
    public PageObjectManager() {
        log.info("Initializing PageObjectManager.");

        // Initializing LoginPageEvents
        loginPage = new LoginPageEvents();
        log.debug("LoginPageEvents instance created.");

        // Initializing HomePageEvents
        homePage = new HomePageEvents();
        log.debug("HomePageEvents instance created.");

        // Intializing DashboardEvents
        dashboardPage = new DashboardPage();
        log.debug("DashboardEvents instance created.");


        // Intializing SlidePannel
        sidePannelPage = new SidePannelPage();
        log.debug("Side Pannel instance created.");

        // Intializing Mystore Page
        myStorePage = new MyStorePage();
        log.debug("MyStore  instance is created ");

        signUpPage = new SignUpPage();
        log.debug("Signup instanced is created ");
    }


    /**
     * Singleton implementation for getting a single instance of PageObjectManager.
     * Ensures only one instance of PageObjectManager exists across the application.
     *
     * @return Single instance of PageObjectManager
     */
    public static PageObjectManager getInstance() {
        if (pageObjectManager == null) {
            log.info("Creating a new instance of PageObjectManager.");
            pageObjectManager = new PageObjectManager();
        }
        return pageObjectManager;
    }

    /**
     * Getter for LoginPageEvents object.
     *
     * @return LoginPageEvents object
     */
    public LoginPageEvents getLoginPage() {
        log.debug("Returning LoginPageEvents instance.");
        return loginPage;
    }

    /**
     * Getter for HomePageEvents object.
     *
     * @return HomePageEvents object
     */
    public HomePageEvents getHomePage() {
        log.debug("Returning HomePageEvents instance.");
        return homePage;
    }

    public DashboardPage getDashboardPage() {
        log.debug("Returning Dashboard instance.");
        return dashboardPage;
    }

    public SidePannelPage getSidePannel() {
        log.debug("Returning Dashboard instance.");
        return sidePannelPage;
    }

    public MyStorePage getMyStorePage() {
        log.debug("Returning the instance of My Store");
        return myStorePage;
    }

    public SignUpPage getSignUpPage() {
        log.debug("Returing the instance of SignUp page");
        return signUpPage;
    }
}





