package com.game.sevens.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Players")
public class Player {
    @Id
    private String id;

    private String name;

    private List<Card> hands = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHands() {
        return hands;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHands(List<Card> hands) {
        this.hands = hands;
    }
}
