package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @DataProvider
    public Iterator<Object[]>validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName","lName","flName@gmail.com","nk123456"});
        list.add(new Object[]{"sima","lima","sima@gmail.com","sima12345"});
        list.add(new Object[]{"11","22","11@ww.com","tima12345"});
        list.add(new Object[]{"Kr","Kn","kr@gmail.com","kr1234567"});

        return list.iterator();
    }

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

    @Test(dataProvider ="validUser" )
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




}
