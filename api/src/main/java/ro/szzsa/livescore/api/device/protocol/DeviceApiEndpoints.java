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
  SYNC_STATS("/stats"),

  /**
   * Endpoint for version synchronization.
   *
   * @see VersionSyncRequest
   * @see VersionSyncResponse
   */
  SYNC_VERSION("/version"),

  /**
   * Endpoint for game details retrieval.
   *
   * @see GameDetailsRequest
   * @see GameDetailsResponse
   */
  GET_GAME_DETAILS("/game");

  private final String path;

  DeviceApiEndpoints(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }

  public String getUrl() {
    return Constants.DEVICE_API_ROOT_PATH + path;
  }

  public static class Constants {

    public static final String DEVICE_API_ROOT_PATH = "/api/device/v1";
  }
}
