package com.epam.onlineshop.repositiories.impl;

import com.epam.onlineshop.models.Cart;
import com.epam.onlineshop.repositiories.CartRepository;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CartRepositoryImpl implements CartRepository {

    private Map<String, Cart> listOfCarts;

    public CartRepositoryImpl() {
        listOfCarts = Maps.newHashMap();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(
                    String.format(
                            "Can not create a cart. A cart with the given id (%) already exists.",
                            cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(
                    String.format(
                            "Cannot update cart. Cart with the given id (%) does not exist.",
                            cartId));
        }
        listOfCarts.put(cartId, cart);
    }

    @Override
    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(
                    String.format(
                            "Cannot update cart. Cart with the given id (%) does not exist.",
                            cartId));
        }
        listOfCarts.remove(cartId);

    }

}
