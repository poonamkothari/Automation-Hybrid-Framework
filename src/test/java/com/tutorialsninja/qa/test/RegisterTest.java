package com.tutorialsninja.qa.test;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base{
	public WebDriver driver;
	AccountSuccessPage accountSuccessPage;
	RegisterPage registerPage;
	
	public RegisterTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationUrl(prop.getProperty("browser"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccount();
		registerPage=homepage.clickOnRegisterAccountOption();
		
		}
	
	@Test(priority = 1)
public void verifyRegisteringAnAccountWithMandatoryFields() {
		//accountSuccessPage=new AccountSuccessPage(driver);
		//registerPage=new RegisterPage(driver);
		
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("password"));
		registerPage.checkTheCheckBoxField();
		accountSuccessPage=registerPage.clickOnContinueButton();
	
	
	String actualHeading = accountSuccessPage.retrieveAccountSuccessfullyCreatedHeading();
Assert.assertEquals(actualHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading"),"account success page is not displayed");
	
	}
	@Test(priority = 2)
	public void verifyRegisteringAccountByProvidingAllFields() {
		
		//registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("password"));
		registerPage.checkTheRadioButton();
		registerPage.checkTheCheckBoxField();
		accountSuccessPage=registerPage.clickOnContinueButton();
		
		String actualHeading=accountSuccessPage.retrieveAccountSuccessfullyCreatedHeading();
		 
		Assert.assertEquals(actualHeading,dataProp.getProperty("accountSuccessfullyCreatedHeading"),"account success page is not displayed");
	}
	@Test(priority = 3)
	public void registeringAnAccountWithExistingEmail() {
		//accountSuccessPage=new AccountSuccessPage(driver);
		registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataProp.getProperty("telephone"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("password"));
		registerPage.checkTheRadioButton();
		registerPage.checkTheCheckBoxField();
	 registerPage.clickOnContinueButton();
		 String actualWarningMsg = registerPage.duplicateEmailWarningMessage();
	Assert.assertTrue(actualWarningMsg.contains(dataProp.getProperty("duplicateEmailWarning")),"warning message is not displayed");
	}
	@Test(priority = 4)
	public void verifyRegisteringAccountWithoutEnteringAnyFields() {
		accountSuccessPage=new AccountSuccessPage(driver);
		registerPage=new RegisterPage(driver);
		
		registerPage.clickOnContinueButton();
 String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarningMessage();
	Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("PrivacyPolicyWarning")),"no warning message");
	
	
	String actualFirstNameWarning = registerPage.retrievefirstNameWarningMessage();
	
	String firstNameWarningMsg=dataProp.getProperty("FirstNameWarning");
	Assert.assertTrue(actualFirstNameWarning.contains(firstNameWarningMsg), "no warning msg for the first name");
	
	String actualLastNameWarning=registerPage.retrieveLastNameWarningMessage();
	String lastNameWarningMsg=dataProp.getProperty("LastNameWarning");
	Assert.assertTrue(actualLastNameWarning.contains(lastNameWarningMsg), "last name warning msg is not displayed");
	
	
	String actualEmailWarningMsg=registerPage.retrieveEmailWarningMessage();
	String emailWarningMsg=dataProp.getProperty("EmailWarningMsg");
	Assert.assertTrue(actualEmailWarningMsg.contains(emailWarningMsg), "email warning msg is not displayed");
	
	String actualTelephoneWarningMsg=registerPage.retrieveTelephoneWarningMessage();
	String telephoneWarningMsg=dataProp.getProperty("TelephoneWarningMsg");
	Assert.assertTrue(actualTelephoneWarningMsg.contains(telephoneWarningMsg), "warning msg is not displayed");
	
	
	String actualPasswordWarningMag=registerPage.retrievePasswordWarningMessage();
	String passwordWarningMsg=dataProp.getProperty("passwordWarningMsg");
	Assert.assertTrue(actualPasswordWarningMag.contains(passwordWarningMsg), "password warning msg is not displayed");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
