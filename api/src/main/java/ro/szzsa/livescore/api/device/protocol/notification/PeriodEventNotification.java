package ro.szzsa.livescore.api.device.protocol.notification;

import ro.szzsa.livescore.model.Game;
import ro.szzsa.livescore.model.PeriodEvent;

import static ro.szzsa.livescore.api.device.protocol.notification.NotificationType.PERIOD_EVENT_NOTIFICATION;

public class PeriodEventNotification extends Notification {

  private Game game;

  private int period;

  private PeriodEvent event;

  public PeriodEventNotification() {
    super(PERIOD_EVENT_NOTIFICATION);
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public int getPeriod() {
    return period;
  }

  public void setPeriod(int period) {
    this.period = period;
  }

  public PeriodEvent getEvent() {
    return event;
  }

  public void setEvent(PeriodEvent event) {
    this.event = event;
  }

  @Override
  public String getCollapseKey() {
    return game.getHomeTeam() +
           game.getVisitorTeam() +
           String.valueOf(game.getDate());
  }
}
