package com.wipro.order_service.repository;

import com.wipro.order_service.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

    //  Find cart by userId
    Optional<CartEntity> findByUserId(String userId);

    //  Delete cart by userId
    void deleteByUserId(String userId);

	Optional<CartEntity> findByUserId(Long userId);
}