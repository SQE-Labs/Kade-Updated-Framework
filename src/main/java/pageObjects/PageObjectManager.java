package pageObjects;

import pageEvents.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageObjectManager {
    private static PageObjectManager pageObjectManager;
    public BillPage bill;
    private LoginPageEvents loginPage;
    private HomePageEvents homePage;
    private DashboardPage dashboardPage;
    private SidePannelPage sidePannelPage;
    private MyStorePage myStorePage;
    private SignUpPage signUpPage;
    private BasicInfoPage basicInfoPage;
    private SecurityAndPasswordPage securityAndPasswordPage;
    private RewardsProgramPage rewardsProgramPage;
    private CustomersPage customersPage;
    private ReportsPage reportsPage;
    private RewardPointsPage rewardPointsPage;
    private AdminPage adminPage;
    private TransactionsPage transactionsPage;
    private SearchPage searchPage;
    private GiftCardDashboardPage giftCardPage;
    private GiftCardPage giftCardspage;

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

        adminPage = new AdminPage();
        log.debug("Admin page instance created ");

        transactionsPage = new TransactionsPage();
        log.debug("Transactions page");

        searchPage= new SearchPage();
        log.debug("Search page instance created");

        giftCardPage= new GiftCardDashboardPage();
        log.debug("Gift Card DashBoard page instance created.");

        giftCardspage= new GiftCardPage();
        log.debug("Gift Card page");
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

    public AdminPage getAdminPage(){
        log.debug("Admin page instance");
        return adminPage;
    }

    public RewardPointsPage getRewardPointsPage() {
        log.debug("Reward Points page instance");
        return rewardPointsPage;
    }
    public SearchPage getSearchPage(){
        log.debug("Search page instance");
        return searchPage;
    }
    public TransactionsPage getTransactionsPage(){
        log.debug("Transactions page");
        return transactionsPage;
    }
    public GiftCardDashboardPage getGiftCardPage(){
        log.debug("Returning Gift Card Dashboard Page");
        return giftCardPage;
    }

    public GiftCardPage getGiftCardspage(){
        log.debug("Gift Card page");
        return giftCardspage;
    }

}
