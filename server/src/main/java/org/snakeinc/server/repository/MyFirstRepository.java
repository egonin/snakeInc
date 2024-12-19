package main.java.org.snakeinc.server.repository;

import main.java.org.snakeinc.server.model.ScoreEntity;
import org.springframework.data.repository.CrudRepository;

public interface MyFirstRepository extends CrudRepository<ScoreEntity, Integer> {

}
