# JavaLab - ServiceLoader whiteboard model

This command-line Asteroids model shows Java SE's built-in `ServiceLoader` without JPMS. Core knows only the service interfaces in `api`; it never imports or constructs Player, Enemy or Asteroids provider classes.

The whiteboard roles are:

- **Provider:** `PlayerPlugin`, `EnemyPlugin` and `AsteroidPlugin` implement the service contracts.
- **Registration:** provider class names are listed in `resources/META-INF/services/api.IGamePluginService` and `api.IEntityProcessingService`.
- **Consumer:** `app.Main` asks `ServiceLoader` for all registered implementations.
- **Discovery:** Java reads the registration files from the runtime class path and constructs providers.

Adding another component therefore requires a provider and registration entry, not an edit to Core. This removes direct compile-time coupling from the consumer to concrete components.

## Deterministic smoke run

JDK 21 is recommended (the source is compatible with JDK 17+).

```powershell
powershell -ExecutionPolicy Bypass -File .\build.ps1
```

or on Linux/macOS/Git Bash:

```bash
./build.sh
```

The command compiles once, copies the standard registration files and prints the sorted discovered component names followed by their updated entities.
