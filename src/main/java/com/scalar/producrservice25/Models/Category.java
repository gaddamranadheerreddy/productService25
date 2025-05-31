package com.scalar.producrservice25.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category") //This mappedBy -> can only be present in  OneToMany side.
    @JsonIgnore //Telling spring to ignore this attribute.
    List<Product> products;
}
