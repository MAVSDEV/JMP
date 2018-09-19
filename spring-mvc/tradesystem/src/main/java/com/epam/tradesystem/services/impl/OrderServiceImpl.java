package com.epam.tradesystem.services.impl;

import com.epam.tradesystem.exception.ProductNotFoundException;
import com.epam.tradesystem.models.Product;
import com.epam.tradesystem.repositiories.ProductRepository;
import com.epam.tradesystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllOrderedProducts() {
        return productRepository.getAllProducts().stream().filter(Product::isOrdered).collect(Collectors.toList());
    }

    public void processOrder(String productId, long quantity) {
        Product productById = productRepository.getProductById(productId);

        if (productById != null) {
            productRepository.changeOrderedStatus(productId);
        } else {
            throw new ProductNotFoundException("Product with such id was not found: " + productId);
        }
    }
}
