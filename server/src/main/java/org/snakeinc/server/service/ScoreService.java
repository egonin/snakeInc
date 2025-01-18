package org.snakeinc.server.service;

import java.util.List;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import org.snakeinc.server.model.ScoreBody;
import org.snakeinc.server.model.ScoreEntity;
import org.snakeinc.server.model.StatBody;
import org.snakeinc.server.repository.MyFirstRepository;

@Service
public class ScoreService {

    private final MyFirstRepository firstRepository;

    public ScoreService(MyFirstRepository firstRepository){
        this.firstRepository = firstRepository;
    }

    // public List<ScoreEntity> getAllFirstEntities(){
    //     List<ScoreEntity> entities = new ArrayList();
    //     for (ScoreEntity entity : firstRepository.findAll()) {
    //         entities.add(entity);
    //     }
    //     return entities;
    // }

    public Integer getNumber(int number){
        return number;
    }

    public void postScore(ScoreBody scoreBody){
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setScore(scoreBody.getScore());
        scoreEntity.setSnake(scoreBody.getSnake());
        // ScoreEntity scoreEntity = new ScoreEntity(scoreBody.getSnake(),scoreBody.getScore());
        firstRepository.save(scoreEntity);
    }

    public List<ScoreEntity> getScores(String snake){
        List<ScoreEntity> entities = new ArrayList();
        for (ScoreEntity entity : firstRepository.findAll()) {
            if (entity.getSnake().equals(snake)){
                entities.add(entity);
            }
        }
        return entities;
    }

    private Integer getMax(String snake){
        List<ScoreEntity> scores = getScores(snake);
        if (scores.isEmpty()) {
            return null;
        }
        Integer max = 0;
        for (ScoreEntity score : scores){
            if (score.getScore() > max){
                max=score.getScore();
            }
        }
        return max;
    }

    private Integer getMin(String snake){
        List<ScoreEntity> scores = getScores(snake);
        if (scores.isEmpty()) {
            return null;
        }
        Integer min = scores.getFirst().getScore();
        for (ScoreEntity score : scores){
            if (score.getScore() < min){
                min=score.getScore();
            }
        }
        return min;
    }

    private Integer getAverage(String snake){
        List<ScoreEntity> scores = getScores(snake);
        if (scores.isEmpty()){
            return null;
        }
        Integer average = 0;
        for (ScoreEntity score : scores){
            average+=score.getScore();
        }
        average = Math.round(average / scores.size());
        return average;
    }

    private StatBody getStat(String snake){
        StatBody stat = new StatBody();
        stat.setSnake(snake);
        stat.setMin(getMin(snake));
        stat.setMax(getMax(snake));
        stat.setAverage(getAverage(snake));
        return stat;
    }

    public List<StatBody> getStats(){
        List<StatBody> stats = new ArrayList();
        stats.add(getStat("python"));
        stats.add(getStat("anaconda"));
        stats.add(getStat("boaConstrictor"));
        return stats;
    }


}
