package com.game.sevens.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Card> hands = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public boolean putDown(Game game){
        Scanner handsIndex = new Scanner(System.in);
        Card shownCard = hands.get(handsIndex.nextInt());
        if (game.shownCardIsLegal(shownCard) == true){
            game.addCardToField(shownCard);
            hands.remove(shownCard);
            return true;
        }
        else{
            System.out.println("you cannot put down this card");
        }
        return false;
    }
    public void addCard(Card card){
        hands.add(card);
    }
    public boolean pass(){
        return true;
    }
    public void showHands(){
        for (Card card:hands){
            System.out.println(card.toString());
        }
    }
    public int handsNum(){
        return hands.size();
    }
}
