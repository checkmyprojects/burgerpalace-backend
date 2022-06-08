package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @ManyToMany (mappedBy = "food")
    @JsonIgnore
    private Set<Orders> order;

}
