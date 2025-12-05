package domain.game;

import java.util.Map;

public class ShuffleBehavior implements CardBehavior {

    @Override
    public void play(Game game, int playerIndex, Map<String, Object> context) {
        int shuffleCount = 1;
        if (context.containsKey("shuffleCount")) {
            shuffleCount = (Integer) context.get("shuffleCount");
        }

        performShuffle(game, shuffleCount);
    }

    @Override
    public boolean canPlay(Game game, int playerIndex) {
        return game.checkIfPlayerHasCard(playerIndex, CardType.SHUFFLE);
    }

    private void performShuffle(Game game, int shuffleCount) {
        for (int i = 0; i < shuffleCount; i++) {
            game.getDeck().shuffleDeck();
        }
    }

    public boolean isValidShuffleCount(int count) {
        return count > 0 && count <= 100;
    }
}