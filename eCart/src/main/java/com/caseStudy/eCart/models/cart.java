package com.caseStudy.eCart.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_Info")
public class cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    Long cartId;
    @ManyToOne
    private users users;
    @ManyToOne
    private Products products;
    @Column(name = "quantity")
    int quantity;
    @Column(name = "amount")
    double amount;

    public cart(com.caseStudy.eCart.models.users users, Products products, int quantity) {
        this.users = users;
        this.products = products;
        this.quantity = quantity;
    }
    public cart()
    { }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public com.caseStudy.eCart.models.users getUsers() {
        return users;
    }

    public void setUsers(com.caseStudy.eCart.models.users users) {
        this.users = users;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
