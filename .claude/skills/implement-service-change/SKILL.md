---
name: implement-service-change
description: Implement a scoped change in one or more services while preserving the current Kotlin, Spring Boot, Kafka, and Docker Compose architecture.
---

# Goal
Implement a requested change in this repository with minimal, focused edits.

# Instructions
When this skill is used:

1. Start from an approved plan or from a clearly scoped request.
2. Keep the change as small as possible.
3. Preserve the existing architecture:
    - booking-service is the main external entrypoint
    - internal communication should remain event-driven unless explicitly told otherwise
4. Update only the relevant services and shared runtime/config files.
5. If adding a new event:
    - define or update the event model
    - update producer logic
    - update consumer logic where needed
    - update configuration if required
6. If Docker behavior changes, update docker-compose.yml in the same change.
7. After implementation, summarize:
    - files changed
    - services changed
    - topics involved
    - how to test

# Constraints
- Do not introduce unnecessary frameworks.
- Do not refactor unrelated code.
- Prefer readability over abstraction.