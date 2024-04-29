package com.qa.utilis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReporter() {
		
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportFile);
		
		//Edit the Report 
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Tutorials Ninja Test Automation Result");
		sparkReport.config().setDocumentTitle("TN Automation Reports");
		sparkReport.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentReport.attachReporter(sparkReport);
		
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			
			try {
				FileInputStream fis = new FileInputStream(configPropFile);
				configProp.load(fis);

			} catch (Throwable e) {
				e.printStackTrace();
			}
		
		 
	    extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
	    extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
	    extentReport.setSystemInfo("Email", configProp.getProperty("ValidEmail"));
	    extentReport.setSystemInfo("Password", configProp.getProperty("ValidPassword"));
	    extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));

	    return extentReport;
		
	}    
}
