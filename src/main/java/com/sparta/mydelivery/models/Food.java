package com.sparta.mydelivery.models;

import com.sparta.mydelivery.dto.FoodDto;
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
    private Long Id;

    @Column
    private String name;

    @Column
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RestaurantsId")
    private Restaurants restaurants;

    public Food(FoodDto foodDto, Restaurants restaurants){
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurants = restaurants;
    }
}
