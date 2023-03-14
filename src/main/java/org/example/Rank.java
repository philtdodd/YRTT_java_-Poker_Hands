package org.example;

import java.util.ArrayList;

public class Rank {
    private final RankEnum rank;
    private final ArrayList<Integer> nextHighest;

    public Rank() {
        this.rank = RankEnum.NOTRANKED;
        this.nextHighest = new ArrayList<Integer>();
    }

    public String getRankName() {
        return this.rank.toString();
    }

    public int getRank() {
        return this.rank.getRank();
    }

    public void RankHand(Hand hand) {

    }
}
