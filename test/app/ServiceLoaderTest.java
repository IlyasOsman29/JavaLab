package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import api.IGamePluginService;
import java.util.List;
import java.util.ServiceLoader;
import org.junit.jupiter.api.Test;

class ServiceLoaderTest {
    @Test
    void discoversRegisteredPlugins() {
        List<String> names = ServiceLoader.load(IGamePluginService.class).stream()
                .map(provider -> provider.get().name())
                .sorted()
                .toList();

        assertEquals(List.of("Asteroids", "Enemy", "Player"), names);
    }
}
