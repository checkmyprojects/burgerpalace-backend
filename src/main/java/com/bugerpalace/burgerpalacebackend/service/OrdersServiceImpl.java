package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Orders;
import com.bugerpalace.burgerpalacebackend.repo.OrdersRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepo ordersRepo;

    @Override
    public Orders addOrder(Orders order) {
        return ordersRepo.save(order);
    }

    @Override
    public List<Orders> findAllOrders() {
        return ordersRepo.findAll();
    }

    @Override
    public Orders findOrderById(Long id) {
        return ordersRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("Food not found in the database"));
    }

    @Override
    public void deleteOrderById(Long id) {
        ordersRepo.deleteById(id);
    }
}
