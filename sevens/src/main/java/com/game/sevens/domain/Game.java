package com.game.sevens.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private Map<Suit, List<LocalCard>> field = new HashMap<>();
    private List<LocalPlayer> localPlayers = new ArrayList<>();
    private Deck deck = new Deck();

    public Game() {
        for (Suit suit : Suit.values()) {
            field.put(suit,new ArrayList<>());
        }
    }

    public void startGame(){

    }
    public boolean shownCardIsLegal(LocalCard localCard) {
        //find same suit line
        List<LocalCard> line = field.get(localCard.getSuit());
        //check if previous or next rank
        if (localCard.getRank().toString().equals("SEVEN")){
            return true;
        }
        else if (line.get(0).getRank().ordinal() - localCard.getRank().ordinal() == 1){
            return true;
        }
        else if (localCard.getRank().ordinal() - line.get(line.size()-1).getRank().ordinal()== 1){
            return true;
        }
        return false;
    }

    public void addCardToField(LocalCard localCard) {
        //find same suit line
        List<LocalCard> line = field.get(localCard.getSuit());
        if (localCard.getRank().toString().equals("SEVEN")){
            line.add(localCard);
        }
        else if (line.get(0).getRank().ordinal() - localCard.getRank().ordinal() == 1){
            line.add(0, localCard);
        }
        else if (localCard.getRank().ordinal() - line.get(line.size()-1).getRank().ordinal()== 1){
            line.add(localCard);
        }

    }

    public void showField(){
        for (Suit suit: Suit.values()){
            for (LocalCard localCard : field.get(suit)){
                System.out.print(localCard.toString());
            }
            System.out.println();
        }
    }
}
