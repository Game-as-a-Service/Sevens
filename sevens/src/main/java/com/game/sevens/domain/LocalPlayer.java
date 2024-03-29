package com.game.sevens.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Setter
@Getter
public class LocalPlayer {
    private String name;
    private List<LocalCard> hands = new ArrayList<>();

    public LocalPlayer(String name) {
        this.name = name;
    }

    public LocalPlayer(String name, List<LocalCard> hands) {
        this.name = name;
        this.hands = hands;
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

}
