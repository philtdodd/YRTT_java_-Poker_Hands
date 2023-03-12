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
    void add5CardsSortedLowHigh() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CK));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.DIAMONDS, CardEnum.CJ));

        hand.sortLowHigh();

        assertEquals("White: 3H 5S JD KC AH", hand.toString());
    }

    @Test
    void add5CardsSortedHighLow() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CK));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.DIAMONDS, CardEnum.CJ));

        hand.sortHighLow();

        assertEquals("White: AH KC JD 5S 3H", hand.toString());
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
    void simplifiedHandSinglePair() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C6));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(4, result.size());
        assertEquals(11, result.get(0).getCard().getFaceValue());
        assertEquals(2, result.get(0).getMatches());
        assertEquals(6, result.get(1).getCard().getFaceValue());
        assertEquals(1, result.get(1).getMatches());
        assertEquals(5, result.get(2).getCard().getFaceValue());
        assertEquals(1, result.get(2).getMatches());
        assertEquals(3, result.get(3).getCard().getFaceValue());
        assertEquals(1, result.get(3).getMatches());
    }

    @Test
    void simplifyHandTwoPairs() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(3, result.size());
        assertEquals(11, result.get(0).getCard().getFaceValue());
        assertEquals(2, result.get(0).getMatches());
        assertEquals(5, result.get(0).getCard().getFaceValue());
        assertEquals(2, result.get(0).getMatches());
        assertEquals(3, result.get(0).getCard().getFaceValue());
        assertEquals(1, result.get(0).getMatches());
    }

    @Test
    void simplifyHandThreePairs() {
        Hand hand = new Hand(6, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(3, result.size());
        assertEquals(11, result.get(0).getCard().getFaceValue());
        assertEquals(2, result.get(0).getMatches());
        assertEquals(5, result.get(1).getCard().getFaceValue());
        assertEquals(2, result.get(1).getMatches());
        assertEquals(3, result.get(2).getCard().getFaceValue());
        assertEquals(2, result.get(2).getMatches());
    }

    @Test
    void simplifyHandNoPairs() {
        Hand hand = new Hand(5, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CJ));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C6));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(5, result.size());
        assertEquals(11, result.get(0).getCard().getFaceValue());
        assertEquals(1, result.get(0).getMatches());
        assertEquals(10, result.get(1).getCard().getFaceValue());
        assertEquals(1, result.get(1).getMatches());
        assertEquals(6, result.get(2).getCard().getFaceValue());
        assertEquals(1, result.get(2).getMatches());
        assertEquals(5, result.get(3).getCard().getFaceValue());
        assertEquals(1, result.get(3).getMatches());
        assertEquals(3, result.get(3).getCard().getFaceValue());
        assertEquals(1, result.get(3).getMatches());
    }

    @Test
    void simplifyHandOneTriple() {
        Hand hand = new Hand(6, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(3, result.size());
        assertEquals(11, result.get(0).getCard().getFaceValue());
        assertEquals(3, result.get(0).getMatches());
        assertEquals(5, result.get(1).getCard().getFaceValue());
        assertEquals(2, result.get(1).getMatches());
        assertEquals(3, result.get(2).getCard().getFaceValue());
        assertEquals(1, result.get(2).getMatches());
    }

    @Test
    void simplifyHandTwoTriple() {
        Hand hand = new Hand(6, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(2, result.size());
        assertEquals(11, result.get(0).getCard().getFaceValue());
        assertEquals(3, result.get(0).getMatches());
        assertEquals(5, result.get(1).getCard().getFaceValue());
        assertEquals(3, result.get(1).getMatches());
    }

    @Test
    void simplifyHandFourOfAKindSingle() {
        Hand hand = new Hand(8, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C3));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(3, result.size());
        assertEquals(5, result.get(0).getCard().getFaceValue());
        assertEquals(4, result.get(0).getMatches());
        assertEquals(11, result.get(1).getCard().getFaceValue());
        assertEquals(3, result.get(1).getMatches());
        assertEquals(5, result.get(2).getCard().getFaceValue());
        assertEquals(1, result.get(2).getMatches());
    }

    @Test
    void simplifyHandFourOfAKindDouble() {
        Hand hand = new Hand(8, "White");

        hand.addCard(new Card(Suit.CLUBS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.CA));
        hand.addCard(new Card(Suit.HEARTS, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));
        hand.addCard(new Card(Suit.SPADES, CardEnum.CA));
        hand.addCard(new Card(Suit.SPADES, CardEnum.C5));

        ArrayList<SimplifiedHandElement> result = hand.simplifiedHand();

        assertEquals(2, result.size());
        assertEquals(11, result.get(0).getCard().getFaceValue());
        assertEquals(4, result.get(0).getMatches());
        assertEquals(5, result.get(1).getCard().getFaceValue());
        assertEquals(4, result.get(1).getMatches());
    }
}
