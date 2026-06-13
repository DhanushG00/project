package com.wipro.order_service.io;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderItemDTO {

    private Long id;

    @NotNull
    private Long productId;

    @NotBlank
    private String productName;

    @Positive
    private Double price;

    @Positive
    private Integer quantity;
}
