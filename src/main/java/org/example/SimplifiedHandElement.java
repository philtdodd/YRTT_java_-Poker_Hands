package org.example;

public class SimplifiedHandElement {
    private final CardEnum card;
    private final Integer matches;

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
