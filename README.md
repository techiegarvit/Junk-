# Online Banking System Web Application

## Overview
The Online Banking System is a Java-based web application that allows users to perform banking operations such as viewing transactions, managing profiles, and accessing banking services. It features role-based access where:
- **Admins** can manage user data, view transactions, and configure settings.
- **Customers** can log in to manage their accounts, view transaction history, and perform various banking functions.

The app is built with JSP for the front end, Java Servlets for the backend, and MySQL for data storage.

## Project Structure
The project follows a standard Maven structure, with packages structured as follows:
- `src/main/java/com.bankapp`: Contains the main application code and servlets.
- `src/main/java/com.bankapp.model`: Contains Java classes representing data models such as `User`.
- `src/main/java/com.bankapp.dao`: Contains Data Access Objects (DAOs) for interacting with the database.

## Features
1. **User Authentication**:
   - Secure login for both admin and customer roles.
   - Password hashing using `BCrypt` for secure storage.

2. **Admin Functionalities**:
   - View all user data.
   - Access and review transaction records.
   - Configure settings for system management.

3. **Customer Functionalities**:
   - View transaction history.
   - Perform transactions.
   - Manage personal profile and settings.

4. **Database Integration**:
   - MySQL database to store user, transaction, and account data.
   - Uses DAO pattern to interact with the database.

## Technologies Used
- **Frontend**: JSP, HTML, CSS
- **Backend**: Java, Servlets, JDBC, MySQL
- **Libraries**: BCrypt for password hashing, JDBC for database connection
- **Database**: MySQL
- **Build Tool**: Maven

## Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/online-banking-system.git
   cd online-banking-system
