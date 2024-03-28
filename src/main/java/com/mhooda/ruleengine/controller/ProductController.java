package com.mhooda.ruleengine.controller;


import com.mhooda.ruleengine.dto.SaveProductRequest;
import com.mhooda.ruleengine.model.Product;
import com.mhooda.ruleengine.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/products")
    public Product SaveProduct(
            @RequestBody
            SaveProductRequest request
            ){
        Product product = request.toProduct();
        return service.save(product);


    }
    @GetMapping("products")
    public List<Product> findAll(){
        return service.findAll();
    }

}
