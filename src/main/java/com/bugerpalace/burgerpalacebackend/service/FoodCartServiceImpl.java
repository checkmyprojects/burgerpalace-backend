/*package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.FoodCart;
import com.bugerpalace.burgerpalacebackend.repo.FoodCartRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodCartServiceImpl implements FoodCartService{


    private final FoodCartRepo foodCartRepo;

    public FoodCartServiceImpl(FoodCartRepo foodCartRepo) {
        this.foodCartRepo = foodCartRepo;
    }

    @Override
    public FoodCart addFoodCart(FoodCart foodCart) {
        return foodCartRepo.save(foodCart);
    }

    @Override
    public List<FoodCart> findAlLFoodCarts() {
        return foodCartRepo.findAll();
    }

    @Override
    public FoodCart updateFoodCart(FoodCart foodCart) {
        return foodCartRepo.save(foodCart);
    }

    @Override
    public FoodCart findFoodCartById(Long id) {
        return foodCartRepo.findById(id).orElseThrow(()-> new UsernameNotFoundException("Food not found in the database"));
    }

    @Override
    public void deleteFoodCart(Long id) {
        foodCartRepo.deleteById(id);
    }
}*/
