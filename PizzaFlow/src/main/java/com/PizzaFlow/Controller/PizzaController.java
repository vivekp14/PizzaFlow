package com.PizzaFlow.Controller;

import com.PizzaFlow.Model.Pizza;
import com.PizzaFlow.Service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public Mono<Pizza> addPizza(@Valid @RequestBody Pizza pizza) {
        return pizzaService.createPizza(pizza);
    }

    @GetMapping
    public Flux<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Mono<Pizza> getPizzaById(@PathVariable String id) {
        return pizzaService.getPizzaById(id);
    }

    @PutMapping("/{id}")
    public Mono<Pizza> updatePizza(@PathVariable String id, @RequestBody Pizza pizza) {
        return pizzaService.updatePizza(id, pizza);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePizza(@PathVariable String id) {
        return pizzaService.deletePizza(id);
    }
}

