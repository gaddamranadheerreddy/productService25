package com.scalar.producrservice25.inheritance_demo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_instructors")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends user{
    private String specialization;
    private Double avgRating;
}
