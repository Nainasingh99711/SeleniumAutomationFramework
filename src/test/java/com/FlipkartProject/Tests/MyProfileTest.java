package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.MyProfilePage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for My profile page
 * @author Naina
 *
 */

public class MyProfileTest extends BaseTest {

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("myProfileSheetName");

	@Test  (groups= {"Test"})
	public void Test_01_myAddress() {
		String testName = "Test_01_myAddress";
		extentTest = extent.startTest("MyAddress : Verifying that user is able to add new address for product delivery");
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String userName = testData.get("EmailID");
		String password = testData.get("Passoword");
		String name = testData.get("name");
		String phoneNumber = testData.get("phoneNumber");
		String pincode = testData.get("pincode");
		String locality = testData.get("locality");
		String address = testData.get("address");
		String town = testData.get("town");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);

		MyProfilePage list = new MyProfilePage(driver);
		log.info("MyAddress : MyAddress Test is Started");
		list.phoneNumber(userName);
		list.enterPassword(password);
		list.loginButton();
		list.clickMyProfile();
		list.manageAddress();
		list.AddNewAddress();
		list.enterName(name);
		list.enterNumber(phoneNumber);
		list.enterPincode(pincode);
		list.enterLocality(locality);
		list.enterYourAddress(address);
		list.enterYourTown(town);
		list.clickState();
		list.chooseYourState();
		list.chooseHome();
		list.clickSave();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Manage Addresses", driver.getTitle());
		log.info("MyAddress Test is successful");
		extentTest.log(LogStatus.PASS,"user is able to add new address for product delivery");
		extent.endTest(extentTest);
	}

	@Test  (groups= {"Test"})
	public void Test_02_deleteSavedAddress() {
		String testName = "Test_02_deleteSavedAddress";
		extentTest = extent.startTest("DeleteSavedAddress : Verifying that user is able to delete the saved address");
		// Fetching all test data from excel file
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String userName = testData.get("EmailID");
		String password = testData.get("Passoword");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);

		MyProfilePage list = new MyProfilePage(driver);
		log.info("DeleteSavedAddress : DeleteSavedAddress Test is Started");
		list.phoneNumber(userName);
		list.enterPassword(password);
		list.loginButton();
		list.clickMyProfile();
		list.manageAddress();
		list.deleteSavedAddress();
		list.delete();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Manage Addresses", driver.getTitle());
		log.info("DeleteSavedAddress Test is successfull");
		extentTest.log(LogStatus.PASS,"user is able to delete the saved address");
		extent.endTest(extentTest);
	}
}