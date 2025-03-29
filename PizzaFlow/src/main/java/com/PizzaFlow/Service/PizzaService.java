package com.PizzaFlow.Service;

import com.PizzaFlow.Model.Pizza;
import com.PizzaFlow.Repository.PizzaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    // Constructor Injection
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Mono<Pizza> createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Flux<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Mono<Pizza> getPizzaById(String id) {
        return pizzaRepository.findById(id);
    }

    public Mono<Pizza> updatePizza(String id, Pizza updatedPizza) {
        return pizzaRepository.findById(id)
                .flatMap(existingPizza -> {
                    existingPizza.setName(updatedPizza.getName());
                    existingPizza.setDescription(updatedPizza.getDescription());
                    existingPizza.setToppings(updatedPizza.getToppings());
                    existingPizza.setSize(updatedPizza.getSize());
                    existingPizza.setPrice(updatedPizza.getPrice());
                    return pizzaRepository.save(existingPizza);
                });
    }

    public Mono<Void> deletePizza(String id) {
        return pizzaRepository.deleteById(id);
    }
}

