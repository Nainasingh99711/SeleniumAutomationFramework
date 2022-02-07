package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.MyOrdersPage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for My orders page
 * @author Naina
 *
 */

public class MyOrdersTest extends BaseTest{

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("myOrderSheetName");

	@Test  (groups= {"Test"})
	public void Test_01_myOrders()  {
		String testName = "Test_01_myOrders";
		extentTest = extent.startTest("MyOrders : Verifying that user is able to see the order history");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String userName = testData.get("EmailID");
		String password = testData.get("Passoword");
		String OrderName = testData.get("OrderName");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		MyOrdersPage page = new MyOrdersPage(driver);
		log.info("MyOrders : MyOrders Test is Started");
		page.phoneNumber(userName);
		page.enterPassword(password);
		page.loginButton();
		page.clickOrders();
		page.searchYourOrder(OrderName);
		page.searchOrder();
		page.yourOrder();
		page.clickDelivered();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Flipkart.com: Order Information", driver.getTitle());
		log.info("MyOrders Test is successful");
		extentTest.log(LogStatus.PASS,"user is able to see the order history");
		extent.endTest(extentTest);
	}

	@Test  (groups= {"Test"})
	public void Test_02_OrderIn2020() {
		String testName = "Test_02_OrderIn2020";
		extentTest = extent.startTest("OrderIn2020 : Verifying that user is able to see the placed order history according to year");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String userName = testData.get("EmailID");
		String password = testData.get("Passoword");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		MyOrdersPage page = new MyOrdersPage(driver);
		log.info("OrderIn2020 : OrderIn2020 Test is Started");
		page.phoneNumber(userName);
		page.enterPassword(password);
		page.loginButton();
		page.clickOrders();
		page.click2020();
		page.click2020FirstOrder();
		page.clickDeliveredOrder();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Flipkart.com: Order Information", driver.getTitle());
		log.info("OrderIn2020 Test is successful");
		extentTest.log(LogStatus.PASS,"user is able to see the placed order history according to year");
		extent.endTest(extentTest);
	}

	@Test  (groups= {"Test"})
	public void Test_03_ReviewOrder() {
		String testName = "Test_03_ReviewOrder";
		extentTest = extent.startTest("ReviewOrder : Verifying that user is able to review and rate the product");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String userName = testData.get("EmailID");
		String password = testData.get("Passoword");
		String review = testData.get("review");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		MyOrdersPage page = new MyOrdersPage(driver);
		log.info("ReviewOrder : ReviewOrder test is started");
		page.phoneNumber(userName);
		page.enterPassword(password);
		page.loginButton();
		page.clickOrders();
		page.clickRecentOrder();
		page.clickRateReview();
		page.addReview(review);
		page.clickSubmitReview();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Review Purchases - Buy Products Online at Great Price and Check out daily Offers at Flipkart.com", driver.getTitle());
		log.info("ReviewOrder test is successful");
		extentTest.log(LogStatus.PASS,"user is able to review and rate the product");
		extent.endTest(extentTest);
	}

}
