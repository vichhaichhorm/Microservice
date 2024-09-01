package com.microservice.product_service.controller;

import com.microservice.product_service.dto.dtoProductRequest.ProductRequest;
import com.microservice.product_service.dto.dtoProductResponse.ProductResponse;
import com.microservice.product_service.repository.ProductRepository;
import com.microservice.product_service.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
       return productService.createProduct(productRequest);
    }

    @GetMapping("/get")
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }



}
