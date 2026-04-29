---
name: add-kafka-flow
description: Add or extend a Kafka-based event flow in the microservice demo, including event models, producers, consumers, and runtime configuration.
---

# Goal
Add a new Kafka event flow cleanly to the repository.

# Instructions
When this skill is used:

1. Identify the source service that publishes the event.
2. Identify the consumer service or services.
3. Define the event name and topic name clearly.
4. Keep naming explicit and consistent with the existing style:
    - booking-created
    - calendar-entry-created
    - notification-sent
5. Add or update:
    - Kotlin event model
    - producer logic
    - listener logic
    - Kafka configuration if necessary
6. Check whether Docker Compose or environment variables need changes.
7. Explain the final event flow in plain language.

# Output requirements
Always include:
- publisher service
- consumer service(s)
- topic name
- event payload type
- expected visible result in Kafka UI