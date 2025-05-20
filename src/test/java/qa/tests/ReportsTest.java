package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObjectManager;
import pageEvents.ReportsPage;
import utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


// Bug Id is : 2966
    @Test
        public void verifyDownloadedReports() {
            log.info("Verify that reports get downloaded in CSV format");

            Login();
            reportsPage.openReportsPage();

            DeleteFile(Constants.fileNameDaily);
            clickElementByJS(reportsPage.firstLinkDownload);
            staticWait(2000);


            String data= getAttribute(reportsPage.dataDownloaded,"data-download");

            Pattern storeIdPattern = Pattern.compile("storeId=(\\d+)");
            Pattern datePattern = Pattern.compile("reportdate=(\\d{2})%2f(\\d{2})%2f(\\d{4})");

            Matcher storeIdMatcher = storeIdPattern.matcher(data);
            Matcher dateMatcher = datePattern.matcher(data);

            String finalResult = "";

            if (storeIdMatcher.find() && dateMatcher.find()) {
                String storeId = storeIdMatcher.group(1);
                String month = dateMatcher.group(1);
                String day = dateMatcher.group(2);
                String year = dateMatcher.group(3);

                finalResult = storeId + "-" + year + "-" + month + "-" + day;
                System.out.println("file downloaded is " + finalResult);  // e.g. 2938-2025-04-26
            } else {
                log.error("Failed to extract storeId or reportDate from data: " + data);
            }
        // Assuming finalResult is already calculated as "2962-2025-04-26"
        String[] dateParts = finalResult.split("-");
        String downloadedDay = dateParts[3];

        // Now extract day from the UI element
        WebElement uiDayElement = getDriver().findElement(By.xpath("(//span[@class='position-relative align-self-center text-muted'])[1]/span"));
        String uiDay = uiDayElement.getText().trim();  // e.g. "26"

        // Compare
         Assert.assertEquals(uiDay, downloadedDay, "Asserting UI day and downloaded report day.");
         staticWait(5000);

//        String fileStatus = isFileDownloaded(Constants.fileNameDaily);
//
//        staticWait(3000);
//        System.out.println("fileStatus :" + fileStatus);
//        Assert.assertEquals(fileStatus,Constants.filePresent);
    }

    @Test
    public void verifyMonthlyPayConfirmationReport() {
        log.info("Verify that monthly reports get generated under 'Monthly Payments Confirmations' tab on 'Reports' page, after every month end.");

        Login();
        reportsPage.openReportsPage();

        click(reportsPage.monthlyPayConfirmation);
        //click(reportsPage.year24);
        waitForElementToBeVisible(reportsPage.year25First,10);
        Assert.assertTrue(isElementDisplayed(reportsPage.year25First));
        DeleteFile(Constants.filenameMonthly);
        waitForElementToBeInteractable(reportsPage.year25First,10);
        clickElementByJS(reportsPage.year25First);
        staticWait(5000);
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
        waitForElementToBeVisible(reportsPage.applyDateRangePayRec,10);
        enterText(reportsPage.dateRangePayReceived, Constants.dateRange);
        click(reportsPage.applyDateRangePayRec);
        System.out.println(getElementText(reportsPage.printTotalReceivedPay));
        System.out.println(getElementText(reportsPage.printTotalTaxPay));
        System.out.println(getElementText(reportsPage.printTotalTip));
    }
}
