package com.product.catalog.utility;

import com.product.catalog.model.Brand;
import com.product.catalog.model.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Lazy
public class ProductUtility {
    public Map<String, Set<Product>> getByGrouping(Set<Product> product, String groupedBy) {
        Map<String, Set<Product>> map=new HashMap<>();
        if(Optional.of(groupedBy).isPresent()){
            if("brand".equalsIgnoreCase(groupedBy))
                 product.stream().filter(Objects::nonNull)
                .forEach(product1 -> product1.getBrand().stream().filter(Objects::nonNull)
                .forEach(brand -> {
                    Set<Product> prodSet = map.getOrDefault(brand.getName(), new HashSet<>());
                    prodSet.add(product1);
                    map.put(brand.getName(),prodSet);
                }));
            else if("price".equalsIgnoreCase(groupedBy))
                product.stream().filter(Objects::nonNull)
                        .forEach(product1 -> product1.getCatagory().stream().filter(Objects::nonNull)
                                .forEach(catagory -> {
                                    Set<Product> prodSet = map.getOrDefault(catagory.getPrice(), new HashSet<>());
                                    prodSet.add(product1);
                                    map.put(String.valueOf(catagory.getPrice()),prodSet);
                                }));
            else if("price".equalsIgnoreCase(groupedBy))
                product.stream().filter(Objects::nonNull)
                        .forEach(product1 -> product1.getCatagory().stream().filter(Objects::nonNull)
                                .forEach(catagory -> {
                                    Set<Product> prodSet = map.getOrDefault(catagory.getColor(), new HashSet<>());
                                    prodSet.add(product1);
                                    map.put(String.valueOf(catagory.getColor()),prodSet);
                                }));
            else if("color".equalsIgnoreCase(groupedBy))
                product.stream().filter(Objects::nonNull)
                        .forEach(product1 -> product1.getCatagory().stream().filter(Objects::nonNull)
                                .forEach(catagory -> {
                                    Set<Product> prodSet = map.getOrDefault(catagory.getColor(), new HashSet<>());
                                    prodSet.add(product1);
                                    map.put(catagory.getColor(),prodSet);
                                }));
            else if("size".equalsIgnoreCase(groupedBy))
                product.stream().filter(Objects::nonNull)
                        .forEach(product1 -> product1.getCatagory().stream().filter(Objects::nonNull)
                                .forEach(catagory -> {
                                    Set<Product> prodSet = map.getOrDefault(catagory.getSize(), new HashSet<>());
                                    prodSet.add(product1);
                                    map.put(String.valueOf(catagory.getSize()),prodSet);
                                }));
            else if("sku".equalsIgnoreCase(groupedBy))
                product.stream().filter(Objects::nonNull)
                        .forEach(product1 -> product1.getCatagory().stream().filter(Objects::nonNull)
                                .forEach(catagory -> {
                                    Set<Product> prodSet = map.getOrDefault(catagory.getSku(), new HashSet<>());
                                    prodSet.add(product1);
                                    map.put(String.valueOf(catagory.getSku()),prodSet);
                                }));

        }
        return map;
    }
}
