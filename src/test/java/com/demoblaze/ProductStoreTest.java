package com.demoblaze;

import com.demoblaze.Pages.StorePage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductStoreTest extends BaseTest {

    @Test
    public void verifyGetItemsCategory() {
        String[] categories = {"notebook", "phone", "monitor"};

        for (String category : categories) {
            String payload = String.format("{\"cat\":\"%s\"}", category);

            Response response = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .post("https://api.demoblaze.com/bycat");

            Assert.assertEquals(response.statusCode(), 200);
        }

    }

    @Test
    public void verifyProductSelection() {
        StorePage storePage = new StorePage(driver, wait);
        storePage.clickFirstProduct();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("prod"));
    }


}