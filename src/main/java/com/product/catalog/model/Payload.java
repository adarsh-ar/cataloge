package com.product.catalog.model;

public class Payload {
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getGroupedBy() {
        return groupedBy;
    }

    public void setGroupedBy(String groupedBy) {
        this.groupedBy = groupedBy;
    }

    String prodName;
    String groupedBy;
}
