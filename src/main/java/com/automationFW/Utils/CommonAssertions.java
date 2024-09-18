package com.automationFW.Utils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CommonAssertions {

	public static void verifyEqual(Object object , String expected, String failedMsg) 
	{
		Assert.assertEquals(object, expected , failedMsg);
	}
	
	public static void verifyTrue(boolean flag, String failedMSG) {
		
		Assert.assertTrue(flag, failedMSG);
	}
	
	
	public static void softVerifyFasle()
	{
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.fail(null);
	}
}
