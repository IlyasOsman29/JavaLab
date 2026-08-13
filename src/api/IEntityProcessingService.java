package api;

public interface IEntityProcessingService {
    void process(GameData gameData, double deltaSeconds);
    String name();
}
