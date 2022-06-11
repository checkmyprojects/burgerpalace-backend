package com.bugerpalace.burgerpalacebackend.dto;

import com.bugerpalace.burgerpalacebackend.domain.Food;

public class OrderProductDto {

    private Food food;
    private Integer quantity;

    public Food getProduct() {
        return food;
    }

    public void setProduct(Food product) {
        this.food = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
