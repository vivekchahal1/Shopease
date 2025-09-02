package com.shopease.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private List<Product> products;
    private double total;
    private LocalDateTime orderTime;

    public Order() {}

    public Order(int id, List<Product> products, double total, LocalDateTime orderTime) {
        this.id = id;
        this.products = products;
        this.total = total;
        this.orderTime = orderTime;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDateTime getOrderTime() { return orderTime; }
    public void setOrderTime(LocalDateTime orderTime) { this.orderTime = orderTime; }
}
