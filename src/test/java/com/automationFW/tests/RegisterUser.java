package com.automationFW.tests;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationFW.Utils.CommonAssertions;

public class RegisterUser extends BaseTest {
	@Test
	public void verifyUserIsAbletoRegisterWithValidCreds() {
		
		
		String actualhomepagetitile = "Automation Exercise";
		CommonAssertions.verifyEqual(actualhomepagetitile, HomePageObj.validateHomePagetitle(), "Not on Home Page");
		HomePageObj.verifyUserIsOnhomePage();
		
		//4 & 5.Verify 'New User Signup!' is visible
		String isDisplayedNewUserSignupText = HomePageObj.navigateToSignupPage();
		CommonAssertions.verifyEqual( "New User Signup!",isDisplayedNewUserSignupText, "New User Signup is not Visible");
		
		//6,7 & 8  - Enter name and Email and Signup for new user
		//CommonAssertions.verifyTrue(SignupLoginPageObj.validateSignup(), "Enter Account Information text not displayed");
		HashMap<String,Object> validateSignupMaps = SignupLoginPageObj.validateSignup();
		System.out.println("outer" + validateSignupMaps);
		CommonAssertions.verifyTrue((boolean)validateSignupMaps.get("accontInformationText"), "Enter Account Information text not displayed");
		
		
		
		// 9,10,11,12,13.14,15 - Account creation Details 
		LinkedHashMap<Object, Object> accountCreationamap = SignupLoginPageObj.validateAndCreateAccountInfo();
		CommonAssertions.verifyEqual(accountCreationamap.get("accountCreationMsg").toString(), "ACCOUNT CREATED!", "Account is not created");
		//CommonAssertions.verifyEqual(accountCreationamap.get("postLoginNameText").toString(),validateSignupMap.get("signupName").toString(),"Not matched");
		
	}
}