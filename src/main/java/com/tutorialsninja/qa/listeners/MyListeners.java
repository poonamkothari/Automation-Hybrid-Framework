package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.MyExtentReport;
import com.tutorialsninja.qa.utils.Utilities;

import io.netty.buffer.search.AbstractMultiSearchProcessorFactory;

public class MyListeners implements ITestListener{
	ExtentReports extentReports ;
	ExtentTest extendTest;
	
	
	@Override
	public void onStart(ITestContext context) {
		//System.out.println("onStart method started");
		try {
			extentReports = MyExtentReport.generateExtentReport();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("method started "+result.getName());
		
		 extendTest = extentReports.createTest(result.getName());
		extendTest.log(Status.INFO,result.getName()+"method started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("method passed "+result.getName());
		extendTest.log(Status.PASS, result.getName()+"method passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver =null;
		//code for retrieving the driver object(this will  get us driver in object format)
		try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		String destinationScreenshotPath = Utilities.captureScreenShots(driver, result.getName());
	//adding screenshots to the extent report 
	extendTest.addScreenCaptureFromPath(destinationScreenshotPath);
	extendTest.log(Status.INFO,result.getThrowable());
	extendTest.log(Status.FAIL,result.getName()+"method failed");
		
	
	//for printing on console.
	//System.out.println("method failed"+result.getName());
		//System.out.println(result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extendTest.log(Status.INFO, result.getThrowable());
		extendTest.log(Status.SKIP, result.getName()+"method skipped");
		//System.out.println("method skipped"+result.getName());
		//System.out.println(result.getThrowable());//exception detail
	}


	@Override
	public void onFinish(ITestContext context) {
	
		extentReports.flush();
		//System.out.println("onFinish method finished");
		
		//for automatically opening the extent report
		String pathOfExtentReport=System.getProperty("user.dir")+"\\test-output\\extentReports\\extentReport.html";
	File extentReport = new File(pathOfExtentReport);
	try {
		Desktop.getDesktop().browse(extentReport.toURI());
	} catch (IOException e) {
	e.printStackTrace();
	}
	}

}
