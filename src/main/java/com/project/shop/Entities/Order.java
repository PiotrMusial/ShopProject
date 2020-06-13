package com.project.shop.Entities;

import com.project.shop.Enums.OrderStatus;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "order_cart_id")
//    private Cart cart;

    @JoinColumn(name = "order_cart_id")
    private Cart cart;


    @Column(name = "order_delivery_address", nullable = false)
    private String delivery_address;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "order_overall_price", nullable = false)
    private Double price;

    @Column(name = "order_is_paid", nullable = false)
    private Boolean isPaid;

    @Column(name = "order_is_completed", nullable = false)
    private Boolean isCompleted;


    public Order(String delivery_address, OrderStatus orderStatus, Double price, Boolean isPaid, Boolean isCompleted) {
        this.delivery_address = delivery_address;
        this.orderStatus = orderStatus;
        this.price = price;
        this.isPaid = isPaid;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
