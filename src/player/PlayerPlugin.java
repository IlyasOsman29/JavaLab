package player;

import api.Entity;
import api.GameData;
import api.IEntityProcessingService;
import api.IGamePluginService;

public final class PlayerPlugin implements IGamePluginService, IEntityProcessingService {
    @Override public String name() { return "Player"; }
    @Override public void start(GameData data) { data.entities().add(new Entity("PLAYER", 0)); }
    @Override public void process(GameData data, double deltaSeconds) {
        data.entities().stream().filter(e -> e.type().equals("PLAYER"))
                .forEach(e -> e.setX(e.x() + 10 * deltaSeconds));
    }
}
