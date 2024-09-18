package com.automationFW.Utils;

import java.io.IOException;

import com.automationFW.Context.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReporterNG {
	
	static ExtentReports extent;
	public static ExtentReports getReporter() 
	{
		String reportPath= System.getProperty("user.dir")+"//Reports//AutomationReport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
		try {
			reporter.loadXMLConfig(Constants.reporterPath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	    extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Name", "Vaibhav Grover");
		extent.setSystemInfo("Brand", "Automation Exercise");
		
		return extent;
	
		
	}

}
