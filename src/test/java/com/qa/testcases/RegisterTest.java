package com.qa.testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.base;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterPage;
import com.qa.utilis.utilities;

public class RegisterTest extends base {

    public RegisterTest() {
       super();
    }

	WebDriver driver;
    @BeforeMethod
	public void setUp() {
    	
		driver = initializeBroswerAndOpenApplication(prop.getProperty("browserName"));
         HomePage homePage = new HomePage(driver);
         homePage.clickOnMyAccountDropMenu();
         homePage.selectRegisterOption();
	}

	@Test(priority = 0)
	public void verifyRegisterWithMandatoryField() {
         RegisterPage registerPage = new RegisterPage(driver);
         registerPage.enterFirstName(dataProp.getProperty("firstName"));
         registerPage.enterLastName(dataProp.getProperty("lastName"));
         registerPage.enterEmailAddress(utilities.generateEmailWithTimeStamp());
         registerPage.enterTelephoneNumber(dataProp.getProperty("Telephone"));
         registerPage.enterPassword(dataProp.getProperty("Password"));
         registerPage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
         registerPage.selectSubscribeBtn();
         registerPage.selectPrivacyPolicy();
         registerPage.selectContinueBtn();
		
		String actualSuccessMsg =driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(actualSuccessMsg ,dataProp.getProperty("accountSuccessfullyCreatedHeading"),"account success not matched");

	} 


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
