package org.example.Book;

public class Book implements Displayable{
    private String name;
    private String author;
    private String year;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return this.year;
    }

    @Override
    public void display() {
        System.out.println("Book name: " + this.name);
        System.out.println("Book author: " + this.author);
        System.out.println("Book year: " + this.year);

    }
}
