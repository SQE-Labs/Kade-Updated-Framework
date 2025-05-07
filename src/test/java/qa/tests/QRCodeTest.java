package qa.tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.PaymentPage;
import pageEvents.QRCodePage;

import java.awt.*;

public class QRCodeTest extends BaseTest {

    QRCodePage QrCode=new QRCodePage();
    PaymentPage payment=new PaymentPage();

    @Test(priority = 0, enabled = true, description = "1")
    public void typesOfQrCodes() {
        QrCode. typesOfQrCodes();
    }
    @Test(priority = 1, enabled = true, description = "2")
    public void directPaySection() {
        QrCode. directPaySect("100.00");
        payment.clickOnVenomoAccount();
    }

    @Test(priority = 2, enabled = true, description = "")
    public void directPayByViewLink() {
        QrCode.DirectPayByViewLink("100.00");
        payment.clickOnVenomoAccount();
    }

    @Test(priority = 3, enabled = true, description = "3")
    public void contactScreenSection() {
        QrCode. contactScreenSect();
    }

    @Test(priority = 4, enabled = true, description = "4")
    public void custPermSection() {
        QrCode. custPermSect();
    }

    @Test(priority = 5, enabled = true, description = "")
    public void createNewQrCode() {
        QrCode.createNewQrCode();
    }

    @Test(priority = 6, enabled = true, description = "19")
    public void flexibleAmountQrCode() throws AWTException {
        QrCode.flexibleAmountQrCode("I am done","Entered in title field","Content tye text");
    }

    @Test(priority = 7, enabled = true, description = "")
    public void addAdditionalField()  {
        QrCode.addAdditionalField("I am done");
        QrCode.editAdditionalFields("Updated Header");
    }
}
