package com.game.sevens.controllers;

import com.game.sevens.app.usecases.PutDownCardUsecase;
import com.game.sevens.domain.Game;
import com.game.sevens.domain.LocalCard;
import com.game.sevens.domain.LocalPlayer;
import com.game.sevens.model.SevensDataModel;
import com.game.sevens.repository.SevensDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthTextAreaUI;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {
    @Autowired
    private SevensDataRepository sevensDataRepository;
//    @PostMapping("/{gameId}/moves")
//    public ResponseEntity<Void> moveChess(@PathVariable Integer gameId,
//                                          @RequestBody MoveChessRequest input) {
//        var presenter = new MoveChessPresenter();
//        moveChessUsecase.execute(new MoveChessUsecase.Input(
//                Side.valueOf(input.side), gameId,
//                point(input.from), point(input.to)), presenter);
//        return noContent().build();
//    }
//    @PostMapping("putdown")
//    public String putDownCard(//@PathVariable Integer gameId,
//                              @RequestBody LocalCard card){
//
//    }
    @PostMapping("startgame/{gameId}")
    public String startGame(@PathVariable("gameId") String gameId){
        Game game = new Game();
        LocalPlayer a = new LocalPlayer("A");
        LocalPlayer b = new LocalPlayer("B");
        game.addPlayer(a);
        game.addPlayer(b);
        game.startGame();
        SevensDataModel sevensDataModel = new SevensDataModel();
        sevensDataModel.setId(gameId);
        sevensDataModel.setField(game.getField());
        sevensDataModel.setLocalPlayers(game.getLocalPlayers());

        sevensDataRepository.save(sevensDataModel);
        return "create sevensdata success";
    }

    @GetMapping("getgame")
    public String getGame(){
        System.out.println(sevensDataRepository.findById("2").get().
                getLocalPlayers().get(0).getHands());
        return "get game successfully";
    }

    @PostMapping("putdowncard/{gameId}")
    public String putDownCard(@PathVariable("gameId") String gameId,
                              @RequestBody LocalCard card){
        PutDownCardUsecase putDownCardUsecase = new PutDownCardUsecase();
        SevensDataModel sevensDataModel = sevensDataRepository.findById(gameId).get();
        Game game = sevensDataModel.toGame();
        boolean isLegal = putDownCardUsecase.execute(card, game);
        //System.out.println(game.getLocalPlayers().get(game.getxPlayersTurn()%game.getLocalPlayers().size()).getHands());
        if (isLegal == false){
            return "illegal, please select the card again";
        }
        sevensDataModel.setTurnNum(sevensDataModel.getTurnNum()+1);
        sevensDataModel.setField(game.getField());
        sevensDataRepository.save(sevensDataModel);
        return "success";
    }
}
