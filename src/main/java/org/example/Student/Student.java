package org.example.Student;

public class Student implements Printable{
    private String name;
    private int number;
    private int average_score;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public int getNumber() {
        return this.number;
    }

    public void setAverage_score(int average_score) {
        this.average_score = average_score;
    }
    public int getAverage_score() {
       return this.average_score;
    }


    @Override
    public void print() {
        System.out.println("Name: " + getName());
        System.out.println("Number: " + getNumber());
        System.out.println("Average score: " + getAverage_score());
    }
}
