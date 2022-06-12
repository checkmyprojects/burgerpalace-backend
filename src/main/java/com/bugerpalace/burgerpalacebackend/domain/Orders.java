package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

//@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    //@JsonManagedReference
    private Food food;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Orders() {
    }

    public Orders(Long id, int quantity, Food food, User user) {
        this.id = id;
        this.quantity = quantity;
        this.food = food;
        this.user = user;
    }

    public Orders(int quantity, Food food, User user) {
        this.quantity = quantity;
        this.food = food;
        this.user = user;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", food=" + food +
                ", user=" + user +
                '}';
    }
}
