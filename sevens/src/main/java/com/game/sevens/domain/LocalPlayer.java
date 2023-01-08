package com.game.sevens.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LocalPlayer {
    private String name;
    private List<LocalCard> hands = new ArrayList<>();

    public LocalPlayer(String name) {
        this.name = name;
    }

    public boolean putDown(Game game){
        Scanner handsIndex = new Scanner(System.in);
        LocalCard shownLocalCard = hands.get(handsIndex.nextInt());
        if (game.shownCardIsLegal(shownLocalCard) == true){
            game.addCardToField(shownLocalCard);
            hands.remove(shownLocalCard);
            return true;
        }
        else{
            System.out.println("you cannot put down this card");
        }
        return false;
    }
    public void addCard(LocalCard localCard){
        hands.add(localCard);
    }
    public boolean pass(){
        return true;
    }
    public void showHands(){
        for (LocalCard localCard :hands){
            System.out.println(localCard.toString());
        }
    }
    public int handsNum(){
        return hands.size();
    }

    public String getName() {
        return name;
    }

    public List<LocalCard> getHands() {
        return hands;
    }
}
