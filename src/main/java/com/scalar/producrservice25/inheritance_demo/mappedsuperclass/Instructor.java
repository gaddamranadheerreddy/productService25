package com.scalar.producrservice25.inheritance_demo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_instructors")
public class Instructor extends user{
    private String specialization;
    private Double avgRating;
}
