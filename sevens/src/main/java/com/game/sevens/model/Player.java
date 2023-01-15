package com.game.sevens.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private List<Card> hands = new ArrayList<>();


    public String getName() {
        return name;
    }

    public List<Card> getHands() {
        return hands;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHands(List<Card> hands) {
        this.hands = hands;
    }
}
