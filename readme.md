# Spring Boot Microservice with Eureka

This project is a **Java Spring Boot microservice** integrated with **Eureka Server** for service discovery.
It demonstrates how microservices can register themselves with a Eureka Server and communicate with each other using **Feign Client** and **Spring Cloud Load Balancer**.

---

## 🚀 Features

* **Service Discovery** with Eureka Server
* **Microservice Registration** with Eureka Client
* **Inter-service Communication** using Feign Client
* **Load Balancing** with Spring Cloud Load Balancer
* Simple REST endpoints for testing

---

## 🏗️ Architecture

```
                     +-------------------+
                     |   Eureka Server   |
                     +-------------------+
                        ↑            ↑
                       	|            |
   +-------------------------+   +------------------------+
   |Employee service (Client)|   |Address service (Client)|
   +-------------------------+   +------------------------+
                  |
                  v
        +-------------------+
        |   Feign Client    |
        +-------------------+
```

* **Eureka Server** → Central registry where all services register.
* **Eureka Clients** → Microservices (Employee service, Address service) that register with the Eureka Server (Discovery service).
* **Feign Client** → Used by one service to call another without hardcoding the service URL.
* **Spring Cloud Load Balancer** → Distributes requests across multiple instances of a service.

---

## 📂 Project Structure

```
springboot-microservices/
│── discoveryservice/          # Eureka Service Discovery Server
│── employeeservice/           # First microservice (Eureka client + Feign client)
│── addressservice/            # Second microservice (Eureka client)
```

---

## ⚙️ Prerequisites

* **Java 17+**
* **Maven 3.8+**
* **Spring Boot 3.x**
* **Spring Cloud 2025.x**

---

## 🔧 Setup & Run

### 1. Clone Repository

```bash
git clone https://github.com/nainghtetlinn/spring-boot-microservices-with-eureka.git
cd spring-boot-microservices-with-eureka
```

### 2. Start Eureka Server

```bash
cd discoveryservice
mvn spring-boot:run
```

Eureka Dashboard → [http://localhost:8761](http://localhost:8761)

### 3. Start Service A & Service B

```bash
cd employeeservice
mvn spring-boot:run

cd ../addressservice
mvn spring-boot:run
```

### 4. Verify Registration

* Open **Eureka Dashboard**
* Check if `employee-service` and `address-service` are registered

---

## 📡 API Endpoints

### Employee Service (Feign Client)

```http
GET http://localhost:8080/employee-service/employees/1
```

Calls Address Service through Feign & Load Balancer

### Address Service

```http
GET http://localhost:8081/address-service/address/1
```

Returns a simple response

---

## 📖 References

* [GeeksforGeeks – Developing Service Discovery](https://www.geeksforgeeks.org/java/java-spring-boot-microservices-developing-service-discovery/)
* [GeeksforGeeks – Eureka + Feign + Load Balancer](https://www.geeksforgeeks.org/java/java-spring-boot-microservices-integration-of-eureka-feign-spring-cloud-load-balancer/)


