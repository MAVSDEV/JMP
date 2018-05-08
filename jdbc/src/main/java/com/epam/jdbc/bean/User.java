package com.epam.jdbc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private UUID id;
    private String name;
    private String surname;
    private Date birthdate;
}
