package com.wipro.order_service.io;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartDTO {

    private Long id;

    @NotNull(message = "UserId is required")
    private Long userId;

    private Double totalPrice;

    private List<CartItemDTO> items;
}
