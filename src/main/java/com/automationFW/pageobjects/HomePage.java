package com.automationFW.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[@style='color: orange;']")
	private WebElement headerOrangeColorCheck;
	
	@FindBy(xpath = "//div[@class='shop-menu pull-right']//ul[@class='nav navbar-nav']/*[3]")
	private WebElement cartNavigationBarIcon;
	
	@FindBy(xpath = "//div[@class='shop-menu pull-right']//ul[@class='nav navbar-nav']/*[1]")
	private WebElement homeNavigationBarIcon;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a[@href='/login']")
	private WebElement signupLoginNavigationBarIcon;

	

	
	public void verifyUserIsOnhomePage() {
		getValidateNavigationMenybyColor(homeNavigationBarIcon, headerOrangeColorCheck);
		
		
	}
		
	
	public String validateHomePagetitle()
	{
		return driver.getTitle();
	}
	
	
}
