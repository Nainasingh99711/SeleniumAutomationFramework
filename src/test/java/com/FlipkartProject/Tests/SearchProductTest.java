package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.SearchProductPage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for search product page
 * @author Naina
 *
 */

public class SearchProductTest extends BaseTest{
	
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");
	
	@Test  (groups= {"Test"})
	public void Test_01_searchAndAddToWishlist()  {
		String testName = "Test_01_searchAndAddToWishlist";
		extentTest = extent.startTest("SearchAndAddToWishlist : Verifying that user is able to search the product & able to add it to the wishlist");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String userName = testData.get("EmailID");
		String password = testData.get("Passoword");
		String productName = testData.get("productName");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		SearchProductPage search = new SearchProductPage(driver);
		log.info("SearchAndAddToWishlist : searchAndAddToWishlist Test is started");
		search.phoneNumber(userName);
		search.enterPassword(password);
		search.loginButton();
		search.enterProductName(productName);
		search.searchIcon();
		search.addToWishlist();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Iphone 12- Buy Products Online at Best Price in India - All Categories | Flipkart.com", driver.getTitle());
		log.info("searchAndAddToWishlist Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to search the product & able to add it to the wishlist");
		extent.endTest(extentTest);
	}

	@Test  (groups= {"Test"})
	public void Test_02_deleteFromWishlist()  {
		String testName = " Test_02_deleteFromWishlist";
		extentTest = extent.startTest("DeleteFromWishlist : Verifying that user is able to delete the product from wishlist test is started");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String userName = testData.get("EmailID");
		String password = testData.get("Passoword");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		SearchProductPage search = new SearchProductPage(driver);
		log.info("DeleteFromWishlist :  DeleteFromWishlist Test is started");
		search.phoneNumber(userName);
		search.enterPassword(password);
		search.loginButton();
		search.profile();
		search.clickOnWishlist();
		search.clickdelete();
		search.clickRemove();
		Assert.assertEquals("My Wishlist", driver.getTitle());
		log.info("DeleteFromWishlist test is successful");
		extentTest.log(LogStatus.PASS,"User is able to delete the product from wishlist test is started");
		extent.endTest(extentTest);
	}
}
