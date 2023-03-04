package com.game.sevens.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalCard implements Comparable<LocalCard>{
    private Rank rank;
    private Suit suit;

    public LocalCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public LocalCard(String rank, String suit){
        this.rank = Enum.valueOf(Rank.class, rank);
        this.suit = Enum.valueOf(Suit.class, rank);
    }

    @Override
    public String toString() {
        if (suit.toString().equals("TWO")){
            return "" + rank +
                    "[" + "2" + "]" +
                    "";
        }
        else if (suit.toString().equals("THREE")){
            return "" + rank +
                    "[" + "3" + "]" +
                    "";
        }
        else if (suit.toString().equals("FOUR")){
            return "" + rank +
                    "[" + "4" + "]" +
                    "";
        }
        else if (suit.toString().equals("FIVE")){
            return "" + rank +
                    "[" + "5" + "]" +
                    "";
        }
        else if (suit.toString().equals("SIX")){
            return "" + rank +
                    "[" + "6" + "]" +
                    "";
        }
        else if (suit.toString().equals("SEVEN")){
            return "" + rank +
                    "[" + "7" + "]" +
                    "";
        }
        else if (suit.toString().equals("EIGHT")){
            return "" + rank +
                    "[" + "8" + "]" +
                    "";
        }
        else if (suit.toString().equals("NINE")){
            return "" + rank +
                    "[" + "9" + "]" +
                    "";
        }
        else if (suit.toString().equals("TEN")){
            return "" + rank +
                    "[" + "10" + "]" +
                    "";
        }

        return "" + rank +
                "[" + suit + "]" +
                "";
    }

    @Override
    public int compareTo(LocalCard o) {

        if (this.suit.ordinal() > o.getSuit().ordinal()) {
            return 0;
        } else if (this.suit.ordinal() == o.getSuit().ordinal()) {
            if (this.rank.ordinal() > o.getRank().ordinal()) {
                return 0;
            }
            return -1;
        }
        return -1;
    }
}
