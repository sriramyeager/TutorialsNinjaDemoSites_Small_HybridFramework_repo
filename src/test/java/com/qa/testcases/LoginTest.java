package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginTest extends base {

	public LoginTest() {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initializeBroswerAndOpenApplication(prop.getProperty("browserName"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		homepage.selectLoginOption();

	}
	@Test(priority=0)
	public void verifyWithValidCredentials() {

		/*loginPage.enterEmailAddress(prop.getProperty("ValidEmail"));
		loginPage.enterPasswordField(prop.getProperty("ValidPassword"));
		loginPage.clickLoginBtn();*/

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("ValidEmail"), prop.getProperty("ValidPassword"));


		String actuslMsg = driver.findElement(By.linkText("Edit your account information")).getText();
		Assert.assertEquals(actuslMsg, dataProp.getProperty("editYourAccountIsDisplayed"),"edit your account not matched");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}




}
