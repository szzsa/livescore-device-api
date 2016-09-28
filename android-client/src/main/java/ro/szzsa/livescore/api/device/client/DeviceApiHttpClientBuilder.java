package ro.szzsa.livescore.api.device.client;

import ro.szzsa.utils.connector.HttpConnectorBuilder;
import ro.szzsa.utils.connector.log.Logger;

/**
 *
 */
public final class DeviceApiHttpClientBuilder {

  private final String serverUrl;

  private HttpConnectorBuilder connectorBuilder;

  public DeviceApiHttpClientBuilder(String serverUrl) {
    this.serverUrl = serverUrl;
    connectorBuilder = new HttpConnectorBuilder();
  }

  public DeviceApiHttpClientBuilder setSocketTimeout(int socketTimeout) {
    connectorBuilder.setSocketTimeout(socketTimeout);
    return this;
  }

  public DeviceApiHttpClientBuilder setConnectionTimeout(int connectionTimeout) {
    connectorBuilder.setConnectionTimeout(connectionTimeout);
    return this;
  }

  public DeviceApiHttpClientBuilder setNumberOfRetries(int numberOfRetries) {
    connectorBuilder.setNumberOfRetries(numberOfRetries);
    return this;
  }

  public DeviceApiHttpClientBuilder setLogger(Logger logger) {
    connectorBuilder.setLogger(logger);
    return this;
  }

  public DeviceApiHttpClient build() {
    return new DeviceApiHttpClient(serverUrl, connectorBuilder.build());
  }
}
