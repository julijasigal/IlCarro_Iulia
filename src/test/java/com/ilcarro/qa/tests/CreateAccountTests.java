package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    //    @Test
//    public void negativeTestSignUpWithoutSecondName()throws InterruptedException{
//        click(By.cssSelector("[href='/signup']"));
//        Assert.assertTrue(isElementPresent(By.xpath("form.signup__fields")));
//
//        fillRegistrationForm(
//                new User()
//                .setFirstName("Nik")
//                .setEmail("nk@nk.co")
//                .setPassword("nk123456"));
//
//        click(By.cssSelector("#check_policy"));
//        pause(2000);
//        submitForm();
//
//        Assert.assertFalse(isLoginFormPresent());
//
//    }
//    @Test
//    public void negativeTestSignUpWithPasswordNumbers() throws InterruptedException {
//        click(By.cssSelector("[href='/signup']"));
//        Assert.assertTrue(isElementPresent(By.xpath("form.signup__fields")));
//
//        fillRegistrationForm(
//                new User()
//                .setFirstName("Nik")
//                .setSecondName("Nk")
//                .setEmail("nk@nk.co")
//                .setPassword("123456789"));
//
//        click(By.cssSelector("#check_policy"));
//        pause(2000);
//        submitForm();
//
//        Assert.assertFalse(isLoginFormPresent());
//
//    }


}
