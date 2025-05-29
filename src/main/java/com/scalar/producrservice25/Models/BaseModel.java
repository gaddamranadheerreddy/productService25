package com.scalar.producrservice25.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id //telling Id is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto Increments the Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
