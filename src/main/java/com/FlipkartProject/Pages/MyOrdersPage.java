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
 * Description:- This class includes all the locators and functions needed to operate for My Orders screen
 * @author Naina
 *
 */

public class MyOrdersPage {
	WebDriver driver;

	public MyOrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//--Login

	@FindBy(how = How.XPATH , using = "//input[@class='_2IX_2- VJZDxU']")
	public WebElement enterPhoneNumber;

	@FindBy(how = How.CSS , using = "input[type='password']")
	public WebElement enterPass;

	@FindBy(how = How.XPATH , using = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	public WebElement clickLogin;

	//--Profile

	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;

	@FindBy(how=How.XPATH, using="//div[contains(text(),'Orders')]")
	public WebElement order;

	//--My orders

	@FindBy(how=How.XPATH, using="//input[@placeholder='Search your orders here']")
	public WebElement searchOrder;

	@FindBy(how=How.XPATH, using="//span[normalize-space()='Search Orders']")
	public WebElement clicksearch;

	@FindBy(how=How.CSS, using=".row._1kkfO3.BqOr_g")
	public WebElement clickYourOrder;


	@FindBy(how=How.CSS, using=".AVbPIS._2HI4u2._20YKus")
	public WebElement delivered;

	//--Order in 2020


	@FindBy(how=How.CSS, using="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > label:nth-child(1) > div:nth-child(2)")
	public WebElement orderIn2020;


	@FindBy(how=How.CSS, using="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
	public WebElement Order2020;


	@FindBy(how=How.CSS, using=".AVbPIS._2HI4u2._20YKus")
	public WebElement checkdelivered;

	@FindBy(how=How.CSS, using="body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
	public WebElement clickRecentOrder;

	@FindBy(how=How.XPATH, using="//span[normalize-space()='Rate & Review Product']")
	public WebElement rate;

	@FindBy(how=How.XPATH, using="//textarea[@placeholder='Description...']")
	public WebElement description;

	@FindBy(how=How.XPATH, using="//button[normalize-space()='Submit']")
	public WebElement submitReview;

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
		Actions actions = new Actions(driver);
		actions.moveToElement(profileButton).perform();
	}

	public void clickOrders() {
		order.click();
	}

	public void searchYourOrder(String orderName) {
		searchOrder.click();
		searchOrder.sendKeys(orderName);
	}

	public void searchOrder() {
		clicksearch.click();
	}

	public void yourOrder() {
		clickYourOrder.click();
	}

	public void clickDelivered() {
		delivered.click();
	}

	public void click2020() {
		orderIn2020.click();
	}

	public void click2020FirstOrder() {
		Order2020.click();
	}

	public void clickDeliveredOrder() {
		checkdelivered.click();
	}

	//--Rate and review the placed order

	public void clickRecentOrder() {
		clickRecentOrder.click();
	}

	public void clickRateReview() {
		rate.click();
	}

	public void addReview(String review){
		description.click();
		description.clear();
		description.sendKeys(review);
	}

	public void clickSubmitReview() {
		submitReview.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement menu = wait.until(ExpectedConditions
		.presenceOfElementLocated(By.xpath("//span[normalize-space()='Review your purchases']")));
	}

}


