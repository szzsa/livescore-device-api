package ro.szzsa.livescore.api.device.client.exception;

/**
 *
 */
public class DeviceApiException extends Exception {

    public DeviceApiException() {
    }

    public DeviceApiException(String detailMessage) {
        super(detailMessage);
    }

    public DeviceApiException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DeviceApiException(Throwable throwable) {
        super(throwable);
    }
}
