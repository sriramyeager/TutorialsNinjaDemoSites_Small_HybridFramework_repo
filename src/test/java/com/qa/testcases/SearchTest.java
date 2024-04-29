package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.base;
import com.qa.pages.HomePage;

public class SearchTest extends base {

	public SearchTest() {
		super();
	}    	 

	WebDriver driver;
	HomePage homePage;
	@BeforeMethod
	public void setUp() {
		driver = initializeBroswerAndOpenApplication(prop.getProperty("browserName"));
	}

	@Test(priority = 0)
	public void verifySearchWithValidProduct () {
		homePage = new HomePage(driver);
		homePage.enterProductNameSearchBoxField(dataProp.getProperty("validProduct"));
		homePage.clickOnSearchBtn();

		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Valid product Hp is not displayed");
	}
	@Test(priority = 1)
	public void verifySearchWithInValidProduct () {
		homePage= new HomePage(driver);
		homePage.enterProductNameSearchBoxField(dataProp.getProperty("invalidProduct"));
		homePage.clickOnSearchBtn();

		String actualMsg = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(actualMsg,dataProp.getProperty("noProductTextInSearch"),"there is no product that matches the search criteria");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}