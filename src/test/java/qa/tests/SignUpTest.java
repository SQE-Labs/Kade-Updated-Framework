package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pageEvents.DashboardPage;
import pageEvents.LoginPageEvents;
import pageEvents.SignUpPage;
import pageObjects.PageObjectManager;
import utils.Constants;

import java.util.Random;


public class SignUpTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(DashboardPage.class);
    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private SignUpPage signUp = pageObjectManager.getSignUpPage();
    String st = requiredString(4);

    @Test(description = "CA_TC 1: Verify the elements of 'Create New Account' page after selecting  'Personal Account' option, on 'Login' page..")
    public void VerifyTheSignUpPage() {
        pageObjectManager.getLoginPage().getSignUpLink();

        // Verify the Business Account And Personal Account Button
        softAssert.assertTrue(isElementDisplayed(signUp.businessAccountButton));
        softAssert.assertTrue(isElementDisplayed(signUp.personalAccountButton));

        // Clicking on Personal Account Option
        signUp.getpersonalAccountButton();

        // Verify app Logo  - 'Kade'
        softAssert.assertTrue(isElementDisplayed(signUp.appLogo));

        // Verify 'Create New Account' heading
        softAssert.assertTrue(isElementDisplayed(signUp.createNewAccountTitle));

        // Verify 'Email or Phone' label
        softAssert.assertTrue(isElementDisplayed(signUp.emailOrPhoneLabel));

        // Verify 'Already have an account? Sign-in' label
        softAssert.assertTrue(isElementDisplayed(signUp.alreadyHaveAnAccountLabel));

        // Verify 'Sign-in' link
        softAssert.assertTrue(isElementDisplayed(signUp.signInLink));

        // Verify 'Sign up' button
        softAssert.assertTrue(isElementDisplayed(signUp.signUpButton));
        softAssert.assertAll();

        // Clicking on sign in Link
        signUp.getSignInLink();
    }

    @Test(description = "CA_TC 1(b): Verify the validation messages while creating new account with 'Personal Account' option on 'Login' page.")
    public void verifyValidationMessagesWithPersonalAccountOption() {
        pageObjectManager.getLoginPage().getSignUpLink();
        signUp.getValidationsOfPersonalAccountPage();
    }

    @Test(description = "CA_TC 1(c): Verify that creating new account with 'Personal Account' option.")
    public void verifyCreatingAccountWithPersonalAccountOption() {
        pageObjectManager.getLoginPage().getSignUpLink();

        // Clicking on Personal Account Option
        signUp.getpersonalAccountButton();

        enterText(signUp.emailOrPhoneField, st + "@yopmail.com");
        signUp.getReceiveTextEmailNotificationCheckBox();
        signUp.getSignUpBtnPA();

        // Verify the Verify Account Title and security code label
        softAssert.assertTrue(isElementDisplayed(signUp.verifyAccountTitle));
        softAssert.assertTrue(isElementDisplayed(signUp.securityCodeLabel));
        enterText(signUp.securityCodeField, Constants.securityCode);
        signUp.getContinueButton();

        // Verify the Set your password Title
        softAssert.assertTrue(isElementDisplayed(signUp.setYourPasswordTitle));
        signUp.getSubmitButton();

        // Verify the success message
        softAssert.assertTrue(isElementDisplayed(signUp.successMessage));
    }

    @Test(description = "CA_TC 2(a): Verify that creating a new account by email address with  Business Account option.")
    public void verifyCreatingNewAccountByEmailWithBusinessAccount() {
        pageObjectManager.getLoginPage().getSignUpLink();
        //Clicking on Business Account Option
        signUp.getBusinessAccount();

        // Verify Mobile field label and  Use Email Link
        softAssert.assertTrue(isElementDisplayed(signUp.phoneFieldLabel));
        softAssert.assertTrue(isElementDisplayed(signUp.useEmailLink));

        // Verify the Receive Text Email Notification CheckBox and Continue button
        softAssert.assertTrue(isElementDisplayed(signUp.checkBox));
        softAssert.assertTrue(isElementDisplayed(signUp.continueButton));

        //Click on continue button and verify the Tooltip
        signUp.getContinueButton();
        getToolTipMessage(signUp.mobilePhoneField);

        // Click on Use Email Link
        signUp.getUseEmailLink();

        // Enter invalid email
        enterText(signUp.emailBusinessField, Constants.invalidEmail);
        signUp.getContinueButton();
        String Actual = getToolTipMessage(signUp.emailBusinessField);
        softAssert.assertEquals(Actual, Constants.emailValidation);

        // Entering valid email in the Email field
        enterText(signUp.emailBusinessField, st + "@yopmail.com");

        // Checking the By providing my information, I consent to receive text/email notifications. checkbox
        signUp.getReceiveTextEmailNotificationCheckBox();
        signUp.getContinueButton();

        // Verify the start Over Link and resent code link
        softAssert.assertTrue(isElementDisplayed(signUp.startOverLink));
        softAssert.assertTrue(isElementDisplayed(signUp.resendCode));

        // Click on start over link and Continue button
        signUp.getStartOverLink();
        signUp.getContinueButton();

        // Enter data in security code field
        enterText(signUp.securityCodeField, Constants.securityCode);

        //Entering name in the Full name field
        enterText(signUp.fullname, "New Kade Member" + st);

        // Clicking on 'Continue' button
        signUp.getBusinessContinuebtn();
    }

    @Test(description = "CA_TC 2(b) : Verify that creating new account by phone number with Business Account option.")
    public void verifyCreateNewAccountByPhoneNumberWithBusinessAccount() {
        pageObjectManager.getLoginPage().getSignUpLink();
        signUp.getBusinessAccount();

        // Enter Phone Number in Phone field
        enterText(signUp.mobilePhoneField,Constants.phone);
        signUp.getReceiveTextEmailNotificationCheckBox();
        signUp.getContinueButton();

        // Enter less than 6 digit in security field
        String digit = requiredDigits(5);
        enterText(signUp.securityCodeField,digit);

        //Verify the security code sent to Information message
        softAssert.assertTrue(isElementDisplayed(signUp.securityCodeSendInfoMsg));
        signUp.getBusinessContinuebtn();

        // Verify the Tooltip message for security field
        String actual = getToolTipMessage(signUp.securityCodeField);
        softAssert.assertEquals(actual,Constants.TooltipForLessDigit);

        // Entering Invalid security Code
       enterText(signUp.securityCodeField,Constants.invalidSecurityCode);
      String alertmessage = getText(signUp.securityCodeAlertMessage);
        enterText(signUp.fullname,st+"New Member");
        signUp.getBusinessContinuebtn();

        // Verify the Validation message for Incorrect Security Code
        softAssert.assertEquals(alertmessage,Constants.invalidSecurityCodeMsg);

        // Entering Valid security Code
        enterText(signUp.securityCodeField,Constants.phoneSecurityCode);
        signUp.getContinueButton();

        // Verify the page title
        softAssert.assertTrue(isElementDisplayed(signUp.stripePageTitle));

        // Clicking on Profile Link
        pageObjectManager.getSidePannel().getProfileLink();

















    }
}

