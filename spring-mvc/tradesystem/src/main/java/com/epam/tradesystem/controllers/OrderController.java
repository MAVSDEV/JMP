package com.epam.tradesystem.controllers;

import com.epam.tradesystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping
    public String getOrderedProducts(Model model) {
        model.addAttribute("products", orderService.getAllOrderedProducts());
        return "orderedProducts";
    }

    @RequestMapping("/orders/{productId}/{quantity}")
    public void process(@PathVariable("productId") String productId,
                          @PathVariable("quantity") Integer quantity) {
        orderService.processOrder(productId, quantity);
    }
}
