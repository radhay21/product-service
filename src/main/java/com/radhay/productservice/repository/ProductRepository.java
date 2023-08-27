package com.radhay.productservice.repository;

import com.radhay.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Override
    public Optional<Product> findById(String id);

}
