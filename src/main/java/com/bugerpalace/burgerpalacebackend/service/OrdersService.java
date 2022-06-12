package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Orders;

import java.util.List;

public interface OrdersService {

    Orders addOrder(Orders order);
    List<Orders> findAllOrders();
    Orders findOrderById(Long id);
    void deleteOrderById(Long id);
}
