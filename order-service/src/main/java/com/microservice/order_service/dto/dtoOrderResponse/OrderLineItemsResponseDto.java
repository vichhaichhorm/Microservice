package com.microservice.order_service.dto.dtoOrderResponse;

import com.microservice.order_service.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsResponseDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
