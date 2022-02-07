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
 * Description:- This class includes all the locators and functions needed to operate for Login screen
 * @author Naina
 *
 */

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH , using = "//input[@class='_2IX_2- VJZDxU']")
	public WebElement enterPhoneNumber;

	@FindBy(how = How.CSS , using = "input[type='password']")
	public WebElement enterPass;

	@FindBy(how = How.XPATH , using = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	public WebElement clickLogin;

	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;

	@FindBy(how=How.XPATH, using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li[10]/a[1]")
	public WebElement logout;

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

	public void clickLogout() {
		logout.click();
	}


}
