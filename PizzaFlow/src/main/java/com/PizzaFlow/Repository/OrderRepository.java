package com.PizzaFlow.Repository;

import com.PizzaFlow.Model.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, String> {}

