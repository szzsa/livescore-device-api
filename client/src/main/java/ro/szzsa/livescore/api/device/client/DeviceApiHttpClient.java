package ro.szzsa.livescore.api.device.client;

import ro.szzsa.livescore.api.device.client.converter.Converter;
import ro.szzsa.livescore.api.device.client.converter.Converters;
import ro.szzsa.livescore.api.device.client.exception.DeviceApiException;
import ro.szzsa.livescore.api.device.client.handler.GameDetailsUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.GamesUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.StandingsUpdateHandler;
import ro.szzsa.livescore.api.device.client.handler.TeamsUpdateHandler;
import ro.szzsa.livescore.api.device.protocol.DeviceApiEndpoints;
import ro.szzsa.livescore.api.device.protocol.request.GameDetailsRequest;
import ro.szzsa.livescore.api.device.protocol.request.VersionSyncRequest;
import ro.szzsa.livescore.api.device.protocol.response.GameDetailsResponse;
import ro.szzsa.livescore.api.device.protocol.response.StatsSyncResponse;
import ro.szzsa.livescore.api.device.protocol.response.VersionSyncResponse;
import ro.szzsa.utils.connector.Connector;
import ro.szzsa.utils.connector.Connectors;
import ro.szzsa.utils.connector.Request;

public class DeviceApiHttpClient implements DeviceApiClient {

  private Connector connector = Connectors.createHttpConnector();

  private Converter converter = Converters.createJsonConverter();

  @Override
  public void getGameDetails(String gameId, GameDetailsUpdateHandler gameDetailsHandler) throws DeviceApiException {
    try {
      GameDetailsRequest requestPayload = new GameDetailsRequest();
      requestPayload.setGameId(gameId);
      String message = converter.toString(requestPayload);
      Request request = new Request(DeviceApiEndpoints.GET_GAME_DETAILS_URL, message);

      String response = connector.sendRequest(request);

      GameDetailsResponse responsePayload = converter.fromString(response, GameDetailsResponse.class);

      gameDetailsHandler.handleGameDetailsUpdate(responsePayload.getGame());
    } catch (Exception e) {
      throw new DeviceApiException(e);
    }
  }

  @Override
  public void getStats(TeamsUpdateHandler teamsHandler, GamesUpdateHandler gamesHandler,
                       StandingsUpdateHandler standingsHandler)
    throws DeviceApiException {
    try {
      Request request = new Request(DeviceApiEndpoints.GET_STATS_URL);

      String response = connector.sendRequest(request);

      StatsSyncResponse responsePayload = converter.fromString(response, StatsSyncResponse.class);

      teamsHandler.handleTeamsUpdate(responsePayload.getTeams());
      gamesHandler.handleGamesUpdate(responsePayload.getGames());
      standingsHandler.handleStandingsUpdate(responsePayload.getStandings());
    } catch (Exception e) {
      throw new DeviceApiException(e);
    }
  }

  @Override
  public boolean shouldUpdate(int appVersion) throws DeviceApiException {
    try {
      VersionSyncRequest requestPayload = new VersionSyncRequest();
      requestPayload.setAppVersion(appVersion);
      String message = converter.toString(requestPayload);
      Request request = new Request(DeviceApiEndpoints.SYNC_VERSION_URL, message);

      String response = connector.sendRequest(request);

      VersionSyncResponse responsePayload = converter.fromString(response, VersionSyncResponse.class);

      return responsePayload.isUpdateApp();
    } catch (Exception e) {
      throw new DeviceApiException(e);
    }
  }
}
