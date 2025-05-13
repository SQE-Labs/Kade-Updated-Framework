package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * The Constants interface holds constant values used throughout the application.
 * These constants ensure consistent values and reduce the risk of hardcoding errors.
 */
public interface Constants {
    // Logger instance for potential debugging (if required in implementations)
    Logger log = LogManager.getLogger(Constants.class);

    // Constant for the "Sign out" text used in validation
    String SIGN_OUT = "Sign out";
    String transactionsTitle = "Transactions";

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
    String validPhonenumber = "6465551111";
    String ValidPhone = "+1 (646) 555 1118";
    String expectedSearchValidation = "Nothing found!";
    String TooltipForLessDigit ="Please enter at least 6 characters.";
    String invalidSecurityCodeMsg = "Invalid security code";
    String invalidSecurityCode ="332434";
    String  phoneSecurityCode ="346543";
    String passwordvalidation = "Invalid password, a password must contain at least one upper case letter, one lower case letter and one special character or a number.";
    String validPassword = "Test@123";
    String validLoginEmail = "test1114@yopmail.com";
    String phoneSecurityCodeForLogin = "777777";
    String ForgetPasswordtitle = "Forget password";
    String  TermsOfUser ="User Agreement";
    String PaymentHistoryTitle = "Payment History";
    String NoPaymentsMessage = "There are no payments available yet!";
    String invalidEmailValidationMsg = "Invalid email";


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
    String pleaseReviewValidation = "Please review the highlighted field(s)";


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
    String searchInput = "yonro";
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
    String fileNameDaily = "2962-2025-04-26.csv";
    String filePresent = "File Present";
    String filenameMonthly = "2962-2025-04-01.csv";
    String dateRange = "01/01/2025 - 02/20/2025";

    //Store Creation
    String skip = "Skip";
    String ConnectToStripe ="Connect to stripe";
    String defaultLocationDescription = "Dix Hills";
    String defaultStoreAddress = "8 Glover Dr, Dix Hills, NY 11746, USA";
    String defaultCurrency = "USD";
    String defaultTaxRate = "0.000%";
    String currentPlan= "Current plan";
    String visavalue = "Visa 1111";

    //Store Names
    public static String AutomationBillFlow = "Automation Bill Flow";  // Flow 1 without plan
    public static String AutomationBillTest = "Automation Bill Test"; // New Buisness 2 with plan
    public static String AutomationCustomerStore="Automation Customer Store";
    public static String AutomationFlowBusiness = "Automation Flow Business";
    public static String AutomationQRCode = "Automation QR Code";
    public static String AutomationTransactions = "Automation Transactions";
    public static String AutomationTransactions3 = "Automation Transaction 3";
    public static String AutomationTransaction2 ="Automation Transaction 2";
    public static String AutomationPaymentHistory = "Automation Payment History";  // Flow 1 without plan
    public static String BillHeader="Bill";
    public static String TerminalChargeStore ="TerminalNewCharges";


    //Verifying Modified Details
    String editdefaultStoreName = "Automation Flow Business 1";
    String editdefaultStorePhone = "+1 (918) 065 2341";
    String reverseStoreName = "Automation Flow Business";


    // Store Configuration

    String maximumBillAmount = "50000.00";
    String minimumBillAmount = "50.00";
    String tipConfigurationTitle = "Tip configuration";
    String rewardConfigurationpopup = "Rewards Program Configuration";

    String newTerminalTitle = "New Terminal";
    String addUserTitle = "Add user";
    String deacticeStatus = "Store is NOT active (Deactivated)";
    String activeStoreStatus ="Store is active and ready to receive payments";
    String loginPageValidation = "Invalid phone number. Phone numbers must start with + and country code";
    String credentialsValidationLP = "Invalid credentials. Check your username and/or password";


    // Gift Card DashBoard

    String GiftCardHeader ="Gift Cards Dashboard";
    String infoMessage= "Gift cards is currently disabled.";
    String configurationPopupTitle = "Gift Cards Configuration";
    String DisabledText="Disabled";
    String EnableText="Enabled";
    String referenceNoDisabledText ="Reference No. is optional";
    String referenceNoEnabledText="Reference No. is mandatory";
    String sourceFundingDisabledText = "Funding source is optional";
    String getSourceFundingEnabledText="Funding source is restricted";
    String ValidationMsg ="Please review the highlighted field(s)";
    String giftCardHeaderText = "Issue a new gift card";
    String customerPopupTitle = "Customer";
    String emailValidationToolTip ="Please enter a valid email address.";
    String phoneValidationToolTip = "Invalid phone number";
    String noResultText ="There are no results";
    String noActiveStoreInfoMsg="No active store is available in your account!";
    String referenceNoTooltipMsg ="This field is required.";
    String cardNoText ="Card No";
    String cardMinLendthMsg ="Please enter atleast 4 characters.";
    String cardNoDatatype="numeric";
    String maxLength ="18";
    String fundingSourceType = "text";
    String invalidDateTooltip= "Invalid date";
    String memoMaxLength ="500";
    String fundingResourceText ="Funding source";
    String memoText ="Memo";
    String startDateText ="Start Date:";
    String endDateText ="Exp. Date:";

    // Transactions page
    String noPaymentInfoMsg = "There are no payments available yet!";
    String amount = "1590.01";
    String newChargeDescription = "New charge payment";
    String terminalNotAcceptedAlert= "Your store is not configured to process any credit card";
    String terminalSuccessMessage = "Processed successfully!";

    // Verify Message
    String verifyInfoMsg = "Each transaction can be verified only once.";
    String verifyByStore = "Verified by the store";

    // Gift Card
    String GiftCardSummaryURL = "https://sibtestenv.azurewebsites.net/Giftcards/GiftCardsSummary";
    String giftCardDetailURL = "https://sibtestenv.azurewebsites.net/Giftcards/giftcardDetail?Id=2935";

        // payment method
    String noPaymentInfoMessage = "You don't have any payment method set up";

    // Gift Card Dashboard Filters
    String giftCardCustomer = "Bean Bliss";
    String giftCardUserEmail = "beanBliss@yopmail.com";
    String giftCardUserPhoneNumber = "6465551105";
    String minAmountOfGC = "100.00";
    String maxAmountOfGC = "1000.00";
    String midValue = "500.00";
    String giftCardNo = "3119";
    String threeDigit = "311";
    String lessThan3cardNoValidation = "Please enter at least 4 characters.";
    String nonexistingGC ="2172";



}
