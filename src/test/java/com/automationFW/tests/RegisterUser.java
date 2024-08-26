package com.automationFW.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationFW.Utils.CommonAssertions;

public class RegisterUser extends BaseTest {
	@Test
	public void verifyUserIsAbletoRegisterWithValidCreds() {
		
		//
		String actualhomepagetitile = "Automation Exercise";
		CommonAssertions.verifyEqual(actualhomepagetitile, HomePageObj.validateHomePagetitle(), "Not on Home Page");
		HomePageObj.verifyUserIsOnhomePage();
		
		//4 & 5.Verify 'New User Signup!' is visible
		String isDisplayedNewUserSignupText = HomePageObj.navigateToSignupPage();
		CommonAssertions.verifyEqual("New User Signup!", isDisplayedNewUserSignupText, "New User Signup is not Visible");
		
		//6,7 & 8  - Enter name and Email and Signup for new user
		CommonAssertions.verifyTrue(SignupLoginPageObj.validateSignup(), "Enter Account Information text not displayed");
		
		// 9,10,11,12,13.14,15 - Account creation Details 
		SignupLoginPageObj.validateAndCreateAccountInfo();
	}
}