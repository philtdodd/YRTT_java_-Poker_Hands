package org.example;

public class SimplifiedHandElement {
    private Card card;
    private Integer matches;

    public SimplifiedHandElement(Card card, Integer matches) {
        this.card = card;
        this.matches = matches;
    }

    public Card getCard() {
        return card;
    }

    public Integer getMatches() {
        return matches;
    }

    @Override
    public String toString() {
        return card.getCardLetter() +
                " " + matches +
                'x';
    }
}
