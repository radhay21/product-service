package com.radhay.productservice.implementation;

import com.radhay.productservice.dto.ProductRequest;
import com.radhay.productservice.dto.ProductResponse;
import com.radhay.productservice.model.Product;
import com.radhay.productservice.repository.ProductRepository;
import com.radhay.productservice.service.iProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements iProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());

        ProductResponse response = new ProductResponse(product.getId(),product.getName(), product.getDescription(), product.getPrice());
        return response;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    @Override
    public ProductResponse getProductById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return (ProductResponse) product.stream().map(this::mapToProductResponse).toList();


    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}