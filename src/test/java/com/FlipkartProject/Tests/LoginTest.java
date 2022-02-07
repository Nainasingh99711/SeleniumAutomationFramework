package com.FlipkartProject.Tests;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for Login page
 * @author Naina
 *
 */

public class LoginTest extends BaseTest{
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("homePageSheetName");
	
	@Test  (groups= {"Test"})
	public void Test_01_invalidLogin()  {
		String testName = "Test_01_invalidLogin";
		extentTest = extent.startTest("InvalidLogin : Verifying that user is not able to login with invalid credentials");
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String user = testData.get("EmailID");
		String password = testData.get("Passoword");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		LoginPage login = new LoginPage(driver);
		log.info("InvalidLogin : Invalid Login Test Started");
		login.phoneNumber(user);
		login.enterPassword(password);
		login.loginButton();
		Assert.assertEquals("Your username or password is incorrect", driver.getTitle());
		log.info("Invalid Login Test is successful");
		extentTest.log(LogStatus.FAIL,"User is not able to login with invalid credentials");
		extent.endTest(extentTest);
	} 

	@Test  (groups= {"Test"})
	public void Test_02_validLogin()  {
		String testName = "Test_02_validLogin";
		extentTest = extent.startTest("ValidLogin : Verifying that user is able to login with valid credentials");
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String user = testData.get("EmailID");
		String password = testData.get("Passoword");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		LoginPage login = new LoginPage(driver);
		log.info("ValidLogin : Valid Login Test Started");
		login.phoneNumber(user);
		login.enterPassword(password);
		login.loginButton();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", driver.getTitle());
		log.info("Valid Login Test is successful");
		extentTest.log(LogStatus.PASS,"Login done successfully");
		extent.endTest(extentTest);
	}
	

	@Test  (groups= {"Test"})
	public void Test_03_logout() {
		String testName = "Test_03_logout";
		extentTest = extent.startTest("Logout : Verifying that user is able to logout after successfull login");
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String user = testData.get("EmailID");
		String password = testData.get("Passoword");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		LoginPage login = new LoginPage(driver);
		log.info("Logout : Logout Test Started");
		login.phoneNumber(user);
		login.enterPassword(password);
		login.loginButton();
		login.clickLogout();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", driver.getTitle());
		log.info("Logout Test is successful");
		extentTest.log(LogStatus.PASS,"Logout done successfully");
		extent.endTest(extentTest);
	}
	
}