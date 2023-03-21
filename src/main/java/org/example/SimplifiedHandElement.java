package org.example;

public class SimplifiedHandElement {
    private final CardEnum card;
    private final Integer matches;

    private final Suit suit;

    public SimplifiedHandElement(CardEnum card, Integer matches, Suit suit) {
        this.card = card;
        this.matches = matches;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardEnum getCard() {
        return card;
    }

    public Integer getMatches() {
        return matches;
    }

    @Override
    public String toString() {
        return card + " " + matches + 'x';
    }
}
