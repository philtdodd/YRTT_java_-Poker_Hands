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
    void matchingCards() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<Card> result = hand.matchingCards(2);

        assertEquals(1, result.size());
    }
}
