package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void getRankName() {
        Rank rank = new Rank();

        assertEquals("Not ranked", rank.getRankName());
        assertEquals(0, rank.getRank());
    }
}