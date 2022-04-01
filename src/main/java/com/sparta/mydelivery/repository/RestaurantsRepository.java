package com.sparta.mydelivery.repository;

import com.sparta.mydelivery.models.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {
}
