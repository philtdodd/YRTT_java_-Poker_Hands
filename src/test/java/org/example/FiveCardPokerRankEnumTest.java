package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class FiveCardPokerRankEnumTest {

    @ParameterizedTest
    @EnumSource(value = FiveCardPokerRankEnum.class)
    void getRank(FiveCardPokerRankEnum fiveCardPokerRankEnum) {
        String expectedName = null;
        Integer expectedRank = 0;

        switch (fiveCardPokerRankEnum){
            case NOTRANKED -> {
                expectedRank = 0;
                expectedName = "Not ranked";
            }
            case HIGHCARD -> {
                expectedRank = 1;
                expectedName = "High Card";
            }
            case PAIR -> {
                expectedRank = 2;
                expectedName = "Pair";
            }
            case TWOPAIRS -> {
                expectedRank = 3;
                expectedName = "Two Pairs";
            }
            case THREEOFAKIND -> {
                expectedRank = 4;
                expectedName = "Three of a kind";
            }
            case STRAIGHT -> {
                expectedRank = 5;
                expectedName = "Straight";
            }
            case FLUSH -> {
                expectedRank = 6;
                expectedName = "Flush";
            }
            case FULLHOUSE -> {
                expectedRank = 7;
                expectedName = "Full house";
            }
            case FOUROFAKIND -> {
                expectedRank = 8;
                expectedName = "Four of a kind";
            }
            case STRAIGHTFLUSH -> {
                expectedRank = 9;
                expectedName = "Straight flush";
            }
        }

        assertEquals(expectedRank, fiveCardPokerRankEnum.getRank());
        assertEquals(expectedName, fiveCardPokerRankEnum.toString());
    }
}