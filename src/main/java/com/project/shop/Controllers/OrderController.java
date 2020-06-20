package com.project.shop.Controllers;

import com.project.shop.Entities.Order;
import com.project.shop.Enums.OrderStatus;
import com.project.shop.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @PostMapping("/add")
//    public Order addOrder(@RequestBody Order order) {return orderService.createOrder(order); }
//
//    @PostMapping("/add/{cartId}")
//    public Order addOrder(@PathVariable Long cartId, @RequestBody Order order) {
//        return orderService.createOrder(order);
//    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping(value = "/byStatus/{name}", produces = "application/json")
    public ResponseEntity<List<Order>> getByStatus(@PathVariable OrderStatus orderStatus) {
        return ResponseEntity.ok(orderService.findByStatus(orderStatus));
    }

    @GetMapping(value = "/byId/{id}", produces = "application/json")
    public ResponseEntity<Optional<Order>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Optional<Order> order = orderService.findById(id);

        Boolean isDeleted = false;

        if (order.isPresent())
            isDeleted = orderService.deleteOrder(id);
            if (isDeleted)
                return ResponseEntity.ok(id);
        return (ResponseEntity<?>) ResponseEntity.badRequest();

    }

}
