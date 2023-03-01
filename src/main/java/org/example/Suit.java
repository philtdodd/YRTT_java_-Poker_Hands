package org.example;

public enum Suit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String suitLetter;

    Suit(String suitLetter) {
        this.suitLetter = suitLetter;
    }

    public String toString() {
        return suitLetter;
    }
}