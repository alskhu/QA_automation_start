package org.example.Car;

import javax.swing.text.Caret;
import java.sql.SQLOutput;
import java.nio.charset.StandardCharsets;

public class Car implements Drivable {
    private String brand;
    private String model;
    private int year;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void drive(int distance) {
        System.out.println("Distance: " + distance + " km");

    }
}
