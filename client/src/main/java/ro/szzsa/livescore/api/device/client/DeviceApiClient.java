package ro.szzsa.livescore.api.device.client;

import ro.szzsa.livescore.api.device.client.handler.GameDetailsUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.GamesUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.StandingsUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.TeamsUpdateHandler;

/**
 * Client of device API.
 */
public interface DeviceApiClient {

    void getGameDetails(String gameId,
                        GameDetailsUpdateHandler gameDetailsHandler);

    void getStats(TeamsUpdateHandler teamsHandler,
                  GamesUpdateHandler gamesHandler,
                  StandingsUpdateHandler standingsHandler);

    boolean shouldUpdate(int appVersion);
}
