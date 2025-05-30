package com.scalar.producrservice25.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "category") //This mappedBy -> can only be present in  OneToMany side.
    List<Product> products;
}
