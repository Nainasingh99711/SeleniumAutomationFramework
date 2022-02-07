package com.FlipkartProject.Tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.FlipkartProject.Pages.Fashion;
import com.relevantcodes.extentreports.LogStatus;
import Utils.CommonUtils;

/***
 * Description:- This class includes all the automation Steps for Fashion page
 * @author Naina
 *
 */

public class FashionTest extends BaseTest{

	// Worksheet Name used by all tests
	private String sheetName = prop.getProperty("generalDataSheetName");

	@Test  (groups= {"Test"})
	public void Test_01_fashion()  {
		String testName = "Test_01_fashion";
		extentTest = extent.startTest("Fashion : Verifying the fashion menu");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);
		String executionRequired = testData.get("Execution Required").toLowerCase();
		CommonUtils.toCheckExecutionRequired(executionRequired);

		Fashion page = new Fashion(driver);
		log.info("Fashion : Fashion Test Started");
		page.clickCross();
		page.select();
		page.clickNewest();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Assert.assertEquals("KK,Sets,DM,Sarees - Buy KK,Sets,DM,Sarees Online at Low Prices In India | Flipkart.com", driver.getTitle());
		log.info("Fashion Test is successful");
		extentTest.log(LogStatus.PASS,"User is able to click on women fashion and then able to use the newest first filter");
		extent.endTest(extentTest);
	}


}
