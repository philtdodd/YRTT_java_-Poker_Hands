package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifiedHandElementTest {

    @Test
    void getCard() {
        SimplifiedHandElement simplifiedHandElement =
                new SimplifiedHandElement(new Card(Suit.CLUBS, CardEnum.CA), 1);

        assertEquals(CardEnum.CA, simplifiedHandElement.getCard());
    }

    @Test
    void getMatches() {
    }

    @Test
    void testToString() {
    }
}