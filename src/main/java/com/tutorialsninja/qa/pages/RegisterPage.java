package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	
	@FindBy(id="input-firstname")
    private WebElement firstnameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement checkBoxField;
	
	@FindBy(xpath ="//input[@value='Continue']")
	private WebElement ContinueButtonField;
	
	@FindBy(xpath ="//input[@name='newsletter'][@value='1']")
	private WebElement RadioButtonField;
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarningfield;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement PrivacyPolicyWarningMessage;

	@FindBy(xpath="(//div[@class='text-danger'])[1]")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="(//div[@class='text-danger'])[2]")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="(//div[@class='text-danger'])[3]")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath="(//div[@class='text-danger'])[4]")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath="(//div[@class='text-danger'])[5]")
	private WebElement passwordWarningMessage;
	

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	  public void enterFirstName(String firstnameText) {
	  firstnameField.sendKeys(firstnameText); }
	  
	  public void enterLastName(String lastNameText) {
	  lastNameField.sendKeys(lastNameText);
	  } public void enterEmailAddress(String
	  emailText) { 
		  emailAddressField.sendKeys(emailText); 
		  } 
	  public void enterTelephone(String telephoneText) {
	  telephoneField.sendKeys(telephoneText); 
	  } 
		  public void enterPassword(String passwordText) {
		  passwordField.sendKeys(passwordText);
	  } 
	  public void enterConfirmPassword(String confirmPasswordText) {
	  confirmPasswordField.sendKeys(confirmPasswordText); 
	  } 
	  
	  public void checkTheCheckBoxField() { 
		  checkBoxField.click(); }
	 
public AccountSuccessPage clickOnContinueButton() {
	ContinueButtonField.click();
	return new AccountSuccessPage(driver);
}
public void checkTheRadioButton() {
	RadioButtonField.click();
}

public String duplicateEmailWarningMessage() {
	String duplicateEmailWarningText = duplicateEmailWarningfield.getText();
return duplicateEmailWarningText;
}
public String retrievePrivacyPolicyWarningMessage() {
	String PrivacyPolicyWarningText = PrivacyPolicyWarningMessage.getText();

return PrivacyPolicyWarningText;
}
public String retrievefirstNameWarningMessage() {
	String firstNameWarningText = firstNameWarningMessage.getText();
	return firstNameWarningText;
}

public String retrieveLastNameWarningMessage() {
	String lastNameWarningText = lastNameWarningMessage.getText();
return lastNameWarningText;
}
	public String retrieveEmailWarningMessage() {
		String emailWarningText = emailWarningMessage.getText();
		return emailWarningText;
	} 
	public String retrieveTelephoneWarningMessage() {
		String telephoneWarningText=telephoneWarningMessage.getText();
		return telephoneWarningText;
	}
	
	public String retrievePasswordWarningMessage() {
		String passwordWarningText = passwordWarningMessage.getText();
		return passwordWarningText;
	}
	/*
	 * public void register(String firstnameText,String lastNameText,String
	 * emailText, String telephoneText,String passwordText,String
	 * confirmPasswordText) { firstnameField.sendKeys(firstnameText);
	 * lastNameField.sendKeys(lastNameText); emailAddressField.sendKeys(emailText);
	 * telephoneField.sendKeys(telephoneText); passwordField.sendKeys(passwordText);
	 * confirmPasswordField.sendKeys(confirmPasswordText); checkBoxField.click(); }
	 */

}



