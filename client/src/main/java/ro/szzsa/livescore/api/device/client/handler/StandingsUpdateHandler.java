package ro.szzsa.livescore.api.device.client.handler;

import java.util.List;

import ro.szzsa.livescore.api.device.model.game.Standings;

/**
 * Handles the up to date standings just received from the server.
 */
public interface StandingsUpdateHandler {

    void handleStandingsUpdate(List<Standings> teams);
}
