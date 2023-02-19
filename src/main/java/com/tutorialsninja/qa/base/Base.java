package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base() {
		prop=new Properties();
		File propfile =new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		dataProp= new Properties();
		
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream file2=new FileInputStream(dataPropFile);
		dataProp.load(file2);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		try {
		FileInputStream file =new FileInputStream(propfile);
		prop.load(file);
	}catch(Throwable e) {
		e.printStackTrace();
	}
	}
	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {
		//instead of equals we can use equalsIgnoreCase to ignore the case 
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver(); 
		}
		else if(browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
	return driver;
	
	}
}
