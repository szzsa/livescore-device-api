package ro.szzsa.livescore.api.device.protocol.notification;

import ro.szzsa.livescore.api.device.model.event.Penalty;

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

    @Override
    public String getCollapseKey() {
        return penalty.getGame().getHomeTeam() +
               penalty.getGame().getVisitorTeam() +
               String.valueOf(penalty.getGame().getDate());
    }
}
