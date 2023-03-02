package org.example;

public enum CardEnum {
    C2("2", 1, 2),
    C3("3", 2, 3),
    C4("4", 3, 4),
    C5("5", 4, 5),
    C6("6", 5, 6),
    C7("7", 6, 7),
    C8("8", 7, 8),
    C9("9", 8, 9),
    CT("T", 9, 10),
    CJ("J", 10, 10),
    CQ("Q", 11, 10),
    CK("K", 12, 10),
    CA("A", 13, 11);

    private final String letter;
    private final int order;
    private final int faceValue;

    CardEnum(String letter, int order, int faceValue) {
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

    public String toString() {
        return letter;
    }
}
