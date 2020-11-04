package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
     if(!app.getUser().isLoginFormPresent()){
         if(!app.getUser().isUserLoggedIn()){
             app.getUser().logOut();
         }
     }
    }

    @Test
    public void logInRegisteredUserPositiveTest() throws InterruptedException {
        app.getHeader().clickLoginTabOnHeader();
        app.getUser().pause(2000);

        app.getUser().fillLogInForm(
                new User()
                        .setEmail("nk@nk.co")
                        .setPassword("nk123456"));


        app.getUser().submitForm();
        app.getUser().pause(2000);
       // Assert.assertTrue(isUserLoggedIn());
        Assert.assertTrue(app.getUser().isUserLoggedIn());
}

}
