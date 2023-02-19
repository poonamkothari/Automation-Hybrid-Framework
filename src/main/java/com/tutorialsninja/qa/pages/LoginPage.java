package com.tutorialsninja.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath ="//input[@type='submit']")
	private WebElement loginButtonField;
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	//will create a constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//created a single method for login
	
	  public AccountPage login(String emailText,String passwordText) {
	  emailAddressField.sendKeys(emailText); passwordField.sendKeys(passwordText);
	  loginButtonField.click(); 
	  return new AccountPage(driver); }
	 

	
	public AccountPage clickOnLoginButton() {
		loginButtonField.click();
		return new AccountPage(driver);
	}

	public String retrieveWarningMessageText() {
		String message = warningMessage.getText();
		return message;
	}
	

}
