package com.demoblaze;

import com.demoblaze.Pages.CartPage;
import com.demoblaze.Pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    @Test
    public void verifyAddingProductToCart() {
        StorePage storePage = new StorePage(driver, wait);
        storePage.clickFirstProduct();
        storePage.addProductToCart();
        driver.findElement(storePage.cartNavigationButton).click();
        CartPage cartPage = new CartPage(driver, wait);
        assertElementPresent(cartPage.productNameInCart);
    }

    @Test
    public void verifyDeleteProductCart() {
        StorePage storePage = new StorePage(driver, wait);
        storePage.clickFirstProduct();
        storePage.addProductToCart();
        driver.findElement(storePage.cartNavigationButton).click();
        CartPage cartPage = new CartPage(driver, wait);
        assertElementPresent(cartPage.productNameInCart);
        cartPage.deleteProductInCart();
    }

    @Test
    public void verifyPlaceOrder() {
        StorePage storePage = new StorePage(driver, wait);
        storePage.clickFirstProduct();
        storePage.addProductToCart();
        driver.findElement(storePage.cartNavigationButton).click();
        CartPage cartPage = new CartPage(driver, wait);
        assertElementPresent(cartPage.productNameInCart);
        cartPage.placeOrder();
        assertElementPresent(cartPage.orderModal);
        cartPage.fillOrderModalWithValidData();
        assertElementPresent(cartPage.purchaseConfirmationModal);
        cartPage.clickOkButtonPurchaseModal();
    }

    @Test
    public void verifyPlaceOrderInvalidCard() {
        StorePage storePage = new StorePage(driver, wait);
        storePage.clickFirstProduct();
        storePage.addProductToCart();
        driver.findElement(storePage.cartNavigationButton).click();
        CartPage cartPage = new CartPage(driver, wait);
        assertElementPresent(cartPage.productNameInCart);
        cartPage.placeOrder();
        assertElementPresent(cartPage.orderModal);

        String alertText = cartPage.fillOrderModalWithInvalidCardData();
        Assert.assertEquals(alertText, "Please fill out Name and Creditcard.");
    }

}
