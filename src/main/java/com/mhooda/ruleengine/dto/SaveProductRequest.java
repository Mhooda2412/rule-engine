package com.mhooda.ruleengine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mhooda.ruleengine.model.Product;

public record SaveProductRequest(
        @JsonProperty("product_name")
        String productName
) {

        public Product toProduct(){
                Product product = new Product();
                product.setName(this.productName());
                return product;
        }
}
