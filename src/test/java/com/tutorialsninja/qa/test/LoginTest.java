package com.tutorialsninja.qa.test;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{
	LoginPage loginPage;
	public WebDriver driver;
	AccountPage accountPage;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationUrl(prop.getProperty("browser"));
		loginPage=new LoginPage(driver);
		accountPage =new AccountPage(driver);
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
	
		loginPage = homepage.clickOnLoginOption();
	}
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		/*
		 * loginPage=new LoginPage(driver); accountPage =new AccountPage(driver);
		 */
		loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPasword"));
		
		//AccountPage accountPage = loginPage.clickOnLoginButton();
	/*login.enterEmail(prop.getProperty("validEmail"));
    login.enterPassword(prop.getProperty("validPasword"));
    AccountPage accountPage = login.clickOnLoginButton();*/
		Assert.assertTrue(accountPage.editAcoountDispalyStatus(), "there is no edit account status dispalyed");
	}
	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() throws InterruptedException {
	 
		loginPage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		/*
		 * loginPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		 * loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		 * loginPage.clickOnLoginButton();
		 */
	
	String warningText = loginPage.retrieveWarningMessageText();
	String expectedWarningMsg=dataProp.getProperty("emialPasswordNoMatching");
	Assert.assertTrue(warningText.contains(expectedWarningMsg),"the warning msg is not displayed");
	}
	
	@Test(priority = 3)
	public void loginWithValidEmailAndInvalidPassword() {
		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		/*
		 * loginPage.enterEmail(prop.getProperty("validEmail"));
		 * loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		 * loginPage.clickOnLoginButton();
		 */
	
	String warningText = loginPage.retrieveWarningMessageText();
	String expectedWarningMsg=dataProp.getProperty("emialPasswordNoMatching");
	Assert.assertTrue(warningText.contains(expectedWarningMsg),"the warning msg is not displayed");
	}
	@Test(priority = 4)
	public void loginWithInValidEmailAndvalidPassword() {
		loginPage.login(dataProp.getProperty("invalidEmail"), prop.getProperty("validPasword"));
		loginPage.clickOnLoginButton();
		
		/*
		 * loginPage.enterEmail(dataProp.getProperty("invalidEmail"));
		 * loginPage.enterPassword(prop.getProperty("validPasword"));
		 * loginPage.clickOnLoginButton();
		 */
	
	String warningText = loginPage.retrieveWarningMessageText();
	String expectedWarningMsg=dataProp.getProperty("emialPasswordNoMatching");
	Assert.assertTrue(warningText.contains(expectedWarningMsg),"the warning msg is not displayed");
	}
	@Test(priority = 5)
	public void loginWithoutCredentials() {
		
		
		loginPage.clickOnLoginButton();
	
	String warningText = loginPage.retrieveWarningMessageText();
	String expectedWarningMsg=dataProp.getProperty("emialPasswordNoMatching");
	Assert.assertTrue(warningText.contains(expectedWarningMsg),"the warning msg is not displayed");
	}
	
	
	  @AfterMethod 
	  public void tearDown() {
		  driver.quit(); 
		  }
	 

	
}
