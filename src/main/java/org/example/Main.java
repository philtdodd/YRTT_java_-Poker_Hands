package org.example;

import java.util.Scanner;

public class Main {
  /* Example Input
   *     Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH
   *     Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S
   *     Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH
   *     Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH
   */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String twoHands = in.nextLine();

            String[] hands = twoHands.split("  ");

            Hand hand1 = new Hand(hands[0].trim());
            Hand hand2 = new Hand(hands[1].trim());

            FiveCardPokerRank rank1 = new FiveCardPokerRank(hand1);
            FiveCardPokerRank rank2 = new FiveCardPokerRank(hand2);

            int result = rank1.compareRank(rank2);

            switch (result) {
                case -1: // hand2 wins
                    System.out.println(hand2.getPlayer() + " wins. - with " + rank2.getDescription());
                    break;
                case 0: // tie
                    System.out.println("Tie.");
                    break;
                case 1: // hand1 wins
                    System.out.println(hand1.getPlayer() + " wins. - with " + rank1.getDescription());
                    break;
            }
        }
    }
}