package com.FlipkartProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Description:- This class includes all the locators and functions needed to operate for Filters screen
 * @author Naina
 *
 */


public class FiltersPage {
WebDriver driver;
	
	public FiltersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH , using = "//button[contains(text(),'✕')]")
	public WebElement clickCross;
	
	@FindBy(how = How.CSS , using = "input[placeholder='Search for products, brands and more']")
	public WebElement clickSearchBar;
	
	@FindBy(how = How.CSS , using = "button[type='submit']")
	public WebElement clickSearchIcon;
	
	@FindBy(how = How.CSS , using = "div[class='_5THWM1'] div:nth-child(2)")
	public WebElement clickPopularity;
	
	@FindBy(how = How.XPATH , using = "//div[normalize-space()='Price -- Low to High']")
	public WebElement priceLowToHigh;
	
	@FindBy(how = How.XPATH , using = "//div[normalize-space()='Price -- High to Low']")
	public WebElement priceHighToLow;
	
	public void clickCross() {
		clickCross.click();
	}
	
	public void searchBar(String productName) {
		clickSearchBar.sendKeys(productName);
	
	}
	
	public void searchIcon() {
		clickSearchIcon.click();
	}
	
	public void popularity() {
		clickPopularity.click();
	}
	
	public void priceLow() {
		priceLowToHigh.click();
	}
	
	public void priceHigh() {
		priceHighToLow.click();
	}
	
}
