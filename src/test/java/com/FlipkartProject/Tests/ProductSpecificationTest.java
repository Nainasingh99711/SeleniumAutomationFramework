package com.FlipkartProject.Tests;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.ProductSpecificationPAge;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for product specification page
 * @author Naina
 *
 */

public class ProductSpecificationTest extends BaseTest {

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");

	@Test  (groups= {"Test"})
	public void Test_01_changeColorAndStorage()  {
		String testName = "Test_01_changeColorAndStorage";
		extentTest = extent.startTest("ChangeColorAndStorage : Verifying that user is able to change the color and storage of phone");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		ProductSpecificationPAge page = new ProductSpecificationPAge(driver);
		log.info("ChangeColorAndStorage : ChangeColorAndStorage Test Started");
		productPage();
		page.changeColor();
		page.changeStorage();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Buy Apple iPhone 12 ( 128 GB Storage ) Online at Best Price On Flipkart.com", driver.getTitle());
		log.info("ChangeColorAndStorage Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to change the color and storage of phone");
		extent.endTest(extentTest);
	}

	@Test  (groups= {"Test"})
	public void Test_02_changePincode()  {
		String testName = "Test_02_changePincode";
		extentTest = extent.startTest("ChangePincode : Verifying that user is able to change the delivery pincode");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String pincode = testData.get("pincode");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		ProductSpecificationPAge page = new ProductSpecificationPAge(driver);
		log.info("ChangePincode : ChangePincode Test Started");
		productPage();
		page.clickAddress(pincode);
		page.clickCheck();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Assert.assertEquals("Buy Apple iPhone 12 ( 64 GB Storage ) Online at Best Price On Flipkart.com", driver.getTitle());
		log.info("ChangePincode Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to change the delivery pincode");
		extent.endTest(extentTest);
	}

	@Test  (groups= {"Test"})
	public void Test_03_Reviews()  {
		String testName = "Test_03_Reviews";
		extentTest = extent.startTest("Reviews : Verifying that user is able to see the reviews");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);
	
		ProductSpecificationPAge page = new ProductSpecificationPAge(driver);
		log.info("Reviews : Reviews Test Started");
		productPage();
		page.clickReviews();
		page.clickCameraReview();
		Assert.assertEquals("Buy Apple iPhone 12 ( 64 GB Storage ) Online at Best Price On Flipkart.com", driver.getTitle());
		log.info("Reviews Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to see the reviews");
		extent.endTest(extentTest);
	}

}
