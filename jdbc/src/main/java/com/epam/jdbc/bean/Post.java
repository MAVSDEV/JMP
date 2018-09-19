package com.epam.jdbc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private UUID id;
    private UUID userId;
    private String text;
    private Date timestamp;
}
