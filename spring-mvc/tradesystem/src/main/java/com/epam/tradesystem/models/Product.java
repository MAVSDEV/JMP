package com.epam.tradesystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@Data
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String productId;
    private String name;
    private BigDecimal unitPrice;
    private boolean isOrdered;
    private String deliveryStatus;
}
