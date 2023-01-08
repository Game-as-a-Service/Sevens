package com.game.sevens.repository;

import com.game.sevens.model.SevensDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SevensDataRepository extends MongoRepository<SevensDataModel, String>{
}


