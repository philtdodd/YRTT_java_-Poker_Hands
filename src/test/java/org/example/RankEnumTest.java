package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class RankEnumTest {

    @ParameterizedTest
    @EnumSource(value = RankEnum.class)
    void getRank(RankEnum rankEnum) {
        String expectedName = null;
        int expectedRank = 0;

        switch (rankEnum){
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
                expectedName = "Three of a Kind";
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
                expectedName = "Full House";
            }
            case FOUROFAKIND -> {
                expectedRank = 8;
                expectedName = "Four of a Kind";
            }
            case STRAIGHTFLUSH -> {
                expectedRank = 9;
                expectedName = "Straight Flush";
            }
        }

        assertEquals(expectedRank, rankEnum.getRank());
        assertEquals(expectedName, rankEnum.toString());
    }
}