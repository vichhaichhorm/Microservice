package com.microservice.product_service.dto.dtoProductResponse;

import com.microservice.product_service.model.Product;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;


}
