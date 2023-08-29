package com.radhay.productservice;

import com.radhay.productservice.dto.ProductRequest;
import com.radhay.productservice.dto.ProductResponse;
import com.radhay.productservice.implementation.ProductServiceImpl;
import com.radhay.productservice.model.Product;
import com.radhay.productservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createProduct() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("pro");
        productRequest.setPrice(BigDecimal.valueOf(10));
        productRequest.setDescription("product 1");

        Product savedProduct = new Product();
        savedProduct.setId("1");
        savedProduct.setName("pro");
        savedProduct.setPrice(BigDecimal.valueOf(10));
        savedProduct.setDescription("product 1");

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(savedProduct);

        ProductResponse productResponse = productService.createProduct(productRequest);

        assertEquals(savedProduct.getName(), productResponse.getName());
        assertEquals(savedProduct.getPrice(), productResponse.getPrice());
        assertEquals(savedProduct.getDescription(), productResponse.getDescription());
    }
}
