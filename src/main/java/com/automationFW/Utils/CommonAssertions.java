package com.automationFW.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.Assert;

public class CommonAssertions {

	public static void verifyEqual(Object object , String expected, String failedMsg) 
	{
		Assert.assertEquals(object, expected , failedMsg);
	}
	
	public static void verifyTrue(boolean flag, String failedMSG) {
		
		Assert.assertTrue(flag, failedMSG);
	}
}
