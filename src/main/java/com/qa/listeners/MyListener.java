package com.qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.utilis.ExtentReporter;

public class MyListener implements ITestListener{

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart (ITestContext context) {
		extentReport = ExtentReporter.generateExtentReporter();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getName(); 
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName +"start Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName(); 
		extentTest.log(Status.PASS, testName +" got successfully Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName(); 
		extentTest.log(Status.FAIL, testName +"got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getName(); 
		extentTest.log(Status.INFO,result.getThrowable() );
		extentTest.log(Status.SKIP, testName+"got skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
