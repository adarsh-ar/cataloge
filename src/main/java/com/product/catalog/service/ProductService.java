package com.product.catalog.service;

import com.product.catalog.model.Payload;
import com.product.catalog.model.Product;
import com.product.catalog.repository.ProductDao;
import com.product.catalog.utility.ProductUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductService {
    @Autowired
    ProductDao dao;
    @Autowired
    ProductUtility utility;
    public Set<Product> getProduct(String prodName){
        return dao.findByName(prodName);
    }

    public Integer getSkuCount(String prodName){
        AtomicInteger count=new AtomicInteger(0);
        getProduct(prodName).stream().filter(Objects::nonNull).
                map(Product::getCatagory)
                .filter(Objects::nonNull)
                .forEach(catagories -> catagories.stream().filter(Objects::nonNull).forEach(c->count.getAndAdd(c.getSkuCount().intValue())));
        return count.get();
    }

    public Map<String, Set<Product>> groupbByResult(Payload payload) {
        return utility.getByGrouping(getProduct(payload.getProdName()),payload.getGroupedBy());
    }
}
