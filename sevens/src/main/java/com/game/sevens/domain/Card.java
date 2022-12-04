package com.game.sevens.domain;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
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
}
