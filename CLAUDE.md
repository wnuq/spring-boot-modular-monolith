# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot modular monolith application written in Kotlin. The project is in its initial setup phase with basic Spring Boot infrastructure in place, ready for modular architecture implementation.

**Technology Stack:**
- Kotlin 1.9.25 with strict JSR-305 null-safety
- Spring Boot 3.5.7
- Java 21 (toolchain)
- Gradle 8.14.3 with Kotlin DSL
- JUnit 5 + Spring Boot Test

## Build and Development Commands

**Build:**
```bash
./gradlew build              # Full build with tests
./gradlew clean build        # Clean build
./gradlew bootJar            # Create executable JAR
./gradlew bootBuildImage     # Build OCI/Docker image
```

**Run:**
```bash
./gradlew bootRun            # Start application (default port 8080)
```

**Test:**
```bash
./gradlew test               # Run all tests
./gradlew test --tests ClassName         # Run specific test class
./gradlew test --tests ClassName.testMethod  # Run specific test method
./gradlew check              # Run all verification tasks
```

**Development:**
```bash
./gradlew compileKotlin      # Compile main sources
./gradlew compileTestKotlin  # Compile test sources
```

## Project Structure

**Current State:** Single-module Spring Boot application with standard layout.

```
src/main/kotlin/com/wnuq/spring/boot/modular/monolith/
  └── SpringBootModularMonolithApplication.kt  # Main application class

src/main/resources/
  ├── application.yaml        # Application configuration
  ├── static/                 # Static web resources (empty)
  └── templates/              # Template files (empty)

src/test/kotlin/             # Test sources mirror main structure
```

**Base Package:** `com.wnuq.spring.boot.modular.monolith`

## Architecture Guidelines

**Modular Monolith Pattern:**
When implementing modules, follow these principles:
- Each module should be a separate package under the base package
- Modules communicate via well-defined interfaces (no direct coupling)
- Use Spring Events for async inter-module communication
- Shared code goes in a common/shared module
- Each module should have its own domain model, services, and repositories

**Typical module structure (to be implemented):**
```
com.wnuq.spring.boot.modular.monolith/
├── orders/          # Order management module
├── customers/       # Customer management module
├── inventory/       # Inventory module
└── shared/          # Shared utilities and domain
```

## Configuration

**Application Configuration:** Located in `src/main/resources/application.yaml`

Currently minimal configuration. When adding new components:
- Use YAML format for configuration
- Consider using Spring profiles for environment-specific config
- Database connection properties not yet configured

## Testing Approach

**Framework:** JUnit 5 with Spring Boot Test support

**Test Location:** All tests under `src/test/kotlin/` mirroring main source structure

**Current Test:** Context load test (`SpringBootModularMonolithApplicationTests.kt`)

**Testing Guidelines:**
- Use `@SpringBootTest` for integration tests
- Use `@WebMvcTest` for controller tests
- Use `@DataJpaTest` for repository tests (when JPA added)
- Follow Kotlin test conventions with backticks for test names

## CI/CD Integration

**GitHub Actions Workflows:**
- `.github/workflows/claude-code-review.yml` - Automated PR code reviews via Claude
- `.github/workflows/claude.yml` - Interactive Claude assistant for issues/PRs

**Code Review:** PRs automatically receive Claude-powered code reviews covering quality, bugs, performance, security, and test coverage.

## Dependencies

**Core:**
- `spring-boot-starter-web` - REST API support
- `jackson-module-kotlin` - Kotlin JSON serialization
- `kotlin-reflect` - Kotlin reflection support

**Testing:**
- `spring-boot-starter-test` - Comprehensive test support
- `kotlin-test-junit5` - Kotlin test utilities

**Not Yet Added (common additions):**
- Database: Spring Data JPA, PostgreSQL/MySQL driver
- Migration: Flyway or Liquibase
- Validation: spring-boot-starter-validation
- Security: spring-boot-starter-security
- Monitoring: spring-boot-starter-actuator
- Documentation: springdoc-openapi

## Development Notes

**Kotlin Configuration:**
- Strict JSR-305 null-safety enabled (`-Xjsr305=strict`)
- Spring plugin auto-configures Spring-specific Kotlin features
- Use Kotlin idioms (data classes, extension functions, etc.)

**Gradle Configuration:**
- Uses Kotlin DSL (`build.gradle.kts`)
- Java toolchain enforces JDK 21
- Annotation processors configured for compile-only dependencies

**Current Limitations:**
- No database configured
- No REST endpoints implemented
- No domain models defined
- No module boundaries established
- No security layer

## Next Steps for Development

When extending this application:
1. Define module boundaries based on business domains
2. Add database configuration and Spring Data repositories
3. Implement domain models as Kotlin data classes
4. Create REST controllers with proper validation
5. Add integration tests for each module
6. Consider adding API documentation (Swagger/OpenAPI)
7. Implement security if needed
8. Add actuator for health checks and metrics
