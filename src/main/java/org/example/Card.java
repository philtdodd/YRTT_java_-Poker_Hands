package org.example;

public class Card {
    private final Suit suit;
    private final CardEnum card;

    public Card(Suit suit, CardEnum card) {
        this.suit = suit;
        this.card = card;
    }

    public Card(String card) {
        this.suit = Suit.valueOf(card.substring(0,0));
        this.card = CardEnum.valueOf(card.substring(1,1));
    }

    public Suit getSuit() {
        return suit;
    }

    public CardEnum getCardEnum() {
        return card;
    }

    public String getCardLetter() {
        return card.toString();
    }

    public int getCardOrder() {
        return card.getOrder();
    }
    public int getCardValue() {
        return card.getFaceValue();
    }


    @Override
    public String toString() {
        return card.toString() + suit.toString();
    }
}
