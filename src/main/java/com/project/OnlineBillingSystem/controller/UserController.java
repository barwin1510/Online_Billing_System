package com.project.OnlineBillingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.OnlineBillingSystem.dto.OrderRequest;
import com.project.OnlineBillingSystem.model.Order;
import com.project.OnlineBillingSystem.model.Product;
import com.project.OnlineBillingSystem.service.OrderService;
import com.project.OnlineBillingSystem.service.ProductService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    // Place an order
    @PostMapping("/order")
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest.getUserId(), orderRequest.getProductId(), orderRequest.getQuantity());
    }

    // Get all orders by userId
    @GetMapping("/orders/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }
}
