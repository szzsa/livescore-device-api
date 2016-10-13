package ro.szzsa.livescore.api.device.protocol.notification;

/**
 *
 */
public class Notification {

  public static final String STATS_TOPIC_NAME = "stats";
  public static final String MESSAGE_KEY = "message";
  private static final int DEFAULT_TIME_TO_LIVE = 300;

  private String to;

  private Data data;

  private String collapse_key;

  private int time_to_live = DEFAULT_TIME_TO_LIVE;

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

  public String getCollapse_key() {
    return collapse_key;
  }

  public void setCollapse_key(String collapse_key) {
    this.collapse_key = collapse_key;
  }

  public int getTime_to_live() {
    return time_to_live;
  }

  public void setTime_to_live(int time_to_live) {
    this.time_to_live = time_to_live;
  }
}
