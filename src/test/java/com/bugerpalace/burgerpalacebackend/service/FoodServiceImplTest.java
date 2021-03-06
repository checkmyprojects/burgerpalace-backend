package com.bugerpalace.burgerpalacebackend.service;

import com.bugerpalace.burgerpalacebackend.domain.Food;
import com.bugerpalace.burgerpalacebackend.repo.FoodRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class FoodServiceImplTest {

    @Mock
    private FoodRepo foodRepo;

    private FoodServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new FoodServiceImpl(foodRepo);
    }

    @Test
    void addFood() {
        Food food = new Food(
                "Veggieburger",
                "burger",
                "Veggieburger",
                true,
                "none",
                12.0,
                "https://www.abomyfriend.com/wp-content/uploads/2021/11/veggie-burger_500x310px.png"
        );
        underTest.addFood(food);

        ArgumentCaptor<Food> foodArgumentCaptor =
                ArgumentCaptor.forClass(Food.class);

        verify(foodRepo).save(foodArgumentCaptor.capture());

        Food capturedFood = foodArgumentCaptor.getValue();
        assertThat(capturedFood).isEqualTo(food);

    }

    @Test
    void findAllFoods() {
        underTest.findAllFoods();
        verify(foodRepo).findAll();
    }

    @Test
    void updateFood() {
        Food food = new Food(
                "Veggieburger",
                "burger",
                "Veggieburger",
                true,
                "none",
                12.0,
                "https://www.abomyfriend.com/wp-content/uploads/2021/11/veggie-burger_500x310px.png"
        );
        underTest.updateFood(food);
        verify(foodRepo).save(food);
    }

    @Test
    void findFoodById() {
        Food food = new Food(
                1L,
                "Veggieburger",
                "burger",
                "Veggieburger",
                true,
                "none",
                12.0,
                "https://www.abomyfriend.com/wp-content/uploads/2021/11/veggie-burger_500x310px.png",
                null
        );
        //underTest.addFood(food);
        underTest.findFoodById(food.getId());
        verify(foodRepo).findFoodById(food.getId());
    }

    @Test
    void deleteFood() {
        Food food = new Food(
                1L,
                "Veggieburger",
                "burger",
                "Veggieburger",
                true,
                "none",
                12.0,
                "https://www.abomyfriend.com/wp-content/uploads/2021/11/veggie-burger_500x310px.png",
                null
        );
        //underTest.addFood(food);
        underTest.deleteFood(food.getId());
        verify(foodRepo).deleteFoodById(food.getId());
    }
}