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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonManagedReference
    @OneToMany (mappedBy = "order")
    private List<FoodCart> foods;

    public Orders() {
    }

    public Orders(User user, List<FoodCart> foods) {
        this.user = user;
        this.foods = foods;
    }

    public Orders(Long id, User user, List<FoodCart> foods) {
        this.id = id;
        this.user = user;
        this.foods = foods;
    }

    public List<FoodCart> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodCart> foods) {
        this.foods = foods;
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
                ", user=" + user +
                ", foods=" + foods +
                '}';
    }
}
