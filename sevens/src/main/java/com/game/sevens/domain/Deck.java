package com.game.sevens.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<LocalCard> deck = new ArrayList<>();

    public Deck(){
//        List<Rank> ranks = new ArrayList<>();
//        ranks.add(Rank.S);
//        ranks.add(Rank.H);
//        ranks.add(Rank.D);
//        ranks.add(Rank.C);
//        List<Suit> suits = new ArrayList<>();
//        suits.add(Suit.TWO);
//        suits.add(Suit.THREE);
//        suits.add(Suit.FOUR);
//        suits.add(Suit.FIVE);
//        suits.add(Suit.SIX);
//        suits.add(Suit.SEVEN);
//        suits.add(Suit.EIGHT);
//        suits.add(Suit.NINE);
//        suits.add(Suit.TEN);
//        suits.add(Suit.J);
//        suits.add(Suit.Q);
//        suits.add(Suit.K);
//        suits.add(Suit.A);

        for (Rank rank: Rank.values()){
            for (Suit suit: Suit.values()){
                deck.add(new LocalCard(rank, suit));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public void dealCard(LocalPlayer localPlayer){
        LocalCard localCard = deck.remove(0);
        localPlayer.addCard(localCard);
    }

}
