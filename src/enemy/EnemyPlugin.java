package enemy;

import api.Entity;
import api.GameData;
import api.IEntityProcessingService;
import api.IGamePluginService;

public final class EnemyPlugin implements IGamePluginService, IEntityProcessingService {
    @Override public String name() { return "Enemy"; }
    @Override public void start(GameData data) { data.entities().add(new Entity("ENEMY", 200)); }
    @Override public void process(GameData data, double deltaSeconds) {
        data.entities().stream().filter(e -> e.type().equals("ENEMY"))
                .forEach(e -> e.setX(e.x() - 5 * deltaSeconds));
    }
}
