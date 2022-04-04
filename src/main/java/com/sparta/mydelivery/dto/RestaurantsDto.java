package com.sparta.mydelivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RestaurantsDto {
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
    private int positionX;
    private int positionY;
}
