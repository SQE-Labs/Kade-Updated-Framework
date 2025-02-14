package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Constants interface holds constant values used throughout the application.
 * These constants ensure consistent values and reduce the risk of hardcoding errors.
 */
public interface Constants {
    // Logger instance for potential debugging (if required in implementations)
    Logger log = LogManager.getLogger(Constants.class);

    // Constant for the "Sign out" text used in validation
    String SIGN_OUT = "Sign out";




    // Dashboard
    String YourBusinessTitle ="Your Businesses";
    String ProcessPayment = "Processed Payments";
    String RecentTransaction = "Recent transactions";
    String CustomerTitle = "Customers";
    String TodaysPaymentTitle = "Today’s Payments";
    String MessageTitle = "Messages";
    String CustomerTrendsTitle = "Customer Trends";
    String PaymentMethodPopularityTitle = "Payment Methods Popularitypast 30 days";


    // Create New Account Personal Account Option
    String RequiredField = "This field is required.";
    String invalidData = "invalid123";
    String invalidPhoneNumber = "24324";
    String emailandPhoneValidation = "Invalid phone or email. Phone numbers must start with country code starting with +";
    String invalidEmail= "test13@d";
    String emailValidation = "Please enter a valid email address.";
    String phone = "6465551114";
    String phoneValidation = "This phone number is already registered.";
    String existingEmail = "test@yopmail.com";
    String existingEmailValidation ="This email is already registered.";
    String securityCode ="123456";
    String validPhonenumber = "6465551105";
    String TooltipForLessDigit ="Please enter at least 6 characters.";
    String invalidSecurityCodeMsg = "Invalid security code";
    String invalidSecurityCode ="332434";
    String  phoneSecurityCode ="346543";
    String passwordvalidation = "Invalid password, a password must contain at least one upper case letter, one lower case letter and one special character or a number.";
    String validPassword = "Test@123";
    String validLoginEmail = "test1114@yopmail.com";
    String phoneSecurityCodeForLogin = "777777";


    //BasicInformationPage constants
    String storeName = "Automation Customer Store";
    String storePhone = "12312312312";
    String taxRate = "10000";
    String storeAddress = "8 Glover Dr, Dix Hills, NY 11746, USA";
    String invalidStoreAddress = "New";
    String addressNotVerifiedToolTip = "Address cannot be verified";
    String invalidStorePhone = "1231";
    String invalidPhoneToolTip = "Invalid phone number";
    String invalidImageFile = "Not a valid image file";
    String description = "Without Stripe Account";

    //Security and Password page
    String requiredFieldValidation = "This field is required.";
    String invalidEmailValidation = "Please enter a valid email address.";
    String sameEmailErrorMessage = "New email cannot be the same as the current email!";
    String emailInput = "yonro";
    String requiredFldValidation = "This field is required.";
    String invalidSecurityCode1 = "123654";
    String validSecurityCode = "123456";
    String incompleteSecurityCode = "1236";
    String IncompleteSecurityCode2 = "12345";
    String atLeastCharReqMessage = "Please enter at least 6 characters.";
    String invalidPhoneNumber1 = "12312312";
    String invalidPhnValidation = "Invalid phone number";
    String validPhoneNumber = "1231231231";
    String validPhoneNumber2 = "1231231233";
    String LeastCharReqMessage = "Please enter at least 6 characters.";
    String diffCellNumber = "12334545676";
    String pleaseReview = "Please review the highlighted field(s)";


    //Rewards Program constants
    String Memo = "Memo";
    String Points = "100";
    String PartialUsername = "yonro";
    String InvalidPartialUsername = "Jonro";
    String phnNoFilterInput = "+2222 223 3333";
    String EmailFilterInput = "yonro@yopmail.com";
    String nonExistingEmailFilterInput = "Jonro@yopmail.com";
    String nonExistingPhoneNoFilterInput = "+2222 223 3888";
    String invalidPhoneNumberFilterInput = "+2222 228";
    String userPhnEmailTooltip = "Invalid phone or email. Phone numbers must start with country code starting with +";
    String LastVisitFilterInput = "12/01/2024 - 01/20/2025";
    String InvalidLastVisitFilterInput = "12/02/2024 - 12/03/2024";
    String InvalidLastVisitFilterInput2 = "www";
    String customerSinceDateRange = "12/01/2024 - 01/05/2025";
    String invalidDateRange = "Invalid date range";
    String minRewardPointsInput = "200";
    String minRewardPointsInput2 = "9000000";
    String maxRewardPointsInput = "2000";
    String maxRewardPointsInput2 = "10";
    String minPaymentInput = "0";
    String minPaymentInput2 = "1";

    //Customer page constants
    String custEmailInput = "yonro@yopmail.com";
    String emailTooltip = "Please enter a valid email address.";
    String emptyFieldTooltip = "This field is required.";
    String searchInput = "Santa";
    String phnNumberInput = "9011017524";
    String phnNumberInput2 = "1232233223";
    String phnNumberInput3 = "12345678901234567890123";
    String phnNumberInput4 = "1231";
    String maxPhnFieldCharValidation = "Please enter no more than 22 characters.";
    String validEmailValidationMsg = "Please enter a valid email address.";
    String nameInput = "jon123";
    String chngeNameInput = "Yonro";
    String cardNumber = "4111111111111111";
    String expDate = "0230";
    String cardSecurityCode = "123";
    String initialAmt = "1000";

    //Reports Page
    String fileNameDaily = "2962-2025-01-20.csv";
    String filePresent = "File Present";
    String filenameMonthly = "2962-2025-01-01.csv";
    String dateRange = "01/01/2025 - 02/20/2025";

    //Store Creation
    String skip = "Skip";
    String ConnectToStripe ="Connect to stripe";
    String defaultLocationDescription = "Dix Hills";
    String defaultStoreAddress = "8 Glover Dr, Dix Hills, NY 11746, USA";
    String defaultCurrency = "USD";
    String defaultTaxRate = "0.000%";
    String currentPlan= "Current plan";
    String visavalue = "Visa1111";


}
