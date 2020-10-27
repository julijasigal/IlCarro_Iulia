package com.ilcarro.qa.framework;

import com.ilcarro.qa.model.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CarHelper extends HelperBase {
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isFindCarFormPresent(){
        return isElementPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw form"));

    }



    public void isCarFormPresent() {
        click(By.xpath("//ul[@class='header__nav desktop']//a[@href='/car']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='let-carwork-style_lets_car_form__2fYnX']")));
    }

    public void fillCarForm(Car car) {
        type(By.name("country"), car.getCountry());
        type(By.name("address"), car.getAddress());
        type(By.name("distance_included"), car.getDistance());
        type(By.name("serial_number"), car.getSerialNumber());
        type(By.name("make"), car.getBrand());
        type(By.name("model"), car.getModel());
        type(By.name("year"), car.getYear());
        type(By.name("engine"), car.getEngine());
        type(By.name("fuel_consumption"), car.getFuel());
        type(By.name("fuel"), car.getFuelType());
        type(By.name("gear"), car.getGear());
        type(By.name("wheels_drive"), car.getWheels());
        type(By.name("horsepower"), car.getHorsepower());
        type(By.name("torque"), car.getTorque());
        type(By.name("doors"), car.getDoors());
        type(By.name("seats"), car.getSeats());
        type(By.name("car_class"), car.getCarClass());
        type(By.name("about"), car.getAbout());
        type(By.name("features"), car.getFeatures());
        type(By.name("price_per_day"), car.getPricePerDay());
    }
}
