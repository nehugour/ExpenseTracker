<<<<<<< HEAD
# ExpenseTracker
=======
# Daily Expenses Sharing Application

## Objective

This application allows users to add expenses and split them based on three different methods: equal, exact amounts, and percentages. It includes features for user management, expense management, and generating downloadable balance sheets.

## Requirements

- **User Management**
  - Users should have an email, name, and mobile number.

- **Expense Management**
  - Users can add expenses.
  - Expenses can be split using:
    - **Equal Split:** Divide equally among all participants.
    - **Exact Amount:** Specify the exact amount each participant owes.
    - **Percentage:** Specify the percentage each participant owes.

- **Balance Sheet**
  - Show individual expenses.
  - Show overall expenses for all users.
  - Provide a feature to download the balance sheet.

## Features

- **User Endpoints**
  - Create a new user.
  - Retrieve user details.

- **Expense Endpoints**
  - Add an expense.
  - Retrieve individual user expenses.
  - Retrieve overall expenses.
  - Download the balance sheet.

- **Validation**
  - Validate user inputs.
  - Ensure percentages in the percentage split method add up to 100%.

## Setup and Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/your-repository.git
   cd your-repository
   
2.) Install Dependencies

Ensure you have JDK 21 and Maven installed. Run the following command to install project dependencies:
mvn install
Configure Database

Update application.properties with your database configuration:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase

spring.datasource.username=yourusername

spring.datasource.password=yourpassword
Run the Application

Start the application using Maven:
mvn spring-boot:run
The application will be available at http://localhost:8080.

API Endpoints
User Endpoints

POST /users - Create a new user.
GET /users/{id} - Retrieve user details.
Expense Endpoints

POST /expenses - Add an expense.
GET /expenses/users/{id} - Retrieve individual user expenses.
GET /expenses/overall - Retrieve overall expenses.
GET /expenses/balance-sheet - Download balance sheet.
Error Handling
The application includes basic error handling. 
>>>>>>> origin/master
