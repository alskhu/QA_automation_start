package org.example.API.models;

public class Unicorn {
    private String name;
    private String color;

    public Unicorn(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String toJson() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"color\": \"" + color + "\"\n" +
                "}";
    }
}
