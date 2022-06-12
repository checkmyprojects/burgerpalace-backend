package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String ingredients;
    private boolean vegan;
    private String alergies;
    private double price;
    private String img;

    @JsonBackReference
    @OneToMany (mappedBy = "food")
//    @JsonIgnore
    private List<Orders> orders;

    public Food(String name, String type, String ingredients, boolean vegan, String alergies, double price, String img) {
        this.name = name;
        this.type = type;
        this.ingredients = ingredients;
        this.vegan = vegan;
        this.alergies = alergies;
        this.price = price;
        this.img = img;
    }
}
