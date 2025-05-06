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

    @Test(priority = 2,description = "PM02: Added Bank Account Method")
    public void getAddedBankAccountMethod(){
        LoginAsNewUser();
        pageObjectManager.getSidePannel().getProfileLink();
        pageObjectManager.getSidePannel().getPaymentMethodTab();

        // verify the payment method title
        waitForElementToBeVisible(paymentMethod.PaymentMethodTitle,4);
        Assert.assertTrue(isElementDisplayed(paymentMethod.PaymentMethodTitle),"Payment Method Title ");

        // verify the add payment link is displayed
        Assert.assertTrue(isElementDisplayed(paymentMethod.addORModifyPaymentLink),"Add or Modify Payment Method");

        // Clicking on Add payment link
        paymentMethod.getAddOrModifyPaymentLink();


        if (!isElementDisplayed(paymentMethod.noPaymentInfo)) {
            paymentMethod.getAddPaymentButton();
        }

        // Verify add new payment method title appears
        waitForElementToBeVisible(paymentMethod.addNewPaymentMethodTitle,6);


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

        // Verify that success text appears
        Assert.assertTrue(isElementDisplayed(paymentMethod.successText),"Success Text");

        paymentMethod.getBackToKadePayBtn();
        switchToDefaultContent();
        staticWait(5000);
        switchToFrame(paymentMethod.bankFrame);

//        waitForElementToBeVisible(paymentMethod.stripeBankAccountText,5);
        System.out.println("Bank Account name is " + getText(paymentMethod.stripeBankAccountText));
        Assert.assertEquals(getText(paymentMethod.stripeBankAccountText),"Stripebank");
        switchToDefaultContent();
        waitForElementToBeClickable(paymentMethod.finalSavebtn,5);
        paymentMethod.getFinalSaveBtn();

        staticWait(5000);
        paymentMethod.getTrashIcon();
        paymentMethod.getThumbIcon();


    }

    @Test(priority = 1, description = "Verify that appropriate information message appears, when no payment method is added, on the 'Payment Method' page.")
        public void verifyThatInformationMsgAppearsWhenNoPaymetMethodIsSelected(){
        pageObjectManager.getSignUpPage().creatingNewAccountWithEmailWithBusinessAccount();
        pageObjectManager.getSidePannel().getProfileLink();
        pageObjectManager.getSidePannel().getPaymentMethodTab();

        // verify the information message when no payment method is selected
        String infoMessage = getText(paymentMethod.noPaymentInfo);
        Assert.assertEquals(infoMessage,Constants.noPaymentInfoMessage);
    }
}
