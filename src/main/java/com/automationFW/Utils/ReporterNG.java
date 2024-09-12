package com.automationFW.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReporterNG {
	
	static ExtentReports extent;
	public static ExtentReports getReporter()
	{
		String reportPath= System.getProperty("user.dir")+"//Reports//AutomationReport.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(reportPath);
		reporter.config().setDocumentTitle("Autiomation Exercise Report");
		reporter.config().setReportName("Created By Vaibhav");
	    extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Name", "Vaibhav Grover");
		extent.setSystemInfo("Brand", "Automation Exercise");
		
		return extent;
	
		
	}

}
