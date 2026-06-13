package com.wipro.order_service.service;

import com.wipro.order_service.io.CartDTO;
import com.wipro.order_service.io.CartItemDTO;

public interface CartService {

    CartItemDTO addToCart(CartDTO request);

    CartItemDTO getCart();

    void clearCart();

    CartItemDTO removeFromCart(CartDTO cartRequest);

	CartDTO addToCart(Long userId, CartItemDTO dto);
}
