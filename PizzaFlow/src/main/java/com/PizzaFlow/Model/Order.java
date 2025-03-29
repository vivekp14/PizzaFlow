package com.PizzaFlow.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private String orderId; // Order ID
    private List<Pizza> pizzas; // List of pizzas in the order
    private String orderStatus; // Status of the order (e.g., Preparing, Delivered)
    private LocalDateTime timestamp; // Timestamp when the order was placed

    // Default constructor
    public Order() {}

    // Parameterized constructor
    public Order(String orderId, List<Pizza> pizzas, String orderStatus, LocalDateTime timestamp) {
        this.orderId = orderId;
        this.pizzas = pizzas;
        this.orderStatus = orderStatus;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", pizzas=" + pizzas +
                ", orderStatus='" + orderStatus + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
