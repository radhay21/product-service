package com.radhay.productservice;

import com.radhay.productservice.dto.ProductRequest;
import com.radhay.productservice.dto.ProductResponse;
import com.radhay.productservice.implementation.ProductServiceImpl;
import com.radhay.productservice.model.Product;
import com.radhay.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJunitRunner.class)
public class ProductServiceImplTest
{

    @Mock
    ProductRepository productRepository ;
    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void createProduct(){
        ProductRequest product = new ProductRequest();
        product.setName("pro");
        product.setPrice(BigDecimal.valueOf(10));
        product.setDescription("product 1");

        Product response = new Product();
        response.setId("1");
        response.setName("pro");
        response.setPrice(BigDecimal.valueOf(10));
        response.setDescription("product 1");

        Mockito.when(productRepository.save(new Product())).thenReturn(response);
        ProductResponse  productResponse = productService.createProduct(product);
        Assertions.assertEquals(productResponse,response);
        //Assertions.assertTrue(productResponse.equals(response));

    }
}
