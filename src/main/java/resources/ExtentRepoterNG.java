package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoterNG {
	
	static ExtentReports extent;
	
	
	public static ExtentReports getReportObject()
	{
		//ExtentRepots, ExtentSparkRepoter
		String path=System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Asis");
		return extent;
	}

}
