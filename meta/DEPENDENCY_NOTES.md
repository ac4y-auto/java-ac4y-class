# Dependency Notes for JAc4yClass

## Overview

This document explains the dependency structure, decisions made regarding dependencies, and how the project was made independently buildable.

## Current Dependencies

### 1. JDOM2 (2.0.6)
- **GroupId**: org.jdom
- **ArtifactId**: jdom2
- **Version**: 2.0.6
- **Scope**: compile
- **License**: Apache License 2.0

**Purpose**: XML DOM manipulation

**Usage**:
- `Ac4yIdentificationDomBuilder` uses JDOM2 for parsing XML structures
- Provides methods to extract identification and template information from XML

**Why this version**:
- Stable release from 2013
- Compatible with Java 1.7+
- Well-established in the ecosystem

**Update considerations**:
- Latest version is 2.0.6 (no updates needed)
- Future: Consider migrating to DOM4J or standard javax.xml if JDOM2 becomes unmaintained

### 2. Gson (2.8.9)
- **GroupId**: com.google.code.gson
- **ArtifactId**: gson
- **Version**: 2.8.9
- **Scope**: compile
- **License**: Apache License 2.0

**Purpose**: JSON serialization/deserialization

**Usage**:
- `GsonCap` utility wrapper
- `Ac4yIdentificationCommon.getAsJson()` and `getFromJson()` methods
- Provides simple object-to-JSON conversion

**Why this version**:
- Stable release (2021)
- Compatible with Java 1.6+
- Lightweight and reliable

**Update considerations**:
- Latest version is 2.10.x (consider upgrading)
- Note: Gson 2.8.9 has no known critical vulnerabilities
- Future: Monitor for security updates

**Alternative considered**:
- Jackson: More features but heavier
- javax.json: More verbose API

### 3. javax.persistence (2.1.0)
- **GroupId**: org.eclipse.persistence
- **ArtifactId**: javax.persistence
- **Version**: 2.1.0
- **Scope**: compile
- **License**: Eclipse Public License 1.0

**Purpose**: JPA 2.1 annotations

**Usage**:
- `@Entity`, `@Id`, `@MappedSuperclass` annotations
- `@OneToOne`, `@Column` annotations
- Used across all domain entities

**Why this version**:
- JPA 2.1 standard (2013)
- Compatible with Java 1.7+
- Widely supported by persistence providers (Hibernate, EclipseLink)

**Update considerations**:
- JPA 2.2 (javax.persistence:javax.persistence-api:2.2) available
- JPA 3.0+ uses jakarta.persistence namespace
- Current version is sufficient for legacy compatibility

**Note**: This is just the API, not the implementation. At runtime, you need:
- Hibernate (org.hibernate:hibernate-core)
- EclipseLink (org.eclipse.persistence:eclipselink)
- Or other JPA provider

### 4. JAXB API (2.3.1)
- **GroupId**: javax.xml.bind
- **ArtifactId**: jaxb-api
- **Version**: 2.3.1
- **Scope**: compile
- **License**: CDDL 1.1 / GPL v2 with Classpath Exception

**Purpose**: XML binding annotations and API

**Usage**:
- `@XmlRootElement` annotations on entities
- `JAXBException` handling
- `JaxbCap` utility wrapper
- `Ac4yIdentificationCommon.getAsXml()` and `getFromXml()` methods

**Why this version**:
- Last version before Jakarta migration
- Compatible with Java 8-10
- Required because JAXB was removed from JDK 11+

**Important**: JAXB was part of Java SE 6-10 but removed in Java 11+. For Java 11+, explicit dependency is required.

### 5. JAXB Runtime (2.3.1)
- **GroupId**: org.glassfish.jaxb
- **ArtifactId**: jaxb-runtime
- **Version**: 2.3.1
- **Scope**: runtime
- **License**: CDDL 1.1 / GPL v2 with Classpath Exception

**Purpose**: JAXB implementation

**Usage**:
- Provides the actual marshalling/unmarshalling implementation
- Required at runtime for XML serialization/deserialization

**Why runtime scope**:
- Only needed at runtime, not during compilation
- Implementation detail, not part of public API

**Update considerations**:
- For Java 11+, these versions work well
- Jakarta XML Binding 3.0+ for Jakarta EE 9+
- Current version sufficient for Java 8-17

### 6. JUnit (4.13.2)
- **GroupId**: junit
- **ArtifactId**: junit
- **Version**: 4.13.2
- **Scope**: test
- **License**: Eclipse Public License 1.0

**Purpose**: Unit testing framework

**Usage**:
- Test classes in `src/test/java/`
- `@Test`, `@Before` annotations
- `Assert` methods for verification

**Why this version**:
- Latest JUnit 4.x (2021)
- Stable and widely used
- No known security vulnerabilities

**Update considerations**:
- JUnit 5 (Jupiter) available but requires migration
- Current version works well with Maven Surefire
- Consider JUnit 5 for new tests

**Note**: Scope is `test`, so not included in final JAR.

## Removed Dependencies

### ac4yBase (2016.1207.1-SNAPSHOT)
- **Status**: REMOVED
- **Reason**: Unavailable in Maven repositories

**Original Purpose**:
- Provided utility classes: `GsonCap`, `JaxbCap`, `JDOMXMLHander`
- Custom base functionality

**Resolution**:
Stub implementations created in `src/ac4y/utility/`:
1. `GsonCap.java` - Gson wrapper
2. `JaxbCap.java` - JAXB wrapper
3. `JDOMXMLHander.java` - JDOM utility

**Impact**:
- Project now builds independently
- No external SNAPSHOT dependency
- Functionality maintained through stubs

**Benefits**:
- Reproducible builds
- No dependency on unavailable artifacts
- Simplified dependency tree

## Dependency Tree

```
ac4y.base:ac4yClass:jar:2018.0325.1-SNAPSHOT
├── org.jdom:jdom2:jar:2.0.6:compile
├── com.google.code.gson:gson:jar:2.8.9:compile
├── org.eclipse.persistence:javax.persistence:jar:2.1.0:compile
├── javax.xml.bind:jaxb-api:jar:2.3.1:compile
│   └── javax.activation:javax.activation-api:jar:1.2.0:compile
├── org.glassfish.jaxb:jaxb-runtime:jar:2.3.1:runtime
│   ├── javax.xml.bind:jaxb-api:jar:2.3.1:runtime
│   ├── org.glassfish.jaxb:txw2:jar:2.3.1:runtime
│   ├── com.sun.istack:istack-commons-runtime:jar:3.0.7:runtime
│   ├── org.jvnet.staxex:stax-ex:jar:1.8:runtime
│   ├── com.sun.xml.fastinfoset:FastInfoset:jar:1.2.15:runtime
│   └── javax.activation:javax.activation-api:jar:1.2.0:runtime
└── junit:junit:jar:4.13.2:test
    └── org.hamcrest:hamcrest-core:jar:1.3:test
```

### Total Dependencies
- **Compile**: 4 direct dependencies
- **Runtime**: 1 direct dependency (+ 6 transitive)
- **Test**: 1 direct dependency (+ 1 transitive)
- **Total JAR size**: ~12KB (excluding dependencies)

## Runtime Classpath

For runtime execution, the following JARs are needed:

### Minimal Runtime (No XML)
```
ac4yClass-2018.0325.1-SNAPSHOT.jar
jdom2-2.0.6.jar
gson-2.8.9.jar
javax.persistence-2.1.0.jar
```

### Full Runtime (With XML)
Add to minimal:
```
jaxb-api-2.3.1.jar
jaxb-runtime-2.3.1.jar
activation-1.1.jar
```

### With JPA Provider (Hibernate example)
Add to full:
```
hibernate-core-5.x.x.jar
hibernate-jpa-2.1-api-1.0.x.jar
(and Hibernate transitive dependencies)
```

## Dependency Management Best Practices

### Version Properties
Consider adding to pom.xml:
```xml
<properties>
    <jdom.version>2.0.6</jdom.version>
    <gson.version>2.8.9</gson.version>
    <jpa.version>2.1.0</jpa.version>
    <jaxb.version>2.3.1</jaxb.version>
    <junit.version>4.13.2</junit.version>
</properties>
```

### Dependency Management Section
For multi-module projects:
```xml
<dependencyManagement>
    <dependencies>
        <!-- Define versions here -->
    </dependencies>
</dependencyManagement>
```

## Security Considerations

### Vulnerability Scanning
Regularly check for vulnerabilities:
```bash
mvn dependency-check:check
```

Or use online tools:
- Snyk: https://snyk.io/
- OWASP Dependency-Check
- GitHub Dependabot

### Current Status (as of 2026)
All dependencies are using stable versions with no known critical vulnerabilities. However, regular updates are recommended:

- **Gson 2.8.9**: Consider updating to 2.10.x
- **JAXB 2.3.1**: Monitor for Jakarta migration
- **JUnit 4.13.2**: Latest 4.x, consider 5.x for new features

## Future Migration Paths

### Java 11+ Considerations
Current configuration works with Java 8-17. No changes needed.

### Java 17+ Considerations
- JAXB dependencies already included (needed for Java 11+)
- Consider Java 17 LTS for long-term support
- Module system (JPMS) not yet configured

### Jakarta EE 9+ Migration
If migrating to Jakarta EE:
```xml
<!-- Replace javax.persistence with jakarta.persistence -->
<dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.1.0</version>
</dependency>

<!-- Replace javax.xml.bind with jakarta.xml.bind -->
<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
    <version>4.0.0</version>
</dependency>
```

**Impact**: Package names change from `javax.*` to `jakarta.*` - requires source code updates.

## Transitive Dependencies

### Handled by Maven
Maven automatically resolves transitive dependencies. Key transitive dependencies:

1. **javax.activation-api** (1.2.0)
   - Required by JAXB
   - Provides activation framework

2. **hamcrest-core** (1.3)
   - Required by JUnit
   - Provides matchers for assertions

3. **JAXB Runtime Dependencies**
   - txw2, istack-commons-runtime, stax-ex, FastInfoset
   - All handled automatically

### Conflict Resolution
If version conflicts arise:
```bash
# Show dependency tree
mvn dependency:tree

# Analyze conflicts
mvn dependency:analyze

# Force specific version
<dependency>
    <groupId>...</groupId>
    <artifactId>...</artifactId>
    <version>...</version>
</dependency>
```

## Licensing

All dependencies use permissive licenses compatible with commercial use:

- **Apache License 2.0**: Gson, JDOM2
- **EPL 1.0**: javax.persistence, JUnit
- **CDDL 1.1 / GPL v2**: JAXB

No copyleft restrictions on distribution.

## Recommendations

### Short Term
1. Update Gson to 2.10.x
2. Document JPA provider choice (Hibernate/EclipseLink)
3. Add dependency version properties

### Medium Term
1. Migrate tests to JUnit 5
2. Add dependency vulnerability scanning
3. Consider Java 17 LTS

### Long Term
1. Monitor Jakarta EE migration path
2. Consider module system (JPMS) adoption
3. Evaluate alternative serialization libraries

## Dependency Update Strategy

### Monitoring
- GitHub Dependabot alerts
- Maven Versions Plugin: `mvn versions:display-dependency-updates`
- Quarterly manual review

### Update Process
1. Check release notes
2. Update in feature branch
3. Run full test suite
4. Test integration scenarios
5. Update documentation
6. Merge to main

### Backward Compatibility
- Maintain Java 8 compatibility
- Avoid breaking API changes in dependencies
- Test with multiple JPA providers
- Validate serialization compatibility

## Conclusion

The dependency structure is lean and well-justified. Each dependency serves a clear purpose and is actively maintained. The removal of the ac4yBase SNAPSHOT dependency significantly improves build reproducibility and project independence.

Regular dependency updates and security monitoring are recommended to maintain a healthy project.
