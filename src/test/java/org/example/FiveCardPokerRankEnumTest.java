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
                expectedName = "high card";
            }
            case PAIR -> {
                expectedRank = 2;
                expectedName = "pair";
            }
            case TWOPAIRS -> {
                expectedRank = 3;
                expectedName = "two pairs";
            }
            case THREEOFAKIND -> {
                expectedRank = 4;
                expectedName = "three of a kind";
            }
            case STRAIGHT -> {
                expectedRank = 5;
                expectedName = "straight";
            }
            case FLUSH -> {
                expectedRank = 6;
                expectedName = "flush";
            }
            case FULLHOUSE -> {
                expectedRank = 7;
                expectedName = "full house";
            }
            case FOUROFAKIND -> {
                expectedRank = 8;
                expectedName = "four of a kind";
            }
            case STRAIGHTFLUSH -> {
                expectedRank = 9;
                expectedName = "straight flush";
            }
        }

        assertEquals(expectedRank, fiveCardPokerRankEnum.getRank());
        assertEquals(expectedName, fiveCardPokerRankEnum.toString());
    }
}