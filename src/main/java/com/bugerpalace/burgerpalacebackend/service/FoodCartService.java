package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.FoodCart;

import java.util.List;

public interface FoodCartService {

    FoodCart addFoodCart(FoodCart foodCart);
    List<FoodCart> findAlLFoodCarts();
    FoodCart updateFoodCart(FoodCart foodCart);
    FoodCart findFoodCartById(Long id);
    void deleteFoodCart(Long id);
}
