package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageEvents.*;
import pageObjects.PageObjectManager;
import org.testng.Assert;

import utils.Constants;


public class DashboardTest extends BaseTest {
    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private DashboardPage dashboard = pageObjectManager.getDashboardPage();
    PaymentPage payment = new PaymentPage();
    TransactionsPage transaction = new TransactionsPage();
    BillPage bill = new BillPage();


    @Test(description = "DC01 & 2 Verify all sections are displayed on the 'Dashboard")
    public void verifyAllSection() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();
        // verifying the sections on the Dashboard Page

        //Your Business Section
        softAssert.assertEquals(getText(dashboard.yourBusinessTitle), Constants.YourBusinessTitle);
        softAssert.assertEquals(getText(dashboard.processPaymentTitle), Constants.ProcessPayment);
        softAssert.assertEquals(getText(dashboard.customerTitle), Constants.CustomerTitle);
        softAssert.assertEquals(getText(dashboard.messageTitle), Constants.MessageTitle);
        softAssert.assertEquals(getText(dashboard.recentTransactionsTitle), Constants.RecentTransaction);
        softAssert.assertEquals(getText(dashboard.todayPaymentTitle), Constants.TodaysPaymentTitle);
        softAssert.assertEquals(getText(dashboard.pymtmethodPopularityTitle), Constants.PaymentMethodPopularityTitle);
        softAssert.assertEquals(getText(dashboard.customerTitle), Constants.CustomerTitle);
        softAssert.assertAll();
    }

    @Test(description = "DC 03, 04, DC 05,06,07: Verify that 'No. of stores' count appears under 'Your Businesses' section, on the 'Dashboard' page.")
    public void verifyCountOfAllStores() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getMyStoreTab();

        // Verifying the store count on my store page
        int storeCount = dashboard.getMyStoreCount();
        System.out.println("Store Count on MyStore page is " + storeCount);
        scrollToElement(pageObjectManager.getSidePannel().manageBusinessAcc);

        pageObjectManager.getSidePannel().getMangeBusinessTab();
        scrollToElement(pageObjectManager.getSidePannel().dashboardTab);
        pageObjectManager.getSidePannel().getDashboardTab();
        int dashboardCount = Integer.parseInt(getText(dashboard.storeCountDashboard));

        // verify both store count match on Dashboard and Mystore page.
        softAssert.assertEquals(storeCount, dashboardCount);
        // Verify the Process Payment of Last 30 days
        softAssert.assertTrue(isElementDisplayed(dashboard.last30DaysTotalAmount));
        System.out.println("last 30 days Total Amount " + getText(dashboard.last30DaysTotalAmount));

        // Verify the  customer count of all stores displayed under Customer Section
        softAssert.assertTrue(isElementDisplayed(dashboard.last30DaysCustomerCount));
        System.out.println("Total Count of last 30 days of all stores " + getText(dashboard.last30DaysCustomerCount));

        // Verify that Today's Payment appears of  all stores under 'Today's Payment' section.
        softAssert.assertTrue(isElementDisplayed(dashboard.todayPayment));
        System.out.println("Sum of Today's payment of all stores: " + getText(dashboard.todayPayment));
        softAssert.assertAll();
    }

    @Test(description = " DC08: Verify that user get directed to 'Messages' page after clicking on 'Contact Support' link under 'Messages' section, on 'Dashboard' page.")
    public void userGetDirectToMessagePage() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();

        // user gets directed to Message page
        dashboard.getContactSupportLink();
        Assert.assertTrue(isElementDisplayed(dashboard.messagePage));
    }

    @Test(description = "DC 18, 19 & 20,21,22,23& 24: Verify that user get directed to 'Dashboard' page of store after selecting store, on 'No. of stores' popup, under 'Your Businesses' section.")
    public void verifyThatDirectedToDashboardPageOfSelectedStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();

        // Clicking on the first store from the Store Popups
        dashboard.getDashboardStoreCount();
        dashboard.getFirstStore();

        // Clicking on the your business link to get redirected to the All stores dashboard page.
        dashboard.getYourBusinessLink();

        // Verify the Process Payment of Last 30 days of a store
        dashboard.getDashboardStoreCount();
        dashboard.getFirstStore();
        softAssert.assertTrue(isElementDisplayed(dashboard.last30DaysTotalAmount));
        System.out.println("Process Payment of Last 30 days is:  " + getText(dashboard.last30DaysTotalAmount));

        // Verify the  customer count of a stores displayed under Customer Section
        softAssert.assertTrue(isElementDisplayed(dashboard.last30DaysCustomerCount));
        System.out.println("Total Count of last 30 days of a stores: " + getText(dashboard.last30DaysCustomerCount));

        // Verify that Today's Payment appears of  a stores under 'Today's Payment' section.
        softAssert.assertTrue(isElementDisplayed(dashboard.todayPayment));
        System.out.println("Sum of Today's payment of a stores is : " + getText(dashboard.todayPayment));


        // Verify that store Configuration page title appears after clicking on setting icon
        dashboard.getSettingIcon();
        softAssert.assertTrue(isElementDisplayed(dashboard.storeConfigurationTitle));
        dashboard.getDriver().navigate().back();

        // Verify that user gets directed to message page of the same store.
        dashboard.getContactSupportLink();

    }

    @Test(description = "DC15, DC16: Verify that Radar chart displaying Payment Methods Popularity for past 30 days of all stores appears in 'Payment Methods Popularity' section, on 'Dashboard' page.")
    public void verifyTheRadarChartPaymentMethods() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();
        scrollToElement(dashboard.paths);
        dashboard.getGraphTraverse();
    }

    @Test(description = "DC 31 and 32: Verify that Radar chart displaying Payment Methods Popularity for past 30 days of store appears in 'Payment Methods Popularity' section.")
    public void verifyRadarchartPaymentMethodOfSelectedStore() {
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();
//        dashboard.getDashboardStoreCount();
//        dashboard.getFirstStore();
        scrollToElement(dashboard.paths);
//         dashboard.getGraphTraverse();
        dashboard.getCustomerGraphData();
    }

    @Test(description = "DC09,DC10, DC11 and DC 12: Verify that Recent transactions of all stores appear under 'Recent transactions' section, on 'Dashboard' page.")
    public void verifyThatRecentTransactionForAllStoreAppearsUnderRecentTransactionSection() {

        bill.createBillWithCustomer("636045278965", "saybo@yopmail.com");
        payment.billPaymentByThroughDebitCard("4111111111111111", "0930", "794", "Australia");
        payment.swipeCard();
        staticWait(3000);
        scrollToElement(payment.viewReciptTxt);
        waitForElementToBeVisible(payment.viewReciptTxt, 3);
        staticWait(3000);
        scrollToElement(payment.viewReciptTxt);
        waitForElementToBeVisible(payment.viewReciptTxt, 3);
        payment.clickOnViewReciptLink();

        pageObjectManager.getSidePannel().getSignOut();
        staticWait(3000);

        // login as store manager
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        transaction.getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        transaction.getContinueButton();

        // Clicking on Current Paid bill
        transaction.getCurrentPaidBill();
        waitForElementToBeVisible(transaction.customerName, 5);
        String customerName = getText(transaction.customerName);
        String payment = getText(transaction.payment);
        String time = getText(transaction.time);
        staticWait(3000);
        transaction.getCrossIconOfCurrentPaidBill();
        staticWait(3000);
        scrollToDown();

        //Clicking on the Dashboard Tab
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();
        staticWait(3000);


        // Verifying the recent Transaction.

        softAssert.assertEquals(getText(dashboard.customerNameUnderRTSection), customerName);
        softAssert.assertEquals(getText(dashboard.recentAmountUnderRT), payment);
        softAssert.assertEquals(getText(dashboard.recentRTTime), time);

        // Verify that user is able to refresh the transaction list
        dashboard.getRefreshBtn();
        waitForElementToBeVisible(dashboard.customerNameUnderRTSection, 4);


        // Verify that Compelete transaction popup appears after clicking on any  Transaction.
        dashboard.getTimeUnderRT();

        softAssert.assertTrue(isElementDisplayed(dashboard.transactionPopup));
        dashboard.getRTpopupCrossIcon();

        // Verify that user gets directed to the 'Transactions' page after clicking on 'Full List' link.
        dashboard.getFullListLink();
    }

    @Test(description = "DC 25,DC 26, DC 27 & DC 28: Verify that Recent transactions of a store appear under 'Recent transactions' section, on 'Dashboard' page of a store.")
    public void verifyThatRecentTransactionAfterClickingOnAStore() {
        // login as store manager
        Login();
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getTransactionTab();
        transaction.getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        transaction.getContinueButton();

        // Clicking on Current Paid bill
        transaction.getCurrentPaidBill();
        waitForElementToBeVisible(transaction.customerName, 5);
        String customerName = getText(transaction.customerName);
        String payment = getText(transaction.payment);
        String time = getText(transaction.time);
        staticWait(4000);
        transaction.getCrossIconOfCurrentPaidBill();
        staticWait(3000);
        scrollToDown();

        staticWait(3000);

        //Clicking on the Dashboard Tab
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();
        staticWait(4000);
        dashboard.getDashboardStoreCount();

        dashboard.getFirstStore();
        waitForElementToBeVisible(dashboard.customerNameUnderRTSection, 4);


        // Verifying the recent Transaction.

        softAssert.assertEquals(getText(dashboard.customerNameUnderRTSection), customerName);
        softAssert.assertEquals(getText(dashboard.recentAmountUnderRT), payment);
        softAssert.assertEquals(getText(dashboard.recentRTTime), time);

        // Verify that user is able to refresh the transaction list
        dashboard.getRefreshBtn();
        waitForElementToBeVisible(dashboard.customerNameUnderRTSection, 4);


        // Verify that Compelete transaction popup appears after clicking on any  Transaction.
        dashboard.getTimeUnderRT();

        softAssert.assertTrue(isElementDisplayed(dashboard.transactionPopup));
        dashboard.getRTpopupCrossIcon();

        // Verify that user gets directed to the 'Transactions' page after clicking on 'Full List' link.
        dashboard.getFullListLink();
    }

    @Test(description = "DC13 and DC14 :Verify that 'Customer Trends' graph of all stores is displayed in 'Customer Trends' section, on 'Dashboard' page.")
    public void verifyCustomerTrendGraphofAllStores() {
        Login();

        //Clicking on the Dashboard Tab
        pageObjectManager.getSidePannel().getMangeBusinessTab();
        pageObjectManager.getSidePannel().getDashboardTab();

        scrollToElement(dashboard.customerTrends);

        // Verify Customer Trends section is displayed
        softAssert.assertTrue(isElementDisplayed(dashboard.customerTrends));
        softAssert.assertTrue(isElementDisplayed(dashboard.newLabel));
        softAssert.assertTrue(isElementDisplayed(dashboard.repeatingLabel));

        dashboard.getCustomerTrend();


    }
}


































        









