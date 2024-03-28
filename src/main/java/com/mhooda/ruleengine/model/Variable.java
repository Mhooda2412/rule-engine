package com.mhooda.ruleengine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name ="variable_set_id" )
    @JsonBackReference
    private VariableSet variableSet;

    public VariableSet getVariableSet() {
        return variableSet;
    }

    public void setVariableSet(VariableSet variableSet) {
        this.variableSet = variableSet;
    }

    public Variable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return Objects.equals(id, variable.id) && Objects.equals(name, variable.name) && Objects.equals(type, variable.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }
}
