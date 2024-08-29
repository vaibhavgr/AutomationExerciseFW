package com.automationFW.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automationFW.Context.DriverManager;

public class PageActions {

	WebDriver driver;
	WebDriverWait wait;

	public PageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String clickElementAndGetText(WebElement element) {
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		element.click();
		return element.getText();

	}
	
	public Object clickElement(WebElement element)
	{
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		element.click();
		return null;
		
	}

	public String setTextBox(WebElement element, String value) {
		waitUntilDisplayed(element);
		waitUntilClickable(element);
		element.sendKeys(value);
		return value ;
		

	}
	
	public String getElementText(WebElement element) {
		waitUntilDisplayed(element);
		return element.getText();
	}

	public void waitUntilDisplayed(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		
	}

	public void switchChildWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		String parentWindow = windowHandles.iterator().next();
		String childWindow = windowHandles.iterator().next();
		driver.switchTo().window(childWindow);
	}

	public void shortWait() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void switchToParentWindow() {

	}

	public List<String> getListofTextFromWebElements(List<WebElement> list) {
		List<String> actualList = new ArrayList<String>();
		for (WebElement item : list) {
			actualList.add(item.getText().toLowerCase());
		}
		return actualList;
	}
	
	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
		
	}
	
//	public static  String getScreenshot() throws IOException {
//		TakesScreenshot screeshot = (TakesScreenshot) DriverManager.getDriver();
//		File src = screeshot.getScreenshotAs(OutputType.FILE);
//		String path= System.getProperty("user.dir") + "//Reports//screenshot"+UniqueGenerator.getCurrentDateTime()+".png";
//		File dest = new File(path);
//		FileUtils.moveFile(src, dest);
//		return path;
//	}
	
	public static  String getScreenshot() throws IOException {
		TakesScreenshot screeshot = (TakesScreenshot) DriverManager.getDriver();
		 return screeshot.getScreenshotAs(OutputType.BASE64);
	
	}
	

	public  void getValidateNavigationMenybyColor(WebElement element , WebElement elementdisplayed)
{
	String isClicked = clickElementAndGetText(element); 
	boolean isDisplayed  = isElementDisplayed(elementdisplayed);
	//Assert.assertTrue(isDisplayed, "The expected element is not displayed.");
		 if (isDisplayed  = true) {
	            System.out.println("I am on  " + isClicked);
	        } else {
	            System.out.println("Not on Same as clicked Page");
	        
	       }
		 
	}
	
	public  void getValidateText(WebElement element , WebElement elementdisplayed)
	{
		String isClicked = clickElementAndGetText(element); 
		boolean isDisplayed  = isElementDisplayed(elementdisplayed);
		//Assert.assertTrue(isDisplayed, "The expected element is not displayed.");
			 if (isDisplayed  = true) {
		            System.out.println("I am on  " + isClicked);
		        } else {
		            System.out.println("Not on Same as clicked Page");
		        
		       }
			 
		}

	
	

}

