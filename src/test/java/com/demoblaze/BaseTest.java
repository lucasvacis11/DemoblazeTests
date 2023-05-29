package com.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		this.wait  = new WebDriverWait( driver, Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		try {

			Thread.sleep(1000);
			driver.quit();
		} catch (Exception e) {

			System.out.println("Exception in tearDown method: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void assertElementPresent(By locator) {
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Assert.assertNotNull("Element not present: " + locator);
		} catch (TimeoutException e) {
			Assert.fail("Element not found within the specified wait time: " + locator);
		}
	}


}
