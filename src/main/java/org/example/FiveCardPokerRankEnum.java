package org.example;

public enum FiveCardPokerRankEnum {
    NOTRANKED("Not ranked", 0, 0),
    HIGHCARD("high card", 1, 1),
    PAIR("pair", 2, 1),
    TWOPAIRS("two pairs", 3, 2),
    THREEOFAKIND("three of a kind", 4, 1),
    STRAIGHT("straight", 5, 5),
    FLUSH("flush", 6, 0),
    FULLHOUSE("full house", 7, 2),
    FOUROFAKIND("four of a kind", 8, 1),
    STRAIGHTFLUSH("straight flush", 9, -5);

    private final String name;

    private final Integer rank;
    private final Integer countToReport;

    FiveCardPokerRankEnum(String name, Integer rank, Integer countToReport) {
        this.name = name;
        this.rank = rank;
        this.countToReport = countToReport;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getCountToReport() {
        return countToReport;
    }

    @Override
    public String toString() {
        return name;
    }
}
