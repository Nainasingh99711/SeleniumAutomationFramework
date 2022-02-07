package com.FlipkartProject.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.FlipkartProject.utils.ExcelFileIO;
import com.FlipkartProject.utils.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BaseTest {
	static WebDriver driver;
	static File file = new File(".\\Resources\\config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();
	public static Logger log = (Logger) LogManager.getLogger(BaseTest.class);
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	// Excel File Test Data Reader
	public static ExcelFileIO reader = null;

	static {
		try {
			fis = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}


		// Exception Handling for Excel File
		try {

			reader = new ExcelFileIO(prop.getProperty("testDataFileLocation"));
		}
		catch(Exception e) {

			log.error(e.getMessage());
		}


	}

	//--Extent Report Generation
	@BeforeSuite (groups= {"Login","Test","Cart","Navigation"})
	public void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
	}
	
	//--Extent Report Flush
	@AfterSuite (groups= {"Login","Test","Cart","Navigation"})
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	//--ScreenShot
	@AfterMethod (groups= {"Login","Test","Cart","Navigation"})
	public void attachScreenshot(ITestResult result) {

		if(result.getStatus()==ITestResult.FAILURE) {

			String screenshotPath = Screenshot.captureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extent.endTest(extentTest);
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {

			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}

	}

	//--Driver initialisation
	@BeforeMethod (groups= {"Login","Test","Cart","Navigation"})
	public static void intializeWebdriver() {
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome")){
			System.setProperty(prop.getProperty("chromeDriverProperty"),prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		}else if(prop.getProperty("Browser").equalsIgnoreCase("ChromeHeadless")){
			System.setProperty(prop.getProperty("chromeDriverProperty"),prop.getProperty("chromeDriverPath"));
			//---chrome headless driver code
			ChromeOptions options=new ChromeOptions();
			options.setHeadless(true);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		}else if(prop.getProperty("Browser").equalsIgnoreCase("edge")){
			System.setProperty(prop.getProperty("edgeDriverProperty"),prop.getProperty("edgeDriverPath"));
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		}else if(prop.getProperty("Browser").equalsIgnoreCase("Firefox")){
			System.setProperty(prop.getProperty("FirefoxDriverProperty"),prop.getProperty("FirefoxDriverPath"));
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		else if(prop.getProperty("Browser").equalsIgnoreCase("FirefoxHeadless")){
			System.setProperty(prop.getProperty("FirefoxDriverProperty"),prop.getProperty("FirefoxDriverPath"));
			FirefoxOptions options=new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
	}
	
	@BeforeMethod  (groups={"Login","Test","Cart","Navigation"})
	public static void openUrl() {
		driver.get(prop.getProperty("url"));

	}
	
	@AfterMethod  (groups= {"Login","Test","Cart","Navigation"})
	public static void closeBrowser() {
		driver.close();
	}

	public static void productPage()
	{
		driver.get(prop.getProperty("productUrl"));
	}

	public static void personalInfoPage()
	{
		driver.get(prop.getProperty("personalInfoUrl"));
	}
}
