package com.product.catalog.repository;

import com.product.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {
 Set<Product> findByName(String name);
}
