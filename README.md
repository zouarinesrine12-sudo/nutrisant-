# shop API
API RESET  the program is dedicated to command healthul meals  regarding your regime
## functions:
-management of users (creation,consultation,suppression)
technologiesjava 17 ,Spring boot 4 ,string data jpa,H2, Swagger (springdoc), Maven
# Shop API

REST API for ordering healthy meals tailored to the customer's diet, built with Spring Boot.

> 🚧 Work in progress: the user module is complete; meals and orders are coming next.

## Features

- User management: create, list, view, update and delete
- Input validation
- Password hashing (BCrypt)
- Centralized error handling (400, 404, 409)
- Interactive API documentation with Swagger

## Technologies

Java 17, Spring Boot 4, Spring Data JPA, H2, Swagger (springdoc), Maven

## Prerequisites

- JDK 17 or higher
- Git

## Run the project

```bash
git clone https://github.com/zouarinesrine12-sudo/YOUR-REPO.git
cd YOUR-REPO
./mvnw spring-boot:run
```

On Windows, use `.\mvnw.cmd spring-boot:run`.

The API starts on `http://localhost:8080`.

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- H2 console: `http://localhost:8080/h2-console`

## Endpoints

| Method | Path | Description | Success |
|---|---|---|---|
| POST | `/api/v1/users` | Create a user | 201 |
| GET | `/api/v1/users` | List users | 200 |
| GET | `/api/v1/users/{id}` | Get a user | 200 |
| PUT | `/api/v1/users/{id}` | Update a user | 200 |
| DELETE | `/api/v1/users/{id}` | Delete a user | 204 |

Errors: 400 (invalid data), 404 (not found), 409 (email already used).

## Author

Nesrine Zouari