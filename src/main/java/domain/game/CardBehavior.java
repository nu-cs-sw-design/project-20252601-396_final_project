package domain.game;

import java.util.Map;

public interface CardBehavior {
    void play(Game game, int playerIndex, Map<String, Object> context);

    boolean canPlay(Game game, int playerIndex);
}