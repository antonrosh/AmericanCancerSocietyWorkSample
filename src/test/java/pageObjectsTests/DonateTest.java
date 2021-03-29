package pageObjectsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.donatePage.DonatePage;
import pageObjects.donatePage.DonatePageLocators;

public class DonateTest extends BaseTest {
    @Test
    public void donatePageTest_donatePageAndTextExist() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        Assert.assertTrue(driver.getTitle().contains("Donate Today | The American Cancer Society"));
        Assert.assertEquals(donatePage.getTextFromPage(DonatePageLocators.textOfTitle), "Give the gift of cancer research and patient support.");
    }

    @Test
    public void donatePageTest_donateValuesExist() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        Assert.assertEquals(donatePage.oneTimeValues(DonatePageLocators.oneTimeValue50), "$50");
        Assert.assertEquals(donatePage.oneTimeValues(DonatePageLocators.oneTimeValue75), "$75");
        Assert.assertEquals(donatePage.oneTimeValues(DonatePageLocators.oneTimeValue100), "$100");
        Assert.assertEquals(donatePage.oneTimeValues(DonatePageLocators.oneTimeValue250), "$250");
        Assert.assertEquals(donatePage.monthlyValues(DonatePageLocators.monthlyValue21), "$21");
        Assert.assertEquals(donatePage.monthlyValues(DonatePageLocators.monthlyValue50), "$50");
        Assert.assertEquals(donatePage.monthlyValues(DonatePageLocators.monthlyValue100), "$100");
        Assert.assertEquals(donatePage.monthlyValues(DonatePageLocators.monthlyValue250), "$250");
    }

    @Test
    public void donatePageTest_errorNotificationsExistForOneTime() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        donatePage.getErrorMessageForOneTime(DonatePageLocators.oneTimeValue50);
        Assert.assertTrue(donatePage.isErrorDisplayed(DonatePageLocators.errorCreditCartRequired));
        Assert.assertTrue(donatePage.isErrorDisplayed(DonatePageLocators.errorExpirationDateRequired));
        Assert.assertTrue(donatePage.isErrorDisplayed(DonatePageLocators.errorCvvRequired));
    }

    @Test
    public void donatePageTest_errorNotificationsExistForMonthly() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        donatePage.getErrorMessageForMonthly(DonatePageLocators.monthlyValue21);
        Assert.assertTrue(donatePage.isErrorDisplayed(DonatePageLocators.errorCreditCartRequired));
        Assert.assertTrue(donatePage.isErrorDisplayed(DonatePageLocators.errorExpirationDateRequired));
        Assert.assertTrue(donatePage.isErrorDisplayed(DonatePageLocators.errorCvvRequired));
    }

    @Test
    public void donatePageTest_feeAmountForOneTime() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        donatePage.calculateFeeAmountForOneTime(DonatePageLocators.oneTimeValue50);
        Assert.assertEquals(donatePage.convertFeeAmount(),
                donatePage.calculateFeeAmountForOneTime(DonatePageLocators.oneTimeValue50));
    }

    @Test
    public void donatePageTest_feeAmountForMonthly() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        donatePage.calculateFeeAmountMonthly(DonatePageLocators.monthlyValue21);
        Assert.assertEquals(donatePage.convertFeeAmount(),
                donatePage.calculateFeeAmountMonthly(DonatePageLocators.monthlyValue21));
    }

    @Test
    public void donatePageTest_feeAmountForOneTimeOther() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        donatePage.clickOneTimeButton();
        donatePage.oneTimeOtherValue("50");
        Assert.assertEquals(donatePage.convertFeeAmount(), donatePage.calculateFeeAmountOneTimeOther("50"));
    }

    @Test
    public void donatePageTest_feeAmountForMonthlyOther() {
        DonatePage donatePage = new DonatePage(driver);
        donatePage.openPage();
        donatePage.clickMonthlyButton();
        donatePage.monthlyOtherValue("50");
        Assert.assertEquals(donatePage.convertFeeAmount(), donatePage.calculateFeeAmountMonthlyOther("50"));
    }
}
