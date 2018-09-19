package com.epam.jdbc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friendship {
    private UUID userId1;
    private UUID userId2;
    private Date timestamp;
}
