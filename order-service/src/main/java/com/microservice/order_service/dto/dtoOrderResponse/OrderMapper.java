package com.microservice.order_service.dto.dtoOrderResponse;

import com.microservice.order_service.model.Order;
import com.microservice.order_service.model.OrderLineItems;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    // Map Order entity to OrderResponseDto
    public static OrderResponseDto mapToOrderResponseDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setOrderNumber(order.getOrderNumber());
        List<OrderLineItemsResponseDto> lineItems = order.getOrderLineItemsList().stream()
                .map(OrderMapper::mapToOrderLineItemsResponseDto)
                .collect(Collectors.toList());
        dto.setOrderLineItemsList(lineItems);
        return dto;
    }

    // Map OrderLineItems entity to OrderLineItemsResponseDto
    public static OrderLineItemsResponseDto mapToOrderLineItemsResponseDto(OrderLineItems item) {
        OrderLineItemsResponseDto dto = new OrderLineItemsResponseDto();
        dto.setId(item.getId());
        dto.setSkuCode(item.getSkuCode());
        dto.setPrice(item.getPrice());
        dto.setQuantity(item.getQuantity());
        return dto;
    }
}
