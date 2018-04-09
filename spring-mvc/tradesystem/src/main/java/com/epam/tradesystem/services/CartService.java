package com.epam.tradesystem.services;


import com.epam.tradesystem.models.Cart;

public interface CartService {
    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);
}
