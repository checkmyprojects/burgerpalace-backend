/*package com.bugerpalace.burgerpalacebackend.api;

import com.bugerpalace.burgerpalacebackend.domain.Food;
import com.bugerpalace.burgerpalacebackend.domain.FoodCart;
import com.bugerpalace.burgerpalacebackend.service.FoodCartService;
import com.bugerpalace.burgerpalacebackend.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class FoodCartController {

    private final FoodCartService foodCartService;

    private final OrdersService ordersService;

    public FoodCartController(FoodCartService foodCartService, OrdersService ordersService) {
        this.foodCartService = foodCartService;
        this.ordersService = ordersService;
    }

    @GetMapping("/cart/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/cart/all")
    public ResponseEntity<List<FoodCart>> getItemInCart(){
        return ResponseEntity.ok().body(foodCartService.findAlLFoodCarts());
    }
/*
    @PostMapping("/cart/save")
    public ResponseEntity<FoodCart> createFoodCart(@RequestBody FoodCart foodCart){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/cart/save").toUriString());
        return ResponseEntity.created(uri).body(foodCartService.addFoodCart(foodCart));
    }

 */
/*
    @PostMapping("/cart/addToCart")
    public ResponseEntity<FoodCart> createFoodCartInOrder(@RequestBody FoodCart foodCart, @RequestBody Long id){
        ordersService.findOrderById(id).getFoods().add(foodCart);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/cart/addToCart").toUriString());
        return ResponseEntity.created(uri).body(foodCart);
    }
*/
//////////////////////////////////////////

    /*@PostMapping("/cart/save")
    public ResponseEntity<FoodCart> createFoodCart(@RequestParam (value = "quantity")int quantity, @RequestParam (value = "orderid")Long orderId, @RequestBody Food food){
        FoodCart foodCart = new FoodCart();
        foodCart.setQuantity(quantity);
        foodCart.setFood(food);
        foodCart.setOrder(ordersService.findOrderById(orderId));
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/cart/save").toUriString());
        return ResponseEntity.created(uri).body(foodCartService.addFoodCart(foodCart));
    }

}
*/