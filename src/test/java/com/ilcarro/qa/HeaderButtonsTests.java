package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderButtonsTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if(!isElementPresent(By.cssSelector("li a[href='/login']"))){
            wd.findElement(By.xpath("//a[contains(., 'logOut')]"));
        }
    }

    @Test
    public void testHeader(){
        click(By.cssSelector("a[href='/search']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("div.search-sidebar__form")));

        click(By.cssSelector("a[href='/car']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".let-carwork-style_lets_car_form__2fYnX")));


        click(By.cssSelector("li a[href='/login']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".signup__fields")));
    }

}
