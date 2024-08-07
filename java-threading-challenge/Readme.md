# Problem Statement:

Implement a program that simulates a restaurant with a limited number of tables and a group of customers arriving at 
random intervals. The restaurant has a fixed number of tables, and each table can accommodate a certain number of 
customers. Customers arrive at random intervals and try to occupy a table. If a table is available, the customers occupy it;

**This challenge is designed to test your skills in multithreading, synchronization, and handling concurrent access to shared resources in Java.** 


## Requirements

### Tables

Create a class Table with properties like tableId and capacity (number of seats). The tableId should be unique and
generated automatically starting from 1.

### Restaurant

Create a Restaurant class that manages multiple Table instances. 
It should have methods to check if a table is available for seating and to occupy a table.

### Customer

Implement a Customer class that represents a customer arriving at the restaurant. Each customer should have a customerId.

### Simulation

Create a RestaurantSimulation class where:
- Customers arrive at random intervals.
- Customers try to occupy a table (if available).
- If a table is not available, customers wait until one becomes free.
- Customers leave the restaurant after dining.

### Hints

- Use Java's Thread or Runnable interface to simulate the arrival and handling of customers concurrently.
- Ensure thread safety when accessing shared resources like tables.
- Use synchronization mechanisms (like synchronized blocks or Lock interface) to manage access to shared tables.
- Implement a mechanism (like a queue) to manage customer arrivals and assign tables efficiently.
- Use Thread.sleep() or ScheduledExecutorService for simulating random arrival intervals of customers.