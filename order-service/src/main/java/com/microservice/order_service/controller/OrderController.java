package com.microservice.order_service.controller;

import com.microservice.order_service.dto.dtoOrderRequest.OrderRequest;
import com.microservice.order_service.dto.dtoOrderResponse.OrderResponseDto;
import com.microservice.order_service.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/save")
    @Operation(summary = "create order")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Placed Successful";
    }

    @GetMapping("/get")
    @Operation(summary = "get all order")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDto> getAllOrder(){
        return orderService.getAllOrder();
    }

}
