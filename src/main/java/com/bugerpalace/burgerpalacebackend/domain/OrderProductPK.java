package com.bugerpalace.burgerpalacebackend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderProductPK implements Serializable {
    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public OrderProductPK() {
    }

    public OrderProductPK(Orders order, Food food) {
        this.order = order;
        this.food = food;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProductPK)) return false;
        OrderProductPK that = (OrderProductPK) o;
        return getOrder().equals(that.getOrder()) && getFood().equals(that.getFood());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getFood());
    }

    @Override
    public String toString() {
        return "OrderProductPK{" +
                "order=" + order +
                ", food=" + food +
                '}';
    }
}
