package ro.szzsa.livescore.api.device.protocol.notification;

/**
 *
 */
public class Notification {

  public static final String STATS_TOPIC_NAME = "stats";

  private String to;

  private Data data;

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }
}
