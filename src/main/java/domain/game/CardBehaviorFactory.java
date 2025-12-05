package domain.game;

import java.util.HashMap;
import java.util.Map;

public class CardBehaviorFactory {
    private final Map<CardType, CardBehavior> behaviors;

    public CardBehaviorFactory() {
        this.behaviors = new HashMap<>();
        registerDefaultBehaviors();
    }

    public void registerBehavior(CardType cardType, CardBehavior behavior) {
        behaviors.put(cardType, behavior);
    }

    public CardBehavior getBehavior(CardType cardType) {
        // Returns null if no registered behavior exists for the cardType: this is expected behavior
        return behaviors.get(cardType);
    }

    private void registerDefaultBehaviors() {
        registerBehavior(CardType.EXPLODING_KITTEN, new ExplodingKittenBehavior());
        registerBehavior(CardType.NOPE, new NopeBehavior());
        registerBehavior(CardType.SHUFFLE, new ShuffleBehavior());
        registerBehavior(CardType.DEFUSE, new DefuseBehavior());
    }
}