package com.game.sevens.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Map<Suit, List<Card>> field = new HashMap<>();
    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();

    public Game() {
        for (Suit suit : Suit.values()) {
            field.put(suit,new ArrayList<>());
        }
    }

    public void startGame(){

    }
    public boolean shownCardIsLegal(Card card) {
        //find same suit line
        List<Card> line = field.get(card.getSuit());
        //check if previous or next rank
        if (card.getRank().toString().equals("SEVEN")){
            return true;
        }
        else if (line.get(0).getRank().ordinal() - card.getRank().ordinal() == 1){
            return true;
        }
        else if (card.getRank().ordinal() - line.get(line.size()-1).getRank().ordinal()== 1){
            return true;
        }
        return false;
    }

    public void addCardToField(Card card) {
        //find same suit line
        List<Card> line = field.get(card.getSuit());
        if (card.getRank().toString().equals("SEVEN")){
            line.add(card);
        }
        else if (line.get(0).getRank().ordinal() - card.getRank().ordinal() == 1){
            line.add(0,card);
        }
        else if (card.getRank().ordinal() - line.get(line.size()-1).getRank().ordinal()== 1){
            line.add(card);
        }

    }

    public void showField(){
        for (Suit suit: Suit.values()){
            for (Card card: field.get(suit)){
                System.out.print(card.toString());
            }
            System.out.println();
        }
    }
}
