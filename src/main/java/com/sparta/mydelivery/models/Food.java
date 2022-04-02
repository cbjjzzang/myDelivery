package com.sparta.mydelivery.models;

import com.sparta.mydelivery.dto.FoodDto;
import lombok.CustomLog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private Long restaurantsId;

    public Food(FoodDto foodDto, Long restaurantsId){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurantsId = restaurantsId;
    }
}
