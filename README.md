# Maven Assignment

A Maven project for string capitalization and hashing (MD5, SHA-256), implemented and tested using both custom classes and external libraries.

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/bhavik-knight/MavenAssingment.git MavenAssingment
cd MavenAssingment
```

### Quick Start
```bash
mvn clean verify
mvn test
java -jar target/MavenAssingment-1.0.1.jar
```

## Project Overview

This project demonstrates:
- Manual implementation of capitalization and hashing logic
- External-library implementation using Apache Commons
- Maven build lifecycle and plugin-driven quality gates

### Core Classes
- `src/main/java/com/smu/mscda/CapitalizeString.java` - Manual capitalization
- `src/main/java/com/smu/mscda/EncryptString.java` - Manual MD5/SHA-256 hashing
- `src/main/java/com/smu/mscda/Main.java` - Demo runner using both approaches

### Test Classes
- `src/test/java/com/smu/mscda/MainTest.java` - 12 tests (manual classes)
- `src/test/java/com/smu/mscda/ExternalLibrariesTest.java` - 9 tests (Apache Commons)

## Project Summary

### Dual Testing Strategy
Both implementations are validated with matching scenarios:
- Manual classes: 12 tests
- External libraries: 9 tests
- Total: 21 tests

| Category | Manual | External | Total |
|---|---:|---:|---:|
| Capitalization | 4 | 3 | 7 |
| MD5 | 4 | 3 | 7 |
| SHA-256 | 4 | 3 | 7 |
| **Total** | **12** | **9** | **21** |

### Why this matters
- Confirms custom logic is correct
- Confirms library integration works as expected
- Provides practical examples for both approaches

## Technologies
- Java 21
- Maven 3.x
- JUnit Jupiter 6.0.3
- Apache Commons Lang3 3.20.0
- Apache Commons Codec 1.21.0
- Lombok 1.18.42
- Spotless 3.2.1
- Checkstyle 3.6.0
- PMD 3.28.0

## Build and Run

### Build Commands
```bash
mvn clean compile
mvn clean test
mvn clean package
```

### Run App
```bash
java -jar target/MavenAssingment-1.0.1.jar
```

## Code Quality and Plugins

Plugins are listed in required order (JAR and Shade first).

### 1) Maven JAR Plugin (`maven-jar-plugin:3.5.0`)
Purpose: Build executable JAR with manifest/main class.

Commands:
```bash
mvn clean package
mvn jar:jar
mvn clean package -DskipTests
```

### 2) Maven Shade Plugin (`maven-shade-plugin:3.6.1`)
Purpose: Build fat/uber JAR including dependencies.

Commands:
```bash
mvn clean package
mvn shade:shade
mvn org.apache.maven.plugins:maven-shade-plugin:3.6.1:shade
```

Outputs:
- `target/MavenAssingment-1.0.1.jar`
- `target/original-MavenAssingment-1.0.1.jar`

### 3) Spotless (`spotless-maven-plugin:3.2.1`)
Purpose: Automatic formatting (Google Java Format), import cleanup.

Commands:
```bash
mvn spotless:check
mvn spotless:apply
```

### 4) Checkstyle (`maven-checkstyle-plugin:3.6.0`)
Purpose: Style enforcement (Google checks).

Commands:
```bash
mvn checkstyle:check
mvn checkstyle:checkstyle
mvn clean verify -Dcheckstyle.skip=true
```

### 5) PMD (`maven-pmd-plugin:3.28.0`)
Purpose: Static code-quality analysis.

Commands:
```bash
mvn pmd:check
mvn pmd:pmd
mvn clean verify -Dpmd.skip=true
```

## Command Summary

| Tool | Check | Apply/Report |
|---|---|---|
| JAR | `mvn clean package` | `mvn jar:jar` |
| Shade | `mvn clean package` | `mvn shade:shade` |
| Spotless | `mvn spotless:check` | `mvn spotless:apply` |
| Checkstyle | `mvn checkstyle:check` | `mvn checkstyle:checkstyle` |
| PMD | `mvn pmd:check` | `mvn pmd:pmd` |
| Tests | `mvn test` | N/A |

## Quality Gates

### Full Verification
```bash
mvn clean verify
```

### Fast Build (skip quality checks)
```bash
mvn clean package -DskipTests -Dcheckstyle.skip=true -Dpmd.skip=true
```

## Troubleshooting

### Formatting issues
```bash
mvn spotless:apply
```

### Style issues
```bash
mvn checkstyle:checkstyle
cat target/checkstyle-result.xml
```

### PMD issues
```bash
mvn pmd:pmd
cat target/pmd.xml
```

## Best Practices
- Run `mvn spotless:apply` before commit
- Run `mvn clean verify` before push
- Fix issues in this order: Spotless -> Checkstyle -> PMD -> Tests
