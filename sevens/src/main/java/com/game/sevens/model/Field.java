package com.game.sevens.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Field")
public class Field {
    @Id
    private String id;
    private List<Card> line = new ArrayList<>();
    private String rank;

    public String getId() {
        return id;
    }

    public List<Card> getLine() {
        return line;
    }

    public String getRank() {
        return rank;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLine(List<Card> line) {
        this.line = line;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
