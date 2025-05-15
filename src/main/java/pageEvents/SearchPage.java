package pageEvents;

import base.BaseTest;
import io.netty.util.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Constants;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SearchPage extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(SearchPage.class);
    public By billBtn = By.xpath("//div[@class='text-nowrap'and contains(text(),'Bills')]");
    public By transactionsBtn = By.xpath("//div[@class='text-nowrap'and contains(text(),'Transactions')]");
    public By continueTrans= By.xpath("//button[@class='btn btn-primary' and contains(text(), 'Continue')]");
    public By SearchBtn = By.xpath("//div[@class='text-nowrap'and contains(text(),'Search')]");
    public By transactionIdtext = By.xpath("(//div[@class='position-relative loaded']/div/div/span)[1]");
    public By popupBilId= By.xpath("//span[contains(@class, 'badge') and contains(@class, 'text-truncate') ]");
    public By popuptransId = By.xpath("//span[contains(@class, 'badge') and contains(@class, 'flex-shrink-0')]");
    By SearchPopup = By.cssSelector(".modal-content");
    By SearchLabel = By.xpath("//div[@class = 'modal-body']/div");
    public By SearchBillReferenceId = By.xpath("(//div[@class='position-relative loaded']/div/div/span)[1]");
    public By CopyReferenceId = By.xpath("//div[@class='mb-1']/span");
    public By CloseBillButton = By.xpath("//div[@class='modal-header']/button");
    public By ClickSearchBox = By.xpath("//input[@name='phrase']");
    public By ClickSearchIcon =By.xpath("//div[@class='input-group']/button");
    public By Billid = By.xpath("//div[@class='mb-1']/span");
    public By SearchTransReferenceId = By.xpath("(//div[@class='position-relative loaded']/div/div/span)[1]");
    public By TransactionId = By.xpath("(//div[@class='col-7']/div/span)[1]");
    public By continueBtn = By.xpath("//button[@class='btn btn-primary' and @type='submit']");
    public By refrenceIdtext= By.xpath("//div[@class='position-relative loaded']/div/div/span[1]");
    public  By popupClickOk = By.xpath("//button[text()='OK']");
    By UserProfile = By.xpath("(//a[@class='text-truncate'])[1]");
    By Useremail = By.xpath("//div[@class='d-flex mb-2']/div/div");
    By VerifyUserEmail = By.xpath("//div[@class='d-flex flex-column overflow-hidden']/div");
    By ReferenceValidation = By.cssSelector(".display-none");
    By InvalidphoneValidation =By.xpath("//div[contains(@class, 'alert-error')]");
    By VerifyNumber = By.xpath("//div[@class='fs-pn15 mb-3']//div[1]");





    public void clickonSearch(){
        log.info("CLicking on Search button");
        click(SearchBtn);
    }

    public SearchPage getSearchPage() { return new SearchPage(); }

    public void assertPopup(){
        softAssert.assertTrue(isElementDisplayed(SearchPopup));
    }

    public By getSearchLabel() {
        return SearchLabel;
    }

    public void getbillBtn(){
        click(billBtn);
    }

    public void getTransactionsBtn(){
        click(transactionsBtn);
    }

    public void getUserProfile(){
        click(UserProfile);

    }

    public void verifySearchlabel(){

        String actualSearchLabel = getText(getSearchLabel());
        String expectedSearchLabel = "Search by reference Id";
        softAssert.assertEquals(expectedSearchLabel, actualSearchLabel);
    }

    public String getCopyReferenceId(){
        return getText(refrenceIdtext);
    }

    public String getCopyTransactionId(){
        waitForElementToBeVisible(transactionIdtext,2);
        return getText(transactionIdtext);
    }

    public String checkpopupbillid(){
        return getText(popupBilId);
    }

    public String checkpopuptransid(){
        return getText(popuptransId);
    }

    public void getUseremail(){
        String Useremails = getText(Useremail);
    }

    public void InputPhoneNumber(){
        actionEnterText(ClickSearchBox, Constants.ValidPhone);
    }

    public void InputInvalidPhoneNumber(){
        actionEnterText(ClickSearchBox, Constants.invalidPhoneNumber);
    }


    public void  checkbybillid() {


            getbillBtn();
            staticWait(2000);
            click(continueBtn);
            waitForElementToBeVisible(refrenceIdtext,4);
            getCopyReferenceId();
            clickonSearch();
            click(ClickSearchBox);
            String refid = getCopyReferenceId();
            actionEnterText(ClickSearchBox, refid);
            click(ClickSearchIcon);
            String popupBillid = checkpopupbillid();
            assertEquals(refid, popupBillid);
            click(CloseBillButton);
        }

    public void checkbytransactionid(){

            waitForElementToBeClickable(transactionsBtn,3);
             getTransactionsBtn();
             staticWait(2000);
             click(continueTrans);
             waitForElementToBeVisible(transactionIdtext,2);
             getCopyTransactionId();
             clickonSearch();;
             click(ClickSearchBox);
             String tranid = getCopyReferenceId();
             waitForElementToBeClickable(ClickSearchBox,2);
             actionEnterText(ClickSearchBox,tranid);
             click(ClickSearchIcon);
             String popupTransid = checkpopuptransid();
             assertEquals(tranid, popupTransid);
             click(CloseBillButton);



    }

    public void performSearchAndVerify(String actiontype) throws IOException, UnsupportedFlavorException {

            if (actiontype.equals("Bills"))
            {
                checkbybillid();
            }
            else
            {
                checkbytransactionid();
            }
        }
    public void verifyUserDirectedToCustomerPageUsingValidIdentity() {

                LoginAsNewUser();

                staticWait(2000);
                clickonSearch();
                click(ClickSearchBox);
                InputPhoneNumber();
                click(ClickSearchIcon);
                staticWait(3000);
                String PhoneValidation = getText(VerifyNumber);
                System.out.println( PhoneValidation);
                Assert.assertEquals(PhoneValidation,Constants.ValidPhone);
                staticWait(2000);
    }

    public void verifyUserDirectedToCustomerPageUsingInvalidIdentity() {


                clickonSearch();
                click(ClickSearchBox);
                InputInvalidPhoneNumber();
                click(ClickSearchIcon);
                staticWait(3000);
                String InvalidValidation = getText(InvalidphoneValidation);
                Assert.assertEquals(InvalidValidation,Constants.expectedSearchValidation);

    }

    public void SearchAndVerify(String actiontype) throws IOException, UnsupportedFlavorException {
                if (actiontype.equals("Valid"))
                {
                    verifyUserDirectedToCustomerPageUsingValidIdentity();
                }
                else
                {
                    verifyUserDirectedToCustomerPageUsingInvalidIdentity();
                }
            }
    }



