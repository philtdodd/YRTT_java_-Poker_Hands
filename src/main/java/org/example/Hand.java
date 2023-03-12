package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Hand {
    private final int cards;
    private final String player;
    private final LinkedList<Card> hand;

    public Hand(int cards, String player) {
        this.cards = cards;
        this.player = player;
        this.hand = new LinkedList<>();
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

        for (Card card : this.hand) {
            returnString.append(card.toString());
            returnString.append(" ");
        }

        return returnString.toString().trim();
    }

    public void sortLowHigh() {
        hand.sort(new Comparator<>() {
            @Override
            public int compare(Card o1, Card o2) {
                return Integer.compare(o1.getCardEnum().getOrder(), o2.getCardEnum().getOrder());
            }
        });
    }

    public void sortHighLow() {
        hand.sort(new Comparator<>() {
            @Override
            public int compare(Card o1, Card o2) {
                return Integer.compare(o2.getCardEnum().getOrder(), o1.getCardEnum().getOrder());
            }
        });
    }

    public ArrayList<SimplifiedHandElement> simplifiedHand() {
        ArrayList<SimplifiedHandElement> simplifiedHand = new ArrayList<>();
        int lastCardOrder = -1;
        int matchCount = 1;

        this.sortHighLow();

        for (Card card : hand) {
            if (lastCardOrder == card.getCardOrder()) {
                matchCount++;
            } else {
                simplifiedHand.add(new SimplifiedHandElement(card.getCardEnum(), matchCount));
                matchCount = 1;
            }
            lastCardOrder = card.getCardOrder();
        }

        //TBC Sort Results

        return simplifiedHand;
    }


}
