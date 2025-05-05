package pageEvents;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import base.BaseTest;
import org.openqa.selenium.By;

public class PaymentMethod extends BaseTest {
    public By PaymentMethodTitle = By.xpath("//h3[text()='Payment Methods']");
    public By addORModifyPaymentLink = By.xpath("//a[text()='Add or modify payment methods']");
    public By addPaymentButton = By.xpath("//button[text()='Add Payment Method']");
    public By addNewPaymentMethodTitle = By.xpath("//h5[text()='Add new payment method']");
    public By creditCardOption = By.xpath("(//span[@class='payment-logo-bg me-2'])[1]");
    public By bankAccountOption = By.xpath("(//span[@class='payment-logo-bg me-2']//..)[2]");
    public By crossIconAddNewPaymentPopup = By.xpath("//button[@class='btn-close text-reset']");
    public By newPaymentMethodPopupTitle = By.xpath("//h5[text()='New payment method']/..");
    public By bankEmailField = By.cssSelector("[name=email]");
    public By fullNameBField = By.cssSelector("[placeholder='First and last name']");
    public By testInsituteBtn = By.xpath("//p[text()='Test Institution']");
    public By LogInWithTestInstitutionLabel = By.xpath("//div[contains(@class,'LightboxModalContent')]//h1[text()='Log in with Test Institution']");
    public By agreeAndContinueBtn = By.xpath("//footer[contains(@class,'la-v3-pane-footer-wrapper')]//span[text()='Agree and continue']/..");
    public By successOption = By.xpath("//div[contains(@class, 'la-v3-accountPicker')]//div/p[text()='Success']");
    public By continueAccount = By.xpath("(//span[text()='Connect account']//..)[2]");
    public By saveWithLink = By.xpath("//span[text()='Save with Link']/..");
    public By notNow = By.xpath("//span[text()='Not now']/..");
    public By backToKadePay = By.xpath("//span[text()='Back to Kade Pay']/..");
    public By finalSavebtn = By.xpath("//button[contains (@class, 'btn btn-primary ') and text()='Save']");
    public By bankFrame = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[1]");
    public By loginInsitututeFrame = By.xpath("(//iframe[contains(@name,'__privateStripeFrame')])[2]");
    public By successText = By.xpath("//div[contains(@class,'la-v3-successTextWrapper')]//h1");
    public By stripeBankAccountText = By.xpath("//div[contains(@class,'p-PickerItem--singleRow')]//../h3");
    public By trash = By.xpath("//i[@class='fas fa-trash']//..");
    public By noPaymentInfo = By.xpath("//div[@class='no-result-icon']/../p");
    public By thumbIcon = By.xpath("//i[contains(@class,'fal fa-thumbs-up')]//..");

    // Methods
    public void  getAddOrModifyPaymentLink(){
        click(addORModifyPaymentLink);
    }
    public void getAddPaymentButton(){
        click(addPaymentButton);
    }
    public void getCreditCardOption(){click(creditCardOption);}
    public void getBankAccountOption(){click(bankAccountOption);}
    public void getCrossIconOfNewP(){click(crossIconAddNewPaymentPopup);}
    public void getTestInsituteBtn(){click(testInsituteBtn);}
    public void getAgreeAndContinueBtn(){clickElementByJS(agreeAndContinueBtn);}
    public void getSuccessOption(){
        click(successOption);
    }
    public void getConnectAccountBtn(){
        click(continueAccount);
    }
    public void getSaveWithLinkBtn(){
        click(saveWithLink);
    }
    public void getNotNow(){
        click(notNow);
    }
    public void getBackToKadePayBtn(){
        click(backToKadePay);
    }
    public void getFinalSaveBtn(){
        click(finalSavebtn);
    }
    public void getTrashIcon(){
        clickElementByJS(trash);
    }
    public void getThumbIcon(){
        clickElementByJS(thumbIcon);
    }
}
