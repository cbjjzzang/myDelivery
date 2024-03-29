package com.sparta.mydelivery.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderRequestDto {

    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;
    private int x;
    private int y;
}
