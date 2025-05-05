package qa.tests;

import base.BaseTest;
import logger.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageEvents.PaymentMethod;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import pageObjects.PageObjectManager;
import utils.Constants;

public class AddPaymentMethodTest extends BaseTest {
    PageObjectManager pageObjectManager = new PageObjectManager();
    PaymentMethod paymentMethod = new PaymentMethod();

    @Test(description = "Added Bank Account Method")
    public void getAddedBankAccountMethod(){
        Login();
        pageObjectManager.getSidePannel().getProfileLink();
        pageObjectManager.getSidePannel().getPaymentMethodTab();

        // verify the payment method title
        waitForElementToBeVisible(paymentMethod.PaymentMethodTitle,4);
        Assert.assertTrue(isElementDisplayed(paymentMethod.PaymentMethodTitle),"Payment Method Title ");

        // verify the add payment link is displayed
        Assert.assertTrue(isElementDisplayed(paymentMethod.addORModifyPaymentLink),"Add or Modify Payment Method");

        // Clicking on Add payment link
        paymentMethod.getAddOrModifyPaymentLink();

        waitForElementToBeClickable(paymentMethod.addPaymentButton,4);
        paymentMethod.getAddPaymentButton();

        // Verify add new payment method title appears
        waitForElementToBeVisible(paymentMethod.addNewPaymentMethodTitle,4);
        Assert.assertTrue(isElementDisplayed(paymentMethod.addNewPaymentMethodTitle),"Add new payment method");
        Assert.assertTrue(isElementDisplayed(paymentMethod.creditCardOption),"Credit card option");
        Assert.assertTrue(isElementDisplayed(paymentMethod.bankAccountOption),"bank account option");

        waitForElementToBeClickable(paymentMethod.bankAccountOption,3);
        paymentMethod.getBankAccountOption();


        // Verify that new payment method popup
        waitForElementToBeVisible(paymentMethod.newPaymentMethodPopupTitle,5);
        Assert.assertTrue(isElementDisplayed(paymentMethod.newPaymentMethodPopupTitle),"New Payment Method Popup Title");

        switchToFrame(paymentMethod.bankFrame);
        waitForElementToBeClickable(paymentMethod.bankEmailField,5);

        // enter email and full name
        actionEnterText(paymentMethod.bankEmailField, Constants.validLoginEmail);
        actionEnterText(paymentMethod.fullNameBField,Constants.nameInput);
        paymentMethod.getTestInsituteBtn();
        switchToDefaultContent();
       // waitForPageLoad();
        staticWait(3000);
       switchToFrame(paymentMethod.bankFrame);

        waitForElementToBeVisible(paymentMethod.LogInWithTestInstitutionLabel,5);
        Assert.assertTrue(isElementDisplayed(paymentMethod.LogInWithTestInstitutionLabel),"Log In with Test Insititute");

        paymentMethod.getAgreeAndContinueBtn();

        // wait till bank options
        staticWait(5000);
        paymentMethod.getSuccessOption();
        paymentMethod.getConnectAccountBtn();

        staticWait(5000);

        paymentMethod.getSaveWithLinkBtn();

        staticWait(5000);
        paymentMethod.getBackToKadePayBtn();
        switchToDefaultContent();

        waitForElementToBeClickable(paymentMethod.finalSavebtn,5);
        paymentMethod.getFinalSaveBtn();









    }

}
