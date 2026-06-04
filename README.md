# Employees API

A RESTful API for managing employees, built with Spring Boot and MySQL.

## Technologies

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- MySQL
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

### Run

```bash
./mvnw spring-boot:run
```

The API will start on `http://localhost:8080`.

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
