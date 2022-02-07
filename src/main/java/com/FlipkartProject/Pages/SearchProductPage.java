package com.FlipkartProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Description:- This class includes all the locators and functions needed to operate for Search Product screen
 * @author Naina
 *
 */

public class SearchProductPage {
	WebDriver driver;

	public SearchProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = "//input[@class='_2IX_2- VJZDxU']")
	public WebElement enterPhoneNumber;

	@FindBy(how = How.CSS , using = "input[type='password']")
	public WebElement enterPass;

	@FindBy(how = How.XPATH , using = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	public WebElement clickLogin;

	@FindBy(how = How.XPATH , using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement searchProduct;

	@FindBy(how = How.XPATH , using = "//button[@type='submit']//*[name()='svg']")
	public WebElement clickSearchIcon;

	@FindBy(how = How.XPATH , using = "//div[@class='_1YokD2 _3Mn1Gg']//div[2]//div[1]//div[1]//div[1]//a[1]//div[1]//div[3]//div[1]//*[name()='svg']//*[name()='path' and contains(@class,'eX72wL')]")
	public WebElement wishlist;

	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;

	@FindBy(how=How.XPATH,using="//a[@href='/wishlist?link=home_wishlist']")
	public WebElement clickWishlist;

	@FindBy(how=How.CSS,using="._2Nq6Qc")
	public WebElement delete;

	@FindBy(how = How.XPATH , using = "//button[normalize-space()='YES, REMOVE']")
	public WebElement remove;

	//----Methods for locators

	public void phoneNumber(String number) {
		enterPhoneNumber.click();
		enterPhoneNumber.sendKeys(number);
	}

	public void enterPassword(String password) {
		enterPass.click();
		enterPass.sendKeys(password);
	}

	public void loginButton() {
		clickLogin.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement menu = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(text(),'Naina')]")));
	}

	public void enterProductName(String productName) {
		searchProduct.click();
		searchProduct.sendKeys(productName);
	}

	public void searchIcon() {
		clickSearchIcon.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement menu = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[normalize-space()='APPLE iPhone 12 (Black, 64 GB)']")));
	}

	public void addToWishlist() {
		wishlist.click();
	}

	public void profile() {
		Actions actions = new Actions(driver);
		actions.moveToElement(profileButton).perform();
	}


	public void clickOnWishlist() {
		clickWishlist.click();
	}

	public void clickdelete() {
		delete.click();
	}

	public void clickRemove() {
		remove.click();

	}
}

