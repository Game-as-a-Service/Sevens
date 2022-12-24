package com.game.sevens.repository;

import com.game.sevens.model.Card;
import com.game.sevens.model.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FieldRepository extends MongoRepository<Field, String> {
    @Query("{'rank' : ?0}")
    List<Field> getLineByRank(String rank);
}
