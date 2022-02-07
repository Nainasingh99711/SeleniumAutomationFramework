package com.FlipkartProject.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/***
 * Description:- This class includes the code for capturing the screenshot of the failed test cases
 * @author Naina
 *
 */

public class Screenshot {

public static String captureScreenshot(WebDriver driver , String testName) {
		
		String screenshotPath = System.getProperty("user.dir")+ "/FailedScreenshot/"+ testName+".jpg";
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenshotPath;
	}


}
