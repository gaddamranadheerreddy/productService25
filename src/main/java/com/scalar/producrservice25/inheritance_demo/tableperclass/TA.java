package com.scalar.producrservice25.inheritance_demo.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_tas")
public class TA extends user {
    private int numberOfHR; //HR-> Help Requests
}
