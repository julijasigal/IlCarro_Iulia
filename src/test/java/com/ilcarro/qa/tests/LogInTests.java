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
        app.getUser().login();
    }



}
