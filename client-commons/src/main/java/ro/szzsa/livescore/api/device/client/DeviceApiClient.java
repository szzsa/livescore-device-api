package ro.szzsa.livescore.api.device.client;

import ro.szzsa.livescore.api.device.client.exception.DeviceApiException;
import ro.szzsa.livescore.api.device.client.handler.GameUpdater;
import ro.szzsa.livescore.api.device.client.handler.StatsUpdater;
import ro.szzsa.livescore.api.device.client.handler.VersionInfoHandler;

/**
 * Client of device API.
 */
public interface DeviceApiClient {

  void syncGame(long gameId, GameUpdater gameUpdater) throws DeviceApiException;

  void getStats(StatsUpdater statsUpdater) throws DeviceApiException;

  void syncVersion(int currentVersion, VersionInfoHandler handler) throws DeviceApiException;
}
