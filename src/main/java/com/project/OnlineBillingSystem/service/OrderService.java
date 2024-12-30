package com.project.OnlineBillingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineBillingSystem.model.Order;
import com.project.OnlineBillingSystem.model.Product;
import com.project.OnlineBillingSystem.repository.OrderRepository;
import com.project.OnlineBillingSystem.repository.ProductRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // Place an Order
    public String placeOrder(Long userId, Long productId, Long quantity) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            Long totalAmount = product.getPrice() * quantity;
            Order order = new Order(userId, productId, product.getProductName(), product.getPrice(), quantity);
            order.setTotalAmount(totalAmount);
            orderRepository.save(order);
            return "Order placed successfully!";
        }
        return "Product not found!";
    }

    // Get all orders by userId
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
