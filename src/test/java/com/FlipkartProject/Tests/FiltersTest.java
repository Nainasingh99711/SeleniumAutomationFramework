package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.FiltersPage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for Filters page
 * @author Naina
 *
 */

public class FiltersTest extends BaseTest{
	
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");
		
	@Test  (groups= {"Test"})
	public void Test_01_popularityFilter() {
		String testName = "Test_01_popularityFilter";
		extentTest = extent.startTest("PopularityFilter : Verifying that user is able to see the product according to popularity");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String productName = testData.get("productName");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		FiltersPage  filter = new FiltersPage (driver);
		log.info("PopularityFilter : PopularityFilter Test Started");
		filter.clickCross();
		filter.searchBar(productName);
		filter.searchIcon();
		filter.popularity();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Iphone 12- Buy Products Online at Best Price in India - All Categories | Flipkart.com", driver.getTitle());
		log.info("PopularityFilter Test is successful");
		extentTest.log(LogStatus.PASS,"user is able to see the product according to popularity");
		extent.endTest(extentTest);
	}

	@Test  (groups= {"Test"})
	public void Test_02_priceLowToHigh() {
		String testName = " Test_02_priceLowToHigh";
		extentTest = extent.startTest("PriceLowToHigh : Verifying that user is able to see the product according to Low to High price");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String productName = testData.get("productName");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		FiltersPage  filter = new FiltersPage (driver);
		log.info("PriceLowToHigh : PriceLowToHigh Test Started");
		filter.clickCross();
		filter.searchBar(productName);
		filter.searchIcon();
		filter.priceLow();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Iphone 12- Buy Products Online at Best Price in India - All Categories | Flipkart.com", driver.getTitle());
		log.info("PriceLowToHigh Test is successful");
		extentTest.log(LogStatus.PASS,"user is able to see the product according to Low to High price");
		extent.endTest(extentTest);
	}


	@Test (groups= {"Test"})
	public void Test_03_priceHighToLow() {
		String testName = "Test_03_priceHighToLow";
		extentTest = extent.startTest("PriceHighToLow : Verifying that user is able to see the product according to High to Low price");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String productName = testData.get("productName");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		FiltersPage  filter = new FiltersPage (driver);
		log.info("PriceHighToLow : PriceHighToLow Test Started");
		filter.clickCross();
		filter.searchBar(productName);
		filter.searchIcon();
		filter.priceHigh();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Iphone 12- Buy Products Online at Best Price in India - All Categories | Flipkart.com", driver.getTitle());
		log.info("PriceHighToLow Test is successful");
		extentTest.log(LogStatus.PASS,"user is able to see the product according to High to Low price");
		extent.endTest(extentTest);
	}

}
