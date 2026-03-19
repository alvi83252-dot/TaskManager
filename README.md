TaskManager Backend
A Spring Boot backend for managing tasks with authentication, PostgreSQL persistence, and production-ready DevOps features including Docker and CI/CD.

🚀 Features
- User authentication with JWT
- CRUD operations for tasks
- PostgreSQL database integration
- RESTful API design
- Secure endpoints with Spring Security

⚙️ Tech Stack
- Java 17
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Docker
- GitHub Actions (CI/CD)

🐳 Docker Setup
- Build the image
- docker build -t taskmanager-app .
- Run the container
- docker run --env-file .env -p 8081:8080 taskmanager-app
  
🔐 Environment Variables
Create a .env file in the root directory:
- SPRING_DATASOURCE_URL=jdbc:postgresql://<host>:5432/<db>
- SPRING_DATASOURCE_USERNAME=<username>
- SPRING_DATASOURCE_PASSWORD=<password>
- JWT_SECRET=mysupersecretkeymysupersecretkey12345

🌐 Deployed Backend
https://taskmanager-1-x9vg.onrender.com
Note: API routes are protected by JWT authentication. Unauthenticated requests may return 403 Forbidden.

🧪 API Endpoints
- Health Check
- GET /health
- Tasks
- GET /api/tasks
- POST /api/tasks
- PUT /api/tasks/{id}
- DELETE /api/tasks/{id}
- Requires authentication (JWT)

🔄 CI/CD Pipeline
This project uses GitHub Actions to:
- Build the application
- Run tests
- Build Docker image
- Triggered automatically on every push.

📊 Logging & Monitoring
- Application logging configured via Spring Boot
- Request-level logging implemented using a custom filter
- Logs available via:
- Docker logs (docker logs <container>)
- Application log file (logs/app.log)

📦 Project Structure
src/
 ├── main/
 │   ├── java/com/taskmanager/
 │   │   ├── controller/
 │   │   ├── service/
 │   │   ├── repository/
 │   │   ├── security/
 │   │   └── config/
 │   └── resources/
 │       └── application.properties
 
▶️ Running Locally
- mvn clean install
- mvn spring-boot:run

📌 Notes
- Uses external PostgreSQL (Render)
- Dockerized for consistent deployment
- Includes operational logging for request tracking

👤 Author
--- Faizan
