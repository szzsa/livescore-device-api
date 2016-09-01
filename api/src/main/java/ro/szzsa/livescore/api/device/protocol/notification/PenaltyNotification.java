package ro.szzsa.livescore.api.device.protocol.notification;

import ro.szzsa.livescore.model.Penalty;

import static ro.szzsa.livescore.api.device.protocol.notification.NotificationType.PENALTY_NOTIFICATION;

public class PenaltyNotification extends Notification {

  private Penalty penalty;

  public PenaltyNotification() {
    super(PENALTY_NOTIFICATION);
  }

  public Penalty getPenalty() {
    return penalty;
  }

  public void setPenalty(Penalty penalty) {
    this.penalty = penalty;
  }
}
