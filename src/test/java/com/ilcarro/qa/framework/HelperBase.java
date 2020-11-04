package com.ilcarro.qa.framework;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class HelperBase {
     WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator){

        return wd.findElements(locator).size()>0;
    }

    public void click(By locator){
        wd.findElement(locator).click();

    }

    public void submitForm() {
        new WebDriverWait(wd,15)
                .until(ExpectedConditions
                        .elementToBeClickable(By.cssSelector("[type='submit']"))).click();
        //click(By.cssSelector("[type='submit']"));
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
    public void stop() {
        wd.quit();
    }

    public String takeScreenshot(){
        File tmp =( (TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot" + System.currentTimeMillis()+".png");
        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
