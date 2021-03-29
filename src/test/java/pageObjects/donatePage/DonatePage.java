package pageObjects.donatePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

import java.text.DecimalFormat;

public class DonatePage extends BasePage {
    Logger logger = LogManager.getLogger(pageObjects.donatePage.DonatePage.class);

    public DonatePage(WebDriver driver) {
        super(driver);
        logger.debug("Donate page object created");
    }

    // Constructors
    public String getTextFromPage(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();
    }

    private WebElement getOneTimeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DonatePageLocators.oneTimeButton));
        return driver.findElement(DonatePageLocators.oneTimeButton);
    }

    private WebElement getMonthlyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(DonatePageLocators.monthlyButton));
        return driver.findElement(DonatePageLocators.monthlyButton);
    }

    private WebElement getContinueButtonStepPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(DonatePageLocators.continueButtonStepPayment));
        return driver.findElement(DonatePageLocators.continueButtonStepPayment);
    }

    private WebElement getContinueButtonStepContact() {
        wait.until(ExpectedConditions.elementToBeClickable(DonatePageLocators.continueButtonStepContact));
        return driver.findElement(DonatePageLocators.continueButtonStepContact);
    }

    private WebElement getPaymentCreditCardForm() {
        wait.until(ExpectedConditions.elementToBeClickable(DonatePageLocators.paymentCreditCardForm));
        return driver.findElement(DonatePageLocators.paymentCreditCardForm);
    }

    private WebElement getFeeAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DonatePageLocators.feeAmount));
        return driver.findElement(DonatePageLocators.feeAmount);
    }

    private WebElement getOneTimeOtherValueField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DonatePageLocators.oneTimeOtherValueField));
        return driver.findElement(DonatePageLocators.oneTimeOtherValueField);
    }

    private WebElement getMonthlyOtherValueField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DonatePageLocators.monthlyOtherValueField));
        return driver.findElement(DonatePageLocators.monthlyOtherValueField);
    }

    // Methods
    public void openPage() {
        driver.get("https://qa.donate.cancer.org/");
    }

    public void clickOneTimeButton() {
        getOneTimeButton().click();
    }

    public void clickMonthlyButton() {
        getMonthlyButton().click();
    }

    public String oneTimeValues(By by) {
        getOneTimeButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
        return driver.findElement(by).getText();
    }

    public String monthlyValues(By by) {
        getMonthlyButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
        return driver.findElement(by).getText();
    }

    public String oneTimeOtherValue(String value) {
        getOneTimeOtherValueField().click();
        getOneTimeOtherValueField().sendKeys(value);
        return "$" + value;
    }

    public String monthlyOtherValue(String value) {
        getMonthlyOtherValueField().click();
        getMonthlyOtherValueField().sendKeys(value);
        return "$" + value;
    }

    public void getErrorMessageForOneTime(By value) {
        oneTimeValues(value);
        getContinueButtonStepPayment().click();
        getContinueButtonStepContact().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DonatePageLocators.paymentCreditCardForm));
    }

    public void getErrorMessageForMonthly(By value) {
        monthlyValues(value);
        getContinueButtonStepPayment().click();
        getContinueButtonStepContact().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DonatePageLocators.paymentCreditCardForm));
    }

    public boolean isErrorDisplayed(By error) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).isDisplayed();
        } catch (TimeoutException ignored) {
            return false;
        }
    }

    public String convertFeeAmount() {
        return getFeeAmount().getText();
    }

    public String calculateFeeAmountForOneTime(By value) {
        String parseValue = oneTimeValues(value).replace("$", "");
        DecimalFormat df = new DecimalFormat("0.00");
        Double feeAmount = Double.parseDouble(parseValue);
        return "$" + df.format(feeAmount = feeAmount * 0.055);
    }

    public String calculateFeeAmountMonthly(By value) {
        String parseValue = monthlyValues(value).replace("$", "");
        DecimalFormat df = new DecimalFormat("0.00");
        Double feeAmount = Double.parseDouble(parseValue);
        return "$" + df.format(feeAmount = feeAmount * 0.055);
    }

    public String calculateFeeAmountOneTimeOther(String value) {
        String parseValue = value.replace("$", "");
        DecimalFormat df = new DecimalFormat("0.00");
        Double feeAmount = Double.parseDouble(parseValue);
        return "$" + df.format(feeAmount = feeAmount * 0.055);
    }

    public String calculateFeeAmountMonthlyOther(String value) {
        String parseValue = value.replace("$", "");
        DecimalFormat df = new DecimalFormat("0.00");
        Double feeAmount = Double.parseDouble(parseValue);
        return "$" + df.format(feeAmount = feeAmount * 0.055);
    }

}
