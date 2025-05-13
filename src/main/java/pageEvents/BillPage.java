package pageEvents;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import base.BaseTest;
import logger.Log;
import org.openqa.selenium.*;
import org.testng.Assert;
import utils.Constants;

import static utils.Constants.BillHeader;


public class BillPage extends BaseTest {

    String descriptionTxt;
    String referenceTxt;
    String memoTxt;
    public String amt;

    public String enteredamt;


    public By newBillTxt = By.xpath("//div/child::div[text()='New Bill']");
    public By newBillBtn = By.cssSelector(".fs-p15>i+div");
    public By transactionsLink = By.xpath("//div[text()='Transactions']");
    public By amtTbx = By.xpath("//input[@name='amount']");
    public By selectCustomer = By.xpath("//button[text()='Select a customer']");
    By closeIcon = By.xpath("(//button[@class='btn-close'])[3]");
    public By filterBtn = By.cssSelector(".far.fa-2x.fa-sliders-h-square");
    public By configureAmount = By.xpath("//div[@class='text-center fs-pn25']");
    public By enteredAmount = By.cssSelector("span[data-field='total']");
    public By tapToAddFiles = By.xpath("//div[text()='Tap to add files']/..");
    public By camera = By.xpath("(//button[contains(@class,'btn btn-outline-dark mx-2')]/child::i[contains(@class,'fas fa-camera-retro fs-p50')])[2]/..");
    public By pdfIcon = By.xpath("(//button[contains(@class,'btn btn-outline-dark mx-2')]/child::i[contains(@class,'fas fa-file-pdf fs-p50')])[2]/..");
    public By okIcon = By.xpath("//button[@class='btn btn-dark -crop-']");
    public By successMessage = By.xpath("//div[@class='toast-message']");

    public By popUpHeader = By.cssSelector(".modal-title span");
     public By customerNumber = By.xpath("//input[@name='phone']");
    public By emailField = By.xpath("//input[@name='email']");
    //input[@name='email']
     public By addBillDescription = By.xpath("//textarea[@name='amount_description']");
    public By customerDropdown = By.xpath("//div[contains(text(),'Select or create')]");
    public By moreLabelTxt = By.xpath("//label[contains(text(),'More options')]");

    public By amtInput = By.xpath("//input[@name='amount']");
     By customerBtn = By.xpath("//div[contains(text(),'Select or create')]/../../../../../..");
    By goBtnEmail = By.xpath("//input[@name='email']/following-sibling::button");
    By enterCustomernameDoneBtn = By.xpath("(//button[text()='Done'])[6]");
    By enterUserNamePopUp = By.xpath("(//div[@class='modal-header']/h5)[8]");
    public By confirmBtn = By.xpath("//button[@name='method']");
    public By continueWithoutBtn = By.xpath("//button[text()='Continue without']");
    public By closePopup = By.xpath("(//div[@class='modal-content']//h5/following-sibling::button)[3]");
    public By crossPopUpIcon = By.xpath("(//div[contains(@class, 'modal-content')]//button[@class='btn-close'])[2]");
    public By crossIcon = By.xpath("(//div[contains(@class,'modal-content')]//button[@class='btn-close'])[1]");
    public By countinueWithoutTxt = By.xpath("//div//button[text()='Continue without']");
    public By selectACustomerBtn = By.xpath("(//div[@class='modal-content'])[8]//button[text()='Select a customer']");
     public By storesCombobox = By.xpath("//span[@role='combobox']");
    By continueBtn = By.xpath("//button[@type='submit']");
    public By messagePopupHeader = By.xpath("//h5[text()='Message']");
    public By closeLogoPopupBtn = By.xpath("(//div[contains(@class, 'modal-content')]//button[@class='btn-close'])[3]");
     // By tapToAddFiles = By.cssSelector(".flex-column-reverse > div:nth-child(3)");

    By deleteButton = By.cssSelector(".btn-outline-danger");
    public By notPaid = By.xpath("//div[contains(@class, 'row bg-white')][1]");
     public By reccuringBill = By.xpath("//div[contains(@class, 'bg-white mb-2 row')][1]");
    public By reccuringAmount = By.xpath("//span[@class='display-6 ms-1 text-danger']");
    By deleteIcon = By.cssSelector(".fal.fa-thumbs-up.text-white");
    By selectCust = By.xpath("//div[contains(text(),'Select or create a new customer')]/../../../../../..");

    By memoBtn = By.xpath("//label[text()='Memo:']/..");
    By memoField = By.xpath("//div[@class='my-4']//textarea[@lbl-title='Memo']");
    By doneBtn = By.xpath("(//button[@class='btn btn-link w-100 my-3'])[5]");
    By memoFieldMessage = By.xpath("//div[contains(text(),'Customer will not see this memo')]");
    By memoPopUpTitle = By.xpath("//h5[text()='Memo']");
     By taxToggleBtn = By.xpath("//input[@name='applyTax']/../i[2]");
     By moreSection = By.xpath("//label[text()='More options']/../..");
    By repeatLockIcon = By.xpath("(//i[@class='fas fa-lock'])[1]");
    By expireLockIcon = By.xpath("(//i[@class='fas fa-lock'])[2]");
    By memoNoneTxt = By.xpath("//label[text()='Memo:']/..//div[text()='None']");
    By expiryDateSection = By.xpath("(//a[contains(@class,'-activator-button-') and contains(@onclick,'showMe()')])[5]");
    By expirationsec=By.xpath("(//div[contains(@class,'position-absolute start-')])[2]");
    By expirationDayPopUp = By.xpath("//h5[text()='Expiration Date']");
    By refSection=By.xpath("//label[text()='Ref No.:']/..//div[text()='None']/../../../../..");
    By refNoneTxt = By.xpath("//label[text()='Ref No.:']/..//div[text()='None']");
    By refDescTxt=By.xpath("//label[text()='Ref No.:']/..//div[contains(@class,'link-empty')]");
    By DescriptionEnteredText = By.xpath("//label[text()='Description:']/..//div[contains(@class,'link-empty')]");
    By descriptionNoneTxt = By.xpath("//label[text()='Description:']/..//div[text()='None']/../../../../..");
    By refNoPopup = By.xpath("//h5[text()='Reference No.']");
    By enterTxtInRefNo = By.xpath("//h5[text()='Reference No.']/../../child::div/div/input");
    By refNopopupDoneBtn = By.xpath("//h5[text()='Reference No.']/../../child::div/button[text()='Done']");
    By descriptionSection = By.xpath("//label[text()='Description:']/..//div[text()='None']/../../../../..");
    By taxRateField = By.xpath("//input[@name='taxRate']");
    By descriptionTextField = By.xpath("//h5[text()='Description']/../following-sibling::div/child::div/textarea");
    By descriptionTitle = By.xpath("//h5[text()='Description']");
    By descriptionDoneButton = By.xpath("//h5[text()='Description']/../following-sibling::div/child::button[text()='Done']");
    By saveBtn = By.cssSelector("button[class='btn btn-primary']");
     By paidRepeatField = By.xpath("//div[text()='No repeat']/../../../../..");
    By repeatUpgradePlan = By.xpath("//h3[text()='Upgrade your plan']");
    By repeatUpgradePlanNotNowBtn = By.xpath("//button[text()='Not now']");
    By repeatTxt = By.xpath("//h5[text()='Repeat']");
     By dailyCheckbox = By.xpath("//label[normalize-space()='Daily']/input");
    By weeklyCheckbox = By.xpath("//label[normalize-space()='Weekly']/input");
    By MonthlyCheckbox = By.xpath("//label[normalize-space()='Monthly']/input");
    By yearlyCheckbox = By.xpath("//label[normalize-space()='Yearly']/input");

    By reccuringIcon = By.xpath("(//span/following-sibling::i)[1]");
    By reccuringMenu = By.xpath("//div[text()='Recurring']/..");
     By enterInBillfield = By.xpath("(//div[@class='d-flex mb-2 clone']/div/input[@name='detail_amount'])[1]");
    By reEnterAmountInBillfield = By.xpath("(//div[@class='d-flex mb-2 clone']//input[@data-field='amount'])[1]");
    By enterInSecondBillfield = By.xpath("(//div[@class='d-flex mb-2 clone']/div/input[@name='detail_amount'])[2]");
    By enteredDescTxt = By.xpath("//div[@class='border rounded p-1 overflow-hidden']");
    By refGetTxt = By.xpath("//span[contains(text(),'Ref:')]");

    // Expiration Date x-paths
    By noneTxt = By.xpath("//button[contains(text(),'None')]");
    By dayTxt = By.xpath("//button[contains(text(),'24 Hours')]");
    By quterDayTxt = By.xpath("//button[contains(text(),'24 Hours')]/following-sibling::button[contains(text(),'4 Hours')]");
    By oneHourTxt = By.xpath("//button[contains(text(),'1 Hour')]");
    By thirtyMinTxt = By.xpath("//button[contains(text(),'30')]");

    By expiresField=By.xpath("//span[text()='Expires in:']/../input[@lbl-title='Expires in']");
    By paymentMethodLink = By.xpath("//button[text()='Add payment method']");
    By customerPermissionCheckbox = By.xpath("((//label[@class='custom-checkbox'])[5]/child::i)[2]");
    By customerPrmissionDoneButton = By.xpath("(//button[text()='Continue'])[2]");
    By cardName = By.xpath("//input[@placeholder='1234 1234 1234 1234']");
    By cardIframe = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[2]");
    By cardExpiry = By.xpath("//input[@name='expiry']");
    By cvcField = By.xpath("//input[@name='cvc']");
    By cardSaveBtn = By.xpath("//button[text()='Save']");
    By shareLinkToCustomer = By.xpath("//button[normalize-space()='Send a link to the customer to add a payment method']");
    By shareLinkSuccessMessage = By.xpath("//div[text()='We sent a link to the customer.']");
    By everyDayField = By.xpath("(//div[@class='d-flex']/child::label/following-sibling::input)[1]");
    By everyWeekField = By.xpath("(//div[@class='d-flex']/child::label/following-sibling::input)[2]");
    By everyMonthField = By.xpath("(//div[@class='d-flex']/child::label/following-sibling::input)[3]");

    By specificNumbers = By.xpath("//label[normalize-space()='Specific number of times']/input");

    /*
    Locators of Bill popup
     */
    public By billPopupHeader = By.xpath("//span[text()='Bill']");

    public By uniqueRefNo = By.xpath("(//span[contains(@class,'badge position-relative')])[1]");
    public By notPaidLabel = By.xpath("(//span[text()='NOT PAID'])[1]");
    public By billTimeOnPopup = By.xpath("(//div[@class='fs-pn25 mb-1'])[1]");
    public By memoEnteredTxt = By.xpath("(//div[contains(text(),'Memo Text')])[1]");
    public By expireDateTime = By.xpath("(//div[contains(@class,'col-5  text-end ')]/div/span)[1]");
     public By taxToggleBtnDisable = By.xpath("(//input[@name='applyTax']/../child::i)[2]");
    public By amountTxtField = By.xpath("//label[text()='Amount']");
    By btnDisabled = By.xpath("(//button[@disabled='disabled'])[3]");


    String amount = "2000.00";


    public void clickOnNewBill() {
        Log.info("Clicking on newBillTxt");
        click(newBillTxt);
    }

    public void getStoresDropdown() {
        staticWait(2000);
        click(storesCombobox);
    }

    public void selectStore(String store) {
        click(By.xpath("//li[contains(text(),'" + store + "')]"));  // Select store
    }


    public void getEnableTaxToggleButton() {
        click(taxToggleBtn);
    }

    public void clickOnTapToAddImageFiles() throws AWTException {
        scrollToElement(tapToAddFiles);
        click(tapToAddFiles);
        hoverAndClick(camera, camera);
        staticWait(1000);
        uploadImageInStoreLogo();
        staticWait(5000);
        //  scrollToElement(okIcon);
        hoverAndClick(okIcon, okIcon);
    }

    public void clickOnTapToAddPdfFiles() throws AWTException {
        scrollToElement(tapToAddFiles);
        click(tapToAddFiles);
        hoverAndClick(pdfIcon, pdfIcon);
        staticWait(1000);
        uploadPdf();
        staticWait(5000);

    }

    public void clickOnMoreSection() {
        staticWait(3000);
        scrollToElement(moreSection);
        staticWait(3000);
        click(moreSection);
    }

    public void clickOnIcon() {
        staticWait(2000);
        click(closeIcon);
    }

    public void clickOnExpiryDateSection() {
        staticWait(3000);
        click(expiryDateSection);
    }
    public void clickOnExpirationSec(){
        staticWait(2000);
        click(expirationsec);
    }

    public void clickOnshareLinkToCustomer() {

        click(shareLinkToCustomer);
        String successMsg = getText(shareLinkSuccessMessage);
        Assert.assertEquals(successMsg, "We sent a link to the customer.");
    }

    public void clickOnpaymentMethodLink() {
        staticWait(3000);
        click(paymentMethodLink);
    }



    public void enterTxtInCardNumberField(String txt, String expiryDate, String cvcNumber) {
        staticWait(5000);
        switchToFrame(cardIframe);
        staticWait(5000);
        actionEnterText(cardName, txt);
        actionEnterText(cardExpiry, expiryDate);
        actionEnterText(cvcField, cvcNumber);
        switchToDefaultContent();
        click(cardSaveBtn);
    }

    public void clickOnDoneBtn() {
        clickElementByJS(doneBtn);
        staticWait(2000);
    }

    public void assertGetRefNotxt() {
        WaitUntilElementVisible(refNoneTxt, 10);
        scrollToTopOfPage();
        staticWait(2000);

        String refNoneTxts=getText(refNoneTxt);
         Assert.assertEquals(refNoneTxts,"None");
    }

    public void assertDescriptionNonetxt() {
        Assert.assertTrue(isElementDisplayed(descriptionNoneTxt));
    }

    public void clickOnGetRefNotxt() {
        staticWait(4000);
        click(refSection);

        String refNoPopups=getText(refNoPopup);
        Assert.assertEquals(refNoPopups,"Reference No.");
        referenceTxt = "Kevin123" + requiredString(42);
        staticWait(4000);
        actionEnterText(enterTxtInRefNo, referenceTxt);
        click(refNopopupDoneBtn);
        staticWait(4000);
    }

    public void entertxtInDescriptiontxt() {
        staticWait(4000);
        click(descriptionSection);
        Log.info("descriptionSection None text displayed");

        String descriptionTitles=getText(descriptionTitle);
        Assert.assertEquals(descriptionTitles,"Description");
        descriptionTxt = "Kevin123" + requiredString(192);
        staticWait(4000);
        actionEnterText(descriptionTextField, descriptionTxt);
        click(descriptionDoneButton);
        staticWait(4000);
    }

    public void assertEnteredText() {
        Log.info("Validating text");
        String referenceTxts=getText(refDescTxt);
        Assert.assertEquals(referenceTxt, referenceTxts);
        Log.info(getText(refDescTxt));

    }


    public void assertEnteredTextInDescriptionField() {
        Log.info("Validating text");

        String DescriptionEnteredTexts=getText(DescriptionEnteredText);
        Assert.assertEquals(descriptionTxt, DescriptionEnteredTexts);
        Log.info(getText(DescriptionEnteredText));
    }

    public void enterInBillTxtField(String maximumBill, String maximumSecondBill) {
        actionEnterText(enterInBillfield, maximumBill);
        actionEnterText(enterInSecondBillfield, maximumSecondBill);
    }



    public void assertingDescription() {
        Log.info("Validating text");
        Assert.assertEquals(enteredDescTxt, descriptionTxt);
        Log.info("Validating text : " + enteredDescTxt);
        Log.info("Validating text");
        Assert.assertEquals(refGetTxt, referenceTxt);
        Log.info("Validating text : " + refGetTxt);
    }


    public void enterTextInTaxRateField(String taxRateFieldText) {
        staticWait(3000);
        actionEnterText(taxRateField, taxRateFieldText);
    }

    public void clickOnSaveBtn() {
        click(saveBtn);
    }


    public String convertToNumberFormat(float num) {
        // Create a NumberFormat instance for the default locale
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        // Set maximum fraction digits to 2 for two decimal places
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);
        // Format the number and return
        return formatter.format(num);
    }

    public void getContinueButton() {
        click(continueBtn);
    }

    public void getNewBillButton() {
        staticWait(2000);
        click(newBillBtn);

    }

    public void getConfirmButton() {
        staticWait(6000);
        scrollToElement(confirmBtn);
        click(confirmBtn);
    }

    public void getContinueWithoutButton() {
        waitForElementToBeVisible(countinueWithoutTxt, 10);
        hoverAndClick(countinueWithoutTxt, countinueWithoutTxt);
    }

    public void getSelectACustomerButton() {
        staticWait(3000);
        click(selectACustomerBtn);
    }

    public void selectCust() {
        staticWait(3000);
        click(selectCust);
    }


    public void getCustomerPhoneNoField(String phone) {
        staticWait(3000);
        actionEnterText(customerNumber, phone);
    }

    public void getCustomerEmailField(String email) {
        waitForElementToBeVisible(emailField, 10);
        actionEnterText(emailField, email);
    }

    public void clickOnEnterNameDoneBtn() {
        staticWait(2000);
        if (isElementDisplayed(enterUserNamePopUp)) {
            staticWait(2000);
            click(enterCustomernameDoneBtn);
        } else {
            Log.info("POPup Not Displayed");
        }
    }


    public void BillClosePopup() {
        waitForElementToBeClickable(closePopup, 10);
        click(closePopup);
    }

    public void closePopupIcon() {
        waitForElementToBeClickable(crossPopUpIcon, 10);
        click(crossPopUpIcon);
    }

    public void clickOnCrossIcon() {
        staticWait(3000);
        click(crossIcon);
    }
    public void getCloseLogoPopupBtn() {
        hoverAndClick(closeLogoPopupBtn, closeLogoPopupBtn);
    }

    public void getEmailGoButton() {
        click(goBtnEmail);
    }


    public void getCustomerButton() {
        staticWait(3000);
        click(customerBtn);
    }

    public void uploadImageAsAttachment(String relativePath) throws AWTException {
        String projectPath = System.getProperty("user.dir");
        String absolutePath = Paths.get(projectPath, relativePath).toString();
        uploadImageFile(absolutePath);
    }

    public void uploadImageInStoreLogo() throws AWTException {
        uploadImageAsAttachment("/src/main/resources/ImageResources/image/BillDummyImg");
    }

    public void uploadPdf() throws AWTException {
        uploadImageAsAttachment("/src/main/resources/ImageResources/image/dummy");
    }

    public void getDeleteButton() {
        staticWait(2000);
        clickElementByJS(deleteButton);
    }

    public void clickOnNotPaidLabel() {
        staticWait(3000);
        hoverAndClick(notPaid, notPaid);
    }

    public void getDeleteIcon() {
        staticWait(2000);
        click(deleteIcon);
    }

    public void clickOnMemoButton() {
        staticWait(2000);
        click(memoBtn);
    }

    public void getMemoField() {
        String maxLengthValue = getAttribute(memoField, "maxlength");
        Log.info(maxLengthValue);
        Assert.assertEquals(maxLengthValue, "200");
        memoTxt = "Memo Text" + requiredString(5);
        staticWait(4000);
        actionEnterText(memoField, memoTxt);
    }


    public void getMemoFieldMessage() {
        String memoFieldMessages=getText(memoFieldMessage);
        Assert.assertEquals(memoFieldMessages, "Customer will not see this memo");
    }

    public void getMemoPopUpTitle() {
        String memoPopUpTitles=getText(memoPopUpTitle);
        Assert.assertEquals(memoPopUpTitles, "Memo");
    }

    public void getEveryDayFieldValue(String specificNumber) {
        String attValue = getAttribute(everyDayField, "value");
        Assert.assertEquals(attValue, "1");
        Log.info("Attribute value is fetched");
        staticWait(2000);
        actionEnterText(specificNumbers, specificNumber);
        Log.info("specificNumberTxt:" + specificNumber);
    }

    public void getEveryWeekFieldValue(String specificNumber) {
        String attValue = getAttribute(everyWeekField, "value");
        Assert.assertEquals(attValue, "1");
        Log.info("Attribute value is fetched");
        staticWait(2000);
        actionEnterText(specificNumbers, specificNumber);
        Log.info("specificNumberTxt:" + specificNumber);
    }

    public void getEveryMonthFieldValue(String specificNumber) {
        String attValue = getAttribute(everyMonthField, "value");
        Assert.assertEquals(attValue, "1");
        Log.info("Attribute value is fetched");
        staticWait(2000);
        actionEnterText(specificNumbers, specificNumber);
        Log.info("specificNumberTxt:" + specificNumber);
    }


    public void clickOnRepeatField() {
        staticWait(2000);
        click(paidRepeatField);
        String repeatText = getText(repeatTxt);
        Assert.assertEquals(repeatText, "Repeat");
    }

    public void closePopup() {
        staticWait(5000);
        if (isElementDisplayed(crossIcon)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(4000);
            clickOnCrossIcon();
        } else {
            Log.info("No pop-up showed");
        }
    }

    public void enableTaxToggleBtn() {
        if (isElementDisplayed(taxToggleBtn)) {
            getEnableTaxToggleButton();
        } else {
            clickOnMoreSection();
            getEnableTaxToggleButton();
            enterTextInTaxRateField("10.000");
            clickOnSaveBtn();
        }
    }

    public void closePaymentpopup() {
        staticWait(3000);
        if (isElementDisplayed(closePopup)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(5000);
            BillClosePopup();
        } else {
            Log.info("No pop-up showed");
        }
    }

    public void removeNonNumericValueFromTheValue() {
        String amt = "1000.00";
        String text = getText(reccuringAmount);  // Get text (e.g., "Maximum $50,000")
        // Remove the dollar sign and commas using replaceAll()
        String numericValue = text.replaceAll("[$,]", "");
        Log.info("Numeric Value: " + numericValue); // Output: 1000.00// Remove non-numeric characters
        Assert.assertEquals(amt, numericValue);
    }

    public void validatingEnteredAmount() {
        String amount = getText(enteredAmount);  // Get the value from the field
        Log.info("Field value: " + amount);

        // Remove non-numeric characters (like commas or currency symbols)
        String extractedNumber = amount.replaceAll("[^0-9]", "");
        Log.info("Extracted Number: " + extractedNumber);

        // Parse to integer for comparison
        int actualAmount = Integer.parseInt(extractedNumber);

        // Validate against the limit
        if (actualAmount > 50000) {
            Log.info("Restriction FAILED. Field allowed more than 50,000: " + actualAmount);
        } else {
            Log.info("Restriction WORKING. Value in field is within limit: " + actualAmount);
        }
    }


    public void validateEnteredAmount() {
        String testInput = "500001";
        // Try to enter more than 50000
        staticWait(3000);

        String fieldValue = getText(enteredAmount);
        staticWait(3000);


        // Read actual value from the field

        Log.info("Attempted to enter: " + testInput);
        Log.info("Actual field value after restriction: " + fieldValue);

        // Remove non-numeric characters if the field includes commas or currency symbols
        // String numericFieldValue = fieldValue.replaceAll("[^0-9]", "");
        String numericFieldValue = fieldValue.replaceAll("[^0-9.]", "");

        double actualAmount = Double.parseDouble(numericFieldValue);

        if (actualAmount > 50000.00) {
            Log.info(" Restriction FAILED. Field allowed more than 50,000: " + actualAmount);
        } else {
            Log.info(" Restriction WORKING. Value in field is within limit: " + actualAmount);
        }
    }

    public void getAmountValue() {
        String text = getText(configureAmount);  // Get text (e.g., "Maximum $50,000")
        String numericValue = text.replaceAll("[^0-9]", ""); // Remove non-numeric characters
        Log.info("Extracted Number: " + numericValue); // Output: 50000
    }

    public void clickOnCloseIcon() {
        staticWait(3000);
        if (isElementDisplayed(closeLogoPopupBtn)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(4000);
            getCloseLogoPopupBtn();
        } else {
            Log.info("No pop-up showed");
        }

    }

    public void closePopupOnBillPage() {
        staticWait(3000);
        if (isElementDisplayed(crossPopUpIcon)) {
            System.out.print(" pop-up showed and clicking");
            staticWait(5000);
            closePopupIcon();
        } else {
            Log.info("No pop-up showed");
        }
    }

    public void getDailyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Daily")) {
                staticWait(2000);
                click(dailyCheckbox);
                staticWait(2000);
                getEveryDayFieldValue("3");
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
                List<WebElement> selectedElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement selectedElement : selectedElements) {
                    staticWait(2000);
                    scrollToDown();
                    String selectedTxt = selectedElement.getText();
                    Log.info("Selected: " + selectedTxt);
                }
            }
        }
    }


    public void getWeeklyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Weekly")) {
                staticWait(2000);
                click(weeklyCheckbox);
                staticWait(2000);
                getEveryWeekFieldValue("3");
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
                List<WebElement> selectedElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement selectedElement : selectedElements) {
                    staticWait(2000);
                    scrollToDown();
                    String selectedTxt = selectedElement.getText();
                    Log.info("Selected: " + selectedTxt);
                }
            }
        }
    }

    public void getMonthlyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Monthly")) {
                staticWait(2000);
                click(MonthlyCheckbox);
                staticWait(2000);
                getEveryMonthFieldValue("3");
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
                List<WebElement> selectedElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement selectedElement : selectedElements) {
                    staticWait(2000);
                    scrollToDown();
                    String selectedTxt = selectedElement.getText();
                    Log.info("Selected: " + selectedTxt);
                }
            }
        }
    }

    public void getYearlyFieldValue() {
        List<WebElement> elements = getDriver().findElements(By.xpath("//div[@class='list-group mb-2']/child::label"));
        for (WebElement element : elements) {
            staticWait(2000);
            String repeatTxt = element.getText();
            Log.info(repeatTxt);
            if (repeatTxt.equals("Yearly")) {
                staticWait(2000);
                click(yearlyCheckbox);
                List<WebElement> dailyElements = getDriver().findElements(By.xpath("//div[@class='list-group-item']"));
                for (WebElement dailyElement : dailyElements) {
                    staticWait(2000);
                    String dailyTxt = dailyElement.getText();
                    Log.info(dailyTxt);
                }
            }
        }
    }


    public void clickOnRepeatsection() {
        staticWait(2000);
        click(paidRepeatField);
    }

    public void assertUpgradePlan() {
        scrollToElement(repeatUpgradePlan);
        Assert.assertTrue(isElementDisplayed(repeatUpgradePlan));
        click(repeatUpgradePlanNotNowBtn);
    }

    public void clickOnReccuring() {
       //  Assert.assertTrue(isElementDisplayed(reccuringIcon));
        staticWait(2000);
        click(reccuringMenu);
        click(reccuringBill);
    }

    public void createBillWithoutCustomer() {
        Login();

        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Click on New Bill Button
        getNewBillButton();

        // Verify New Bill popup Web Elements
        String billPopupTitle = getText(billPopupHeader);
        Assert.assertEquals(billPopupTitle, BillHeader);
        Assert.assertTrue(isElementDisplayed(amountTxtField), "Amount");
        Assert.assertTrue(isElementDisplayed(addBillDescription), "Description (optional)");
        Assert.assertTrue(isElementDisplayed(customerDropdown), "Select or create a new customer");
        Assert.assertTrue(isElementDisplayed(moreLabelTxt), "More options");


        // Verify Default value of Amount tab
        String defaultAmt = getAttribute(amtInput, "value");
        Assert.assertEquals(defaultAmt, "$0.00");

        //Verify Confirm Button is disabled before entering amount
        scrollToElement(btnDisabled);
        Assert.assertTrue(isElementDisplayed(btnDisabled));

        //Enter amount
        String amt = "2,999.00";
        // Thread.sleep(4000);
        actionEnterText(amtTbx, amt);

        Assert.assertTrue(isElementDisplayed(taxToggleBtnDisable));

        // Verify Default Confirm button is enabled after entering amount
        scrollToElement(confirmBtn);
        Assert.assertTrue(isElementDisplayed(confirmBtn));


        //Click Confirm
        getConfirmButton();

        //Verify Message popup and Buttons
        String messagePopup = getText(messagePopupHeader);
        Assert.assertEquals(messagePopup, "Message");
        Assert.assertTrue(isElementDisplayed(selectCustomer));
        Assert.assertTrue(isElementDisplayed(continueWithoutBtn));

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();

    }

    public void deleteBill() {
        clickOnNotPaidLabel();
        staticWait(2000);
        getDeleteButton();
        getDeleteIcon();
    }

    public void createBillWithCustomer(String phoneNumber, String emailID) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Click on New Bill Button
        getNewBillButton();

        // Verify New Bill popup
        //  Assert.assertEquals(popUpHeader, "Bill");
        String popupheader = getText(popUpHeader);
        Assert.assertEquals(popupheader, "Bill");

        //Verify Confirm Button is disabled before entering amount
        scrollToElement(btnDisabled);
        Assert.assertTrue(isElementDisplayed(btnDisabled));


        //Enter amount
        String amt = "2,000.00";
        staticWait(3000);
        scrollToElement(amtTbx);
        actionEnterText(amtTbx, amt);

        //Verify Default Confirm button is enabled after entering amount
        scrollToElement(confirmBtn);
        Assert.assertTrue(isElementDisplayed(confirmBtn));


        //Click Confirm
        getConfirmButton();

        //Verify Message popup and Buttons
        String messagePopupHeade = getText(messagePopupHeader);
        Assert.assertEquals(messagePopupHeade, "Message", "Message popup header");

        Assert.assertTrue(isElementDisplayed(selectCustomer));

        Assert.assertTrue(isElementDisplayed(continueWithoutBtn));


        //click on select customer button.
        getSelectACustomerButton();

        //Verify Customer popup
        String phoneNumberField = "Phone number. Existing or new";
        String phone = getAttribute(customerNumber, "placeholder");
        //   Assert.assertTrue(Boolean.parseBoolean(phone), phoneNumberField);
        Assert.assertEquals(phone, phoneNumberField);
        Log.info(phone);

        String emailFieldTxt = "Email. Existing or new";
        String email = getAttribute(emailField, "placeholder");
        //  Assert.assertTrue(Boolean.parseBoolean(email), emailField);
        Assert.assertEquals(email, emailFieldTxt);
        Log.info(email);


        //   Select Customer
        getCustomerPhoneNoField(phoneNumber);
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click Confirm

        getConfirmButton();

        //Verify toast message : Success message Popup.
        Assert.assertTrue(isElementDisplayed(successMessage));
        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        String toastMess = getText(successMessage);
        Assert.assertEquals(toastMess, toastMessage);


        //Close popup
        closePopupOnBillPage();

        //Deleting Created Bill
//        waitForElementToBeClickable(notPaid, 5);
//        clickOnNotPaidLabel();
    }

    public void verifyCreateBillForSuggestedCustomer(String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "105.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer

        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();
        getConfirmButton();

        //Verify toast message : Success message Popup.
        waitForElementToBeVisible(successMessage, 10);
        Assert.assertTrue(isElementDisplayed(successMessage));

        String successMsg = getText(successMessage);

        String toastMessage = "Bill has been created successfully.Click here to open the bill";
        Assert.assertEquals(successMsg, toastMessage);

        //Close popup
        closePopup();

        //Verify not paid label for generated amount
        Assert.assertTrue(isElementDisplayed(notPaidLabel), "Not Paid Label");
        Assert.assertTrue(isElementDisplayed(uniqueRefNo), "Unique Reference No");
        Assert.assertTrue(isElementDisplayed(billTimeOnPopup), "Bill Time On Popup");
        staticWait(3000);
    }

    public void verifyBillCreationByOptionalFields(String amount, String DesAmount, String emailID) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //click on more option section
        clickOnMoreSection();

        //Asserting 'None' text bydefault in the 'Ref No' field.
        assertGetRefNotxt();
        //Asserting Reference No.' popup.
        clickOnGetRefNotxt();
        //Asserting entered text in refno text field
        assertEnteredText();
        assertDescriptionNonetxt();
        // Click on Descrption field
        entertxtInDescriptiontxt();
        assertEnteredTextInDescriptionField();
        enterInBillTxtField(amount, DesAmount);

        //select customer to share the bill
        //Select Suggested Customer
        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();
        getConfirmButton();

        //Close popup
        closePopup();

    }

    public void verifyingBillCreationWithConfiguredBilledAmount() {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "5000001";
        validateEnteredAmount();
        getAmountValue();

        staticWait(3000);
        actionEnterText(amtTbx, amt);

        validatingEnteredAmount();

        //Click Confirm
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();

        //Close popup
        closePaymentpopup();

        //Deleting Created Bill
        staticWait(3000);
    }

    public void verifyingBillCreationWithOutConfiguredBillAmount() {


        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillTest);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        amt = "300001";


        getAmountValue();

        staticWait(3000);
        actionEnterText(amtTbx, amt);

        validatingEnteredAmount();


        //Click Confirm
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();


        //Close popup
        closePaymentpopup();


        //Deleting Created Bill
        staticWait(3000);


    }

    public void createBillByAttachingImageFile() throws InterruptedException, AWTException {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillTest);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        Thread.sleep(4000);
        actionEnterText(amtTbx, amt);

        clickOnTapToAddImageFiles();

        //Click Confirm
        getConfirmButton();


    }

    public void verifyingBillCreationByAttachingPdfFile() throws InterruptedException, AWTException {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Verifying that these buttons appear on Bill Page
        Assert.assertTrue(isElementDisplayed(newBillBtn));
        Assert.assertTrue(isElementDisplayed(transactionsLink));
        Assert.assertTrue(isElementDisplayed(filterBtn));

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        Thread.sleep(4000);
        actionEnterText(amtTbx, amt);

        clickOnTapToAddPdfFiles();

        //Click Confirm
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();

        //Close popup
        closePopup();
    }

    public void verifyingBillCreationWithAddingMemoField(String emailID) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer
        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();


        //click on more option section
        clickOnMoreSection();

        staticWait(4000);
        String memoTxt = getText(memoNoneTxt);
         Assert.assertEquals(memoTxt,"None");
        getMemoFieldMessage();
        clickOnMemoButton();

        //Verifying details of 'Memo' Pop-up
        getMemoPopUpTitle();
        getMemoField();
        clickOnDoneBtn();

        //Confirming the Bill
        getConfirmButton();

        //Close popup
        closePopupOnBillPage();
        //Verify not paid label for generated amount
        //verifyEnteredMemoText();
    }


    public void verifyingBillCreationWithEssentialFreePlan(String emailId) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationCustomerStore);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1250.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer
        getCustomerButton();
        getCustomerEmailField(emailId);
        getEmailGoButton();
        clickOnEnterNameDoneBtn();


        //click on more option section
        clickOnMoreSection();

        //Click on 'Repeat' Field
        Assert.assertTrue(isElementDisplayed(repeatLockIcon));
        clickOnRepeatsection();
        assertUpgradePlan();


        //Click on 'Expiry' Field
        Assert.assertTrue(isElementDisplayed(expireLockIcon));
        clickOnExpirationSec();
        assertUpgradePlan();


        //Confirming the Bill
        getConfirmButton();

        //Close popup
        closePaymentpopup();

//Verify not paid label for generated amount
        Assert.assertTrue(isElementDisplayed(notPaidLabel));
        Assert.assertTrue(isElementDisplayed(uniqueRefNo));
        Assert.assertTrue(isElementDisplayed(billTimeOnPopup));
        Assert.assertTrue(isElementDisplayed(expireDateTime));

        staticWait(3000);

    }

    public void verifyBillCreationByAddingExpirationDate(String emailID,String expiresInFieldTxt) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        // Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "2,000.00";
        staticWait(3000);
        scrollToElement(amtTbx);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer

        getCustomerButton();
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();

        clickOnExpiryDateSection();
        staticWait(2000);

        String expirationDay = getText(expirationDayPopUp);
        Assert.assertEquals(expirationDay,"Expiration Date");

        String noneTxts = getText(noneTxt);
        Assert.assertEquals(noneTxts, "None");

        String dayTxts = getText(dayTxt);
        Assert.assertEquals(dayTxts, "24 Hours");
        String quterDayTxts = getText(quterDayTxt);
        Assert.assertEquals(quterDayTxts, "4 Hours");
        String oneHourTxts = getText(oneHourTxt);
        Assert.assertEquals(oneHourTxts, "1 Hour");
        String thirtyMinTxts = getText(thirtyMinTxt);
        Assert.assertEquals(thirtyMinTxts, "30 Minutes");

        //Click on Expiry Field
        actionEnterText(expiresField,expiresInFieldTxt );
        clickOnDoneBtn();


        //Click Confirm
        getConfirmButton();



        //Close popup
        closePopup();


      //Verify not paid label for generated amount
        Assert.assertTrue(isElementDisplayed(notPaidLabel));
        Assert.assertTrue(isElementDisplayed(uniqueRefNo));
        Assert.assertTrue(isElementDisplayed(billTimeOnPopup));
        Assert.assertTrue(isElementDisplayed(expireDateTime));
        staticWait(3000);
    }

    public void verifyBillCreationByAddingRecurringTransactionsDaily(String phoneNumber, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //click on select customer button.
        selectCust();

        //Verify Customer popup
        String phoneNumberField = "Phone number. Existing or new";
        String phone = getAttribute(customerNumber, "placeholder");
        //   Assert.assertTrue(Boolean.parseBoolean(phone), phoneNumberField);
        Assert.assertEquals(phone, phoneNumberField);
        Log.info(phone);

        String emailFieldTxt = "Email. Existing or new";
        String email = getAttribute(emailField, "placeholder");
        //  Assert.assertTrue(Boolean.parseBoolean(email), emailField);
        Assert.assertEquals(email, emailFieldTxt);
        Log.info(email);

        //   Select Customer
        getCustomerPhoneNoField(phoneNumber);
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getDailyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();

        //Click Confirm
        staticWait(2000);
        getConfirmButton();

        //Close popup
        closePopup();

        scrollToTopOfPage();
         clickOnReccuring();
        removeNonNumericValueFromTheValue();
        //Deleting Created Bill
        staticWait(3000);
    }

    public void verifyBillCreationByAddingRecurringTransactionsWeekly(String phoneNumber, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //click on select customer button.
        selectCust();

        //Verify Customer popup
        String phoneNumberField = "Phone number. Existing or new";
        String phone = getAttribute(customerNumber, "placeholder");
        //   Assert.assertTrue(Boolean.parseBoolean(phone), phoneNumberField);
        Assert.assertEquals(phone, phoneNumberField);
        Log.info(phone);

        String emailFieldTxt = "Email. Existing or new";
        String email = getAttribute(emailField, "placeholder");
        //  Assert.assertTrue(Boolean.parseBoolean(email), emailField);
        Assert.assertEquals(email, emailFieldTxt);
        Log.info(email);


        //   Select Customer
        getCustomerPhoneNoField(phoneNumber);
        getCustomerEmailField(emailID);
        getEmailGoButton();


        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getWeeklyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        getConfirmButton();


        //clickOnIcon();
        //Close popup
        closePopup();

        // Assert.assertTrue(isElementDisplayed(reccuringIcon));
        scrollToTopOfPage();
        clickOnReccuring();

        removeNonNumericValueFromTheValue();
        //Deleting Created Bill
        staticWait(3000);
    }

    public void BillCreationByAddingRecurringTransactionsWeekly(String phoneNumber, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //click on select customer button.
        selectCust();

        //Verify Customer popup
        String phoneNumberField = "Phone number. Existing or new";
        String phone = getAttribute(customerNumber, "placeholder");
        //   Assert.assertTrue(Boolean.parseBoolean(phone), phoneNumberField);
        Assert.assertEquals(phone, phoneNumberField);
        Log.info(phone);

        String emailFieldTxt = "Email. Existing or new";
        String email = getAttribute(emailField, "placeholder");
        //  Assert.assertTrue(Boolean.parseBoolean(email), emailField);
        Assert.assertEquals(email, emailFieldTxt);
        Log.info(email);


        //   Select Customer
        getCustomerPhoneNoField(phoneNumber);
        getCustomerEmailField(emailID);
        getEmailGoButton();


        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getWeeklyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();

        //Click Confirm

        getConfirmButton();

        //Close popup
        closePopup();

        // Assert.assertTrue(isElementDisplayed(reccuringIcon));
        staticWait(2000);
        scrollToTopOfPage();
        clickOnReccuring();

        removeNonNumericValueFromTheValue();
        //Deleting Created Bill
        staticWait(3000);
    }


    public void verifyBillCreationByAddingRecurringTransactionsMonthly(String phoneNumber, String emailID) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1000.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //click on select customer button.
        selectCust();

        //Verify Customer popup
        String phoneNumberField = "Phone number. Existing or new";
        String phone = getAttribute(customerNumber, "placeholder");
        //   Assert.assertTrue(Boolean.parseBoolean(phone), phoneNumberField);
        Assert.assertEquals(phone, phoneNumberField);
        Log.info(phone);

        String emailFieldTxt = "Email. Existing or new";
        String email = getAttribute(emailField, "placeholder");
        //  Assert.assertTrue(Boolean.parseBoolean(email), emailField);
        Assert.assertEquals(email, emailFieldTxt);
        Log.info(email);


        //   Select Customer
        getCustomerPhoneNoField(phoneNumber);
        getCustomerEmailField(emailID);
        getEmailGoButton();

        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getMonthlyFieldValue();
        //  bill.activateAfterFirstElement();
        clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        getConfirmButton();


        //Close popup
        closePopup();

        scrollToTopOfPage();
        clickOnReccuring();
        removeNonNumericValueFromTheValue();

        //Deleting Created Bill
        staticWait(3000);
    }

    public void verifyBillCreationByAddingRecurringTransactionsYearly(String phone, String Email) {

        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount

        staticWait(3000);
        String amt = "1000.00";
        actionEnterText(amtTbx, amt);

        //Click on More Option
        clickOnMoreSection();
        clickOnRepeatField();
        getYearlyFieldValue();
        clickOnDoneBtn();


        //Click Confirm
        staticWait(2000);
        getConfirmButton();

        //Click On Continue Button
        staticWait(4000);
        getContinueWithoutButton();

        clickOnIcon();
        //Close popup
        closePopupOnBillPage();

        Assert.assertTrue(isElementDisplayed(reccuringIcon));
        clickOnReccuring();

        removeNonNumericValueFromTheValue();

        //Deleting Created Bill
        staticWait(3000);


    }

    public void verifyBillCreationByAddingpaymentMethod(String emilId) {
        Login();
        //Select Store
        clickOnNewBill();
        getStoresDropdown();
        selectStore(Constants.AutomationBillFlow);
        getContinueButton();

        //Click on New Bill Button
        getNewBillButton();

        //Enter amount
        String amt = "1005.00";
        staticWait(3000);
        actionEnterText(amtTbx, amt);

        //Select Suggested Customer

        getCustomerButton();
        getCustomerEmailField(emilId);
        getEmailGoButton();

        //Share bill by clicking on Share link to customer button
        clickOnpaymentMethodLink();
        clickOnshareLinkToCustomer();

        //Share bill by adding card details
        clickOnpaymentMethodLink();

    }
}