package com.microservice.order_service.dto.dtoOrderResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private Long id;
    private String orderNumber;
    private List<OrderLineItemsResponseDto> orderLineItemsList;

}
