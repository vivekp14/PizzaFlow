package com.PizzaFlow.Controller;

import com.PizzaFlow.Model.Order;
import com.PizzaFlow.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    // Constructor for dependency injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Place a new order.
     *
     * @param order the order to be placed
     * Mono<Order> the created order
     */
    @PostMapping
    public Mono<Order> placeOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    /**
     * Get all orders.
     *
     * Flux<Order> It will give list of all orders
     */
    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    /**
     * Get order details by ID.
     *
     * id the ID of the order
     * Mono<Order> the order details
     */
    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    /**
     * Update the status of an order.
     *
     * @param id the ID of the order
     * @param status the new status for the order
     * Mono<Order> the updated order
     */
    @PutMapping("/{id}/status")
    public Mono<Order> updateOrderStatus(@PathVariable String id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }

    /**
     * Cancel an order by ID.
     *
     * id the ID of the order to cancel
     * Mono<Void> represents the cancellation
     */
    @DeleteMapping("/{id}")
    public Mono<Void> cancelOrder(@PathVariable String id) {
        return orderService.cancelOrder(id);
    }
}

