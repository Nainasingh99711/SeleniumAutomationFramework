package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.ElectronicsPage;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for Electronics page
 * @author Naina
 *
 */
public class ElectronicsTest  extends BaseTest {
	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");

	@Test  (groups= {"Test"})
	public void Test_01_Electronics()  {
		String testName = "Test_01_Electronics";
		extentTest = extent.startTest("Electronics : Verifying the electronics section");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);

		ElectronicsPage page = new ElectronicsPage(driver);
		log.info("Electronics : Electronics Test is Started");
		page.clickCross();
		page.selectElectronics();
		page.clickMouse();
		page.clickPopularity();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Assert.assertEquals("Mouse - Buy Mouse at an Discount of Upto 70% | Flipkart.com", driver.getTitle());
		log.info("Electronics Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to click on electronics and then able to select mouse options");
		extent.endTest(extentTest);
	}



}
