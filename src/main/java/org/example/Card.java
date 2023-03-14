package org.example;

public class Card {
    private final Suit suit;
    private final CardEnum card;

    public Card(Suit suit, CardEnum card) {
        this.suit = suit;
        this.card = card;
    }

    public Card(String card) {
        this.card = CardEnum.valueOf("C" + card.substring(0, 1));
        switch (card.substring(1, 2)) {
            case "C":
                this.suit = Suit.CLUBS;
                break;
            case "D":
                this.suit = Suit.DIAMONDS;
                break;
            case "H":
                this.suit = Suit.HEARTS;
                break;
            case "S":
                this.suit = Suit.SPADES;
                break;
            default:
                this.suit = Suit.CLUBS;
                break;
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


    @Override
    public String toString() {
        return card.toString() + suit.toString();
    }
}
