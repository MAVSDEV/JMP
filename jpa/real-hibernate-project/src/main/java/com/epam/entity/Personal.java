package com.epam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Personal {

    @Column
    private String idCard;
}
