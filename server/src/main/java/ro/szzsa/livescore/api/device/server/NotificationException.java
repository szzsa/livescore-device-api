package ro.szzsa.livescore.api.device.server;

/**
 *
 */
public class NotificationException extends Exception {

  public NotificationException() {
  }

  public NotificationException(String detailMessage) {
    super(detailMessage);
  }

  public NotificationException(String detailMessage, Throwable throwable) {
    super(detailMessage, throwable);
  }

  public NotificationException(Throwable throwable) {
    super(throwable);
  }
}
