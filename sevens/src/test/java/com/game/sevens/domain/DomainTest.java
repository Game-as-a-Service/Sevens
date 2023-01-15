package com.game.sevens.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainTest {
    private Game game;
    @BeforeEach
    void setUp(){
        game = new Game();

    }

    @Test
    void testGameInitialization(){
        game.addPlayer(new LocalPlayer("A"));
        game.addPlayer(new LocalPlayer("B"));
        game.startGame();
        //test hands number
        assertEquals(26, game.getLocalPlayers().get(0).getHands().size());
        assertEquals(26, game.getLocalPlayers().get(1).getHands().size());
    }

    @Test
    void testShownCardIsLegal(){
        game.addPlayer(new LocalPlayer("A"));
        game.addPlayer(new LocalPlayer("B"));
        game.startGame();
        //test seven
        LocalCard clubSeven = new LocalCard(Rank.C,Suit.SEVEN);
        game.addCardToField(clubSeven);
        assertEquals(true,game.shownCardIsLegal(clubSeven));
        //test same rank legal
        LocalCard clubSix = new LocalCard(Rank.C,Suit.SIX);
        LocalCard clubEight = new LocalCard(Rank.C,Suit.EIGHT);
        LocalCard clubFive = new LocalCard(Rank.C,Suit.FIVE);
        assertEquals(true,game.shownCardIsLegal(clubSix));
        assertEquals(true,game.shownCardIsLegal(clubEight));
        game.addCardToField(clubSix);
        assertEquals(true,game.shownCardIsLegal(clubFive));
        //test same rank illegal
        LocalCard clubAce = new LocalCard(Rank.C, Suit.A);
        assertEquals(false,game.shownCardIsLegal(clubAce));
        //test different rank same suit
        LocalCard diamendSix = new LocalCard(Rank.D, Suit.SIX);
        assertEquals(false,game.shownCardIsLegal(diamendSix));
    }

}
