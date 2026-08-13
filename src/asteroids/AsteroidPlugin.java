package asteroids;

import api.Entity;
import api.GameData;
import api.IEntityProcessingService;
import api.IGamePluginService;

public final class AsteroidPlugin implements IGamePluginService, IEntityProcessingService {
    @Override public String name() { return "Asteroids"; }
    @Override public void start(GameData data) { data.entities().add(new Entity("ASTEROID", 100)); }
    @Override public void process(GameData data, double deltaSeconds) {
        data.entities().stream().filter(e -> e.type().equals("ASTEROID"))
                .forEach(e -> e.setX(e.x() - 4 * deltaSeconds));
    }
}
