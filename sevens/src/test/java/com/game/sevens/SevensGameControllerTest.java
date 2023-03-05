package com.game.sevens;

import com.game.sevens.app.port.SevensGameRepository;
import com.game.sevens.controllers.GameController;
import com.game.sevens.domain.Game;
import com.game.sevens.domain.LocalPlayer;
import com.game.sevens.repository.SpringSevensGameRepository;
import com.game.sevens.repository.dao.SevensGameDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SevensGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SevensGameRepository gameRepository;

    @Autowired
    private SevensGameDAO dao;

    SpringSevensGameRepository springSevensGameRepository = new SpringSevensGameRepository(dao);
    @Test
    public void putCardTest() throws Exception {
        LocalPlayer A = new LocalPlayer("A");
        LocalPlayer B = new LocalPlayer("B");

        Game game = new Game();
        game.addPlayer(A);
        game.addPlayer(B);
        game.startGame();

        game = givenGameStarted(game);


//        mockMvc.perform(post("/api/games/{gameId}:playCard", game.getId())
//                        .contentType(APPLICATION_JSON)
//                        .content("{" +
//                                "  \"playerId\": \"B\",\n" +
//                                "  \"handIndex\": 0,\n" +
//                                "  \"targetPlayerId\": \"A\"\n" +
//                                "}"))
//                .andExpect(status().isNoContent());

        var actualGame = findGameById(game.getId());
        LocalPlayer actualOne = actualGame.getLocalPlayers().get(0);

        //assertTrue(actualOne.getHands().isAvailable());
        assertEquals(26, actualOne.getHands().size());

    }
    private Game givenGameStarted(Game game) {
        return gameRepository.save(game);
    }
    private Game findGameById(String gameId) {
        // 從 repo 查出 game
        return gameRepository.findById(gameId).orElseThrow();
    }
}
