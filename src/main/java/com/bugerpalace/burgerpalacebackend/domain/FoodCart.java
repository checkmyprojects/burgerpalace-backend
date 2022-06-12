package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="food_cart")
public class FoodCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;


    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    //@JsonManagedReference
    private Food food;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Orders order;

    public FoodCart() {
    }

    public FoodCart(Long id, int quantity, Food food, Orders order) {
        this.id = id;
        this.quantity = quantity;
        this.food = food;
        this.order = order;
    }

    public FoodCart(int quantity, Food food, Orders order) {
        this.quantity = quantity;
        this.food = food;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "FoodCart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", food=" + food +
                ", order=" + order +
                '}';
    }
}
