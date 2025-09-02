package com.shopease.controller;

import com.shopease.model.Order;
import com.shopease.model.Product;
import com.shopease.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return shopService.addProduct(product);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return shopService.getProducts();
    }

    @PostMapping("/orders")
    public Order placeOrder(@RequestBody List<Integer> productIds) {
        return shopService.placeOrder(productIds);
    }

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return shopService.getOrders();
    }
}
