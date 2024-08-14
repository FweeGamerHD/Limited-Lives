package freegamerdev.limited_lives;

import freegamerdev.limited_lives.DataClasses.ConfigData;
import freegamerdev.limited_lives.DataClasses.ConfigDataManager;
import freegamerdev.limited_lives.DataClasses.LifeData;
import freegamerdev.limited_lives.DataClasses.LifeDataManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

import java.io.IOException;

public class Limited_lives implements ModInitializer {

    private LifeData lifeData;
    private int MAX_LIVES = 10;
    private String LIVES_LEFT_TEXT = "Lives left: %l";
    private String NO_RESPAWNS_LEFT_MESSAGE = "You have no more respawns left! What a shame...";

    @Override
    public void onInitialize() {
        try {
            lifeData = LifeDataManager.loadLifeData();
            ConfigData configData = ConfigDataManager.loadConfigData();
            MAX_LIVES = configData.getMaxLives() - 1;
            LIVES_LEFT_TEXT = configData.getLivesLeftText();
            NO_RESPAWNS_LEFT_MESSAGE = configData.getNoRespawnsLeftMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Register the event listener for player respawn
        ServerPlayerEvents.AFTER_RESPAWN.register(this::onPlayerRespawn);
    }

    // This method runs every time a player respawns on the server
    private void onPlayerRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        if (!lifeData.getPlayerDeaths().containsKey(newPlayer.getUuid().toString())) {
            lifeData.addPlayer(newPlayer.getUuid().toString(), 0);
        }

        if (!alive) {
            int playerDeaths = lifeData.getDeathsFromPlayer(newPlayer.getUuid().toString());

            if (playerDeaths < MAX_LIVES) {
                playerDeaths++;
                lifeData.setDeathsForPlayer(newPlayer.getUuid().toString(), playerDeaths);
                String messageText = LIVES_LEFT_TEXT.replace("%l", String.valueOf(MAX_LIVES - playerDeaths + 1));
                newPlayer.sendMessage(Text.of(messageText), false);
            } else {
                newPlayer.sendMessage(Text.of(NO_RESPAWNS_LEFT_MESSAGE), false);
                newPlayer.changeGameMode(GameMode.SPECTATOR);
            }
        }

        try {
            LifeDataManager.saveLifeData(lifeData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
