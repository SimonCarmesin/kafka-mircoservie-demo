---
name: analyze-issue
description: Analyze a requested feature or issue for this Kafka microservice demo and produce a scoped implementation plan before coding.
---

# Goal
Analyze a requested change for this repository before implementation.

# Repository context
This repository is a Kafka-based Kotlin microservice demo with these services:
- booking-service
- calendar-service
- notification-service

The main architectural pattern is:
- external request enters through booking-service
- internal communication happens via Kafka events
- docker-compose.yml in the repo root is part of the system

# Instructions
When this skill is used:

1. Read the request carefully.
2. Identify which service or services are affected.
3. Identify whether the change affects:
   - REST endpoints
   - Kafka producers
   - Kafka consumers
   - event models
   - Docker Compose
   - configuration files
4. Identify whether a new topic or event type is required.
5. Prefer the smallest clean implementation that fits the current architecture.
6. Do not implement yet unless explicitly asked.

# Output format
Return exactly these sections:

## Scope
List the affected services and files at a high level.

## Event flow impact
Explain whether existing Kafka flow changes or a new flow is added.

## Implementation plan
Give a short numbered plan with 3 to 7 steps.

## Risks or checks
List anything that should be verified before coding.