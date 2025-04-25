package qa.tests;
import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageEvents.BasicInfoPage;
import pageEvents.SearchPage;
import pageObjects.PageObjectManager;
import org.testng.Assert;
import utils.Constants;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

public class SearchTest extends BaseTest {
    SearchPage search = new SearchPage();


    @Test(description = " SP01, SP02 : Verify that 'Search' popup appears after clicking on 'Search' tab, on Left Panel.")
    public void verifySearchPopupAppearsAfterClickingSearchTab() throws IOException, UnsupportedFlavorException {
        Login();

        search.clickonSearch();
        search.assertPopup();
        search.verifySearchlabel();

    }

    @Test(description = " SP03 : Verify that 'bill or transaction' popup appears after searching with a reference ID in 'Search by Reference ID, Phone, or Email' field.")
    public void verifyBillOrTransactionAppearsAfterSearchingByReferenceId() throws Exception {
        Login();

        search.performSearchAndVerify("Bills");
        search.performSearchAndVerify("Transactions");

    }

    @Test(description = " SP04, SP05 : Verify that user is directed to specific cutomer's page using phone number")
    public void verifyUserDirectedToCustomerPageUsingPhoneNumberoremail () throws IOException, UnsupportedFlavorException {


         search.SearchAndVerify("Valid");
         search.SearchAndVerify("Invalid");




        }
    }
