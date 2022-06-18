package com.bugerpalace.burgerpalacebackend.api;

//import com.bugerpalace.burgerpalacebackend.domain.FoodCart;
import com.bugerpalace.burgerpalacebackend.domain.Food;
import com.bugerpalace.burgerpalacebackend.domain.ItemToPurchase;
import com.bugerpalace.burgerpalacebackend.domain.Orders;
import com.bugerpalace.burgerpalacebackend.domain.User;
import com.bugerpalace.burgerpalacebackend.service.FoodService;
import com.bugerpalace.burgerpalacebackend.service.OrdersService;
import com.bugerpalace.burgerpalacebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class OrdersController {

    private final OrdersService ordersService;

    private final UserService userService;

    private final FoodService foodService;

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getOrders() {
        return ResponseEntity.ok().body(ordersService.findAllOrders());
    }
/*
    @GetMapping("/orders/{id}")
    public ResponseEntity <Orders> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok().body(ordersService.findOrderById(id));
    }
*/
    // Get all items in user(id) cart
    @GetMapping("/orders/{id}")
    public ResponseEntity <List<Orders>> getOrderByUserId(@PathVariable Long id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok().body(user.getOrder());
    }
    /*
    @PostMapping("/orders/save")
    public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/save").toUriString());
        return ResponseEntity.created(uri).body(ordersService.addOrder(order));
    }
     */

    /*@PostMapping("/orders/{id}/save")
    public ResponseEntity<Orders> saveOrder(@PathVariable Long id,@RequestParam (value = "quantity")int quantity, @RequestBody Food food){
        Orders order = new Orders();
        order.setQuantity(quantity);
        order.setFood(food);
        order.setUser(userService.findUserById(id));
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/save").toUriString());
        return ResponseEntity.created(uri).body(ordersService.addOrder(order));
    }*/

    // Add item to user(id) cart. Need to sent quantity and foodid as parameter
    // example localhost:8080/api/orders/3/save?quantity=2&foodid=10

    /*@PostMapping("/orders/{id}/save")
    public ResponseEntity<Orders> saveOrder(@PathVariable Long id,@RequestParam (value = "quantity")int quantity, @RequestParam (value = "foodid")Long foodId){
        Orders order = new Orders();
        order.setQuantity(quantity);
        order.setFood(foodService.findFoodById(foodId));
        order.setUser(userService.findUserById(id));
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/{id}/save").toUriString());
        return ResponseEntity.created(uri).body(ordersService.addOrder(order));
    }*/
/*
@PostMapping("/orders/{user_id}/checkout")
    public ResponseEntity<List<Orders>> checkout(@PathVariable Long user_id, @RequestBody List<ItemToPurchase> items){

        System.out.println(items);
        System.out.println("Starting to build Items");
        //Generate uuid for all item in this order
        UUID uuid = UUID.randomUUID();
        items.forEach((product) -> {
            Orders order = new Orders();
            order.setFood(foodService.findFoodById(product.getFood().getId()));
            order.setQuantity(product.getQuantity());
            order.setUser(userService.findUserById(user_id));
            order.setUuid(uuid);
            ordersService.addOrder(order);
            // saveall en el repo para guardar todo
        });
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/{id}/checkout").toUriString());
        return ResponseEntity.created(uri).build();
    }
 */

    @PostMapping("/orders/checkout")
    public ResponseEntity<List<Orders>> checkout(Authentication authentication, @RequestBody List<ItemToPurchase> items){

        System.out.println("Starting to build Items");
        //Generate uuid for all item in this order
        User user = userService.findByUsername(authentication.getPrincipal().toString());
        System.out.println("Current order for user: " + user.getName());
        UUID uuid = UUID.randomUUID();
        items.forEach((product) -> {
            Orders order = new Orders();
            order.setFood(foodService.findFoodById(product.getFood().getId()));
            order.setQuantity(product.getQuantity());
            order.setUser(user);
            order.setUuid(uuid);
            ordersService.addOrder(order);
            // saveall in the repo is better todo
        });
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/orders/{id}/checkout").toUriString());
        return ResponseEntity.created(uri).build();
    }


    //UUID uuid = UUID.randomUUID();
    /*
    userId: 1,
    [
        {
            foodId: 1,
            quantity: 2
        },
        {
            foodId: 2,
            quantity: 1
        },
    ]
    UUID = generar el UUID
    foreach {
        Orders order = new Orders();
        order.setUUID = UUID
        order.setQuantity(quantity);
        order.setFood(foodService.findFoodById(foodId));
        order.setUser(userService.findUserById(id));
        order.setStatus("PAGADO")
    }



     */

    // Reset all food items in user(id)
    /*
    @GetMapping("/orders/{id}/purchase")
    public ResponseEntity <Void> resetItemsFromUser(@PathVariable Long id) {
        User user = userService.findUserById(id);
        user.setOrder(new ArrayList<>());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orders/{id}/deleteall")
    public ResponseEntity <Void> deleteAllItemsFromUser(@PathVariable Long id){
        User user = userService.findUserById(id);
        List<Orders> orders = user.getOrder();
        orders.forEach((singleOrder) -> ordersService.deleteOrderById(singleOrder.getId()));
        return ResponseEntity.noContent().build();
    }*/
}
