package com.scalar.producrservice25.inheritance_demo.joinedtable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_users")
@Inheritance(strategy = InheritanceType.JOINED)
public class user {
    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
}
