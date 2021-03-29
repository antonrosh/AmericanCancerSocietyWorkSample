package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    Logger logger = LogManager.getLogger(Listeners.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        logger.trace(iTestResult.getInstanceName() + " started XX");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        logger.trace("Test " + iTestResult.getInstanceName() + " successfully finished");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.error(iTestResult.getInstanceName() + " failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
