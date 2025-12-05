package domain.game;

import java.util.ArrayList;
import java.util.Random;
import java.security.SecureRandom;

public class Instantiator {
    private CardBehaviorFactory behaviorFactory;

    public Instantiator(CardBehaviorFactory behaviorFactory) {
        this.behaviorFactory = behaviorFactory;
    }

	public Card createCard(CardType cardType) {
        CardBehavior behavior = behaviorFactory.getBehavior(cardType);
        return new Card(cardType, behavior);
	}

    // Create a card with a specific behavior
    public Card createCard(CardType cardType, CardBehavior behavior) {
        return new Card(cardType, behavior);
    }

	public Random createRandom() {
		return new SecureRandom();
	}

	public ArrayList<Card> createCardList() {
		return new ArrayList<Card>();
	}
}
