package com.project.shop.Controllers;

import com.project.shop.Entities.ProductCategory;
import com.project.shop.Services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/products/categories/add")
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createProductCategory(productCategory);
    }

    @GetMapping(value = "/products/categories/all", produces = "application/json")
    public ResponseEntity<List<ProductCategory>> getAllCategories() {
        return ResponseEntity.ok(productCategoryService.findAll());
    }

    @GetMapping(value = "/products/categories/{categoryName}", produces = "application/json")
    public ResponseEntity<Optional<ProductCategory>> getCategoryByName(@PathVariable String categoryName) {
        return ResponseEntity.ok(productCategoryService.findByName(categoryName));
    }
}
