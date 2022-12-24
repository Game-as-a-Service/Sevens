package com.game.sevens.repository;

import com.game.sevens.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardTestRepository extends MongoRepository<Card, String> {
    @Query("{ 'id' : ?0 }")
    Optional<Card> findById(String id);
}
