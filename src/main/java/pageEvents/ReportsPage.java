package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;

public class ReportsPage extends BaseTest {

    String month ="January 2025";
    String month2 = "December - 2024";
    String day = "Sunday";
    public By storesComboBox = By.cssSelector(".select2-selection.select2-selection--single");
    public By storeSelection = By.xpath("//ul[@class=\"select2-results__options\"]//li[contains(text(), \"Automation Transaction 3\")]");
    public By continueBtn = By.xpath("//button[@class='btn btn-primary'][text()='Continue']");
    public By dailyPayConfirmation = By.xpath("//a[text()='Daily Payments Confirmations']");
    public By monthlyPayConfirmation = By.xpath("//a[text()='Monthly Payments Confirmations']");
    public By payReceived = By.xpath("//a[text()='Payments Received']");
    public By reportsPgHeading = By.cssSelector(".header-title.mb-0");
    public By storeCustomer = By.xpath("//ul[@class='select2-results__options']//li[contains(text(), 'Automation Customer Store')] ");
    public By NoResultIcon = By.cssSelector(".no-result-icon");
    public By monthCardHeader = By.cssSelector(".card-header");
    public By cardBody = By.xpath("//div[@class='card-body max-30c collapse show']");
    public By janDataDownload = By.xpath("(//a[contains(text(),'"+month+"')]//parent::div/div[1]//strong[text()='"+day+"'])[1]");
    public By firstLinkDownload = By.xpath("(//a[@class='btn btn-link stretched-link align-self-center'])[1]");
    public By selectJanuaryMonth = By.xpath("//a[@class='card-header collapsed' and text()='"+month+"']");
    public By topMonth = By.xpath("(//a[@class='card-header'])[1]");
    public By dec24Report = By.xpath("//strong[@class='align-self-center' and text()='"+month2+"']");
    public By totalReceivedamt = By.xpath("//div[@class='col-md-4'] //h4[text()='Total Received Amount']");
    public By totalTax = By.xpath("//div[@class='col-md-4'] //h4[text()='Total Tax']");
    public By totalTip = By.xpath("//div[@class='col-md-4'] //h4[text()='Total Tip']");
    public By filterBtn = By.cssSelector(".fas.fa-filter.me-1");
    public By todayFilter = By.xpath("//label[@class='btn btn-outline-primary ' and text()='Today']");
    public By yesterdayFilter = By.xpath("//label[@class='btn btn-outline-primary' and text()='Yesterday']");
    public By lastMonthFilter = By.xpath("//label[@class='btn btn-outline-primary' and text()='Last month']");
    public By customDateFilter = By.xpath("//label[@class='btn btn-outline-primary' and text()='Custom date']");
    public By dateRangePayReceived = By.xpath("//input[@name='dateRange']");
    public By applyDateRangePayRec = By.cssSelector(".btn-sm.mx-2.-btnapply-.btn.btn-outline-primary");
    public By printTotalReceivedPay = By.id("lblTotalReceivedAmount");
    public By printTotalTaxPay = By.id("lblTotalTax");
    public By printTotalTip = By.id("lblTotalTip");
    public By year24 = By.xpath("//a[text()='2024']");
    public By year25First = By.xpath("(//a[text()='This Year']//following-sibling::div/div/a)[1]");

    public By dec2024 =By.xpath("//a[text()='2024']/following-sibling::div//strong[text()='December - 2024']");
    public By manageBusinessAcc = By.xpath("//a[@class='sidebar-link fw-bold text-black collapsed' and text()='Manage Business']");
    public By reportsTab = By.cssSelector(".align-middle.me-2.fa-fw.far.fa-ballot");

    public void openReportsPage() {
        click(manageBusinessAcc);
        click(reportsTab);
        click(storesComboBox);
        click(storeSelection);
        click(continueBtn);
    }

    public void openCustStoreReportsPage() {
        click(manageBusinessAcc);
        click(reportsTab);
        click(storesComboBox);
        click(storeCustomer);
        click(continueBtn);
    }

}
