package com.FlipkartProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/***
 * Description:- This class includes all the locators and functions needed to operate for Product Specification screen
 * @author Naina
 *
 */

public class ProductSpecificationPAge {
	WebDriver driver;

	public ProductSpecificationPAge(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = "//li[@id='swatch-1-color']//div[@class='_2C41yO']")
	public WebElement clickBlueColor;

	@FindBy(how = How.XPATH , using = "//a[normalize-space()='128 GB']")
	public WebElement click128Storage;

	@FindBy(how = How.XPATH , using = "//input[@id='pincodeInputId']")
	public WebElement changeAddress;

	@FindBy(how = How.XPATH , using = "//span[@class='_2P_LDn']")
	public WebElement check;

	@FindBy(how = How.CSS , using = "div[class='gUuXy- _16VRIQ'] div[class='_3LWZlK']")
	public WebElement checkReviews;

	@FindBy(how = How.CSS , using = "a:nth-child(1) div:nth-child(1) div:nth-child(2)")
	public WebElement checkCameraReviews;

	//----Methods for locators

	public void changeColor() {
		clickBlueColor.click();
	}

	public void changeStorage() {
		click128Storage.click();
	}

	public void clickAddress(String pincode) {
		changeAddress.click();
		changeAddress.clear();
		changeAddress.sendKeys(pincode);
	}

	public void clickCheck() {
		check.click();	
	}

	public void clickReviews() {
		checkReviews.click();	

	}

	public void clickCameraReview() {
		checkCameraReviews.click();	

	}

}
