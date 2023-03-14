package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiveCardPokerRankTest {

    @Test
    void getRankName() {
        Hand hand = new Hand("Player: 2C 3D 4H KS 7H");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals("High card", fiveCardPokerRank.getRankName());
        assertEquals(1, fiveCardPokerRank.getRankValue());
    }

    @Test
    void rankHandHighCard() {
        Hand hand = new Hand("Player: 2C 8D 4H KS 3H");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.HIGHCARD, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandPair() {
        Hand hand = new Hand("Player: 2C 2D 4H KS 3H");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.PAIR, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandTwoPairs() {
        Hand hand = new Hand("Player: 2C 3D 3H 2S 4H");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.TWOPAIRS, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandThreeOfAKind() {
        Hand hand = new Hand("Player: 2C 3D 3H 4S 3H");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.THREEOFAKIND, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandStraight() {
        Hand hand = new Hand("Player: 7C 8D 9H TS JH");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.STRAIGHT, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandFlush() {
        Hand hand = new Hand("Player: 7C QC KC AC 2C");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.FLUSH, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandFullHouse() {
        Hand hand = new Hand("Player: 7C QD 7H QS 7H");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.FULLHOUSE, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandFourOfAKind() {
        Hand hand = new Hand("Player: 7C 7D 7H QS 7H");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.FOUROFAKIND, fiveCardPokerRank.getRank());
    }

    @Test
    void rankHandStraightFlush() {
        Hand hand = new Hand("Player: 9C TC JC QC KC");
        FiveCardPokerRank fiveCardPokerRank = new FiveCardPokerRank(hand);

        assertEquals(FiveCardPokerRankEnum.STRAIGHTFLUSH, fiveCardPokerRank.getRank());
    }

    @Test
    void compareRankSame() {
        Hand hand1 = new Hand("Player1: 9C TC JC QC KC");
        Hand hand2 = new Hand("Player2: 9C TC JC QC KC");

        FiveCardPokerRank rank1 = new FiveCardPokerRank(hand1);
        FiveCardPokerRank rank2 = new FiveCardPokerRank(hand2);

        assertEquals(0, rank1.compareRank(rank2));
    }
}