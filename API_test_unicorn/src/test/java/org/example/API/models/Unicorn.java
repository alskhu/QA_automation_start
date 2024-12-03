package org.example.API.models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Data
public class Unicorn {
    private String name;
    private String color;
}
