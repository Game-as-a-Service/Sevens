package com.game.sevens.app.port;

import com.game.sevens.domain.Game;

import java.util.Optional;

public interface SevensGameRepository {

    Game save(Game game);

    Optional<Game> findById(String id);
}
