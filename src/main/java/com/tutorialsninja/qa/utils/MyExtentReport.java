package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReport {

	public static ExtentReports generateExtentReport() throws IOException {
		
		ExtentReports extentReports=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\extentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extentReportFile);
	//using sparkReporter will can set some configuration.
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorialsninja test automation results");
		sparkReporter.config().setDocumentTitle("TN automation report");
		sparkReporter.config().setTimeStampFormat("DD/MM/YYYY HH:MM:SS");
	
	///ATTACHING THE SPARKREPORTER TO THE EXTENTREPORT
		extentReports.attachReporter(sparkReporter);
		
//to print details
		
		Properties configProp =new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		FileInputStream fisConfigProp=new FileInputStream(configPropFile);
		configProp.load(fisConfigProp);
		extentReports.setSystemInfo("application url", configProp.getProperty("url"));
		extentReports.setSystemInfo("Browser name", configProp.getProperty("browser"));
		extentReports.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extentReports.setSystemInfo("password", configProp.getProperty("validPasword"));
		extentReports.setSystemInfo("operating system", System.getProperty("os.name"));
		extentReports.setSystemInfo("username", System.getProperty("user.name"));
		extentReports.setSystemInfo("java version", System.getProperty("java.version"));
	
	return extentReports;
	}
	
}
