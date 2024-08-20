package com.automationFW.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.automationFW.Context.Constants;

public class TestProperties {

	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(Constants.configFILEPATH);
		prop.load(fis);
		return prop;
	}
}
