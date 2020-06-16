package com.project.shop.Entities;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_user_id")
    private User user;

    @ElementCollection
    @CollectionTable(name="cart_products",
            joinColumns={@JoinColumn(name="cart_id")})
    @MapKeyJoinColumn(name="products_id")
//    @JsonDeserialize(keyUsing = )
    private Map<Product, Integer> products;

    public Cart() {}

//    public Cart(User user) {
//        this.user = user;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addProduct(Product product, Integer amount) {
        if (this.products == null) {
            this.products = new HashMap<>();
        } else if(this.products.containsKey(product)) {
            this.products.put(product, this.products.get(product) + amount);
        } else {
            this.products.put(product, amount);
        }
    }


}
