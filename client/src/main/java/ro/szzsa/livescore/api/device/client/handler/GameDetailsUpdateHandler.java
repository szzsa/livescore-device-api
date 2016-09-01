package ro.szzsa.livescore.api.device.client.handler;

import ro.szzsa.livescore.model.Game;

/**
 * Handles the up to date game details just received from the server.
 */
public interface GameDetailsUpdateHandler {

  void handleGameDetailsUpdate(Game game);
}
