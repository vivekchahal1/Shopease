package com.shopease.service;

import com.shopease.model.Order;
import com.shopease.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ShopService {
    private final List<Product> products = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private final AtomicInteger productIdCounter = new AtomicInteger(1);
    private final AtomicInteger orderIdCounter = new AtomicInteger(1);

    // Add a new product
    public Product addProduct(Product product) {
        product.setId(productIdCounter.getAndIncrement());
        products.add(product);
        return product;
    }

    // Get all products
    public List<Product> getProducts() {
        return products;
    }

    // Place an order
    public Order placeOrder(List<Integer> productIds) {
        List<Product> orderedProducts = new ArrayList<>();
        for (int id : productIds) {
            products.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst()
                    .ifPresent(orderedProducts::add);
        }

        double total = orderedProducts.stream().mapToDouble(Product::getPrice).sum();
        Order order = new Order(orderIdCounter.getAndIncrement(), orderedProducts, total, LocalDateTime.now());
        orders.add(order);
        return order;
    }

    // Get all orders
    public List<Order> getOrders() {
        return orders;
    }
}
