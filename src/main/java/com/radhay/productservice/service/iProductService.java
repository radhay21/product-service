package com.radhay.productservice.service;

import com.radhay.productservice.dto.ProductRequest;
import com.radhay.productservice.dto.ProductResponse;

import java.util.List;

public interface iProductService {

    public ProductResponse createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();

    public ProductResponse getProductById(String id);
}
