package com.demoblaze.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {
	
	public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public By signUpModal = By.cssSelector("//div[@id='logInModal']//div[@class='modal-content']");
	public By signUpLink = By.id( "signin2");
    public By usernameField = By.id( "sign-username");
    public By passwordField = By.id( "sign-password");
    public By signUpButton = By.xpath( "//div[@id='signInModal']/div[@role='document']//div[@class='modal-footer']/button[2]");

    public String signUp(String username, String password) {
    	doClick(signUpLink);
        doSendKeys(usernameField, username);
        doSendKeys(passwordField, password);
        doClick(signUpButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

}




