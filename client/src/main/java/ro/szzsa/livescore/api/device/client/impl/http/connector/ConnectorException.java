package ro.szzsa.livescore.api.device.client.impl.http.connector;

/**
 *
 */
public class ConnectorException extends RuntimeException {

    public ConnectorException() {
    }

    public ConnectorException(String detailMessage) {
        super(detailMessage);
    }

    public ConnectorException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ConnectorException(Throwable throwable) {
        super(throwable);
    }
}
