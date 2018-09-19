package com.epam.tradesystem.services;


import com.epam.tradesystem.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    void addProduct(Product product);

}
