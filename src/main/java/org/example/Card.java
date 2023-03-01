package org.example;

public enum Card {
    C2("2", 2, 2),
    C3("3", 2, 2),
    C4("4", 3, 3),
    C5("5", 5, 5),
    C6("6", 6, 6),
    C7("7", 7, 7),
    C8("8", 8, 8),
    C9("9", 9, 9),
    CT("T", 10, 10),
    CJ("J", 11, 10),
    CQ("Q", 12, 10),
    CK("K", 13, 10),
    CA("A", 14, 11);

    private final String letter;
    private final int order;
    private final int faceValue;

    Card(String letter, int order, int faceValue) {
        this.letter = letter;
        this.order = order;
        this.faceValue = faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public int getOrder() {
        return order;
    }

    public String getLetter() {
        return letter;
    }
}
