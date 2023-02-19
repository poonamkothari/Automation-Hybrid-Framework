package com.tutorialsninja.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;
//this is the updated code.
public class SearchTest extends Base{
	
	public WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver=initializeBrowserAndOpenApplicationUrl(prop.getProperty("browser"));
	}
@Test(priority = 1)
	public void varifySearchWithValidProduct() {
	homePage=new HomePage(driver);
	homePage.enteringDataInsearchBox(dataProp.getProperty("validProduct"));
	searchPage=homePage.clickOnsearchButton();
		
	Assert.assertTrue(searchPage.displayedResultForsearchedProduct(),"error message will be displayed");
}
@Test(priority = 2)
public void varifySearchWithInvalidProduct() {
	homePage=new HomePage(driver);
	
	homePage.enteringDataInsearchBox(dataProp.getProperty("invalidProduct"));
	searchPage=homePage.clickOnsearchButton();
	
 
	String actualMessage = searchPage.invalidProductMessage();
	Assert.assertEquals(actualMessage,"abcd","no message is displyed");
	//Assert.assertEquals(actualMessage,dataProp.getProperty("noProductMsg"),"no message is displyed");
	//Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'There is no product')]")).isDisplayed());
}

@Test(priority = 3,dependsOnMethods = {"varifySearchWithInvalidProduct"})
public void verifySearchWithoutProvidingProductName() {
	homePage=new HomePage(driver);
	
	searchPage=homePage.clickOnsearchButton();
	String actualMessage = searchPage.invalidProductMessage();
Assert.assertEquals(actualMessage,dataProp.getProperty("noProductMsg"),"no message is displyed");
} 

@AfterMethod
public void tearDown() {
	driver.quit();
}
}
