package domain.game;

import java.util.Map;

public class DefuseBehavior implements CardBehavior {

    @Override
    public void play(Game game, int playerIndex, Map<String, Object> context) {
        if (!context.containsKey("insertionIndex")) {
            throw new IllegalArgumentException("Defuse requires insertion index in context");
        }

        int insertionIndex = (Integer) context.get("insertionIndex");
        game.getDeck().insertExplodingKittenAtIndex(insertionIndex); // The exploding kitten is reinserted into the draw pile once it is defused
        game.removeCardFromHand(playerIndex, CardType.DEFUSE);

        if (playerIndex == game.getPlayerTurn()) {
            game.setCurrentPlayerNumberOfTurns(0);
        }
    }

    @Override
    public boolean canPlay(Game game, int playerIndex) {
        // Defuse can only be played when player has drawn an exploding kitten
        return game.checkIfPlayerHasCard(playerIndex, CardType.EXPLODING_KITTEN);
    }

    public boolean isValidInsertionIndex(Game game, int index) {
        return index >= 0 && index <= game.getDeckSize();
    }
}