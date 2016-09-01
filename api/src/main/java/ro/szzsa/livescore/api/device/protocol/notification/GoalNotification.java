package ro.szzsa.livescore.api.device.protocol.notification;

import ro.szzsa.livescore.model.Goal;

import static ro.szzsa.livescore.api.device.protocol.notification.NotificationType.GOAL_NOTIFICATION;

public class GoalNotification extends Notification {

  private Goal goal;

  public GoalNotification() {
    super(GOAL_NOTIFICATION);
  }

  public Goal getGoal() {
    return goal;
  }

  public void setGoal(Goal goal) {
    this.goal = goal;
  }
}
