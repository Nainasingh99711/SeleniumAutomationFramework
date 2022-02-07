package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.PageNavigation;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

public class PageNavigationTest  extends BaseTest{

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");

	@Test  (groups= {"Test"})
	public void Test_01_navigation() throws InterruptedException  {
		String testName = "Test_01_navigation";
		extentTest = extent.startTest("Navigation : Verifying that user is able to navigate to another page");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String productName = testData.get("productName");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);

		PageNavigation navigate = new PageNavigation(driver);
		log.info("Navigation : Navigation Test Started");
		navigate.clickCross();
		navigate.searchBar(productName);
		navigate.searchIcon();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		navigate.pageNavigation();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Iphone 12- Buy Products Online at Best Price in India - All Categories | Flipkart.com", driver.getTitle());
		log.info("Navigation Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to navigate to page 2");
		extent.endTest(extentTest);
	}
}
