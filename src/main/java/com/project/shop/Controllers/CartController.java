package com.project.shop.Controllers;

import com.project.shop.Entities.Cart;
import com.project.shop.Entities.Product;
import com.project.shop.Services.CartService;
import com.project.shop.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add", produces = "application/json")
    public Cart addCart(@RequestBody Cart cart) {return cartService.createCart(cart); }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Cart>> getAllCarts() {return ResponseEntity.ok(cartService.findAll()); }

    @GetMapping(value = "/byId/{id}", produces = "application/json")
    public ResponseEntity<Cart> getById(@PathVariable Long id) {

        Optional<Cart> cart = cartService.findById(id);

        if (cart.isPresent())
            return ResponseEntity.ok(cart.get());
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/add/{idCarts}/{productId}/{amount}")
//    public ResponseEntity<?> addCartItem(@PathVariable Long productId, @PathVariable Long amount, @RequestBody Cart cart) {
//        Optional<Product> product = productService.findById(productId);
//        cart.addProduct(product.get(), amount);
//        URI uri = URI.create("Product added to cart");
//        return (ResponseEntity<?>) ResponseEntity.created(uri);
//    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable Long id) {
        Optional<Cart> cart = cartService.findById(id);

        Boolean isDeleted = false;

        if (cart.isPresent())
            isDeleted = cartService.deleteCart(id);
        if (isDeleted)
            return ResponseEntity.ok("Deleted Cart, id: " + id);
        return (ResponseEntity<?>) ResponseEntity.badRequest();

        // KS - tutaj nie wiem czy to jest na pewno ok
    }
}
