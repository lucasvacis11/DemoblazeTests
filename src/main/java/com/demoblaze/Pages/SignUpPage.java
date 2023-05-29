package com.demoblaze.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignUpPage extends BasePage {
	
	public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    By signUpModal = By.xpath("//div[@id='logInModal']//div[@class='modal-content']");
	By signUpLink = By.id( "signin2");
	By usernameField = By.id( "sign-username");
	By passwordField = By.id( "sign-password");
	By signUpButton = By.xpath( "//button[@onclick='register()']");
    

    public void signUp(String username, String password) {
    	doClick(signUpLink);
        doSendKeys(usernameField, username);
        doSendKeys(passwordField, password);
        doClick(signUpButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    }

    public void verifyAlertText (String expectedText) {
        var actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualText, expectedText);
    }


}




