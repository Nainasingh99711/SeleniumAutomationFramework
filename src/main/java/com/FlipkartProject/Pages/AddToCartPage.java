package com.FlipkartProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/***
 * Description:- This class includes all the locators and functions needed to operate for Add to Cart screen
 * @author Naina
 *
 */

public class AddToCartPage {
	WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.CSS , using = "._2KpZ6l._2U9uOA._3v1-ww")
	public WebElement addCart;

	@FindBy(how = How.XPATH , using = "//div[normalize-space()='Remove']")
	public WebElement removeCart;

	//----Methods for locators

	public void addToCart() {
		addCart.click();
	}

	public void removeFromeCart() {
		removeCart.click();
	}


}
