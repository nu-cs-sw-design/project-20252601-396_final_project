package domain.game;

import java.util.Map;

public class Card {
	private CardType cardType;
	private boolean isMarked;
	private boolean isFacedUp;
    private CardBehavior behavior;

    public Card(CardType cardType, CardBehavior behavior) {
        this.isMarked = false;
        this.cardType = cardType;
        this.isFacedUp = false;
        this.behavior = behavior;
    }

    // Original constructor for backwards compatibility
    public Card(CardType cardType) {
        this(cardType, null);
    }

	public domain.game.CardType getCardType() {
		return cardType;
	}

    public void play(Game game, int playerIndex, Map<String, Object> context) {
        if (behavior != null && behavior.canPlay(game, playerIndex)) {
            behavior.play(game, playerIndex, context);
        } else {
            // Fallback to old behavior if no behavior is set
            playLegacy(game, playerIndex, context);
        }
    }

    public boolean canPlay(Game game, int playerIndex) {
        return behavior != null && behavior.canPlay(game, playerIndex);
    }

    public void setBehavior(CardBehavior behavior) {
        this.behavior = behavior;
    }

    public CardBehavior getBehavior() {
        return behavior;
    }

    // Legacy play method for backward compatibility
    private void playLegacy(Game game, int playerIndex, Map<String, Object> context) {
        // This is currently a no-op since the legacy play logic is contained within Game class
        // Retaining this method for future use/further refactoring
    }

	public void markCard() {
		isMarked = true;
	}

	public boolean checkIfMarked() {
		return isMarked;
	}

	public void setFacedUp() {
		isFacedUp = true;
	}

	public boolean checkIfFacedUp() {
		return isFacedUp;
	}
}

