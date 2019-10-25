package com.caseStudy.eCart.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="orderhistory_info")
public class OrderHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderhistory_id;

    @Column(name = "quantity")
    int quantity;

    @ManyToOne
    Products products;

    @ManyToOne
    users users;

    @Column(name="price")
    int price;

    @Column(nullable = false)
    LocalDate date;

    public Long getOrderhistory_id() {
        return orderhistory_id;
    }

    public void setOrderhistory_id(Long orderhistory_id) {
        this.orderhistory_id = orderhistory_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }


}
