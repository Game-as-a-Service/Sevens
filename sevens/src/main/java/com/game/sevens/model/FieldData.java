package com.game.sevens.model;

import com.game.sevens.domain.Field;
import com.game.sevens.domain.LocalPlayer;
import com.game.sevens.domain.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldData {

    private String  rank;
    private List<CardData> field;

    public Field toDomain() {
//        var ranks = this.ranks.stream()
//                .map(String -> Enum.valueOf(Rank.class, String))
//                .collect(Collectors.toList());

        var field = this.field.stream()
                .map(CardData::toDomain)
                .collect(Collectors.toList());
        return new Field(this.rank, field);
    }

    public static FieldData toData(Field field) {
//        var ranksData = field.getRanks().stream()
//                .map(Rank :: toString)
//                .collect(Collectors.toList());
        var fieldData = field.getField().stream()
                .map(LocalCard -> CardData.toCardData(LocalCard))
                .collect(Collectors.toList());
        return new FieldData(field.getRank(), fieldData);
    }
}
