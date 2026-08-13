# JavaLab

This lab uses Java's `ServiceLoader` to find game components.

`PlayerPlugin`, `EnemyPlugin` and `AsteroidPlugin` implement the two service interfaces in `api`. Their class names are registered in `resources/META-INF/services`. The `Main` class only uses the interfaces, so it does not create the plugins directly.

## Run

Requirements: JDK 21 and Maven.

```text
mvn clean verify
mvn exec:java
```

The test checks that all three plugins are found. The console program starts them, runs one update and prints the entities.
