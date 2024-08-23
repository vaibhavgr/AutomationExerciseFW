package com.automationFW.tests;

import org.testng.annotations.Test;

import com.automationFW.Utils.CommonAssertions;

public class RegisterUser extends BaseTest {
	@Test
	public void verifyUserIsAbletoRegisterWithValidCreds() {
		String actualhomepagetitile = "Automation Exercise";
		CommonAssertions.verifyEqual(actualhomepagetitile, HomePageObj.validateHomePagetitle(), "Not on Home Page");
		HomePageObj.verifyUserIsOnhomePage();
	}
}