# Product Management Backend API

Spring Boot backend application dengan H2 in-memory database untuk Product Management System.

## 🚀 Tech Stack

- **Framework**: Spring Boot 3.5.6
- **Java Version**: 17
- **Database**: H2 In-Memory Database
- **Persistence**: Spring Data JPA
- **Build Tool**: Gradle
- **API Documentation**: Spring REST API

## ⚙️ Prerequisites

- **Java 17** or higher
- **Gradle** (included in wrapper)

## 🛠️ Installation & Setup

### 1. Navigate to Backend Directory
```bash
cd mgg-backend-test

# Using Gradle Wrapper
./gradlew bootRun

# Or using installed Gradle
gradle bootRun
```

## 🗄️ Database Configuration
H2 Database (In-Memory)
JDBC URL: jdbc:h2:mem:product_db

Username: sa

Password: (empty)

### Access H2 Console
Start the application

Navigate to: http://localhost:8080/h2-console

Use credentials above

Connect to database

## DB Schema
DB schema in folder resource with filename schema.sql

## 🔗 Frontend Integration
The backend is designed to work with the React frontend. Make sure the frontend is running on http://localhost:3000.

For any issues, check:

Backend is running on port 8080

H2 console is accessible

CORS configuration is correct

API endpoints return expected responses
