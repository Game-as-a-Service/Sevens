package com.game.sevens.app.usecases;

import com.game.sevens.domain.Game;
import com.game.sevens.domain.LocalCard;

public class PutDownCardUsecase {

//    public void execute(LocalCard card, Game game) {
//        var game = findGame(input);
//
//        PlayerData player = game.getPlayer(input.side);
//        var events = game.moveChess(player, input.from, input.to);
//
//        chineseChessRepository.saveAndBroadcast(game, events);
//
//        presenter.success(events);
//    }
    public boolean execute(LocalCard card, Game game){
        boolean isLegal = game.shownCardIsLegal(card);
        if (isLegal == true){
            game.addCardToField(card);
            return true;
        }

        return false;
    }
}
