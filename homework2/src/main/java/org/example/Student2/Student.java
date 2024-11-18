package org.example.Student2;

public class Student {
    private String name;
    private String id;

    public Student() {
        this.name = "unknown";
        this.id = "unknown";
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name) {
        this.name = name;
        this.id = "id_" + name;
    }


    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
