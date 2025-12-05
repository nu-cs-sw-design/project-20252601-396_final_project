package domain.game;

import java.util.Map;

public class ExplodingKittenBehavior implements CardBehavior {

    @Override
    public void play(Game game, int playerIndex, Map<String, Object> context) {
        if (game.checkIfPlayerHasCard(playerIndex, CardType.DEFUSE)) {
            return;
        }

        game.getPlayerAtIndex(playerIndex).setIsDead();
        if (playerIndex == game.getPlayerTurn()) {
            game.setCurrentPlayerNumberOfTurns(0);
        }

        game.playExplodingKitten(playerIndex);
    }

    @Override
    public boolean canPlay(Game game, int playerIndex) {
        return false;
    }
}