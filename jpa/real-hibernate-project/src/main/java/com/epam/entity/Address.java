package com.epam.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    @Column(name = "city")
    private String city;
    @Column(name = "title")
    private String title;
}
