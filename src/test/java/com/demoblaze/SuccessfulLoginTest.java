package com.demoblaze;

import org.testng.annotations.Test;
import com.demoblaze.Pages.LoginPage;
import com.demoblaze.Pages.SignUpPage;
import com.github.javafaker.Faker;


public class SuccessfulLoginTest extends BaseTest {
    @Test
    public void signUpWithValidDetails() {
        Faker faker = new Faker();
        String username = faker.name().username();
        String password = faker.internet().password();
        SignUpPage signUpPage = new SignUpPage(driver, wait);
        signUpPage.signUp(username, password);
        signUpPage.verifyAlertText("Sign up successful.");
    }

    @Test
    public void signUpWithExistingUsername() {
        SignUpPage signUpPage = new SignUpPage(driver, wait);
        signUpPage.signUp("existinguser", "testpassword");
        signUpPage.verifyAlertText("This user already exist.");
    }

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("testuser", "testpassword");
        // Add assertions to verifysuccessful login
    }



    @Test
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("____", "invalidpassword");
        // Add assertions to verify login failure
    }
	

}
