package org.example;

import java.util.ArrayList;

public class FiveCardPokerRank {
    private final FiveCardPokerRankEnum rank;
    private final ArrayList<Integer> nextHighest;

    private final ArrayList<SimplifiedHandElement> simplifiedHand;

    private final boolean isStraight;
    private final boolean isFlush;

    public FiveCardPokerRank(Hand hand) {
        FiveCardPokerRankEnum rank1;
        rank1 = FiveCardPokerRankEnum.NOTRANKED;
        this.nextHighest = new ArrayList<Integer>();
        this.isStraight = hand.isStraight();
        this.isFlush = hand.isSingleSuit();
        this.simplifiedHand = hand.simplifiedHand();

        if (isFlush && isStraight) {
            rank1 = FiveCardPokerRankEnum.STRAIGHTFLUSH;
        }

        this.rank = rank1;
    }

    public String getRankName() {
        return this.rank.toString();
    }

    public int getRankValue() {
        return this.rank.getRank();
    }

    public FiveCardPokerRankEnum getRank() {
        return this.rank;
    }
}
