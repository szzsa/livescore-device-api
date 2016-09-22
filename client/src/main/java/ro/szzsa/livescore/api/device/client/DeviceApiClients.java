package ro.szzsa.livescore.api.device.client;

/**
 * Factory methods for {@link DeviceApiClient} instances.
 */
public final class DeviceApiClients {

  private DeviceApiClients() {
    throw new UnsupportedOperationException();
  }

  public static DeviceApiClient createDefaultHttpClient(String serverUrl) {
    return new DeviceApiHttpClient(serverUrl);
  }

  public static DeviceApiHttpClientBuilder createCustomHttpClient(String serverUrl) {
    return new DeviceApiHttpClientBuilder(serverUrl);
  }
}
