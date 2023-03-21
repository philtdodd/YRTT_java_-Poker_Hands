package org.example;

import java.util.ArrayList;

public class FiveCardPokerRank {
    private final FiveCardPokerRankEnum rank;

    private final ArrayList<SimplifiedHandElement> simplifiedHand;

    public boolean isStraight() {
        return isStraight;
    }

    public boolean isFlush() {
        return isFlush;
    }

    private final boolean isStraight;
    private final boolean isFlush;

    public FiveCardPokerRank(Hand hand) {
        FiveCardPokerRankEnum rank1;

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
        } else if (simplifiedHand.get(0).getMatches() == 3) {
            rank1 = FiveCardPokerRankEnum.THREEOFAKIND;
        } else if (simplifiedHand.get(0).getMatches() == 2 &&
                simplifiedHand.get(1).getMatches() == 2) {
            rank1 = FiveCardPokerRankEnum.TWOPAIRS;
        } else if (simplifiedHand.get(0).getMatches() == 2) {
            rank1 = FiveCardPokerRankEnum.PAIR;
        } else {
            rank1 = FiveCardPokerRankEnum.HIGHCARD;
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

    public ArrayList<SimplifiedHandElement> getSimplifiedHand() {
        return simplifiedHand;
    }

    public int compareRank(FiveCardPokerRank rank) {
        if (this.getRankValue() == rank.getRankValue()) {
            // check other cards
            ArrayList<SimplifiedHandElement> rankElements = rank.getSimplifiedHand();

            for (int i = 0; i < this.simplifiedHand.size() && i < rankElements.size(); i++) {
                if (this.simplifiedHand.get(i).getCard().getOrder() > rankElements.get(i).getCard().getOrder())
                    return 1;
                else if (this.simplifiedHand.get(i).getCard().getOrder() < rankElements.get(i).getCard().getOrder())
                    return -1;
            }

            return 0;
        } else if (this.getRankValue() > rank.getRankValue())
            return 1;
        else
            return -1;
    }

    public String getDescription() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(rank.toString());
        stringBuilder.append(": ");
        switch (rank.getCountToReport()) {
            case 2 -> stringBuilder.append(simplifiedHand.get(0).getCard().getName() + " over " +
                    simplifiedHand.get(1).getCard().getName());
            case 1 -> stringBuilder.append(simplifiedHand.get(0).getCard().getName());
            case 0 -> stringBuilder.append(simplifiedHand.get(0).getSuit());
        }

        return stringBuilder.toString();
    }
}
