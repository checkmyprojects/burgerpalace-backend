package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Food;
import com.bugerpalace.burgerpalacebackend.repo.FoodRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FoodServiceImpl implements FoodService{

    private final FoodRepo foodRepo;

    /*@Autowired
    public FoodService(FoodRepo foodRepo) {
        this.foodRepo = foodRepo;
    }*/

    @Override
    public Food addFood(Food food){
        return foodRepo.save(food);
    }

    @Override
    public List<Food> findAllFoods(){
        return foodRepo.findAll();
    }

    @Override
    public Food updateFood(Food food){
        return foodRepo.save(food);
    }

    @Override
    public Food findFoodById(Long id){
        return foodRepo.findFoodById(id).orElseThrow(() -> new UsernameNotFoundException("User not found in the database"));
    }

    @Override
    public void deleteFood(Long id){
        foodRepo.deleteFoodById(id);
    }
}
