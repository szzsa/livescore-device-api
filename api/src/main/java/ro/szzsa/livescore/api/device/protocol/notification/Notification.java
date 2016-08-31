package ro.szzsa.livescore.api.device.protocol.notification;

/**
 * Marker interface for notification message payload sent by the server.
 */
public abstract class Notification {

  private final NotificationType type;

  protected Notification(NotificationType type) {
    this.type = type;
  }

  public NotificationType getType() {
    return type;
  }

  public String getCollapseKey() {
    return null;
  }
}
