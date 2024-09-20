package com.automationFW.pageobjects;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@data-qa = 'name' and @placeholder = 'Name']")private WebElement nameInput;
	@FindBy(xpath = "//input[@data-qa = 'email' and @placeholder = 'Email']")private WebElement emailInput;
	@FindBy(xpath = "//input[@data-qa = 'subject' and @placeholder = 'Subject']")private WebElement subjectInput;
	@FindBy(xpath = "//input[@data-qa = 'message' and @placeholder = 'Your Message Here']")private WebElement messageInput;
	@FindBy(xpath = "//input[@type= 'file' and @name = 'upload_file']")private WebElement uploadfileInput;
	@FindBy(xpath = "//input[@data-qa = 'submit-button']")private WebElement submitBtnContactUsPage;
	
	
	//verify user is able to submit all details on contactuspage
	public void validateContactUsPage()
	{
		setTextBox(nameInput, "");
		setTextBox(emailInput, "");
		setTextBox(subjectInput, "");
		setTextBox(messageInput, "");
		
	} 
	
	public void validateContactUsPageJson(Map <String , String> Data)
	{
		//setTextBox(nameInput, Data.get());
		setTextBox(emailInput, "");
		setTextBox(subjectInput, "");
		setTextBox(messageInput, "");
		
	}
}

 