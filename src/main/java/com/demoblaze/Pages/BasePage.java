package com.demoblaze.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait  = new WebDriverWait( driver, Duration.ofSeconds(20));
	}
	
	public void doClick(By locator) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
	}
	
	public void doSendKeys(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}
	
	public String doGetText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}
	
}
