package com.demoblaze.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StorePage extends BasePage {

    public StorePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public By firstProduct = By.xpath("//div[@id='tbodyid']/div[1]/div[@class='card h-100']/a[@href='prod.html?idp_=1']/img");

    public By addToCartButton = By.linkText("Add to cart");

    public By cartNavigationButton = By.id("cartur");


    public void clickFirstProduct() {
        doClick(firstProduct);
    }

    public void addProductToCart() {
        doClick(addToCartButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

}
