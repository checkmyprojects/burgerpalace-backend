package com.bugerpalace.burgerpalacebackend.api;

import com.bugerpalace.burgerpalacebackend.domain.Orders;
import com.bugerpalace.burgerpalacebackend.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class OrdersController {

    private final OrdersService ordersService;

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getOrders() {
        return ResponseEntity.ok().body(ordersService.findAllOrders());
    }

    @GetMapping("/orders/save")
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/food/save").toUriString());
        return ResponseEntity.created(uri).body(ordersService.addOrder(order));
    }
}
