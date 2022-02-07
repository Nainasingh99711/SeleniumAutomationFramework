package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.AddToCartPage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for Add to cart page
 * @author Naina
 *
 */

public class AddToCartTest extends BaseTest {

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");

	@Test (groups= {"Test"})
	public void Test_01_addTOCart()  {
		String testName = "Test_01_addTOCart";
		extentTest = extent.startTest("AddTOCart : Verify that user is able to add product to the cart");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		AddToCartPage cart = new AddToCartPage(driver);
		productPage();
		log.info("AddTOCart : AddTOCart Test Started");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		cart.addToCart();	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Buy Apple iPhone 12 ( 64 GB Storage ) Online at Best Price On Flipkart.com", driver.getTitle());
		log.info("AddTOCart Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to add the product to the cart");
		extent.endTest(extentTest);
	}
}
