# TaskMind
TaskMind is a Spring Boot backend application focused on task management enhanced with AI assistance. This project supports user registration and login secured by JWT authentication, providing protected AI features.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Setup & Installation](#setup--installation)  
- [Running the Application](#running-the-application)  
- [API Endpoints](#api-endpoints)  
- [Security](#security)  
- [Future Improvements](#future-improvements)  
- [Troubleshooting](#troubleshooting)  
- [License](#license)  
- [Contact](#contact)  

---

## Features

- User registration with encrypted password storage  
- User login with JWT token issuance  
- JWT authentication securing AI-related endpoints  
- AI controller scaffold for future OpenAI integration  
- In-memory H2 database for quick testing  
- Clear project structure with Spring Boot best practices  

---

## Tech Stack

- Java 17  
- Spring Boot 3.5.4  
- Spring Security (JWT)  
- Spring Data JPA  
- H2 Database (in-memory)  
- Maven  
- Optional: OpenAI SDK (for AI features)  

---

## Setup & Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/taskmind.git
   cd taskmind
2. Build the project

mvn clean install

3. Run the application
mvn spring-boot:run

4. Access app 
Open http://localhost:8080

---

## Running the Application in the Future

Ensure Java 17 and Maven are installed.
Run mvn clean install if you make changes.
Run mvn spring-boot:run to start.
Use API clients like Postman to interact with endpoints.
Check application.properties for configs (e.g., JWT secret, DB settings).
For persistent storage, replace H2 with PostgreSQL or another DB.


---

## API Endpoints

Auth
| Endpoint             | Method | Description                | Request Body                                 | Response                     |
| -------------------- | ------ | -------------------------- | -------------------------------------------- | ---------------------------- |
| `/api/auth/register` | POST   | Register a new user        | `{ "username": "user", "password": "pass" }` | Success message              |
| `/api/auth/login`    | POST   | Authenticate user, get JWT | `{ "username": "user", "password": "pass" }` | `{ "token": "<JWT Token>" }` |

AI (Protected)
| Endpoint          | Method | Description                | Headers                         | Response                                          |
| ----------------- | ------ | -------------------------- | ------------------------------- | ------------------------------------------------- |
| `/api/ai/profile` | GET    | Protected AI test endpoint | `Authorization: Bearer <token>` | `{ "message": "This is protected AI endpoint!" }` |

---

## Security

Passwords are hashed with BCrypt before storage.

JWT tokens must be provided in Authorization headers for protected routes.

JWT secret key stored in application.properties (for production, use environment variables).

Token expiration and refresh mechanisms can be added later.

--

## Future Improvements

Integrate actual OpenAI API calls in AIController.

Implement token refresh endpoints.

Switch from H2 to persistent database (PostgreSQL, MySQL).

Add Swagger/OpenAPI documentation.

Add roles and permissions for users.

Improve error handling and input validation.

Add frontend UI or mobile app integration.

--

## Troubleshooting

Port in use? Change port in src/main/resources/application.properties (server.port).

JWT errors? Ensure token is valid and provided in Authorization header.

Build fails? Check Java version, Maven version, and dependencies.

H2 data lost? This is normal for in-memory DB; use persistent DB for production.

--
## License

This project is licensed under the MIT License. See the LICENSE file for details.



