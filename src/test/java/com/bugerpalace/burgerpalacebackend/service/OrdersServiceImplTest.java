package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Orders;
import com.bugerpalace.burgerpalacebackend.domain.User;
import com.bugerpalace.burgerpalacebackend.repo.OrdersRepo;
import com.bugerpalace.burgerpalacebackend.domain.Food;
import com.bugerpalace.burgerpalacebackend.repo.FoodRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class OrdersServiceImplTest {
    @Mock
    private OrdersRepo ordersRepo;

    private OrdersServiceImpl underTest;

    @BeforeEach
    void setUp(){ underTest = new OrdersServiceImpl(ordersRepo);}

    @Test
    void addOrder() {
        Food food = new Food(
                "Veggieburger",
                "burger",
                "Veggieburger",
                true,
                "none",
                12.0,
                "https://www.abomyfriend.com/wp-content/uploads/2021/11/veggie-burger_500x310px.png"
        );
        User user = new User(
                null,
                "userTesting",
                "user street",
                "user@mail.com",
                "123321123",
                "password",
                new ArrayList<>(),
                null
        );

        Orders order = new Orders(
                1,
                null,
                food,
                user
        );

        underTest.addOrder(order);

        ArgumentCaptor<Orders> ordersArgumentCaptor = ArgumentCaptor.forClass(Orders.class);
        verify(ordersRepo).save(ordersArgumentCaptor.capture());

        Orders capturedOrder = ordersArgumentCaptor.getValue();

        assertThat(capturedOrder).isEqualTo(order);

    }

    @Test
    void findAllOrders() {
        underTest.findAllOrders();
        verify(ordersRepo).findAll();
    }

    @Test
    void findOrderById() {
        Food food = new Food(
                "Veggieburger",
                "burger",
                "Veggieburger",
                true,
                "none",
                12.0,
                "https://www.abomyfriend.com/wp-content/uploads/2021/11/veggie-burger_500x310px.png"
        );
        User user = new User(
                null,
                "userTesting",
                "user street",
                "user@mail.com",
                "123321123",
                "password",
                new ArrayList<>(),
                null
        );

        Orders order = new Orders(
                1,
                null,
                food,
                user
        );

        underTest.addOrder(order);


        given(ordersRepo.findById(1L)).willReturn(Optional.of(order));
        underTest.findOrderById(1L);
        verify(ordersRepo).findById(1L);

    }

    @Test
    void throwsExceptionWhenOrderNotFound() {

        given(ordersRepo.findById(1L)).willReturn(Optional.empty());

        assertThatThrownBy(() -> underTest.findOrderById(1L)).isInstanceOf(UsernameNotFoundException.class).hasMessageContaining("Food not found in the database");
    }

    @Test
    void deleteOrderById() {
        Food food = new Food(
                1L,
                "Veggieburger",
                "burger",
                "Veggieburger",
                true,
                "none",
                12.0,
                "https://www.abomyfriend.com/wp-content/uploads/2021/11/veggie-burger_500x310px.png"
        );
        underTest.deleteOrderById(food.getId());
        verify(ordersRepo).deleteById(food.getId());
    }
}