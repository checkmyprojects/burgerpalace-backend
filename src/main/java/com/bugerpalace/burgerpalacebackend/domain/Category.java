package com.bugerpalace.burgerpalacebackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //@OneToMany(mappedBy = "food")
    //private List<Food> food;



}
