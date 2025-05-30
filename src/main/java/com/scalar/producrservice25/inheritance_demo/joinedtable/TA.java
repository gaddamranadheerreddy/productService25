package com.scalar.producrservice25.inheritance_demo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_tas")
@PrimaryKeyJoinColumn(name="user_id")
public class TA extends user {
    private int numberOfHR; //HR-> Help Requests
}
