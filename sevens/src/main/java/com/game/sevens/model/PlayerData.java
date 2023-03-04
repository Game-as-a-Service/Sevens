package com.game.sevens.model;

import com.game.sevens.domain.LocalCard;
import com.game.sevens.domain.LocalPlayer;
import com.game.sevens.domain.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerData {
    private String name;
    private List<CardData> hands;


    public LocalPlayer toDomain() {
        var hands = this.hands.stream()
                .map(CardData::toDomain)
                .collect(Collectors.toList());
        return new LocalPlayer(this.name, hands);
    }

    public static PlayerData toData(LocalPlayer player) {

        var hands = player.getHands().stream()
                .map(LocalCard -> CardData.toCardData(LocalCard))
                .collect(Collectors.toList());
        return new PlayerData(player.getName(), hands);
    }

}