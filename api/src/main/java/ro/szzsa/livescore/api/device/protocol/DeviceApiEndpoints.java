package ro.szzsa.livescore.api.device.protocol;

import ro.szzsa.livescore.api.device.protocol.request.GameDetailsRequest;
import ro.szzsa.livescore.api.device.protocol.request.VersionSyncRequest;
import ro.szzsa.livescore.api.device.protocol.response.GameDetailsResponse;
import ro.szzsa.livescore.api.device.protocol.response.StatsSyncResponse;
import ro.szzsa.livescore.api.device.protocol.response.VersionSyncResponse;

/**
 * Device REST API endpoints exposed by the server and used by devices.
 */
public enum DeviceApiEndpoints {

  /**
   * Endpoint for stats synchronization.
   *
   * @see StatsSyncResponse
   */
  SYNC_STATS(Constants.DEVICE_API_ROOT_PATH + "/stats"),

  /**
   * Endpoint for version synchronization.
   *
   * @see VersionSyncRequest
   * @see VersionSyncResponse
   */
  SYNC_VERSION(Constants.DEVICE_API_ROOT_PATH + "/version"),

  /**
   * Endpoint for game details retrieval.
   *
   * @see GameDetailsRequest
   * @see GameDetailsResponse
   */
  GET_GAME_DETAILS(Constants.DEVICE_API_ROOT_PATH + "/game");

  private final String url;

  DeviceApiEndpoints(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  private static class Constants {

    private static final String DEVICE_API_ROOT_PATH = "/api/device/v1";
  }
}
