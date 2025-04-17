package qa.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageEvents.GiftCardDashboardPage;
import pageEvents.SidePannelPage;
import pageObjects.PageObjectManager;
import utils.Constants;
import base.BaseTest;


public class GiftCardDashboardTest extends BaseTest {



    private PageObjectManager pageObjectManager = PageObjectManager.getInstance();
    private GiftCardDashboardPage giftCardPage = pageObjectManager.getGiftCardPage();


    @Test(priority = 1, enabled = true, description = "Verify that user gets directed to 'Gift Cards Dashboard' page, after clicking on any store under 'Which store?' section.")
    public void verifyGiftcardDashboardPage() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        softAssert.assertEquals(giftCardPage.giftCardDashBoardHeaderText, Constants.GiftCardHeader);
        String name = giftCardPage.selectStore(3);
        giftCardPage.clickWhichStoreContinueBtn();
        softAssert.assertEquals(giftCardPage.storeName.toString(), name);
        System.out.println(giftCardPage.infoMessageText);
        softAssert.assertEquals(giftCardPage.infoMessageText, Constants.infoMessage);

    }

    @Test(priority = 2, enabled = true, description = "Verify that 'Gift Cards Configuration' popup opens up after clicking on 'Configuration' link, on 'Gift Card Dashboard' page.")
    public void verifyGiftConfigurationPopup() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        softAssert.assertEquals(giftCardPage.getConfigurationPopupText().toString(), Constants.configurationPopupTitle);
        softAssert.assertEquals(giftCardPage.getDisabledText().toString(), Constants.DisabledText);

    }

    @Test(priority = 3, enabled = true, description = "TC_04_01 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyReferenceNoOptions() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(6);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();

        if (isDisplayed(giftCardPage.disabledToggleBtn, 1000)) {
            softAssert.assertEquals(giftCardPage.disabledText, Constants.DisabledText);
            giftCardPage.enableToggleButton();
            softAssert.assertEquals(giftCardPage.enableText, Constants.EnableText);
            if (isDisplayed(giftCardPage.refernceNoDiableToggleBtn, 1000)) {
                softAssert.assertEquals(giftCardPage.referenceNoDisabledText, Constants.referenceNoDisabledText);
                giftCardPage.enableReferenceNoEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.referenceNoEnabledText, Constants.referenceNoEnabledText);
            } else {
                giftCardPage.disableReferenceNoEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.referenceNoDisabledText, Constants.referenceNoDisabledText);
                giftCardPage.enableReferenceNoEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.referenceNoEnabledText, Constants.referenceNoEnabledText);
            }
        } else {
            giftCardPage.disableToggleButton();
            softAssert.assertEquals(giftCardPage.disabledText, Constants.DisabledText);
            giftCardPage.enableToggleButton();
            softAssert.assertEquals(giftCardPage.enableText, Constants.EnableText);
            if (isDisplayed(giftCardPage.refernceNoDiableToggleBtn, 1000)) {
                softAssert.assertEquals(giftCardPage.referenceNoDisabledText, Constants.referenceNoDisabledText);
                giftCardPage.enableReferenceNoEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.referenceNoEnabledText, Constants.referenceNoEnabledText);
            } else {
                giftCardPage.disableReferenceNoEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.referenceNoDisabledText, Constants.referenceNoDisabledText);
                giftCardPage.enableReferenceNoEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.referenceNoEnabledText, Constants.referenceNoEnabledText);
            }

        }
    }


    @Test(priority = 4, enabled = true, description = "TC_4_02 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifySourceFundingOptions() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(6);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();

        if (isDisplayed(giftCardPage.disabledToggleBtn, 1000)) {
            softAssert.assertEquals(giftCardPage.disabledText, Constants.DisabledText);
            giftCardPage.enableToggleButton();
            softAssert.assertEquals(giftCardPage.enableText, Constants.EnableText);
            if (isDisplayed(giftCardPage.fundingSourceDisableText, 1000)) {
                softAssert.assertEquals(giftCardPage.fundingSourceDisableText, Constants.sourceFundingDisabledText);
                giftCardPage.enableFundingSourceEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.fundingSourceEnabledText, Constants.getSourceFundingEnabledText);
            } else {
                giftCardPage.disableFundingSourceEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.fundingSourceDisableText, Constants.sourceFundingDisabledText);
                giftCardPage.enableFundingSourceEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.fundingSourceEnabledText, Constants.sourceFundingDisabledText);
            }
        } else {
            giftCardPage.disableToggleButton();
            softAssert.assertEquals(giftCardPage.disabledText, Constants.DisabledText);
            giftCardPage.enableToggleButton();
            softAssert.assertEquals(giftCardPage.enableText, Constants.EnableText);
            if (isDisplayed(giftCardPage.fundingSourceDisableText, 1000)) {
                softAssert.assertEquals(giftCardPage.fundingSourceDisableText, Constants.sourceFundingDisabledText);
                giftCardPage.enableFundingSourceEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.fundingSourceEnabledText, Constants.getSourceFundingEnabledText);
            } else {
                giftCardPage.disableFundingSourceEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.fundingSourceDisableText, Constants.sourceFundingDisabledText);
                giftCardPage.enableFundingSourceEnableToggleBtn();
                softAssert.assertEquals(giftCardPage.fundingSourceEnabledText, Constants.sourceFundingDisabledText);
            }

        }
    }


    @Test(priority = 5, enabled = true, description = "TC_4_03 Verify that appropriate setting options appears on 'Gift Card Configuration' popup, after clicking on 'Confguration' link, on 'Gift Card Dashboard' page.")
    public void verifyCardAmountField() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(6);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.disabledToggleBtn, 1000)) {
            softAssert.assertEquals(giftCardPage.disabledText, Constants.DisabledText);
            giftCardPage.enableToggleButton();
            softAssert.assertEquals(giftCardPage.enableText, Constants.EnableText);
            softAssert.assertEquals(isDisplayed(giftCardPage.amountCardText, 1000), "true");
        } else {
            giftCardPage.disableToggleButton();
            softAssert.assertEquals(giftCardPage.disabledText, Constants.DisabledText);
            giftCardPage.enableToggleButton();
            softAssert.assertEquals(giftCardPage.enableText, Constants.EnableText);
            softAssert.assertEquals(isDisplayed(giftCardPage.amountCardText, 1000), "true");
        }


    }

    @Test(priority = 6, enabled = true, description = "Verify Maximum gift card amount allowed' field.")
    public void verifySendAmount() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        String name = giftCardPage.selectStore(3);
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.disabledToggleBtn, 10000)) {
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            softAssert.assertEquals(giftCardPage.storeName.toString(), name);

        } else {
            giftCardPage.disableToggleButton();
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            softAssert.assertEquals(giftCardPage.storeName.toString(), name);

        }


    }

    @Test(priority = 7, enabled = true, description = "Verify Maximum gift card amount allowed' field.")
    public void verifyNullAmountValidationMsg() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(1);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.disabledToggleBtn, 10000)) {
            giftCardPage.enableToggleButton();
            giftCardPage.clickSaveConfigurationBtn();
            softAssert.assertEquals(giftCardPage.getCardAmountValidationMeg(), Constants.ValidationMsg);

        } else {
            giftCardPage.disableToggleButton();
            giftCardPage.enableToggleButton();
            giftCardPage.clickSaveConfigurationBtn();
            softAssert.assertEquals(giftCardPage.getCardAmountValidationMeg(), Constants.ValidationMsg);

        }
    }

    @Test(priority = 8, enabled = true, description = "Verify that 'Managing, accepting and issuing Gift Cards is' and 'Providing Reference No. is'  settings appears as optional on 'Gift Cards Configuration' popup of 'Gift Cards Dashboard' page.")
    public void verifyOptionalSettings() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        String name = giftCardPage.selectStore(1);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.disabledToggleBtn, 10000)) {
            giftCardPage.enableToggleButton();
            if (!isDisplayed(giftCardPage.refernceNoDiableToggleBtn, 1000)) {
                giftCardPage.disableReferenceNoEnableToggleBtn();
            }
            if (!isDisplayed(giftCardPage.fundingSourceDisableText, 1000)) {
                giftCardPage.disableFundingSourceEnableToggleBtn();
            } else {
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                softAssert.assertEquals(giftCardPage.storeName.toString(), name);
            }


        } else {
            if (!isDisplayed(giftCardPage.refernceNoDiableToggleBtn, 1000)) {
                giftCardPage.disableReferenceNoEnableToggleBtn();
            }
            if (!isDisplayed(giftCardPage.fundingSourceDisableText, 1000)) {
                giftCardPage.disableFundingSourceEnableToggleBtn();
            } else {
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                softAssert.assertEquals(giftCardPage.storeName.toString(), name);
            }


        }
    }

    @Test(priority = 9, enabled = true, description = "Verify that 'Gift Cards Configuration' popup closes after clicking on 'Cross' icon, without any changes on 'Gift Cards Configuration' popup of 'Gift Cards Dashboard' page")
    public void verifyCrossButton() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        String name = giftCardPage.selectStore(1);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        giftCardPage.clickCrossIcon();
        softAssert.assertEquals(giftCardPage.storeName.toString(), name);

    }


    @Test(priority = 10, enabled = true, description = "Verify that 'Create gift card' popup opens up after clicking on 'Issue a new gift card' link, on 'Gift Cards Dashboard' page.")
    public void verifyIssueNewGiftCardBtn() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickIssueNewGiftCardBtn();
        softAssert.assertEquals(giftCardPage.getGiftCardHeader(), Constants.giftCardHeaderText);

    }

    @Test(priority = 11, enabled = true, description = "Verify that 'Custome' popup opens up after clicking on 'Customer' field, on 'Issue a new gift card' popup of 'Gift Cards Dashboard' page.")
    public void verifyCustomerPopUp() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickIssueNewGiftCardBtn();
        softAssert.assertEquals(giftCardPage.getGiftCardHeader(), Constants.giftCardHeaderText);
        giftCardPage.clickCustomerField();
        softAssert.assertEquals(giftCardPage.getCustomerTitle(), Constants.customerPopupTitle);


    }

    @Test(priority = 12, enabled = true, description = "Verify that appropriate validation message appears on entering invalid phone number in  'Customer phone/email' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerPhoneField() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickIssueNewGiftCardBtn();
        giftCardPage.clickCustomerField();
        softAssert.assertEquals(giftCardPage.getCustomerTitle(), Constants.customerPopupTitle);
        giftCardPage.setCustomerPhoneNo("1");
        giftCardPage.clickPhoneSearchBtn();
        softAssert.assertEquals(giftCardPage.getPhoneValidationMsgText(), Constants.ValidationMsg);
        softAssert.assertEquals(giftCardPage.getPhoneValidationToolTip(), Constants.phoneValidationToolTip);


    }

    @Test(priority = 13, enabled = true, description = "Verify that appropriate validation message appears on entering invalid phone number in  'Customer phone/email' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerEmailField() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickIssueNewGiftCardBtn();
        giftCardPage.clickCustomerField();
        softAssert.assertEquals(giftCardPage.getCustomerTitle(), Constants.customerPopupTitle);
        giftCardPage.setCustomerEmail("r");
        giftCardPage.clickEmailSearchBtn();
        softAssert.assertEquals(giftCardPage.geEmailValidationMsgText(), Constants.ValidationMsg);
        softAssert.assertEquals(giftCardPage.getEmailValidationToolTip(), Constants.emailValidationToolTip);


    }


    @Test(priority = 14, enabled = true, description = "Verify that appropriate validation message appears on entering invalid name in  'Customer Name' field, on 'Create gift card' popup.")
    public void verifyInvalidCustomerNameField() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickIssueNewGiftCardBtn();
        giftCardPage.clickCustomerField();
        giftCardPage.setCustomerName("ty");
        giftCardPage.clickCustomerNameSearchBtn();
        softAssert.assertEquals(giftCardPage.getNoSearchResultText(), Constants.noResultText);

    }

    @Test(priority = 15, enabled = true, description = "Verify that user is able to create gift card only after entering value in 'Initial amount' field, on 'Create gift card' popup.")
    public void verifyInitialAmountField() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(4);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickIssueNewGiftCardBtn();
        giftCardPage.clickCustomerField();
        giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
        giftCardPage.clickEmailSearchBtn();
        giftCardPage.setIntialAmount("100");
        giftCardPage.clickCreateBtn();

    }

    @Test(priority = 16, enabled = true, description = "Verify that value for 'Initial amount' field' cannot be greater than the value set in 'Maximum gift card amount allowed' field during Gift Cards Configuration")
    public void verifyInitialAmountLessThenMaxGiftAmount() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(5);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();

        if (isDisplayed(giftCardPage.enabledToggleBth, 10000)) {
            giftCardPage.disableToggleButton();
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
            giftCardPage.clickEmailSearchBtn();
            giftCardPage.setIntialAmount("10000");
            giftCardPage.clickCreateBtn();

        } else {
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
            giftCardPage.clickEmailSearchBtn();
            giftCardPage.setIntialAmount("10000");
            giftCardPage.clickCreateBtn();
        }


    }


    @Test(priority = 17, enabled = true, description = "Verify that value for 'Initial amount' field' cannot be greater than the value set in 'Maximum gift card amount allowed' field during Gift Cards Configuration")
    public void verifyRefrenceNoMandatory() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(5);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();

        if (isDisplayed(giftCardPage.enabledToggleBth, 10000)) {
            if (isDisplayed(giftCardPage.referenceNoEnableToggleBtn, 1000)) {
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                giftCardPage.clickIssueNewGiftCardBtn();
                giftCardPage.clickCustomerField();
                giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
                giftCardPage.clickEmailSearchBtn();
                giftCardPage.setIntialAmount("10000");
                giftCardPage.clickCreateBtn();
                softAssert.assertEquals(giftCardPage.getReferenceNoToolTip(), Constants.referenceNoTooltipMsg);
            } else {
                giftCardPage.enableReferenceNoEnableToggleBtn();
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                giftCardPage.clickIssueNewGiftCardBtn();
                giftCardPage.clickCustomerField();
                giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
                giftCardPage.clickEmailSearchBtn();
                giftCardPage.setIntialAmount("10000");
                giftCardPage.clickCreateBtn();
                softAssert.assertEquals(giftCardPage.getReferenceNoToolTip(), Constants.referenceNoTooltipMsg);

            }

        } else {
            giftCardPage.enableToggleButton();
            if (isDisplayed(giftCardPage.referenceNoEnableToggleBtn, 1000)) {
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                giftCardPage.clickIssueNewGiftCardBtn();
                giftCardPage.clickCustomerField();
                giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
                giftCardPage.clickEmailSearchBtn();
                giftCardPage.setIntialAmount("10000");
                giftCardPage.clickCreateBtn();
                softAssert.assertEquals(giftCardPage.getReferenceNoToolTip(), Constants.referenceNoTooltipMsg);
            } else {
                giftCardPage.enableReferenceNoEnableToggleBtn();
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                giftCardPage.clickIssueNewGiftCardBtn();
                giftCardPage.clickCustomerField();
                giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
                giftCardPage.clickEmailSearchBtn();
                giftCardPage.setIntialAmount("10000");
                softAssert.assertEquals(giftCardPage.getReferenceNoToolTip(), Constants.referenceNoTooltipMsg);
            }
        }


    }

    @Test(priority = 18, enabled = true, description = "Verify that 5 additional options appear after clicking on 'Advanced' link , on 'Create gift card' popup.")
    public void verifyAdditionalFields() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(5);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.enabledToggleBth, 10000)) {
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
            giftCardPage.clickEmailSearchBtn();
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            softAssert.assertEquals(giftCardPage.getCardNoText(), Constants.cardNoText);
        } else {
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
            giftCardPage.clickEmailSearchBtn();
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            softAssert.assertEquals(giftCardPage.getCardNoText(), Constants.cardNoText);
        }

    }


    @Test(priority = 19, enabled = true, description = "Verify that 5 additional options appear after clicking on 'Advanced' link , on 'Create gift card' popup.")
    public void verifyGiftCardCreationWithOptionalFields() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(5);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.enabledToggleBth, 10000)) {
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
            giftCardPage.clickEmailSearchBtn();
            giftCardPage.setIntialAmount("10000");
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            softAssert.assertEquals(giftCardPage.getCardNoText(), Constants.cardNoText);
            giftCardPage.clickCreateBtn();
        } else {
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerEmail("beanBliss@yopmail.com");
            giftCardPage.clickEmailSearchBtn();
            giftCardPage.setIntialAmount("10000");
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            softAssert.assertEquals(giftCardPage.getCardNoText(), Constants.cardNoText);
            giftCardPage.clickCreateBtn();
        }

    }


    @Test(priority = 20, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
    public void verifyCardNoRejectLessThan4NumericValues() {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(5);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.enabledToggleBth, 10000)) {
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerPhoneNo("6465551113");
            giftCardPage.clickPhoneSearchBtn();
            giftCardPage.setIntialAmount("10000");
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            giftCardPage.setCardNo("12");
            scrollToElement(giftCardPage.createButton);
            giftCardPage.clickCreateBtn();
            softAssert.assertEquals(giftCardPage.getCardNoValidationToolTip(), Constants.cardMinLendthMsg);
            softAssert.assertEquals(giftCardPage.getCardNoValidationMsg(), Constants.ValidationMsg);


        } else {
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerPhoneNo("6465551113");
            giftCardPage.clickPhoneSearchBtn();
            giftCardPage.setIntialAmount("10000");
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            giftCardPage.setCardNo("12");
            scrollToElement(giftCardPage.createButton);
            giftCardPage.clickCreateBtn();
            softAssert.assertEquals(giftCardPage.getCardNoValidationMsg(), Constants.cardMinLendthMsg);
            softAssert.assertEquals(giftCardPage.getCardNoValidationMsg(), Constants.ValidationMsg);

        }
    }


        @Test(priority = 21, enabled = true, description = "Verify that 'Card No' field accepts only numeric value, on' Create gift card' popup.")
        public void verifyCardNoAccepts18NumericValues () {
            SidePannelPage pannel = new SidePannelPage();
            Login();
            pannel.getMangeBusinessTab();
            pannel.getGiftCardsDashboardTab();
            giftCardPage.selectStore(5);
            giftCardPage.clickWhichStoreContinueBtn();
            giftCardPage.clickConfigurationButton();
            if (isDisplayed(giftCardPage.enabledToggleBth, 10000)) {
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                giftCardPage.clickIssueNewGiftCardBtn();
                giftCardPage.clickCustomerField();
                giftCardPage.setCustomerPhoneNo("6465551113");
                giftCardPage.clickPhoneSearchBtn();
                giftCardPage.setIntialAmount("10000");
                scrollToElement(giftCardPage.moreOptionsBtn);
                giftCardPage.clickMoreOptionsBtn();
                WebElement element = getWebElement(giftCardPage.CardNoField);
                String maxLength = element.getAttribute("maxlength");
                softAssert.assertEquals(maxLength,Constants.maxLength);



            } else {
                giftCardPage.enableToggleButton();
                giftCardPage.enterAmount();
                giftCardPage.clickSaveConfigurationBtn();
                giftCardPage.clickIssueNewGiftCardBtn();
                giftCardPage.clickCustomerField();
                giftCardPage.setCustomerPhoneNo("6465551113");
                giftCardPage.clickPhoneSearchBtn();
                giftCardPage.setIntialAmount("10000");
                scrollToElement(giftCardPage.moreOptionsBtn);
                giftCardPage.clickMoreOptionsBtn();
                WebElement element = getWebElement(giftCardPage.CardNoField);
                String maxLength = element.getAttribute("maxlength");
                softAssert.assertEquals(maxLength,Constants.maxLength);


            }

        }
    @Test(priority = 22, enabled = true, description = "Verify that 'Memo' field accepts value up to 500 characters, on' Create gift card' popup.")
    public void verifyMemoAccepts500Values () {
        SidePannelPage pannel = new SidePannelPage();
        Login();
        pannel.getMangeBusinessTab();
        pannel.getGiftCardsDashboardTab();
        giftCardPage.selectStore(5);
        giftCardPage.clickWhichStoreContinueBtn();
        giftCardPage.clickConfigurationButton();
        if (isDisplayed(giftCardPage.enabledToggleBth, 10000)) {
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerPhoneNo("6465551113");
            giftCardPage.clickPhoneSearchBtn();
            giftCardPage.setIntialAmount("10000");
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            WebElement element = getWebElement(giftCardPage.memoField);
            String maxLength = element.getAttribute("maxlength");
            softAssert.assertEquals(maxLength,Constants.memoMaxLength);



        } else {
            giftCardPage.enableToggleButton();
            giftCardPage.enterAmount();
            giftCardPage.clickSaveConfigurationBtn();
            giftCardPage.clickIssueNewGiftCardBtn();
            giftCardPage.clickCustomerField();
            giftCardPage.setCustomerPhoneNo("6465551113");
            giftCardPage.clickPhoneSearchBtn();
            giftCardPage.setIntialAmount("10000");
            scrollToElement(giftCardPage.moreOptionsBtn);
            giftCardPage.clickMoreOptionsBtn();
            WebElement element = getWebElement(giftCardPage.memoField);
            String maxLength = element.getAttribute("maxlength");
            softAssert.assertEquals(maxLength,Constants.memoMaxLength);


        }

    }
    @Test(priority = 83, enabled = true, description = "Verify that user gets directed to 'Gift Card For Sale' page, after clicking on 'Add' button, on 'Sell Dashboard' page.")
    public void verifyUserDirectsToGiftCardForSalePage() {

        giftCardPage.verifyUserDirection();
    }

    @Test(priority = 84, enabled = true, description = "Verify that appropriate validation message appears on entering value in 'Gift card amount' field' greater than the value set in 'Maximum gift card amount ")
    public void verifyValidationOnEnteringGreaterValue() {

        giftCardPage.verifyFaceValueAmountField();

    }

    @Test(priority = 85, enabled = true, description = "Verify that 'Face value' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyFaceValueFieldAcceptNumeric() {

        giftCardPage.verifyFaceValueFieldAccept();


    }

    @Test(priority = 86, enabled = true, description = "Verify that 'Sale price' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifySalePriceAcceptOnlyNumeric() {

        giftCardPage.verifySalePriceFieldAccept();


    }

    @Test(priority = 87, enabled = true, description = "Verify that user is allowed to enter maximum value upto 150% of the value entered in 'Maximum Gift Card amount' ")
    public void verifyUserAllowedToEnterMaximumValueInSalePrice(){

        giftCardPage.verifyUserAllowedToEnterMaximumValue();

    }

    @Test(priority = 88, enabled = true, description = "Verify that 'Face value', 'sale price', 'Reference No.' and 'Available quantity for sale' fields appears mandatory,on'Gift Card For Sale' page.")
    public void verifyFieldsAppearMandatoryOnPage() {

        giftCardPage.verifyFieldsAppearMandatory();

    }

    @Test(priority = 89, enabled = true, description = "Verify that appropriate validation message appears on leaving any mandaory field blank on 'Gift Card For Sale' page")
    public void verifyValidationOnLeavingBlankAnyFIeld(){

        giftCardPage.verifyValidationLeavingFieldsBlank();


    }

    @Test(priority = 90, enabled = true, description = "Verify that 'Funding Source' field appear as text field on 'Gift Card For Sale' page. ")
    public void verifyFundingSrcFieldAppearAsText(){


    }

    @Test(priority = 91, enabled = true, description = "Verify that 'Gift card amount' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyValidationOnEnteringG (){

    }

    @Test(priority = 92, enabled = true, description = "Verify that 'Gift card amount' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyValidati(){

    }

    @Test(priority = 93, enabled = true, description = "Verify that 'Gift card amount' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyVal() {

    }

    @Test(priority = 94, enabled = true, description = "Verify that 'Gift card amount' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyValidationOnEnteringGreaterValu() {

    }

    @Test(priority = 95, enabled = true, description = "Verify that 'Gift card amount' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyValidationOnEnteringGreaterVal() {

    }

    @Test(priority = 96, enabled = true, description = "Verify that 'Gift card amount' field accepts only numeric value, on 'Gift Card For Sale' popup. ")
    public void verifyValidationOnEnteringGreaterVa() {

    }






    }















