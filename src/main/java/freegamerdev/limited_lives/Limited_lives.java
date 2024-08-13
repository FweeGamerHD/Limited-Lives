package freegamerdev.limited_lives;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class Limited_lives implements ModInitializer {

    @Override
    public void onInitialize() {
        // Register the event listener for player respawn
        ServerPlayerEvents.AFTER_RESPAWN.register(this::onPlayerRespawn);
    }

    // This method runs every time a player respawns on the server
    private void onPlayerRespawn(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        if (!alive) {

        }
    }
}
