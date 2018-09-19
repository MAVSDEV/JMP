package com.epam.tradesystem.repositiories.impl;

import com.epam.tradesystem.models.Product;
import com.epam.tradesystem.repositiories.ProductRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Component
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> listOfProducts = Lists.newArrayList();

    public ProductRepositoryImpl() {
        listOfProducts.add(new Product("P1234", "iPhone 5s", new BigDecimal(500), Boolean.FALSE, ""));
        listOfProducts.add(new Product("P1235", "Dell Inspiron", new BigDecimal(700), Boolean.FALSE, ""));
        listOfProducts.add(new Product("P1236", "Nexus 7", new BigDecimal(300), Boolean.FALSE, ""));
        listOfProducts.add(new Product("P1237", "Galaxy S5", new BigDecimal(700), Boolean.FALSE, ""));
        listOfProducts.add(new Product("P1238", "Nexus 9", new BigDecimal(700), Boolean.FALSE, ""));
    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(String productid) {
        final Product[] productById = {null};
        listOfProducts.stream()
                .filter(product -> product != null && product.getProductId() != null && product.getProductId().equals(productid))
                .forEach(product -> productById[0] = product);
        if (productById[0] == null) {
            throw new IllegalArgumentException("No products found with product Id " + productid);
        }
        return productById[0];
    }

    @Override
    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    @Override
    public void changeOrderedStatus(String productId) {
        listOfProducts.stream()
                .filter(product -> product.getProductId().equalsIgnoreCase(productId))
                .forEach(product -> product.setOrdered(Boolean.TRUE));
    }

    @Override
    public void changeDeliveryStatus(String productId, String newDeliveryStatus) {
        listOfProducts.stream()
                .filter(product -> product.getProductId().equalsIgnoreCase(productId))
                .forEach(product -> product.setDeliveryStatus(newDeliveryStatus));
    }
}
