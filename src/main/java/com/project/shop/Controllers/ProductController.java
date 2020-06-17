package com.project.shop.Controllers;

import com.project.shop.Entities.Product;
import com.project.shop.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping(value = "/products/all", produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(value = "/products/byCategory/{name}", produces = "application/json")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String name) {
        return ResponseEntity.ok(productService.findByCategory(name));
    }

    @GetMapping(value = "/products/byName/{name}", produces = "application/json")
    public ResponseEntity<Optional<Product>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.findByName(name));
    }
}
