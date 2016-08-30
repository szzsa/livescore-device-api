package ro.szzsa.livescore.api.device.client.impl.http.connector;

/**
 * Connects the server with the client.
 */
public interface Connector {

    String sendRequest(Request request) throws ConnectorException;
}
