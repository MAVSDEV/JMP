package com.epam.tradesystem.controllers;

import com.epam.tradesystem.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products/delivery")
public class DeliveryController {

    private static final String DELIVERED_STATUS = "delivered";

    @Autowired
    private DeliveryService deliveryService;

    @RequestMapping("/changeStatus/{productId}")
    public String changeStatus(@PathVariable("productId") String productId,
                        @PathVariable("quantity") Integer quantity) {
        deliveryService.changeDeliveryStatus(productId, DELIVERED_STATUS);
        return "orderedProducts";
    }
}
