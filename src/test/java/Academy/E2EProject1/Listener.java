package Academy.E2EProject1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentRepoterNG;

public class Listener extends Base implements ITestListener {
   
	 ExtentTest test;
	ExtentReports extent= ExtentRepoterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) 
	{
		  test=extent.createTest(result.getMethod().getMethodName());
		  extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) 
	{
   extentTest.get().log(Status.PASS, "Test  Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		  extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShot(testMethodName, driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) 
	{
        extent.flush();
	}

}
