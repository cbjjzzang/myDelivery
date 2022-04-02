package com.sparta.mydelivery.models;

import com.sparta.mydelivery.dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private int price;

    @ManyToOne
    @JoinColumn
    private OrderList orderList;

    public FoodOrder(FoodOrderDto foodOrderDto){
        this.name = foodOrderDto.getName();
        this.quantity = foodOrderDto.getQuantity();
        this.price = foodOrderDto.getPrice();
    }
}
