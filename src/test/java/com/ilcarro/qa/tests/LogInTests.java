package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
     if(!app.getUser().isLoginFormPresent()){
         app.getCar().pause(2000);
         if(!app.getUser().isUserLoggedIn()){
             app.getUser().logOut();
         }
         app.getCar().pause(2000);
         app.getHeader().clickLoginTabOnHeader();
     }
    }

    @Test
    public void logInRegisteredUserPositiveTest(){
        app.getHeader().clickLoginTabOnHeader();

        app.getUser().fillLogInForm(
                new User()
                        .setEmail("nk@nk.co")
                        .setPassword("nk123456"));


        app.getUser().submitForm();
       // Assert.assertTrue(isUserLoggedIn());
}

}
