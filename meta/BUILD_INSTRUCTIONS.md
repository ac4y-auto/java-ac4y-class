# Build Instructions for JAc4yClass

## Prerequisites

### Required Software
- **Java Development Kit (JDK)**: Version 1.8 or higher
- **Apache Maven**: Version 3.x or higher
- **Git**: For version control (optional)

### Verify Installation
```bash
# Check Java version
java -version
javac -version

# Check Maven version
mvn -version
```

## Building the Project

### 1. Clone or Download Repository
```bash
git clone <repository-url>
cd JAc4yClass
```

### 2. Clean and Compile
```bash
# Clean previous builds
mvn clean

# Compile the project
mvn compile
```

Expected output: Compilation success with 10 source files compiled.

### 3. Run Tests (Optional)
```bash
mvn test
```

Note: Tests are currently not configured to run automatically. Test files were created but need proper integration.

### 4. Package JAR
```bash
# Create JAR file
mvn package

# Skip tests if needed
mvn package -DskipTests
```

**Output**: `target/ac4yClass-2018.0325.1-SNAPSHOT.jar` (~12KB)

### 5. Install to Local Repository
```bash
# Install to local Maven repository (~/.m2/repository)
mvn install
```

This makes the artifact available to other local Maven projects.

## Build Phases Explained

### clean
Deletes the `target/` directory and all compiled artifacts.

```bash
mvn clean
```

### compile
Compiles source code from `src/` directory to `target/classes/`.

```bash
mvn compile
```

### test-compile
Compiles test sources from `src/test/java/` to `target/test-classes/`.

```bash
mvn test-compile
```

### test
Runs unit tests using JUnit.

```bash
mvn test
```

### package
Creates JAR file in `target/` directory.

```bash
mvn package
```

### install
Installs JAR to local Maven repository.

```bash
mvn install
```

### deploy
Deploys JAR to remote repository (e.g., GitHub Packages).

```bash
mvn deploy
```

## Common Build Commands

### Full Build with Tests
```bash
mvn clean install
```

### Quick Build (No Tests)
```bash
mvn clean package -DskipTests
```

### Build and Show Dependencies
```bash
mvn dependency:tree
```

### Build with Debug Output
```bash
mvn clean package -X
```

### Build Offline (No Dependency Downloads)
```bash
mvn clean package -o
```

## Troubleshooting

### Issue: Java version not supported
**Error**: `Source option 7 is no longer supported. Use 8 or later.`

**Solution**: The project is configured for Java 1.8. Ensure JDK 8+ is installed:
```bash
# Check Java version
java -version

# Set JAVA_HOME if needed
export JAVA_HOME=/path/to/jdk-8-or-higher
```

### Issue: Dependencies not found
**Error**: `Could not resolve dependencies`

**Solution**: Maven will download dependencies automatically on first build. Ensure internet connection or check `~/.m2/settings.xml` for proxy configuration.

```bash
# Force dependency update
mvn clean package -U
```

### Issue: Compilation errors
**Error**: Various compilation errors

**Solution**:
1. Ensure all source files are present
2. Check Java version compatibility
3. Clean and rebuild:
```bash
mvn clean compile
```

### Issue: Test failures
**Error**: Tests fail or cannot be found

**Solution**: Currently tests are not fully integrated. Build with:
```bash
mvn package -DskipTests
```

## Project Structure

```
JAc4yClass/
├── pom.xml                 # Maven configuration
├── src/
│   ├── ac4y/
│   │   ├── base/
│   │   │   ├── domain/    # Domain entities
│   │   │   └── service/   # Service classes
│   │   └── utility/       # Utility classes
│   └── test/java/         # Test sources (not yet integrated)
├── target/                # Build output (created during build)
│   ├── classes/          # Compiled classes
│   └── *.jar             # Final JAR artifact
└── meta/                 # Project documentation
```

## Artifacts Produced

### Main JAR
- **Location**: `target/ac4yClass-2018.0325.1-SNAPSHOT.jar`
- **Size**: ~12KB
- **Contents**: Compiled classes from src/

### Compiled Classes
- **Location**: `target/classes/`
- **Structure**: Mirrors source package structure

## Dependencies

All dependencies are automatically downloaded by Maven on first build:

1. **jdom2** (2.0.6) - XML processing
2. **gson** (2.8.9) - JSON serialization
3. **javax.persistence** (2.1.0) - JPA annotations
4. **jaxb-api** (2.3.1) - XML binding API
5. **jaxb-runtime** (2.3.1) - XML binding implementation
6. **junit** (4.13.2) - Testing framework (test scope)

Dependencies are cached in `~/.m2/repository/`.

## Maven Configuration

### Compiler Settings
```xml
<source>1.8</source>
<target>1.8</target>
```

### Source Directories
- **Main**: `src/`
- **Test**: `src/test/java/`

### Plugins
1. **maven-compiler-plugin** (3.3) - Compilation
2. **maven-surefire-plugin** (2.22.2) - Test execution
3. **maven-jar-plugin** (3.2.0) - JAR creation

## Using the JAR

### Add as Dependency in Other Projects

#### Maven
```xml
<dependency>
    <groupId>ac4y.base</groupId>
    <artifactId>ac4yClass</artifactId>
    <version>2018.0325.1-SNAPSHOT</version>
</dependency>
```

#### Gradle
```groovy
implementation 'ac4y.base:ac4yClass:2018.0325.1-SNAPSHOT'
```

### Manual Classpath
```bash
java -cp target/ac4yClass-2018.0325.1-SNAPSHOT.jar:other-libs.jar com.example.Main
```

## Publishing to GitHub Packages

### Prerequisites
1. GitHub account with repository access
2. Personal Access Token with `write:packages` scope
3. Maven settings configured

### Configuration

#### 1. Create GitHub Personal Access Token
1. Go to GitHub Settings → Developer settings → Personal access tokens
2. Generate new token with `write:packages` scope
3. Save token securely

#### 2. Configure Maven Settings
Edit `~/.m2/settings.xml`:

```xml
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <password>YOUR_PERSONAL_ACCESS_TOKEN</password>
    </server>
  </servers>
</settings>
```

#### 3. Deploy to GitHub Packages
```bash
export GITHUB_REPOSITORY=username/JAc4yClass
mvn deploy
```

## Continuous Integration

### GitHub Actions Example
Create `.github/workflows/maven.yml`:

```yaml
name: Java CI with Maven

on:
  push:
    branches: [ master ]
  pull_request:
    branches: [ master ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 8
      uses: actions/setup-java@v3
      with:
        java-version: '8'
        distribution: 'temurin'

    - name: Build with Maven
      run: mvn clean package -DskipTests

    - name: Run tests
      run: mvn test
```

## Development Workflow

### Standard Workflow
1. Make code changes
2. Compile and verify: `mvn compile`
3. Run tests: `mvn test`
4. Package: `mvn package`
5. Commit changes

### Quick Iteration
```bash
# Compile only changed files
mvn compile

# Or use your IDE's incremental compilation
```

## IDE Integration

### IntelliJ IDEA
1. File → Open → Select `pom.xml`
2. Maven projects tool window will load automatically
3. Use Maven lifecycle phases from tool window

### Eclipse
1. File → Import → Maven → Existing Maven Projects
2. Select project directory
3. Use Run As → Maven build

### VS Code
1. Install "Extension Pack for Java"
2. Open folder containing `pom.xml`
3. Maven tasks available in sidebar

## Performance Optimization

### Faster Builds
```bash
# Use multiple threads (4 cores)
mvn clean package -T 4

# Skip tests
mvn package -DskipTests

# Offline mode (no dependency checks)
mvn package -o
```

### Dependency Management
```bash
# Download dependencies only
mvn dependency:resolve

# Show dependency tree
mvn dependency:tree

# Analyze dependencies
mvn dependency:analyze
```

## Additional Resources

- Maven Documentation: https://maven.apache.org/guides/
- Maven Central Repository: https://search.maven.org/
- GitHub Packages Guide: https://docs.github.com/en/packages

## Support

For build issues or questions:
1. Check Maven logs for error messages
2. Verify Java and Maven versions
3. Ensure all source files are present
4. Check internet connection for dependency downloads
5. Review `~/.m2/settings.xml` for custom configurations
