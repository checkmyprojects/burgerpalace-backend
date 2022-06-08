package com.bugerpalace.burgerpalacebackend.repo;

import com.bugerpalace.burgerpalacebackend.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Long> {
}
