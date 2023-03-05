package com.game.sevens.repository.dao;

import com.game.sevens.domain.Game;
import com.game.sevens.model.SevensData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SevensGameDAO extends MongoRepository<SevensData, String> {
}
