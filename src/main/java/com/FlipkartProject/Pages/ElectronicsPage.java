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
 * Description:- This class includes all the locators and functions needed to operate for Electronics screen
 * @author Naina
 *
 */

public class ElectronicsPage {
	WebDriver driver;

	public ElectronicsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	@FindBy(how = How.XPATH , using = "//button[contains(text(),'✕')]")
	public WebElement clickCross;

	@FindBy(how = How.XPATH , using = "//img[@alt='Logitech B175 Wireless Optical Mouse']")
	public WebElement mouse;


	@FindBy(how = How.XPATH , using = "//div[normalize-space()='Popularity']")
	public WebElement popularity;

	public void clickCross() {
		clickCross.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement menu = wait.until(ExpectedConditions
		.presenceOfElementLocated(By.xpath("//img[@alt='Electronics']")));
	}

	public void selectElectronics() {
		Actions actions = new Actions(driver);
		WebElement accoutOptions = driver.findElement(By.xpath("//img[@alt='Electronics']"));
		actions.moveToElement(accoutOptions).perform();
		WebElement selectMenuOption = driver.findElement(By.xpath("//a[normalize-space()='Laptop Accessories']"));
		selectMenuOption.click();
	}

	public void clickMouse() {
		mouse.click();
	}

	public void clickPopularity() {
		popularity.click();
	}

}
