package com.automationFW.tests;
import org.testng.annotations.Test;

import com.automationFW.Utils.CommonAssertions;

public class LoginUser extends BaseTest{
	
	@Test (priority = 0)
	public void verifyUserIsAbletoSignupAndLoginWithValidEmailPass() 
	{	
		HomePageObj.verifyUserIsOnhomePage();
		CommonAssertions.verifyEqual(HomePageObj.navigateToLoginPage(), "Login to your account",  "'Login to your account' is visible");
		SignupLoginPageObj.validateSignup(email);
		SignupLoginPageObj.validateAndCreateAccountInfo(password);
		HomePageObj.verifyUserIsAbleTologout();
		CommonAssertions.verifyTrue(SignupLoginPageObj.login(email,password), "Login Name Not found");
	}
	
	@Test (priority = 1, dependsOnMethods={"verifyUserIsAbletoSignupAndLoginWithValidEmailPass()"})
	public void verifyUserIsAbletoSignupAndLoginWithValidEmailPassAndDeleteAccount() 
	{	
		HomePageObj.navigateToLoginPage();
		SignupLoginPageObj.login(email,password);
		CommonAssertions.verifyEqual(SignupLoginPageObj.deleteAccount(), "ACCOUNT DELETED!" , "Account NOt Deleted Succesffuly" );
	}
	
//	@Test
//	public void verifyUserIsNotAbletoLoginWithIncorrectEmailAndPass()
//	{	
//		HomePageObj.verifyUserIsOnhomePage();
//		CommonAssertions.verifyEqual(HomePageObj.navigateToLoginPage(), "Login to your account",  "'Login to your account' is visible");
//	}
	
	
}
