package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(!isSignUpTabPresentInHeader()){
            logOut();
  }
    }



    @Test
    public void testSignUp() throws InterruptedException {
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='signup__fields']")));
        pause(2000);

        fillRegistrationForm( new User()
                .setFirstName("Nik")
                .setSecondName("Nk")
                .setEmail("nk@nk.co")
                .setPassword("nk123456"));

        click(By.cssSelector("#check_policy"));
        pause(2000);
        submitForm();

        Assert.assertTrue(isLoginFormPresent());

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
