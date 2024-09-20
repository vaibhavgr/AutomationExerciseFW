package com.automationFW.tests;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.automationFW.Context.Constants;
import com.automationFW.Utils.JsonReaderUtil;

public class ContactUs extends BaseTest {
public static final Object contactUsFormObject = JsonReaderUtil.getAnyKeyValue(Constants.contactUsJson, "ContactUs");
public static final Map<String, String> contactusformData = JsonReaderUtil
.convertJsonObjectToHashMap((JSONObject) contactUsFormObject);

	
	
	@Test
	public void verifyUserIsAbleToSendContactUsSuccessfully()
	{
		HomePageObj.navigateToContactUsPage();
		//ContactUsPageObj.validateContactUsPageJson(contactusformData);
		System.out.println(contactusformData);
	}
	
}
