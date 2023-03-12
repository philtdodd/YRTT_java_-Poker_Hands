package org.example;

public class SimplifiedHandElement {
    private CardEnum card;
    private Integer matches;

    public SimplifiedHandElement(CardEnum card, Integer matches) {
        this.card = card;
        this.matches = matches;
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
