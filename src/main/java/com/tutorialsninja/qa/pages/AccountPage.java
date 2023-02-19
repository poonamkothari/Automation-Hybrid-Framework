package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
WebDriver driver;

	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInformation;
	
	//will create a constructor
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean editAcoountDispalyStatus() {
		boolean displayStatusForAccountEdit=editAccountInformation.isDisplayed();
	return displayStatusForAccountEdit;
	}

	
}