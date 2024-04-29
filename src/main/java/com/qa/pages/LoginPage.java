package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;


	//locators
	@FindBy(id="input-email")
	WebElement enterEmailField;

	@FindBy(id = "input-password")
	WebElement enterPasswordField;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement loginButton;


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Actions
	public void enterEmailAddress(String emailText) {
		enterEmailField.sendKeys(emailText);

	}

	public void enterPasswordField(String PasswordField) {
		enterPasswordField.sendKeys(PasswordField);
	}
	public void clickLoginBtn() {
		loginButton.click();
	}

	//all actions in single way
	public void login(String emailText , String passwordText) {
		enterEmailField.sendKeys(emailText);
		enterPasswordField.sendKeys(passwordText);
		loginButton.click();
     return ;
	}





}
