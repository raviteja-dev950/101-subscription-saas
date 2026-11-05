# Contributing to 101-subscription-saas

Tier 10 System Design Level - SCALE PROJECT - 101/102 98%

## How to Contribute

1. Fork the repo
2. Create branch feature/your-feature
3. Commit changes
4. Push and create PR

## Code Style

- Java 17
- Spring Boot 3.2.5
- Builder Pattern Subscription.Builder
- Strategy Pattern Plan vs Status vs Tenant vs Hybrid
- trim() fix for \n bug - Same as 99/100
- Caffeine Cache 1000 max 600s Stats
- Security Headers nosniff DENY XSS
- JUnit 5 6/6 Green Bar

## Testing

- Run JUnit: SubscriptionServiceTest 6/6 Green
- Test endpoints: /api/subscriptions, /strategy?type=plan&filter=PRO etc.

## Bug Fixes

- data_value column fix for reserved keyword value
- trim() fix for resource/plan \n bug - FIXED [] to 1 item
- META-INF delete fix
- Docker Multi-Stage fix for openjdk not found + COPY target error

## Deployment

- Docker Multi-Stage: maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine
- Render: PORT=10000, Live https://one01-subscription-saas.onrender.com
- Local: Port 8103

Thank you!