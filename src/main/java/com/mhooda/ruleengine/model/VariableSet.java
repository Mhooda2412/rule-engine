package com.mhooda.ruleengine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class VariableSet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @OneToMany(
            mappedBy = "variableSet",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Variable> variables;

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public VariableSet() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariableSet set = (VariableSet) o;
        return Objects.equals(id, set.id) && Objects.equals(name, set.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "VariableSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
