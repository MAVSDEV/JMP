package com.epam.tradesystem.services;

import com.epam.tradesystem.models.Product;

import java.util.List;

public interface OrderService {

    List<Product> getAllOrderedProducts();

    void processOrder(String productId, long quantity);
}
