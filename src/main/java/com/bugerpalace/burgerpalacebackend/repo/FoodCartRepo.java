package com.bugerpalace.burgerpalacebackend.repo;

import com.bugerpalace.burgerpalacebackend.domain.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCartRepo extends JpaRepository<FoodCart, Long> {
}
