package ro.szzsa.livescore.api.device.protocol.notification;

import java.util.List;

import ro.szzsa.livescore.model.Standings;

import static ro.szzsa.livescore.api.device.protocol.notification.NotificationType.STANDINGS_UPDATE_NOTIFICATION;

public class StandingsUpdateNotification extends Notification {

  private List<Standings> standings;

  public StandingsUpdateNotification() {
    super(STANDINGS_UPDATE_NOTIFICATION);
  }

  public List<Standings> getStandings() {
    return standings;
  }

  public void setStandings(List<Standings> standings) {
    this.standings = standings;
  }
}
