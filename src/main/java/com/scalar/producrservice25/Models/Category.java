package com.scalar.producrservice25.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseModel {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE}) //This mappedBy -> can only be present in  OneToMany side.
    //can set this to EAGER by fetch = FetchType.EAGER in the above line after cascade.
    @JsonIgnore //Telling spring to ignore this attribute.
    List<Product> products; //by default -> fetch type is LAZY for Collection Types.
}
