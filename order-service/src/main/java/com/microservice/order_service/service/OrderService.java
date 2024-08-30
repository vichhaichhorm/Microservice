package com.microservice.order_service.service;

import com.microservice.order_service.dto.dtoOrderResponse.OrderMapper;
import com.microservice.order_service.dto.dtoOrderRequest.OrderRequest;
import com.microservice.order_service.dto.dtoOrderResponse.OrderResponseDto;
import com.microservice.order_service.model.Order;
import com.microservice.order_service.model.OrderLineItems;
import com.microservice.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(orderLineItemsDto -> orderRequest.mapToDto(orderLineItemsDto, order))
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);

    }

    public List<OrderResponseDto> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderMapper::mapToOrderResponseDto)
                .collect(Collectors.toList());
    }
}
