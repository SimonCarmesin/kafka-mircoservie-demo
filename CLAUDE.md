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

## Default issue workflow
When asked to work on an issue, follow this sequence unless explicitly told otherwise:
1. Read the GitHub issue.
2. Analyze the affected services, topics, configs, and Docker setup.
3. Propose a short implementation plan.
4. After approval, create a feature branch.
5. Implement the change.
6. Review the diff and create clear commits.
7. Push the branch.
8. Create a GitHub pull request with a complete summary.
9. Only merge when explicitly requested by the user.

## Git workflow rules
- Never commit directly to `main`.
- For every implementation task, create a dedicated feature branch first.
- Use branch names based on the issue or feature, for example:
    - `feat/analytics-service`
    - `feat/frontend-bookings`
    - `fix/<short-description>`
- After implementation:
    1. review changed files
    2. create clear commits
    3. push the branch
    4. create a GitHub pull request
- Pull request descriptions must summarize:
    - what changed
    - which services were affected
    - which Kafka topics or event flows were affected
    - how the change can be tested
- If working from a GitHub issue, reference the issue in the PR description.
- Documentation for changes should live in the repository history and GitHub pull requests, not only in terminal output.

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