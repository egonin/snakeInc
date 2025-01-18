package org.snakeinc.server.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.snakeinc.server.service.ScoreService;
import org.snakeinc.server.model.ScoreBody;
import org.snakeinc.server.model.ScoreEntity;
import org.snakeinc.server.model.StatBody;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ScoreController {

    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/api/v1/score")
    public Pair <String, Integer> postScore(@RequestBody ScoreBody requestBody){
        if (requestBody.getScore() >= 0 && Arrays.asList("python", "anaconda", "boaConstrictor").contains(requestBody.getSnake())) {
            scoreService.postScore(requestBody);
            return Pair.of(requestBody.getSnake(), requestBody.getScore());
        }
        // return HttpServletResponse.sendError ;
        return Pair.of("nul",0);
    }

    @GetMapping("/api/v1/scores")
    public List<ScoreEntity> getScores(@RequestParam String snake){
        // List<ScoreEntity> response = scoreService.getScores(snake);
        return scoreService.getScores(snake);
    }

    @GetMapping("/api/v1/scores/stats")
    public List<StatBody> getStats(){
        return scoreService.getStats();
    }
}
