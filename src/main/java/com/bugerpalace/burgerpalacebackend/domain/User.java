package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

//@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String address;
    private String username; // email
    private String phone;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy="user")
    private Set<Orders> order;

    public User() {
    }

    public User(String name, String address, String username, String phone, String password, Collection<Role> roles, Set<Orders> order) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
        this.order = order;
    }

    public User(Long id, String name, String address, String username, String phone, String password, Collection<Role> roles, Set<Orders> order) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.roles = roles;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    @JsonManagedReference
    public Set<Orders> getOrder() {
        return order;
    }

    public void setOrder(Set<Orders> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", order=" + order +
                '}';
    }
}
