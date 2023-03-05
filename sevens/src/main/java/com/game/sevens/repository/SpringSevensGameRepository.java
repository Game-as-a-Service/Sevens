package com.game.sevens.repository;

import com.game.sevens.app.port.SevensGameRepository;
import com.game.sevens.domain.Game;
import com.game.sevens.model.SevensData;
import com.game.sevens.repository.dao.SevensGameDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpringSevensGameRepository implements SevensGameRepository {

    @Autowired
    private final SevensGameDAO dao;
    @Override
    public Game save(Game game) {
        SevensData data = SevensData.toData(game);
        SevensData savedData = dao.save(data);
        return savedData.toDomain();
    }

    @Override
    public Optional<Game> findById(String id) {
        return dao.findById(id)
                .map(SevensData::toDomain);
    }
}
