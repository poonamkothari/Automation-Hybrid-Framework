package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(linkText ="HP LP3065")
	WebElement searchedProduct;
	
	@FindBy(xpath ="//p[contains(text(),'There is no product')]")
	WebElement invalidProduct;
	
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public  boolean displayedResultForsearchedProduct() {
		boolean displayStatus = searchedProduct.isDisplayed();
		
		return displayStatus;
	}
	public  String invalidProductMessage() {
		 String errorMessageForInvalidProduct = invalidProduct.getText();
		 return errorMessageForInvalidProduct;
	}
	
}
