package com.game.sevens.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private String id;
    private Map<String, List<LocalCard>> field = new HashMap<>();
    private List<LocalPlayer> localPlayers = new ArrayList<>();
    private Deck deck = new Deck();

    private int turnNum = 1;


    public Game(String id, List<Field> field, List<LocalPlayer> players, int turnNum) {
        this.id = id;
        for (Field f: field){
            this.field.put(f.getRank(),f.getField());
        }
        this.localPlayers = players;
        this.turnNum = turnNum;
    }

    public List<Field> getFieldList(){
        List<Field> fields = new ArrayList<>();
        for (String rank: this.field.keySet()){
            Field field = new Field(rank,this.field.get(rank));
            fields.add(field);
        }
        return fields;
    }
    public void startGame(){
        //initialization
        //shuffle deck
        deck.shuffle();
        //deal card
        while (deck.getDeckSize()>0){
            for (LocalPlayer player: localPlayers){
                deck.dealCard(player);
            }
        }
        for (LocalPlayer player: localPlayers){
            Collections.sort(player.getHands());
            System.out.println(player.getHands());
        }
    }
    public boolean shownCardIsLegal(LocalCard localCard){
        //find same suit line
        List<LocalCard> line = field.get(localCard.getRank());
        //check if previous or next rank
        if (localCard.getSuit().toString().equals("SEVEN")){
            return true;
        }
        else if (line.size() > 0) {
            if (line.get(0).getSuit().ordinal() - localCard.getSuit().ordinal() == 1) {
                return true;
            }
            else if (localCard.getSuit().ordinal() - line.get(line.size() - 1).getSuit().ordinal() == 1) {
                return true;
            }
        }

        return false;
    }

    public void addCardToField(LocalCard localCard) {
        //find same suit line
        List<LocalCard> line = field.get(localCard.getRank());
        if (localCard.getSuit().toString().equals("SEVEN")){
            line.add(localCard);
        }
        else if (line.get(0).getSuit().ordinal() - localCard.getSuit().ordinal() == 1){
            line.add(0, localCard);
        }
        else if (localCard.getSuit().ordinal() - line.get(line.size()-1).getSuit().ordinal()== 1){
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

    public void addPlayer(LocalPlayer localPlayer){
        localPlayers.add(localPlayer);
    }





}
