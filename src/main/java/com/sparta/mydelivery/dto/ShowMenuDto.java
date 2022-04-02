package com.sparta.mydelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ShowMenuDto {

    private Long id;
    private String name;
    private Long price;
}
