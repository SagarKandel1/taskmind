# TaskMind (Phase 1)

TaskMind is a Spring Boot backend (Phase 1) that accepts task descriptions and returns AI-generated suggestions.
This skeleton implements a lightweight REST API and integrates with the OpenAI REST API via WebClient.

## Contents
- Java 17, Spring Boot 3.5.4
- Endpoints: `POST /api/ai/suggest-task`
- No database in this phase (in-memory / stateless)

## How to run
1. Set your OpenAI API key in `src/main/resources/application.properties`:
   ```properties
   openai.api.key=sk-REPLACE_WITH_YOUR_KEY
   ```
2. Build and run with Maven:
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```
3. Test with curl/Postman:
   ```bash
   curl -X POST http://localhost:8080/api/ai/suggest-task -H "Content-Type: application/json" -d '{ "prompt": "Suggest a task to improve backend code quality" }'
   ```
