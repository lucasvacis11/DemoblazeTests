package com.demoblaze.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "login2")
	private WebElement loginHeaderButton;

	@FindBy(id = "loginusername")
	private WebElement usernameField;

	@FindBy(id = "loginpassword")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@onclick='logIn()']")
	private WebElement loginButton;

	public void login(String username, String password) {
		loginHeaderButton.click();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
}
