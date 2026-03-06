# Live API
Base URL: https://taskmanager-1-x9vg.onrender.com
Note: The service runs on the Render free tier and may take 30 seconds to wake up after inactivity.

# Features
- User registration and login
- JWT based authentication
- Protected API endpoints
- Task CRUD operations
- PostgreSQL database persistence
- Spring Security Authorization
- Cloud deployment on Render

# Tech Stack
Backend:
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT Authentication

Database:
- PostgreSQL

Deployment:
- Render (Web Service + PostgreSQL)

Tools:
- Maven
- Postman

# API Endpoints
# Authentication
Register: POST /api/auth/register
Body: 
{
  "username": "tester01",
  "email": "tester01@example.com",
  "password": "Password123!"
}

Login: POST /api/auth/login?username=tester01&password=Password123!
returns a JWT token

# Task Endpoints (Protected)
All tasks endpoints require a JWT token:
- Authorization: Bearer <token>
Get Tasks: GET /api/tasks
Returns all tasks belonging to the authenticated user.

Create Tasks: POST /api/tasks
Body: 
{
  "title": "Finish project",
  "description": "Deploy backend API",
  "completed": false
}

Update Tasks: PUT /api/tasks/{id}
Body: 
{
  "title": "Finished",
  "description": "Deploy backend API",
  "completed": false
}

Delete Task: DELETE /api/tasks/{id}

# Architecture
Client (Postman / Frontend)
        │
        ▼
Spring Boot REST API
        │
Spring Security + JWT
        │
Spring Data JPA
        │
PostgreSQL Database
        │
Render Cloud Deployment

# Running Locally
Clone the repository: git clone https://github.com/faiza/TaskManager.git(https://github.com/alvi83252-dot/TaskManager.git

Install dependencies: ./mvnw clean install 
Run the application: ./mvnw spring-boot:run (PowerShell)
API will start on: http://localhost:8080

# Deployment 
The application is deployed on Render with:
- A Spring Boot Web Service
- A PostgreSQL database
- Environment variables for database credentials
- Automatic builds from GitHub

# Future Improvements
- Frontend UI
- Swagger API documentation
- Role-based authorization
- Docker containerization
- Automated tests

# Author
Faizan Alvi
