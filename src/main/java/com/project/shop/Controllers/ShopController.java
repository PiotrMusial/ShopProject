package com.project.shop.Controllers;

import com.project.shop.Entities.Cart;
import com.project.shop.Entities.Product;
import com.project.shop.Entities.ProductCategory;
import com.project.shop.Entities.User;
import com.project.shop.Services.CartService;
import com.project.shop.Services.ProductCategoryService;
import com.project.shop.Services.ProductService;
import com.project.shop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users/add", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value = "/users/all", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/users/{userName}", produces = "application/json")
    public ResponseEntity<Optional<User>> getUserByName(@PathVariable String userName) {
        return ResponseEntity.ok(userService.findByUserName(userName));
    }

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

    @Autowired
    private CartService cartService;

    @PostMapping("/carts/add")
    public Cart addCart(@RequestBody Cart cart) {return cartService.createCart(cart); }

    @GetMapping(value = "/carts/all", produces = "application/json")
    public ResponseEntity<List<Cart>> getAllCarts() {return ResponseEntity.ok(cartService.findAll()); }

    @GetMapping(value = "carts/byId/{id}", produces = "application/json")
    public ResponseEntity<Optional<Cart>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.findById(id));
    }


}
