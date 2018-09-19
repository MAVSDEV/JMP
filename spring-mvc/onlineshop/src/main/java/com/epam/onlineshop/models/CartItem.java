package com.epam.onlineshop.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItem {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem(Product product) {
        super();
        this.setProduct(product);
        this.setQuantity(1);
        this.setTotalPrice(product.getUnitPrice());
    }
}
