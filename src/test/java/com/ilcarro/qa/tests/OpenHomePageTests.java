package com.ilcarro.qa.tests;

import org.testng.annotations.Test;



public class OpenHomePageTests extends TestBase {

    @Test
     public void homePageTest(){
        app.getCar().isFindCarFormPresent();

    }


}
