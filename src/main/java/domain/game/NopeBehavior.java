package domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NopeBehavior implements CardBehavior {
    private Card targetCard;
    private final List<Integer> nopeChain;

    public NopeBehavior() {
        this.nopeChain = new ArrayList<>();
    }

    @Override
    public void play(Game game, int playerIndex, Map<String, Object> context) {
        if (context.containsKey("targetCard")) {
            targetCard = (Card) context.get("targetCard");
        }

        game.removeCardFromHand(playerIndex, CardType.NOPE);

        nopeChain.add(playerIndex);

        if (shouldCancelCard()) {
            cancelCardEffect(game);
        }
    }

    @Override
    public boolean canPlay(Game game, int playerIndex) {
        return true;
    }

    private boolean cancelCardEffect(Game game) {
        if (targetCard == null) {
            return false;
        }

        return true;
    }

    private boolean shouldCancelCard() {
        return nopeChain.size() % 2 == 0;
    }
}