package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.Car;
import com.ilcarro.qa.model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fName","lName","flName@gmail.com","nk123456"});
        list.add(new Object[]{"sima","lima","sima@gmail.com","sima12345"});
        list.add(new Object[]{"11","22","11@ww.com","tima12345"});
        list.add(new Object[]{"Kr","Kn","kr@gmail.com","kr1234567"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validUserFromCSV() throws IOException {
        List<Object[]>list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/java/resources/test_newUser.csv")));
        String line = reader.readLine();

        while(line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0]).setSecondName(split[1])
                    .setEmail(split[2]).setPassword(split[3])});
            line = reader.readLine();
        }

        return list.iterator();
    }

//    @DataProvider
//    public Iterator<Object[]> validCarFromCSV() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        BufferedReader reader = new BufferedReader(new FileReader(
//                new File("src/test/resources/addCar.csv")));
//        String line = reader.readLine();
//
//        while (line != null){
//            String[] split = line.split(",");
//            list.add(new Object[]{new Car()
//                    .setCountry(split[0])
//                    .setAddress(split[1])
//                    .setDistance(split[2])
//                    .setSerialNumber(split[3])
//                    .setBrand(split[4])
//                    .setModel(split[5])
//                    .setYear(split[6])
//                    .setEngine(split[7])
//                    .setFuelConsumption(split[8])
//                    .setFuel(split[9])
//                    .setTransmission(split[10])
//                    .setWd(split[11])
//                    .setHorsepower(split[12])
//                    .setTorque(split[13])
//                    .setDoors(split[14])
//                    .setSeats(split[15])
//                    .setClasss(split[16])
//                    .setAbout(split[17])
//                    .setFeature(split[18])
//                    .setPrice(split[19])});
//
//            line = reader.readLine();
//        }
//
//        return list.iterator();
//    }

}
