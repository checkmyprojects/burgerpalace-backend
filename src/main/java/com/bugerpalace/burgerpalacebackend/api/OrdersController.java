package com.bugerpalace.burgerpalacebackend.api;

import com.bugerpalace.burgerpalacebackend.domain.FoodCart;
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

    @GetMapping("/orders/{id}")
    public ResponseEntity <Orders> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ordersService.findOrderById(id));
    }

    @PostMapping("/orders/save")
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/save").toUriString());
        return ResponseEntity.created(uri).body(ordersService.addOrder(order));
    }

    @GetMapping("/orders/listFoods")
    public  ResponseEntity<List<FoodCart>> listAllItemsInCart(@RequestBody Long id){
        return ResponseEntity.ok().body(ordersService.findOrderById(id).getFoods());
    }

    // shows all order(id) foods
    @GetMapping("/orders/{id}/listFoods")
    public  ResponseEntity<List<FoodCart>> listAllItemsInCartByPath(@PathVariable Long id){
        return ResponseEntity.ok().body(ordersService.findOrderById(id).getFoods());
    }

    // add foodCart (food + quantity) to order(id)
    @PostMapping("/orders/{id}/addFoodToOrder")
    public ResponseEntity<Orders> saveOrder(@PathVariable Long id, @RequestBody FoodCart foodCart){
        Orders editOrder =  ordersService.findOrderById(id);
        editOrder.getFoods().add(foodCart);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/save").toUriString());
        return ResponseEntity.created(uri).body(ordersService.addOrder(editOrder));
    }
}
