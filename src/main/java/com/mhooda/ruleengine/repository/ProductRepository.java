package com.mhooda.ruleengine.repository;

import com.mhooda.ruleengine.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
