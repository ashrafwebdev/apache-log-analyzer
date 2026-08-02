# Apache Log Analyzer

A command-line tool that parses Apache access logs (combined log format) and reports on traffic patterns: top requesting IPs, HTTP status code breakdowns, and request volume over time.

Built as Phase 1 of a Java learning curriculum, applying real Apache server administration experience to a practical Java/OOP project rather than a toy exercise.

## Status

🚧 In progress — log parsing implemented, aggregation and reporting in development.

## Tech stack

- Java 21
- Maven
- JUnit 5

## How to run locally

```bash
mvn package
java -jar target/apache-log-analyzer.jar path/to/access.log
```

## How it works

_(to be filled in as the parser, aggregator, and report generator are built)_

## Running tests

```bash
mvn test
```
