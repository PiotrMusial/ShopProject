package com.project.shop.Repositories;

import com.project.shop.Entities.Cart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Long> {

        @Query("SELECT c FROM Cart c JOIN User u ON u.id = c.user WHERE u.userName = ?1")
        Optional<Cart> findByUserName(String name);

        @Query("SELECT c FROM Cart c WHERE c.user = ?1")
        Optional<Cart> findByUserId(Long id);

}