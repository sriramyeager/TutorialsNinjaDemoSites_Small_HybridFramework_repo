package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	//Locators
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText="Login")
	private WebElement LoginOption;

	@FindBy(linkText = "Register")
	private WebElement RegisterOption;

	@FindBy(name = "search")
	private WebElement searchBoxField;

	@FindBy (xpath = "//button[contains(@class,'btn btn-default')]")
	private WebElement searchButton; 

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver,this);

	}


	//Actions
	public void enterProductNameSearchBoxField(String productText) {
		searchBoxField.sendKeys(productText);
	}
	public void clickOnSearchBtn() {
		searchButton.click();
	}


	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();

	}
	public void selectLoginOption() {
		LoginOption.click();
	}

	public void selectRegisterOption() {
		RegisterOption.click();
	}


}
