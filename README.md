# restAPIdemo-springboot

## 1) Project Overview
`restAPIdemo-springboot` is a Spring Boot demo application that exposes a simple REST API for retrieving user details by ID. It demonstrates core web service concepts such as request mapping, dependency injection, and JSON responses.

This project follows the RESTful portion of the **Web Services - Tutorial** and implements a minimal user lookup service.

## 2) Web Services Introduction (from tutorial)
Web services are standardized ways for applications to communicate over networks using common protocols (such as HTTP) and data formats (such as JSON or XML).

### RESTful Web Services
- Use HTTP methods such as **GET, POST, PUT, DELETE**
- Use simple URL endpoints
- Commonly exchange **JSON** data
- Well-suited for web/mobile apps due to simplicity and scalability

### SOAP Web Services
- Use the SOAP protocol
- Exchange data in **XML**
- Typically used in enterprise scenarios needing stricter contracts, security, and transaction support

> Note: This repository contains the REST demo implementation. SOAP content is covered in the tutorial PDF for learning comparison.

## 3) Project Structure
Main package: `com.example.restAPIdemo`

- `src/main/java/com/example/restAPIdemo/RestApIdemoApplication.java`
  - Spring Boot entry point (`@SpringBootApplication`)
- `src/main/java/com/example/restAPIdemo/api/model/User.java`
  - User model with fields: `id`, `name`, `age`, `email`
- `src/main/java/com/example/restAPIdemo/service/UserService.java`
  - Service layer (`@Service`) with an in-memory list of sample users
  - Provides `getUser(Integer id)` lookup logic
- `src/main/java/com/example/restAPIdemo/api/controller/UserController.java`
  - REST controller (`@RestController`)
  - Exposes endpoint to fetch a user by ID

## 4) REST API Endpoints
Base URL (local): `http://localhost:8080`

| Method | Endpoint | Description |
|---|---|---|
| GET | `/user/{id}` | Returns a user object for the given `id` |

### Endpoint details
- **Path variable:** `id` (Integer)
- Sample valid IDs from seeded data: `1`, `2`, `3`

## 5) Setup Instructions
### Prerequisites
- Java 21
- Maven (or use Maven Wrapper included in repo)

### Run locally
1. Clone/download this repository and open a terminal in the project root (`restAPIdemo-springboot`)
2. Start the app:
   - Linux/macOS:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Windows:
     ```bat
     mvnw.cmd spring-boot:run
     ```
3. Application runs on `http://localhost:8080`

## 6) Testing the Application (Postman)
1. Start the Spring Boot app.
2. Open Postman.
3. Create a new request:
   - Method: `GET`
   - URL: `http://localhost:8080/user/1`
4. Click **Send**.
5. Repeat for other IDs (`2`, `3`).

If an unknown ID is requested (for example `/user/99`), current implementation returns `null` in the response body.

## 7) Technology Stack
- **Java** 21
- **Spring Boot**
- **Maven** (via Maven Wrapper)
- **Spring Web MVC**

## 8) API Documentation (Example Requests & Responses)
### Example 1: Fetch user with ID 1
Request:
```http
GET /user/1 HTTP/1.1
Host: localhost:8080
```

cURL:
```bash
curl http://localhost:8080/user/1
```

Response:
```json
{
  "id": 1,
  "name": "Nimal",
  "age": 23,
  "email": "Nimal@gmail.com"
}
```

### Example 2: Fetch user with ID 2
Request:
```bash
curl http://localhost:8080/user/2
```

Response:
```json
{
  "id": 2,
  "name": "Bimal",
  "age": 22,
  "email": "Bimal@gmail.com"
}
```

### Example 3: Unknown user
Request:
```bash
curl http://localhost:8080/user/99
```

Response:
```json
null
```

---

## Tutorial Reference
Source tutorial PDF used for this README:
- [`Web Services - Tutorial.pdf`](./Web%20Services%20-%20Tutorial.pdf)
