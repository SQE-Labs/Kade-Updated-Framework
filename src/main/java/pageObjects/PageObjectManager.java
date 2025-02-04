package pageObjects;

import pageEvents.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageObjectManager {
    private static PageObjectManager pageObjectManager;
    private BasicInfoPage basicInfoPage;
    private SecurityAndPasswordPage securityAndPasswordPage;
    private RewardsProgramPage rewardsProgramPage;
    private CustomersPage customersPage;
    private ReportsPage reportsPage;
    private RewardPointsPage rewardPointsPage;

    // Logger instance for logging messages
    private static final Logger log = LoggerFactory.getLogger(PageObjectManager.class);

    /**
     * Constructor to initialize all page event objects.
     * Ensures that all page event objects are created when the manager is instantiated.
     */
    public PageObjectManager() {
        log.info("Initializing PageObjectManager.");

        basicInfoPage = new BasicInfoPage();
        log.debug("BasicInfoPage instance created.");

        securityAndPasswordPage = new SecurityAndPasswordPage();
        log.debug("Security And Password instance created");

        rewardsProgramPage = new RewardsProgramPage();
        log.debug("Rewards program page instance created");

        customersPage = new CustomersPage();
        log.debug("Customers Page instance created");

        reportsPage = new ReportsPage();
        log.debug("Reports Page instance created");

        rewardPointsPage = new RewardPointsPage();
        log.debug("Reward Ponts Page instance created");
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
     * Getter for BasicInfoPageEvents object.
     *
     * @return BasicInfoPageEvents object
     */
    public BasicInfoPage getbasicInfoPage() {
        log.debug("Returning BasicInfoPageEvents instance.");
        return basicInfoPage;
    }

    public SecurityAndPasswordPage getSecurityAndPasswordPage() {
        log.debug("Returning SecurityAndPassword instance.");
        return securityAndPasswordPage;
    }

    public RewardsProgramPage getRewardsProgramPage() {
        log.debug("Returning RewardsProgramPage Instance.");
        return rewardsProgramPage;
    }

    public CustomersPage getCustomersPage() {
        log.debug("Returning Customers Page instance");
        return customersPage;
    }

    public ReportsPage getReportsPage() {
        log.debug("Returning Reports Page instance");
        return reportsPage;
    }

    public RewardPointsPage getRewardPointsPage() {
        log.debug("Reward Points page instance");
        return rewardPointsPage;
    }

}
