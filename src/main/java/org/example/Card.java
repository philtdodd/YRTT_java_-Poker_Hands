package org.example;

public class Card {
    Suit suit;
    CardEnum card;

    public Card(Suit suit, CardEnum card) {
        this.suit = suit;
        this.card = card;
    }

    @Override
    public String toString() {
        return card.toString() + suit.toString();
    }
}
