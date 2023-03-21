package org.example;

public enum CardEnum {
    C2("2", 1, 2, "2"),
    C3("3", 2, 3, "3"),
    C4("4", 3, 4, "4"),
    C5("5", 4, 5, "5"),
    C6("6", 5, 6, "6"),
    C7("7", 6, 7, "7"),
    C8("8", 7, 8, "8"),
    C9("9", 8, 9, "9"),
    CT("T", 9, 10, "Ten"),
    CJ("J", 10, 10, "Jack"),
    CQ("Q", 11, 10, "Queen"),
    CK("K", 12, 10, "King"),
    CA("A", 13, 11, "Ace");

    private final String letter;
    private final int order;
    private final int faceValue;
    private final String name;

    CardEnum(String letter, int order, int faceValue, String name) {
        this.letter = letter;
        this.order = order;
        this.faceValue = faceValue;
        this.name = name;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public int getOrder() {
        return order;
    }

    public String getName() { return name; }

    public String toString() {
        return letter;
    }
}
