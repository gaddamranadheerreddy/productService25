package com.scalar.producrservice25.inheritance_demo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_mentors")
public class Mentor extends user{
    private String companyName;
    private double avgRating;
}
