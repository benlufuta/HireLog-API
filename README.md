# HireLog API

HireLog API is a backend application for logging, tracking, and managing job applications throughout the job search process.

The project is being built with Java and Spring Boot as a hands-on learning project focused on backend engineering, REST API design, testing, and clean architecture principles.

---

## Project Status

Work In Progress — Actively Under Development

Current development focuses on building a RESTful API before integrating persistence, authentication, and deployment.

---

## Features

### Implemented

- Create job applications
- Retrieve all applications
- Retrieve application by ID
- Track application status
    - SAVED
    - APPLIED
    - INTERVIEWING
    - OFFER
    - REJECTED
    - WITHDRAWN
    - GHOSTED
- Follow-up date tracking
- Domain validation rules
- Unit tests for domain and service layers
- Swagger/OpenAPI integration

### In Progress

- Update application endpoints
- Delete application endpoints
- Filter applications by status
- Request validation
- DTO implementation
- Improved API responses and error handling

### Planned

- Database integration (MySQL)
- Spring Data JPA
- Authentication & Authorization
- Docker support
- AWS deployment
- Analytics and reporting endpoints

---

## Tech Stack

### Backend

- Java 17
- Spring Boot
- Maven

### Testing

- JUnit 5

### API Documentation

- Swagger / OpenAPI

---

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.benlufuta.hirelog
│   │       ├── controller
│   │       ├── domain
│   │       └── service
│   └── resources
│
└── test
    └── java
        └── com.benlufuta.hirelog
            ├── domain
            └── service
```

---

## Current API Endpoints

### Applications

| Method | Endpoint | Description |
|----------|----------|----------|
| GET | `/applications` | Retrieve all applications |
| GET | `/applications/{id}` | Retrieve an application by ID |
| POST | `/applications` | Create a new application |

---

## Running Locally

### Clone Repository

```bash
git clone https://github.com/benlufuta/HireLog-API.git
```

### Navigate To Project

```bash
cd HireLog-API
```

### Run Application

```bash
./mvnw spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

or

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Example Response

```json
{
  "id": 1,
  "companyName": "Google",
  "roleTitle": "Software Engineer Intern",
  "status": "APPLIED",
  "dateApplied": "2026-03-26",
  "jobUrl": "google.com",
  "nextFollowUpDate": "2026-04-02",
  "notes": "Strong backend role"
}
```

---

## Learning Goals

This project is being used to gain practical experience with:

- Object-Oriented Programming
- Unit Testing
- REST APIs
- Spring Boot
- Maven
- Database Design
- Backend Architecture
- AWS Deployment

---

## Author

Ben Lufuta

GitHub: https://github.com/benlufuta