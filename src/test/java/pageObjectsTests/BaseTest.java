package pageObjectsTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    protected WebDriver driver;
    protected String browser;

    @Parameters({"browser"})
    @BeforeMethod
    public void startUp(String browserName) throws NoSuchMethodException {
        BrowserType browser;
        switch (browserName) {
            case "CHROME":
                browser = BrowserType.CHROME;
                break;
            case "FIREFOX":
                browser = BrowserType.FIREFOX;
                break;
            case "EDGE":
                browser = BrowserType.EDGE;
                break;
            case "OPERA":
                browser = BrowserType.OPERA;
                break;
            default:
                throw new NoSuchMethodException("Browser not defined");
        }
        this.browser = browserName;
        driver = BrowserFabric.getDriver(browser);
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (iTestResult.getStatus() == iTestResult.FAILURE) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("=MM-dd-yyyy--HH-mm-ss");
            String filename = iTestResult.getName() + formatter.format(date);
            Screenshot.get(driver, filename);
        }
        driver.quit();
    }
}
