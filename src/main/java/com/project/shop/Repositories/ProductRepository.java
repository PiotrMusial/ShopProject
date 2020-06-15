package com.project.shop.Repositories;

import com.project.shop.Entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    List<Product> findByName(String name);

    @Query("SELECT p FROM Product p JOIN ProductCategory pc ON p.productCategory = pc.id WHERE pc.name = ?1")
    List<Product> findByCategory(String name);
}
