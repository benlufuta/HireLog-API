# HireLog API

HireLog is a RESTful backend service for logging and tracking job applications throughout the hiring process.

This project is being built as a production-style Spring Boot application, emphasizing clean architecture, proper validation, and scalable backend design.

> $${\color{green}Status: Actively under development./}$$

---

## Project Vision

HireLog is designed to provide a structured and organized way to manage the job search process. 

The API enables users to:

- Store and manage job applications
- Track application progress across hiring stages
- Schedule follow-ups
- Filter and analyze job search activity
- Serve as a foundation for future authentication and deployment

The primary objective of this project is to demonstrate strong backend engineering skills using Java and Spring Boot.

---

## MVP Features (In Progress)

The following features are being implemented incrementally:

- Create, update, and delete job applications
- Structured status tracking (Saved, Applied, Interviewing, Offer, Rejected, etc.)
- Automatic `dateApplied` default handling
- Follow-up scheduling with domain validation rules
- Filtering, sorting, and pagination
- Analytics-ready endpoints for reporting insights

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## Architecture

The application follows a layered architecture to ensure clear separation of concerns:

- **Controller Layer** — REST API endpoints
- **Service Layer** — Business logic and validation
- **Repository Layer** — Data access abstraction via JPA
- **Entity & DTO Separation** — Clean API contracts and internal domain models

This structure reflects real-world backend systems and supports long-term scalability and maintainability.

---

## Planned API Endpoints (MVP)

- `POST /applications`
- `GET /applications`
- `GET /applications/{id}`
- `PUT /applications/{id}`
- `DELETE /applications/{id}`

Endpoints are being implemented and tested incrementally.

---

## Initial Data Model (MVP)

### Application
- id
- companyName
- roleTitle
- status
- dateApplied
- nextFollowUpDate
- notes

Future relational expansion is planned (see below).

---

## Future Enhancements

Post-MVP improvements can include:

- Interview tracking (One-to-Many relationship)
- Recruiter contact management
- JWT authentication & role-based authorization
- Global exception handling standardization
- Docker containerization
- AWS deployment (EC2, S3, RDS, etc.)
- CI/CD integration

---

## Learning Objectives

This project is being built to:

- Strengthen backend architecture design
- Apply Spring Boot best practices
- Implement robust validation and error handling
- Design scalable relational data models
- Simulate production-style backend development

---

## Running the Project (Coming Soon)

Setup instructions will be finalized after MVP completion.

Planned steps:

1. Clone repository
2. Configure MySQL database
3. Update `application.properties`
4. Run with Maven

---

## License

This project is developed for educational and portfolio purposes.