package com.ilcarro.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderHelper extends HelperBase {
    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    public void isLogInButtonPresentInHeader() {
        click(By.cssSelector("li a[href='/login']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".signup__fields")));
    }

    public void clickSearchFormFromHeader() {
        click(By.cssSelector("a[href='/search']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("div.search-sidebar__form")));
    }
    public void clickLetCarWorkButtonInHeader() {
        click(By.cssSelector("a[href='/car']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".let-carwork-style_lets_car_form__2fYnX")));
    }
}
