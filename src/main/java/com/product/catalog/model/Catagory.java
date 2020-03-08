package com.product.catalog.model;

import javax.persistence.*;

@Entity
@Table
public class Catagory {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getSkuCount() {
        return skuCount;
    }

    public void setSkuCount(Long skuCount) {
        this.skuCount = skuCount;
    }

    private float price;
    private String color;
    private String sku;
    private Long size;
    private Long skuCount;
}
