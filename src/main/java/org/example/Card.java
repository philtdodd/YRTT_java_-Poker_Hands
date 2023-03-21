package org.example;

public class Card {
    private final Suit suit;
    private final CardEnum card;

    public Card(Suit suit, CardEnum card) {
        this.suit = suit;
        this.card = card;
    }

    public Card(String card) {
        this.card = CardEnum.valueOf("C" + card.charAt(0));
        switch (card.substring(1, 2)) {
            case "C" -> this.suit = Suit.CLUBS;
            case "D" -> this.suit = Suit.DIAMONDS;
            case "H" -> this.suit = Suit.HEARTS;
            case "S" -> this.suit = Suit.SPADES;
            default -> this.suit = Suit.CLUBS;
        }
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

    public String getCardName() {
        return card.getName();
    }

    @Override
    public String toString() {
        return card.toString() + suit.toString();
    }
}
