package com._dFilamentManager._dFilamentManager.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class FilamentDTO {
    private Long id;

    private String name;

    private Double grams;

    private Double price;

    private String material;

    private String color;

    private String img;
}
