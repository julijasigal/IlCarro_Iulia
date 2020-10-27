package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillCarFormTests extends TestBase{
    @Test
    public void carFormTest(){
        click(By.xpath("//ul[@class='header__nav desktop']//a[@href='/car']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("[class='let-carwork-style_lets_car_form__2fYnX']")));

        fillCarForm(new Car().setCountry("Israel").setAddress("YtzhakSade 33 ap 2").setDistance("550")
                .setSerialNumber("45485454").setBrand("Suzuki").setModel("Boleno").setYear("2016")
                .setEngine("95").setFuel("50").setFuelType("benzine").setGear("automat").setWheels("4wd")
                .setHorsepower("180").setTorque("6445451").setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("new car").setFeatures("white car").setPricePerDay("50"));

        submitForm();
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
