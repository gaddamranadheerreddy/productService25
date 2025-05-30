package com.scalar.producrservice25.inheritance_demo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_tas")
public class TA extends user{
    private int numberOfHR; //HR-> Help Requests
}
