package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.Objects;

@Entity
public class OrderProduct {

    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(nullable = false)
    private Integer quantity;

    public OrderProduct() {
    }

    public OrderProduct(OrderProductPK pk, Integer quantity) {
        this.pk = pk;
        this.quantity = quantity;
    }

    public OrderProduct(Orders order, Food food, Integer quantity) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setFood(food);
        this.quantity = quantity;
    }
    @Transient
    public Food getProduct() {
        return this.pk.getFood();
    }
    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProduct)) return false;
        OrderProduct that = (OrderProduct) o;
        return getPk().equals(that.getPk()) && getQuantity().equals(that.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPk(), getQuantity());
    }
}
