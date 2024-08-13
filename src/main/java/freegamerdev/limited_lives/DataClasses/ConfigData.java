package freegamerdev.limited_lives.DataClasses;

public class ConfigData {
    private int maxLives;
    private String livesLeftText;
    private String noRespawnsLeftMessage;

    public ConfigData() {
        maxLives = 10;
        livesLeftText = "Lives left: %l";
        noRespawnsLeftMessage = "You have no more respawns left! What a shame...";
    }

    public int getMaxLives() {
        return maxLives;
    }

    public void setMaxLives(int maxLives) {
        this.maxLives = maxLives;
    }

    public String getLivesLeftText() {
        return livesLeftText;
    }

    public void setLivesLeftText(String livesLeftText) {
        this.livesLeftText = livesLeftText;
    }

    public String getNoRespawnsLeftMessage() {
        return noRespawnsLeftMessage;
    }

    public void setNoRespawnsLeftMessage(String noRespawnsLeftMessage) {
        this.noRespawnsLeftMessage = noRespawnsLeftMessage;
    }
}