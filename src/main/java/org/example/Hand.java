package org.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Hand {
    private final int cards;
    private final String player;
    private LinkedList<Card> hand;

    public Hand(int cards, String player) {
        this.cards = cards;
        this.player = player;
        this.hand = new LinkedList<Card>();
    }

    public void addCard(Card card) {
        if (this.hand.size() == this.cards)
            throw new ArrayStoreException();

        hand.add(card);
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();

        returnString.append(this.player);
        returnString.append(": ");

        for (Card card : this.hand){
            returnString.append(card.toString());
            returnString.append(" ");
        }

        return returnString.toString().trim();
    }

    public void sort() {
         hand.sort(new Comparator<Card>() {
             @Override
             public int compare(Card o1, Card o2) {
                 if (o1.getCard().getOrder() < o2.getCard().getOrder()) return -1;
                 if (o1.getCard().getOrder() > o2.getCard().getOrder()) return 1;
                 return 0;
             }
         });
    }
}
