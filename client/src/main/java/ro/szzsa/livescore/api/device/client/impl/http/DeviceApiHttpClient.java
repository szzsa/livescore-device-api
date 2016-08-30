package ro.szzsa.livescore.api.device.client.impl.http;

import ro.szzsa.livescore.api.device.client.DeviceApiClient;
import ro.szzsa.livescore.api.device.client.handler.GameDetailsUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.GamesUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.StandingsUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.TeamsUpdateHandler;
import ro.szzsa.livescore.api.device.client.impl.http.connector.Connector;
import ro.szzsa.livescore.api.device.client.impl.http.connector.HttpConnector;
import ro.szzsa.livescore.api.device.client.impl.http.connector.Request;
import ro.szzsa.livescore.api.device.client.impl.http.converter.Converter;
import ro.szzsa.livescore.api.device.client.impl.http.converter.JsonConverter;
import ro.szzsa.livescore.api.device.client.log.EmptyLogger;
import ro.szzsa.livescore.api.device.client.log.Logger;
import ro.szzsa.livescore.api.device.protocol.DeviceApiEndpoints;
import ro.szzsa.livescore.api.device.protocol.request.GameDetailsRequest;
import ro.szzsa.livescore.api.device.protocol.request.VersionSyncRequest;
import ro.szzsa.livescore.api.device.protocol.response.GameDetailsResponse;
import ro.szzsa.livescore.api.device.protocol.response.StatsSyncResponse;
import ro.szzsa.livescore.api.device.protocol.response.VersionSyncResponse;

public class DeviceApiHttpClient implements DeviceApiClient {

    private int connectionTimeout = 10000;

    private int socketTimeout = 10000;

    private int numberOfRetries = 2;

    private Logger logger = new EmptyLogger();

    private Connector connector = new HttpConnector(connectionTimeout, socketTimeout, numberOfRetries, logger);

    private Converter converter = new JsonConverter();

    @Override
    public void getGameDetails(String gameId, GameDetailsUpdateHandler gameDetailsHandler) {
        GameDetailsRequest requestPayload = new GameDetailsRequest();
        requestPayload.setGameId(gameId);
        String message = converter.toString(requestPayload);
        Request request = new Request(DeviceApiEndpoints.GET_GAME_DETAILS.getUrl(), message);

        String response = connector.sendRequest(request);

        GameDetailsResponse responsePayload = converter.fromString(response, GameDetailsResponse.class);

        gameDetailsHandler.handleGameDetailsUpdate(responsePayload.getGameDetails());
    }

    @Override
    public void getStats(TeamsUpdateHandler teamsHandler, GamesUpdateHandler gamesHandler, StandingsUpdateHandler standingsHandler) {
        Request request = new Request(DeviceApiEndpoints.SYNC_STATS.getUrl());

        String response = connector.sendRequest(request);

        StatsSyncResponse responsePayload = converter.fromString(response, StatsSyncResponse.class);

        teamsHandler.handleTeamsUpdate(responsePayload.getTeams());
        gamesHandler.handleGamesUpdate(responsePayload.getGames());
        standingsHandler.handleStandingsUpdate(responsePayload.getStandings());
    }

    @Override
    public boolean shouldUpdate(int appVersion) {
        VersionSyncRequest requestPayload = new VersionSyncRequest();
        requestPayload.setAppVersion(appVersion);
        String message = converter.toString(requestPayload);
        Request request = new Request(DeviceApiEndpoints.SYNC_VERSION.getUrl(), message);

        String response = connector.sendRequest(request);

        VersionSyncResponse responsePayload = converter.fromString(response, VersionSyncResponse.class);

        return responsePayload.isUpdateApp();
    }

    /**
     * Set connection timeout in milliseconds.
     *
     * @param connectionTimeout connection timeout
     */
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * Set socket timeout in milliseconds.
     *
     * @param socketTimeout socket timeout
     */
    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    /**
     * Set number of connection retries.
     *
     * @param numberOfRetries number of retries
     */
    public void setNumberOfRetries(int numberOfRetries) {
        this.numberOfRetries = numberOfRetries;
    }

    /**
     * Sets the logger.
     *
     * @param logger the logger
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
