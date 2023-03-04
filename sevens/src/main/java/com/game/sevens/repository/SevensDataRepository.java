package com.game.sevens.repository;

import com.game.sevens.model.SevensData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SevensDataRepository extends MongoRepository<SevensData, String>{
}


