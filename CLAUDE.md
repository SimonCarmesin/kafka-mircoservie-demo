# Project: kafka-microservice-demo

## Purpose
This repository is a learning and demo project for event-driven microservices with Kotlin, Spring Boot, Kafka, and Docker Compose.

The goal is to evolve the system step by step while keeping the architecture understandable and small enough for experimentation.

## Current architecture
The repository currently contains these services:

- `booking-service`
- `calendar-service`
- `notification-service`

Infrastructure in the repo root:

- `docker-compose.yml`
- `README.md`

## Service responsibilities

### booking-service
- External entrypoint into the system
- Exposes REST endpoints
- Accepts booking requests
- Publishes booking events to Kafka

### calendar-service
- Consumes booking-related Kafka events
- Creates follow-up calendar events
- Publishes follow-up events when appropriate

### notification-service
- Consumes booking-related Kafka events
- Creates notification-related follow-up events when appropriate

## Architectural rules
- Keep Kotlin, Spring Boot, Kafka, and Docker Compose as the main stack.
- Prefer event-driven communication between internal services.
- Do not introduce direct REST calls between internal services unless explicitly requested.
- The external entrypoint should stay in `booking-service` unless a new external service is intentionally added.
- Preserve the current microservice structure unless there is a strong reason to refactor it.
- Keep changes small, explicit, and easy to review.

## Kafka rules
- Treat Kafka topics as domain event channels.
- Prefer clear event names such as `booking-created`, `calendar-entry-created`, and `notification-sent`.
- When introducing a new event, identify:
    - which service publishes it
    - which service consumes it
    - whether Docker Compose or configuration files must be updated
- Keep event payloads simple and explicit.
- Prefer JSON event payloads with strongly typed Kotlin models.

## Docker and runtime rules
- `docker-compose.yml` in the repo root is part of the system and must stay consistent with service changes.
- When changing ports, environment variables, or service dependencies, update Docker Compose as part of the same change.
- Prefer solutions that work both locally and in Docker where reasonable.

## Change workflow
When working on an issue or feature:
1. First understand the existing architecture and identify affected services.
2. Propose a short implementation plan before large changes.
3. Make the smallest useful change that solves the issue cleanly.
4. Keep changes scoped to the relevant service(s).
5. Summarize what changed, why, and how to test it.

## Coding preferences
- Prefer simple and readable Kotlin over clever abstractions.
- Keep Spring configuration explicit when it improves understanding.
- Avoid introducing unnecessary frameworks, infrastructure, or databases.
- Favor small DTOs and event classes with clear names.
- Keep logs useful for understanding event flow during local development.

## Testing and verification
When making code changes, always explain:
- which service(s) were changed
- which topic(s) are involved
- how to test the behavior
- what should be visible in Kafka UI or logs

## Future direction
This repository may later include:
- a frontend service
- additional Kafka consumers/producers
- GitHub issue-driven agent workflows
- MCP integration
- optional RAG/documentation support

Until then, optimize for clarity, learning value, and maintainability.