package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void getSuitLetterClubs() {
        Suit suit = Suit.CLUBS;

        assertEquals("C", suit.getSuitLetter());
    }

    @Test
    void getSuitLetterHearts() {
        Suit suit = Suit.HEARTS;

        assertEquals("H", suit.getSuitLetter());
    }

    @Test
    void getSuitLetterDiamonds() {
        Suit suit = Suit.DIAMONDS;

        assertEquals("D", suit.getSuitLetter());
    }

    @Test
    void getSuitLetterSpades() {
        Suit suit = Suit.SPADES;

        assertEquals("S", suit.getSuitLetter());
    }
}