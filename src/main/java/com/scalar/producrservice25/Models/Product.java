package com.scalar.producrservice25.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private double price;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //can set this to LAZY by fetch = FetchType.LAZY in the above line after cascade.
    private Category category; //By default, the fetch type is EAGER for Non-Collection Types.
}
