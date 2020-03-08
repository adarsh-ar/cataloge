package com.product.catalog.controller;

import com.product.catalog.model.Payload;
import com.product.catalog.model.Product;
import com.product.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin()
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping(value = "/getProduct/{name}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Set<Product> getProduct(@PathVariable(name = "name") String productName){
        return service.getProduct(productName);
    }
    @GetMapping(value = "/{prodName}/count",produces = {MediaType.APPLICATION_JSON_VALUE})
    public int getCount(@PathVariable("prodName") String name){
        return service.getSkuCount(name);
    }
    @PostMapping(value ="/getProduct",produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String,Set<Product>> groupbByResult(@RequestBody Payload payload){
        return service.groupbByResult(payload);
    }
}
