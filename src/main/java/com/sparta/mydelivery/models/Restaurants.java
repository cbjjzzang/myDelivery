package com.sparta.mydelivery.models;

import com.sparta.mydelivery.dto.RestaurantsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Getter
@NoArgsConstructor
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @Column
    private int positionX;

    @Column
    private int positionY;

    public Restaurants(RestaurantsDto restaurantsDto){
        this.name = restaurantsDto.getName();
        this.minOrderPrice = restaurantsDto.getMinOrderPrice();
        this.deliveryFee = restaurantsDto.getDeliveryFee();
        this.positionX = restaurantsDto.getPositionX();
        this.positionY = restaurantsDto.getPositionY();
    }
}
