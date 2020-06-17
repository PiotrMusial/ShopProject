package com.project.shop.Controllers;

import com.project.shop.Entities.Cart;
import com.project.shop.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Cart addCart(@RequestBody Cart cart) {return cartService.createCart(cart); }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Cart>> getAllCarts() {return ResponseEntity.ok(cartService.findAll()); }

    @GetMapping(value = "/byId/{id}", produces = "application/json")
    public ResponseEntity<Optional<Cart>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.findById(id));
    }
}