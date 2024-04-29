package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	//Locators
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emaliField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmField;

	@FindBy(xpath ="(//input[@name='newsletter'])[1]")
	private WebElement subscribeField;

	@FindBy(name  = "agree")
	private WebElement privacyPolicyField;

	@FindBy(xpath ="//input[@class='btn btn-primary']")
	private WebElement continueButton;

	public RegisterPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	
	//Actions
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmailAddress(String emailText) {
		emaliField.sendKeys(emailText);
	}

	public void enterTelephoneNumber(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void enterPassword(String PasswordText) {
		passwordField.sendKeys(PasswordText);
	}

	public void  enterConfirmPassword(String PasswordText) {
		confirmField.sendKeys(PasswordText);
	}

	public void selectSubscribeBtn() {
		subscribeField.click();
	}

	public void selectPrivacyPolicy() {
		privacyPolicyField.click();
	}
	public void selectContinueBtn(){
     continueButton.click();
	}





}