package ro.szzsa.livescore.api.device.client.log;

/**
 *
 */
public interface Logger {

    void info(String message);

    void error(String message);

    void error(String message, Throwable e);

    void warn(String message);

    void warn(String message, Throwable e);

    void debug(String message);
}
