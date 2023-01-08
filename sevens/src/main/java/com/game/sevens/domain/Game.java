package com.game.sevens.domain;

import java.util.*;

public class Game {
    private Map<Rank, List<LocalCard>> field = new HashMap<>();
    private List<LocalPlayer> localPlayers = new ArrayList<>();
    private Deck deck = new Deck();

    private int turnNum = 1;

    private int xPlayersTurn = 1;

    public Game() {
        for (Rank rank : Rank.values()) {
            field.put(rank,new ArrayList<>());
        }
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
        }
    }
    public boolean shownCardIsLegal(LocalCard localCard){
        //find same suit line
        List<LocalCard> line = field.get(localCard.getRank());
        //check if previous or next rank
        if (localCard.getSuit().toString().equals("SEVEN")){
            return true;
        }
        try{
            if (line.get(0).getSuit().ordinal() - localCard.getSuit().ordinal() == 1){
                return true;
            }
            else if (localCard.getSuit().ordinal() - line.get(line.size()-1).getSuit().ordinal()== 1){
                return true;
            }
        }catch(Exception e){

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

    public Map<Rank, List<LocalCard>> getField() {
        return field;
    }

    public List<LocalPlayer> getLocalPlayers() {
        return localPlayers;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getTurnNum() {
        return turnNum;
    }

    public int getxPlayersTurn() {
        return xPlayersTurn;
    }

    public void setField(Map<Rank, List<LocalCard>> field) {
        this.field = field;
    }

    public void setLocalPlayers(List<LocalPlayer> localPlayers) {
        this.localPlayers = localPlayers;
    }

    public void setTurnNum(int turnNum) {
        this.turnNum = turnNum;
    }

    public void setxPlayersTurn(int xPlayersTurn) {
        this.xPlayersTurn = xPlayersTurn;
    }
}
