package pageObjects.donatePage;

import org.openqa.selenium.By;

public class DonatePageLocators {
    public static final By textOfTitle = By.xpath("//strong[contains(text(),'Give the gift')]");
    public static final By oneTimeButton = By.xpath("//*[@id='frequency_onetime']");
    public static final By oneTimeValue50 = By.xpath("(//div[@data-paymentamount='50'])[1]");
    public static final By oneTimeValue75 = By.xpath("//*[@data-paymentamount='75']");
    public static final By oneTimeValue100 = By.xpath("(//*[@data-paymentamount='100'])[1]");
    public static final By oneTimeValue250 = By.xpath("(//*[@data-paymentamount='250'])[1]");
    public static final By monthlyButton = By.xpath("//*[@id='frequency_monthly']");
    public static final By monthlyValue21 = By.xpath("//*[@data-paymentamount='21']");
    public static final By monthlyValue50 = By.xpath("(//div[@data-paymentamount='50'])[2]");
    public static final By monthlyValue100 = By.xpath("(//*[@data-paymentamount='100'])[2]");
    public static final By monthlyValue250 = By.xpath("(//*[@data-paymentamount='250'])[2]");
    public static final By continueButtonStepPayment = By.xpath("//button[@data-steps='step-payment']");
    public static final By continueButtonStepContact = By.xpath("//button[@data-steps='step-contact,call-to-action']");
    public static final By errorCreditCartRequired = By.xpath("(//*[@class='error'])[1]");
    public static final By errorExpirationDateRequired = By.xpath("(//*[@class='error'])[2]");
    public static final By errorCvvRequired = By.xpath("(//*[@class='error'])[3]");
    public static final By paymentCreditCardForm = By.xpath("//*[@id='payment_credit-card-form']");
    public static final By feeAmount = By.xpath("//*[@id='fee_amount']");
    public static final By oneTimeOtherValueField = By.xpath("//*[@name='onetime_other']");
    public static final By monthlyOtherValueField = By.xpath("//*[@name='monthly_other']");

}
