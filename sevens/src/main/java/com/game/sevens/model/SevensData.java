package com.game.sevens.model;

import com.game.sevens.domain.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SevensGames")
public class SevensData {
    @Id
    private String id;

    private int turnNum = 1;
    private List<FieldData> field;
    private List<PlayerData> players;


    public Game toDomain() {
        var players = this.players.stream()
                        .map(PlayerData::toDomain)
                        .collect(Collectors.toList());
        var field = this.field.stream()
                .map(FieldData::toDomain)
                .collect(Collectors.toList());
        Game game = new Game(this.id, field, players, this.turnNum);
        return game;
    }

    public static SevensData toData(/*聚合根*/ Game sevensGame) {
        var field = sevensGame.getFieldList().stream()
                .map(Field -> FieldData.toData(Field))
                .collect(Collectors.toList());
        var players = sevensGame.getLocalPlayers().stream()
                .map(LocalPlayer -> PlayerData.toData(LocalPlayer))
                .collect(Collectors.toList());

        return new SevensData(sevensGame.getId(), sevensGame.getTurnNum(), field, players);
    }






}
