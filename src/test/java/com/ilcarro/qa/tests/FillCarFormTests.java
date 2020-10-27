package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.Car;
import org.testng.annotations.Test;

public class FillCarFormTests extends TestBase {
    @Test
    public void carFormTest(){
        app.getCar().isCarFormPresent();

        app.getCar().fillCarForm(new Car().setCountry("Israel").setAddress("YtzhakSade 33 ap 2").setDistance("550")
                .setSerialNumber("45485454").setBrand("Suzuki").setModel("Boleno").setYear("2016")
                .setEngine("95").setFuel("50").setFuelType("benzine").setGear("automat").setWheels("4wd")
                .setHorsepower("180").setTorque("6445451").setDoors("5").setSeats("5").setCarClass("C")
                .setAbout("new car").setFeatures("white car").setPricePerDay("50"));

        app.getCar().submitForm();
    }

}
