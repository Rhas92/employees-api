# Employees API

A RESTful API for managing employees, built with Spring Boot and MySQL.

## Technologies
- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- Spring Security + JWT (jjwt)
- MySQL
- Docker & Docker Compose
- Swagger / OpenAPI

## Getting Started

### Prerequisites

- Java 21+
- MySQL running on port 3306
- Database `practice` created

### Configuration

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/practice
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run with Docker (recommended)
The easiest way to run the app and the database together:

```bash
docker compose up --build
```

This starts the API and a MySQL container, already connected. The API will be available at `http://localhost:8080`.

## Authentication
This API is secured with JWT. You must log in to obtain a token, then send it on every request.

A default user is seeded on startup:
- **username:** `ramon`
- **password:** `1234`

### 1. Log in to get a token
```bash
curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/json" \
  -d '{"username":"ramon","password":"1234"}'
```

### 2. Use the token on protected endpoints
```bash
curl http://localhost:8080/employees \
  -H "Authorization: Bearer YOUR_TOKEN_HERE"
```

In Swagger, use the **Authorize 🔒** button and paste the token.

## API Documentation

Interactive documentation available at:

```
http://localhost:8080/swagger-ui.html
```

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by id |
| GET | `/employees/department/{department}` | Get employees by department |
| POST | `/employees` | Create employee |
| POST | `/login` | Authenticate and receive a JWT (public) |
| PUT | `/employees/{id}` | Update employee |
| DELETE | `/employees/{id}` | Delete employee |

## Request Body

```json
{
  "name": "Alice",
  "salary": 55000,
  "department": "ENGINEERING"
}
```
