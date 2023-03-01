package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void getSuitLetterClubs() {
        Suit suit = Suit.CLUBS;

        assertEquals("C", suit.toString());
    }

    @Test
    void getSuitLetterHearts() {
        Suit suit = Suit.HEARTS;

        assertEquals("H", suit.toString());
    }

    @Test
    void getSuitLetterDiamonds() {
        Suit suit = Suit.DIAMONDS;

        assertEquals("D", suit.toString());
    }

    @Test
    void getSuitLetterSpades() {
        Suit suit = Suit.SPADES;

        assertEquals("S", suit.toString());
    }
}