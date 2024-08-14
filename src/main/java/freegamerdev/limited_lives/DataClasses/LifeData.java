package freegamerdev.limited_lives.DataClasses;

import java.util.HashMap;

public class LifeData {

    private HashMap<String, Integer> playerDeaths;

    public LifeData() {
        playerDeaths = new HashMap<>();
    }

    public void addPlayer(String uuid, int deaths) {
        playerDeaths.put(uuid, deaths);
    }

    public int getDeathsFromPlayer(String uuid) {
        return playerDeaths.get(uuid);
    }

    public void setDeathsForPlayer(String uuid, int deaths) {
        playerDeaths.put(uuid, deaths);
    }

    public HashMap<String, Integer> getPlayerDeaths() {
        return playerDeaths;
    }

    public void setPlayerDeaths(HashMap<String, Integer> playerDeaths) {
        this.playerDeaths = playerDeaths;
    }
}
