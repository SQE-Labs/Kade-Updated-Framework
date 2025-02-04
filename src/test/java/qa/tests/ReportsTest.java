package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObjectManager;
import pageEvents.ReportsPage;
import utils.Constants;

public class ReportsTest extends BaseTest {

    public static Logger log = LogManager.getLogger(BasicInformationPage.class);

    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();

    private ReportsPage reportsPage = pageObjectManager.getReportsPage();

    @Test
    public void verifyReportsPgOpens() {
        log.info("Verify that Reports page opens up");

        Login();
        reportsPage.openReportsPage();

        Assert.assertTrue(isElementDisplayed(reportsPage.dailyPayConfirmation));
        Assert.assertTrue(isElementDisplayed(reportsPage.reportsPgHeading));
        Assert.assertTrue(isElementDisplayed(reportsPage.monthlyPayConfirmation));
        Assert.assertTrue(isElementDisplayed(reportsPage.payReceived));
    }

    @Test
    public void verifyReportsPgForCustStore() {
        log.info("Verify that reports page opens for customer store");

        Login();
        reportsPage.openCustStoreReportsPage();

        Assert.assertTrue(isElementDisplayed(reportsPage.NoResultIcon));
    }

    @Test
    public void verifyDailyReport() {
        log.info("Verify that daily report appears on report page");

        Login();
        reportsPage.openReportsPage();

        Assert.assertTrue(isElementDisplayed(reportsPage.monthCardHeader));
        Assert.assertTrue(isElementDisplayed(reportsPage.cardBody));
    }

    @Test
    public void verifyDownloadedReports() {
        log.info("Verify that reports get downloaded on csv format");

        Login();
        reportsPage.openReportsPage();

        clickElementByJS(reportsPage.selectJanuaryMonth);
        DeleteFile(Constants.fileNameDaily);
        scrollToElement(reportsPage.janDataDownload);
        staticWait(2000);
        clickElementByJS(reportsPage.janDataDownload);
        String fileStatus = isFileDownloaded(Constants.fileNameDaily);
        System.out.println("fileStatus :" + fileStatus);
        Assert.assertEquals(fileStatus,Constants.filePresent);
    }

    @Test
    public void verifyMonthlyPayConfirmationReport() {
        log.info("Verify that monthly reports get generated under 'Monthly Payments Confirmations' tab on 'Reports' page, after every month end.");

        Login();
        reportsPage.openReportsPage();

        click(reportsPage.monthlyPayConfirmation);
        click(reportsPage.year24);
        waitForElementToBeVisible(reportsPage.dec24Report,10);
        Assert.assertTrue(isElementDisplayed(reportsPage.dec24Report));
        DeleteFile(Constants.filenameMonthly);
        waitForElementToBeInteractable(reportsPage.dec24Report,10);
        clickElementByJS(reportsPage.dec24Report);
        staticWait(2000);
        String fileStatus = isFileDownloaded(Constants.filenameMonthly);
        System.out.println("fileStatus :" + fileStatus);
        Assert.assertEquals(fileStatus,Constants.filePresent);
    }

    @Test
    public void verifyPaymentReceived() {
        log.info("Verify that stats of total received amount appears on 'Payment Received' tab, after clicking on 'Payment Received' tab, on Reports page.");

        Login();
        reportsPage.openReportsPage();

        click(reportsPage.payReceived);
        Assert.assertTrue(isElementDisplayed(reportsPage.totalReceivedamt));
        Assert.assertTrue(isElementDisplayed(reportsPage.totalTax));
        Assert.assertTrue(isElementDisplayed(reportsPage.totalTip));
    }

    @Test
    public void verifyTodayStats() {
        log.info("Verify that 'Today' statistics appear after clicking on 'Today' from 'Filter'");

        Login();
        reportsPage.openReportsPage();

        click(reportsPage.payReceived);
        click(reportsPage.todayFilter);
        staticWait(1000);
        System.out.println(getElementText(reportsPage.printTotalReceivedPay));
        System.out.println(getElementText(reportsPage.printTotalTaxPay));
        System.out.println(getElementText(reportsPage.printTotalTip));

        click(reportsPage.yesterdayFilter);
        staticWait(1000);
        System.out.println(getElementText(reportsPage.printTotalReceivedPay));
        System.out.println(getElementText(reportsPage.printTotalTaxPay));
        System.out.println(getElementText(reportsPage.printTotalTip));

        click(reportsPage.lastMonthFilter);
        staticWait(1000);
        System.out.println(getElementText(reportsPage.printTotalReceivedPay));
        System.out.println(getElementText(reportsPage.printTotalTaxPay));
        System.out.println(getElementText(reportsPage.printTotalTip));
    }

    @Test
    public void verifyCustomDateRange() {
        log.info("Verify that statistics for selected date range appear on 'Payments received' tab after selecting a date range");

        Login();
        reportsPage.openReportsPage();

        click(reportsPage.payReceived);
        click(reportsPage.customDateFilter);
        waitForElementToBeVisible(reportsPage.applyDateRangePayRec,20);
        enterText(reportsPage.dateRangePayReceived, Constants.dateRange);
        click(reportsPage.applyDateRangePayRec);
        System.out.println(getElementText(reportsPage.printTotalReceivedPay));
        System.out.println(getElementText(reportsPage.printTotalTaxPay));
        System.out.println(getElementText(reportsPage.printTotalTip));
    }
}
