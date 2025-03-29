package com.PizzaFlow.Repository;

import com.PizzaFlow.Model.Pizza;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PizzaRepository extends ReactiveCrudRepository<Pizza, String> {
    Flux<Pizza> findBySize(String size); // Example of a custom query
}
