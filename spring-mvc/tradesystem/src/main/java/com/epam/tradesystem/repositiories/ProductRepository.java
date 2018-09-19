package com.epam.tradesystem.repositiories;


import com.epam.tradesystem.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(String productid);

    void addProduct(Product product);

    void changeOrderedStatus(String productId);

    void changeDeliveryStatus(String productId, String newDeliveryStatus);
}
