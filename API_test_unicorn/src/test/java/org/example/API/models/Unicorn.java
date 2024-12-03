package org.example.API.models;

import com.google.gson.annotations.SerializedName;

public class Unicorn {
    private String name;
    private String color;
    @SerializedName("_id")
    private String id;

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

    public String getId() {
        return id;
    }
}
