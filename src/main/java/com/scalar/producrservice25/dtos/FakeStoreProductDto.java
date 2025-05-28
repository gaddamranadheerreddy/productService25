package com.scalar.producrservice25.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    //To receive tha data in the same format as in the fakestoreapi.com website
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
}
