package freegamerdev.limited_lives.DataClasses;

import java.util.HashMap;

public class LifeData {

    private HashMap<String, Integer> playerLives;

    public LifeData() {
        playerLives = new HashMap<>();
    }

    public HashMap<String, Integer> getPlayerLives() {
        return playerLives;
    }

    public void setPlayerLives(HashMap<String, Integer> playerLives) {
        this.playerLives = playerLives;
    }
}
