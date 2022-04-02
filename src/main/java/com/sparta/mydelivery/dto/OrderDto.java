package com.sparta.mydelivery.dto;

import com.sparta.mydelivery.models.FoodOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrder> foods;
    private int deliveryFee;
    private int totalPrice;
}
