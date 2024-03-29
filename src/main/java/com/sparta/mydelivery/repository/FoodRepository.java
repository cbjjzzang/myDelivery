package com.sparta.mydelivery.repository;

import com.sparta.mydelivery.models.Food;
import com.sparta.mydelivery.models.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByNameAndRestaurantsId(String name, Long restaurantId);
    List<Food> findAllByRestaurantsId(Long restaurantId);

    Food findByIdAndRestaurantsId(Long Id, Long restaurantsId);
}
