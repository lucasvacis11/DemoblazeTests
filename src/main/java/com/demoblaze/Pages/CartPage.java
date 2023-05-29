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

    public By productNameInCart = By.xpath("//body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");
    public By deleteProductButton = By.xpath("/html//tbody[@id='tbodyid']//a[@href='#']");
    public By placeOrderbutton = By.xpath("/html//div[@id='page-wrapper']//button[@type='button']");
    public By orderModal = By.xpath("//div[@id='orderModal']/div[@role='document']//div[@class='modal-body']");
    public By nameField = By.xpath("/html//input[@id='name']");
    public By countryField = By.xpath("/html//input[@id='country']");
    public By cityField = By.xpath("/html//input[@id='city']");
    public By cardField = By.xpath("/html//input[@id='card']");
    public By monthField = By.xpath("/html//input[@id='month']");
    public By yearField = By.xpath("/html//input[@id='year']");
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
