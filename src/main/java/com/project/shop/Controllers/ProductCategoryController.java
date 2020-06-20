package com.project.shop.Controllers;

import com.project.shop.Entities.Cart;
import com.project.shop.Entities.Product;
import com.project.shop.Entities.ProductCategory;
import com.project.shop.Services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/products/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/add")
    public ProductCategory addProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createProductCategory(productCategory);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<ProductCategory>> getAllCategories() {
        return ResponseEntity.ok(productCategoryService.findAll());
    }

    @GetMapping(value = "/{categoryName}", produces = "application/json")
    public ResponseEntity<Optional<ProductCategory>> getCategoryByName(@PathVariable String categoryName) {
        return ResponseEntity.ok(productCategoryService.findByName(categoryName));
    }
    @GetMapping(value = "/byId/{id}", produces = "application/json")
    public ResponseEntity<ProductCategory> getById(@PathVariable Long id) {
        Optional<ProductCategory> productCategory = productCategoryService.findById(id);
        return ResponseEntity.ok(productCategory.get());
    }



    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteProductCategory(@PathVariable Long id) {
        Optional<ProductCategory> productCategory = productCategoryService.findById(id);

        Boolean isDeleted = false;

        if (productCategory.isPresent())
            isDeleted = productCategoryService.deleteProductCategory(id);
        if (isDeleted)
            return ResponseEntity.ok("Deleted ProductCategory, id: " + id);
        return (ResponseEntity<?>) ResponseEntity.badRequest();

    }

}
