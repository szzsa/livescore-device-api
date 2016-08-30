package ro.szzsa.livescore.api.device.client.connector;

/**
 * Factory methods for {@link Connector} instances.
 */
public final class Connectors {

    private Connectors() {
        throw new UnsupportedOperationException();
    }

    public static Connector createHttpConnector() {
        return new HttpConnector();
    }
}
