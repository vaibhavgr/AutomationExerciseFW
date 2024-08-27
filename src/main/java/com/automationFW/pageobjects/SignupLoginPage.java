package com.automationFW.pageobjects;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationFW.Utils.UniqueGenerator;
import com.github.javafaker.Faker;

public class SignupLoginPage extends BasePage {

	public SignupLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[@style='color: orange;']")private WebElement headerOrangeColorCheck;
	@FindBy(xpath = "//input[@data-qa='signup-name' and @placeholder='Name']")private WebElement signupName;
	@FindBy(xpath = "//input[@data-qa='signup-email' and @placeholder='Email Address']")private WebElement signupEmail;
	@FindBy(xpath = "//button[@data-qa='signup-button']")private WebElement signUpBtn ;
	@FindBy(xpath = "//div[@class = 'login-form']//b[text() = 'Enter Account Information']")private WebElement accountInformationText;
	@FindBy(css = "#uniform-id_gender1")private WebElement radioBtnMale;
	@FindBy(css = "#password") private WebElement passwordTextBox;
	@FindBy(xpath = "//*[@id = 'days']//option[5]") private WebElement dayDropdown;
	@FindBy(xpath = "//*[@id = 'months']//option[5]")private WebElement monthDropdown;
	@FindBy(xpath = "//*[@id = 'years']//option[5]")private WebElement yearDropdown;
	@FindBy(css = "#newsletter")private WebElement newslettercheckbox;
	@FindBy(css = "#optin")private WebElement offerCheckbox;
	@FindBy(css = "#first_name")private WebElement firstNameTextBox;
	@FindBy(css = "#last_name")private WebElement lastNameTextBox;
	@FindBy(css = "#company")private WebElement companyTextBox;
	@FindBy(css = "#address1")private WebElement address1TextBox;
	@FindBy(css = "#address2")private WebElement address2TextBox;
	@FindBy(xpath = "//*[@id = 'country']//option[1]")private WebElement countryTextBox;
	@FindBy(css = "#state")private WebElement stateTextBox;
	@FindBy(css = "#city")private WebElement cityTextBox;
	@FindBy(css = "#zipcode")private WebElement zipcodeTextBox;
	@FindBy(css = "#mobile_number")private WebElement mobileNumberTextBox;
	@FindBy(xpath = "//button[@data-qa = 'create-account']")private WebElement createAccountBtn;
	@FindBy(xpath = "//b[text() = 'Account Created!']")private WebElement accountCreatedText;
	@FindBy(xpath = "//a[text() = ' Logged in as ']//b")private WebElement postLoginName;
	@FindBy(xpath = "//a[text() = 'Continue']")private WebElement continueBtn;
	
	
//	public boolean validateSignup() {
//
//		setTextBox(signupName, UniqueGenerator.randomeString(8));
//		setTextBox(signupEmail, UniqueGenerator.getUniqueEmail());
//		clickElement(signUpBtn);
//		return isElementDisplayed(accountInformationText);
//	}
	
	public HashMap <String,Object>validateSignup(){
		HashMap <String,Object>validateSignupMap = new HashMap<>();
		setTextBox(signupName, UniqueGenerator.randomeString(5));
		setTextBox(signupEmail, UniqueGenerator.getUniqueEmail());
		clickElement(signUpBtn);
		validateSignupMap.put("accontInformationText",isElementDisplayed(accountInformationText));
		System.out.println(String.format("Inner",signupName));
		return  validateSignupMap;
	}
	
	public LinkedHashMap<Object, Object> validateAndCreateAccountInfo() {
		LinkedHashMap<Object, Object> accountCreationamap = new LinkedHashMap<>();
		Faker faker = new Faker();
		accountCreationamap.put(clickElement(radioBtnMale),null);
		accountCreationamap.put(clickElement(passwordTextBox), setTextBox(passwordTextBox , faker.internet().password()));
		accountCreationamap.put(clickElement(dayDropdown),null);
		accountCreationamap.put(clickElement(monthDropdown),null);
		accountCreationamap.put(clickElement(yearDropdown),null);
		accountCreationamap.put(clickElement(newslettercheckbox),null);
		accountCreationamap.put(clickElement(offerCheckbox),null);
		accountCreationamap.put(clickElement(firstNameTextBox),setTextBox(firstNameTextBox,faker.name().firstName()));
		accountCreationamap.put(clickElement(lastNameTextBox),setTextBox(lastNameTextBox,faker.name().lastName()));
		accountCreationamap.put(clickElement(companyTextBox),setTextBox(companyTextBox,faker.name().firstName()));
		accountCreationamap.put(clickElement(address1TextBox),setTextBox(address1TextBox,faker.address().fullAddress()));
		accountCreationamap.put(clickElement(address2TextBox),setTextBox(address2TextBox,faker.address().fullAddress()));
		accountCreationamap.put(clickElement(countryTextBox),null);
		accountCreationamap.put(clickElement(stateTextBox),setTextBox(stateTextBox,faker.address().state()));
		accountCreationamap.put(clickElement(cityTextBox),setTextBox(cityTextBox,faker.address().cityName()));
		accountCreationamap.put(clickElement(zipcodeTextBox),setTextBox(zipcodeTextBox,faker.address().zipCode()));
		accountCreationamap.put(clickElement(mobileNumberTextBox),setTextBox(mobileNumberTextBox,faker.phoneNumber().phoneNumber()));
		accountCreationamap.put(clickElement(createAccountBtn),null);
		accountCreationamap.put("accountCreationMsg" ,getElementText(accountCreatedText));
		accountCreationamap.put(clickElement(continueBtn),null);
		accountCreationamap.put("postLoginNameText" ,getElementText(postLoginName));
		
		return accountCreationamap;

		
	}
	
	public void deleteAccount()
	{
		
	}
	
	

}

 