package qa.tests;

import base.BaseTest;
import logger.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.PaymentPage;
import pageEvents.QRCodePage;

import java.awt.*;

import static pageEvents.LoginPage.Login;

public class QRCodeTest extends BaseTest {

    QRCodePage qrCode = new QRCodePage();

    PaymentPage payment = new PaymentPage();
    String TitleName = "Donation " + requiredString(3);
    String TitleNameTxt = "Donation " + requiredString(5);
    String TitleFieldTxt = "Donation " + requiredString(5);

    @Test(priority = 0, enabled = true)
    public void typesOfQrCodes() {
        Login();
        qrCode.typesOfQrCodes();
    }

    @Test(priority = 1, enabled = true)
    public void directPaySection() {
        Login();
        qrCode.directPaySect("100.00");
        payment.clickOnVenomoAccount();
    }

    @Test(priority = 2, enabled = true)
    public void directPayByViewLink() {
        Login();
        qrCode.DirectPayByViewLink("100.00");
        payment.clickOnVenomoAccount();
    }

    @Test(priority = 3, enabled = true)
    public void contactScreenSection() {
        Login();
        qrCode.contactScreenSect();
    }

    @Test(priority = 4, enabled = true)
    public void custPermSection() {
        Login();
        qrCode.custPermSect();
    }

    @Test(priority = 5, enabled = true)
    public void createNewQrCode() {
        Login();
        qrCode.createNewQrCode();
    }

    @Test(priority = 6, enabled = true)
    public void flexibleAmountQrCode() throws AWTException {
        Login();
        qrCode.flexibleAmountQrCode("I am done", "Entered in title field", "Content tye text");
    }

    // Bug : Current date is not selecting.

    @Test(priority = 7, enabled = true)
    public void addAdditionalField() {
        Login();
        qrCode.addAdditionalField("I am done");
        qrCode.clickOnEditIcon();
        qrCode.enterTxtInFlexibleAmtField("Updated Header");
        qrCode.clickOnCorrectIcon();
        qrCode.clickOndeleteIcon();
        qrCode.clickOnCalenderIcon();
        waitForElementToBeVisible(qrCode.monthHeader, 10);
        String calenderHead = getText(qrCode.monthHeader);
        Log.info("Current Month is :" + calenderHead);
        Assert.assertTrue(isElementDisplayed(qrCode.monthHeader));
        qrCode.clickOncurrentDate();
        qrCode.enableToggle();
        qrCode.clickOnflexibleAmtSaveBtn();
        qrCode.clickOnEyeIcon();
        qrCode.ClickOnViewIcon();
        switchToNewWindow();
        String linkNotTxt = getText(qrCode.linkNotAvailableTxt);
        Assert.assertEquals(linkNotTxt, "This link is not available.");
    }

    @Test(priority = 8, enabled = true)
    public void returnToQrDashboardPage() {
        Login();
        qrCode.selectStore();
        qrCode.clickOnPencilIcon();
        qrCode.clickOndashboardLink();
    }

    @Test(priority = 8, enabled = true, description = "payment Throgh Temporarily Unavailable Toggle button making off")
    public void paymentThroghTemporarilyUnavailable() {
        Login();
        qrCode.paymentThroughByenablingTheToggleBtn("100.00");
    }

    @Test(priority = 9, enabled = true, description = "Create fixed amount create code")
    public void fixedAmountQrCode() {
        Login();
        qrCode.fixedAmountQrCode("Nothing to be added", "100.00");
    }

    @Test(priority = 10, enabled = true, description = "Create fixed amount create code")
    public void ticketsAndEventsQrCode() {
        Login();
        qrCode.ticketsAndEvents("200.00");
    }

    @Test(priority = 11, enabled = true, description = "Filter Qr Code")
    public void filterQrCode() {

        Login();
        qrCode.QrFilter();
    }


    // New scripts writing

    @Test(priority = 12, enabled = true, description = "Verify that creating Donation QR Code, after clicking on 'Generate new QR Code' button.")
    public void VerifyThatCreatingDonationQRCode() throws AWTException {
        Login();
        qrCode.donationQRCode(TitleName, "100000", TitleNameTxt, TitleFieldTxt);
    }

    @Test(priority = 13, enabled = true, description = "Verify that making QR Code Donation payment after clicking on eye icon, on QR Code Dashboard' page.")
    public void VerifyThatMakingQRCodeDonationQRCode() throws AWTException {
        Login();
        qrCode.MakingQRCodeDonation();
    }


}