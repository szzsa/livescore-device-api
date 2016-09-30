package ro.szzsa.livescore.api.device.client;

import ro.szzsa.livescore.api.device.client.exception.DeviceApiException;
import ro.szzsa.livescore.api.device.client.handler.GameUpdater;
import ro.szzsa.livescore.api.device.client.handler.StatsUpdater;
import ro.szzsa.livescore.api.device.client.handler.VersionInfoHandler;
import ro.szzsa.livescore.api.device.protocol.DeviceApiEndpoints;
import ro.szzsa.livescore.api.device.protocol.request.GameDetailsRequest;
import ro.szzsa.livescore.api.device.protocol.request.VersionSyncRequest;
import ro.szzsa.livescore.api.device.protocol.response.GameDetailsResponse;
import ro.szzsa.livescore.api.device.protocol.response.StatsSyncResponse;
import ro.szzsa.livescore.api.device.protocol.response.VersionSyncResponse;
import ro.szzsa.utils.connector.Connector;
import ro.szzsa.utils.connector.Request;
import ro.szzsa.utils.converter.Converter;

public abstract class DeviceApiHttpClientAdapter implements DeviceApiClient {

  private final String serverUrl;

  private final Connector connector;

  private final Converter converter;

  protected DeviceApiHttpClientAdapter(String serverUrl, Connector connector, Converter converter) {
    this.serverUrl = serverUrl;
    this.connector = connector;
    this.converter = converter;
  }

  @Override
  public void syncGame(long gameId, GameUpdater gameUpdater) throws DeviceApiException {
    try {
      GameDetailsRequest requestPayload = new GameDetailsRequest();
      requestPayload.setGameId(gameId);
      String message = converter.toString(requestPayload);
      Request request = new Request(serverUrl + DeviceApiEndpoints.GET_GAME_DETAILS_URL, message);

      String response = connector.sendRequest(request);

      GameDetailsResponse responsePayload = converter.fromString(response, GameDetailsResponse.class);

      gameUpdater.updateGame(responsePayload.getGame());
    } catch (Exception e) {
      throw new DeviceApiException(e);
    }
  }

  @Override
  public void getStats(StatsUpdater statsUpdater)
    throws DeviceApiException {
    try {
      Request request = new Request(serverUrl + DeviceApiEndpoints.GET_STATS_URL);

      String response = connector.sendRequest(request);

      StatsSyncResponse responsePayload = converter.fromString(response, StatsSyncResponse.class);

      statsUpdater.updateTeams(responsePayload.getTeams());
      statsUpdater.updateGames(responsePayload.getGames());
      statsUpdater.updateStandings(responsePayload.getStandings());
    } catch (Exception e) {
      throw new DeviceApiException(e);
    }
  }

  @Override
  public void syncVersion(int currentVersion, VersionInfoHandler handler) throws DeviceApiException {
    try {
      VersionSyncRequest requestPayload = new VersionSyncRequest();
      requestPayload.setAppVersion(currentVersion);
      String message = converter.toString(requestPayload);
      Request request = new Request(serverUrl + DeviceApiEndpoints.SYNC_VERSION_URL, message);

      String response = connector.sendRequest(request);

      VersionSyncResponse responsePayload = converter.fromString(response, VersionSyncResponse.class);

      if (responsePayload.isUpdateApp()) {
        handler.updateApplication();
      }
    } catch (Exception e) {
      throw new DeviceApiException(e);
    }
  }
}
