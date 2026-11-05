# 🚀 Project 101 – Subscription SaaS (Your SaaS Idea) | System Design Level | Full Stack DevOps

![Java 17](https://img.shields.io/badge/Java-17-E76F00?logo=openjdk&logoColor=white)
![Spring Boot 3.2.5](https://img.shields.io/badge/Spring%20Boot-3.2.5-6DB33F?logo=springboot&logoColor=white)
![Caching](https://img.shields.io/badge/Caching-Caffeine%201000%20max%20600s%20expire%20Stats-blue?logo=redis&logoColor=white)
![Cache Stats](https://img.shields.io/badge/Cache%20Stats-recordStats%20enabled-brightgreen)
![Security](https://img.shields.io/badge/Security-Headers%20nosniff%20DENY%20XSS-red?logo=springsecurity&logoColor=white)
![Builder Pattern](https://img.shields.io/badge/Builder%20Pattern-Subscription.Builder%20Fluent%20API-success?logo=java&logoColor=white)
![Strategy Pattern](https://img.shields.io/badge/Strategy%20Pattern-Plan%20vs%20Status%20vs%20Tenant%20vs%20Hybrid-yellow?logo=elasticsearch&logoColor=white)
![Repository Pattern](https://img.shields.io/badge/Repository%20Pattern-JpaRepository-6DB33F)
![H2 Database](https://img.shields.io/badge/H2-Database%20saasdb-003545?logo=h2&logoColor=white)
![viewCount](https://img.shields.io/badge/viewCount-Added%20%2B%20idx__plan%20%2B%20idx__tenant-orange)
![JUnit 5](https://img.shields.io/badge/JUnit-5%206%2F6%20Green-25A162?logo=junit5&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-Mocked%20Repo%20when%2Fverify-00BFFF)
![Subscription Pattern](https://img.shields.io/badge/Subscription-Pattern%20Plan%20Status%20Tenant%20Hybrid-blueviolet?logo=elasticsearch&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Multi--Stage-2496ED?logo=docker&logoColor=white)
![Render](https://img.shields.io/badge/Render-Live%203m50s-brightgreen?logo=render&logoColor=white)
![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10.1.20-D4AF00?logo=apachetomcat&logoColor=white)
![Port](https://img.shields.io/badge/Port-8103-00BFFF)
![Status](https://img.shields.io/badge/Status-Subscription%20SaaS%20Live%20Tier%2010-brightgreen)
![Tier 10](https://img.shields.io/badge/Tier%2010-System%20Design%20Level%20SCALE-blueviolet)

**Live URL:** https://one01-subscription-saas.onrender.com/

[![Live](https://img.shields.io/badge/Live-Render-brightgreen?style=for-the-badge&logo=render)](https://one01-subscription-saas.onrender.com)

Project 101 - Part of Java 102 Projects Challenge - System Design Level Tier 10 SCALE - Your SaaS Idea
---
**TIER 10 SCALE 101/102 - 99%**
---

# 📖 Project Overview

**Subscription SaaS (Your SaaS Idea)** is Project 101 of **Tier 10 – System Design Level – SCALE PROJECT**, developed using **Java 17**, **Spring Boot 3.2.5**, **Spring Cache Caffeine (CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats() - Redis pattern ready)**, **Security Headers (SecurityHeadersConfig WebMvcConfigurer + HandlerInterceptor X-Content-Type-Options nosniff + X-Frame-Options DENY + X-XSS-Protection)**, **Design Patterns (Builder Pattern Subscription.Builder Fluent API + Strategy Pattern Plan vs Status vs Tenant vs Hybrid + Repository Pattern JpaRepository + Caching Pattern Cache-aside)**, **Spring Data JPA**, **H2 Database saasdb + view_count + idx_plan + idx_tenant index**, **JUnit 5 + Mockito 6 tests Green Bar**, **Docker Multi-Stage (maven:3.9-eclipse-temurin-17 + eclipse-temurin:17-jdk-alpine + mkdir -p data)**, **Maven**, and **Apache Tomcat 10.1.20** in a **production System Design ready repo**.

Spring Boot REST API running on port 8103 locally (10000 on Render) with 12 endpoints + home `GET / returns live JSON {"project":"101-subscription-saas","status":"Live - Subscription SaaS - Tier 10 Scale","tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","caching":"Caffeine Cache - subscriptions cache - 1000 max, 600s expire - Stats enabled - Redis ready","saas":"Subscription Pattern - Plan Status Tenant Hybrid"}`, `GET /health -> {"status":"UP","cache":"Active - Caffeine - subscriptions, subscription - Stats enabled","security":"Headers Active","saas":"Active - Subscription Pattern - Plan Status Tenant Hybrid - Strategy Pattern"}`, `POST /api/subscriptions?plan=STARTER&status=TRIAL&tenantId=tenant-alpha&billingCycle=MONTHLY&dataValue=29.99&viewCount=0 -> 200 OK {id, plan, status, tenantId, billingCycle, dataValue, viewCount, createdAt}`, `GET /api/subscriptions -> List Subscription with viewCount + X-Cache: Caffeine`, `GET /api/subscriptions/strategy?type=plan&filter=PRO -> Plan-Strategy count 1 + plan PRO`, `GET /api/subscriptions/strategy?type=status&filter=ACTIVE -> Status-Strategy count 2 + status ACTIVE`, `GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha -> Tenant-Strategy count 2 FIXED from [] empty -> trim() fix + tenant-alpha`, `GET /api/subscriptions/strategy?type=hybrid -> Hybrid-Strategy count 4 sorted by price DESC 299.99, 99.99, 29.99, 9.99 + X-Strategy: Hybrid-Strategy`. This repo contains **Subscription.java Entity with Builder inner class**, **SubscriptionRepository.java**, **SubscriptionService.java**, **CacheConfig.java**, **SecurityHeadersConfig.java**, **SubscriptionController.java**, **SubscriptionServiceTest (JUnit 5 + Mockito 6 tests Green Bar)**. One `git push` gives full Subscription SaaS live.

This is Project 101 of Tier 10 - SCALE - After Audit Log (100), now real SaaS Idea base for Capstone OSS (102).

**Bug Fixed:** `Syntax error in SQL statement "create table subscriptions (... value float ...) expected "identifier""` - H2 reserved keyword `value` - Fixed by renaming field to `dataValue` with `@Column(name="data_value")` + backward compat `getValue()/setValue()` alias with `@JsonIgnore` to fix JSON conflict - Same pattern as 97 98 99 100 value fix.

**Bug Fixed:** `GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha returns [] empty but DB has tenant-alpha` - Postman Enter adds `\n` newline - `tenantId="tenant-alpha\n"` - Filter `"tenant-alpha".equals("tenant-alpha\n")` fails - Fixed by adding `trim()` in `createSubscription()` `cleanTenantId=tenantId.trim()` + `getSubscriptionByStrategy()` `cleanType=type.trim()` + `d.getTenantId().trim()` - BUILD SUCCESS 13.37 sec - Now demo11 returns 2 items CLEAN not [] - CRITICAL FIX - Same as 99 isolated fix + 100 resource fix count 0->2.

**Bug Fixed:** `Cannot load driver class: org.h2.Driver` - H2 scope runtime - Fixed by removing `<scope>runtime</scope>` + Maven Update Project + Force Update - Same pattern as Tier 9 H2 fix - 94 + 95 + 96 + 97 + 98 + 99 + 100 also.

**Bug Fixed:** `Unable to resolve name [org.hibernate.dialect.H2Dialect ] as strategy` - Extra newline space in application.properties - Fixed by removing `spring.jpa.database-platform` + `spring.datasource.driverClassName` lines + Fixing `password=update` misaligned - Fixed `spring.jpa.hibernate.ddl-auto=update` - BUILD SUCCESS 13.37 sec.

**Bug Fixed:** `URL must start with 'jdbc'` - Typo `dbc:h2:mem:saasdb` missing `j` - Fixed by correcting to `jdbc:h2:file:./data/saasdb` - BUILD SUCCESS 13.37s Tier 10 + Fixed `Table SUBSCRIPTIONS not found` by adding `ddl-auto=update`.

**Bug Fixed:** `SubscriptionController.java red errors - cannot find symbol Cacheable, CaffeineCacheManager` - META-INF folder bug - Eclipse creates `src/main/resources/META-INF` breaking Maven + Maven dependencies not downloaded - Fixed by deleting META-INF + deleting target + Maven Update Project Force Update - Same as 93/94/95/96/97/98/99/100 META-INF bug.

**Bug Fixed:** `docker.io/library/openjdk:17-jdk-slim: not found` - OpenJDK image deleted from Docker Hub - Fixed by changing to `eclipse-temurin:17-jdk-alpine` - Render Deploy failed - Same as 94 + 95 + 96 + 97 + 98 + 99 + 100.

**Bug Fixed:** `COPY target/*.jar app.jar ERROR: lstat /target: no such file or directory` - Docker build doesn't run mvn package - Fixed by using Multi-Stage Dockerfile `FROM maven:3.9-eclipse-temurin-17 AS build + COPY pom.xml + COPY src + RUN mvn clean package -DskipTests + FROM eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar` - Deploy succeeded Live 3m50s - Same as 94 + 95 + 96 + 97 + 98 + 99 + 100.

**Bug Fixed:** `POST /api/subscriptions -> 400 Bad Request` - Used `@RequestParam` with `@RequestBody` conflict + Query Params empty - Fixed by changing to `@RequestBody Subscription` + Setting Params tab in Postman Key Value plan status tenantId billingCycle dataValue - Same as 97 98 99 100 index bug - Now 200 OK id 1 price 29.99 - CLEAN without \n.

**Bug Fixed:** `GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha -> [] empty` - Used `equals` without trim but tenantId has `\n` - Fixed by adding `trim()` in Service - Same as 99 isolated bug + 100 resource bug - Now 200 OK count 2 Tenant-Strategy - FIXED from [].

**Bug Fixed:** `Was 2/2 tests Tier 5 - Not Tier 10 compliant + UnnecessaryStubbingException` - Only Entity + Format tests - No Builder + No Mockito + No Caching + No Security + No CONTRIBUTING.md - Stubbing both `findAllByOrderByCreatedAtDesc` and `findAll` in testGetAllSubscription_Mockito - Fixed by removing `when(repository.findAll())` + rebuilding to Tier 10 SCALE - Caffeine 1000 max 600s Stats + Security Headers + Builder Pattern + Strategy Pattern Plan vs Status vs Tenant vs Hybrid + Repository + Caching + JUnit5 Mockito 6 tests Green Bar Runs: 6/6 Errors: 0 Failures: 0 + viewCount + idx_plan + idx_tenant + CONTRIBUTING.md 12466 chars + Issues + 18 Badges + Architecture Diagram + Live Link + Docker Multi-Stage + Render Live 3m50s - Roadmap 100% Compliant.

---

# ✨ Features

- Scale Ready status API with JSON response - `{"project":"101-subscription-saas","status":"Live - Subscription SaaS - Tier 10 Scale","tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","caching":"Caffeine Cache - subscriptions cache - 1000 max, 600s expire - Stats enabled - Redis ready","saas":"Subscription Pattern - Plan Status Tenant Hybrid"}`
- Fully production Subscription SaaS API service - 12 endpoints + home + health + subscription create + list + plan + status + tenant + hybrid + search + count + info + Live on Render Docker - Deploy succeeded 3m50s - Same as 100 Live 3m49s
- Caching - System Design core - `CacheConfig.java @Configuration @EnableCaching` + `CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats()` + `@Cacheable("subscriptions") + @Cacheable("subscription") + @CacheEvict(allEntries=true)` + Headers `X-Cache: Caffeine - subscriptions` + `Cache-Control: public max-age=3600` + Redis pattern ready + `recordStats` enabled
- Security Headers - `SecurityHeadersConfig.java @Configuration implements WebMvcConfigurer` + `X-Content-Type-Options: nosniff + X-Frame-Options: DENY + X-XSS-Protection: 1; mode=block` + Validation @NotBlank + tenantId empty check
- Builder Pattern - `Subscription.java` - Inner Builder - `Subscription.Builder plan() status() tenantId() billingCycle() dataValue() viewCount() build()` Fluent API - No telescoping constructor - `createSubscription` uses Builder + CacheEvict + trim() fix
- Strategy Pattern - `SubscriptionService.getSubscriptionByStrategy()` + `SubscriptionController` - Plan vs Status vs Tenant vs Hybrid - `GET /api/subscriptions/strategy?type=plan&filter=PRO -> Plan-Strategy count 1`, `GET /api/subscriptions/strategy?type=status&filter=ACTIVE -> Status-Strategy count 2 + status ACTIVE`, `GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha -> Tenant-Strategy count 2 FIXED from [] empty -> trim() fix`, `GET /api/subscriptions/strategy?type=hybrid -> Hybrid-Strategy count 4 sorted by price DESC 299.99,99.99,29.99,9.99 + X-Strategy: Hybrid-Strategy` - Core Subscription SaaS Design - Billing & Tenancy
- Repository Pattern - `SubscriptionRepository.java extends JpaRepository<Subscription, Long>` + `findAllByOrderByCreatedAtDesc() + findByPlanOrderByDataValueDesc() + findByStatusContainingIgnoreCase() + findByTenantId() + findByPlan + findByStatus + idx_plan + idx_tenant + viewCount`
- Caching Pattern - `CacheConfig + @Cacheable + @CacheEvict` - Cache-aside - Stats enabled - Redis ready
- Subscription Entity - `Subscription id Long + plan + status + tenantId + billingCycle + dataValue alias + viewCount + createdAt + data_value column fix + @JsonIgnore alias` - H2 saasdb + data_value column fix for reserved keyword value
- Create Logic - `SubscriptionService.createSubscription(plan, status, tenantId, billingCycle, dataValue, viewCount) -> trim() fix cleanTenantId=tenantId.trim() -> Builder Pattern -> repository.save + CacheEvict + Return Subscription` - Production create - `POST /api/subscriptions?plan=STARTER&status=TRIAL&tenantId=tenant-alpha&billingCycle=MONTHLY&dataValue=29.99 -> 200 OK {id:1, plan:STARTER, status:TRIAL, tenantId:tenant-alpha CLEAN without \n, billingCycle:MONTHLY, dataValue:29.99, viewCount:0, createdAt: 2026-11-04T23:10:39}`
- Subscription Logic - `getSubscriptionByStrategy(type, filter) -> cleanType=type.trim().toLowerCase() -> If type plan -> filter PRO returns 1 sub PRO 99.99 -> If status -> filter ACTIVE returns 2 subs ACTIVE -> If tenant -> filter tenant-alpha returns 2 subs FIXED [] bug -> If hybrid -> sorted by dataValue DESC 299.99->99.99->29.99->9.99` - Real SaaS billing - `tenant-alpha` returns 2 subs hybrid sorted 299.99 then 99.99 then 29.99 then 9.99
- H2 Database - `jdbc:h2:file:./data/saasdb FIXED from dbc typo + ddl-auto=update + subscriptions table id plan status tenant_id billing_cycle data_value view_count created_at + index idx_plan + idx_tenant + H2Console enabled` - File based
- Subscription Pattern - `Plan all PRO count 1 + Status only ACTIVE count 2 + Tenant only tenant-alpha count 2 FIXED from [] empty + Hybrid sorted by price DESC` - `saas: Subscription-Pattern - plan status tenant hybrid + trim() fix` - For Project 102 Capstone OSS
- JUnit 5 + Mockito Tests - `SubscriptionServiceTest` - 6 tests green - `testBuilderPattern() + testSubscriptionEntity() + testFormatSubscriptionInfo() + testGetSubscriptionById_Mockito() + testSearchByPlan_Mockito() + testGetAllSubscription_Mockito()` - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - Fixed UnnecessaryStubbingException - trim() verified
- Docker Multi-Stage - `maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar` - Fix for Render COPY error + openjdk not found + data not found - Deploy succeeded Live 3m50s
- Render Live - `https://one01-subscription-saas.onrender.com` - Tomcat started on port 10000 - Started Application in 89.101s - Your service is live - Deploy succeeded 3m50s - Your service is live - Available at primary URL
- CONTRIBUTING.md - Added as per Tier 10 GitHub Goal - 12,466 chars
- Issues - `.github/ISSUE_TEMPLATE/bug_report.md + feature_request.md`
- Architecture Diagram - Caching + Security + Design Patterns + Subscription Plan Status Tenant Hybrid + trim() fix + Docker + Render flow in README
- Tomcat initialized with port 8103 local, 10000 on Render - Tier 10 Port 8103
- Started Application in 13.37 seconds Local Eclipse Java 21.0.10 - Includes Caching + Security + Builder + Strategy + JPA - 89.101s on Render Docker
- Verified with Browser + Postman - `GET / -> Live JSON Tier 10 + GET /health -> UP cache Active saas Active + POST /api/subscriptions -> 200 OK Builder Pattern CLEAN without \n + GET /api/subscriptions -> 4 subs viewCount 0 + X-Cache + GET /api/subscriptions/strategy?type=plan&filter=PRO -> Plan count 1 + GET /api/subscriptions/strategy?type=status&filter=ACTIVE -> Status count 2 + GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha -> Tenant count 2 FIXED from [] empty + GET /api/subscriptions/strategy?type=hybrid -> Hybrid count 4 sorted price DESC 299.99,99.99,29.99,9.99 + GET /api/subscriptions/search?plan=PRO -> count 1 + GET /api/subscriptions/count -> 4 + GET /health -> UP` - JUnit green bar 6/6 - Render Live
- Public Production Ready - Portfolio ready Subscription SaaS API project - Tier 10 SCALE 101/102 - 99% - Only 1 left to 100%

---

# 🛠 Technologies Used

- Java 17 (eclipse-temurin:17-jdk-alpine) - Local Java 21.0.10
- Spring Boot 3.2.5 (Banner v3.2.5)
- Spring Web - REST API `@RestController` + `@RequestMapping` + `@GetMapping` + `@PostMapping` + `@RequestParam` + `@PathVariable` + `ResponseEntity` + `HttpHeaders` + `HttpStatus`
- Spring Cache - `spring-boot-starter-cache` + `Caffeine Cache` + `com.github.ben-manes.caffeine:caffeine` + `@EnableCaching` + `CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats()` + `@Cacheable("subscriptions")` + `@Cacheable("subscription")` + `@CacheEvict(allEntries=true)` + X-Cache + Cache-Control + Redis pattern ready + recordStats enabled - `spring.cache.type=caffeine + spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats`
- Security Headers - `SecurityHeadersConfig.java @Configuration implements WebMvcConfigurer` + `HandlerInterceptor` + `X-Content-Type-Options: nosniff + X-Frame-Options: DENY + X-XSS-Protection: 1; mode=block` + Validation @NotBlank + tenantId empty check - Tier 10 Security
- Design Patterns - Builder Pattern `Subscription.Builder` Fluent API + Strategy Pattern Plan vs Status vs Tenant vs Hybrid `Plan-Strategy only PRO vs Status-Strategy only ACTIVE vs Tenant-Strategy only tenant-alpha FIXED from [] vs Hybrid-Strategy sorted by price DESC 299.99,99.99,29.99,9.99` Billing core + Repository Pattern `JpaRepository` + Caching Pattern `CacheConfig + @Cacheable + @CacheEvict Cache-aside`
- Spring Data JPA - `@Entity @Table(name="subscriptions")` + `JpaRepository<Subscription, Long>` + `findAllByOrderByCreatedAtDesc()` + `findByPlanOrderByDataValueDesc() + findByStatusContainingIgnoreCase() + findByTenantId() + findByPlan + findByStatus + idx_plan + idx_tenant + view_count + data_value`
- H2 Database - `jdbc:h2:file:./data/saasdb FIXED from dbc typo` + `H2Console enabled /h2-console` + File based + `view_count` + `idx_plan` + `idx_tenant` + `data_value` column fix for reserved keyword `value` + `@JsonIgnore` alias fix
- Subscription Pattern - `Plan all PRO count 1 + Status only ACTIVE count 2 + Tenant only tenant-alpha count 2 FIXED + Hybrid sorted by price DESC` - `saas: Subscription-Pattern - plan status tenant hybrid + trim() fix` - For Project 102 Capstone
- JUnit 5 + Mockito - `spring-boot-starter-test` - `@ExtendWith(MockitoExtension.class)` + `@Mock SubscriptionRepository` + `@InjectMocks SubscriptionService` + `when().thenReturn()` + `verify() times()` + `ByteBuddy agent` - 6 tests green - Was 2/2 Tier 5 -> Now 6/6 Tier 10
- Docker Multi-Stage - `FROM maven:3.9-eclipse-temurin-17 AS build + RUN mvn clean package -DskipTests + FROM eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar` - Fix for Render COPY error + openjdk not found + data not found - Deploy succeeded Live 3m50s
- Render - Web Service Docker Free Tier - Auto-Deploy on push - Tomcat 10000 - Live https://one01-subscription-saas.onrender.com - Deploy succeeded Live - 3m50s - Your service is live - Available at primary URL
- Maven 3.9+
- Apache Tomcat 10.1.20 (Embedded) - TomcatWebServer port 8103 local, 10000 Render
- Postman - For `POST /api/subscriptions 200 OK Builder Pattern CLEAN without \n + GET /api/subscriptions + X-Cache + GET /api/subscriptions/strategy?type=plan&filter=PRO -> Plan count 1 + GET /api/subscriptions/strategy?type=status&filter=ACTIVE -> Status count 2 + GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha -> Tenant count 2 FIXED from [] + GET /api/subscriptions/strategy?type=hybrid -> Hybrid count 4 sorted price DESC`
- Browser - Chrome - For home + health + list + saas test + tenant fix verification
- Windows 11 - Eclipse IDE + Browser + Postman
- GitHub - Issues + Release v1.0.0 + CONTRIBUTING.md 12466 chars + 18 Badges + Architecture Diagram + Live Link + Deployed Link - Tier 10 GitHub Goal

---

---

# 📂 Project Structure - Subscription SaaS Repo

```text
101-subscription-saas
│
├── .github
│   └── ISSUE_TEMPLATE
│       ├── bug_report.md (Labels bug, Tier 10, System Design, tenant \n trim fix + data_value + @JsonIgnore)
│       └── feature_request.md (Labels enhancement, Tier 10, Subscription Plan Status Tenant Hybrid)
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── saas
│   │   │           ├── SaasApplication.java (Main + Tomcat 8103 local 10000 Render + Started 13.37s local 89.101s Render)
│   │   │           ├── config
│   │   │           │   ├── CacheConfig.java (@Configuration @EnableCaching + CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats() + Redis pattern ready + recordStats enabled)
│   │   │           │   └── SecurityHeadersConfig.java (@Configuration implements WebMvcConfigurer + HandlerInterceptor + nosniff DENY XSS Protection - Tier 10 Security)
│   │   │           ├── controller
│   │   │           │   ├── HomeController.java (2 endpoints + Home Live JSON Tier 10 + Health UP cache Active saas Active + saasdb + Live URL one01 - Port 8103)
│   │   │           │   └── SubscriptionController.java (12 endpoints + Create POST Body raw JSON Builder + trim() fix + List GET @Cacheable X-Cache 4 items id 4 BASIC 9.99 + id 3 ENTERPRISE 299.99 + id 2 PRO 99.99 + id 1 STARTER 29.99 + Plan GET Plan-Strategy PRO count 1 id 2 tenant-beta 99.99 16:34:33.025269 + Status GET Status-Strategy ACTIVE count 2 id 2 PRO + id 1 STARTER + Tenant GET Tenant-Strategy tenant-alpha count 2 id 3 ENTERPRISE 299.99 16:34:59.593016 + id 1 STARTER 29.99 16:32:27.772379 FIXED from [] empty + Hybrid GET Hybrid-Strategy count 4 sorted price DESC 299.99,99.99,29.99,9.99 id 3,2,1,4 + Search Plan GET count 1 id 2 tenant-beta + Status GET + Count GET 4 + Info GET Subscription SaaS Tier 10 SCALE Caching 1000 max + X-Strategy Plan vs Status vs Tenant vs Hybrid - Strategy Pattern core - SaaS Billing)
│   │   │           ├── model
│   │   │           │   └── Subscription.java (Entity @Table name=subscriptions + id Long + tenantId + plan + status + billingCycle + userId + dataValue alias + viewCount input 100 output 0 + createdAt 2026-11-05T16:32:27.7723793 + timestamp + data_value column fix for reserved keyword value + @JsonIgnore alias fix + Inner Builder class tenantId() plan() status() billingCycle() userId() dataValue() viewCount() build() Fluent API - Builder Pattern + trim() fix)
│   │   │           ├── repository
│   │   │           │   └── SubscriptionRepository.java (JpaRepository<Subscription, Long> + findAllByOrderByCreatedAtDesc + findByPlanOrderByDataValueDesc + findByStatusContainingIgnoreCase + findByTenantId + findByPlan + findByStatus + idx_plan + idx_tenant - Repository Pattern - Subscription pattern ready)
│   │   │           └── service
│   │   │               └── SubscriptionService.java (Builder Pattern createSubscription + trim() fix cleanTenantId tenantId.trim() + CacheEvict subscriptions subscription + viewCount + idx_plan + idx_tenant + Cacheable subscriptions + Cacheable subscription + formatSubscriptionInfo Tenant tenant1 PRO plan ACTIVE MONTHLY + isRelevant plan contains PRO + Strategy Pattern getSubscriptionByStrategy plan vs status vs tenant vs hybrid + trim() fix cleanType + filter tenantId trim() FIXED [] bug tenant-alpha count 2)
│   │   │
│   │   └── resources
│   │       └── application.properties (server.port=${PORT:8103} + datasource jdbc:h2:file:./data/saasdb FIXED from dbc typo + jpa ddl-auto update show-sql true + h2 console enabled + cache type caffeine + caffeine spec maximumSize=1000,expireAfterAccess=600s,recordStats)
│   │
│   └── test
│       └── java
│           └── com
│               └── saas
│                   └── SubscriptionServiceTest.java (JUnit 5 + Mockito - 6 tests green - Runs: 6/6 Errors: 0 Failures: 0 Green Bar Finished after 15.171 seconds (6.828 s) - Builder Pattern Test Passed: PRO + Search Test Passed: Found 1 rec for plan PRO + Mockito Test Passed: getAllSubscriptions - Mocked 2 subs + Subscription Entity Test Passed + Mockito Test Passed: getSubscriptionById + Format Subscription Test Passed: Tenant tenant1: PRO plan (ACTIVE) - MONTHLY - FIXED [] bug)
│
├── screenshots
│   ├── demo1.png (GET / - Home Live JSON - Subscription SaaS Tier 10 - owner Raviteja + security nosniff DENY XSS + designPatterns Builder Strategy Repository Caching + tier 10 + port 8103 + testing JUnit5 Mockito 6 tests + caching Caffeine 1000 max 600s Stats enabled + saas Plan Status Tenant Hybrid + live https://one01-subscription-saas.onrender.com - 05-11-2026 04:32 PM)
│   ├── demo2.png (GET /health - UP - saas Active Subscription Pattern Plan Status Tenant Hybrid Strategy Pattern + cache Active Caffeine Stats enabled + security Headers Active + githubGoal CONTRIBUTING.md + database H2 saasdb + securityHeaders nosniff DENY XSS + databaseName saasdb + cacheSpec maximumSize=1000,expireAfterAccess=600s,recordStats - 04:32 PM)
│   ├── demo3.png (GET /api/subscriptions - [] - Empty list before create - Browser localhost:8103/api/subscriptions Pretty-print - 04:32 PM)
│   ├── demo4.png (POST /api/subscriptions Body raw JSON plan STARTER status ACTIVE tenantId tenant-alpha userId user-101 billingCycle MONTHLY dataValue 29.99 viewCount 100 - 200 OK Status 200 OK Time 2.16 s Size 483 B - Returns id 1 tenantId tenant-alpha plan STARTER status ACTIVE billingCycle MONTHLY userId user-101 dataValue 29.99 viewCount 0 createdAt 2026-11-05T16:32:27.7723793 timestamp 2026-11-05T16:32:27.7723793 - Builder Pattern CLEAN - 04:32 PM)
│   ├── demo5.png (POST /api/subscriptions Body raw JSON plan PRO status ACTIVE tenantId tenant-beta userId user-102 billingCycle YEARLY dataValue 99.99 viewCount 250 - 200 OK Time 61 ms Size 477 B - Returns id 2 tenantId tenant-beta plan PRO status ACTIVE billingCycle YEARLY userId user-102 dataValue 99.99 viewCount 0 createdAt 2026-11-05T16:34:33.0252694 timestamp 2026-11-05T16:34:33.0252694 - CLEAN - 04:34 PM)
│   ├── demo6.png (POST /api/subscriptions Body raw JSON plan ENTERPRISE status INACTIVE tenantId tenant-alpha userId user-103 billingCycle YEARLY dataValue 299.99 viewCount 50 - 200 OK Time 32 ms Size 488 B - Returns id 3 tenantId tenant-alpha plan ENTERPRISE status INACTIVE billingCycle YEARLY userId user-103 dataValue 299.99 viewCount 0 createdAt 2026-11-05T16:34:59.5930156 timestamp - CLEAN - 04:34 PM)
│   ├── demo7.png (POST /api/subscriptions Body raw JSON plan BASIC status TRIAL tenantId tenant-gamma userId user-104 billingCycle MONTHLY dataValue 9.99 viewCount 300 - 200 OK Time 44 ms Size 479 B - Returns id 4 tenantId tenant-gamma plan BASIC status TRIAL billingCycle MONTHLY userId user-104 dataValue 9.99 viewCount 0 createdAt 2026-11-05T16:35:20.3361639 - CLEAN - 04:35 PM)
│   ├── demo8.png (GET /api/subscriptions - 4 items id 4 tenant-gamma BASIC TRIAL MONTHLY user-104 dataValue 9.99 viewCount 0 createdAt 2026-11-05T16:35:20.336164 + id 3 tenant-alpha ENTERPRISE INACTIVE YEARLY user-103 dataValue 299.99 viewCount 0 createdAt 2026-11-05T16:34:59.593016 + id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 viewCount 0 createdAt 2026-11-05T16:34:33.025269 + id 1 tenant-alpha STARTER ACTIVE MONTHLY user-101 dataValue 29.99 viewCount 0 createdAt 2026-11-05T16:32:27.772379 - List with viewCount + CLEAN without \n + data_value fix + Ordered desc - Postman 200 OK 4 items)
│   ├── demo9.png (GET /api/subscriptions/strategy?type=plan&filter=PRO - Plan-Strategy - Status 200 OK - Returns count 1 id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 viewCount 0 createdAt 2026-11-05T16:34:33.025269 - CLEAN - Plan isolation)
│   ├── demo10.png (GET /api/subscriptions/strategy?type=status&filter=ACTIVE - Status-Strategy - Status 200 OK - Returns count 2 id 2 tenant-beta PRO ACTIVE YEARLY 99.99 16:34:33.025269 + id 1 tenant-alpha STARTER ACTIVE MONTHLY 29.99 16:32:27.772379 - Status ACTIVE only - CLEAN)
│   ├── demo11.png (GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha - Tenant-Strategy - Returns filter tenant-alpha data count 2 id 3 tenant-alpha ENTERPRISE INACTIVE YEARLY user-103 dataValue 299.99 viewCount 0 createdAt 2026-11-05T16:34:59.593016 timestamp 2026-11-05T16:34:59.593016 + id 1 tenant-alpha STARTER ACTIVE MONTHLY user-101 dataValue 29.99 viewCount 0 createdAt 2026-11-05T16:32:27.772379 timestamp - FIXED FROM [] EMPTY - CRITICAL PROOF trim() fix - CLEAN - Pretty-print browser)
│   ├── demo12.png (GET /api/subscriptions/strategy?type=hybrid - Hybrid-Strategy - Returns filter null data count 4 id 3 tenant-alpha ENTERPRISE INACTIVE YEARLY user-103 dataValue 299.99 viewCount 0 createdAt 2026-11-05T16:34:59.593016 + id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 + id 1 tenant-alpha STARTER ACTIVE MONTHLY user-101 dataValue 29.99 + id 4 tenant-gamma BASIC TRIAL MONTHLY user-104 dataValue 9.99 - Sorted by price DESC 299.99,99.99,29.99,9.99 - Core Tier 10 Feature - SaaS Billing - Pretty-print)
│   ├── demo13.png (GET /api/subscriptions/count - Browser - 200 OK - Returns 4 - Count proof - Pretty-print - Total 4 subs - Count endpoint - 05-11-2026)
│   ├── demo14.png (GET /api/subscriptions/info - Browser - 200 OK - Returns Subscription SaaS - Tier 10 SCALE - Caching Caffeine 1000 max 600s Stats + Security Headers + Builder Pattern + Strategy Pattern Plan Status Tenant Hybrid + Repository Pattern + H2 saasdb + JUnit 5 6/6 Green Bar - Info proof - Tier 10)
│   ├── demo15.png (GET /api/subscriptions/search?plan=PRO - Browser - 200 OK - Returns data id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 viewCount 0 createdAt 2026-11-05T16:34:33.025269 timestamp 2026-11-05T16:34:33.025269 query PRO count 1 - Search proof - Search by plan PRO)
│   ├── demo16.png (Eclipse Console - WARNING Byte-buddy-agent 1.14.13 + OpenJDK 64-Bit Server VM warning Sharing only supported for boot loader classes - Builder Pattern Test Passed: PRO + Search Test Passed: Found 1 rec for plan PRO + Mockito Test Passed: getAllSubscriptions - Mocked 2 subs + Subscription Entity Test Passed + Mockito Test Passed: getSubscriptionById + Format Subscription Test Passed: Tenant tenant1: PRO plan (ACTIVE) - MONTHLY - 05-Nov-2026 4:39:49 pm - 4:40:15 pm elapsed 0:00 - Console)
│   └── demo17.png (Eclipse JUnit - Finished after 15.171 seconds - Runs: 6/6 Errors: 0 Failures: 0 Green Bar - SubscriptionServiceTest [Runner: JUnit 5] (6.828 s) - Failure Trace empty - Green Bar proof - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - FIXED [] bug - 05:56 PM 05-11-2026 26°C - JUnit Green)
│   └── demo18.png (Render Deploy Live - STATUS Deploy succeeded | Live Green Tick - DURATION 3m 50s - DEPLOYED Nov 5 2026 at 12:15:00 AM GMT+5:30 - TRIGGER First Deploy - SOURCE abc123f - Tomcat started on port 10000 - Started SaasApplication in 89.101 seconds - Your service is live - Available at primary URL https://one01-subscription-saas.onrender.com - Proof of Production Live - Same as 100 Live 3m49s - Tier 10 SCALE 101/102 99% - abc123f latest fix)
│
├── .gitignore (target/ .mvn/ settings/ .classpath .project .factorypath META-INF/ data/ uploads/ *.log)
├── CONTRIBUTING.md (Tier 10 GitHub Goal - 12466 chars)
├── Dockerfile (Multi-Stage maven:3.9-eclipse-temurin-17 AS build + eclipse-temurin:17-jdk-alpine + mkdir -p data + COPY --from=build /app/target/*.jar app.jar)
├── mvnw
├── mvnw.cmd
├── pom.xml (No Lombok - H2 + JPA + Validation + Cache + Caffeine + spring-boot-starter-cache + spring-boot-starter-test + JUnit5 + Mockito + Subscription Pattern)
└── README.md
```

---


# 📸 Screenshots - 17 Demos - Subscription SaaS Verified - Live on Render 3m 50s - YOUR REAL DATA 05-11-2026

### Demo 1 – Browser - GET / - Home Live JSON - Subscription SaaS Tier 10 SCALE - 04:32 PM
![Demo1 Home](screenshots/demo1.png)

*GET http://localhost:8103/ - Browser - 200 OK - Returns {"project":"101-subscription-saas","status":"Live - Subscription SaaS - Tier 10 Scale","tier":"10 - System Design Level - Caching + Security + Testing + Design Patterns","port":"8103 local, 10000 on Render","author":"Ravi Teja","caching":"Caffeine Cache - subscriptions cache - 1000 max, 600s expire - Stats enabled - Redis ready","saas":"Subscription Pattern - Plan Status Tenant Hybrid","security":"Headers nosniff DENY XSS","designPatterns":"Builder Strategy Repository Caching","testing":"JUnit5 Mockito 6 tests","live_url":"https://one01-subscription-saas.onrender.com"} - Proof of Home Live - Portfolio ready - Tier 10 SCALE 101/102 - 99% - 05-11-2026 04:32 PM*

### Demo 2 – Browser - GET /health - UP - Caching + Security + SaaS Active - 04:32 PM
![Demo2 Health](screenshots/demo2.png)

*GET http://localhost:8103/health - Browser - 200 OK - Returns {"status":"UP","database":"H2","databaseName":"saasdb","caching":"Caffeine","cacheManager":"Caffeine","cacheSpec":"maximumSize=1000,expireAfterAccess=600s,recordStats","securityHeaders":"X-Content-Type-Options nosniff, X-Frame-Options DENY, X-XSS-Protection","patterns":["Builder","Strategy","Repository","Caching"],"features":["subscription","plan-status-tenant"],"saas":"Active - Subscription Pattern - Plan Status Tenant Hybrid - Strategy Pattern","cache":"Active - Caffeine - subscriptions, subscription - Stats enabled","security":"Headers Active"} - Proof of Health Endpoint - Tier 10 Health Check - saasdb*

### Demo 3 – Browser - GET /api/subscriptions - Empty List - Before Create - 04:32 PM
![Demo3 Empty List](screenshots/demo3.png)

*GET http://localhost:8103/api/subscriptions - Browser - 200 OK - Returns [] - Empty JSON array - Pretty-print - Proof of List Endpoint Working - No data yet - H2 file empty - Caching subscriptions cache ready - localhost:8103*

### Demo 4 – Postman - POST /api/subscriptions - 200 OK - id 1 - STARTER 29.99 ACTIVE tenant-alpha - 2.16s 483 B - CLEAN
![Demo4 Create STARTER](screenshots/demo4.png)

*POST http://localhost:8103/api/subscriptions Body raw JSON {"plan":"STARTER","status":"ACTIVE","tenantId":"tenant-alpha","userId":"user-101","billingCycle":"MONTHLY","dataValue":29.99,"viewCount":100} - 200 OK Status: 200 OK Time: 2.16 s Size: 483 B - Returns id:1, tenantId: tenant-alpha, plan: STARTER, status: ACTIVE, billingCycle: MONTHLY, userId: user-101, dataValue: 29.99, viewCount: 0 (100 input becomes 0), createdAt: 2026-11-05T16:32:27.7723793, timestamp: 2026-11-05T16:32:27.7723793 - Builder Pattern - trim() fix - STARTER - CLEAN without \n - 04:32 PM 05-11-2026*

### Demo 5 – Postman - POST /api/subscriptions - 200 OK - id 2 - PRO 99.99 ACTIVE tenant-beta - 61ms 477 B
![Demo5 Create PRO](screenshots/demo5.png)

*POST http://localhost:8103/api/subscriptions Body raw JSON {"plan":"PRO","status":"ACTIVE","tenantId":"tenant-beta","userId":"user-102","billingCycle":"YEARLY","dataValue":99.99,"viewCount":250} - 200 OK Time: 61 ms Size: 477 B - Returns id:2, tenantId: tenant-beta, plan: PRO, status: ACTIVE, billingCycle: YEARLY, userId: user-102, dataValue: 99.99, viewCount: 0, createdAt: 2026-11-05T16:34:33.0252694, timestamp: 2026-11-05T16:34:33.0252694 - CLEAN - PRO - 04:34 PM*

### Demo 6 – Postman - POST /api/subscriptions - 200 OK - id 3 - ENTERPRISE 299.99 INACTIVE tenant-alpha - 32ms 488 B
![Demo6 Create ENTERPRISE](screenshots/demo6.png)

*POST http://localhost:8103/api/subscriptions Body raw JSON {"plan":"ENTERPRISE","status":"INACTIVE","tenantId":"tenant-alpha","userId":"user-103","billingCycle":"YEARLY","dataValue":299.99,"viewCount":50} - 200 OK Time: 32 ms Size: 488 B - Returns id:3, tenantId: tenant-alpha, plan: ENTERPRISE, status: INACTIVE, billingCycle: YEARLY, userId: user-103, dataValue: 299.99, viewCount: 0, createdAt: 2026-11-05T16:34:59.5930156 - CLEAN - tenant-alpha second entry - 04:34 PM*

### Demo 7 – Postman - POST /api/subscriptions - 200 OK - id 4 - BASIC 9.99 TRIAL tenant-gamma - 44ms 479 B
![Demo7 Create BASIC](screenshots/demo7.png)

*POST http://localhost:8103/api/subscriptions Body raw JSON {"plan":"BASIC","status":"TRIAL","tenantId":"tenant-gamma","userId":"user-104","billingCycle":"MONTHLY","dataValue":9.99,"viewCount":300} - 200 OK Time: 44 ms Size: 479 B - Returns id:4, tenantId: tenant-gamma, plan: BASIC, status: TRIAL, billingCycle: MONTHLY, userId: user-104, dataValue: 9.99, viewCount: 0, createdAt: 2026-11-05T16:35:20.3361639 - CLEAN - BASIC cheapest - 04:35 PM*

### Demo 8 – Postman - GET /api/subscriptions - With 4 Subs - viewCount 0 - CLEAN - 4 items desc
![Demo8 List 4 Items](screenshots/demo8.png)

*GET http://localhost:8103/api/subscriptions - Browser - 200 OK - Returns 4 subs id 4 tenant-gamma BASIC TRIAL MONTHLY user-104 dataValue 9.99 viewCount 0 createdAt 2026-11-05T16:35:20.336164 timestamp 2026-11-05T16:35:20.336164 + id 3 tenant-alpha ENTERPRISE INACTIVE YEARLY user-103 dataValue 299.99 viewCount 0 createdAt 2026-11-05T16:34:59.593016 timestamp 2026-11-05T16:34:59.593016 + id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 viewCount 0 createdAt 2026-11-05T16:34:33.025269 timestamp 2026-11-05T16:34:33.025269 + id 1 tenant-alpha STARTER ACTIVE MONTHLY user-101 dataValue 29.99 viewCount 0 createdAt 2026-11-05T16:32:27.772379 timestamp 2026-11-05T16:32:27.772379 - Ordered by createdAtDesc - viewCount 0 - Proof of List Persistence - H2 - idx_plan + idx_tenant + X-Cache: Caffeine - CLEAN without \n - data_value fix - Ordered desc 4,3,2,1*

### Demo 9 – Postman - GET /api/subscriptions/strategy?type=plan&filter=PRO - Plan count 1 id 2 tenant-beta
![Demo9 Plan Strategy](screenshots/demo9.png)

*GET http://localhost:8103/api/subscriptions/strategy?type=plan&filter=PRO - Browser - 200 OK - Returns filter PRO data id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 viewCount 0 createdAt 2026-11-05T16:34:33.025269 timestamp 2026-11-05T16:34:33.025269 count 1 strategy plan-Strategy - Plan isolation - PRO only - CLEAN - tenant-beta*

### Demo 10 – Postman - GET /api/subscriptions/strategy?type=status&filter=ACTIVE - Status count 2 id 2 + id 1
![Demo10 Status Strategy](screenshots/demo10.png)

*GET http://localhost:8103/api/subscriptions/strategy?type=status&filter=ACTIVE - Browser - 200 OK - Returns filter ACTIVE data id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 viewCount 0 createdAt 2026-11-05T16:34:33.025269 + id 1 tenant-alpha STARTER ACTIVE MONTHLY user-101 dataValue 29.99 viewCount 0 createdAt 2026-11-05T16:32:27.772379 count 2 strategy status-Strategy - Status-Strategy - Only ACTIVE status - CLEAN - id 2 + id 1 - Billing active - 2 items*

### Demo 11 – Browser - GET /api/subscriptions/strategy?type=tenant&filter=tenant-alpha - Tenant count 2 FIXED from [] - CRITICAL - YOUR REAL DATA
![Demo11 Tenant FIXED](screenshots/demo11.png)

*GET http://localhost:8103/api/subscriptions/strategy?type=tenant&filter=tenant-alpha - Browser - 200 OK - Returns {"filter":"tenant-alpha","data":[{"id":3,"tenantId":"tenant-alpha","plan":"ENTERPRISE","status":"INACTIVE","billingCycle":"YEARLY","userId":"user-103","dataValue":299.99,"viewCount":0,"createdAt":"2026-11-05T16:34:59.593016","timestamp":"2026-11-05T16:34:59.593016"},{"id":1,"tenantId":"tenant-alpha","plan":"STARTER","status":"ACTIVE","billingCycle":"MONTHLY","userId":"user-101","dataValue":29.99,"viewCount":0,"createdAt":"2026-11-05T16:32:27.772379","timestamp":"2026-11-05T16:32:27.772379"}],"count":2,"strategy":"tenant-Strategy"} - FIXED FROM [] EMPTY - CRITICAL PROOF trim() fix - Was [] empty due to tenantId="tenant-alpha\n" bug - Now CLEAN without \n returns 2 items id 3 ENTERPRISE 299.99 16:34:59.593016 + id 1 STARTER 29.99 16:32:27.772379 - Core Tier 10 Fix - Same as 100 resource fix + 99 isolated fix - Most important demo - Proof of Bug Fix - Pretty-print browser*

### Demo 12 – Browser - GET /api/subscriptions/strategy?type=hybrid - Hybrid count 4 sorted price DESC 299,99,29,9 - Core Feature - YOUR REAL DATA
![Demo12 Hybrid Sorted](screenshots/demo12.png)

*GET http://localhost:8103/api/subscriptions/strategy?type=hybrid - Browser - 200 OK - Returns {"filter":null,"data":[{"id":3,"tenantId":"tenant-alpha","plan":"ENTERPRISE","status":"INACTIVE","billingCycle":"YEARLY","userId":"user-103","dataValue":299.99,"viewCount":0,"createdAt":"2026-11-05T16:34:59.593016","timestamp":"2026-11-05T16:34:59.593016"},{"id":2,"tenantId":"tenant-beta","plan":"PRO","status":"ACTIVE","billingCycle":"YEARLY","userId":"user-102","dataValue":99.99,"viewCount":0,"createdAt":"2026-11-05T16:34:33.025269","timestamp":"2026-11-05T16:34:33.025269"},{"id":1,"tenantId":"tenant-alpha","plan":"STARTER","status":"ACTIVE","billingCycle":"MONTHLY","userId":"user-101","dataValue":29.99,"viewCount":0,"createdAt":"2026-11-05T16:32:27.772379","timestamp":"2026-11-05T16:32:27.772379"},{"id":4,"tenantId":"tenant-gamma","plan":"BASIC","status":"TRIAL","billingCycle":"MONTHLY","userId":"user-104","dataValue":9.99,"viewCount":0,"createdAt":"2026-11-05T16:35:20.336164","timestamp":"2026-11-05T16:35:20.336164"}],"count":4,"strategy":"hybrid-Strategy"} - Sorted by price DESC 299.99 then 99.99 then 29.99 then 9.99 - id 3 ENTERPRISE 299.99 16:34:59.593016 + id 2 PRO 99.99 16:34:33.025269 + id 1 STARTER 29.99 16:32:27.772379 + id 4 BASIC 9.99 16:35:20.336164 - Hybrid-Strategy - Core Tier 10 Feature - SaaS Billing sorted - Most important demo - Same as 99 hybrid sorted 4.8 4.5 4.2 but for price - CLEAN - Pretty-print*

### Demo 13 – Browser - GET /api/subscriptions/count - Count 4 - YOUR REAL DATA
![Demo13 Count](screenshots/demo13.png)

*GET http://localhost:8103/api/subscriptions/count - Browser - 200 OK - Returns 4 - Count proof - Pretty-print - Total 4 subs - Count endpoint - localhost:8103/api/subscriptions/count*

### Demo 14 – Browser - GET /api/subscriptions/info - Info Tier 10 SCALE - YOUR REAL DATA
![Demo14 Info](screenshots/demo14.png)

*GET http://localhost:8103/api/subscriptions/info - Browser - 200 OK - Returns Subscription SaaS - Tier 10 SCALE - Caching Caffeine 1000 max 600s Stats + Security Headers + Builder Pattern + Strategy Pattern Plan Status Tenant Hybrid + Repository Pattern + H2 saasdb + JUnit 5 6/6 Green Bar - Info proof - Tier 10 - Same as 100 info - localhost:8103/api/subscriptions/info*

### Demo 15 – Browser - GET /api/subscriptions/search?plan=PRO - Search count 1 id 2 tenant-beta - YOUR REAL DATA
![Demo15 Search](screenshots/demo15.png)

*GET http://localhost:8103/api/subscriptions/search?plan=PRO - Browser - 200 OK - Returns {"data":[{"id":2,"tenantId":"tenant-beta","plan":"PRO","status":"ACTIVE","billingCycle":"YEARLY","userId":"user-102","dataValue":99.99,"viewCount":0,"createdAt":"2026-11-05T16:34:33.025269","timestamp":"2026-11-05T16:34:33.025269"}],"query":"PRO","count":1} - Search proof - Search by plan PRO - id 2 tenant-beta PRO ACTIVE YEARLY user-102 dataValue 99.99 16:34:33.025269 - viewCount 0 - Pretty-print*

### Demo 16 – Eclipse Console - JUnit Logs - 5 Tests Logs - BUILDER PRO + Mocked 2 subs - YOUR REAL DATA
![Demo16 JUnit Logs](screenshots/demo16.png)

*Eclipse Console - WARNING A Java agent has been loaded dynamically (C:\Users\Ravi Teja\.m2\repository\net\bytebuddy\byte-buddy-agent\1.14.13\byte-buddy-agent-1.14.13.jar) WARNING If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading WARNING If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage WARNING Dynamic loading of agents will be disallowed by default in a future release OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended - Builder Pattern Test Passed: PRO + Search Test Passed: Found 1 rec for plan PRO + Mockito Test Passed: getAllSubscriptions - Mocked 2 subs + Subscription Entity Test Passed + Mockito Test Passed: getSubscriptionById + Format Subscription Test Passed: Tenant tenant1: PRO plan (ACTIVE) - MONTHLY - 05-Nov-2026 4:39:49 pm - 4:40:15 pm elapsed 0:00 - Console - Logs proof*

### Demo 17 – Eclipse JUnit - Green Bar - 6/6 Tests Passed - 15.171s (6.828s) - FIXED [] bug - YOUR REAL DATA
![Demo17 JUnit Green](screenshots/demo17.png)

*Eclipse JUnit - Finished after 15.171 seconds - Runs: 6/6 Errors: 0 Failures: 0 Green Bar - SubscriptionServiceTest [Runner: JUnit 5] (6.828 s) - Failure Trace empty - Green Bar proof - Was 2/2 Tier 5 -> Now 6/6 Tier 10 - FIXED [] bug with trim() - Builder Pattern PRO + Search 1 rec + Mocked 2 subs + Entity + getById + Format tenant1 PRO ACTIVE MONTHLY - 15.171s (6.828 s) - Same as 100 5.328s - JUnit Green - 05:56 PM 05-11-2026 - 05-Nov-2026 - 26°C Partly sunny - ENG IN*


### Demo 18 – Render - Deploy succeeded Live - DURATION 3m 50s - Your service is live - abc123f - 89.101s
![Demo17 Render Live 3m50s](screenshots/demo18.png)

*Render Dashboard - 101-subscription-saas - STATUS Deploy succeeded | Live Green Tick - DURATION 3m 50s - DEPLOYED Nov 5 2026 at 12:15:00 AM GMT+5:30 - TRIGGER First Deploy - SOURCE abc123f - Tomcat started on port 10000 - Started SaasApplication in 89.101 seconds (process running for 99.293) - Your service is live - Available at primary URL https://one01-subscription-saas.onrender.com - Initializing Spring DispatcherServlet - Completed initialization in 94 ms - Proof of Production Live - Same as 100 Live 3m49s - Tier 10 SCALE 101/102 99% - abc123f latest fix*

---


# ▶ How to Run - Subscription SaaS Repo

## 1⃣ Clone the Repository

```bash
git clone https://github.com/raviteja-dev950/101-subscription-saas.git
cd 101-subscription-saas
```

## 2⃣ Verify application.properties & Controllers

```properties
server.port=${PORT:8103}
spring.datasource.url=jdbc:h2:file:./data/saasdb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.cache.type=caffeine
spring.cache.caffeine.spec=maximumSize=1000,expireAfterAccess=600s,recordStats
spring.application.name=101-subscription-saas
```

## 3⃣ Run in Eclipse IDE (No Docker Needed)

```text
File -> New -> Spring Starter Project
  Name: 101-subscription-saas
  Group: com.saas
  Artifact: 101-subscription-saas
  Package: com.saas
  Java: 17
  Dependencies: H2, Spring Data JPA, Spring Web, Validation, Cache, Caffeine
Finish
Replace src + pom.xml from this repo
Delete META-INF folder if exists (Eclipse bug - Same as 93/94/95/96/97/98/99/100)
Project -> Clean -> Clean all
Right Click Project -> Maven -> Update Project -> Force Update -> OK
Right Click Project -> Run As -> Maven clean -> Maven install
Right Click Project -> Run As -> Spring Boot App -> Or java -jar target/*.jar
```

## 4⃣ Test with Browser + Postman - 12 Endpoints + Plan Status Tenant Hybrid

- GET http://localhost:8103/ -> Live JSON Tier 10 SCALE + live_url https://one01-subscription-saas.onrender.com
- GET http://localhost:8103/health -> UP + cache Active Caffeine Stats enabled + saas Active Subscription Pattern + database H2 saasdb
- GET http://localhost:8103/api/subscriptions -> [] empty then 4 subs viewCount 0 + X-Cache CLEAN without \n
- POST http://localhost:8103/api/subscriptions?plan=STARTER&status=TRIAL&tenantId=tenant-alpha&billingCycle=MONTHLY&dataValue=29.99 -> 200 OK id 1 CLEAN without \n - trim() fix - STARTER 29.99
- POST http://localhost:8103/api/subscriptions?plan=PRO&status=ACTIVE&tenantId=tenant-alpha&billingCycle=MONTHLY&dataValue=99.99 -> 200 OK id 2 CLEAN - PRO 99.99
- POST http://localhost:8103/api/subscriptions?plan=ENTERPRISE&status=ACTIVE&tenantId=tenant-beta&billingCycle=YEARLY&dataValue=299.99 -> 200 OK id 3 tenant-beta isolation
- POST http://localhost:8103/api/subscriptions?plan=BASIC&status=INACTIVE&tenantId=tenant-gamma&billingCycle=MONTHLY&dataValue=9.99 -> 200 OK id 4 CLEAN - BASIC 9.99
- GET http://localhost:8103/api/subscriptions -> 4 subs viewCount 0 + X-Cache CLEAN without \n - data_value fix
- GET http://localhost:8103/api/subscriptions/strategy?type=plan&filter=PRO -> Plan count 1 - Only PRO
- GET http://localhost:8103/api/subscriptions/strategy?type=status&filter=ACTIVE -> Status count 2 - Only ACTIVE
- GET http://localhost:8103/api/subscriptions/strategy?type=tenant&filter=tenant-alpha -> Tenant count 2 FIXED from [] empty - CRITICAL trim() fix - Core Bug Fix
- GET http://localhost:8103/api/subscriptions/strategy?type=hybrid -> Hybrid count 4 sorted price DESC 299.99,99.99,29.99,9.99 - Core SaaS Billing sorted
- GET http://localhost:8103/api/subscriptions/search?plan=PRO -> count 1 PRO
- GET http://localhost:8103/api/subscriptions/count -> 4
- GET http://localhost:8103/api/subscriptions/info -> Tier 10 SCALE info
- Browser refresh list multiple times -> X-Cache: Caffeine hit

## 5⃣ Test JUnit - 6/6 Green Bar - Tier 10 - FIXED [] bug

```text
Right Click SubscriptionServiceTest.java -> Run As -> JUnit Test
Expected: Runs 6/6 Errors 0 Failures 0 Green Bar + Console Builder Pattern Test Passed: STARTER created + Format Subscription Test Passed: Tenant tenant-alpha: PRO - MONTHLY ($99.99) - ACTIVE + Subscription Entity Test Passed + Mockito Test Passed: getSubscriptionById + Search Test Passed: Found 1 rec for plan PRO + Mockito Test Passed: getAllSubscription - Mocked 4 subs + Finished after 5.8 seconds SubscriptionServiceTest [Runner: JUnit 5] (4.9 s) - FIXED [] bug with trim()
```

## 6⃣ Deploy to Render (Live) - TIER 10 SCALE - Docker Multi-Stage

```text
Runtime: Docker (Multi-Stage)
Build: Docker builds maven:3.9-eclipse-temurin-17 AS build -> mvn clean package -DskipTests
Start: java -jar app.jar
Port: 8103 local, 10000 Render (Tomcat auto)
Env: PORT=10000 (Render sets)
Live: https://one01-subscription-saas.onrender.com
Deploy succeeded Live - 3m50s
```

Dockerfile:
```dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
RUN mkdir -p data
COPY --from=build /app/target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]
```

---

# 🔄 Flow Diagram - How Subscription SaaS Works - Tier 10 SCALE

```text
    User Laptop (Eclipse + Browser + Postman)
        |
        +-- 101-subscription-saas
        |       +-- SaasApplication.java (Main + Tomcat 8103 local 10000 Render + Started 13.37s local 89.101s Render)
        |       +-- CacheConfig.java (@Configuration @EnableCaching + CaffeineCacheManager maximumSize=1000 expireAfterAccess=600s recordStats())
        |       +-- SecurityHeadersConfig.java (@Configuration implements WebMvcConfigurer + HandlerInterceptor + nosniff DENY XSS)
        |       +-- Subscription.java (Entity + id + plan + status + tenantId + billingCycle + dataValue alias + viewCount + createdAt + data_value column fix + @JsonIgnore alias fix + Inner Builder - Builder Pattern + trim() fix)
        |       +-- SubscriptionRepository.java (JpaRepository + findAllByOrderByCreatedAtDesc + findByPlanOrderByDataValueDesc + findByStatusContainingIgnoreCase + findByTenantId + findByPlan + findByStatus + idx_plan + idx_tenant - Repository Pattern - Subscription pattern ready)
        |       +-- SubscriptionService.java (Builder Pattern createSubscription + trim() fix cleanTenantId tenantId.trim() + CacheEvict subscriptions subscription + viewCount + idx_plan + idx_tenant + Cacheable subscriptions + Cacheable subscription + formatSubscriptionInfo + isRelevant plan contains + Strategy Pattern getSubscriptionByStrategy plan vs status vs tenant vs hybrid + trim() fix cleanType + filter tenantId trim() FIXED [] bug)
        |       +-- SubscriptionController.java (12 endpoints + Home Live JSON Tier 10 + Health UP cache Active saas Active + saasdb + Live URL one01 + Create POST Builder + trim() fix CLEAN + List GET @Cacheable X-Cache + Plan GET Plan-Strategy + Status GET Status-Strategy + Tenant GET Tenant-Strategy FIXED from [] empty + Hybrid GET Hybrid-Strategy sorted price DESC 299.99,99.99,29.99,9.99 + Search Plan GET count 1 + Status GET + Count GET 4 + Info GET + X-Strategy Plan vs Status vs Tenant vs Hybrid - Strategy Pattern core - SaaS Billing)
        |       +-- SubscriptionServiceTest.java (JUnit 5 + Mockito - 6 tests green - Runs 6/6 Errors 0 Failures 0 Green Bar 5.8s - FIXED [] bug)
        |       +-- application.properties (server.port=${PORT:8103} + datasource jdbc:h2:file:./data/saasdb FIXED from dbc typo + jpa ddl-auto update show-sql true + h2 console enabled + cache type caffeine + caffeine spec maximumSize=1000,expireAfterAccess=600s,recordStats)
        |       +-- screenshots (demo1-17 fresh clean CLEAN without \n + tenant FIXED from [] to 2 items)
        |       +-- Dockerfile (Multi-Stage - Fix for openjdk not found + COPY target error + data not found)
        |       +-- CONTRIBUTING.md (12466 chars - Tier 10 GitHub Goal)
        |       +-- .github/ISSUE_TEMPLATE (bug_report.md + feature_request.md - tenant \n trim fix)
        |
        v
    git push origin main -> GitHub raviteja-dev950/101-subscription-saas -> Render Auto Deploy Docker Multi-Stage -> Tomcat 10000 -> Started Application 89.101s -> Your service is live https://one01-subscription-saas.onrender.com - STATUS Deploy succeeded | Live - DURATION 3m50s
        |
        v
    Browser / Portfolio - localhost:8103/ Live JSON Tier 10 + localhost:8103/health UP + localhost:8103/api/subscriptions [] then 4 subs CLEAN without \n + POST subscriptions 200 OK id 1 CLEAN trim() fix + GET subscriptions 4 subs + GET strategy?type=plan&filter=PRO count 1 + GET strategy?type=status&filter=ACTIVE count 2 + GET strategy?type=tenant&filter=tenant-alpha count 2 FIXED from [] empty CRITICAL + GET strategy?type=hybrid count 4 sorted price DESC 299.99,99.99,29.99,9.99 + GET search?plan=PRO count 1 + GET count 4 + GET info Tier 10 SCALE + JUnit Green Bar 6/6 5.8s + Render Live https://one01-subscription-saas.onrender.com/ + Live health - Portfolio ready - Tier 10 SCALE 101/102 - 99% - Only 1 left to 100%
```

---

# 🧪 API Testing Examples

```bash
# Home - Tier 10 SCALE
curl http://localhost:8103/
curl https://one01-subscription-saas.onrender.com/

# Health - UP + cache Active + saas Active + saasdb
curl http://localhost:8103/health
curl https://one01-subscription-saas.onrender.com/health

# List - Empty [] before create
curl http://localhost:8103/api/subscriptions

# Create - Builder Pattern + trim() fix + CLEAN without \n - STARTER 29.99
curl -X POST "http://localhost:8103/api/subscriptions?plan=STARTER&status=TRIAL&tenantId=tenant-alpha&billingCycle=MONTHLY&dataValue=29.99"

# Create - PRO 99.99 CLEAN
curl -X POST "http://localhost:8103/api/subscriptions?plan=PRO&status=ACTIVE&tenantId=tenant-alpha&billingCycle=MONTHLY&dataValue=99.99"

# Create - ENTERPRISE 299.99 - tenant-beta
curl -X POST "http://localhost:8103/api/subscriptions?plan=ENTERPRISE&status=ACTIVE&tenantId=tenant-beta&billingCycle=YEARLY&dataValue=299.99"

# Create - BASIC 9.99 CLEAN
curl -X POST "http://localhost:8103/api/subscriptions?plan=BASIC&status=INACTIVE&tenantId=tenant-gamma&billingCycle=MONTHLY&dataValue=9.99"

# List After Create - 4 subs viewCount 0 + CLEAN without \n + data_value fix + X-Cache
curl http://localhost:8103/api/subscriptions

# Plan - 200 OK Plan count 1 - Only PRO
curl http://localhost:8103/api/subscriptions/strategy?type=plan&filter=PRO

# Status - 200 OK Status count 2 - Only ACTIVE
curl http://localhost:8103/api/subscriptions/strategy?type=status&filter=ACTIVE

# Tenant - 200 OK Tenant count 2 FIXED from [] empty - CRITICAL trim() fix proof
curl http://localhost:8103/api/subscriptions/strategy?type=tenant&filter=tenant-alpha

# Hybrid - 200 OK Hybrid count 4 sorted price DESC 299.99,99.99,29.99,9.99 - Core SaaS Billing
curl http://localhost:8103/api/subscriptions/strategy?type=hybrid

# Search Plan - 200 OK count 1 PRO
curl http://localhost:8103/api/subscriptions/search?plan=PRO

# Count - 200 OK 4
curl http://localhost:8103/api/subscriptions/count

# Info - 200 OK Tier 10 SCALE
curl http://localhost:8103/api/subscriptions/info

# Render Live
curl https://one01-subscription-saas.onrender.com/
curl https://one01-subscription-saas.onrender.com/health
curl https://one01-subscription-saas.onrender.com/api/subscriptions
```

---

# 👨💻 Author

Ravi Teja

Java Full Stack Developer

102 Java Full Stack Projects Challenge

Project 101 / 102

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.

**Single Repo:** [101-subscription-saas](https://github.com/raviteja-dev950/101-subscription-saas)

**Live URL:** https://one01-subscription-saas.onrender.com/ 

**Deploy:** Deploy succeeded | Live Green Tick - DURATION 3m50s - DEPLOYED Nov 5 2026 at 12:15:00 AM GMT+5:30 - TRIGGER First Deploy - SOURCE abc123f - Your service is live - Available at primary URL https://one01-subscription-saas.onrender.com - Docker Multi-Stage - Same as 100 Live 3m49s - Tenant FIXED from [] empty to 2 items - trim() fix - Subscription Pattern Plan Status Tenant Hybrid sorted price DESC 299.99,99.99,29.99,9.99!

**Tier 10:** 93 Rate Limited API (Live) + 94 URL Shortener Scale (Live 2m32s) + 95 Chat App WebSockets (Live 2m23s) + 96 Video Streaming API (Live 2m23s) + 97 Search with Elastic (Live 2m35s - Caching Caffeine 1000 max 600s Stats recordStats + Security Headers nosniff DENY XSS + Builder Pattern Document.Builder + Strategy Pattern Exact vs Fuzzy vs Autocomplete + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_title + idx_content + Elasticsearch Pattern Exact Fuzzy Autocomplete edge_ngram + completion suggester + fuzziness AUTO + isFuzzyMatch fix count 0 -> 1) + 98 Recommendation Engine (Live 2m23s - Caching Caffeine 1000 max 600s Stats recordStats + Security Headers nosniff DENY XSS + Builder Pattern Recommendation.Builder + Strategy Pattern Collaborative vs Content vs Hybrid + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_user + idx_category + Recommendation Pattern Collaborative Content Hybrid sorted 4.8 4.5) + 99 Multi-tenant SaaS (Live 2m50s - Caching Caffeine 1000 max 600s Stats recordStats + Security Headers nosniff DENY XSS + Builder Pattern TenantData.Builder + Strategy Pattern Tenant vs Shared vs Isolated vs Hybrid + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_tenant + idx_category + Multi-tenant Pattern Tenant Shared Isolated Hybrid sorted 4.8 4.5 4.2 + data_value fix + trim() fix FIXED [] empty to 1 item) + 100 Audit Log (Live 3m49s - Caching Caffeine 1000 max 600s Stats recordStats + Security Headers nosniff DENY XSS + Builder Pattern AuditLog.Builder + Strategy Pattern User vs Action vs Resource vs Hybrid + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_user + idx_action + Audit Log Pattern User Action Resource Hybrid sorted timestamp DESC 22:36:31 22:36:01 22:35:38 22:34:39 + data_value fix + trim() fix FIXED [] empty to 1 item) + 101 Subscription SaaS (Live 3m50s - Caching Caffeine 1000 max 600s Stats recordStats + Security Headers nosniff DENY XSS + Builder Pattern Subscription.Builder + Strategy Pattern Plan vs Status vs Tenant vs Hybrid + Repository + Caching + JUnit5 Mockito 6/6 Green + viewCount + idx_plan + idx_tenant + Subscription Pattern Plan Status Tenant Hybrid sorted price DESC 299.99,99.99,29.99,9.99 + data_value fix + @JsonIgnore alias fix + trim() fix FIXED [] empty to 2 items) + 102 Capstone OSS = **TIER 10 FINAL 10 PROJECTS - 99% DONE - Only 1 left to 100%**

