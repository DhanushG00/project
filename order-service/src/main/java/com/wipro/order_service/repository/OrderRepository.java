package com.wipro.order_service.repository;

import com.wipro.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    // Find orders by user
    List<OrderEntity> findByUserId(String userId);

  

	void deleteById(String orderId);

	Optional<OrderEntity> findById(String orderId);
}
