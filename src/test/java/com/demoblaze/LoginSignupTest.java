package com.demoblaze;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.demoblaze.Pages.LoginPage;
import com.demoblaze.Pages.SignUpPage;
import com.github.javafaker.Faker;


public class LoginSignupTest extends BaseTest {
    private Faker faker;
    private String username;
    private String password;

    @BeforeClass
    public void setupSignUpPage() {
        faker = new Faker();
        username = faker.name().username();
        password = faker.internet().password();
    }

    @Test(priority=1)
    public void signUpWithValidDetails() {
        SignUpPage signUpPage = new SignUpPage(driver, wait);
        String alertText = signUpPage.signUp(username, password);
        Assert.assertEquals(alertText, "Sign up successful.");
    }

    @Test(priority=2)
    public void signUpWithExistingUsername() {
        SignUpPage signUpPage = new SignUpPage(driver, wait);
        String alertText = signUpPage.signUp(username, password);
        Assert.assertEquals(alertText, "This user already exist.");
    }

    @Test(priority=3)
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(username, password);
        assertElementPresent(loginPage.logOutButton);
    }

    @Test(priority=4)
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login(username, "invalidpassword");
        String alertText = loginPage.verifyUserExistAlert();
        Assert.assertEquals(alertText, "Wrong password.");
    }

}
