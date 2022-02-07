package com.FlipkartProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/***
 * Description:- This class includes all the locators and functions needed to operate for Page Navigation screen
 * @author Naina
 *
 */

public class PageNavigation {
	WebDriver driver;

	public PageNavigation(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = "//button[contains(text(),'✕')]")
	public WebElement clickCross;

	@FindBy(how = How.CSS , using = "input[placeholder='Search for products, brands and more']")
	public WebElement clickSearchBar;

	@FindBy(how = How.CSS , using = "button[type='submit']")
	public WebElement clickSearchIcon;

	@FindBy(how = How.XPATH , using = "//a[normalize-space()='2']")
	public WebElement navigate;

	//----Methods for locators

	public void clickCross() {
		clickCross.click();
	}

	public void searchBar(String productName) {
		clickSearchBar.sendKeys(productName);
	}
	
	public void searchIcon() {
		clickSearchIcon.click();
	}

	public void pageNavigation() {
		navigate.click();
	}
}

