# Maven Assignment

Simple example project for capitalizing a string and generating MD5 and SHA-256 hash values.

## Project Overview

This Maven project demonstrates:
- **CapitalizeString**: Utility class to capitalize the first letter of a given string
- **EncryptString**: Utility class to compute hash values using MD5 and SHA-256 algorithms
- **MainTest**: Comprehensive unit tests using JUnit 5 (Jupiter)

### Technologies & Tools
- **Java 25** (Source/Target)
- **Maven 3.x** for build automation
- **JUnit 5 (Jupiter) 6.0.3** for unit testing
- **Lombok 1.18.42** for annotation processing
- **Spotless 3.2.1** for code formatting
- **Checkstyle 3.6.0** for code style enforcement
- **PMD 3.28.0** for code quality analysis

## Build & Run

### Compile the Project
```bash
mvn clean compile
```

### Run Unit Tests
```bash
mvn clean test
```

### Build JAR File
```bash
mvn clean package
```

### Run the Application
```bash
java -jar target/MavenAssingment-1.0.1.jar
```

## Code Quality & Formatting

This project includes several plugins to enforce code quality and consistency.

### 1. Maven JAR Plugin - JAR Packaging

**Purpose**: Packages compiled Java code into a JAR (Java ARchive) file for distribution and execution.

#### Commands

**Create JAR package (included in package phase):**
```bash
mvn jar:jar
```

**Build complete package with JAR:**
```bash
mvn clean package
```

**Configuration**:
- **archive/manifest/mainClass**: `com.smu.mscda.Main` - Specifies entry point
- **finalName**: `MavenAssingment-${project.version}` - JAR filename

**Output**:
- `target/MavenAssingment-1.0.1.jar` - Executable JAR file

---

### 2. Maven Shade Plugin - Uber JAR Creation

**Purpose**: Creates a fat JAR (uber JAR) that includes all project dependencies in a single executable file.

#### Commands

**Create shaded JAR with dependencies:**
```bash
mvn clean package shade:shade
```

**Build only shade JAR:**
```bash
mvn shade:shade
```

**Full command:**
```bash
mvn org.apache.maven.plugins:maven-shade-plugin:shade
```

**Features**:
- Packages all dependencies into a single JAR
- No need for external classpath configuration
- Relocates classes to avoid conflicts
- Creates self-contained executable
- Useful for command-line applications and microservices

**Configuration**:
- **transformers/mainClass**: Sets entry point for executable JAR
- **finalName**: Names the output JAR file
- **shadedArtifactAttached**: Creates both original and shaded JARs

**Output**:
- `target/MavenAssingment-1.0.1.jar` - Shaded JAR with all dependencies included

**Execution**:
```bash
java -jar target/MavenAssingment-1.0.1.jar
```

---

### 3. Spotless - Code Formatting

**Purpose**: Automatically formats code according to Google Java Format standard.

#### Commands

**Check formatting (fail if not formatted):**
```bash
mvn spotless:check
```

**Auto-format all Java files:**
```bash
mvn spotless:apply
```

**Full command to format:**
```bash
mvn com.diffplug.spotless:spotless-maven-plugin:apply
```

**Configuration**: Uses Google Java Format, removes unused imports, and enforces import ordering.

---

### 4. Checkstyle - Code Style Enforcement

**Purpose**: Validates code against Google's coding standards to ensure consistency.

**Configuration File**: `google_checks.xml` (built-in)

#### Commands

**Check code style (fail build on violations):**
```bash
mvn checkstyle:check
```

**Generate Checkstyle report (without failing build):**
```bash
mvn checkstyle:checkstyle
```

**Full command:**
```bash
mvn org.apache.maven.plugins:maven-checkstyle-plugin:check
```

**Options**:
- **failsOnError**: `true` - Build fails if violations found
- **consoleOutput**: `true` - Outputs violations to console
- **includeTestSourceDirectory**: `true` - Checks test code as well

---

### 5. PMD - Code Quality Analysis

**Purpose**: Detects potential bugs, dead code, and other issues.

**Ruleset**: `/rulesets/java/quickstart.xml` (built-in basic rules)

#### Commands

**Check code quality (fail build on violations):**
```bash
mvn pmd:check
```

**Generate PMD report:**
```bash
mvn pmd:pmd
```

**Generate HTML report (view at target/site/pmd.html):**
```bash
mvn site
```

**Full check command:**
```bash
mvn org.apache.maven.plugins:maven-pmd-plugin:check
```

**Configuration**:
- **minimumPriority**: `3` (1=high, 5=low severity)
- **failOnViolation**: `true` - Fails build if violations found
- **includeTests**: `true` - Analyzes test code

---

## Complete Build Pipeline

### Full Build with All Checks
```bash
mvn clean verify
```

This runs:
1. Code compilation
2. Unit tests
3. Spotless formatting check
4. Checkstyle style validation
5. PMD code quality analysis

### Build Without Enforcement (Skip Plugins)
```bash
mvn clean compile -DskipTests -Dcheckstyle.skip=true -Dpmd.skip=true
```

### Individual Plugin Commands Summary

| Plugin | Check Command | Fix/Report Command |
|--------|---------------|--------------------|
| **Maven JAR** | `mvn clean package` | `mvn jar:jar` |
| **Maven Shade** | `mvn clean package shade:shade` | `mvn shade:shade` |
| **Spotless** | `mvn spotless:check` | `mvn spotless:apply` |
| **Checkstyle** | `mvn checkstyle:check` | `mvn checkstyle:checkstyle` |
| **PMD** | `mvn pmd:check` | `mvn pmd:pmd` |
| **JUnit** | `mvn test` | N/A |

## Project Structure

```
src/
├── main/
│   ├── java/com/smu/mscda/
│   │   ├── Main.java              (Entry point with example usage)
│   │   ├── CapitalizeString.java  (String capitalization utility)
│   │   └── EncryptString.java     (Hash generation utility - MD5/SHA-256)
│   └── resources/
└── test/
    └── java/com/smu/mscda/
        └── MainTest.java          (Comprehensive unit tests)
```

## Testing

The project includes comprehensive unit tests using JUnit 5:

```bash
mvn test
```

**Test Coverage**:
- String capitalization (normal, single char, already capitalized)
- MD5 hashing
- SHA-256 hashing
- Error handling (null/empty input validation)

## Troubleshooting

### Build Fails on Formatting
```bash
mvn spotless:apply
```

### Build Fails on Style Violations
Review and fix violations or temporarily skip:
```bash
mvn clean verify -Dcheckstyle.skip=true
```

### Build Fails on Code Quality Issues
Review PMD report:
```bash
mvn pmd:pmd
cat target/pmd.xml
```

## Development Workflow

**Recommended workflow**:

1. **Make code changes**
   ```bash
   # Edit your Java files
   ```

2. **Auto-format code**
   ```bash
   mvn spotless:apply
   ```

3. **Run tests**
   ```bash
   mvn clean test
   ```

4. **Full build verification**
   ```bash
   mvn clean verify
   ```

If any step fails, address the issues and repeat.

