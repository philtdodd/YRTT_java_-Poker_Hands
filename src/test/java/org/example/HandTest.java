package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void add1Card() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));

        assertEquals("White: AC", hand.toString());
    }

    @Test
    void add2Cards() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));

        assertEquals("White: AC AH", hand.toString());
    }

    @Test
    void add3Cards() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));

        assertEquals("White: AC AH 3H", hand.toString());
    }

    @Test
    void add4Cards() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        assertEquals("White: AC AH 3H 5S", hand.toString());
    }

    @Test
    void add5Cards() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.DIAMONDS, CardEnum.CJ));

        assertEquals("White: AC AH 3H 5S JD", hand.toString());
    }

    @Test
    void add5CardsSorted() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CK));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.DIAMONDS, CardEnum.CJ));

        hand.sort();

        assertEquals("White: 3H 5S JD KC AH", hand.toString());
    }

    @Test
    void add6Cards() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.DIAMONDS, CardEnum.CJ));

        assertThrowsExactly(ArrayStoreException.class, () -> {
            hand.addCard(new Card(Suit.DIAMONDS, CardEnum.CJ));
        });
    }

    @Test
    void matchingPairsSinglePair() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C6));

        ArrayList<Card> result = hand.matchingCards(2);

        assertEquals(1, result.size());
        assertEquals(11, result.get(0).getCardValue());
    }

    @Test
    void matchingPairsTwoPairs() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<Card> result = hand.matchingCards(2);

        assertEquals(2, result.size());
        assertEquals(11, result.get(0).getCardValue());
        assertEquals(5, result.get(1).getCardValue());
    }

    @Test
    void matchingPairsThreePairs() {
        Hand hand = new Hand(6, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<Card> result = hand.matchingCards(2);

        assertEquals(3, result.size());
        assertEquals(11, result.get(0).getCardValue());
        assertEquals(5, result.get(1).getCardValue());
        assertEquals(3, result.get(2).getCardValue());
    }

    @Test
    void matchingPairsNoPairs() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CJ));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C6));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<Card> result = hand.matchingCards(2);

        assertEquals(0, result.size());
    }

    @Test
    void matchingTriplesOneTriple() {
        Hand hand = new Hand(6, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<Card> result = hand.matchingCards(3);

        assertEquals(1, result.size());
        assertEquals(11, result.get(0).getCardValue());
    }
}
