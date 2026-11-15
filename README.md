# Grand Horizon Hotel Management System

A Java console-based Hotel Management System developed as an Object-Oriented Programming (OOP) assignment.

## Project Overview

The Grand Horizon Hotel Management System is designed to manage basic hotel operations through a menu-driven console interface. It provides functions for guest registration, room management, booking creation, payment recording, and employee management.

The project demonstrates the practical implementation of Java Object-Oriented Programming concepts.

## Features

- **Guest Management:** Register, display, and search guest records.
- **Room Management:** View and search hotel rooms, including their categories, prices, and availability.
- **Booking Management:** Create bookings, select rooms, enter stay dates, and calculate booking costs.
- **Payment Management:** Record payments and search payment records.
- **Employee Management:** Register, display, and search employee information.

## Room Categories

The system contains 50 rooms divided into three categories:

| Room Category | Number of Rooms |
|---|---:|
| Standard Room | 25 |
| Deluxe Room | 20 |
| VIP Room | 5 |
| **Total** | **50** |

## Object-Oriented Programming Concepts

The project demonstrates the following OOP principles:

1. **Encapsulation:** Private attributes with getter and setter methods.
2. **Inheritance:** Guest and Employee inherit from Person, while the room categories inherit from Room.
3. **Polymorphism:** Method overriding and runtime polymorphism using superclass references.
4. **Abstraction:** Abstract Person and Room classes with abstract methods.

## Technologies Used

- Java
- Java Scanner
- ArrayList
- LocalDate
- Visual Studio Code
- Java Development Kit (JDK)

## Project Structure

```text
Grand-Horizon-Hotel-Management-System/
│
├── src/
│   ├── Main.java
│   ├── HotelManagement.java
│   ├── Person.java
│   ├── Guest.java
│   ├── Employee.java
│   ├── Room.java
│   ├── StandardRoom.java
│   ├── DeluxeRoom.java
│   ├── VIPRoom.java
│   ├── Booking.java
│   └── Payment.java
│
├── docs/
├── screenshots/
├── .gitignore
└── README.md
```

## How to Run the Application

### Requirements

- Java Development Kit (JDK) installed.
- Terminal or command-line interface.

### Compilation

Open the project directory and navigate to the `src` folder:

```bash
cd src
javac *.java
```

### Execution

Run the application using:

```bash
java Main
```

## Project Purpose

This project was developed for educational purposes to demonstrate Java programming skills and the application of Object-Oriented Programming concepts in a practical management system.