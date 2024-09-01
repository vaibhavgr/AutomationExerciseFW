package com.automationFW.tests;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.automationFW.Utils.CommonAssertions;

public class LoginUserWithCorrectEmailPassword extends BaseTest{

	@Test
	public void verifyUserIsAbletoSignupAndLoginWithValidEmailPass() 
	{	//1,2,3
		HomePageObj.verifyUserIsOnhomePage();
		CommonAssertions.verifyEqual(HomePageObj.navigateToLoginPage(), "Login to your account",  "'Login to your account' is visible");
		LinkedHashMap<Object, Object> map  = 
		SignupLoginPageObj.validateAndCreateAccountInfo();
	}
}
