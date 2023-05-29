package com.demoblaze.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public By loginHeaderButton = By.xpath("/html//a[@id='login2']");

	public By usernameField = By.xpath("/html//input[@id='loginusername']");

	public By passwordField = By.xpath("/html//input[@id='loginpassword']");

	public By loginButton = By.xpath("//div[@id='logInModal']/div[@role='document']//div[@class='modal-footer']/button[2]");

	public By logOutButton = By.xpath("/html//a[@id='logout2']");

	public void login(String username, String password) {
		doClick(loginHeaderButton);
		doSendKeys(usernameField, username);
		doSendKeys(passwordField, password);
		doClick(loginButton);
	}

	public String verifyUserExistAlert() {
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}
}
