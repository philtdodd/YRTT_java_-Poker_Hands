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
        } else if (simplifiedHand.get(0).getMatches() == 4) {
            rank1 = FiveCardPokerRankEnum.FOUROFAKIND;
        } else if (simplifiedHand.get(0).getMatches() == 3 &&
                simplifiedHand.get(1).getMatches() == 2) {
            rank1 = FiveCardPokerRankEnum.FULLHOUSE;
        } else if (isFlush) {
            rank1 = FiveCardPokerRankEnum.FLUSH;
        } else if (isStraight) {
            rank1 = FiveCardPokerRankEnum.STRAIGHT;
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
