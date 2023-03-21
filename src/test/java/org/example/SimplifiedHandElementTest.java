package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifiedHandElementTest {

    @Test
    void getCard() {
        SimplifiedHandElement simplifiedHandElement =
                new SimplifiedHandElement(CardEnum.CA, 1, Suit.CLUBS);

        assertEquals(CardEnum.CA, simplifiedHandElement.getCard());
    }

    @Test
    void getMatches() {
        SimplifiedHandElement simplifiedHandElement =
                new SimplifiedHandElement(CardEnum.CA, 1, Suit.CLUBS);

        assertEquals(1, simplifiedHandElement.getMatches());
    }

    @Test
    void testToString() {
        SimplifiedHandElement simplifiedHandElement =
                new SimplifiedHandElement(CardEnum.CA, 1, Suit.CLUBS);

        assertEquals("A 1x", simplifiedHandElement.toString());
    }

    @Test
    void testToString3xJ() {
        SimplifiedHandElement simplifiedHandElement =
                new SimplifiedHandElement(CardEnum.CJ, 3, Suit.CLUBS);

        assertEquals("J 3x", simplifiedHandElement.toString());
    }
}