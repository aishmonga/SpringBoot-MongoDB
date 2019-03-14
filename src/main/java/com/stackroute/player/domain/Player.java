package com.stackroute.player.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

//@Entity
@Document(value = "player")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Player {


//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String  playerId;
    private String playerName;
    private int score;

}
//    public Player(int playerId, String playerName, int score) {
//        this.playerId = playerId;
//        this.playerName = playerName;
//        this.score = score;
//    }
//
//    public Player() {
//    }
//
//    public int getPlayerId() {
//        return playerId;
//    }
//
//    public void setPlayerId(int playerId) {
//        this.playerId = playerId;
//    }
//
//    public String getPlayerName() {
//        return playerName;
//    }
//
//    public void setPlayerName(String playerName) {
//        this.playerName = playerName;
//    }
//
//    public String getScore() {
//        return score;
//    }
//
//    public void setScore(String score) {
//        this.score = score;
//    }
//}
