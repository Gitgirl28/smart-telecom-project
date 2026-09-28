# Telecom Incident Intelligence & Resolution Assistant

Recovered Incident Service milestone.

Stack: Java 21, Spring Boot 4.1.1, Spring Web, Spring Data JPA, PostgreSQL, Maven.

PostgreSQL Docker:
docker run --name telecom-postgres -e POSTGRES_DB=telecomdb -e POSTGRES_USER=telecom -e POSTGRES_PASSWORD=telecompass -p 5432:5432 -d postgres:16

Run:
mvn spring-boot:run

Endpoints:
POST /api/incidents
GET /api/incidents
GET /api/incidents/{id}
PUT /api/incidents/{id}
DELETE /api/incidents/{id}
GET /api/incidents/search
GET /api/incidents/paged
GET /api/incidents/search/paged
