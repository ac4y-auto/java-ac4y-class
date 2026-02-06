# JAc4yClass

A Java persistence domain model library for object identification and classification.

## Overview

JAc4yClass provides a framework for managing identified and classified objects in Java applications. It implements a flexible identification system with GUID-based object tracking, human-readable IDs, and template-based classification.

## Features

- **GUID-based Object Identification**: Automatic UUID generation for unique object identification
- **Human-readable IDs**: Support for both internal and public human-readable identifiers
- **Template-based Classification**: Objects can be classified using template patterns
- **JPA/Hibernate Integration**: Full support for database persistence with JPA annotations
- **XML/JSON Serialization**: Built-in support for XML (JAXB) and JSON (Gson) serialization
- **Indicator Utilities**: Light (boolean) and numeric indicator classes for state management

## Components

### Domain Classes

#### Ac4yClass
Core entity representing a classification template. Extends `Ac4yIdentificationCommon` with JPA Entity and XML annotations.

#### Ac4yIdentification
Represents an identified object with template association. Links objects to their classification templates.

#### Ac4yIdentificationCommon
Base class providing common identification properties:
- GUID (UUID)
- Human ID (internal identifier)
- Public Human ID (external/display identifier)
- Personal Human ID
- External ID
- Name and Description
- Namespace
- Deleted flag
- Persistent ID

#### Ac4yObject
Base class for objects requiring identification. Contains an embedded `Ac4yIdentification` and serialization support.

#### Ac4yLightIndicator
Simple boolean indicator with semantic methods (on/off, yes/no).

#### Ac4yNumericIndicator
Integer counter with increment/decrement operations and copy functionality.

### Service Classes

#### Ac4yIdentificationDomBuilder
JDOM2-based utility for extracting identification information from XML DOM structures.

## Dependencies

- **JDOM2** (2.0.6): XML processing
- **javax.persistence** (2.1.0): JPA annotations
- **ac4yBase** (2016.1207.1-SNAPSHOT): Base utilities for JSON/XML/DOM handling

## Building

### Prerequisites
- Java 1.7 or higher
- Maven 3.x

### Build Commands

```bash
# Compile the project
mvn compile

# Run tests
mvn test

# Build JAR
mvn package

# Install to local repository
mvn install
```

## Usage Examples

### Creating a Classification

```java
// Create a new class template
Ac4yClass template = new Ac4yClass("UserType");
template.setDescription("User classification template");

// With explicit GUID
Ac4yClass template2 = new Ac4yClass("uuid-here", "AdminType");
```

### Creating an Identified Object

```java
// Create identification with template
Ac4yClass template = new Ac4yClass("UserType");
Ac4yIdentification identification = new Ac4yIdentification(template, "User001");

// Factory method
Ac4yIdentification id = Ac4yIdentification.createAc4yIdentificationByHumanID("User002");
```

### Using Indicators

```java
// Light indicator
Ac4yLightIndicator flag = new Ac4yLightIndicator();
flag.on();
if (flag.yes()) {
    // Process...
}

// Numeric indicator
Ac4yNumericIndicator counter = new Ac4yNumericIndicator();
counter.increment();
counter.increment();
int count = counter.getIndicator(); // Returns 2
```

## Testing

The project includes comprehensive JUnit 4 tests covering all domain and service classes:

- `Ac4yClassTest`: Tests for classification entities
- `Ac4yIdentificationTest`: Tests for identification objects
- `Ac4yLightIndicatorTest`: Tests for boolean indicators
- `Ac4yNumericIndicatorTest`: Tests for numeric counters
- `Ac4yIdentificationDomBuilderTest`: Tests for XML DOM processing

## Version

Current version: **2018.0325.1-SNAPSHOT**

## License

Please refer to the project license file for licensing information.

## Notes

- This is a legacy project targeting Java 1.7
- The project uses SNAPSHOT dependencies which may require local installation of ac4yBase
- Commented code in source files suggests ongoing development/refactoring

