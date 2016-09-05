package ro.szzsa.livescore.api.device.client;

/**
 * Factory methods for {@link DeviceApiClient} instances.
 */
public final class DeviceApiClients {

  private DeviceApiClients() {
    throw new UnsupportedOperationException();
  }

  public static DeviceApiClient createHttpClient(String serverUrl) {
    return new DeviceApiHttpClient(serverUrl);
  }
}
