package com.radhay.productservice.controller;

import com.radhay.productservice.dto.ProductRequest;
import com.radhay.productservice.dto.ProductResponse;
import com.radhay.productservice.implementation.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping(path = "{id}")
    public ProductResponse getProductById(String id){
        return productService.getProductById(id);
    }


}
