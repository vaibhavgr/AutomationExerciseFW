package com.automationFW.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;

public class UniqueGenerator {

	
	public static String getUniqueEmail() {
		return "automation"+ getCurrentDateTime() +"@yopmail.com";
	}
	
	
	public static String getCurrentDateTime() {
		
		 String dateTime = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(Calendar.getInstance().getTime());
		 return dateTime.replaceAll("[^0-9]","");
	}
	
	public static String randomeString(int length)
	{
		return RandomStringUtils.randomAlphanumeric(length);
	}
}
