package com.bugerpalace.burgerpalacebackend.api;

import com.bugerpalace.burgerpalacebackend.domain.Food;
import com.bugerpalace.burgerpalacebackend.service.FoodService;
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
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/food")
    public ResponseEntity<List<Food>> getFoods() {
        return ResponseEntity.ok().body(foodService.findAllFoods());
    }

    @PostMapping("/food/save")
    public ResponseEntity<Food> saveFood(@RequestBody Food food){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/food/save").toUriString());
        return ResponseEntity.created(uri).body(foodService.addFood(food));
    }

}
