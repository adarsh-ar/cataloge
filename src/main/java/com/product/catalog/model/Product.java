package com.product.catalog.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name="Product")
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Brand> getBrand() {
        return brand;
    }

    public void setBrand(Set<Brand> brand) {
        this.brand = brand;
    }

    public Set<Catagory> getCatagory() {
        return catagory;
    }

    public void setCatagory(Set<Catagory> catagory) {
        this.catagory = catagory;
    }

    @ManyToMany(targetEntity = Brand.class)
    private Set<Brand> brand;
    @ManyToMany(targetEntity = Catagory.class)
    private Set<Catagory> catagory;

}
