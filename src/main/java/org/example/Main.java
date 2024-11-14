package org.example;

import org.example.Book.Book;
import org.example.Book.Displayable;
import org.example.Car.Car;
import org.example.Clock.Clock;
import org.example.Point.Point;
import org.example.Student.Student;

public class Main {
    public static void main(String[] args) {
        //1. BOOK
        Book book1 = new Book();
        //name
        book1.setName("Sunny day");
        //author
        book1.setAuthor("Almaz A.");
        //year
        book1.setYear("1998");
        book1.display();

        System.out.println();

        //2. STUDENT
        Student student1 = new Student();
        //name
        student1.setName("Alice");
        //number
        student1.setNumber(12345);
        //average_score
        student1.setAverage_score(4);
        student1.print();

        System.out.println();

        //3. POINT
        Point point1 = new Point();
        //x
        point1.setX(5);
        //y
        point1.setY(7);
        point1.moveDown();
        point1.print();

        System.out.println();

        //4. CLOCK
        Clock time1 = new Clock();
        //hour
        time1.setHour(23);
        //minute
        time1.setMinute(59);
        //sec
        time1.setSec(59);
        //add 2 sec
        time1.tick();
        time1.tick();
        time1.readTime();

        System.out.println();

        //5. CAR
        Car car1 = new Car();
        car1.setBrand("Toyota");
        car1.setModel("Camry");
        car1.setYear(2020);
        car1.start();
        car1.stop();
        car1.drive(2000);
    }
}