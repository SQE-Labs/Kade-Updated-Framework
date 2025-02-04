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
    String RecentTransaction = " Recent transactions";
    String CustomerTitle = "Customers";
    String TodaysPaymentTitle = "Today’s Payments";
    String MessageTitle = "Messages";
    String CustomerTrendsTitle = "Customer Trends";
    String PaymentMethodPopularityTitle = "Payment Methods Popularitypast 30 days";


    // Create New Account Personal Account Option
    String RequiredField = "This field is required.";
    String invalidData = "invalid123";
    String emailandPhoneValidation = "Invalid phone or email. Phone numbers must start with country code starting with +";
    String invalidEmail= "test13@d";
    String emailValidation = "Please enter a valid email address.";
    String phone = "6465551114";
    String phoneValidation = "This phone number is already registered.";
    String existingEmail = "test@yopmail.com";
    String existingEmailValidation ="This email is already registered.";
    String securityCode ="123456";
    String validPhonenumber ="6465551105";
    String TooltipForLessDigit ="Please enter at least 6 characters.";
    String invalidSecurityCodeMsg = "Invalid security code";
    String invalidSecurityCode ="332434";
    String  phoneSecurityCode ="346543";





}
