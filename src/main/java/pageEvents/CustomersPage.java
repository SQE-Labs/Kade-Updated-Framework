package pageEvents;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Constants;

public class CustomersPage extends BaseTest {

    By manageBusinessAcc = By.xpath("//a[@class='sidebar-link fw-bold text-black collapsed' and text()='Manage Business']");
    By CustomersBtn = By.cssSelector(".fa-fw.fas.fa-user-friends");
    By customersPageText = By.cssSelector(".header-title.mb-0");
    By storesCombobox = By.xpath("//span[@role='combobox']");
    By selectStore = By.xpath("//ul[@class=\"select2-results__options\"]//li[contains(text(), \"Automation Customer Store\")]");
    By cnt = By.cssSelector(".btn.btn-primary");
    public By nameAddress = By.xpath("//div[@class='d-flex flex-column  overflow-hidden']");
    public By findAddCustomer = By.xpath("//button[@class='-addnew- btn btn-outline-dark']");
    public By filter = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    public By phoneNumber = By.xpath("//input[@placeholder='Phone number. Existing or new']");
    public By goBtn = By.xpath("//input[@placeholder='Phone number. Existing or new']/..//button");
    public By emailGoBtn = By.xpath("(//input[@placeholder='Email. Existing or new' and @name='email']/..//button)");
    public By customerName = By.xpath("(//input[@lbl-title=\"Customer's name?\"])[2]");
    public By done = By.xpath("//button[text()=\"Done\"]");
    public By emailField = By.xpath("//input[@placeholder='Email. Existing or new' and @name='email']");
    public By filterPhoneNumber = By.xpath("(//input[@class='form-control'])[1]");
    public By filterPhonenumberInvalid = By.xpath("(//input[@class='form-control is-invalid'])[1]");
    public By filterEmail = By.xpath("(//input[@class='form-control'])[2]");
    public By invalidFilterEmail = By.xpath("//input[@class='form-control is-invalid']");
    public By filterName  = By.xpath("(//input[@class='form-control'])[3]");
    public By filterApplyBtn = By.xpath("//button[@class='btn-sm mt-4 -apply- btn btn-primary']");
    public By filterTitle = By.xpath("//h5[@class='offcanvas-title']");
    public By pencilIcon = By.xpath("//i[@class='fas fa-pencil fs-pn15']");
    public By chngeName = By.xpath("//input[@name='userAliasName']");
    public By saveBtn = By.xpath("//button[@class='float-end mt-2 mb-2 btn btn-primary']");
    public By eyeIcon = By.cssSelector("[href='/Stores/userProfile/3790?userid=3436']");
    public By profileHeading = By.xpath("//h1[@class='header-title mb-0']");
    public By messageIcon = By.cssSelector(".fal.fa-paper-plane.fa-2x");
    public By trophieIcon = By.xpath("//a[@class='align-self-center p-0 btn btn-link']");
    public By storeName = By.xpath("//h3[@class='text-truncate']");
    public By messagePg = By.xpath("//h1[@class='header-title mb-0']");
    public By typeArea = By.cssSelector(".form-control");
    public By sendBtn = By.cssSelector(".btn.btn-primary.align-self-start.mt-1");
    public By unsendBtn = By.xpath("//button[@class='btn btn-outline-danger align-self-start mt-1 -deleteMessage-']");
    public By deletecnfrm = By.cssSelector(".btn.btn-outline-success");
    public By addRewardpts = By.cssSelector(".btn.btn-outline-primary.floar-start.collapsed.btn-sm");
    public By memoinput = By.xpath("//input[@placeholder='Memo']");
    public By rewardPoints = By.xpath("//input[@placeholder='Points']");
    public By submitRewardPts = By.cssSelector(".btn.btn-outline-primary.ms-auto");
    public By phoneValidation = By.cssSelector(".alert.alert-error.text-danger.display-none");
    public By customerPopupClose = By.xpath("(//button[@class=\"btn-close\"])[2]");
    public By emailValidation = By.xpath("(//div[@class=\"alert alert-error text-danger  display-none\"])[2]");
    public By newBill = By.cssSelector(".fs-4");
    public By newBillDropdown = By.xpath("//span[@class=\"select2-selection select2-selection--single\"]");
    public By newBillSoreSelection = By.xpath("//ul[@class='select2-results__options']//li[contains(text(), \"Automation Cust Test\")]");
    public By newBillBrn = By.cssSelector(".fs-p15.btn.btn-outline-dark");
    public By amountInput = By.xpath(" //input[@name='amount']");
    public By selectCustomer = By.xpath("(//label[text()=\"Customer\"])[2]");
    public By billPhonenumber = By.xpath("//input[@placeholder=\"Phone number\"]");
    public By billPhoneGoBtn = By.xpath("(//button[@class='btn btn-primary'][text()='Go'])[1]");
    public By billSendBtn = By.xpath("//div[@class='d-none -link-cust-d-block']");
    public By customerDisplayed = By.xpath("(//div[text()='yonro'])[1]");
    public By customerDisplayed2 = By.xpath("(//span[text()=\"Yonro\"])[1]");
    public By searchField = By.xpath("//input[@placeholder=\"Search by name\"]");
    public By searchBtn = By.xpath("//input[@placeholder='Search by name']/..//button");
    public By alertValidation = By.xpath("//h4[@class=\"alert-heading\"]");
    public By noResult = By.xpath("//div[@class='no-result-icon']");
    public By selectCustomerinFilter = By.xpath("//div[@class='d-flex align-items-center position-relative mb-3 rounded border']");
    public By customerSelection = By.xpath("//div[@class='border rounded-3 mb-1 p-2 position-relative clone']");
    public By customerdisplayed = By.xpath("//div[@class='bg-white mb-2 row position-relative m-0 g-2 border rounded-2 -cust-row-']");
    public By addPaymentMethod = By.xpath("//button[@class='-btn-add-payment- btn-sm btn btn-link']");
    public By permissionChkbx = By.xpath("//i[@class='fal fa-square custom-check-off ']");
    public By permissionCtnBtn = By.xpath("//button[@class='checked-d-inline-block d-none -launch-add-paymentmethod- btn btn-primary']");
    public By addCardNumberField = By.xpath("//input[@placeholder='1234 1234 1234 1234']");
    public By expirationDate = By.xpath("//input[@class='p-Input-input Input Input--empty p-Input-input--textRight']");
    public By securityCode = By.xpath("//input[@placeholder='CVC']");
    public By countrySelect = By.xpath("//select[@class=\"Input p-Select-select\"]");
    public By selectCountry = By.xpath("//option[text()=\"Australia\"]");
    public By saveCardBtn = By.xpath("//button[@class=\"btn btn-primary display-none\"]");
    public By closefilter = By.xpath("//button[@class='btn-close text-reset']");
    public By frame1 = By.xpath("//iframe[@title='Secure payment input frame']");
    public By amountText = By.xpath("//label[text()='Amount']");
    public By closePopup = By.xpath("//div[@class='modal fade show' and not(@data-bs-keyboard='false')] //child::button");
    public By addGiftCardBtn = By.xpath("//div[contains(@class, 'justify-content-between m')]/button");
    public By initialAmt = By.xpath("//input[@name='initialAmount']");
    public By createGiftCardBtn = By.cssSelector(".btn.btn-success.btn-lg.w-100");

    public void navigateToCustomersPage() {
        click(manageBusinessAcc);
        click(CustomersBtn);
        click(storesCombobox);
        click(selectStore);
        click(cnt);
    }

    public void applyFilter(String phoneNumber) {
        click(filter);
        waitForElementToBeInteractable(filterPhoneNumber,20);
        actionEnterText(filterPhoneNumber, phoneNumber);
        click(filterApplyBtn);
    }

    public void tryCatchFilter() {
        try {
            waitForElementToBeVisible(filterEmail,10);
        } catch (Exception e) {
            click(filter);
        }
    }

    public void saveNewByCreditCard() {
        enterText(addCardNumberField, Constants.cardNumber);
        enterText(expirationDate, Constants.expDate);
        enterText(securityCode, Constants.cardSecurityCode);
        click(countrySelect);
        click(selectCountry);
        click(saveCardBtn);
    }

}
