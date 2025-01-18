package org.snakeinc.server.model;

import java.lang.annotation.Inherited;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class ScoreEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String snake;
    private Integer score;

    // public ScoreEntity(){

    // }

    // public ScoreEntity(String snake, Integer score){
    //     this.snake = snake;
    //     this.score = score;
    // }
}
