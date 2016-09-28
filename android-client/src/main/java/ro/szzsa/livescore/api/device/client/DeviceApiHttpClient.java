package ro.szzsa.livescore.api.device.client;

import ro.szzsa.utils.connector.Connector;
import ro.szzsa.utils.connector.HttpConnectorBuilder;
import ro.szzsa.utils.converter.Converters;

public class DeviceApiHttpClient extends DeviceApiHttpClientAdapter {

  public DeviceApiHttpClient(String serverUrl) {
    super(serverUrl, new HttpConnectorBuilder().build(), Converters.createJsonConverter());
  }

  public DeviceApiHttpClient(String serverUrl, Connector connector) {
    super(serverUrl, connector, Converters.createJsonConverter());
  }
}
