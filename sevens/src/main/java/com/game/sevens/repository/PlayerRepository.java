package com.game.sevens.repository;

import com.game.sevens.model.Card;
import com.game.sevens.model.PlayerData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<PlayerData, String> {
}
