package com.FlipkartProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/***
 * Description:- This class includes all the locators and functions needed to operate for Grocery screen
 * @author Naina
 *
 */

public class GroceryPage {
	WebDriver driver;

	public GroceryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = "//button[contains(text(),'✕')]")
	public WebElement clickCross;

	@FindBy(how = How.XPATH , using = "//img[@alt='Grocery']")
	public WebElement clickGrocery;

	@FindBy(how = How.XPATH , using = "//input[@placeholder='Search grocery products']")
	public WebElement enterProductName;

	@FindBy(how = How.XPATH , using = "//button[@type='submit']//*[name()='svg']")
	public WebElement clicksearch;

	//----Methods for locators

	public void clickCross() {
		clickCross.click();
	}

	public void clickGrocerySection() {
		clickGrocery.click();
	}

	public void enterProduct(String product) {
		enterProductName.sendKeys(product);
	}

	public void clickSearchIcon() {
		clicksearch.click();
	}

}
