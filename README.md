🍕 PizzaFlow: A Reactive Pizza Shop CRUD REST API

PizzaFlow is a modern and scalable RESTful API designed for a local pizza shop. Built with Spring Boot, Spring WebFlux, and MongoDB, the application showcases the power of reactive programming to deliver non-blocking, asynchronous operations. The API enables efficient management of pizzas and orders while ensuring high performance under load.

Features 
Pizzas Create: Add new pizzas to the menu with attributes such as name, description, size, toppings, and price. Read: Fetch details of a specific pizza by ID or retrieve the entire pizza menu. Update: Modify existing pizza details. Delete: Remove pizzas from the menu.

Orders Create: Place an order for one or more pizzas. Read: Retrieve an order by ID or view all orders. Update: Update the status of an order (e.g., Preparing, Delivered). Delete: Cancel an order.

Why Use Reactive Programming? 
This application utilizes Spring WebFlux and Reactive MongoDB to improve scalability and resource utilization by: Supporting non-blocking IO, allowing better throughput under high load. Utilizing Mono and Flux for efficient handling of asynchronous streams of data. Making the application more responsive and efficient compared to traditional blocking APIs.

Technologies Used Spring Boot: For building robust Java applications.

Spring WebFlux: To enable reactive programming and non-blocking operations.

MongoDB: A NoSQL database for data storage, integrated with reactive support.

Maven: Dependency and build management.

