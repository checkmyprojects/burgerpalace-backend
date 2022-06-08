package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Food;

import java.util.List;

public interface FoodService {

    Food addFood(Food food);
    List<Food> findAllFoods();
    Food updateFood(Food food);
    Food findFoodById(Long id);
    void deleteFood(Long id);
}
