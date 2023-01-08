package com.game.sevens.model;

import com.game.sevens.domain.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "Games")
public class SevensDataModel {
    @Id
    private String id;

    private int turnNum = 1;
    private Integer xPlayersTurn=1;
    private Map<Rank, List<LocalCard>> field = new HashMap<>();
    private List<LocalPlayer> localPlayers = new ArrayList<>();
    //private Deck deck = new Deck();

    public Game toGame(){
        Game game = new Game();
        game.setField(this.field);
        game.setLocalPlayers(this.localPlayers);
        game.setTurnNum(this.getTurnNum());
        return game;
    }

    public SevensDataModel toData(){
        SevensDataModel sevensDataModel = new SevensDataModel();
        return sevensDataModel;
    }

    public String getId() {
        return id;
    }

    public Integer getxPlayersTurn() {
        return xPlayersTurn;
    }

    public Map<Rank, List<LocalCard>> getField() {
        return field;
    }

    public List<LocalPlayer> getLocalPlayers() {
        return localPlayers;
    }

    public int getTurnNum() {
        return turnNum;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setxPlayersTurn(Integer xPlayersTurn) {
        this.xPlayersTurn = xPlayersTurn;
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
}
