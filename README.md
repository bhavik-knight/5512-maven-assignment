# Maven Assignment

A comprehensive Maven project demonstrating professional Java build automation, testing strategies, code quality enforcement, and external library integration.

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/bhavik-knight/MavenAssingment.git MavenAssingment
cd MavenAssingment
```

### Quick Start
```bash
# Full build with verification
mvn clean verify

# Run all tests (21 tests)
mvn test

# Run the application
java -jar target/MavenAssingment-1.0.1.jar
```

## Project Overview

This Maven project demonstrates:
- **CapitalizeString**: Utility class to capitalize the first letter of a given string (manually implemented)
- **EncryptString**: Utility class to compute hash values using MD5 and SHA-256 algorithms (manually implemented)
- **MainTest**: 12 comprehensive unit tests using manually written classes with JUnit 5 (Jupiter)
- **ExternalLibrariesTest**: 9 comprehensive unit tests using external Apache Commons libraries

### Key Features

✅ **Dual Testing Approach**: Tests both manual implementations and external libraries to ensure correctness  
✅ **21 Total Tests**: Expanded from 12 to 21 tests with matching test scenarios  
✅ **External Libraries**: Integrated Apache Commons Lang3 for *Capitalization* and Apache Commons Codec for *Hashing*  
✅ **Production Ready**: Executable JAR with all dependencies included (Shade plugin)  
✅ **Code Quality**: 100% compliance with Spotless, Checkstyle, and PMD  
✅ **Professional Build Pipeline**: 5 quality plugins with automated enforcement

### Technologies & Tools
- **Java 21** (Source/Target)
- **Maven 3.x** for build automation
- **JUnit 5 (Jupiter) 6.0.3** for unit testing
- **Apache Commons Lang3 3.20.0** for string utilities (capitalization)
- **Apache Commons Codec 1.21.0** for hashing utilities (MD5, SHA-256)
- **Lombok 1.18.42** for annotation processing
- **Spotless 3.2.1** for code formatting
- **Checkstyle 3.6.0** for code style enforcement
- **PMD 3.28.0** for code quality analysis

---

## Project Summary

### What This Project Demonstrates

This project is a professional example of:

1. **Maven Best Practices**
   - Proper POM configuration
   - Dependency management
   - Build lifecycle customization
   - Plugin configuration and execution phases

2. **Professional Testing Pattern - Dual Implementation**
   - Manual implementations tested independently (12 tests)
   - External libraries tested with identical scenarios (9 tests)
   - Results compared for validation and correctness
   - **Total: 21 tests with 100% pass rate**

3. **Code Quality Enforcement**
   - Automated code formatting (Spotless - Google Java Format)
   - Style guide enforcement (Checkstyle - Google standards)
   - Code quality analysis (PMD - bug detection)
   - Build failure on violations

4. **External Library Integration**
   - Apache Commons Lang3: String utilities
   - Apache Commons Codec: Hashing functions
   - Proper dependency management
   - Version control and updates

5. **Build Automation**
   - Executable JAR creation (Maven JAR Plugin)
   - Uber JAR with dependencies (Maven Shade Plugin)
   - Automated quality checks
   - Reproducible builds

### Test Coverage

The project includes **21 comprehensive unit tests** across two test suites:

| Category | Manual Implementation | External Libraries | Total |
|----------|----------------------|-------------------|-------|
| String Capitalization | 4 tests | 3 tests | 7 tests |
| MD5 Hashing | 4 tests | 3 tests | 7 tests |
| SHA-256 Hashing | 4 tests | 3 tests | 7 tests |
| **TOTAL** | **12 tests** | **9 tests** | **21 tests** |

**All tests PASSING ✅ | Pass Rate: 100% ✅ | Unique Scenarios: 7 (each tested 2 ways)**

#### MainTest.java (12 Tests - Manual Implementations)
- Tests using custom-written `CapitalizeString` class
- Tests using custom-written `EncryptString` class
- Validates manual implementations are correct
- Covers capitalization, MD5, SHA-256, error handling

#### ExternalLibrariesTest.java (9 Tests - Apache Commons)
- Tests using `StringUtils.capitalize()` from Apache Commons Lang3
- Tests using `DigestUtils` from Apache Commons Codec
- Validates external libraries work correctly
- Identical scenarios to manual tests for comparison

### Dual Testing Benefits

✅ **Code Correctness**: Manual implementations match library behavior  
✅ **Library Validation**: External libraries produce expected results  
✅ **Documentation**: Test cases serve as usage examples  
✅ **Confidence**: Double verification of algorithm implementations  
✅ **Best Practices**: Demonstrates professional testing patterns

### Build Artifacts

- **MavenAssingment-1.0.1.jar** (1.1 MB)
  - Executable JAR with all dependencies included
  - Created by Maven Shade Plugin
  - Ready for distribution and execution
  - Run: `java -jar target/MavenAssingment-1.0.1.jar`

- **original-MavenAssingment-1.0.1.jar** (7.1 KB)
  - Original JAR without dependencies (backup)

### Build Quality Status

| Plugin | Status | Details |
|--------|--------|---------|
| Spotless (Formatting) | ✅ PASSED | Google Java Format compliant |
| Checkstyle (Style) | ✅ PASSED | Google style guidelines enforced |
| PMD (Quality) | ✅ PASSED | Zero code quality violations |
| JUnit (Tests) | ✅ PASSED | 21/21 tests passing |
| Build (Maven) | ✅ SUCCESS | All phases completed |

---

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

**Version**: 3.5.0

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.5.0</version>
    <configuration>
        <archive>
            <manifest>
                <addClasspath>true</addClasspath>
                <mainClass>com.smu.mscda.Main</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```

**Commands**:
```bash
# Standard build and package
mvn clean package

# Build JAR only
mvn jar:jar

# Create JAR without running tests
mvn clean package -DskipTests
```

**Output**:
- `target/MavenAssingment-1.0.1.jar` - Executable JAR file

**Key Features**:
- Creates executable JAR with manifest
- Sets main class for direct execution: `com.smu.mscda.Main`
- Includes classpath in manifest for easier dependency management
- Version-stamped filename: `MavenAssingment-${project.version}.jar`

**Execution**:
```bash
java -jar target/MavenAssingment-1.0.1.jar
```

---

### 2. Maven Shade Plugin - Uber JAR Creation

**Purpose**: Creates a fat JAR (uber JAR) that includes all project dependencies in a single executable file, eliminating the need for external classpath configuration.

**Version**: 3.6.1

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.6.1</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Create shaded JAR (automatic with package phase)
mvn clean package

# Build only shade JAR
mvn shade:shade

# Full command
mvn org.apache.maven.plugins:maven-shade-plugin:3.6.1:shade
```

**Output**:
- `target/MavenAssingment-1.0.1.jar` - Shaded JAR with all dependencies included
- `target/original-MavenAssingment-1.0.1.jar` - Original JAR (backup)

**Key Features**:
- Packages all dependencies into a single JAR
- Creates self-contained executable (no external classpath needed)
- Relocates classes to avoid conflicts with existing libraries
- Ideal for command-line applications and microservices

**Execution**:
```bash
java -jar target/MavenAssingment-1.0.1.jar
# No additional classpath configuration needed!
```

---

### 3. Spotless - Code Formatting

**Purpose**: Automatically formats code according to Google Java Format standard for consistent code style across the project.

**Version**: 3.2.1

**Configuration**:
```xml
<plugin>
    <groupId>com.diffplug.spotless</groupId>
    <artifactId>spotless-maven-plugin</artifactId>
    <version>3.2.1</version>
    <configuration>
        <java>
            <googleJavaFormat />
            <removeUnusedImports />
            <importOrder>
                <order>java.,javax.,org.,com.,,static java.,static javax.,static org.,static com.</order>
            </importOrder>
            <includes>
                <include>src/main/java/**/*.java</include>
                <include>src/test/java/**/*.java</include>
            </includes>
        </java>
        <formats>
            <format>
                <includes>
                    <include>pom.xml</include>
                </includes>
                <trimTrailingWhitespace />
                <endWithNewline />
            </format>
        </formats>
    </configuration>
    <executions>
        <execution>
            <id>spotless-check</id>
            <goals>
                <goal>check</goal>
            </goals>
            <phase>verify</phase>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Check code formatting (fail if not formatted)
mvn spotless:check

# Auto-format all Java files
mvn spotless:apply

# Full command with plugin prefix
mvn com.diffplug.spotless:spotless-maven-plugin:apply
```

**Features**:
- Google Java Format standard compliance
- Automatic import organization
- Removal of unused imports
- POM.xml formatting enforcement
- Trailing whitespace removal
- Newline enforcement

**Workflow**:
```bash
# Before committing
mvn spotless:apply

# Verify formatting in CI/CD
mvn spotless:check
```

---

### 4. Checkstyle - Code Style Enforcement

**Purpose**: Validates code against Google's coding standards to ensure consistency and prevent style violations.

**Version**: 3.6.0

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-checkstyle-plugin</artifactId>
    <version>3.6.0</version>
    <configuration>
        <configLocation>google_checks.xml</configLocation>
        <consoleOutput>true</consoleOutput>
        <failsOnError>true</failsOnError>
        <includeTestSourceDirectory>true</includeTestSourceDirectory>
        <linkXRef>false</linkXRef>
    </configuration>
    <executions>
        <execution>
            <id>checkstyle</id>
            <phase>verify</phase>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Check code style (fail build on violations)
mvn checkstyle:check

# Generate detailed Checkstyle report (without failing)
mvn checkstyle:checkstyle

# Skip checkstyle in build
mvn clean verify -Dcheckstyle.skip=true
```

**Configuration**:
- **configLocation**: `google_checks.xml` - Built-in Google style guide
- **failsOnError**: `true` - Build fails on violations
- **consoleOutput**: `true` - Prints violations to console
- **includeTestSourceDirectory**: `true` - Validates test code

**Report Location**:
```
target/checkstyle-result.xml
target/site/checkstyle.html (after mvn site)
```

---

### 5. PMD - Code Quality Analysis

**Purpose**: Detects potential bugs, dead code, performance issues, and other code quality problems.

**Version**: 3.28.0

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-pmd-plugin</artifactId>
    <version>3.28.0</version>
    <configuration>
        <rulesets>
            <ruleset>/rulesets/java/quickstart.xml</ruleset>
        </rulesets>
        <minimumPriority>3</minimumPriority>
        <printFailingErrors>true</printFailingErrors>
        <failOnViolation>true</failOnViolation>
        <includeTests>true</includeTests>
    </configuration>
    <executions>
        <execution>
            <id>pmd-check</id>
            <phase>verify</phase>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Check code quality (fail build on violations)
mvn pmd:check

# Generate PMD report
mvn pmd:pmd

# Generate HTML report
mvn site

# Skip PMD checks
mvn clean verify -Dpmd.skip=true
```

**Configuration**:
- **rulesets**: `/rulesets/java/quickstart.xml` - Basic quality rules
- **minimumPriority**: `3` (1=high, 5=low severity)
- **failOnViolation**: `true` - Build fails on violations
- **includeTests**: `true` - Analyzes test code

**Report Location**:
```
target/pmd.xml
target/site/pmd.html (after mvn site)
```

**Common Issues Detected**:
- Unused variables
- Empty catch blocks
- Duplicate code
- Missing javadoc
- Complex methods
- Performance issues

---

## Plugin Documentation & Commands

This section provides detailed information about all Maven plugins used in the project, including configuration, usage commands, and best practices.

### 1. Maven JAR Plugin - JAR Packaging

**Purpose**: Packages compiled Java code into a JAR (Java ARchive) file for distribution and execution.

**Version**: 3.5.0

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>3.5.0</version>
    <configuration>
        <archive>
            <manifest>
                <addClasspath>true</addClasspath>
                <mainClass>com.smu.mscda.Main</mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```

**Commands**:
```bash
# Standard build and package
mvn clean package

# Build JAR only
mvn jar:jar

# Create JAR without running tests
mvn clean package -DskipTests
```

**Output**:
- `target/MavenAssingment-1.0.1.jar` - Executable JAR file

**Key Features**:
- Creates executable JAR with manifest
- Sets main class for direct execution: `com.smu.mscda.Main`
- Includes classpath in manifest for easier dependency management
- Version-stamped filename: `MavenAssingment-${project.version}.jar`

**Execution**:
```bash
java -jar target/MavenAssingment-1.0.1.jar
```

---

### 2. Maven Shade Plugin - Uber JAR Creation

**Purpose**: Creates a fat JAR (uber JAR) that includes all project dependencies in a single executable file, eliminating the need for external classpath configuration.

**Version**: 3.6.1

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.6.1</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Create shaded JAR (automatic with package phase)
mvn clean package

# Build only shade JAR
mvn shade:shade

# Full command
mvn org.apache.maven.plugins:maven-shade-plugin:3.6.1:shade
```

**Output**:
- `target/MavenAssingment-1.0.1.jar` - Shaded JAR with all dependencies included
- `target/original-MavenAssingment-1.0.1.jar` - Original JAR (backup)

**Key Features**:
- Packages all dependencies into a single JAR
- Creates self-contained executable (no external classpath needed)
- Relocates classes to avoid conflicts with existing libraries
- Ideal for command-line applications and microservices

**Execution**:
```bash
java -jar target/MavenAssingment-1.0.1.jar
# No additional classpath configuration needed!
```

---

### 3. Spotless - Code Formatting

**Purpose**: Automatically formats code according to Google Java Format standard for consistent code style across the project.

**Version**: 3.2.1

**Configuration**:
```xml
<plugin>
    <groupId>com.diffplug.spotless</groupId>
    <artifactId>spotless-maven-plugin</artifactId>
    <version>3.2.1</version>
    <configuration>
        <java>
            <googleJavaFormat />
            <removeUnusedImports />
            <importOrder>
                <order>java.,javax.,org.,com.,,static java.,static javax.,static org.,static com.</order>
            </importOrder>
            <includes>
                <include>src/main/java/**/*.java</include>
                <include>src/test/java/**/*.java</include>
            </includes>
        </java>
        <formats>
            <format>
                <includes>
                    <include>pom.xml</include>
                </includes>
                <trimTrailingWhitespace />
                <endWithNewline />
            </format>
        </formats>
    </configuration>
    <executions>
        <execution>
            <id>spotless-check</id>
            <goals>
                <goal>check</goal>
            </goals>
            <phase>verify</phase>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Check code formatting (fail if not formatted)
mvn spotless:check

# Auto-format all Java files
mvn spotless:apply

# Full command with plugin prefix
mvn com.diffplug.spotless:spotless-maven-plugin:apply
```

**Features**:
- Google Java Format standard compliance
- Automatic import organization
- Removal of unused imports
- POM.xml formatting enforcement
- Trailing whitespace removal
- Newline enforcement

**Workflow**:
```bash
# Before committing
mvn spotless:apply

# Verify formatting in CI/CD
mvn spotless:check
```

---

### 4. Checkstyle - Code Style Enforcement

**Purpose**: Validates code against Google's coding standards to ensure consistency and prevent style violations.

**Version**: 3.6.0

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-checkstyle-plugin</artifactId>
    <version>3.6.0</version>
    <configuration>
        <configLocation>google_checks.xml</configLocation>
        <consoleOutput>true</consoleOutput>
        <failsOnError>true</failsOnError>
        <includeTestSourceDirectory>true</includeTestSourceDirectory>
        <linkXRef>false</linkXRef>
    </configuration>
    <executions>
        <execution>
            <id>checkstyle</id>
            <phase>verify</phase>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Check code style (fail build on violations)
mvn checkstyle:check

# Generate detailed Checkstyle report (without failing)
mvn checkstyle:checkstyle

# Skip checkstyle in build
mvn clean verify -Dcheckstyle.skip=true
```

**Configuration**:
- **configLocation**: `google_checks.xml` - Built-in Google style guide
- **failsOnError**: `true` - Build fails on violations
- **consoleOutput**: `true` - Prints violations to console
- **includeTestSourceDirectory**: `true` - Validates test code

**Report Location**:
```
target/checkstyle-result.xml
target/site/checkstyle.html (after mvn site)
```

---

### 5. PMD - Code Quality Analysis

**Purpose**: Detects potential bugs, dead code, performance issues, and other code quality problems.

**Version**: 3.28.0

**Configuration**:
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-pmd-plugin</artifactId>
    <version>3.28.0</version>
    <configuration>
        <rulesets>
            <ruleset>/rulesets/java/quickstart.xml</ruleset>
        </rulesets>
        <minimumPriority>3</minimumPriority>
        <printFailingErrors>true</printFailingErrors>
        <failOnViolation>true</failOnViolation>
        <includeTests>true</includeTests>
    </configuration>
    <executions>
        <execution>
            <id>pmd-check</id>
            <phase>verify</phase>
            <goals>
                <goal>check</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

**Commands**:
```bash
# Check code quality (fail build on violations)
mvn pmd:check

# Generate PMD report
mvn pmd:pmd

# Generate HTML report
mvn site

# Skip PMD checks
mvn clean verify -Dpmd.skip=true
```

**Configuration**:
- **rulesets**: `/rulesets/java/quickstart.xml` - Basic quality rules
- **minimumPriority**: `3` (1=high, 5=low severity)
- **failOnViolation**: `true` - Build fails on violations
- **includeTests**: `true` - Analyzes test code

**Report Location**:
```
target/pmd.xml
target/site/pmd.html (after mvn site)
```

**Common Issues Detected**:
- Unused variables
- Empty catch blocks
- Duplicate code
- Missing javadoc
- Complex methods
- Performance issues

---

## Complete Plugin Commands Summary

| Plugin | Purpose | Check Command | Fix/Apply Command |
|--------|---------|------|------|
| **Maven JAR** | Package JAR | `mvn clean package` | `mvn jar:jar` |
| **Maven Shade** | Create uber JAR | `mvn clean package` | `mvn shade:shade` |
| **Spotless** | Code formatting | `mvn spotless:check` | `mvn spotless:apply` |
| **Checkstyle** | Style enforcement | `mvn checkstyle:check` | `mvn checkstyle:checkstyle` |
| **PMD** | Code quality | `mvn pmd:check` | `mvn pmd:pmd` |
| **JUnit** | Unit testing | `mvn test` | N/A |

---

## Build Quality Gates

### Full Verification (All Checks)
```bash
mvn clean verify
```

This runs in sequence:
1. ✅ Code compilation
2. ✅ Unit tests (21 tests)
3. ✅ Spotless formatting check
4. ✅ Checkstyle validation
5. ✅ PMD analysis
6. ✅ JAR packaging

### Skip Checks (Fast Build)
```bash
mvn clean package -DskipTests \
  -Dcheckstyle.skip=true \
  -Dpmd.skip=true
```

### Single Plugin Verification
```bash
# Format and check
mvn spotless:apply && mvn spotless:check

# Just checkstyle
mvn checkstyle:check

# Just PMD
mvn pmd:check

# Just tests
mvn test
```

---

## CI/CD Integration

### GitHub Actions Example
```yaml
name: Build & Quality Checks
on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '21'
      
      - name: Run full build with verification
        run: mvn clean verify
      
      - name: Upload test results
        if: always()
        uses: actions/upload-artifact@v3
        with:
          name: test-results
          path: target/surefire-reports/
```

---

## Troubleshooting Plugins

### Spotless Issues
```bash
# Reformat all files
mvn spotless:apply

# Check what would be formatted
mvn spotless:check -X
```

### Checkstyle Issues
```bash
# Generate detailed report
mvn checkstyle:checkstyle

# View violations
cat target/checkstyle-result.xml
```

### PMD Issues
```bash
# Generate detailed report
mvn pmd:pmd

# View violations
cat target/pmd.xml

# Generate HTML report
mvn site && open target/site/pmd.html
```

### Build Failures
```bash
# Skip all enforcement temporarily
mvn clean package -DskipTests \
  -Dcheckstyle.skip=true \
  -Dpmd.skip=true

# Then fix issues and re-run full build
mvn clean verify
```

---

## Best Practices

1. **Always use `spotless:apply` before committing**
   ```bash
   mvn spotless:apply && git add . && git commit
   ```

2. **Run full verification before pushing**
   ```bash
   mvn clean verify
   ```

3. **Fix issues in order** (Spotless → Checkstyle → PMD → Tests)

4. **Keep dependencies updated**
   ```bash
   mvn versions:display-dependency-updates
   ```

5. **Review reports regularly**
   ```bash
   mvn site
   ```
