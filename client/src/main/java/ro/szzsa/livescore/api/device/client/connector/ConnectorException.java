package ro.szzsa.livescore.api.device.client.connector;

/**
 *
 */
public class ConnectorException extends Exception {

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
