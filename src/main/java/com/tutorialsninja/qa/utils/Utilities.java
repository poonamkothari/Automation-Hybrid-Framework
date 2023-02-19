package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateEmailWithTimeStamp() {
		
		Date date=new Date();
		String timeStamp= date.toString().replace(" ", "-").replace(":", "-");
		return "amotoorpi"+timeStamp+"@gmail.com";
	}

	public static String captureScreenShots(WebDriver driver,String testName) {
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	try {
		FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	return destinationScreenshotPath;
	}
}
