package com.sparta.mydelivery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {
    private String name;
    private int quantity;
    private int price;
}
