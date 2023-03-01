package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testToString() {
        Card card = new Card(Suit.CLUBS, CardEnum.CA);

        assertEquals("AC", card.toString());
    }
}