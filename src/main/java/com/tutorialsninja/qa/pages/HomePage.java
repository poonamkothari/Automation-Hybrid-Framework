package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropdownMenu;
	
	@FindBy(linkText ="Register")
	private WebElement registerAccount;
	
	@FindBy(linkText ="Login")
	private WebElement LoginOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//span/button[contains(@class,'btn-lg')]")
	private WebElement searchButtonField;
	
	
	//will craeye a constructor
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//now will create methods which are called actions.
	public void clickOnMyAccount() {
		myAccountDropdownMenu.click();
		
	}
	public RegisterPage clickOnRegisterAccountOption() {
		registerAccount.click();
		return new RegisterPage(driver);
	}
	public LoginPage clickOnLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
	}
	
	public void enteringDataInsearchBox(String data) {
		searchBoxField.sendKeys(data);
	}

	public SearchPage clickOnsearchButton() {
		searchButtonField.click();
		return new SearchPage(driver);
		
	}
}
