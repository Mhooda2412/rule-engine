package com.mhooda.ruleengine.dto;

import com.mhooda.ruleengine.model.Product;
import com.mhooda.ruleengine.model.Variable;
import com.mhooda.ruleengine.model.VariableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
public record SaveVariableRequest(
        String name,
        Integer product_id,
        List<Variable> variables

) {

    private static final Logger log = LoggerFactory.getLogger(SaveVariableRequest.class);
    public VariableSet toVariableSet(){



        VariableSet variableSet = new VariableSet();
        variableSet.setName(this.name());
        Product product = new Product();
        product.setId(this.product_id());
        variableSet.setProduct(product);

        List<Variable> variableList =  new ArrayList<>();

        variables()
                .stream()
                .peek(variable -> variable.setVariableSet(variableSet))
                .forEach(variableList::add);

        variableSet.setVariables(variableList);
        log.info(variableSet.toString());

        return variableSet;

    }
}
