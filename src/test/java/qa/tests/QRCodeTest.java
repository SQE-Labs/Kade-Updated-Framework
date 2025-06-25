package qa.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.PaymentPage;
import pageEvents.QRCodePage;

import java.awt.*;
import java.util.random.RandomGenerator;

public class QRCodeTest extends BaseTest {

    QRCodePage QrCode = new QRCodePage();
    PaymentPage payment = new PaymentPage();
    String TitleName="Donation "+requiredString(3);
    String TitleNameTxt="Donation "+requiredString(5);
    String TitleFieldTxt="Donation "+requiredString(5);

    @Test(priority = 0, enabled = true)
    public void typesOfQrCodes() {
        QrCode.typesOfQrCodes();
    }

    @Test(priority = 1, enabled = true)
    public void directPaySection() {
        QrCode.directPaySect("100.00");
        payment.clickOnVenomoAccount();
    }

    @Test(priority = 2, enabled = true)
    public void directPayByViewLink() {
        QrCode.DirectPayByViewLink("100.00");
        payment.clickOnVenomoAccount();
    }

    @Test(priority = 3, enabled = true)
    public void contactScreenSection() {
        QrCode.contactScreenSect();
    }

    @Test(priority = 4, enabled = true)
    public void custPermSection() {
        QrCode.custPermSect();
    }

    @Test(priority = 5, enabled = true)
    public void createNewQrCode() {
        QrCode.createNewQrCode();
    }

    @Test(priority = 6, enabled = true)
    public void flexibleAmountQrCode() throws AWTException {
        QrCode.flexibleAmountQrCode("I am done", "Entered in title field", "Content tye text");
    }

    // Bug : Current date is not selecting.

    @Test(priority = 7, enabled = true)
    public void addAdditionalField() {
        QrCode.addAdditionalField("I am done");
        QrCode.editAdditionalFields("Updated Header");
        QrCode.TemporaryUnavailable();
    }

    @Test(priority = 8, enabled = true)
    public void returnToQrDashboardPage() {
        QrCode.selectStore();
        QrCode.clickOnPencilIcon();
        QrCode.clickOndashboardLink();
    }

    @Test(priority = 8, enabled = true, description = "payment Throgh Temporarily Unavailable Toggle button making off")
    public void paymentThroghTemporarilyUnavailable() {
        QrCode.paymentThroughByenablingTheToggleBtn("100.00");
    }

    @Test(priority = 9, enabled = true, description = "Create fixed amount create code")
    public void fixedAmountQrCode() {
        QrCode.fixedAmountQrCode("Nothing to be added","100.00");
    }

    @Test(priority = 10, enabled = true, description = "Create fixed amount create code")
    public void ticketsAndEventsQrCode() {
        QrCode.ticketsAndEvents("200.00");
    }

    @Test(priority = 11, enabled = true, description = "Filter Qr Code")
    public void filterQrCode() {
        QrCode.QrFilter();
    }


    // New scripts writing

    @Test(priority = 12, enabled = true, description = "Verify that creating Donation QR Code, after clicking on 'Generate new QR Code' button.")
    public void VerifyThatCreatingDonationQRCode() throws AWTException {
        QrCode.donationQRCode(TitleName,"100000",TitleNameTxt,TitleFieldTxt);
    }

    @Test(priority = 13, enabled = true, description = "Verify that making QR Code Donation payment after clicking on eye icon, on QR Code Dashboard' page.")
    public void VerifyThatMakingQRCodeDonationQRCode() throws AWTException {
        QrCode.MakingQRCodeDonation();
    }



}