package com.project.shop.Controllers;

import com.project.shop.Entities.User;
import com.project.shop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/add", produces = "application/json")
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/{userName}", produces = "application/json")
    public ResponseEntity<Optional<User>> getUserByName(@PathVariable String userName) {
        return ResponseEntity.ok(userService.findByUserName(userName));
    }
}
