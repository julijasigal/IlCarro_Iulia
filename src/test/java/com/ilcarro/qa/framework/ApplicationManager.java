package com.ilcarro.qa.framework;

import com.ilcarro.qa.framework.CarHelper;
import com.ilcarro.qa.framework.HeaderHelper;
import com.ilcarro.qa.framework.UserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    private  String browser;
    WebDriver wd;
    UserHelper user;
    CarHelper car;
    HeaderHelper header;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public WebDriver getWd() {
        return wd;
    }

    public UserHelper getUser() {
        return user;
    }

    public CarHelper getCar() {
        return car;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");

        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        user = new UserHelper(wd);
        car = new CarHelper(wd);
        header = new HeaderHelper(wd);
    }


}
