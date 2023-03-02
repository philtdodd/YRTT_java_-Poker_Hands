package org.example;

public class Card {
    Suit suit;
    CardEnum card;

    public Card(Suit suit, CardEnum card) {
        this.suit = suit;
        this.card = card;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardEnum getCard() {
        return card;
    }

    @Override
    public String toString() {
        return card.toString() + suit.toString();
    }
}
