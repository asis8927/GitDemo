package resources;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
 public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop=new Properties();
				FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	String browserName=	prop.getProperty("browser");
	System.out.println(browserName);
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Jar\\chrome\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		if(browserName.contains("headless"))
		{
		options.addArguments("headless");
		}
		driver=new ChromeDriver(options);
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "G:\\Selenium_Jar\\Drivers\\geckodriver.exe");
	 driver =new FirefoxDriver();
	}
	else if(browserName.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", "G:\\Selenium_Jar\\Drivers\\IEDriverServer.exe");
	driver=new InternetExplorerDriver();
	}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;
}
	public String getScreenShot(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
	FileUtils.copyFile(source, new File(destinationfile));
	return destinationfile;
	}
	

	
	
}