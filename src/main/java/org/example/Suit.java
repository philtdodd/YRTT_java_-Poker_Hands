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

    String getSuitLetter() {
        return suitLetter;
    }
}