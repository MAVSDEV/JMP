package com.epam.onlineshop.repositiories;


import com.epam.onlineshop.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productid);

    void addProduct(Product product);
}
