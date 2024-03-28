package com.mhooda.ruleengine.service;

import com.mhooda.ruleengine.model.VariableSet;
import com.mhooda.ruleengine.repository.VariableSetRepository;
import org.springframework.stereotype.Service;

@Service
public class VariableService {
    private final VariableSetRepository repository;

    public VariableService(VariableSetRepository repository) {
        this.repository = repository;
    }

    public VariableSet save(VariableSet variableSet) {
        return repository.save(variableSet);
    }
}
