package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.GroceryPage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for grocery page
 * @author Naina
 *
 */

public class GroceryTest extends BaseTest{

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");

	@Test  (groups= {"Test"})
	public void Test_01_groceryPageVerification()  {
		String testName = " Test_01_groceryPageVerification";
		extentTest = extent.startTest("GroceryPageVerification : Verifying that user is able to proceed to the grocery section");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);

		GroceryPage grocery = new GroceryPage(driver);
		log.info("GroceryPageVerification : GroceryPageVerification Test is Started");
		grocery.clickCross();
		grocery.clickGrocerySection();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", driver.getTitle());
		log.info("GroceryPageVerification Test is successful");
		extentTest.log(LogStatus.PASS,"user is able to proceed to the grocery section");
		extent.endTest(extentTest);
	}


	@Test  (groups= {"Test"})
	public void Test_02_groceryProductSearch()  {
		String testName = "Test_02_groceryProductSearch";
		extentTest = extent.startTest("GroceryProductSearch : Verifying that user is able to search the product in the grocery section");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String productName = testData.get("productName");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);

		GroceryPage grocery = new GroceryPage(driver);
		log.info("GroceryProductSearch : GroceryProductSearch test started");
		grocery.clickCross();
		grocery.clickGrocerySection();
		grocery.enterProduct(productName);
		grocery.clickSearchIcon();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", driver.getTitle());
		log.info("GroceryProductSearch test is successful");
		extentTest.log(LogStatus.PASS,"user is able to search the product in the grocery section");
		extent.endTest(extentTest);
	}


}
