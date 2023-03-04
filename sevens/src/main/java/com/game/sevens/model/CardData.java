package com.game.sevens.model;


import com.game.sevens.domain.LocalCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardData {
    private String rank;

    private String suit;

    public LocalCard toDomain() {
        return new LocalCard(rank,suit);
    }

    static CardData toCardData(LocalCard card) {
        return CardData.builder()
                .rank(card.getRank().toString())
                .suit(card.getSuit().toString())
                .build();
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
