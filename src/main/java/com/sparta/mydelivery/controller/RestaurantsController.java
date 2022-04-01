package com.sparta.mydelivery.controller;

import com.sparta.mydelivery.dto.RestaurantsDto;
import com.sparta.mydelivery.models.Restaurants;
import com.sparta.mydelivery.repository.RestaurantsRepository;
import com.sparta.mydelivery.service.RestaurantsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestaurantsController {

    private final RestaurantsService restaurantsService;

    @PostMapping("restaurant/register")
    public Restaurants registerRestaurants(@RequestBody RestaurantsDto restaurantsDto){
        return restaurantsService.registerRestaurants(restaurantsDto);
    }
}
