package com.microservice.order_service.dto.dtoOrderRequest;

import com.microservice.order_service.dto.dtoOrderRequest.OrderLineItemsDto;
import com.microservice.order_service.model.Order;
import com.microservice.order_service.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto, Order orderId) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        // set order-id into orderLine item
        orderLineItems.setOrder(orderId);
        return orderLineItems;
    }

}
