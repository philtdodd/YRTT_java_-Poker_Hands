package org.example;

public enum RankEnum {
    HIGHCARD("High Card", 1),
    PAIR("Pair", 2),
    TWOPAIRS("Two Pairs", 3),
    THREEOFAKIND("Three of a kind", 4),
    STRAIGHT("Straight", 5),
    FLUSH("Flush", 6),
    FULLHOUSE("Full house", 7),
    FOUROFAKIND("Four of a kind", 8),
    STRAIGHTFLUSH("Straight flush", 9);

    private final String name;
    private final int rank;

    RankEnum(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return name;
    }
}
