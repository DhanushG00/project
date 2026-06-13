package com.wipro.order_service.service;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.order_service.entity.CartEntity;
import com.wipro.order_service.entity.CartItem;
import com.wipro.order_service.io.CartDTO;
import com.wipro.order_service.io.CartItemDTO;
import com.wipro.order_service.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartDTO addToCart(Long userId, CartItemDTO dto) {

        log.info("Adding item to cart for user {}", userId);

        CartEntity cart = cartRepository.findByUserId(userId)
                .orElse(new CartEntity());

        cart.setUserId(userId);

        CartItem item = MapperUtil.toCartItem(dto);
        item.setCart(cart);

        cart.getItems().add(item);

        double total = cart.getItems()
                .stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();

        cart.setTotalPrice(total);

        CartEntity saved = cartRepository.save(cart);

        log.info("Cart updated successfully {}", saved.getId());

        return MapperUtil.toCartDTO(saved);
    }

	@Override
	public CartItemDTO addToCart(CartDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemDTO getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartItemDTO removeFromCart(CartDTO cartRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}