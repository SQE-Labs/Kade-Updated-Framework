package pageEvents;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends BaseTest {

    // Logger instance for logging messages
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    // Locators:
    public By yourBusinessTitle = By.cssSelector("div.card-body h5:nth-child(1)");
    public By customerTitle = By.cssSelector("div.card-body h5:nth-child(2)");
    public By last30DaysCustomerCount = By.xpath("(//h1[contains(@class, 'display-5 mt-2 mb-4')])[1]");
    public By messageTitle = By.cssSelector("div[class='row mb-1'] h5[class='card-title']");
    public By processPaymentTitle = By.xpath("//h5[text()='Processed Payments']");
    public By last30DaysTotalAmount = By.cssSelector("div:nth-child(1) >div >h1");
    public By todayPaymentTitle = By.xpath("//h5[text()='Today’s Payments']");
    public By todayPayment = By.xpath("(//h1[contains(@class, 'display-5 mt-2 mb-4')])[3]");
    public By recentTransactionsTitle = By.cssSelector("a +h5.card-title.mb-0");
    public By customerNameUnderRTSection = By.cssSelector(".card-body .row.g-1.p-1 >div> div:nth-child(2)");
    public By recentAmountUnderRT = By.cssSelector(" div:nth-child(4) strong");
    public By recentRTTime = By.cssSelector(" div:nth-child(4) strong+a");
    public By refreshIcon = By.cssSelector(".card-title.mb-0 .btn >i");
    public By fullListLink = By.cssSelector("a.float-end");
    public By transactionPopup = By.cssSelector("div div.modal-content:nth-child(1)");
    public By RTpopupCrossIcon = By.cssSelector(" h5+ button.btn-close:nth-child(2)");
    public By customerTrends = By.xpath("//h5[text()='Customer Trends']");
    public By pymtmethodPopularityTitle = By.xpath("//h5[text()='Payment Methods Popularity']");
    public By contactSupportLink = By.cssSelector(".card-title +h6 a");
    public By myStore = By.cssSelector("[class^='card p-2 border w-20c overflow-hidden']");
    public By storeCountDashboard = By.xpath("(//span[@class='badge rounded-pill bg-dark ms-n1'])[2]");
    public By listofStoreNameonPopup = By.cssSelector("div.popover-body span:nth-child(1)");
    public By getFirstStore = By.cssSelector(".popover-body >div a:nth-child(1)");
    public By settingIcon = By.cssSelector("a.p-0.float-end");
    public By yourBusinessLink = By.cssSelector("span.fs-pn15 + a");
    public By messagePage = By.cssSelector("nav.navbar >h1 ");
    public By storeConfigurationTitle = By.cssSelector("h1.header-title");
    public By storeName = By.cssSelector(".d-flex.flex-column h3");
    public By bankAccountGraph = By.cssSelector("g[id^=\"Svgjs\"] path.apexcharts-pie-area.apexcharts-polararea-slice-0");
    public By graphContainer = By.cssSelector("g.apexcharts-inner .apexcharts-pie");
    public By paths = By.cssSelector("g.apexcharts-pie g.apexcharts-series >path");
    public By paymentNames = By.cssSelector(".chart .apexcharts-legend.apexcharts-align-center >div");
    // Customer Trends
    public By monthsLabel = By.cssSelector(".apexcharts-xaxis-texts-g >text");
    public By newLabel = By.xpath("//div[@class='apexcharts-legend-series' and @seriesname='New']");
    public By repeatingLabel = By.xpath("//div[@class='apexcharts-legend-series' and @seriesname='Repeating']");
    public By customerCount = By.cssSelector(" div.apexcharts-tooltip.apexcharts-theme-light div.apexcharts-tooltip-y-group >span");
    public By custGraphLine = By.xpath("(//*[name()='rect' and @class='apexcharts-grid-row'])[4]");
    By lastDEC = By.xpath("(//*[contains(@id,'SvgjsText')])[6]");
    public By timeUnderRT = By.xpath("//a[@class='text-truncate ms-auto mt-1 stretched-link']");
    // Methods


    public void getFirstStoreUnderYourBusiness() {
        click(getFirstStore);
    }

    public void getSettingIcon() {
        click(settingIcon);
    }

    public void getYourBusinessLink() {
        click(yourBusinessLink);
    }

    public void getRecentRTAmount() {
        click(recentAmountUnderRT);
    }

    public void getRecentRTTime() {
        click(recentRTTime);
    }

    public void getCustomerNameUnderRTSection() {
        clickElementByJS(customerNameUnderRTSection);
    }

    public void getRTpopupCrossIcon() {
        click(RTpopupCrossIcon);
    }

    public void getContactSupportLink() {
        click(contactSupportLink);
    }

    public int getMyStoreCount() {
        // Verifying the store count from my store page.
        List<WebElement> storeElements = getDriver().findElements(myStore);
        // Return the count of elements
        return storeElements.size();
    }

    public void getDashboardStoreCount() {
        click(storeCountDashboard);
    }

    public void getFirstStore() {
        click(getFirstStore);
    }

    public void getPathsofGraph() {
        click(paths);
    }


    public void getGraphTraverse() {
        List<WebElement> pieSlices = getDriver().findElements(paths);

        Actions actions = new Actions(getDriver());
        // Hover over each slice and fetch the tooltip data
        for (WebElement slice : pieSlices) {
            // Hover over the slice
            actions.moveToElement(slice).perform();

            List<WebElement> graphElements = getDriver().findElements(paths);
            List<WebElement> paymentElements = getDriver().findElements(paymentNames);

            // List to store payment method and data value pairs
            List<String> paymentDataPairs = new ArrayList<>();

            int size = Math.min(graphElements.size(), paymentElements.size());
            System.out.println("Number of elements to process: " + size);

            for (int i = 0; i < size; i++) {
                // Retrieve payment name
                String paymentName = paymentElements.get(i).getAttribute("seriesName");

                // Retrieve data value
                String dataValue = graphElements.get(i).getAttribute("data:value");

                // Store the payment method and data value pair
                paymentDataPairs.add("Payment Name: " + paymentName + ", Data Value: " + dataValue);
            }
            System.out.println("All Payment Data Pairs: " + paymentDataPairs);
        }
    }

    public void getCustomerGraphData() {
        List<WebElement> graphLines = getDriver().findElements(custGraphLine);
        Actions actions = new Actions(getDriver());

        for (WebElement graphLine : graphLines) {
            // Hover over the graph point
            actions.moveToElement(graphLine).pause(java.time.Duration.ofSeconds(2)).perform();
            staticWait(2000); 

            // Re-fetch customer data inside the loop (in case of dynamic changes)
            List<WebElement> updatedCustomerData = getDriver().findElements(customerCount);

            // Get corresponding customer data
            int index = graphLines.indexOf(graphLine);
            if (index < updatedCustomerData.size()) {
                WebElement customerPoint = updatedCustomerData.get(index);

                // Retrieve text
                String graphLineText = graphLine.getText();
                String customerText = customerPoint.getText();

                System.out.println("Graph Coordinate: " + graphLineText + " | Customer Data: " + customerText);
            }

        }
    }
public void getRefreshBtn(){
        click(refreshIcon);
}
public void getFullListLink(){
        click(fullListLink);
}
public void getTimeUnderRT(){
        click(timeUnderRT);
}


}




