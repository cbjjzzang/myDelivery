package com.sparta.mydelivery.controller;

import com.sparta.mydelivery.dto.FoodDto;
import com.sparta.mydelivery.dto.RestaurantsDto;
import com.sparta.mydelivery.models.Food;
import com.sparta.mydelivery.models.Restaurants;
import com.sparta.mydelivery.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantsController {

    private final RestaurantsService restaurantsService;

    @PostMapping("/restaurant/register")
    public Restaurants registerRestaurants(@RequestBody RestaurantsDto restaurantsDto){
        return restaurantsService.registerRestaurants(restaurantsDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurants> showRestaurants(){
        return restaurantsService.showRestaurants();
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList){
        restaurantsService.registerFood(restaurantId, foodDtoList);
    }

}
