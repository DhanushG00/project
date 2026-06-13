package com.wipro.order_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.wipro.order_service.entity.CartEntity;
import com.wipro.order_service.entity.OrderItem;
import com.wipro.order_service.io.OrderDTO;
import com.wipro.order_service.io.OrderItemDTO;
import com.wipro.order_service.repository.CartRepository;
import com.wipro.order_service.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO placeOrder(Long userId) {

        CartEntity cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        Order order = new Order();
        order.setUserId(userId);
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("PLACED");

        List<OrderItem> items = cart.getItems().stream()
                .map(ci -> {
                    OrderItem oi = new OrderItem();
                    oi.setProductId(ci.getProductId());
                    oi.setProductName(ci.getProductName());
                    oi.setPrice(ci.getPrice());
                    oi.setQuantity(ci.getQuantity());
                    oi.setOrder(order);
                    return oi;
                }).toList();

        order.setItems(items);

        order.setTotalAmount(
                items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum()
        );

        Order saved = orderRepository.save(order);

        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);

        log.info("Order placed successfully {}", saved.getId());

        return MapperUtil.toOrderDTO(saved);
    }

	@Override
	public OrderItemDTO createOrderWithPayment(OrderDTO request) throws RazorpayException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void verifyPayment(Map<String, String> paymentData, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItemDTO> getUserOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeOrder(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItemDTO> getOrdersOfAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderStatus(String orderId, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItemDTO> getUserOrders(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
