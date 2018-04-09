package com.epam.tradesystem.services.impl;

import com.epam.tradesystem.exception.ProductNotFoundException;
import com.epam.tradesystem.models.Product;
import com.epam.tradesystem.repositiories.ProductRepository;
import com.epam.tradesystem.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private static final String DELIVERED_STATUS = "delivered";

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void changeDeliveryStatus(String productId, String newDeliveryStatus) {
        Product product = productRepository.getProductById(productId);

        if (product != null && product.isOrdered() && !product.getDeliveryStatus().equalsIgnoreCase(DELIVERED_STATUS)) {
            productRepository.changeDeliveryStatus(productId, newDeliveryStatus);
        } else {
            throw new ProductNotFoundException("Product with such id was not found: " + productId);
        }
    }
}
