package com._dFilamentManager._dFilamentManager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "filaments")
public class Filament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double grams;

    private Double price;

    private String material;

    private String color;

    private String img;
}
