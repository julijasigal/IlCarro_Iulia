package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LogInTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
     if(!isLoginFormPresent()){
         if(!isUserLoggedIn()){
             logOut();
         }
         pause(2000);
         clickLoginTabOnHeader();
     }
    }

    @Test
    public void logInRegisteredUserPositiveTest(){
        clickLoginTabOnHeader();
        fillLogInForm(
                new User()
                        .setEmail("nk@nk.co")
                        .setPassword("nk123456"));

        submitForm();
       // Assert.assertTrue(isUserLoggedIn());
}

}
