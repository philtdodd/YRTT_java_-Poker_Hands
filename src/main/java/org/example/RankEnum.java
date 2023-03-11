package org.example;

public enum RankEnum {
    NOTRANKED("Not ranked", 0),
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
    private final Integer rank;

    RankEnum(String name, Integer rank) {
        this.name = name;
        this.rank = rank;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return name;
    }
}
