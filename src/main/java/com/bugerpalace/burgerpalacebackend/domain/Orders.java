package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

//@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "food_orders",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"))
    //@OrderBy("id DESC")
    private Set<Food> food;

    public Orders() {
    }

    public Orders(LocalDate dateCreated, User user, Set<Food> food) {
        this.dateCreated = dateCreated;
        this.user = user;
        this.food = food;
    }

    public Orders(Long id, LocalDate dateCreated, User user, Set<Food> food) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.user = user;
        this.food = food;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
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

    public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", user=" + user +
                ", food=" + food +
                '}';
    }
}
