package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void shuffle() {
    }

    @Test
    void testToString() {
        Deck deck = new Deck(1);

        assertEquals(
                "",
                deck.toString()
        );
    }
}