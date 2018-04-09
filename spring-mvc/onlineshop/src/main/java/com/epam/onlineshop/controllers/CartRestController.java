package com.epam.onlineshop.controllers;

import com.epam.onlineshop.exception.ProductNotFoundException;
import com.epam.onlineshop.models.Cart;
import com.epam.onlineshop.models.CartItem;
import com.epam.onlineshop.models.Product;
import com.epam.onlineshop.services.CartService;
import com.epam.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    @ResponseBody
    public Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(String cartId, @RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") String productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(sessionId);
        System.out.println(cart);

        if (cart == null) {
            cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }

        cart.addCartItem(new CartItem(product));
        cartService.update(sessionId, cart);

    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable("productId") String productId, HttpServletRequest request) {

        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }

        cart.removeCartItem(new CartItem(product));
        cartService.update(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception ex) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServletErrors(Exception ex) {
    }


}
