package com.PizzaFlow.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "pizzas")
public class Pizza {
    @Id
    private String id; // Pizza ID
    @NotBlank(message = "Name cannot be blank")
    private String name; // Pizza name
    private String description; // Description of the pizza
    private List<String> toppings; // List of toppings
    private String size; // Size options (small, medium, large)
    @Positive(message = "Price must be positive")
    private double price; // Price of the pizza

    // Default constructor
    public Pizza() {}

    // Parameterized constructor
    public Pizza(String id, String name, String description, List<String> toppings, String size, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.toppings = toppings;
        this.size = size;
        this.price = price;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Pizza{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", toppings=" + toppings +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
