package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {



    @BeforeMethod
    public void ensurePreconditions(){
        if(!app.getHeader().isSignUpTabPresentInHeader()){
            app.getUser().logOut();
  }
    }



    @Test
    public void testSignUp() throws InterruptedException {
        app.getUser().clickSignUp();
        app.getCar().pause(2000);

        app.getUser().fillRegistrationForm( new User()
                .setFirstName("Nik")
                .setSecondName("Nk")
                .setEmail("nk@nk.co")
                .setPassword("nk123456"));

        app.getUser().clickCheckPolicy();
        app.getCar().pause(2000);
        app.getUser().submitForm();

        Assert.assertTrue(app.getUser().isLoginFormPresent());

    }

    @Test(enabled = false,dataProvider ="validUser", dataProviderClass = DataProviders.class )
    public void testSignUpFromDataProvider(String FirstName,String SecondName, String Email, String Password) throws InterruptedException {
        app.getUser().clickSignUp();
        app.getCar().pause(2000);

        app.getUser().fillRegistrationForm( new User()
                .setFirstName(FirstName)
                .setSecondName(SecondName)
                .setEmail(Email)
                .setPassword(Password));

        app.getUser().clickCheckPolicy();
        app.getCar().pause(2000);
        app.getUser().submitForm();

        logger.info("Login form present. actual result : "
                + app.getUser().isLoginFormPresent()+ "expected result is: true");
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        
    }

    @Test(enabled = false,dataProvider ="validUserFromCSV" , dataProviderClass = DataProviders.class)
    public void testSignUpFromCSVDataProvider(
            User user) throws InterruptedException {
        app.getUser().clickSignUp();
        app.getCar().pause(2000);

        app.getUser().fillRegistrationForm(user);

        app.getUser().clickCheckPolicy();
        app.getCar().pause(2000);
        app.getUser().submitForm();

        logger.info("Login form present. actual result : "
                + app.getUser().isLoginFormPresent()+ "expected result is: true");
        Assert.assertTrue(app.getUser().isLoginFormPresent());

    }




}
