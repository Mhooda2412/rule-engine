package com.mhooda.ruleengine.service;

import com.mhooda.ruleengine.model.Product;
import com.mhooda.ruleengine.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }
}
