package com.scalar.producrservice25.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private int price;
    private Category category;
}
