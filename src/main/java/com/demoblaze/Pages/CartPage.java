package com.demoblaze.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public By productNameInCart = By.xpath("//tbody[@id='tbodyid']//td[.='Samsung galaxy s6']");
    public By deleteProductButton = By.linkText("Delete");
    public By placeOrderbutton = By.xpath("/html//div[@id='page-wrapper']//button[@type='button']");
    public By orderModal = By.className("modal-body");
    public By nameField = By.id("name");
    public By countryField = By.id("country");
    public By cityField = By.id("city");
    public By cardField = By.id("card");
    public By monthField = By.id("month");
    public By yearField = By.id("year");
    public By purchaseButton = By.xpath("//div[@id='orderModal']/div[@role='document']//div[@class='modal-footer']/button[2]");
    public By purchaseConfirmationModal = By.xpath("/html/body/div[10]");
    public By okButtonPurchaseModal = By.xpath("/html/body/div[10]//button[.='OK']");
    public void deleteProductInCart() {
        doClick(deleteProductButton);
    }

    public void placeOrder() {
        doClick(placeOrderbutton);
    }

    public void fillOrderModalWithValidData() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String country = faker.address().country();
        String city = faker.address().city();
        String card = faker.finance().creditCard();
        String month = String.valueOf(faker.number().numberBetween(1, 12));
        String year = String.valueOf(faker.number().numberBetween(2023, 2030));

        doSendKeys(nameField, name);
        doSendKeys(countryField, country);
        doSendKeys(cityField, city);
        doSendKeys(cardField, card);
        doSendKeys(monthField, month);
        doSendKeys(yearField, year);
        doClick(purchaseButton);
    }

    public String fillOrderModalWithInvalidCardData() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String country = faker.address().country();
        String city = faker.address().city();
        String month = String.valueOf(faker.number().numberBetween(1, 12));
        String year = String.valueOf(faker.number().numberBetween(2023, 2030));

        doSendKeys(nameField, name);
        doSendKeys(countryField, country);
        doSendKeys(cityField, city);
        doSendKeys(monthField, month);
        doSendKeys(yearField, year);
        doClick(purchaseButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;

    }

    public void clickOkButtonPurchaseModal() {
        doClick(okButtonPurchaseModal);
    }

}
