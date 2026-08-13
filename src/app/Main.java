package app;

import api.Entity;
import api.GameData;
import api.IEntityProcessingService;
import api.IGamePluginService;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;

public final class Main {
    private Main() { }

    public static void main(String[] args) {
        GameData data = new GameData();
        List<IGamePluginService> plugins = ServiceLoader.load(IGamePluginService.class).stream()
                .map(ServiceLoader.Provider::get).sorted(Comparator.comparing(IGamePluginService::name)).toList();
        List<IEntityProcessingService> processors = ServiceLoader.load(IEntityProcessingService.class).stream()
                .map(ServiceLoader.Provider::get).sorted(Comparator.comparing(IEntityProcessingService::name)).toList();

        System.out.println("Discovered plugins: " + plugins.stream().map(IGamePluginService::name).toList());
        System.out.println("Discovered processors: " + processors.stream().map(IEntityProcessingService::name).toList());
        plugins.forEach(plugin -> plugin.start(data));
        processors.forEach(processor -> processor.process(data, 1.0));
        data.entities().stream().sorted(Comparator.comparing(Entity::type))
                .forEach(entity -> System.out.printf("ENTITY %-8s x=%.1f%n", entity.type(), entity.x()));
    }
}
