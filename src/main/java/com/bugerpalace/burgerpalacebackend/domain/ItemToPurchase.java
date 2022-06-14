package com.bugerpalace.burgerpalacebackend.domain;

public class ItemToPurchase {

    private Long food_id;
    private int quantity;

    public ItemToPurchase() {
    }

    public ItemToPurchase(Long food_id, int quantity) {
        this.food_id = food_id;
        this.quantity = quantity;
    }

    public Long getFood_id() {
        return food_id;
    }

    public void setFood_id(Long food_id) {
        this.food_id = food_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
