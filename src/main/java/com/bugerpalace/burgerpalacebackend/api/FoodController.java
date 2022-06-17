package com.bugerpalace.burgerpalacebackend.api;

import com.bugerpalace.burgerpalacebackend.domain.Food;
import com.bugerpalace.burgerpalacebackend.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200/")
public class FoodController {

    private final FoodService foodService;

    /*@GetMapping("/food")
    public ResponseEntity<List<Food>> getFoods() {
        return ResponseEntity.ok().body(foodService.findAllFoods());
    }*/

    @GetMapping("/food")
    public ResponseEntity<List<Food>> getFoods(Authentication authentication) {
        if (authentication == null){
            System.out.println("user not found or invalid token");
        }else{
            String username = authentication.getPrincipal().toString();
            System.out.println(username);
        }
        System.out.println("test");
        return ResponseEntity.ok().body(foodService.findAllFoods());
    }

    @GetMapping("/food/filter/{categoryName}")
    public ResponseEntity<List<Food>> getFoodsbyCategory(@PathVariable String categoryName) {
        System.out.println(categoryName);
        return ResponseEntity.ok().body(foodService.findFoodByCategory(categoryName));
    }

    @PostMapping("/food/save")
    public ResponseEntity<Food> saveFood(@RequestBody Food food){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/food/save").toUriString());
        return ResponseEntity.created(uri).body(foodService.addFood(food));
    }

    @GetMapping("/food/{id}")
    public ResponseEntity<Food> findFoodById(@PathVariable Long id){
        return ResponseEntity.ok().body(foodService.findFoodById(id));
    }

    @DeleteMapping("/food/delete/{id}")
    public ResponseEntity<Void> deleteFoodById(@PathVariable Long id){
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/food/edit")
    public ResponseEntity<Food> editFood(@RequestBody Food food){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/food/save").toUriString());
        return ResponseEntity.created(uri).body(foodService.updateFood(food));
    }
    /*@PostMapping("/edit/add")
    public Food addFood(@RequestBody Food food){
        return foodService.addFood(food);
    }

     */

}
