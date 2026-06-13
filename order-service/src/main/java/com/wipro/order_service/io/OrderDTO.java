package com.wipro.order_service.io;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderDTO {

    private Long id;

    @NotNull
    private Long userId;

    private Double totalAmount;

    private String status;

    private List<OrderItemDTO> items;
}
