package com.PizzaFlow.Service;

import com.PizzaFlow.Model.Order;
import com.PizzaFlow.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    // Constructor Injection
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Create a new order.
     * Sets the current timestamp and default status to "Preparing".
     *
     * @param order the order to create
     * @return Mono<Order> the created order
     */
    public Mono<Order> createOrder(Order order) {
        order.setTimestamp(LocalDateTime.now()); // Set the current timestamp
        order.setOrderStatus("Preparing");           // Default order status
        return orderRepository.save(order);
    }

    /**
     * Retrieve all orders.
     *
     * @return Flux<Order> all orders from the database
     */
    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Retrieve an order by ID.
     *
     * @param id the ID of the order
     * @return Mono<Order> the order if found, or an error if not
     */
    public Mono<Order> getOrderById(String id) {
        return orderRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found")));
    }

    /**
     * Update the status of an existing order.
     *
     * @param id the ID of the order to update
     * @param newStatus the new status for the order
     * @return Mono<Order> the updated order
     */
    public Mono<Order> updateOrderStatus(String id, String newStatus) {
        return orderRepository.findById(id)
                .flatMap(order -> {
                    order.setOrderStatus(newStatus);
                    return orderRepository.save(order);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found with ID: " + id)));
    }

    /**
     * Delete an order by ID.
     *
     * @param id the ID of the order to delete
     * @return Mono<Void> represents the deletion operation
     */
    public Mono<Void> cancelOrder(String id) {
        return orderRepository.findById(id)
                .flatMap(order -> orderRepository.deleteById(order.getOrderId()))
                .switchIfEmpty(Mono.error(new RuntimeException("Order not found with ID: " + id)));
    }
}

