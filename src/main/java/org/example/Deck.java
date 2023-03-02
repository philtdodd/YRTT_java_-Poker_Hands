package org.example;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {
    LinkedList<Card> deck;

    static final int CARDSINDECK = 52;

    public Deck(int packs) {
        this.deck = new LinkedList<Card>();

        // Initialise Deck
        int i = 0;
        for (int pack = 0; pack < packs; pack++)
            for (Suit suit : Suit.values())
                for (CardEnum card : CardEnum.values())
                    this.deck.add(new Card(suit, card));
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public String toString() {
        StringBuilder returnValue = new StringBuilder();
        for (Card card : deck) {
            returnValue.append(card.toString());
            returnValue.append(" ");
        }

        return returnValue.toString().trim();
    }

    // methods to get a card from the top or bottom of the deck go here.
}
