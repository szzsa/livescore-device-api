package ro.szzsa.livescore.api.device.protocol.notification;

import java.util.List;

import ro.szzsa.livescore.api.device.model.team.Team;

import static ro.szzsa.livescore.api.device.protocol.notification.NotificationType.TEAM_UPDATE_NOTIFICATION;

public class TeamsUpdateNotification extends Notification {

    private List<Team> teams;

    public TeamsUpdateNotification() {
        super(TEAM_UPDATE_NOTIFICATION);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
