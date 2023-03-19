package nl.tudelft.jpacman.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PlayerScore{
    private String playerName;
    private int score;

    public String getPlayerName() {
        return playerName;
    }

    public PlayerScore(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
