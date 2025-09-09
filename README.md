# 🧠 Order Service — Domain-Driven Design with Spring Boot

This project is a modular Java Spring Boot application built using **Domain-Driven Design (DDD)** principles. It focuses on the `OrderService` domain and lays the foundation for scalable microservices architecture.

---

## 🚀 Features

- 🧩 DDD structure: Domain, Application, Infrastructure, Interface layers
- 📦 Spring Boot 2.7.18 with Maven
- 🧠 Clean separation of business logic and technical concerns
- 🧪 RESTful API for placing and managing orders
- 🛠 Ready for extension into a full microservices platform

---

## 🧱 Architecture Overview
src/ └── main/ └── java/ └── com/ └── example/ └── orderservice/ ├── domain/ │ ├── model/ │ └── repository/ ├── application/ ├── infrastructure/ │ └── persistence/ └── interfaceweb/ └── web/


### Layer Breakdown

| Layer           | Responsibility                              |
|-----------------|----------------------------------------------|
| `domain`        | Core business logic, entities, value objects |
| `application`   | Use cases, orchestration                     |
| `infrastructure`| Persistence, configuration                   |
| `interfaceweb`  | REST controllers, API exposure               |

---

## 🛠 Tech Stack

- Java 8
- Spring Boot 2.7.18
- Maven
- Spring Data JPA
- H2 (in-memory database for dev)

---

## 📦 Getting Started

### 🔧 Prerequisites

- JDK 8+
- Maven 3.6+
- VS Code or IntelliJ IDEA

### ▶️ Run the App

```bash
mvn clean package
java -jar target/orderservice-1.0-SNAPSHOT.jar
### 🧪 Test the API

Use Postman or curl:

bash

```
curl -X POST http://localhost:8080/orders

```

## 📚 Domain Concepts

- `Order`: Aggregate root
    
- `OrderItem`: Value object
    
- `OrderStatus`: Enum for lifecycle
    
- `OrderService`: Application service
    
- `OrderRepository`: Domain interface
    
- `JpaOrderRepository`: Infrastructure implementation
    

## 📂 Sample Files

### ✅ `Order.java`

```java


@Entity
@Table(name = "orders")
public class Order {
    @Id
    private UUID id;
    private OrderStatus status;
    @ElementCollection
    private List<OrderItem> items = new ArrayList<>();
    // Business logic...
}

```

### ✅ `OrderService.java`



```java
@Service
public class OrderService {
    private final OrderRepository repository;

    public void placeOrder(Order order) {
        repository.save(order);
    }
}

```

### ✅ `OrderController.java`



```java
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    @PostMapping
    public ResponseEntity<String> createOrder() {
        Order order = new Order();
        service.placeOrder(order);
        return ResponseEntity.ok("Order created with ID: " + order.getId());
    }
}

}
```

## 🧠 Future Enhancements

- Add Customer and Inventory services
    
- Integrate Kafka or RabbitMQ for messaging
    
- Dockerize for deployment
    
