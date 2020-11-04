package com.ilcarro.qa.framework;

import com.ilcarro.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void clickSignUp() {
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='signup__fields']")));
    }

    public boolean isLoginFormPresent(){

        return isElementPresent(By.cssSelector(".signup__fields"));
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void logOut() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));

    }

    public void fillLogInForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickCheckPolicy() {
        click(By.cssSelector("#check_policy"));
    }

    public void login() throws InterruptedException {
        clickLoginTabOnHeader();
        pause(2000);

        fillLogInForm(
                new User()
                        .setEmail("Rm@vv.il")
                        .setPassword("Bb12345678"));


        submitForm();
        pause(2000);
        // Assert.assertTrue(isUserLoggedIn());
        //Assert.assertTrue(isUserLoggedIn());
    }

    private void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }
}





