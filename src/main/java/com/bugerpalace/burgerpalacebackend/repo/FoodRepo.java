package com.bugerpalace.burgerpalacebackend.repo;

import com.bugerpalace.burgerpalacebackend.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepo extends JpaRepository<Food, Long> {

    void deleteFoodById(Long id);

    Optional<Food> findFoodById(Long id);
}
