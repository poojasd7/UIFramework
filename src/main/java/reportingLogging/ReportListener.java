package reportingLogging;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import reportingLogging.ExtentReporter.*;

public class ReportListener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started. "+result.getStartMillis());
		System.out.println("on test start");
		ExtentReporter.test = ExtentReporter.reports.startTest(result.getMethod().getMethodName());
		ExtentReporter.test.log(LogStatus.INFO, result.getMethod().getMethodName() + " test is started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success. "+result.getEndMillis());
		ExtentReporter.test.log(LogStatus.PASS, result.getMethod().getMethodName() + " test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed. "+result.getTestName());
		ExtentReporter.test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		//implement screenshot logic here
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped. "+result.getTestName());
		ExtentReporter.test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {		
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * System.out.println("Context Name = "+context.getName());
		 * ExtentReporter.startTests(context);
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		ExtentReporter.reports.endTest(ExtentReporter.test);
		ExtentReporter.reports.flush();

		
	}


}
