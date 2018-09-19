package com.epam.onlineshop.services;


import com.epam.onlineshop.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(String productId);

    void addProduct(Product product);

}
