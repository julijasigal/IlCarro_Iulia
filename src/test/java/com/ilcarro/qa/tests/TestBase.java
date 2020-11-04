package com.ilcarro.qa.tests;

import com.ilcarro.qa.framework.ApplicationManager;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m,Object[] p) {

        logger.info("Start Test " + m.getName()+"with data : " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {
        if(result.isSuccess()){
            logger.info("PASSED: Test method " + result.getMethod().getMethodName());
        }else{
            logger.error("FILED: Test method " + result.getMethod().getMethodName()+"\n"
            +"Screenshot: " +app.getUser().takeScreenshot());
            //logger.info("Screenshot: " +app.getUser().takeScreenshot());

        }
        logger.info("Stop Test " );
        logger.info("===========================");
    }


    @AfterSuite(enabled = false)
    public void tearDown() {
        app.getCar().stop();
    }






}

