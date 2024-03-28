package com.mhooda.ruleengine.controller;

import com.mhooda.ruleengine.dto.SaveVariableRequest;
import com.mhooda.ruleengine.model.VariableSet;
import com.mhooda.ruleengine.service.VariableService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class VariableController {
    private final VariableService service;

    public VariableController(VariableService service) {
        this.service = service;
    }

    @PostMapping("/variables")
    public VariableSet saveVariable(@RequestBody SaveVariableRequest request){
        VariableSet variableSet = request.toVariableSet();
        return service.save(variableSet);
    }
}
