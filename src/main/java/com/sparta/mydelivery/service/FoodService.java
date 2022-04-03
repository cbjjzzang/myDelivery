package com.sparta.mydelivery.service;

import com.sparta.mydelivery.dto.FoodDto;
import com.sparta.mydelivery.models.Food;
import com.sparta.mydelivery.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {


    private final FoodRepository foodRepository;


    @Transactional
    public void registerFood(Long restaurantId, List<FoodDto> foodDtoList) {
        HashSet<String> foods= new HashSet<>();
        for(FoodDto food : foodDtoList){
            foods.add(food.getName());
        }
        if(foods.size() != foodDtoList.size()) throw new IllegalArgumentException("동일한 메뉴는 하나만 등록이 가능합니다.");
        if(exsistMenu(foodDtoList, restaurantId)) throw new IllegalArgumentException("이미 음식점에 동일한 메뉴가 있습니다.");

        for(FoodDto menu : foodDtoList){
            Food food = new Food(menu, restaurantId);
            if(food.getPrice() < 100 || food.getPrice() > 1000000) throw new IllegalArgumentException("가격은 100원 ~ 1,000,000원 까지 입니다.");
            if(food.getPrice() % 100 != 0) throw new IllegalArgumentException("100원 단위로 가격을 입력해 주세요.");
            foodRepository.save(food);
        }
    }

    @Transactional
    public List<Food> showFoods(Long restaurantId) {
        return foodRepository.findAllByRestaurantsId(restaurantId);
    }

    public boolean exsistMenu(List<FoodDto> newMenu, Long restaurantId){
        for (FoodDto newFood : newMenu) {
            if (foodRepository.existsByNameAndRestaurantsId(newFood.getName(), restaurantId))
                return true;
        }
        return false;

    }
}
