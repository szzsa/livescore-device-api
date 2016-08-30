package ro.szzsa.livescore.api.device.client.handler;

import ro.szzsa.livescore.api.device.model.game.GameDetails;

/**
 * Handles the up to date game details just received from the server.
 */
public interface GameDetailsUpdateHandler {

    void handleGameDetailsUpdate(GameDetails gameDetails);
}
