package com.game.sevens.controllers;

import com.game.sevens.repository.SevensDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /*
    @PostMapping("startgame/{gameId}")
    public String startGame(@PathVariable("gameId") String gameId){
        Game game = new Game();
        LocalPlayer a = new LocalPlayer("A");
        LocalPlayer b = new LocalPlayer("B");
        game.addPlayer(a);
        game.addPlayer(b);
        game.startGame();
        SevensData sevensDataModel = new SevensData();
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

    @PostMapping("putdown/{gameId}")
    public String putDownCardByCard(@PathVariable("gameId") String gameId,
                              @RequestBody LocalCard card){
        PutDownCardUsecase putDownCardUsecase = new PutDownCardUsecase();
        SevensData sevensDataModel = sevensDataRepository.findById(gameId).get();
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

    /*
    @GetMapping("gethands/{gameId}")
    public List<LocalCard> getHands(@PathVariable("gameId") String gameId){
        SevensData sevensDataModel = sevensDataRepository.findById(gameId).get();
        LocalPlayer player = sevensDataModel.getLocalPlayers().get(sevensDataModel.getTurnNum()%sevensDataModel.getLocalPlayers().size());
        System.out.println(player.getHands());
        return player.getHands();

    }
    */
    /*
    @PostMapping("putdowncard/{gameId}/{cardId}")
    public String putDownCardById(@PathVariable("gameId") String gameId,
                                    @PathVariable("cardId") int cardId){
        //get data & game
        SevensData sevensDataModel = sevensDataRepository.findById(gameId).get();
        Game game = sevensDataModel.toGame();
        //get card
        LocalPlayer player = sevensDataModel.getLocalPlayers().get(sevensDataModel.getTurnNum()%sevensDataModel.getLocalPlayers().size());
        LocalCard card = player.getHands().get(cardId);
        //implement putdowncard
        PutDownCardUsecase putDownCardUsecase = new PutDownCardUsecase();
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
    */
}
