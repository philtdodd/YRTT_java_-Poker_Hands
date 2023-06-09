package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import static java.util.Comparator.*;

public class Hand {
    private final int cards;
    private final String player;
    private final LinkedList<Card> hand;

    public Hand(int cards, String player) {
        this.cards = cards;
        this.player = player;
        this.hand = new LinkedList<>();
    }

    public Card getCard(int cardNumber) {
        return hand.get(cardNumber);
    }

    public String getPlayer() {
        return player;
    }

    public Hand(String hand) {
        hand = hand.replaceAll("[ ]{2,2}", " ");
        String[] items = hand.split(" ");

        this.cards = items.length - 1;
        this.player = items[0].replace(":", "");
        this.hand = new LinkedList<>();

        //TBC Add cards to hand
        for (int i = 1; i < items.length; i++) {
            addCard(new Card(items[i]));
        }
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
        hand.sort(comparingInt(o -> o.getCardEnum().getOrder()));
    }

    public void sortHighLow() {
        hand.sort((o1, o2) -> Integer.compare(o2.getCardEnum().getOrder(), o1.getCardEnum().getOrder()));
    }

    public ArrayList<SimplifiedHandElement> simplifiedHand() {
        ArrayList<SimplifiedHandElement> simplifiedHand = new ArrayList<>();
        Card lastCard = null;
        int matchCount = 1;

        this.sortHighLow();

        for (Card card : hand) {
            if (lastCard != null && lastCard.getCardOrder() == card.getCardOrder()) {
                matchCount++;
            } else if (lastCard != null) {
                simplifiedHand.add(new SimplifiedHandElement(lastCard.getCardEnum(), matchCount, lastCard.getSuit()));
                matchCount = 1;
            }
            lastCard = card;
        }

        if (lastCard != null)
            simplifiedHand.add(new SimplifiedHandElement(lastCard.getCardEnum(), matchCount, lastCard.getSuit()));

        //TBC Sort Results
        simplifiedHand.sort(comparing(SimplifiedHandElement::getMatches)
                .thenComparing(SimplifiedHandElement::getCard));

        Collections.reverse(simplifiedHand);

        return simplifiedHand;
    }

    public boolean isSingleSuit() {
        Suit lastSuit = hand.get(0).getSuit();

        for (Card card : hand) {
            if (!lastSuit.equals(card.getSuit()))
                return false;
        }

        return true;
    }

    public boolean isStraight() {
        this.sortLowHigh();

        Integer lastOrder = hand.get(0).getCardOrder() - 1;

        for (Card card : hand) {
            if (!lastOrder.equals(card.getCardOrder() - 1))
                return false;

            lastOrder = card.getCardOrder();
        }

        return true;
    }
}
