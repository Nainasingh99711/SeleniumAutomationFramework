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
 * Description:- This class includes all the locators and functions needed to operate for My Profile screen
 * @author Naina
 *
 */

public class MyProfilePage {
	WebDriver driver;

	public MyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	//---login

	@FindBy(how = How.XPATH , using = "//input[@class='_2IX_2- VJZDxU']")
	public WebElement enterPhoneNumber;

	@FindBy(how = How.CSS , using = "input[type='password']")
	public WebElement enterPass;

	@FindBy(how = How.XPATH , using = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	public WebElement clickLogin;

	//--My Profile
	@FindBy(how=How.XPATH,using="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	public WebElement profileButton;

	@FindBy(how=How.XPATH, using="//div[contains(text(),'My Profile')]")
	public WebElement myProfile;

	//--Add New Address
	@FindBy(how = How.XPATH , using = "//div[contains(text(),'Manage Addresses')]")
	public WebElement address;

	@FindBy(how = How.XPATH , using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	public WebElement addNewAddress;

	@FindBy(how = How.XPATH , using = "//input[@name='name']")
	public WebElement addName;

	@FindBy(how = How.XPATH , using = "//input[@name='phone']")
	public WebElement phone;

	@FindBy(how = How.XPATH , using = "//input[@name='pincode']")
	public WebElement pin;

	@FindBy(how = How.CSS , using = "input[name='addressLine2']")
	public WebElement enterlocality;
	//------
	@FindBy(how = How.CSS , using = "textarea[name='addressLine1']")
	public WebElement enterAddress;

	@FindBy(how = How.XPATH , using = "//input[@name='city']")
	public WebElement entertown;

	@FindBy(how = How.XPATH , using = "//select[@name='state']")
	public WebElement state;

	@FindBy(how = How.CSS , using = "option[value='Delhi']")
	public WebElement chooseState;

	@FindBy(how = How.CSS , using = "label[for='HOME'] div[class='_1XFPmK']")
	public WebElement home;

	@FindBy(how = How.XPATH , using = "//button[normalize-space()='Save']")
	public WebElement save;

	//----Delete Saved Address
	@FindBy(how = How.CSS , using = "div[class='_1TzjCl'] div:nth-child(3) div:nth-child(1) div:nth-child(1) div:nth-child(1) img:nth-child(1)")
	public WebElement DeleteSavedAddress;

	@FindBy(how = How.CSS , using = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > span:nth-child(1)")
	public WebElement delete;

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

	public void clickMyProfile() {
		myProfile.click();
	} 

	//--Add Address
	public void manageAddress() {
		address.click();
	}

	public void AddNewAddress() {
		addNewAddress.click();
	}

	public void enterName(String name) {
		addName.clear();
		addName.sendKeys(name);
	}

	public void enterNumber(String number) {
		phone.clear();
		phone.sendKeys(number);
	}

	public void enterPincode(String pincode) {
		pin.clear();
		pin.sendKeys(pincode);
	}

	public void enterLocality(String locality) {
		enterlocality.clear();
		enterlocality.sendKeys(locality);
	}

	public void enterYourAddress(String address) {
		enterAddress.clear();
		enterAddress.sendKeys(address);
	}

	public void enterYourTown(String town) {
		entertown.clear();
		entertown.sendKeys(town);
	}

	public void clickState() {
		state.click();
	}

	public void chooseYourState() {
		chooseState.click();
	}

	public void chooseHome() {
		home.click();
	}

	public void clickSave() {
		save.click();
	}

	//---Delete saved address

	public void deleteSavedAddress() {
		Actions actionProvider = new Actions(driver);
		actionProvider.moveToElement(DeleteSavedAddress).perform();
	}

	public void delete() {
		delete.click();
	}
}
