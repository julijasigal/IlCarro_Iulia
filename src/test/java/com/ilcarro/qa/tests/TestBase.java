package com.ilcarro.qa.tests;

import com.ilcarro.qa.framework.ApplicationManager;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class TestBase {


    protected static ApplicationManager app = new ApplicationManager(System.getProperty( "browser", BrowserType.CHROME));
  Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m) {
        logger.info("Start Test " + m.getName());
    }

    @AfterMethod
    public void stopTest(Method m) {
        logger.info("Stop Test " + m.getName());
        logger.info("------------------------------------------------");
    }


    @AfterSuite(enabled = false)
    public void tearDown() {
        app.getCar().stop();
    }




}

