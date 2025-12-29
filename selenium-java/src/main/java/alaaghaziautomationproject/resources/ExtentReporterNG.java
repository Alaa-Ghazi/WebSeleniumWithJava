package alaaghaziautomationproject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	//Method for the Extent reports 
		public static ExtentReports getExtentReports() {
			String path = System.getProperty("user.dir") + "//reports//ExtentReport.html";
			ExtentSparkReporter reports = new ExtentSparkReporter(path);
			reports.config().setReportName("Web Automation Report");
			reports.config().setDocumentTitle("Test Results");
			
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reports);
			extent.setSystemInfo("Tester", "Alaa Ghazi");
			
			return extent;
			
		}

}
