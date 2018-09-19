package com.epam.onlineshop.services;


import com.epam.onlineshop.models.Cart;

public interface CartService {
    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
