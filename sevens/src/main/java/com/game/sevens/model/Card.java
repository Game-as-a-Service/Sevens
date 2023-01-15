package com.game.sevens.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Card {

    private String rank;
    private String suit;

    public Card() {

    }


    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }


    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
