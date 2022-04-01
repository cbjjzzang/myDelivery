package com.sparta.mydelivery.service;

import com.sparta.mydelivery.dto.FoodDto;
import com.sparta.mydelivery.dto.RestaurantsDto;
import com.sparta.mydelivery.models.Food;
import com.sparta.mydelivery.models.Restaurants;
import com.sparta.mydelivery.repository.FoodRepository;
import com.sparta.mydelivery.repository.RestaurantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantsService {

    private final FoodRepository foodRepository;
    private final RestaurantsRepository restaurantsRepository;

    public Restaurants registerRestaurants(RestaurantsDto restaurantsDto) {
        if(restaurantsDto.getMinOrderPrice() < 1000 || restaurantsDto.getMinOrderPrice() > 100000) throw new IllegalArgumentException("주문금액은 1000원 이상 100000원 미만입니다.");
        if(restaurantsDto.getMinOrderPrice() % 100 != 0) throw new IllegalArgumentException("100원 단위만 입력해주세요.");
        if(restaurantsDto.getDeliveryFee() < 0 || restaurantsDto.getDeliveryFee() > 10000) throw new IllegalArgumentException("배달비는 10000원 이하 입니다.");
        if(restaurantsDto.getDeliveryFee() % 500 != 0) throw new IllegalArgumentException("배달비는 500원 단위로 입력해주세요.");
        Restaurants restaurants = new Restaurants(restaurantsDto);
        return restaurantsRepository.save(restaurants);
    }

    public List<Restaurants> showRestaurants() {
        return restaurantsRepository.findAll();
    }

    @Transactional
    public void registerFood(Long restaurantId, List<FoodDto> foodDtoList) {
        Restaurants restaurants = restaurantsRepository.findById(restaurantId).orElseThrow( () -> new NullPointerException("음식점이 존재하지 않습니다."));
        HashSet<String> foods= new HashSet<>();
        for(FoodDto food : foodDtoList){
            foods.add(food.getName());
        }
        if(foods.size() != foodDtoList.size()) throw new IllegalArgumentException("동일한 메뉴는 하나만 등록이 가능합니다.");
        if(exsistMenu(foodDtoList, restaurants)) throw new IllegalArgumentException("이미 음식점에 동일한 메뉴가 있습니다.");

        for(FoodDto menu : foodDtoList){
            Food food = new Food(menu, restaurants);
            if(food.getPrice() < 100 || food.getPrice() > 1000000) throw new IllegalArgumentException("가격은 100원 ~ 1,000,000원 까지 입니다.");
            if(food.getPrice() % 100 != 0) throw new IllegalArgumentException("100원 단위로 가격을 입력해 주세요.");
            foodRepository.save(food);
        }
    }


    public boolean exsistMenu(List<FoodDto> newMenu, Restaurants restaurants) {
        for (FoodDto newfood : newMenu) {
            if (foodRepository.existsByNameAndRestaurants(newfood.getName(), restaurants))
                return true;
        }
        return false;

    }


}
