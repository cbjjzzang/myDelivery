package com.sparta.mydelivery.controller;

import com.sparta.mydelivery.dto.FoodDto;
import com.sparta.mydelivery.models.Food;
import com.sparta.mydelivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;


    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList){
        foodService.registerFood(restaurantId, foodDtoList);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> showFoods(@PathVariable Long restaurantId){
        return foodService.showFoods(restaurantId);
    }
}
