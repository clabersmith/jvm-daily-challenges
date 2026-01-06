# JVM Daily Challenges

A daily practice project focused on building fluency across the **JVM ecosystem** using **Java**, **Kotlin**, and **Groovy**, with **Gradle** as the build system and **Spock** for testing.

This repository emphasizes **clear problem-solving, language comparison, and modern tooling**, rather than simply collecting finished solutions.

View full list of challenges [here](tasks.md).

---

## Project Goals

- Practice **core programming and algorithmic skills** consistently
- Strengthen fluency across **multiple JVM languages**
- Compare **idiomatic approaches** between Java, Kotlin, and Groovy
- Use **Gradle** and **Spock** in a realistic, professional setup
- Thoughtfully incorporate **AI tools** to explore alternative implementations

---

## Repository Structure

This project uses a **branch-based learning workflow**:

### `main` branch
- Contains:
  - Problem descriptions
  - Fully implemented **test cases**
  - Empty class stubs for each daily challenge
- Represents a **clean starting point** for solving each problem

### `solutions` branch
- Contains:
  - Complete implementations for each challenge
  - Multiple approaches where appropriate
  - Cross-language comparisons (Java, Kotlin, Groovy)

This separation makes it easy to:
- Attempt problems independently
- Review and compare solutions afterward
- Keep the problem definitions immutable

---

## Testing

- All challenges are validated using **Spock Framework**
- Tests are written in **Groovy**
- Running all tests:

```bash
./gradlew test
```

---

## Use of AI Tools

AI tools are used in this project in a **limited and controlled manner** to support learning and comparison, not as a primary source of solutions.

Problem descriptions, documentation, and test scaffolding are built using AI tools but reviewed and validated before inclusion.

### Approach

- Each problem is solved **independently first**, typically using **Java**
- AI tools can be consulted afterward to:
  - Review alternative approaches
  - Compare language-specific idioms across Java, Kotlin, and Groovy
  - Identify potential improvements in clarity or structure
- The intention is for all solution code to either be **written, reviewed, or validated** by me

### Rationale

The intent of using AI tools here is to:
- Encourage broader perspective when comparing JVM languages
- Supplement traditional learning resources such as documentation and examples
- Support careful evaluation rather than automation of problem-solving
