package org.example.orderservice.service;

import org.example.orderservice.entities.Order;
import org.example.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    public void testDatabaseOperation() {
        Order order = new Order();
        order.setCustomerId(1L);
        order.setOrderDate(new Date());
        order.setTotalAmount(100.0);
        order.setStatus("Pending");
        orderRepository.save(order);
    }

    // Retrieve all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Retrieve a specific order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Retrieve all orders by customer ID
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    /*@Autowired
    private InventoryService inventoryService;  // Assuming you have an InventoryService to check stock
*/
   /* public Order createOrder(Order order) {
        // Step 1: Check inventory for each product code
        boolean isQuantityAvailable = checkInventory(order.getProductCodes());

        // Step 2: If inventory is not sufficient, throw an exception
        if (!isQuantityAvailable) {
            throw new RuntimeException("Insufficient quantity in inventory for one or more products.");
        }

        // Step 3: If quantity is available, proceed to create the order
        return orderRepository.save(order);
    }*/

    /*// Method to check inventory for each product code
    private boolean checkInventory(List<String> productCodes) {
        for (String productCode : productCodes) {
            boolean isProductInStock = inventoryService.checkStock(productCode);
            if (!isProductInStock) {
                return false;  // If any product is out of stock, return false
            }
        }
        return true;  // All products are in stock
    }*/





    // Update an existing order
    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setCustomerId(updatedOrder.getCustomerId());
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setTotalAmount(updatedOrder.getTotalAmount());
            order.setStatus(updatedOrder.getStatus());
            order.setShippingAddress(updatedOrder.getShippingAddress());
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }

    // Delete an order by ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

