package org.snakeinc.server.repository;

import org.snakeinc.server.model.ScoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface MyFirstRepository extends CrudRepository<ScoreEntity, Integer> {

}
