package qa.tests;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pageEvents.DashboardPage;
import pageEvents.SignUpPage;
import pageObjects.PageObjectManager;
import utils.Constants;
import org.testng.annotations.Test;




public class SignUpTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(SignUpPage.class);
    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private SignUpPage signUp = pageObjectManager.getSignUpPage();
    String st = requiredString(4);

    @Test(priority = 0, description = "CA_TC 1: Verify the elements of 'Create New Account' page after selecting  'Personal Account' option, on 'Login' page..")
    public void VerifyTheSignUpPage() {
        pageObjectManager.getLoginPage().getSignUpLink();
        waitForElementToBeVisible(signUp.businessAccountButton,10);

        // Verify the Business Account And Personal Account Button
        Assert.assertTrue(isElementDisplayed(signUp.businessAccountButton));
        Assert.assertTrue(isElementDisplayed(signUp.personalAccountButton));

        // Clicking on Personal Account Option
        signUp.getpersonalAccountButton();

        // Verify app Logo  - 'Kade'
        Assert.assertTrue(isElementDisplayed(signUp.appLogo));

        // Verify 'Create New Account' heading
        Assert.assertTrue(isElementDisplayed(signUp.createNewAccountTitle));

        // Verify 'Email or Phone' label
        Assert.assertTrue(isElementDisplayed(signUp.emailOrPhoneLabel));


        // Verify 'Already have an account? Sign-in' label
        Assert.assertTrue(isElementDisplayed(signUp.alreadyHaveAnAccountLabel));


        // Verify 'Sign-in' link
        Assert.assertTrue(isElementDisplayed(signUp.signInLink));

        // Verify 'Sign up' button
        Assert.assertTrue(isElementDisplayed(signUp.signUpButton));
        staticWait(3000);

        // Clicking on sign in Link
        signUp.getSignInLink();
    }

    @Test(priority = 1,description = "CA_TC 1(b): Verify the validation messages while creating new account with 'Personal Account' option on 'Login' page.")
    public void verifyValidationMessagesWithPersonalAccountOption() {
        pageObjectManager.getLoginPage().getSignUpLink();
        signUp.getValidationsOfPersonalAccountPage();
    }

    @Test(priority = 2,description = "CA_TC 1(c): Verify that creating new account with 'Personal Account' option.")
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
        enterText(signUp.securityCodePC, Constants.securityCode);
        signUp.getContinueButton();

        // Verify the Set your password Title
        softAssert.assertTrue(isElementDisplayed(signUp.setYourPasswordTitle));
        signUp.getSubmitButton();

        // Verify the success message
        softAssert.assertTrue(isElementDisplayed(signUp.successMessage));
    }

    @Test(priority = 3,description = "CA_TC 2(a): Verify that creating a new account by email address with  Business Account option.")
    public void verifyCreatingNewAccountByEmailWithBusinessAccount() {
        pageObjectManager.getLoginPage().getSignUpLink();
        //Clicking on Business Account Option
        signUp.getBusinessAccount();

        // Verify Mobile field label and  Use Email Link
         Assert.assertTrue(isElementDisplayed(signUp.phoneFieldLabel));
         Assert.assertTrue(isElementDisplayed(signUp.useEmailLink));

        // Verify the Receive Text Email Notification CheckBox and Continue button
        Assert.assertTrue(isElementDisplayed(signUp.checkBox));
        Assert.assertTrue(isElementDisplayed(signUp.continueButton));

        //Click on continue button and verify the Tooltip
        signUp.clickOnCountinueBtn();
        staticWait(7000);
        getToolTipMessage(signUp.mobilePhoneField);

        // Click on Use Email Link
        signUp.getUseEmailLink();

        // Enter invalid email
        enterText(signUp.emailBusinessField, Constants.invalidEmail);
        staticWait(2000);
        signUp.clickOnCountinueBtn();
        staticWait(7000);
        String Actual = getToolTipMessage(signUp.emailBusinessField);
        Assert.assertEquals(Actual, Constants.emailValidation);

        // Entering valid email in the Email field
        enterText(signUp.emailBusinessField, st + "@yopmail.com");

        // Checking the By providing my information, I consent to receive text/email notifications. checkbox
        signUp.getReceiveTextEmailNotificationCheckBox();
        signUp.getContinueButton();
        staticWait(7000);


        // Verify the start Over Link and resent code link
        staticWait(2000);
         Assert.assertTrue(isElementDisplayed(signUp.startOverLink));
         Assert.assertTrue(isElementDisplayed(signUp.resendCode));

        // Click on start over link and Continue button
        signUp.getStartOverLink();
        signUp.getContinueButton();
        staticWait(4000);

        // Enter data in security code field
        enterText(signUp.securityCodeFieldNewAccount, Constants.securityCode);

       // waitForElementToBeVisible(signUp.fullname,10);

        //Entering name in the Full name field
        staticWait(3000);
        enterText(signUp.fullname, "New Kade Member" + st);

        // Clicking on 'Continue' button
        signUp.getBusinessContinuebtn();
    }

    @Test(priority = 4,description = "CA_TC 2(b) : Verify that creating new account by phone number with Business Account option.")
    public void verifyCreateNewAccountByPhoneNumberWithBusinessAccount() {
        pageObjectManager.getLoginPage().getSignUpLink();
        signUp.getBusinessAccount();
        staticWait(2000);

        // Enter Phone Number in Phone field
        actionEnterText(signUp.mobilePhoneField, Constants.validPhonenumber);
        signUp.getReceiveTextEmailNotificationCheckBox();
        signUp.getContinueButton();
        staticWait(3000);

        // Enter less than 6 digit in security field
        String digit = requiredDigits(5);
        actionEnterText(signUp.securityCodeFieldNewAccount, digit);

        //Verify the security code sent to Information message
        softAssert.assertTrue(isElementDisplayed(signUp.securityCodeSendInfoMsg));
        signUp.getBusinessContinuebtn();

        // Verify the Tooltip message for security field
        String actual = getToolTipMessage(signUp.securityCodeFieldNewAccount);
        softAssert.assertEquals(actual, Constants.TooltipForLessDigit);

        // Entering Invalid security Code
        enterText(signUp.securityCodeFieldNewAccount, Constants.invalidSecurityCode);

        // ..
        waitForElementToBeVisible(signUp.ContinueButtonBusiness,3);
        signUp.getBusinessContinuebtn();

        String alertmessage = getText(signUp.securityCodeAlertMessage);


//        waitForElementToBeVisible(signUp.fullname,4);/// UI change this field discountinue
//        enterText(signUp.fullname, st + "New Member");
        signUp.getBusinessContinuebtn();

        // Verify the Validation message for Incorrect Security Code
        softAssert.assertEquals(alertmessage, Constants.invalidSecurityCodeMsg);
        staticWait(5000);
        cleanByJS(signUp.securityCodeFieldNewAccount);

        // Entering Valid security Code
        actionEnterText(signUp.securityCodeFieldNewAccount, Constants.phoneSecurityCodeForLogin);
        waitForElementToBeVisible(signUp.ContinueButtonBusiness,3);

        signUp.getBusinessContinuebtn();

        waitForElementToBeVisible(signUp.stripePageTitle,4);

        // Verify the page title
        softAssert.assertTrue(isElementDisplayed(signUp.stripePageTitle));
        waitForElementToBeClickable(pageObjectManager.getSidePannel().profileLink,4);

        // Clicking on Profile Link
        pageObjectManager.getSidePannel().getProfileLink();
        pageObjectManager.getSidePannel().getSecurityAndPasswordTab();
        pageObjectManager.getSecurityAndPasswordPage().getCloseAndDeleteAccountbtn();
        softAssert.assertAll();
    }

    @Test(priority = 5,description = "CA_TC 3 a: Verify that signing in to the application by phone number using Business Account option.")
    public void verifyThatSiginToApplicationByPhoneNumberUsingBusinessAccountOption() {
        pageObjectManager.getLoginPage().getSignUpLink();
        signUp.getBusinessAccount();
        signUp.getCrossIcon();

        // Clicking on 'Sign In Button
        signUp.getSignInBtn();

        waitForElementToBeVisible(signUp.signInTitle,10);

        // Verify the elements on 'Sign In' page
        softAssert.assertTrue(isElementDisplayed(signUp.signInTitle), "signInTitle");
        softAssert.assertTrue(isElementDisplayed(signUp.continueBtnSignInP), "Continue Btn");
        softAssert.assertTrue(isElementDisplayed(signUp.switchToEmailLinkSP), "Switch To Email");
        softAssert.assertTrue(isElementDisplayed(signUp.phoneFieldSP), "Phone field");
        softAssert.assertTrue(isElementDisplayed(signUp.googleIconSP), "google icon");
        softAssert.assertTrue(isElementDisplayed(signUp.appleIconSP), "apple icon");

        waitForElementToBeClickable(signUp.continueBtnSignInP, 2);

        // Validation for Phone Field
        signUp.getContinueBtnSP();
        String actual = getToolTipMessage(signUp.phoneFieldSP);
        softAssert.assertEquals(actual, Constants.requiredFieldValidation);
        actionEnterText(signUp.phoneFieldSP, Constants.invalidPhoneNumber);
        signUp.getContinueBtnSP();
        String tooltipvalidation = getToolTipMessage(signUp.phoneFieldSP);
        softAssert.assertTrue(isElementDisplayed(signUp.pleaseReviewValidationSP), "Please review the highlighted field message is not displayed");
        softAssert.assertEquals(tooltipvalidation, Constants.invalidPhnValidation);
        cleanByJS(signUp.phoneFieldSP);

        // Entering valid phone number
        actionEnterText(signUp.phoneFieldSP, Constants.phone);
        signUp.getContinueBtnSP();
        waitForElementToBeVisible(signUp.changeLinkSP,10);

        // Verify the link is displayed
        softAssert.assertTrue(isElementDisplayed(signUp.changeLinkSP), "FAILURE: 'Change' link  is NOT displayed!");
        softAssert.assertTrue(isElementDisplayed(signUp.iDontKnowPasswordSP), "I don't know is not displayed ");
        Assert.assertTrue(isElementDisplayed(signUp.signInButtonSignInP), "signIn button is not displayed");

        // Validation for Password field
        enterText(signUp.passwordFieldSignP, Constants.invalidData);
        signUp.getsignInButtonSignInP();
        waitForElementToBeInteractable(signUp.passwordFieldSignP, 2);
        String validation = getToolTipMessage(signUp.passwordFieldSignP);
        softAssert.assertEquals(validation, Constants.passwordvalidation);

        // Entering valid password and signing in to the app.
        signUp.getShowPasswordSP();
        enterText(signUp.passwordFieldSignP, Constants.validPassword);
        signUp.getsignInButtonSignInP();
        softAssert.assertAll();
    }
    @Test(priority = 6,description = "CA_TC 3 (b): Verify that signing in to the application by phone number using Business Account option, with forget password option.")
    public void verifyThatSigningInToApplicationByPhoneUsingNewPassword() {
        pageObjectManager.getLoginPage().getSignUpLink();
        signUp.getBusinessAccount();
        signUp.getCrossIcon();

        // Clicking on 'Sign In Button
        signUp.getSignInBtn();
        waitForElementToBeClickable(signUp.phoneFieldSP,3);
        // Entering valid phone number
        actionEnterText(signUp.phoneFieldSP, Constants.phone);
        signUp.getContinueBtnSP();

        // clicking on I don't know my password link.
        signUp.getIdonkKnowPasswordLinkSP();
        waitForElementToBeVisible(signUp.securityCodeLabelsignInP,3);

        // Verify the elements
        softAssert.assertTrue(isElementDisplayed(signUp.securityCodeLabelsignInP),"Security code label");
        softAssert.assertTrue(isElementDisplayed(signUp.informationMessageSP),"Information message");
        softAssert.assertTrue(isElementDisplayed(signUp.newPasswordLabelSP),"new passoword label");
        softAssert.assertTrue(isElementDisplayed(signUp.showPasswordSignInP),"show password");
        softAssert.assertTrue(isElementDisplayed(signUp.signInButtonSignInP),"sign in button ");
        waitForElementToBeInteractable(signUp.finalSignInbtn,5);
        staticWait(5000);

        // Checking validations
        signUp.getFinalSignInbtn();
        staticWait(5000);

        String securitycode= getToolTipMessage(signUp.securityCodeField);
        staticWait(3000);
        String password = getToolTipMessage(signUp.newPasswordFieldSP);

        softAssert.assertEquals(securitycode,Constants.requiredFldValidation);
        staticWait(3000);
        softAssert.assertEquals(password,Constants.requiredFldValidation);
        staticWait(3000);

        // Enter invalid security code
        actionEnterText(signUp.securityCodeField,Constants.incompleteSecurityCode);
//        actionEnterText(signUp.newPasswordFieldSP,Constants.validPassword);
        signUp.getFinalSignInbtn();

        String lessthan6 = getToolTipMessage(signUp.securityCodeField);
        softAssert.assertEquals(lessthan6,Constants.atLeastCharReqMessage);

        // entering valid security code
        enterText(signUp.securityCodeField,Constants.phoneSecurityCodeForLogin);
        staticWait(3000);


        signUp.getFinalSignInbtn();
        staticWait(3000);

        // Validation for Password field
        actionEnterText(signUp.passwordFieldSignP, Constants.invalidData);
        staticWait(3000);
        signUp.getFinalSignInbtn();

       waitForElementToBeInteractable(signUp.passwordFieldSignP, 5);
        String validation = getToolTipMessage(signUp.passwordFieldSignP);
        softAssert.assertEquals(validation, Constants.passwordvalidation);

        // Entering valid password and signing in to the app.
        signUp.getShowPasswordSP();
        enterText(signUp.passwordFieldSignP, Constants.validPassword);
        signUp.getFinalSignInbtn();
        softAssert.assertAll();

    }

    @Test(priority = 7,description = " CA_TC 4(a): Verify that signing in to the application by email address using Business Account option.")
    public void verifyThatSigningInByEmailUsingBusinessAccountOption() {
        pageObjectManager.getLoginPage().getSignUpLink();
        signUp.getBusinessAccount();
        signUp.getCrossIcon();

        // Clicking on 'Sign In Button
        signUp.getSignInBtn();

        // Clicking on Switch to Email Link
        signUp.getSwitchtoEmailLink();
        signUp.getContinueBtnSP();
        String actual = getToolTipMessage(signUp.emailFieldSP);
        softAssert.assertEquals(actual, Constants.RequiredField);

        // entering invalid email
        enterText(signUp.emailFieldSP, Constants.invalidEmail);
        signUp.getContinueBtnSP();
        staticWait(3000);

        String invalidEmailValidation = getText(signUp.invalidEmailValidation);
        softAssert.assertEquals(invalidEmailValidation, Constants.invalidEmailValidationMsg);

//        String tooltip = getToolTipMessage(signUp.emailFieldSP); this funcationality has been changed to validation message
//        softAssert.assertEquals(tooltip, Constants.emailTooltip);

        // Entering valid email address
        enterText(signUp.emailFieldSP, Constants.validLoginEmail);
        signUp.getContinueBtnSP();

        // Validation for Password field
        enterText(signUp.passwordFieldSignP, Constants.invalidData);
        signUp.getsignInButtonSignInP();

        waitForElementToBeInteractable(signUp.passwordFieldSignP, 2);
        String validation = getToolTipMessage(signUp.passwordFieldSignP);
        softAssert.assertEquals(validation, Constants.passwordvalidation);

        // Entering valid password and signing in to the app.
        signUp.getShowPasswordSP();
        enterText(signUp.passwordFieldSignP, Constants.validPassword);
        signUp.getsignInButtonSignInP();
        softAssert.assertAll();
    }


    @Test(priority = 8,description = " CA_TC 4(b): Verify that signing in to the application by email address using Business Account option, with forget password option.")
    public void verifyThatSigningInByEmailUsingBusinessAccountOptionWithForgetPasswordoption() {
        signUp.getsignInWithEmailUsingBusinessAccount();
    }
}

