package com.automationFW.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.automationFW.Utils.CommonAssertions;
import com.automationFW.Utils.ExcelReader;
import com.automationFW.models.LoginData;

public class LoginUser extends BaseTest {

	@Test(priority = 0)
	public void verifyUserIsAbletoSignupAndLoginWithValidEmailPass() {

		HomePageObj.verifyUserIsOnhomePage();
		CommonAssertions.verifyEqual(HomePageObj.navigateToLoginPage(), "Login to your account",
				"'Login to your account' is visible");
		SignupLoginPageObj.validateSignup(email);
		SignupLoginPageObj.validateAndCreateAccountInfo(password);
		HomePageObj.verifyUserIsAbleTologout();
		CommonAssertions.verifyTrue(SignupLoginPageObj.login(email, password), "Login Name Not found");
		System.out.println(email + password + "i am at firsttestcase" );
	}

	@Test(priority = 1, dependsOnMethods = { "verifyUserIsAbletoSignupAndLoginWithValidEmailPass()" })
	public void verifyUserIsNotAbletoRegisterWithExistingEMail() {
		HomePageObj.verifyUserIsOnhomePage();
		HomePageObj.navigateToLoginPage();
		CommonAssertions.verifyEqual(SignupLoginPageObj.userAlreadyExist(email , password), "Email Address already exist!", "");
		System.out.println(email + password + "i am at Secondtestcase" );

	}

	@Test
	public void verifyUserIsNotAbletoLoginWithIncorrectEmailAndPass() throws IOException {
		HomePageObj.verifyUserIsOnhomePage();
		HomePageObj.navigateToLoginPage();
		List<LoginData> dataList = ExcelReader.incorrectLoginDatafromExcel();
		dataList.forEach(InvalidData -> {
			String expectedInvalidText = SignupLoginPageObj.loginWithInValidCredAndValidation(InvalidData);
			CommonAssertions.verifyEqual(expectedInvalidText, "Your email or password is incorrect!", "");
			System.out.println(email + password + "i am at thirdcase" );

		});
	}

	@Test(priority = 2, dependsOnMethods = { "verifyUserIsAbletoSignupAndLoginWithValidEmailPass()" })
	public void verifyUserIsAbletoSignupAndLoginWithValidEmailPassAndDeleteAccount() {
		HomePageObj.navigateToLoginPage();
		SignupLoginPageObj.login(email, password);
		CommonAssertions.verifyEqual(SignupLoginPageObj.deleteAccount(), "ACCOUNT DELETED!",
				"Account NOt Deleted Succesffuly");
		System.out.println(email + password + "i am at fourthtestcase" );
	}

}
