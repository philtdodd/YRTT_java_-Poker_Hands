package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardEnumTest {
    @ParameterizedTest
    @EnumSource(value = CardEnum.class)
    void valueOfCard(CardEnum cardEnum) {
        String expectedLetter = null;
        int expectedOrder = 0;
        int expectedFaceValue = 0;
        String expectedName = null;

        switch (cardEnum) {
            case C2 -> {
                expectedLetter = "2";
                expectedFaceValue = 2;
                expectedOrder = 1;
                expectedName = "2";
            }
            case C3 -> {
                expectedLetter = "3";
                expectedFaceValue = 3;
                expectedOrder = 2;
                expectedName = "3";
            }
            case C4 -> {
                expectedLetter = "4";
                expectedFaceValue = 4;
                expectedOrder = 3;
                expectedName = "4";
            }
            case C5 -> {
                expectedLetter = "5";
                expectedFaceValue = 5;
                expectedOrder = 4;
                expectedName = "5";
            }
            case C6 -> {
                expectedLetter = "6";
                expectedFaceValue = 6;
                expectedOrder = 5;
                expectedName = "6";
            }
            case C7 -> {
                expectedLetter = "7";
                expectedFaceValue = 7;
                expectedOrder = 6;
                expectedName = "7";
            }
            case C8 -> {
                expectedLetter = "8";
                expectedFaceValue = 8;
                expectedOrder = 7;
                expectedName = "8";
            }
            case C9 -> {
                expectedLetter = "9";
                expectedFaceValue = 9;
                expectedOrder = 8;
                expectedName = "9";
            }
            case CT -> {
                expectedLetter = "T";
                expectedFaceValue = 10;
                expectedOrder = 9;
                expectedName = "Ten";
            }
            case CJ -> {
                expectedLetter = "J";
                expectedFaceValue = 10;
                expectedOrder = 10;
                expectedName = "Jack";
            }
            case CQ -> {
                expectedLetter = "Q";
                expectedFaceValue = 10;
                expectedOrder = 11;
                expectedName = "Queen";
            }
            case CK -> {
                expectedLetter = "K";
                expectedFaceValue = 10;
                expectedOrder = 12;
                expectedName = "King";
            }
            case CA -> {
                expectedLetter = "A";
                expectedFaceValue = 11;
                expectedOrder = 13;
                expectedName = "Ace";
            }
        }

        assertEquals(expectedLetter, cardEnum.toString());
        assertEquals(expectedFaceValue, cardEnum.getFaceValue());
        assertEquals(expectedOrder, cardEnum.getOrder());
        assertEquals(expectedName, cardEnum.getName());
    }
}