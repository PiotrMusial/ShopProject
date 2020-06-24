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

    @OneToOne(optional = false)
    @JoinColumn(name = "cart_user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_product_id")
    private Product product;

//    @ElementCollection
//    @CollectionTable(name = "cart_product_mapping",
//            joinColumns = {@JoinColumn(name = "cart_id")})
//    @MapKeyJoinColumn(name = "product_id")
//    @Column(name = "cart_products")
//    private Map<Product, Long> products;

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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    public Map<Product, Long> getProducts() {
//        return products;
//    }

//    public void setProducts(Map<Product, Long> products) {
//        this.products = products;
//    }

//    public void addProduct(Product product, Long amount) {
//        if (this.products == null) {
//            this.products = new HashMap<>();
//        } else if (this.products.containsKey(product)) {
//            this.products.put(product, this.products.get(product) + amount);
//        } else {
//            this.products.put(product, amount);
//        }
//    }

}
