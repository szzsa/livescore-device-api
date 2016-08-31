package ro.szzsa.livescore.api.device.protocol;

import ro.szzsa.livescore.api.device.protocol.request.GameDetailsRequest;
import ro.szzsa.livescore.api.device.protocol.request.VersionSyncRequest;
import ro.szzsa.livescore.api.device.protocol.response.GameDetailsResponse;
import ro.szzsa.livescore.api.device.protocol.response.StatsSyncResponse;
import ro.szzsa.livescore.api.device.protocol.response.VersionSyncResponse;

/**
 * Device REST API endpoints exposed by the server and used by devices.
 */
public final class DeviceApiEndpoints {

  public static final String DEVICE_API_ROOT_PATH = "/api/device/v1";

  public static final String GET_STATS_PATH = "/stats/get";

  public static final String SYNC_VERSION_PATH = "/version/sync";

  public static final String GET_GAME_DETAILS_PATH = "/game/sync";

  /**
   * Endpoint for stats synchronization.
   *
   * @see StatsSyncResponse
   */
  public static final String GET_STATS_URL = DEVICE_API_ROOT_PATH + GET_STATS_PATH;

  /**
   * Endpoint for version synchronization.
   *
   * @see VersionSyncRequest
   * @see VersionSyncResponse
   */
  public static final String SYNC_VERSION_URL = DEVICE_API_ROOT_PATH + SYNC_VERSION_PATH;

  /**
   * Endpoint for game details retrieval.
   *
   * @see GameDetailsRequest
   * @see GameDetailsResponse
   */
  public static final String GET_GAME_DETAILS_URL = DEVICE_API_ROOT_PATH + GET_GAME_DETAILS_PATH;

  private DeviceApiEndpoints() {
    throw new UnsupportedOperationException();
  }
}
