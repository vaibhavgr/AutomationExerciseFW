package com.automationFW.tests;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.automationFW.Utils.CommonAssertions;

public class LoginUserWithCorrectEmailPassword extends BaseTest{

	@Test
	public void verifyUserIsAbletoSignupAndLoginWithValidEmailPass() 
	{	//1,2,3
		HomePageObj.verifyUserIsOnhomePage();
		CommonAssertions.verifyEqual(HomePageObj.navigateToLoginPage(), "Login to your account",  "'Login to your account' is visible");
		HashMap<String , Object> signupMap = SignupLoginPageObj.validateSignup();
		String Email = signupMap.get("signupEmail").toString();
		
	
		LinkedHashMap<Object, Object> map  = SignupLoginPageObj.validateAndCreateAccountInfo();
		String Password = map.get("InputPassword").toString();
		HomePageObj.verifyUserIsAbleTologout();
		SignupLoginPageObj.login(Email , Password);

//		
//		
//		
//		System.out.println("My Email is : "+ Email + "and Passowrd is :" +  Password );		
	}
}
