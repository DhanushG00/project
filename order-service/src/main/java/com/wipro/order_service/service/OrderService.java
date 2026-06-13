package com.wipro.order_service.service;

import java.util.List;
import java.util.Map;

import com.razorpay.RazorpayException;
import com.wipro.order_service.io.OrderDTO;
import com.wipro.order_service.io.OrderItemDTO;

public interface OrderService {

    OrderItemDTO createOrderWithPayment(OrderDTO request) throws RazorpayException;

    void verifyPayment(Map<String, String> paymentData, String status);

    List<OrderItemDTO> getUserOrders();

    void removeOrder(String orderId);

    List<OrderItemDTO> getOrdersOfAllUsers();

    void updateOrderStatus(String orderId, String status);

	List<OrderItemDTO> getUserOrders(String userId);

	OrderDTO placeOrder(Long userId);

}
