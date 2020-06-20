package com.project.shop.Controllers;

import com.project.shop.Entities.Cart;
import com.project.shop.Entities.Product;
import com.project.shop.Entities.ProductCategory;
import com.project.shop.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping(value = "/byCategory/{name}", produces = "application/json")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable String name) {
        return ResponseEntity.ok(productService.findByCategory(name));
    }

    @GetMapping(value = "/byId/{id}", produces = "application/json")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return ResponseEntity.ok(product.get());
    }

    @GetMapping(value = "/byName/{name}", produces = "application/json")
    public Slice<Product> getByName(@PathVariable String name, Pageable pageable) {
        if (name == null) {
            return productService.findByName("", pageable);
        } else {
            return productService.findByName(name, pageable);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<Product> productCategory = productService.findById(id);

        Boolean isDeleted = false;

        if (productCategory.isPresent())
            isDeleted = productService.deleteById(id);
        if (isDeleted)
            return ResponseEntity.ok("Deleted Product, id: " + id);
        return (ResponseEntity<?>) ResponseEntity.badRequest();

        // KS - tutaj nie wiem czy to jest na pewno ok
    }
}







