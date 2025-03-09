# Library Management System

## Project Description
The **Library Management System** is a REST application that simulates basic library operations. Customers (members) can borrow and return books, check available books. Employees (librarians) manage the book inventory, issue books to members, and maintain transaction logs.

### Key Features:
- **Customer Features:**
  - Register as a library member
  - View available books in the library
  - Borrow and return books
- **Employee Features:**
  - Add, remove, and update books in the library
  - Issue and return books to members
  - View member account details and transaction history
  - Generate logs of all transactions

### System Validation:
- Prevent customers from borrowing more books than the allowed limit.
- Reject book returns that have already been processed.
- Log all transactions, including book issues and returns.

## Technologies Used
This project is built using the following technologies:
- **Java 17**: For programming logic and functionality
- **PostgreSQL**: For managing the database of books and members
- **JDBC**: For database connectivity between Java and PostgreSQL
- **JUnit**: For unit testing the application logic
- **Log4j**: For logging events and debugging the application

## Features
- **Signup & Login**: Employees and customers can sign up and log in using their credentials to access respective dashboards.
- **Customer Module**: Allows customers to view books, borrow and return them.
- **Employee Module**: Allows employees to manage books, issue and return books, and track transactions.
- **Logging**: Transactions are logged using **Log4j**, which makes it easier to track all actions.

## To-Do List
Future improvements and additional features for the system include:
- **Book Reservation**: Allow customers to reserve books that are currently unavailable.
- **User Interface Enhancements**: Enhance the user interaction for a better experience.
- **Book Recommendations**: Add a feature to recommend books based on customer borrowing history.

## Getting Started

### Prerequisites:
Before running the project, ensure you have the following installed on your machine:
- **Java 8 or higher**: Required to compile and run the application.
- **PostgreSQL**: To store library and member data.
- **IntelliJ**: Recommended for running the Java project.

### Installation:
1. **Clone the Repository**:
   Clone the GitHub repository to your local machine by running:
   ```bash
   git clone https://github.com/urjaswitasingh/LibraryApplication.git
